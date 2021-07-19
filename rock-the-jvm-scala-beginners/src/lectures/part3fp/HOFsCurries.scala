package lectures.part3fp

import scala.annotation.tailrec

object HOFsCurries extends App{


  // higher order functions like map, flatMap, and filter

  // define a function that applies a function n times over a given value
  // nTimes (f, n, x)
  // nTimes (f, 3, x) = f(f(f(x)))

  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n<=0) x
    else nTimes(f, n-1, f(x))
  }
  val f: Int => Int = _ + 1
  println(nTimes(f, 10, 10))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n<=0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(f, 10)
  println(plus10)
  // lectures.part3fp.HOFsCurries$$$Lambda$20/0x00000008000c5040@612679d6
  println(plus10(10)) // 20

  // curried functions
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y -> 3 + y
  println(add3)
  // lectures.part3fp.HOFsCurries$$$Lambda$23/0x00000008000c2840@491cc5c9
  println(add3(10)) // 13
  println(superAdder(3)(10))

  // currying: functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: Double =>String = curriedFormatter("%4.2f")
  val preciseFormat: Double =>String = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))














}

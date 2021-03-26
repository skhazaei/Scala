/** Currying functions:
 *  currying is simply a technique or a process of
 *  transforming a function that takes
 *  multiple arguments into a sequence of functions
 *  that each take a single argument
 *
 */

object Currying {
  def main(args: Array[String]) = {

  println(add(3, 4))  // returns 7
  println(add2(3)(4))  // returns 7
  println(add2(3))  // returns  Currying$$$Lambda$17/0x00000008000d7840@1a1d6a08

  // another way of using Curried function is partially applied function.
  val sum = add2(3)(_:Int)
  println(sum(4))

  }

  // let's define a method add to sum x and y
  def add(x: Int, y: Int) = x + y

  // now let's transform add to a function that
  // takes one single argument
  def add2(x: Int): Int => Int = (y: Int) => x +y
  // add2 takes only one argument x and we are going to
  // return a second function which will have the value of add2.
  // The second function will take an argument, let say y and this
  // function when called in main, takes two parenthesis:
  // add2()()











}

package lectures.part3fp

object AnonymousFunctions extends App{

  val doubler = new Function1[Int, Int] {
    override def apply(x: Int): Int = 2*x
  }
  println(doubler(3))

  // anonymous function (Lambda)
  val doublerAnonymous = (x: Int) => 2*x
  println(doublerAnonymous(3))

  val doublerAnonymous2: Int => Int = (x: Int) => 2*x
  println(doublerAnonymous2(3))

  val doublerAnonymous3: Int => Int = x => 2*x
  println(doublerAnonymous3(3))

  // multiple parameters in Lambda
  val adder = (a: Int, b: Int) => a + b
  val adder2: (Int, Int) => Int = (a: Int, b: Int) => a + b
  val adder3: (Int, Int) => Int = (a, b) => a + b

  println(adder3(2,3))

  // no params
  val justDoSomething = () => 3
  val justDoSomething2: () => Int = () => 3

  println(justDoSomething)
  // returns lectures.part2oop.AnonymousFunctions$$$Lambda$25/0x00000008000c2c40@4671e53b
  // which is function itself
  println(justDoSomething()) // returns 3 // actual call of function

  // curly braces with lambda
  val stringToInt = { (string: String) =>
    string.toInt}

  // more syntactic sugar
  val incrementer: Int => Int = x => x+1
  println(incrementer(100))

  // _ + 1 is equivalent to x => x + 1
  val niceIncrementer: Int => Int = _ + 1

  val addTwoNumbers: (Int, Int) => Int = (a, b) => a+b
  val nicerAddTwoNumbers: (Int, Int) => Int = _ + _

  // define a function that takes an Int and returns
  // another function which takes an Int and returns an Int

  val f = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int) = new Function1[Int, Int]{
      override def apply(y: Int) = x + y
    }
  }
  val fx = f(3)
  val fxy = fx(4)
  println(fx) // returns <function1>
  println(fxy)

  // lets rewrite the f function as anonymous function
  val g = (x: Int) => (y: Int) => x+ y
  // type of g: Int => Int => Int
  val gx = g(3)
  val gxy = gx(4)
  println(gx)
  // returns lectures.part3fp.AnonymousFunctions$$$Lambda$33/0x0000000800104040@43bd930a
  println(gxy)






}

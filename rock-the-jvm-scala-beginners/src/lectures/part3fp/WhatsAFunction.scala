package lectures.part3fp

object WhatsAFunction extends App {

  // Dream: work with functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element* 2
  }
  println(doubler(2))

  // Function Types = Function1[A, B]
  val stringToInt = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToInt("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  println(adder(2,3))

  val adder2: (Int, Int) => Int  = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  println(adder2(4,5))

  // All scala functions are objects or the instances of Function type

  // define a function which takes two strings and concatenates them:
  val stringConcatenates: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String) : String = a + b
  }
  println(stringConcatenates("hi, ", "how are you"))

  // define a function that takes an Int and returns
  // another function which takes an Int and returns an Int
  // what is the type of this function?

  // Function1[Int, Function1[Int, Int]]

  val fx = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function1[Int, Int]{
      override def apply(y: Int): Int = 5*x + 2*y
    }
  }

  println(fx(2)(3)) // returns 16 // this called curried function
  // curried function receive a parameter and it returns a function


  val multi5 = fx(10)
  println(multi5) // returns <function1>
  println(multi5(20)) // returns 90



}


trait MyFunction[A, B]{
  def apply(element: A): B
}

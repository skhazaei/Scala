object currying
{

  /** Currying
   * Currying in Scala is simply a technique or a process
   * of transforming a function. This function takes multiple
   * arguments into a function that takes single argument.
   * It is applied widely in multiple functional languages
   *
   *  */

  /** In the last lecture we learned to use anonymous functions
   * to short the code:

   * Question is that can we be even shorter by getting rid
   * of a and b parameters?
   * * *  */

    // we define a sum that it takes only one single parameter f
    // of type Int => Int and it returns a function as result: (Int, Int) => Int
    // sum(f: Int => Int): (Int, Int) => Int = { a function in the body}
    // the returned function sumF applies the given function parameter f
    // and sums the result.
    //
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a>b) 0
      else f(a) + sumF(a+1, b)
    sumF
    }
    // so let's define sumInts and other functions
  def sumInts = sum(x => x)

  def sumCubes = sum(x => x*x*x)

  // could we even make the code shorter and avoid using
  // sumInts and sumCubes?
  // yes, by: sum(cube)(a, b)

  // Let's rewrite the above function sum even shorter:
  def sum_shorter(f: Int => Int)(a: Int, b: Int): Int =
    if (a>b) 0 else f(a) + sum_shorter(f)(a+1, b)

  // EXAMPLE 2:
  // Let's define a add function that adds up two integers
  // the function add takes two arguments
  def add(x: Int, y: Int): Int = x + y
  // Now let's now transform add function that takes two argument
  // to a function that takes only one
  def add2(x: Int)=(y: Int) => x + y
  // this is equivalent to:
  def add3(x: Int): Int => Int=(y: Int) => x + y
  // this is equivalent to the following which
  // is the default syntax for curried function
  def add4(x: Int)(y: Int): Int= x + y

  // The interesting point about currying is that:
  // one can apply partial application on curried function
  // Let's declare a variable:
  val add_2 = add2(4)
  // Here we just passed one parameter to the add2 function
  // println(add_1arg) returns: currying$$$Lambda$15/0x0000000800090040@4abdb505
  // we can call add_1arg function with passing another parameter like:
  // println(add_2(2))
  // this returns 6 because (4 + 2)

  // Let's now try partial application with add4
  // val add_4 = add4(4)
  // and try this: println(add_4(2))
  // this returns an error and it asks to provide
  // the second argument, how to solve? try this:
  // let's redefine add_4 again with _ at the end
  val add_4 = add4(4)_
  // _ tells that we provide the second argument later



  def main(args: Array[String]): Unit={

    println(sumInts(1,2))
    println(sum(x => x*x*x)(1, 2))
    println(sum_shorter(x => x*x*x)(1,2))

    //Example 2
    println(add(2,3))
    println(add2(2)(3))
    println(add3(2)(3))
    println(add4(2)(3))
    println(add_2)
    println(add_2(2))
    //println(add_4(2)) // returns error with val add_4 = add4(4)
    println(add_4(2))

  }
}

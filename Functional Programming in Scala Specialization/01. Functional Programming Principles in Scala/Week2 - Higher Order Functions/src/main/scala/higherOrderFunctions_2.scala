import scala.annotation.tailrec

object higherOrderFunctions_2 {
  def main(args: Array[String]) = {}

  /**
   *  def sumInts(a: Int, b: Int): Int =
   *  if (a>b) 0 else a + sumInts(a+1, b)
   *
   *  def cube(n: Int): Int = n*n*n
   *  def sumCubes(a: Int, b: Int): Int =
   *  if (a>b) 0 else cube(a) + sumCubes(a+1, b)
   *
   *  def fact(n: Int): Int={
   *  @tailrec
   *  def loop(acc: Int, n: Int): Int=
   *  if (n==1) acc else loop(acc*n, n-1)
   *  loop(1, n)
   *  }
   *  def sumFacts(a: Int, b: Int): Int =
   *  if (a>b) 0 else fact(a) + sumFacts(a+1, b)
   *
   * */


  /** Question: can we factor out the common pattern
   * from the previous code lessons?
   * */

  // Let's define
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)

  // as it can be seen, f is the parameter of some function

  def sumInts(a: Int, b: Int): Int = sum(id, a, b)

  def id(x: Int): Int = x

  //test code
  var output = sumInts(1, 3)
  println(s" sumInts = $output")

  def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)

  def cube(x: Int): Int = x * x * x

  //test code
  output = sumCubes(1, 3)
  println(s" sumCubes = $output")


  def sumFactorials(a: Int, b: Int): Int = sum(fact, a, b)
  def fact(n: Int): Int =
  {
    @tailrec
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc else loop(acc * n, n - 1)
    loop(1, n)
  }
  //test code
  output = sumFactorials(1, 3)
  println(s" sumFactorials = $output")

  /** So what we've done, effectively, is reuse the pattern
   *  that defines the sum function, so that we had to write
   *  that only once.
   *  And we could reuse it in the three definitions of the
   *  particular sums.
   *
   *  One thing that's new here is a function type.
   *  ///  Function type:
   *  The type A => B is the type of a function that takes
   *  an argument of type A and returns a result of type B.

   *  So for example Int => Int, is a type of functions
   *  that map integers to integers.
   *
   * Similarly, (A1, A2) => B is the type of functions
   * that take two arguments (of types A1 and A2, respectively)
   * and return a result of type B.
   *
   * More generally, (A1, ..., An) => B is the type of functions
   * that take n arguments (of types A1 to An) and return a result of type B.
   *
   *  */


}


object higherOrderFunctions_3
{
  def main(args: Array[String]) = {}

  /** in previous lesson, we see that Passing functions
   *  as parameters leads to the creation of many small functions.
   *  And Sometimes it is tedious to have to define (and name)
   *  these functions using def.
   */

  /** Anonymous Function:
   *  Anonymous functions are those without giving it a name.
   *
   *  Anonymous Function Syntax:
   *  see the examples ..
   *  */

  // Example: a function that raises its argument to a cube
  (x: Int) => x * x * x
  // here (x: Int) is the parameter of the function
  // and x * x * x is the body of the function

  // if there are several parameters, they can be separated by comma
  (x: Int, y: Int) => x + y

  /** Anonymous Functions are Syntactic Sugar
   *
   */


  /** Summation with Anonymous Functions
   *
   */

  def sum(f: Int => Int, a: Int, b: Int): Int=
    if (a>b) 0 else f(a) + sum(f, a+1, b)

  def sumOfInts(a: Int, b: Int): Int = sum(x => x, a, b)
  var output = sumOfInts(1, 3)
  println(s" sum of integers= $output")


  def sumOfCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)
  output = sumOfCubes(1,3)
  println(s" sum of cubes= $output")

  def sum_short_version(f: Int => Int, a: Int, b: Int): Int =
    {
      def loop(a: Int, acc: Int): Int =
        {
          if (a>b) acc
          else loop(a+1, f(a) + acc)
        }
      loop(a, 0)
    }

  output = sum_short_version(x => x, 1, 3)
  println(s" sum (short version) of integers= $output")

  output = sum_short_version(x => x * x * x, 1, 3)
  println(s" sum (short version) of cubes= $output")




















}

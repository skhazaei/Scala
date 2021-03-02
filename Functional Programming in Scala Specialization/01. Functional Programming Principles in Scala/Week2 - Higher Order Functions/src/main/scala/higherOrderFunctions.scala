object higherOrderFunctions {

  def main(args: Array[String]) ={}

/** higher order functions:
 *
 *  -- Functions that take other functions as parameters
 *  or that return functions as results are called higher order functions.
 *
 *  -- Functional languages treat functions as first-class values.
 *
 *  -- This means that, like any other value, a function can be
 *  passed as a parameter and returned as a result.
 **/

  // Write a function that takes the sum of
  // all integers between a and b
  def sumInts(a: Int, b: Int): Int =
    if (a>b) 0 else a + sumInts(a+1, b)
  // test code
  var output = sumInts(1,3)
  println(s" sum = $output")


  // Write a function that takes the sum of
  // the cubes of all integers between a and b
  def cube(n: Int): Int = n*n*n

  def sumCubes(a: Int, b: Int): Int =
    if (a>b) 0 else cube(a) + sumCubes(a+1, b)
  //test code
  output = sumCubes(1,2)
  println(s" sum of cubes= $output")



}

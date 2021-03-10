import Operations._

/** Functions vs. Methods
 *
 * Function: 1- is an expression and defined by "val" keyword
 *           2- Functions can be used to pass behaviour across the application
 *           3- All the parameters in Functions are mandatory
 *
 * Method:   1- is not a value type and is defined by "def" keyword
 *           2- can not be passed as parameters
 * */
object Functions {
  def main(args: Array[String]) = {

    var result = calculator(3, 2, add)
    println("add = " + result)
    result = calculator(3, 2, sub)
    println("sub= "+ result)
    result = calculator(3, 2, multiply)
    println("multiply= " + result)

  }
  def calculator(a: Int, b: Int, operations: (Int, Int) => Int) =
    operations(a, b)
}

object Operations{
  val add = (a: Int, b: Int) => a + b
  val sub = (a: Int, b: Int) => a - b
  val multiply = (a: Int, b: Int) => a * b
}

object PartiallyAppliedFunction {

  /** What we learn?
   * --- partially applied function:
   *     - once all arguments are not available to the function
   *     - a new partial function is then created
   *
   *  */

  def main(args:Array[String]) = {
    println(billCalculator(1, 2, 3))
    println(partialBillCalculator(30))
    sampleList.foreach(println _)
  }

  // let's define a method that takes three arguments: a, b, and c
  def billCalculator(a: Int, b: Int, c: Int): Int =
    a + b + c

  // let's assume that a and b in billCalculator could be fixed values
  // then we can define a val function that takes only one argument
   val partialBillCalculator = billCalculator(10, 20, _:Int)

  val sampleList = List("a", "b", "c")

}


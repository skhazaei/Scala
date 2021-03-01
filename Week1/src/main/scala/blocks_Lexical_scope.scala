object blocks_Lexical_scope
{
  def main(args: Array[String]) ={}

  /** --- A block is delimited by braces and it contains as number
   *  of definitions.
   *
   *  --- The last element an expression defines the return value
   *  of the result of that block.
   *  */

  /** --- the definitions inside a block are only visible from
   *  within the block, not from the outside.  */

  /** --- the definitions from outside the block are visible in
   *  the block as long as they are not shadowed by definitions
   *  of the same names inside the block. */


  // Question: what is the value of result in this code?
  def f(y: Double) = y + 1
  val x = 10
  val result =
  {
    val x = f(3)
    x*x
  } + x
  println(result)
  // result = (4*4) + 10 = 26

  /** Lexical Scope
   * definitions of the outer blocks are visible inside a block
   * unless they are shadowed.
   *
   * --- We can use that to simplify square root by eliminating
   * redundant occurrences of the x parameter, which means,
   * everywhere, the same thing.
   *  */
  def sqrt(x: Double) = {
    /** calculates square root of parameter x using Newtons method
     * start with an initial value, let's pick y=1, and find sqrt(2)
     * Estimation   Quotient  Mean
     * y=1          x / y = 2         (1+2)/2=1.5
     * y=1.5        2 / 1.5 =1.33     (1.5 + 1.33)/2= 1.415
     * and so on
     * */
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess: Double)) guess
      else sqrtIter(improve(guess))

    def abs(x: Double) = if (x < 0) -x else x

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  var output=sqrt(16)
  println(s" sqrt(16) = $output")
  output=sqrt(4)
  println(s" sqrt(4) = $output")

  output=sqrt(1e-6)
  println(s" sqrt(1e-6) = $output")

  output=sqrt(1e+60)
  println(s" sqrt(1e+60) = $output")

  /** Semicolons:
   *  in Scala semicolons at the end of sentences
   *  are in most cases optional
   *  */

  /** How to write multi-line expressions? two ways:
   * 1- use the parentheses:
   *    (SomeLongExpression
   *     + someLongExpression)
   *
   * 2- write the operator at the end of first line
   *   SomeLongExpression +
   *   SomeLongExpression
   *
   * */


}

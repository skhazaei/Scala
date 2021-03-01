object block_sqrt
{
  def main(args: Array[String]) ={}

  /** Normally, we would not like users to access the functions
   * like isGoodEnough and etc directly, so we want to avoid
   * name space pollution where they would see these names
   * even though they're not suppose to be called directly
   * by them. One way we can achieve that is to put these
   * auxiliary functions inside the function square root.
   * */

  def sqrt(x: Double) = {
    /** calculates square root of parameter x using Newtons method
     * start with an initial value, let's pick y=1, and find sqrt(2)
     * Estimation   Quotient  Mean
     * y=1          x / y = 2         (1+2)/2=1.5
     * y=1.5        2 / 1.5 =1.33     (1.5 + 1.33)/2= 1.415
     * and so on
     * */
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess: Double, x: Double)) guess
      else sqrtIter(improve(guess, x: Double), x)

    def abs(x: Double) = if (x < 0) -x else x

    def isGoodEnough(guess: Double, x: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0, x: Double)
  }

  var output=sqrt(16)
  println(s" sqrt(16) = $output")
  output=sqrt(4)
  println(s" sqrt(4) = $output")

  output=sqrt(1e-6)
  println(s" sqrt(1e-6) = $output")

  output=sqrt(1e+60)
  println(s" sqrt(1e+60) = $output")




}

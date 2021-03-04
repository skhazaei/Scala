object preconditions{
  def main(args: Array[String]) = {

    val x = new Rational5(1, 3)
    val y = new Rational5(5, 7)
    val z = new Rational5(3, 2)
    println(x.add(y))
    println(x.neg)
    println(x.sub(y).sub(z))
    println(y.add(y))
    println(x.less(y))
    println(x.max(y))
    /** preconditions:
     *  let's say our Rational class requires that denominator to be nonzero.
     *  We can enforce this by calling function require
     *  */
    // val strange = new Rational5(1, 0)
    // println(strange.add(strange))
    // This returns the error:
    // Exception in thread "main" java.lang.ArithmeticException: / by zero
    // what we can do is to add a requirement to our class
    // After adding require to the class, the error message changes to:
    // Exception in thread "main" java.lang.IllegalArgumentException:
    // requirement failed: denominator must be nonzero
    // Note that "require" function we used in the class, is a predefined function
    // which takes a condition and a string as an optional message
    /** Another option is using "assert"
     * assert takes a condition and an optional message string
     * Example:
     * val x = sqrt(y)
     * assert (x>=0)
     * this also thrown an error message "AssertionError for assert"
     * which is different from require error message "IllegalArgumentException"
     *
     * difference between assert and require:
     * require is used to enforce a precondition on the caller of a function
     * while assert is used to check the code of the function itself
     *
     */

    /** Primary Constructors of the class:
     * primary constructor of the class Rational is x, and y
     * That primary constructor simply takes the parameters of the
     * and executes all statements in the class body. So, for instance,
     * the constructor of class rational would take the x and y as the
     * parameter, and then execute the class body.
     *
     *
     * Second constructor of the class:
     * So, let's say we want to have a second constructor for
     * class Rational that only takes one integer: denominator.
     * we can write:
     * def this(x: Int) = this(x, 1)
     *
     *  */
    val den = new Rational5(2)
    println(den)
    // this returns 2/1


  }
}

class Rational5(x: Int, y: Int){
  def this(x: Int) = this(x, 1)
  require(y != 0, "denominator must be nonzero")
  private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b, a%b)
  // one way of calling gcd is defining: val g = gcd(x, y)
  // and then def numer = x / g
  //          def denom = y / g
  // But a better way is to call gcd in the code of numer and denom as follows:
  // This could be an advantage when numer and denom are called not very frequent.
  def numer = x / gcd(x, y)
  def denom = y / gcd(x, y)
  // the other equal possibility is that to turn numer and denom to "val"
  // This could be an advantage when numer and denom are called often
  // val numer = x /gcd(x, y)
  // val denom = y / gcd(x, y)

  /** The important thing is that no matter which method you choose,
   * the result would be the same at each case,
   * The ability of choosing different implementations of data without
   * effecting clients is called "*** Data Abstraction ***"
   *  */

  // implement less method
  def less(that: Rational5)= that.denom*numer < that.numer*denom

  // implement max method
  def max(that: Rational5) = if (this.less(that)) that else this
  /** self reference:
   * on the inside of a class, the name "this" represents the object
   * on which the method is executed
   *
   * **** another important point:
   * Note that x which simply refer to the other member in the class
   * is an abbreviation of "this.x" thus an equivalent way to formulate
   * less is:
   *
   * def less(that: Rational5) = that.denom * this. numer < that.numer * this.denom
   *
   * */






  // implement add method
  def add(that: Rational5) =
    new Rational5 (that.numer * denom + numer * that.denom ,
      that.denom * denom)

  override def toString = numer + "/" + denom

  // implement a method named neg to do so
  // x.neg returns -x
  def neg: Rational5 = new Rational5(-numer, denom)

  // implement subtract method
  def sub(that: Rational5) = add(that.neg)

}

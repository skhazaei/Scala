object funRationals{
  def main(args: Array[String]) = {

    val x = new Rational4(1, 3)
    val y = new Rational4(5, 7)
    val z = new Rational4(3, 2)
    println(x.add(y))
    println(x.neg)
    println(x.sub(y).sub(z))
    println(y.add(y))
    println(x.less(y))
    println(x.max(y))
  }
}

class Rational4(x: Int, y: Int){
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
  def less(that: Rational4)= that.denom*numer < that.numer*denom

  // implement max method
  def max(that: Rational4) = if (this.less(that)) that else this
  /** self reference:
   * on the inside of a class, the name "this" represents the object
   * on which the method is executed
   *
   * **** another important point:
   * Note that x which simply refer to the other member in the class
   * is an abbreviation of "this.x" thus an equivalent way to formulate
   * less is:
   *
   * def less(that: Rational4) = that.denom * this. numer < that.numer * this.denom
   *
   * */






  // implement add method
  def add(that: Rational4) =
    new Rational4 (that.numer * denom + numer * that.denom ,
      that.denom * denom)

  override def toString = numer + "/" + denom

  // implement a method named neg to do so
  // x.neg returns -x
  def neg: Rational4 = new Rational4(-numer, denom)

  // implement subtract method
  def sub(that: Rational4) = add(that.neg)

}

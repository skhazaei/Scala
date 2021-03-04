object classes_3{
  def main(args: Array[String]) = {

    val x = new Rational3(1, 3)
    val y = new Rational3(5, 7)
    val z = new Rational3(3, 2)
    println(x.add(y))
    println(x.neg)
    println(x.sub(y).sub(z))
  }
}

class Rational3(x: Int, y: Int){
  def numer = x
  def denom = y

  // implement add method
  def add(that: Rational3) =
    new Rational3 (that.numer * denom + numer * that.denom ,
      that.denom * denom)

  override def toString = numer + "/" + denom

  // implement a method named neg to do so
  // x.neg returns -x
  def neg: Rational3 = new Rational3(-numer, denom)

  // implement subtract method
  def sub(that: Rational3) = add(that.neg)

}

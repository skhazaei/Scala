object classes_2{
  def main(args: Array[String]) = {

    val x = new Rational2(1, 2)
    val y = new Rational2(2, 3)
    println(x.add(y))
  }
}

class Rational2(x: Int, y: Int){
  def numer = x
  def denom = y

  // implement add method
  def add(that: Rational2) =
    new Rational2 (that.numer * denom + numer * that.denom ,
      that.denom * denom)

  override def toString = numer + "/" + denom

}

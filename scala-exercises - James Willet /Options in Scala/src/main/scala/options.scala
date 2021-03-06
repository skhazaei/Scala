object options {
  def main(args:Array[String]) = {

    def fraction(numer: Double, denom: Double): Option[Double] =
      if (denom==0) None else Some(numer/denom)

    def  fr_nonsafe(numer: Double, denom: Double): Double =
      numer/denom

    println(fraction(8,2))
    println(fraction(8,2).get)
    println(fraction(8,0).get)
    println(fr_nonsafe(numer=8, denom=2))

  }

}
case class Person(name: String, email: Option[String])

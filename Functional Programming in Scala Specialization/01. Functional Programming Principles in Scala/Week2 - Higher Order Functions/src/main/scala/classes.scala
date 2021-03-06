object classes {
  def main(args: Array[String]) = {

    val num= new Rational(1,2)
    // println(num.x) returns error, why?
    println(num.numer)
    println(num.denom)

  }
}

class Rational(x: Int, y: Int){
  // class Rational has two arguments: x and y
  // we can not access x and y directly
  // but with two methods: numer and denom
  def numer = x
  def denom = y

  // This definition introduced two entities:
  // 1- A new type named Rational.
  // 2- A constructor of Rational to create new elements of this type.

  // **** Question **** what are objects?
  // Objects are the elements of a class type.

  // **** Question **** how create objects?
  // we create an object by prefixing an application of the constructor
  // of the class with the operator new
  // Example:
  // val num = new Rational(1, 2)

  // num is now an object of class Rational

  // What are the members of the class Rational?
  // numer and denom are two members of the class.

  // How select the members of the class?
  // like java and other languages, we can
  // select the members of an object with an
  // infix operator "."
  // num.numer or num.denom
}

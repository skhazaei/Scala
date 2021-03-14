object Options {
  def main(args:Array[String]): Unit ={

    /** What we learn:
     * Option[A] returns either None if it has no value of type A, or Some(value) of type A
     * get method returns the value of Some(value)
     * isDefined returns true or false
     * is Empty returns true or false
     * getOrElse returns either the value if exists else a given message
     * match pattern {cas x =>}
     */


    println("\nfraction1 implementation")
    println(fraction1(1,2))
    println(fraction1(1,0))

    println("\nfraction2 implementation")
    println(fraction2(1, 2))
    println(fraction2(1, 0))

    println("\nfraction2 implementation; use get method")
    println(fraction2(1, 2).get)
    // println(fraction2(1, 0).get)
    // this line returns "NoSuchElementException" error

    println("\nfraction2 implementation, use isEmpty")
    println(fraction2(1, 2).isEmpty)
    println(fraction2(1, 0).isEmpty)

    println("\nfraction2 implementation, use isDefined")
    println(fraction2(1, 2).isDefined)
    println(fraction2(1, 0).isDefined)

    println("\nfraction2 implementation, combine get and isDefined")
    println(if (fraction2(1, 2).isDefined) fraction2(1,2).get else "Denominator must be nonzero")
    println(if (fraction2(1, 0).isDefined) fraction2(1,2).get else "Denominator must be nonzero")

    println("\nfraction2 implementation, getOrElse method")
    println(fraction2(1, 2) getOrElse "Denominator must be nonzero")
    println(fraction2(1, 0) getOrElse "Denominator must be nonzero")

    println("\nfraction2 implementation, use pattern match")
    println(fraction2(1, 2) match{
      case Some(value) => value
      case None => "Denominator must be nonzero"})
    println(fraction2(1, 0) match{
      case Some(value) => value
      case None => "Denominator must be nonzero"})
  }

  // Write a function takes numer and denom
  // and returns the fraction
  def fraction1(numer: Double, denom: Double): Double=
    numer/denom

  // Question: what is the output of "println(fraction1(1,0))" ?
  // Answer: Infinity

  // So let's rewrite the fraction function and use the Option[A] container:
  // Option[A]: is a container for the value of type A.
  // if a value of type A is present, the Option[A] is an instance of Some[A]
  // if the value of type A is absent, the Option[A] is the object None
  def fraction2(numer: Double, denom: Double): Option[Double] =
    if (denom==0) None else Some(numer/denom)
  // The output is now "Some(0.5)" and "None "

  // Let's fetch out the value out from Option container using get method
  // try then :: fraction2(1, 2).get returns 0.5
  //             fraction2(1, 0).get returns "NoSuchElementException" error


  // Question: How handle this to make sure that get applies once the return value is not "None"
  // Answer: We can use two helper methods: isEmpty and isDefined
  // Let's try:: fraction2(1, 2).isEmpty
  //             fraction2(1, 0).isDefined
  // isEmpty and isDefined returns true and false
  // We can combine these methods with get:
  // if (fraction2(1, 2).isDefined) fraction2(1,2).get else "Denominator must be nonzero"

  // Above implementation works fine but looks not very elegant
  // Let's use another method on option "getOrElse":
  // fraction2(1, 2) getOrElse "Denominator must be nonzero"
  // if fraction2(1, 2) has a value then its value prints out, otherwise the given error message

  // Another way to handle such situations is using pattern match:
  /**
    fraction2(1, 2) match {
    case Some(value) => value
    case None => "Denominator must be nonzero"
  }
   */
}

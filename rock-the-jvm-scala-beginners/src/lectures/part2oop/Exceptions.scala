package lectures.part2oop

import javax.management.RuntimeErrorException

object Exceptions extends App{

  val x: String = null
  //println(x.length)
  // this ^^ will crash with NullPointerException
  // returns "Exception in thread "main" java.lang.NullPointerException"

  // 1. throw exception
  //val aWeiredValue: String = throw new NullPointerException
  // This ^^ throw an exception and since there is nobody to catch it, it crashes the program
  // returns "Exception in thread "main" java.lang.NullPointerException"

  // Exception and error are the major throwable subtypes
  // 2. catch the exception

  def getIn(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("No int for you")
    else 100
  }
  println(getIn(false)) // returns 32
  //println(getIn(true))
  // this ^^ throw a RuntimeException error
  //returns "Exception in thread "main" java.lang.RuntimeException"

  // So lets catch the exception
  val potentialFail = try{
    // potentialFail type is: AnyVal
    // getIn function returns Int, but the case returns Unit and when the compiler
    // wants to unify Int and Unit together, it gets AnyVal
    getIn(true)
  } catch{
    case e: RuntimeException => println("caught the Runtime error")
    //case e: NullPointerException => println("caught NullPointerException")
      // This ^^ does not match with the error in def function, therefore
      // the program crashes and returns :
      // Exception in thread "main" java.lang.RuntimeException: No int for you
  } finally{
    // code will execute no matter what
    // finally is optional
    // does not influence the return type of this expression
    // use finally for side effects
    println("finally")
  }
  println("Hello World")
  // when we added try expression and caught the potential error, the rest of code could be run

  // 3- How to define your own exception?

  class MyException extends Exception
  val exception = new MyException

  //throw exception
  // this crashes code with message "Exception in thread "main" lectures.part2oop.Exceptions$MyException"


  /**
   * 1- crash your program with out of memory error
   * 2- crash your program with stack overflow error
   * 3- class PocketCalculator
   *   - add(x,y)
   *   - subtract(x,y)
   *   - multiply(x,y)
   *   - divide(x,y)
   *
   *   Throw:
   *        - overflowException error if add(x,y) exceeds Int.MaxValue
   *        - underflowException error if subtract(x,y) exceeds Int.MinValue
   *        - MathCalculationException error for division by zero
   *
   */

  // 1-
  // val largeArray: Array[Int] = Array.ofDim(Int.MaxValue)
  // this ^^ returns "Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit"

  //2-
  def infinite: Int = infinite + 1
  //val noLimit = infinite
  // this ^^ returns "Exception in thread "main" java.lang.StackOverflowError"

  // 3-
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by Zero")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x>0 && y>0 && result<0) throw new OverflowException
      else if (x<0 && y<0 && result>0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y:Int): Int = {
      val result = x - y
      if (x>0 && y<0 && result<0) throw new OverflowException
      else if (x<0 && y>0 && result>0) throw new UnderflowException
      else result
    }

    def multiple(x: Int, y:Int): Int ={
      val result = x * y
      if (x>0 && y>0 && result<0) throw new OverflowException
      else if (x<0 && y<0 && result<0) throw new OverflowException
      else if (x>0 && y<0 && result>0) throw new UnderflowException
      else if (x<0 && y>0 && result>0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y==0) throw new MathCalculationException
      else x/y
    }
  }

  //println(PocketCalculator.add(Int.MaxValue, 10))
  //println(PocketCalculator.add(4, 10))
  //println(PocketCalculator.divide(10, 0))
  // This ^^ returns:
  //"Exception in thread "main" lectures.part2oop.Exceptions$MathCalculationException: Division by Zero"
  
}

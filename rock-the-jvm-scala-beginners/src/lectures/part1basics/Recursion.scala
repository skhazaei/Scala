package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  /**
  def factorial(n: Int): Int =
    if (n==1) return 1
    else n * factorial(n-1)
  println(factorial(5))
   */

  // each call of recursion function uses what we call stack frame
  // let's add some extra line to the above code to see what is happening
  def factorial(n: Int): Int ={
    if (n==1) return 1
    else {
      println("computing factorial of "+ n  + " - first need the factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("computed factorial of "+ n)
      result
    }
  }
  println(factorial(3))
  // So this is the entire stack frame that the JVM needs to compute our factorial of 3:
  // computing factorial of 3 - first need the factorial of 2
  // computing factorial of 2 - first need the factorial of 1

  // And then after it figures out the base case the call stack is
  // then freed with the intermediate results.

  // but this code crashes to compute the factorial of large numbers
  // and it gives "StackOverflowError"
  // println(factorial(5000)) // Exception in thread "main" java.lang.StackOverflowError

  def anotherFactorial(n: Int): BigInt ={
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x==1) accumulator
      else factHelper(x-1, x * accumulator)
    }
    factHelper(n, 1)
  }

  println(anotherFactorial(4))
  /*
   anotherFactorial(4)
      factHelper(4, 1)
              factHelper(3, 4*1)
              factHelper(2, 3*4*1)
              factHelper(1, 2*3*4*1)
   */
  println(anotherFactorial(5000)) // the result is a very big int number
  // therefore int in the code is changed to BigInt to see the result in console

  /**
   * factorial function was not a recursive function, because
   * factorial recursive call does not occur as last expression
   *
   * anotherFactorial is a tail recursive function
   * the key is "use the recursive call as last expression"
   *
   * This allow scala to preserve the same stack frame and
   * not to use an additional stack frame for each recursive calls.
   * In previous implementation, scala needed a new stack fame for
   * each call.
   * therefore when we need loops, use tail recursion
   *
   *
   */

  def repeatedFunction(n: Int, aString: String): String =
    if (n==1) aString
    else aString + "," + repeatedFunction(n-1, aString)
  println(repeatedFunction(5, "Hello"))

  // write the above function in as a tail recursion one
  @tailrec
  def concatenateTailrec(n: Int, aString: String, accumulator: String=""): String ={
    if (n==0) accumulator
    else concatenateTailrec(n-1, aString, aString + accumulator)
  }
  println(concatenateTailrec(5, "Hello"))


  def isPrime(n: Int): Boolean ={
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
    if (t <= 1) true
    else n % t != 0 && isPrimeUntil(t-1)
  }
    isPrimeUntil( n / 2)
  }
  println(isPrime(2003))
  println(isPrime(7))
  println(isPrime(23*17))

  def isPrime2(n: Int): Boolean = {
    @tailrec
    def untilPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t<=1) true
      else untilPrimeTailrec(t-1, n%t!=0 && isStillPrime)
    untilPrimeTailrec(n/2, true)
  }
  println(isPrime2(2003))
  println(isPrime2(7))
  println(isPrime2(23*17))

  // 1 1 2 3 5 8 13 21
  def fibonacci(n: Int): Int =
    if (n<=2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  println(fibonacci(8))

  // 1 1 2 3 5 8 13 21
  // write fibonacci tail recursive
  def fibonacci2(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTailrec(i + 1,last+nextToLast, last )
    if (n<=2) 1
    else fibonacciTailrec(2, 1, 1)
  }
  println(fibonacci2(8))

}

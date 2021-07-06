package lectures.part1basics

object Functions extends App {


  def aFunction(a: String, b: Int): String =
    a + ' ' + b

  println(aFunction("Hello", 2))

  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())
  println(aParameterLessFunction)

  // When need loops, write recursion functions
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("Hello", 2))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  aFunctionWithSideEffects("Nothing")



  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b
    aSmallFunction(n, n-1)
  }
  println(aBigFunction(10))

  def greetings(name: String, age: Int): String =
    s"Hi there, this is $name, $age years old!"
  println(greetings("Mary", 12))

  def factorial(n: Int): Int =
    if (n==1) n
    else n*factorial(n-1)
  println(factorial(5))



  // 1 1 2 3 5 8 13 21
  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  println(fibonacci(3))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t<=1) true
      else (n%t != 0) && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(2003))
  println(isPrime(7))
  println(isPrime(23*17))

}

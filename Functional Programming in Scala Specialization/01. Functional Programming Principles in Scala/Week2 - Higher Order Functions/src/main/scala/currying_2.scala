object currying_2
{
  // Question: given the following function:
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a>b) 0 else f(a) + sum(f)(a+1, b)
  // what is the type of sum?
  // sum is a function that takes a function f
  // as the argument:
  // (Int => Int) which is the argument type
  // and that returns a function that takes two
  // argument a and b which are both Int and finally
  // this returns an Int:
  // (Int => Int) => (Int => Int) => Int
  // Note that functional type associate to the right: this says
  // Int => Int => Int
  // is equivalent to
  // Int => (Int => Int)


  /** Write a product function that calculates the product
   *  of the squared values of a function for the points on a given
   *  interval
   *  */
    def product(f: Int=> Int)(a: Int, b: Int): Int =
      if (a>b) 1
      else f(a)*product(f)(a+1, b)

  /** can we define factorial in terms of product?
   *  */
    def fact(n: Int) = product(x => x)(1, n)

  /** can we find a function that generalizes sum
   *  and product? Using that function we should be
   *  able to express both sum and product.
   *  What could that be?
   *  */
    def mapReduce(f: Int=> Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:Int): Int=
      if (a>b) zero
      else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

  /** write product function in terms of the map reduce
   *  */
    def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y)=> x*y, 1)(a, b)


  def main(args: Array[String]) =
  {
    println(sum(x => x)(1,2))
    println(product(x => x*x)(3,4))
    // returns (3^2)(4^2) = 144
    println(product(x => x*x)(3,5))
    // returns (3^2)(4^2)(5^2) = 3600
    println(fact(3))
    println(mapReduce(x => x, (x,y) => x*y, 1)(1,3))
    // returns 6
    println(product2(x => x)(1,3))
  }
}

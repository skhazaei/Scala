import scala.annotation.tailrec

/**  write a function to compute
 *  the greatest common divisor (gcd)
 *  of two numbers.
 *  an implementation of gcd using
 *  Euclid's algorithm.
 * */

def gcd(a: Int, b: Int): Int =
  if (b==0) a else gcd(b, a % b)
gcd(21, 14)
// returns 7

/** Implement a factorial function */
def factorial(n : Int): Int =
  if (n==0) 1 else n* factorial(n-1)

factorial(5)
// returns 120

/**  What are the differences between two methods?
 *
 * in gcd:
 * the reduction sequence essentially oscillates.
 * It goes from one call to gcd to the next one,
 * and eventually it terminates.
 *
 * in factorial:
 * in each steps, one more element is added to
 * the expressions. The expressions becomes bigger
 * and bigger until it ends when finally reduce
 * it to the final value.
 */

/** Tail Recursion:
 * That difference in the rewriting rules actually
 * translates directly to a difference in the actual
 * execution on a computer. In fact, it turns out that
 * if you have a recursive function that calls itself
 * as its last action, then you can reuse the stack
 * frame of that function. This is called tail recursion.
 *
 * And by applying that trick, a tail recursive function
 * can execute in constant stack space, so it's really
 * just another formulation of an iterative process.
 * We could say a tail recursive function is the functional
 * form of a loop, and it executes just as efficiently as a loop.
 *
 * // gcd:
 * gcd calls itself as its last action.
 * And that translates to a rewriting sequence that was
 * essentially constant in size, and that will, in the actual
 * execution on a computer, translate into a tail recursive
 * call that can execute in constant space.
 *
 * // factorial:
 * in factorial, after the call to factorial(n - 1),
 * there is still work to be done, namely, we had to multiply
 * the result of that call with the number n.
 * So, that recursive call is not a tail recursive call,
 * */

/** TAIL RECURSION IN SCALA
 * In Scala, only directly recursive calls to the current
 * function are optimized. One can require that a function
 * is tail-recursive using a @tailrec annotation:
 *  */


/**
 * /// What is the benefit of @tailrec annotation?
 *
 * A tail recursive function call allows the compiler
 * to perform a special optimization which it normally
 * can not with regular recursion.
 *
 * In a tail recursive function, the recursive call
 * is the very last thing to be executed.
 * In this case, instead of allocating a stack frame
 * for each call, the compiler can rework the code
 * to simply reuse the current stack frame, meaning
 * a tail-recursive function will only use a single
 * stack frame as opposed to hundreds or even thousands.
 * */


@tailrec
def gcd_tail(a: Int, b: Int): Int =
  if (b==0) a else gcd_tail(b, a % b)
gcd_tail(6,2)


/** implement a recursion version of factorial */
def factorial_tail(n: Int): Int = {
  @tailrec
  def loop(acc: Int, n: Int): Int = {
    if (n==1) acc
    else loop(n*acc, n-1)
  }
  loop(1, n)
}
factorial_tail(3)
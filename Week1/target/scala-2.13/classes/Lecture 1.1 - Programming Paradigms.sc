// ******** Lecture 1.2 - Elements of Programming
def x = 1
//
def x: Double=3
//
def Square(x: Double=5): Double= x*x
Square()
//
def sumOfSquares(x: Double, y: Double): Double = Square(x) + Square(y)
sumOfSquares(2, 3)
// ******** Lecture 1.3 - Evaluation Strategies and Termination
/*
call by name (CBN)
call by value (CBV)
CBN vs. CBV

Let's define:
def first(x: Int, y: Int) = x

and now let's consider the expression first(1, loop)

ANSWER: under CBN -- 1
ANSWER: under CBV -- get stuck in an infinite loop

In Scala, we normally use call by value.
You might ask, well, given the advantages
of call by name that it terminates more often,
why call by value? it turns out that, for expressions
in practice, call by value is often exponentially
more efficient than call by name because it avoids
this repeated re-computation of argument expressions
that call by name entails.
*/

// Except that, sometimes you really want to force
// call by name, and Scala lets you do that also.
// You do that by adding an arrow in front of the
// parameter type, see following example:

def constOne(x: Int, y: => Int): Int = x
def loop: Int=loop

// Let's trace the evaluations of constOne(1+2, loop)
constOne(1+2, loop)
// this outputs 3 because in the definition of constOne,
// y is defined as CBN. In constOne(1+2, loop), loop
// is not going to be called.
/*
However if we wanted to evaluate constOne(loop, 1+2)
then the program gets stuck with a loop,
because x in constOne definition is by default
call by value. So, no progress and we get another
infinite cycle.
 */

// ******** Lecture 1.4 - Conditionals and Value Definitions
// scala has a conditional expression if-else

def abs(x: Int)= if (x>=0) x else -x
abs(-1)

// Boolean expressions
/*
!b Negation
b||b disjunction
b&&b conjunction
 */

// reduction rules for Boolean (e is an arbitrary expression)
/*
!true --> false
!false --> true
true && e --> e
false && e --> false
true || e --> true
false || e --> e

as it can be seen, || and && do not always need their
right operand to be evaluated.
These expressions use "short-circuit evaluation"
 */

// value definition:
// the right hand side of a value definition
// is evaluated at the point of the definition
// itself and afterwards the name refers to the value
val x =2
val y = Square(x)

// difference between val and def:
// The difference between val and def
// as a definition form becomes apparent
// when the right hand side does not terminate.

def loop: Boolean = loop

// A definition
def x = loop
// is Ok

// But a definition
///     val x = loop
// will lead to an infinite loop
// because the right hand side loop
// will be evaluated at the point
// of the finishing.

// Write a function and and
// and(x, y) == x && y

def and(x: Boolean, y: Boolean) =
  if (x) x else false

and(true, false)
// returns true

and(false, true)
// return false

// What about non-terminating arguments?
////   and(false, loop)
// it returns an infinite loop
// this can be fixed as follows:

def and(x: Boolean, y: => Boolean) =
  if (x) x else false

and(false, loop)
// it returns false, without evoking loop
// because in the definition of and,
// y is call by name






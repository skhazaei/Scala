package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4) // first 3*4 is evaluated and then 2 is added
  // 2 + 3 * 4 is mathematical expression which is evaluated
  // Arithmetic Operators: + - * / %

  println(x == 1) // == tests for equality
  // x==1 is expression and is evaluated to false
  // Relational Operators: == != > >= < <=

  println(!(x==1))
  // Logical Operators: !(Logical NOT Operator) && (Logical AND Operator) || (Logical OR Operator)

  var aVariable = 2
  aVariable += 3 // also works for -= *= /=
  println(aVariable)

  // Instructions (DO) vs Expression (VALUE)
  // instructions are those to tell computer to do this and that
  // but expression has value or type

  // if expression
  val aCondition = true
  val conditionValue = if (aCondition) 10 else 3 // if in scala is expression because it returns a value
  println(conditionValue)

  // Loops are discouraged to use in scala
  // Loops do not really return something meaningful and it just returns side effects

  // an example of loop
  var i = 0
  while ( i < 10 ) {
    println(i)
    i += 1
  }

  // while and loops are very specific to imperative programming
  // scala forces every thing to be an expression

  val aWiredValue = (aVariable = 3)
  println(aWiredValue) // returns ()
  // question: what is the type of aWiredValue?
  // answer: unit which is equivalent to void and it means do not return anything meaningful
  println(aWiredValue.getClass) // returns void

  // lets see what is the type of while loop
  var j = 0
  val awhile = while (j<2) {
    println(j)
    j += 1
  }
  println(awhile.getClass) // returns void
  println(awhile) // returns ()

  // Examples of side effects, which are expressions returning units
  // 1. println, 2. reassignment, 3. whiles

  // codeblocks
  val aCodeBlock = {
    val x = 2
    val y = x + 3
    if (y > 3) "Hello" else "Bye"
  }
  println(aCodeBlock) //  returns Hello
  println(aCodeBlock.getClass) // returns class java.lang.String

  // question: what this code block return?
   val anotherCodeBlock = {
     val u = 4
     if (u>3) "yes" else "no"
     val t = 2
   }
  println(anotherCodeBlock) // returns ()
  println(anotherCodeBlock.getClass) // returns void
  // val m = u + 2 this gives error because u is defined inside the code block

  // summary of code block:
  //     1- code blocks are expression
  //     2- the value of the block is the value of last expression
  //     3- the values outside of code blocks are not accessible and visible

  val n = 2 + 3
  val nIsEven = n%2 == 0
  val nIsOdd = !nIsEven

  println(n)
  println(nIsEven)
  println(nIsOdd)

  // Takeaways:
  /**
   *  - Everything in scala is an expression.
   *  - if in scala is an expression.
   *  - code blocks in scala are expression.
   *  - the value of code blocks is the value of last expression
   *  - instructions: are executed (means do something)
   *  - expressions: are evaluated (means give me the value of something)
   */

  // Question 1: what is the difference between "hello world" and println("hello world")?
  // Answer: "Hello World" is a value of type String
  //         println("hello World") is an expression which is a side effect
  //         and it returns unit

  // Question 2: what is the value of the following block code?
  val someValue = {
    2 > 3
  }
  // Answer:
  println(someValue)  // false
  println(someValue.getClass) // Boolean

  // Question 3: what is the value of the following code block:
  val otherValue = {
    if (2>3) "yes" else "no"
    42
  }
  // Answer:
  println(otherValue) // returns 42
  println(otherValue.getClass) // returns int














}


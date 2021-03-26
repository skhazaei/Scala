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
  val conditionValue = if (aCondition) 10 else 3 // if expression because it returns a value
  println(conditionValue)

}


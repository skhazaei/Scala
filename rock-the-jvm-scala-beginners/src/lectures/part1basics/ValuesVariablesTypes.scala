package lectures.part1basics

object ValuesVariablesTypes extends App {

  // val is immutable, so x = 12 gives error
  val x: Int = 42
  println(x)

  // type is optional in defining a val
  // compiler can infer the type
  val y = 23
  println(y)

  val aString: String = "Hello"
  val anotherString = "Bye"

  val aBoolean: Boolean = true
  val anotherBoolean: Boolean = false

  val aChar: Char = 'a'

  val aShort: Short = 3276  // 16 bit signed value. Range -32768 to 32767
  val aLong: Long = 999999999980778L // 64 bit signed value. -9223372036854775808 to 9223372036854775807

  val aFloat: Float = 1.0f // 32 bit IEEE 754 single-precision float
  // f must be at the end of value otherwise it interprets as double

  val aDouble: Double = 3.14 // 64 bit IEEE 754 double-precision float

  // Variables
  // variables use as side effect, to see what the program is doing

  var aVariable: Int = 3
  aVariable = 29
  aVariable += 2

}

package lectures.part1basics

object stringOps extends App {

  val str: String = "Hello, I am learning scala"

  // charAt method
  println(str.charAt(2))

  // substring method
  println(str.substring(7, 11))

  // split method
  println(str.split(" ").toList)

  // startsWith method
  println(str.startsWith("Hello"))

  // replace method
  println(str.replace(" ", "-"))

  // toLowerCase
  println(str.toLowerCase())

  // length
  println(str.length)

  // since scala runs on top of java virtual machine, it has
  // access to string class in java language. All above functions
  // belong to java string class.

  // Besides scala has its own utility. The followings are scala utility.
  /*
  - toInt
  - +:
  - reverse
  - take
  - s interpolator
  - f interpolator
  - raw interpolator

   */

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println("a" +: aNumberString :+ "z") // returns Vector(a, 4, 5, z)
  println("a" + aNumberString + "z") // returns a45z

  println(str.reverse) // returns alacs gninrael ma I ,olleH
  println(str.take(3)) // returns Hel

  // s - interpolator
  val name = "Tom"
  val age = 13
  val greetings = s"Hello $name, I am $age years old"
  println(greetings)

  val anotherGreetings = s"I am turning ${age + 1}"
  println(anotherGreetings)

  // f - interpolator
  val num = 1.2f
  val info = f"$name%s eats $num%2.2f burger per minute."
  println(info)

  val euro = 200
  val anotherInfo = f"$name%s has $euro%10d" // return "Tom has        200"
  println(anotherInfo)

  // raw - interpolator
  println(raw"this is a \n new line") // returns this is a \n new line

  val escaped = "this is a \n new line"
  println(raw"$escaped")
  // this returns:
  /*
  this is a
   new line
   */
}

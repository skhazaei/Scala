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
  val aNumberString = "45"
  val aNumber = aNumberString.toInt 



}

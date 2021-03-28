package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Tom", 26)
  println(person) // lectures.part2oop.Person@76a3e297

  println(person.age)

}
// constructor
class Person(name: String, val age: Int) {
  /**
   * first let's define class Person like this:
   * class Person(name: String, age: Int)
   * here, name and age are class parameters and not members/fields
   * Therefore, they can not be access outside of class:
   * person.age returns error. So class parameters are NOT FIELDS.
   *
   *
   * To convert the parameters "name" and "age" to fields, we need just add
   * val or var in front of the parameters
   *
   */

}


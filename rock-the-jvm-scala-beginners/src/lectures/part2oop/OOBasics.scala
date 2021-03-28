package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Tom", 26)
  // as soon the instance of class Person is instantiated,
  // the whole code block of class is executed. Therefore,
  // in console, first the result of println(1+3) is given
  // and then the following line is executed.
  println(person) // lectures.part2oop.Person@76a3e297

  println(person.age)
  person.greet("Sarah")
  person.greet()

  val writer = new Writer("Sanaz", "Valid", 1200)
  println(writer.fullName)
  val novel = new Novel("janvanjan", 2000, writer)
  println(novel.authorAge)
  println(novel.isWrittenBy)
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
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  // in the following method, name is in fact this.name which implies to the class instance
  def greet(): Unit = println(s"Hi I am $name")
  // Overloading:
  /*
    means defining methods with the same name but with different signatures
    different signatures mean "different parameters", or "parameters with different types"
   */

  // multiple constructors
  def this(name: String) = this (name, 0)
  def this() = this("John Doe")
}

class Writer(firstName: String, surname: String, val year: Int){

  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer){
  def authorAge: Int = year - author.year

  def isWrittenBy: String= author.fullName

}













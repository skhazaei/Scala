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

  val author = new Writer("Charles", "Dickens", 1812)
  println(author.fullName)

  val imposter = new Writer("Charles", "Dickens", 1812 )

  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge) // 49
  println(novel.isWrittenBy(author)) // true
  println(novel.isWrittenBy(imposter)) // false
  println(novel.copy(2000)) // lectures.part2oop.Novel@eafc191

  println("class counter")
  val counter = new Counter
  counter.inc.inc.inc.inc.inc.print
  counter.inc(5).print
  counter.dec(3).print
  counter.dec.dec.dec.print

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

// class Writer: firstName, surname, year
//               - method fullName
class Writer(firstName: String, surname: String, val year: Int){
  def fullName: String = firstName + " " + surname
}

// class Novel: name, year of release, author
//              - method authorAge at the time of novel release
//              - method isWrittenBy(author)
//              - method copy (new year of release) = new instance of Novel
class Novel(name: String, year: Int, author: Writer){
  def authorAge: Int = year - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}


// class Counter: an int value
//              - method current count
//              - method to increment/decrement => new Counter
//              - method overload to inc/dec to receive an amount
class Counter(val count: Int = 0) {
  def inc: Counter = {
    println("incrementing")
    new Counter(count + 1) //immutability
  }
  // immutability: instances are fixed and can not be modified inside
  // whenever you need to modify the instances inside, return a new instances
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  // overloading
  def inc(n: Int): Counter = {
    if (n<=0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if (n<=0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}








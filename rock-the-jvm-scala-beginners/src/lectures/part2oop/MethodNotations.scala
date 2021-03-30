package lectures.part2oop

object MethodNotations extends App {

  // we are going to declare a class with name Person inside the object
  // to prevent the conflict with other class named Person within this package
  class Person(val name: String, favoriteMovie: String, val age: Int=0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is couple with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and my favorite movie is $favoriteMovie"


    /*
     1. write an overload infix operator +
        mary + "the rockstar" => new person "Mary (the rockstar)"
        rock star is the nickname
    */
    def +(nickName: String): Person = new Person(s"$name ($nickName)",favoriteMovie)

    /*
        2. add an age to the person class with default zero value
       add unary + operator to increment age and returns a new Person with age + 1
       +mary => mary with age incremented
     */
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    /*
        3. add learns method to the Person class => "Mary learns Scala"
       add learnsScala. calls learns method with "Scala" as parameter
       Use it in postfix notation.
     */
    def learns(thing: String): String = s"$name is learning $thing"
    def learnsScala = this learns "Scala"

    /*
      4. overload apply method
         mary.apply(2) => "mary watched Inception 2 times"
     */
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"


  }

  // infix notation
  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation == operator notation (an example of syntactic sugar)
  // the style of calling methods in infix notation is called "syntactic sugar"
  // syntactic sugar is more resemble of natural language
  // this called "infix notation" or "operator notation"
  // which looks like natural language
  // and it only works with methods that have one parameter

  // "Operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary.hangOutWith(tom))
  println(mary hangOutWith tom)

  println(mary.+(tom))
  println(mary + tom)
  // in fact the + operator between numbers are actually methods as well
  // all operators are methods in scala
  println( x = 1.+(2))
  println( 1 + 2 )

  // prefix notation
  // prefix notation (another form of syntactic sugar)
  // prefix notation is all about unary operators
  // for example in -1, "-" negative sign is a unary operator
  // unary operators are also methods
  // look at the two equivalent definitions:
  val x = -1
  val y = 1.unary_-   // y=-1
  // unary operators are actually methods with unary_ prefix
  // unary_ prefix works only with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  // the functions that do not take any parameters
  // have the property to be used for postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply method
  println(mary.apply)
  println(mary()) // equivalent

  //
  println((mary + "the rockstar").apply())
  println((mary + "the rockstar")())

  //
  println((mary.unary_+).age)
  println((+mary).age)

  //
  println(mary.learns("Scala"))
  println(mary learns "Scala")

  //
  println(mary.learnsScala)
  println(mary learnsScala)

  //
  println(mary.apply(2))
  println(mary(2))


}

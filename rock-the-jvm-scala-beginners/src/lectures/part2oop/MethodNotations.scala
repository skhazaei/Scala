package lectures.part2oop

object MethodNotations extends App {

  // we are going to declare a class with name Person inside the object
  // to prevent the conflict with other class named Person within this package
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is couple with ${person.name}"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
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
  println( 1.+(2))
  println( 1 + 2 )

}

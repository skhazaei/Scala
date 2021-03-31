package lectures.part2oop

object Objects extends App {

  /*
  --- Scala does not have static methods/values

  *** Scala objects:
      -- are in their own type
      -- are the only instance
      -- Scala objects = Singleton instance

  --- In scala, we avoid to refer the instances of class as object
      because objects in scala is a dedicated concept.

  --- Scala does not have class-level functionality

  --- Objects can have values and methods

  --- It means when we define scala objects, in fact
      we define type and only instance

  *** Scala Companions:
      -- scala objects and scala classes can stay in the same
         scope
      -- companions can access each others private members
      -- the pattern of writing classes and objects with the
         same name in the same scope is called companions

  *** Scala is more OO than java
      all the codes would be access via some kind of instances
      either regular instances (class instances) or singleton instance

  *** Scala applications are scala objects with either:
      def main(args: Array[String]): Unit
      or object myApp extends App
   */

  object Person { // type + only instance
    val N_eyes = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person (val name: String) {
    // instance-level functionality
  }


  println(Person.N_eyes)
  println(Person.canFly)

  // scala objects = singleton instance
  val person1 = Person
  val person2 = Person
  println(person1 == person2) // returns true
  // because person1 and person2 point to the same instance
  // which is the object called Person
  // object Person is a singleton object and it means
  // there is a single instance (singleton) that can be referred
  // with the name Person

  val mary = new Person("Mary")
  val tom = new Person ("Tom")
  println(mary == tom) // returns false
  // because sam and sarah refer to different instances

  //val bobbie = Person.apply(mary, tom)
  val bobbie = Person(mary, tom) // equivalent
  // to make singleton object like a callable function
  // this looks like a constructor but with a difference
  // that is actually apply method in the Person singleton object


  // Scala Application = Scala Object with
  // def main(args: Array[String]): Unit = {}
  // because scala applications turn to java virtual machine applications
  // whose entry point have to be public static void main with an array of String
  // as parameter. Static in java is translated in a plain main method in scala object.
  // Therefore scala applications have to be scala objects with main method

  // you can either extends app or give def main method





}

package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  // we can instantiate the types and override the methods and fields on the spot
  // this work with abstract, non abstract classes and trait
  val funnyAnimal = new Animal{
    override def eat: Unit = println("Hahahaha")
  }
  println(funnyAnimal.getClass)

  // returns "class lectures.part2oop.AnonymousClasses$$anon$1"
  /**
   * it appears that we instantiated an abstract class
   * but in fact we instantiated a real class
   * remember that abstract classes do not instantiated
   */

  // what actually happens behind:
  /**
  class $anon$1 extends Animal {
    override def eat: Unit = println("Hahahah")
  }
  val funnyAnimal = new $anon$1
  println(funnyAnimal.getClass)
  */

  // anonymous classes work for abstract and non abstract data type
  // Rule 1- pass in all required constructor arguments if needed
  // Rule 2- implement all abstract methods and fields
  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, I am Jim, how can I help you")
  }
  jim.sayHi



}

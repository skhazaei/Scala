package lectures.part2oop

object AbstractDataTypes extends App{

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  /**
   *  abstract class X
   *  1- members of abstract class are usually left unimplemented
   *  2- abstract classes can not be instantiated:
   *  val animal = new Animal returns error: "class Animal is abstract; cannot be instantiated"
   *  3- abstract classes in abstract data type are means to be extended later
   */

  class Dog extends Animal{
     val creatureType: String = "canine"
     def eat: Unit = println("Crunch Crunch")
  }

  /**
   * traits:
   * -- traits like abstract class can have abstract fields and methods
   * -- traits can be inherited along classes
   */
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I am a $creatureType and eating ${animal.creatureType}")
  }

  val croc = new Crocodile
  val dog = new Dog
  croc.eat
  croc.eat(dog)


  /**
   * abstract classes and traits both can have abstract and non-abstract members
   *
   * abstract class vs traits:
   * 1- trait do not have constructor parameters
   * 2- multiple traits may be inherited by the same class (we can extend one class and multiple traits)
   * 3- traits describe behaviours but abstract class is a type of "thing"
   */






}

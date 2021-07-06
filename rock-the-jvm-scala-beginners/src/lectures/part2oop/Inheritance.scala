package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  // access modifiers: public vs private vs protected
  // private modifier : private def eat -- then eat method can not be accessed outside of class
  // protected modifier: protected def eat -- then eat method is marked to be useable
  // in its own classes and also subclasses

  class Animal {
    def eat = println("Animal eat method")
    val creatureType = "Wild"
    val name: String = "Animal"
  }

  class Cat extends Animal{
    def crunch ={
      eat
      println("Crunch Crunch")
    }
  }

  val cat = new Cat
  //cat.eat
  cat.crunch

  // constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }

  // jvm call first the constructor of parent class and then the subclass Adult
  class Adult(name: String, age: Int, IdCard: Int) extends Person(name: String)

  // overriding
  // we can override the fields from superclass directly in the constructor
  class Dog(override val name: String) extends Animal {
    override def eat = {
      super.eat
      println("dog eat method")
    }
    override val creatureType: String = "domestic"
    def print = println(name)
  }

  val dog= new Dog("Rex")
  dog.eat
  dog.creatureType
  dog.print

  // all the instances of the derived classes use the override methods and fields

  // type substitution -- in broad sense is called polymorphism

  val unknownAnimal: Animal = new Dog("k20")
  unknownAnimal.creatureType
  unknownAnimal.eat
  // if we try unknownAnimal.print returns the error:
  // value print is not a member of lectures.part2oop.Inheritance.Animal
  // so while unknownAnimal is of type of Animal but it can uses the latest override methods
  // in the class Dog. Print is not a method in Animal class

  // Overriding vs Overloading

  // super
  // we can access to eat method in the class of Dog while overriding eat method by super.eat

  /**
   * Preventing override:
   *  - 1- use final on the members: "final def eat"
   *                 this prevents derived classes of overriding the eat method
   *  - 2- use final on the entire class: "final class Animal"
   *                 this prevents the entire class to be extended
   *  - 3- Seal the class: "sealed class Animal"
   *                 to extend the class in this file but prevent class extension on other file
   *
   */


}

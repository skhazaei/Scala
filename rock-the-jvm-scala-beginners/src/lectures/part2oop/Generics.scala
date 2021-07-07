package lectures.part2oop

import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy

object Generics extends App{

  class MyList[+A] { // generic class of type A
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = cat
    B = dog which is basicaly Animal, so lets say B = Animal
     */
  }

  class MyMap[Key, Value]

  val intList = new MyList[Int]
  val strList = new MyList[String]

  // traits can be also type parameterised but objects can not

  // generic method
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes: List[Cat] extends List[Animal] COVARIANCE
  class CovariantList[+A]
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // hard question:
  // if I have a list of animals which in fact is a list of cats,
  // what if I add a new Dog to the list?
  // animalList.add(new Dog)=???
  // Answer: if we add dog to the list of cats, it returns a list of Animals

  // 2. No: List[Cat] and List[Animal] are two different things
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. hell, No!: Contravariance
  class ContravarianceTrainer[-A]
  val trainer: ContravarianceTrainer[Cat] = new ContravarianceTrainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

  class Car
  //val newCage = new Cage(new Car)
  // return error: do not conform to value <local Cage>'s type parameter bounds [A <: lectures.part2oop.Generics.Animal]
  //  val newCage = new Cage(new Car)









}

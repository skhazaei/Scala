package lectures.part2oop

object Generics extends App{

  class MyList[A] { // generic class of type A
    // use the type A
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
  println(emptyListOfIntegers)

  // variance problem
  //
}

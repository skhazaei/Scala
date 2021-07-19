package lectures.part3fp

import scala.util.Random

object Sequences extends App{

  // sequences
  val aSeq = Seq(1, 20, 13, 4) // its type is aSeq: Seq[Int] = Seq(1, 2, 3, 4)
  println(aSeq)
  // returns List(1, 2, 3, 4)
  // sequences are actually lists
  println(aSeq.reverse) // List(4, 3, 2, 1)
  println(aSeq(2)) // get the element at index 2 - returns 3
  println(aSeq ++ Seq(5, 6, 7))
  println(aSeq.sorted)

  // Ranges

  val aRange: Seq[Int] = 1 to 3
  println(aRange) // returns Range 1 to 3
  aRange.foreach(println)
  //1
  //2
  //3
  val anotherRange: Seq[Int] = 1 until 3
  println(anotherRange) // Range 1 until 3
  anotherRange.foreach(println)
  //1
  //2

  (1 to 2).foreach(n => println("scala"))
  // scala
  // scala

  val aList = List(1, 2, 3)
  val prepended1 = 42 :: aList
  println(prepended1) // List(42, 1, 2, 3)

  val prepended2 = 32 +: prepended1
  println(prepended2) // List(32, 42, 1, 2, 3)

  val append = prepended2 :+ 52
  println(append) // List(32, 42, 1, 2, 3, 52)

  val prependAppend = 1000 +: append :+ 1000
  println(prependAppend) // List(1000, 32, 42, 1, 2, 3, 52, 1000)
  // : is always on the side of List

  // fill: a curried function
  val apple5 = List.fill(5)("apple")
  println(apple5) // List(apple, apple, apple, apple, apple)

  // mkString
  println(aList.mkString("+")) // 1+2+3

  // Arrays: can be manually constructed with predefined lengths
  //       : can be mutated
  val numbers = Array(100, 200, 300)
  println(numbers) // [I@10a035a0

  numbers.foreach(println)
  // 100
  // 200
  // 300

  val array = Array.ofDim[Int](3)
  println(array) // [I@710726a3

  array.foreach(println)
  // 0
  // 0
  // 0

  val stringArray = Array.ofDim[String](3)
  stringArray.foreach(println)
  // null
  // null
  // null

  // mutations

  stringArray(2) = "Hello" // synatx sugar for stringArray.update(2, "Hello")
  println(stringArray) // [Ljava.lang.String;@1e4a7dd4

  stringArray.foreach(println)
  // null
  // null
  // Hello

  println(stringArray.mkString("-")) // null-null-Hello

  // Array and Seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq) // ArraySeq(100, 200, 300)

  // vectors
  // effectively constant indexed read and write
  // fast element addition: prepend/append
  // implemented as fixed branch tries (branch factor 32)
  // good performance for large size

  val vector: Vector[Int] = Vector(1000, 2000, 3000)
  println(vector) // Vector(1000, 2000, 3000)

  // vector vs list
  val randomNumber = new Random()
  println(randomNumber.nextInt(10)) // prints random number from 0 to 10


  val maxCapacity = 1000000
  val maxRun = 1000

  def getWriteTime (collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRun
    } yield {
      val currentTime = System.nanoTime()
      // do some operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRun
  }

  // advantage of List: keeps the reference to tail
  // disadvantage of List: updating an element in the middle takes a lot of time
  val numbersList = (1 to maxCapacity).toList
  // Advantage of Vector: the depth of tree is small
  // Disadvantage of Vector: needs to replace an entire 32-elements chunk
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList)) // 5965278.175 nanoseconds
  println(getWriteTime(numbersVector)) // 3462.398 nanoseconds


















}

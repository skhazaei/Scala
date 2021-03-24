import scala.collection.mutable._

object MutableCollections {
  def main(args: Array[String]) ={}

    /** What we learn?
     * --- create mutable collections
     * --- import explicitly mutable collection packages
     * --- create a mutable map
     * --- create a ListBuffer, and add new elements or another list to it
     * --- try higher order functions like map and foreach with ListBuffer
     * --- convert mutable map and ListBuffer to immutable ones
     * --- two other mutable collections are: 1- ArrayBuffer, which is a dynamic array
     *                                        2- StringBuilder, which is a dynamic string
     * */

  val aMap: Map[String, Int] = Map("a" -> 1, "b" ->2, "c" ->3)
  println(aMap.getClass) // returns class scala.collection.mutable.HashMap
  println(aMap) // returns HashMap(a -> 1, b -> 2, c -> 3)
  // as it can be seen, scala has inferred that aMap is a mutable map

  val aList = ListBuffer("scala")
  println(aList.getClass) // returns class scala.collection.mutable.ListBuffer
  println(aList) // returns ListBuffer(scala)

  // let's add "java" to aList
  aList += "java"
  println(aList) // returns ListBuffer(scala, java)

  // let's add another list to the aList using ++ operator
  aList ++= ListBuffer("C", "python")
  println(aList)

  // let's evoke other higher order functions like foreach
  aList.foreach(println)

  // use map to print the first elements of each list element
  println(aList.map(_(0)))

  val immMap = aMap.toMap
  println(immMap.getClass)
  println(immMap)

  val immList = aList.toList
  println(immList.getClass)
  println(immList)









}

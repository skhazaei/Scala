object Lists {
  def main(args: Array[String]) = {

    /** What we learn:
     * ---- create Lists: Cons Operator, List apply methods
     * ---- Merge Lists: using ++ and ::: operators
     * ---- create empty List: using Nil or List apply method
     * ---- head, tail, init, last and size methods on Lists
     * ---- for: to iterate over list elements using for
     * ---- foreach, and map():  to apply some task on all elements
     * ---- List.range() to create a range of elements
     * ---- substring
     * ---- zip
     * ---- sorted and reverse
     * */


    /** Lists:
     * - by default lists are immutable collection
     * - Lists are implemented as singly Linked List
     * - Lists in scala are terminated by values called Nil
     * - Nil is special value in List, an instance of List
     *
     *  */

    // Use Cons :: Operator to create List(a, b, c, d)
    val letters1 = "a" :: "b" :: "c" :: "d" :: Nil
    println("first list of letters: " + letters1)      //  List(a, b, c, d)
    println("size = " + letters1.size) // 4
    println("head = " + letters1.head) // a
    println("tail = " + letters1.tail) // List(b, c, d)
    println("init = " + letters1.init) // List(a, b, c)
    println("last = " + letters1.last) // List(d)

    // Use List apply method to create List(e, f, g, h)
    val letters2 : List[String] = List("e", "f", "g", "h")
    println("second list of letters: " + letters2)

    // Merge two lists of letters using ++ operator
    val lettersMerged1 = letters1 ++ letters2
    println("merged list of letters = " + lettersMerged1)

    // Use for to iterate on the elements of the lists
    println("iterate over elements using FOR LOOP")
    for (letter <- lettersMerged1) {
      println(letter)
    }

    // Use foreach to iterate over the list elements
    println("\niterate over elements using FOREACH")
    lettersMerged1.foreach(println)

    // Merge two lists of letters using ::: operator
    val lettersMerged2 = letters1 ::: letters2
    println("Merged lists of letters: " + lettersMerged2)

    // Use List[Int] method to create List(1, 2, 3, 4)
    val ints1: List[Int] = List(1, 2, 3, 4)
    println(ints1)

    // Use Cons operator to create List(5, 6, 7, 8)
    val ints2 = 5 :: 6 :: 7 :: 8 :: Nil
    println(ints2)

    // Merge two integer lists using ++operator
    val intsMerged1 = ints1 ++ ints2
    println(intsMerged1)

    // Use for to iterate on the elements of the lists
    for (nums <- intsMerged1) {
      println(nums)
    }

    // Merge two integer lists using ::: operator
    val intsMerged2 = ints1 ::: ints2
    println(intsMerged2 )

    // Create an empty list using Nil
    val emptyList1 = Nil
    println(emptyList1)

    //Create an empty list using List apply method
    val emptyList2 = List()
    println(emptyList2)
    println(emptyList2.size) // 0
    // applying other methods like head, tail, init, and last on empty lists return errors

    // use range method to create a list of numbers ranges 1-10
    val numbers = List.range(1,11)
    println(numbers)
    println(numbers.size)
    for (nums <- numbers)
      println(nums )

    // Lets sum up the elements in the numbers list
    var sum1 = 0
    for (nums <- numbers)
      sum1 += nums
    println(s"sum calculated using for loop= $sum1")

    // Use foreach() to sum up the elements in the numbers list
    var sum2 = 0
    numbers.foreach(sum2+=_)
    println(s"sum calculated using foreach method = $sum2")

    // Use map() method to sum up the elements in the numbers list
    var sum3 = 0
    numbers.map(sum3+=_)
    println(s"sum calculated using map method = $sum3")

    // Use map() to multiply all elements of numbers by 2
    println(numbers.map(_*2)) // return a list where all numbers are multiply by two

    // Let's consider the following list:
    var names = List("Hannah", "Jeniffer", "Marta", "Serena")
    println(s"list of names = $names")
    var short_names = names.map(_.substring(0,3))
    println(s"list of short names (the first three letters) = $short_names")

    // use zip method to zip two lists and put each pair together as tuple
    var abb = names.zip(short_names)
    print(s"zip file of names and short names = $abb")

    // use foreach method to print the zip list
    abb.foreach(println)

    // Let's consider the following list
    var randomNums = List(100, 12, 1, 0, -2, 3, 17, 2, -2, -14, -0.1)
    println(s"random numbers = $randomNums")
    println("sorted numbers = " + randomNums.sorted)
    println("reverse sorted numbers = " + (randomNums.sorted).reverse)
    println(randomNums(1))

  }
}

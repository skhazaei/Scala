object Lists {
  def main(args: Array[String]) = {

    /** What we learn:
     * create Lists: Cons Operator, List apply methods
     * Merge Lists: using ++ and ::: operators
     * create empty List: using Nil or List apply method
     * head, tail, init, last and size methods on Lists
     * 
     *
     * */


    /** Lists:
     * - by default lists are immutable collection
     * - Lists are implemented as singly Linked List
     * - Lists in scala are terminated by values called Nil
     * - Nil is special value in List, an instance of List
     *
     *
     *  How to create a list?
     *
     *  1- use Cons :: operator
     *  2- use List apply method
     *  3- Merge two lists using ::: or ++ operator
     *  4- create an empty list
     *
     *  Useful methods on List:
     *  -- size
     *  -- head
     *  -- tail
     *  -- init
     *  -- last
     *
     *  */

    // Use Cons :: Operator to create List(a, b, c, d)
    val letters1 = "a" :: "b" :: "c" :: "d" :: Nil
    println(letters1)      //  List(a, b, c, d)
    println(letters1.size) // 4
    println(letters1.head) // a
    println(letters1.tail) // List(b, c, d)
    println(letters1.init) // List(a, b, c)
    println(letters1.last) // List(d)

    // Use List apply method to create List(e, f, g, h)
    val letters2 : List[String] = List("e", "f", "g", "h")
    println(letters2)

    // Merge two lists of alpha1 and alpha2 using ++ operator
    val lettersMerged1 = letters1 ++ letters2
    println(lettersMerged1)

    // Merge two lists of alpha1 and alpha2 using ::: operator
    val lettersMerged2 = letters1 ::: letters2
    println(lettersMerged2)

    // Use List[Int] method to create List(1, 2, 3, 4)
    val ints1: List[Int] = List(1, 2, 3, 4)
    println(ints1)

    // Use Cons operator to create List(5, 6, 7, 8)
    val ints2 = 5 :: 6 :: 7 :: 8 :: Nil
    println(ints2)

    // Merge two integer lists using ++operator
    val intsMerged1 = ints1 ++ ints2
    println(intsMerged1)

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



  }



}

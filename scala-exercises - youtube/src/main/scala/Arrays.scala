object Arrays {
  def main(args:Array[String]) = {

    /** What we learn?
     *
     *
     *
     */

    /**
     * Arrays are:
     * --- NOT technically collections
     * --- have fixed length
     * --- but their elements are mutable
     * --- are Sequences (Sequences are interfaces for data structure
     *                    that have a well defined order and are indexable)
     */

    // create an empty array of string with the size 3
    // use mkString to print the array
    // mkString: convert arrays element by element to string representations
    // use size method to print the size array
    val array: Array[String] = new Array[String](3)
    println(array)       // returns [Ljava.lang.String;@631330c
    println(array.size)  // returns 3
    println(array.mkString(" "))

    println()

    val anotherArray = new Array[String](4)
    println(anotherArray)   // returns [Ljava.lang.String;@37374a5e
    println(anotherArray.size)   // return 4
    println(anotherArray.mkString(",")) // returns null,null,null,null

    println()

    // use Array method to create an array
    val newArray = Array("scala", "java", "python")
    println(newArray(1))
    println(newArray.size)
    println(newArray.mkString("-"))  // returns scala-java-python

    // access the array elements using their index, which starts from 0
    println(newArray(0))
    println(newArray(1))
    println(newArray(2))

    // modify the first element with "C"
    newArray(0) = "awesome scala"
    println(newArray.mkString(","))
  }

}

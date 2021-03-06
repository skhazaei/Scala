package exercises


abstract class MyList[+A] {
  /**
   * implement a linked list
   * head = first element of the list
   * tail = remainder of the list
   * isEmpty = is this list Empty
   * add(int) = a new list with this element added
   * toString = a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  // polymorphic call
  def printElement: String
  override def toString: String = "[" + printElement + "]"
}

object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElement: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElement:String= {
    if (t.isEmpty) "" + h
    else  h + " "+ t.printElement
  }
}

object ListTest extends App{

  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.head)
  println(list.tail)
  println(list.isEmpty)
  val addedList = list.add(4)
  println(addedList)
  // part 2
  val listOfIntegers = new Cons(10, new Cons(20, new Cons(30, Empty)))
  val listOfStrings = new Cons("Hello", new Cons("World", Empty))
  println(listOfIntegers)
  println(listOfStrings)
}

/**
 * First version
 * abstract class MyList {
  /**
 * implement a linked list
 * head = first element of the list
 * tail = remainder of the list
 * isEmpty = is this list Empty
 * add(int) = a new list with this element added
 * toString = a string representation of the list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  // polymorphic call
  def printElement: String
  override def toString: String = "[" + printElement + "]"
}

object Empty extends MyList{
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElement: String = ""
}

class Cons(h: Int, t: MyList) extends MyList{
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElement:String= {
    if (t.isEmpty) "" + h
    else  h + " "+ t.printElement
  }
}

object ListTest extends App{

  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.head)
  println(list.tail)
  println(list.isEmpty)
  val addedList = list.add(4)
  println(addedList)
}*
 */

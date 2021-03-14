object Maps {
  def main(args:Array[String]) = {}

  /** What we learn:
   * ----- Maps are collections used to associate things with other things
   * ----- With maps we associate keys to values
   * ----- create an empty map
   * ----- create a map use Map method Map(key -> value)
   * ----- use getClass to get the type/class of variable
   * ----- fetch the values of map
   * ----- handle a scenario when a key does not exists use:
   *       1- contains
   *       2- get
   *       3- withDefaultValue
   *       4- getOrElse
   * ----- iterate over map keys and values use:
   *                               1- for
   *                               2- foreach
   * ----- create a map out of two lists using zip and toMap methods
   * ----- get the keys of a map as a list use keySet and toList
   * ----- get the values of a map as a list use values and toList
   * ----- in map, like dictionaries in python, the keys must be unique
   */

  /**
   * Map:
   * 1- part of core collection library
   * 2- by default is immutable
   * 3- is a set of keys and values
   */

  // create an empty map, which keys are string and values are integers
  val aMap: Map[String, Int] = Map()
  println(aMap)


  // create a menu of food items along with their prices
  // syntax of maps is similar to the tuple: key -> value
    val menu = Map("pizza" -> 12.8,
    "pasta" -> 10.0,
    "penne" -> 8.80)
  println("menu" + menu)

  // check what is the type of menu, what you think?
  println(menu.getClass)
  // Answer: the scala collection immutable map

  // Let's look up a value, for instance "pizza" to see its price
  println("Pizza price: " + menu("pizza"))

  // How about to check the price of a food that does not exist in menu?
  //println(menu("Burger"))
  // Answer: "Exception in thread "main" java.lang.ExceptionInInitializerError
  //	        at Maps.main(Maps.scala)"

  // How handle such cases?
  // 1- method contains
  // 2- method get
  // 3- use withDefaultValue
  // 4- getOrElse

  // ******** 1- one way is to check if a key exists in map beforehand using "method contains"
  // let's then to define the method fetchPrice

  def fetchPrice(food: String) = {
    if (menu.contains(food)) println(s"$food price: " + menu(food))
    else println("we do not serve this food")
  }
  fetchPrice("pizza")
  fetchPrice("Burger")

  // ******* 2- Second way is using get method and pattern matching
  def fetchPrice2(item: String)= menu.get(item) match {
      case None => "sorry we do not serve this item"
      case Some(price) => s"$item price: " + price
    }
  println(fetchPrice2("pizza"))
  println(fetchPrice2("Burger"))

  // ******* 3- we can consider such situations when defining the menu
  // using withDefaultValue, let's try it!
  val menu2 = Map("pizza" -> 12.8,
    "pasta" -> 10.0,
    "penne" -> 8.80).withDefaultValue(0.0)
  println(menu2)
  println("pizza price: " + menu2("pizza"))
  println("Burger price: "+ menu2("Burger"))
  // Output:
  // Map(pizza -> 12.8, pasta -> 10.0, penne -> 8.8)
  // pizza price: 12.8
  // Burger price: 0.0

  // ******* 4- using getOrElse
  println(menu.getOrElse("pizza", "we do not serve this item"))
  println(menu.getOrElse("Burger", "we do not serve this item"))

  // Iterate over the menu use for
  for ((key, value) <- menu) println(s"$key costs $value")

  // iterate over menu items use foreach
  menu.foreach{
    case(k, v) => println(s"$k costs $v")
  }

  // Create a map out of two lists x, y
  val x = List("a", "b", "c")
  val y = List(1, 2, 3)
  val z = x.zip(y).toMap
  println(z)
  println(z.getClass)

  //recall that zip takes two lists and create
  // the third list with both initial lists
  println(x.zip(y)) // returns List((a,1), (b,2), (c,3))

  // let's now separate a map to two lists using keySet
  val xRecover = z.keySet.toList
  println(xRecover)

  val yRecover = z.values.toList
  println(yRecover)

  val uniqueKeys = Map(1->2, 1->3, 1->4)
  println(uniqueKeys) // returns Map(1 -> 4)

  println(uniqueKeys.getClass)
  val anotherMap = uniqueKeys + (2->1)
  println(anotherMap)


}

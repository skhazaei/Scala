object Tuples {
  def main(args:Array[String]) = {}
  /**
   * Tuples:
   *       1- declared by enclosing values in parentheses
   *       2- can values of different types
   *       3- the elements can be accessed by their oder
   *       4- implements trait like Tuple1, Tuple2
   */

  // create a tuple, includes different types of elements
  val cellInformation = ("Apple", "ios", 12, 2021)
  print(cellInformation)

  println()

  // create a two-elements tuple of ((iphone 12, 12),(iphone 6, 2016))
  // using key-value syntax with an arrow
  val yearOfRelease = ("iphone 12" -> 2020, "iphone 6" -> 2016 )
  print(yearOfRelease)

  println()

  // Use productArity method to access the elements of tuple object
  println(cellInformation.productArity)

  // Tuples are ordered containers: fetch the elements by under score(_)
  println(cellInformation._1)
  println(yearOfRelease._2)

  // A cleaner way to access the individual value in a tuple
  val (brand, system, model, year) = cellInformation
  println("brand: " + brand)
  println("system: " + system)
  println("model: " + model)
  println("year: " + year)

  println()

  // Let's print the elements of cellInformation using
  // productIterator.foreach method
  cellInformation.productIterator.foreach(println)

  // write a method that takes the cellInformation as tuple and
  // it returns model and the year of the cell phone as a tuple
  def getModelAndSize(cellphone: (String, String, Int, Int )) = {
    val (_, model, _, year) = cellphone
    (model, year)
  }
  println(getModelAndSize(cellInformation))

  // A better way to evoke the getModelAndSize method:
  val (cellBrand, cellYear) = getModelAndSize(cellInformation)
  println(cellBrand, cellYear)





}

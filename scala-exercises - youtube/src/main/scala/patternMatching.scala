import scala.io.StdIn.readLine

object patternMatching {
  def main(args:Array[String]) = {

    // Write a code to ask user a weekday
    // and if weekday is Friday or saturday
    // (including ignore case) prints
    // "Have a nice weekend" and in all other cases
    // prints "inputDay = $inputDay"
    val inputDay = readLine("enter a weekday ...\n\n")
    // One way of implementation is using |
    /**
    val output = inputDay.toLowerCase match{
      case "friday" | "saturday" => "Have a nice weekend"
      case _  => s"Today is $inputDay"}
    println(output)
     */
    // A better implementation:
    val output = inputDay.toLowerCase match {
      case weekend if (weekend=="friday" || weekend=="saturday") => "Have a nice weekend"
      case _ => s"inputDay=  $inputDay"
    }
    println(output)

  // Second Example:
  // Pattern matching on type
  // Write a method the computes the area of a circle
  // Let's assume the input radius can be received as int/string
  // So the input type can be "Any" and output is "Double"


  def circleArea(radius: Any): Double = {
    val area: Double = radius match {
      case i: Int => Math.PI * i * i
      case s: String => Math.PI * s.toInt * s.toInt
    }
    return area}

  val areaInt = circleArea(1)
  println("area with Integer radius as input= " + areaInt)

  val areaString = circleArea("1")
  println("area with String radius as input= " + areaString)

  }
}

import math.pow

object ClassSessions1{
  def main(args: Array[String]) ={

    /** What we learn?
     * --- define class Coordinate
     * --- define distance method in class
     *     to compute the distance between two points
     *  */

    val origin = new Coordinate(0, 0)
    println(origin) // returns Coordinate@42f93a98

    val point = new Coordinate(3, 4 )
    println(point) // Coordinate@c46bcd4
    println(point.getClass) // class Coordinate

    // use distance method to get the distance between point and origin
    println(point.distance(origin))
  }
}

class Coordinate(val x: Double, val y: Double) {
  // define a method to compute distance between two points
  def distance(c: Coordinate): Double = {
    val xDistanceSquare = pow((x - c.x), 2)
    val yDistanceSquare = pow((y - c.y), 2)
    pow((xDistanceSquare + yDistanceSquare), 0.5)
  }

}

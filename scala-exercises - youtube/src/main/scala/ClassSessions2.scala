import math.pow

object ClassSessions2 {
  def main(args: Array[String]) = {

    /** What we learn?
     *
     * --- in last lesson, we computed the distance of each point
     *     from the origin. But origin is fixed, so it is better
     *     to have a separate method in class to do this task
     *     Therefore, we use "fields" concept:
     *
     *     What are "Fields"?
     *         -- Fields are values available to the instance of class
     *         -- can be accessed outside the class
     *         -- are different from class parameters
     *         -- parameters are passed to the class while
     *            fields are already within the class
     *     -- In the following class, 'xOrigin and yOrigin' are fields
     *
     * --- Infix Notation:
     *     --- can be applied if the method takes only one argument
     *     --- This is an advantage for support DSL or Domain Specific Languages
     *     --- Method calls on class instance
     *     --- Method call without "." or parentheses
     *
     * */

    val point1 = new Coordinate2(3, 4)
    val point2 = new Coordinate2(-1, 1)
    println(point1.distance(point2))

    // compute distance from origin
    println(point1.originDistance)
    println(point2.originDistance)

    //fields can be accessed outside the class
    println(point1.xOrigin) // returns 0
    println(point1.yOrigin) // returns 0

    // practice infix Notation
    val c1 = new Coordinate2(1,2)
    val c2 = new Coordinate2(3,4)
    // dot and parentheses notation
    println(c1.distance(c2))
    // infix Notation
    println(c1 distance c2)
  }

}
class Coordinate2(val x: Double, val y: Double){

  val xOrigin = 0
  val yOrigin = 0

  def distance(c: Coordinate2): Double = {
    val xDistanceSquare = pow((x - c.x), 2)
    val yDistanceSquare = pow((y - c.y), 2)
    pow((xDistanceSquare + yDistanceSquare), 0.5)
  }

  def originDistance = {
    val origin = new Coordinate2(xOrigin, yOrigin)
    distance(origin)
  }
}

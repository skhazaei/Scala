package lectures.part1basics

import scala.annotation.tailrec
object defaultArgs extends App {

  @tailrec
  def trcFact(n: Int, acc: Int = 1): Int =
    if (n==1) acc
    else trcFact(n-1, n*acc)

  val fact5 = trcFact(5)
  println(fact5)

  def savePicture(format: String= "jpg", width: Int= 1920, height: Int= 1080): Unit =
    println("saving picture")

  /**
   * 1. pass in every leading argument
   * 2. name the argument
   */
  savePicture(width=800, height=1200, format="TIFF")
  savePicture("JPEG")
  savePicture(width=800)

}

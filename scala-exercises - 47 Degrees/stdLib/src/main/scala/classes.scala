object classes {
  def main(args:Array[String]) = {

    /**
     * The program defines an executable application Classes
     * in the form of a top-level singleton object with a main method.
     *
     * The main method creates a new Point and stores it in value pt.
     *
     */
    val pt = new point(1, 2)
    println(pt)

    ///
    val aClass = new ClassWithValParameter("Gandalf")
    println(aClass.name)
  }

}

class point(x: Int, y: Int) {
  override def toString(): String = "(" + x + "," + y + ")"
}

class ClassWithValParameter(val name: String)
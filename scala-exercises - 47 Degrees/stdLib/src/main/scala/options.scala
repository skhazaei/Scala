object options {
  def main(args:Array[String]) = {
    //val someValue: Option[String] = Some("I am wrapped in something")
    //println(someValue)

    def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
      if (flag) Some("Found value") else None
    }
    val value1 = maybeItWillReturnSomething(true)
    val value2 = maybeItWillReturnSomething(false)


    println(value1)
    println(value2)
    println(value1 getOrElse "No value")
    println(value2 getOrElse "No value")

    println(value2 getOrElse {
      "default function"
    })



  }

}

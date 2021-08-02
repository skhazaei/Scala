package lectures.part3fp

object Options extends App{

  // options are present in many places
  // map uses option in its basic operations
  val aMap: Map[String, String] = Map("key" -> "value")
  println(aMap("key")) // value
  println(aMap.get("key")) // Some(value)
  // println(aMap("other")) // code crashes
  println(aMap.get("other")) // None

  // lots of functions on all collections work with options
  val numbers: List[Int] = List(1, 2, 3)
  println(numbers.headOption) // Some(1)
  println(numbers.find(_ % 2 == 0)) // Some(2)

  // options are popular in scala because we want to avoid null pointer

  // options are invented to deal with unsafe APIs

  val myFirstOption: Option[Int] = Some(200)
  val noOption: Option[Int] = None

  println(myFirstOption) // Some(200)
  println(noOption) // None

  // Work with unsafe APIs
  def unsafeMethod(): String = null
  val result = Some(unsafeMethod())
  println(result) // Some(null) // this application is wrong
  val trueResult = Option(unsafeMethod())
  println(trueResult) // None

  // chained method
  def backupMethod(): String = "a valid result"
  val aChainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(aChainedResult) // Some(a valid result)

  // Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("a valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult) // Some(a valid result)

  // functions on option
  println(myFirstOption.isEmpty) // false
  println(myFirstOption.get) // 200 unsafe - Do not use it

  // map, flatmap, and filter
  println(myFirstOption.map(_ * 10)) // Some(2000)
  println(myFirstOption.filter(x => x < 10)) // None
  println(myFirstOption.filter(x => x> 10)) // Some(200)
  println(myFirstOption.flatMap(x => Option(10 * x))) // Some(2000)

  // for-comprehensions





}

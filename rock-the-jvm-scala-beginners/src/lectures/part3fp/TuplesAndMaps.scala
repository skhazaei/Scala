package lectures.part3fp

object TuplesAndMaps extends App{

  // tuples = "finite orders" ~ Lists

  val aTuple: (Int, String) = new Tuple2(1, "Hello Scala")
  println(aTuple) // (1,Hello Scala)

  val bTuple: (Int, String, Int) = new Tuple3(1, "Hello Scala", 3)
  println(bTuple) // (1,Hello Scala,3)

  val cTuple = Tuple6(1, 2, 3, "Tuple", 4, 10)
  println(cTuple) // (1,2,3,Tuple,4,10)

  val dTuple = (1, 2, 3, "Tuple", 4, 10)
  println(dTuple) // (1,2,3,Tuple,4,10)

  // print method
  println(dTuple.toString()) // (1,2,3,Tuple,4,10)

  // access Tuple members
  println(dTuple._1) // 1
  println(dTuple._2) // 2

  // copy method
  val eTuple = dTuple.copy(_6 = "Hello Scala")
  println(eTuple) // (1,2,3,Tuple,4,Hello Scala)
  println(eTuple.copy(_4 = "Goodbye Java")) // (1,2,3,Goodbye Java,4,Hello Scala)

  // swap method
  val fTuple = ("Hello Scala", 100)
  println(fTuple.swap) // (100, "Hello Scala")

  // Maps: associate keys with values keys -> values

  val aMap: Map[String, Int] = Map()
  println(aMap) // Map()

  val bMap = Map(("a", 1), ("b", 2), "c" -> 3)
  println(bMap) // Map(a -> 1, b -> 2, c -> 3)
  // a -> 1 is syntactic sugar for ("a", 1)

  // Map operations
  println(bMap.contains("a")) // true
  println(bMap.contains("A")) // false

  println(bMap("a")) // 1
  //println(bMap("A")) // it crashes

  val cMap = Map(("Mary",10), ("John", 12)).withDefaultValue(-1)
  println(cMap)
  println(cMap("Mary")) // 10
  println(cMap("David")) // -1

  // Maps are mutable
  val newPair = "Dara" -> 20
  val dMap = cMap + newPair
  println(dMap) // Map(Mary -> 10, John -> 12, Dara -> 20)

  // functions on Map
  // map, flatMap and filter

  val eMap = dMap.map(pair => pair._1.toLowerCase())
  println(eMap) // List(mary, john, dare)

  val fMap = dMap.map(pair => pair._2)
  println(fMap) // List(10, 12, 20)

  val gMap = dMap.map(pair => pair._1.toLowerCase() -> pair._2)
  println(gMap) // Map(mary -> 10, john -> 12, dara -> 20)

  // filter keys
  println(dMap.view.filterKeys(pair => pair.startsWith("J")).toMap) // Map(John -> 12)
  println(dMap.view.filterKeys(_.startsWith("M")).toMap) // Map(Mary -> 10)

  // mapValues
  println(dMap.view.mapValues(number => number * 100).toMap)
  // Map(Mary -> 1000, John -> 1200, Dara -> 2000)

  println(dMap.view.mapValues(_*100).toMap)
  // Map(Mary -> 1000, John -> 1200, Dara -> 2000)

  println(dMap.view.mapValues(number => "hey :D-" + number).toMap)
  // Map(Mary -> hey :D-10, John -> hey :D-12, Dara -> hey :D-20)

  // conversion to other collections
  println(dMap.toList) // List((Mary,10), (John,12), (Dara,20))

  val sList = List(("Maria", 120))
  println(sList.toMap) // Map(Maria -> 120)

  // groupBy

  val kList = List("Jim", "Jerry", "John", "Mary", "Maria", "David")
  println(kList.groupBy(names => names.charAt(0)))
  // HashMap(J -> List(Jim, Jerry, John), M -> List(Mary, Maria), D -> List(David))

  val mMap = Map("Jim" -> 500, "JIM" -> 1000).withDefaultValue(-1)
  val pMap = mMap.map(names => names._1.toLowerCase() -> names._2)
  println(pMap) // Map(jim -> 1000)
  // make sure that keys are not going to overlap otherwise we lose some data

  val oMap = Map(("a", Set(1, 2, 3)), ("b", Set(4, 5, 6)))
  println(oMap) // Map(a -> Set(1, 2, 3), b -> Set(4, 5, 6))
  val aVal = oMap("a")
  val bVal = oMap("b")
  println(aVal) // Set(1, 2, 3)
  println(bVal) // Set(4, 5, 6)
  println(aVal - 2) // Set(1, 3)
  println(oMap - "a") // Map(b -> Set(4, 5, 6))


  /*
  overly simplified social network based on Map
  person = String
       - add a person to the network
       - remove
       - friend (mutual)
       - unfriend
  */

  def add(network: Map[String, Set[String]], aPerson: String): Map[String, Set[String]] =
    network + (aPerson -> Set())

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(add(empty, "John"), "Jim"), "Sam")
  println(network) // Map(John -> Set(), Jim -> Set(), Sam -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] =
    {
      val friendsA = network(a)
      val friendsB = network(b)
      network + (a -> (friendsA + b)) + (b -> (friendsB + a))
    }
  val newFriends = friend(network, "Jim", "Sam")
  println(newFriends) // Map(John -> Set(), Jim -> Set(Sam), Sam -> Set(Jim))

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }
  val noFriend = unfriend(network, "Jim", "Sam")
  println(noFriend) // Map(John -> Set(), Jim -> Set(), Sam -> Set())

  def remove(network: Map[String, Set[String]], aPerson: String): Map[String, Set[String]] = {
    def auxRemove(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else auxRemove(friends.tail, unfriend(networkAcc, aPerson, friends.head))

    val unfriended = auxRemove(network(aPerson), network)
    unfriended - aPerson
    }


  val people = add(add(add(empty, "Bob"),"Mary"),"Jim")
  val jimBob = friend(people, "Jim", "Bob")
  val testNet = friend(jimBob, "Mary", "Bob")

  println(testNet) // Map(Bob -> Set(Jim, Mary), Mary -> Set(Bob), Jim -> Set(Bob))

  def nFriends(network: Map[String, Set[String]], aPerson: String): Int = {
    if (!network.contains(aPerson)) 0
    else network(aPerson).size
  }

  println(nFriends(testNet, "Bob")) // 2

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet)) // Bob

  def peopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)
    //network.count(pair => pair._2.isEmpty)
    //network.filter(k => k._2.isEmpty).size
    //network.view.filterKeys(k => network(k).isEmpty).toMap.size

  println(peopleWithNoFriends(testNet)) // 0

  val anotherNet: Map[String, Set[String]] = Map(("Bob", Set("Jim", "Mary")), ("Sam", Set()), ("Mary", Set()))
  println(anotherNet) // Map(Bob -> Set(Jim, Mary), Sam -> Set(), Mary -> Set())
  println(peopleWithNoFriends(anotherNet)) // 2

}

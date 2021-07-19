package lectures.part3fp

object MapFlatmapFilterFor extends App{

  val list = List(1, 2, 3)
  println(list) // List(1, 2, 3)

  println(list.head) // 1
  println(list.tail) // List(2, 3)

  // map
  println(list.map(n => n+1)) // List(2, 3, 4)
  println(list.map(_ + 1)) // List(2, 3, 4)
  println(list.map(_ + " is a number"))
  // List(1 is a number, 2 is a number, 3 is a number)

  // filter
  println(list.filter(_ % 2 == 0)) // List(2)

  // flatMap
  // flatMap applies the map function first then
  // the result is flattened creating single list

  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair)) // List(1, 2, 2, 3, 3, 4)

  // map
  println(list.map(toPair)) // List(List(1, 2), List(2, 3), List(3, 4))

  // print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val letters = List("a", "b", "c", "d")

  // "iterating"
  val combinations1 =numbers.map(n => (letters.map(c => c + n )))
  println(combinations1)
  // List(List(a1, b1, c1, d1), List(a2, b2, c2, d2), List(a3, b3, c3, d3), List(a4, b4, c4, d4))

  val combinations2 = numbers.flatMap(n => (letters.map(c => c + n)))
  println(combinations2)
  // List(a1, b1, c1, d1, a2, b2, c2, d2, a3, b3, c3, d3, a4, b4, c4, d4)

  val combinations3 = numbers.flatMap(n => (letters.flatMap(c => c + n)))
  println(combinations3)
  // List(a, 1, b, 1, c, 1, d, 1, a, 2, b, 2, c, 2, d, 2, a, 3, b, 3, c, 3, d, 3, a, 4, b, 4, c, 4, d, 4)

  val colors = List("Black", "White")
  val combinations4 = numbers.flatMap(n => (letters.flatMap(c => (colors.map( color => c + n + color)))))
  println(combinations4)
  // List(
  // a1Black, a1White, b1Black, b1White, c1Black, c1White, d1Black, d1White,
  // a2Black, a2White, b2Black, b2White, c2Black, c2White, d2Black, d2White,
  // a3Black, a3White, b3Black, b3White, c3Black, c3White, d3Black, d3White,
  // a4Black, a4White, b4Black, b4White, c4Black, c4White, d4Black, d4White
  // )

  // foreach
  list.foreach(println)
  // equivalent to:
  for {
    n <- list
  } println(n)


  // for-comprehensions
  val forComprehensions = for {
    n <- numbers
    l <- letters
    color <- colors
  } yield l + n + color
  println(forComprehensions) // equivalent to combinations4

  val forComprehensions2 = for {
    n <- numbers if (n%2 == 0)
    l <- letters
    color <- colors
  } yield l + n + color
  println(forComprehensions2)
  // List(
  // a2Black, a2White, b2Black, b2White,
  // c2Black, c2White, d2Black, d2White,
  // a4Black, a4White, b4Black, b4White,
  // c4Black, c4White, d4Black, d4White
  // )

  // equivalent to:
  val combinations5 = numbers.filter(_ % 2 == 0).flatMap(n => (letters.flatMap(c => (colors.map( color => c + n + color)))))


  // syntax overload
  list.map { n =>
    n + 1
  }





}

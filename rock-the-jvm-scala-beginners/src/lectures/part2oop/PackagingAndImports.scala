package lectures.part2oop
import playground.{Cinderella, PrinceCharming}

import java.sql.SQLDataException
// if the list of classes imported get long, then use:
// import playground._

import java.util.Date
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Jim", "RockTheJVM", 2018)

  // import package
  val princess = new Cinderella
  // another way of accessing Cinderella Class without importing is:
  // val prince = new playground.Cinderella
  // playground.Cinderella is called "fully qualified name"

  // packages are in hierarchy
  // matching folder structure

  // package object: can be only one per package
  // package objects hold standalone methods and constants
  sayHello

  val prince = new PrinceCharming

  // How about importing packages with the same name? like date
  // 1. use fully qualified name
  // 2. use alias name

  val date = new Date
 // val date = new sqlDate(2021, 07, 07)

  /**
   * default imports:
   * - java.lang : String, Exception, Objects
   * - scala: Int, Nothing, Function
   * - scala.Predef: println, ???
   */



}

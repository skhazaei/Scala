package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit ={
    println("called by value: " + x)
    println("called by value: " + x)
  }

  // the arrow in defining x tells the compiler
  // that is going to call by its name which is
  // another way of evaluating a parameter in
  // a function
  def calledByName(x: => Long): Unit ={
    println("called by name: " + x)
    println("called by name: " + x)
  }
  calledByValue(System.nanoTime())
  /** when is called by value, first System.nanoTime()
   * is evaluated so we would have for instance:
   * calledByValue(20679181383146) and then the number
   * in the function is passed and printed therefore, the
   * output will be:
   * called by value: 20679181383146
   * called by value: 20679181383146
   *
   * But in the case of called by name,
   * System.nanoTime() is exactly passed
   * to the function without being evaluated
   * and then in the function is going to be
   * evaluated. Therefore it prints different
   * time:
   * called by name: 20679303371994
   * called by name: 20679303577675
   *  */
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  // printFirst(infinite(), 5) // returns StackOverflowError
  // because infinite is first evaluated and the code got stock in it

  printFirst(12, infinite()) // this returns 12 because infinite is called by name
  // and in printFirst function is not evoke






}

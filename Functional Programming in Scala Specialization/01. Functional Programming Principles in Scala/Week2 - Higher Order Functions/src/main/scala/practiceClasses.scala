class Users1(var name: String, var age: Int )

class Users2(val name: String, val age: Int)

class Users3(private var name: String, private val age: Int)
{
  def printName {println(name)}
  def printAge {println(age)}
}

class Users4(name: String, age: Int)
{
  def printName {println(name)}
  def printAge {println(age)}

}

object practiceClasses
{

  def main(args: Array[String]) =
  {
    var member1 = new Users1(name="Tom", age=28)
    var member2 = new Users2(name="Mani", age=20)
    println(member1.name, member1.age)
    println(member2.name, member2.age)

    // let's change the name of Users1 member
    member1.name = "Sarah"
    println("name of member 1 changed to: " + member1.name)

    // Let's change the name of Users2 member
    // member2.name = 'Tara' returns error because
    // the constructors in the class Users2
    // are defined by 'val'

    var member3 = new Users3(name = "Ana", age =23)
    // Let's print the name of User3 member
    // println(member3.name) returns error
    // because name is a private variable
    // and we can not access outside the class
    // How we can access the private variables
    // outside of the class?
    // Using the method which is defined in the class
    member3.printName
    member3.printAge


    var member4 = new Users4(name ="Hanah", age=25)
    // both println(member4.name) and member4.name = "newName"
    // returns error. Because in class Users4, no keyword "var"
    // or "val" is set for members, and by default no getter
    // and setter method would be available for the members.
    // One can access "name" and "age" by defining the methods
    // inside the class like what we did for class Users3
    member4.printName
    member4.printAge



    /**            Summary
     *
     *  ----------  getter? - setter?
     *   var      |   yes   |  yes
     *   val      |   yes   |  No
     *   default  |   No    |  No
     *
     *  */



  }
}

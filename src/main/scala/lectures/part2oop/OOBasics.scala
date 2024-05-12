package lectures.part2oop


// video nr 10: Object-Oriented Basics
object OOBasics extends App {

  val person = new Person
   //println(person) // lectures.part2oop.Person@57829d67

  val person2 = new Person2("John", 26)
  // println(person2.age) // it will cause error
  // error occurs because, we have here class parameters, class parameters from the constructor and class fields that you can access are two different things
  // below i show how to fix it:

  val person3 = new Person3("John", 26)
  println(person3.age) // it will not cause error like above because of "val age: Int" in constructor, not just age: Int

  // the val definitions or the Var definitions inside the class implementations are fields.
  // So for example, I declared a value X equals two. I can actually use that as a field: println(person4.x)
  val person4= new Person4("John", 26)
  println(person4.x) // result:
  // 4
  // 2
  // notice that before the value two here, the value four was printed before. This was because println(1 + 3) from class body was also evaluated.
  // That is because at every instantiation of the class person, this whole block of code will be evaluated
  // That is, every single expression within and all side effects. For example, this println, will be executed.

  val person5 = new Person5("John", 26)
  person5.greet("Daniel")
  person5.greet()

}


//We can create simplest class as follows:
class Person

class Person2(name: String, age: Int) // constructor - every single instance of person must be constructed by passing in a name and an age.

// Now, the way that you would convert a class parameter to a field would be to add the Val or var keyword before the parameter.
class Person3(name: String, val age: Int)


class Person4(name: String, val age: Int) {
  // body - the body here is not an expression per se, but it defines the implementation of this class.  block of code inside can have basically everything//
  // including vars and vals, function definitions (we call them methods), expressions and even other definitions like packages, other classes and more complex stuff.

  val x = 2 // class can have vals and vars

  // They can have function definitions. We call them methods.

  // example expression
  println(1 + 3)


} // value of the code block (betwen {}) is ignored because this guy is only the implementation of this class.
//But remember that you can do anything inside this block that you can do in a block expression.


// take a notice that name is not class val/var, it is just class parameter, so we cannot use instance of class e.g. person5 to get name.
// you can use it only inside class scope, e.g. here for greet method. but you cannot access it outside of class definition
class Person5(name: String, val age: Int) {
  // body
  val x = 2

  println(1 + 3)

  // This function is called a method because it's defined inside a class definition .
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // $name, here, indicate name parameter from function, not from class,
                                                                           // to indicate $name (class parameter(or class val)) from class in this example,
                                                                           // you should use ${this.name}

  // overloading - Overloading means defining methods with the same name, but different signatures
  def greet(): Unit = println(s"i, I am $name") // not relevant if I use $name here or ${this.name}
  // Different signatures means different numbers of parameters or parameters of different types coupled with possibly different return types here at the end.

  //def greet(): Int = 42 // compiler will complain because if you call the method greet the compiler will not know which method you actually want

  // multiple constructors (or overloading constructors)
  // in many languages, for the same class, we can supply many constructors and in Scala we allow that too by using Def this.
  def this(name: String) = this(name, 0)
}

// better style of creating constructor than auxiliary constructor above is to use constructor with default parameter,
// in auxiliary constructor above we omitted the age parameter so this could be
//more easily solved by supplying a default parameter to the actual class definition.
class Person6(name: String, val age: Int = 0 ) { // here we use default parameter age = "0" and we don't need to create second constructor
  // body
  val x = 2

  println(1 + 3)
}



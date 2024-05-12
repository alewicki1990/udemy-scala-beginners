package lectures.part2oop


// video nr 12 Syntactic Sugar: Method Notations and 13 Method Notations (Exercises)
object MethodNotations extends App{

  //I'm creating the class person inside the object because otherwise it would conflict with the other class person that we wrote in the previous video
  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // above method definition needs space between ! and :, if I don't put in a space, then the compiler will think that this colon will be part of the method name
    def unary_! : String = s"$name, what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie" // method signature is very important here

    // functions for exercises from video 13
    // exercise 1
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie)

    // exercise 2
    def unary_+ : Person = new Person(name,favouriteMovie, age+1)

    // exercise 3
    def learns(topic: String): String = s"$name is learning $topic"

    def learns: String = this learns "Scala"

    // exercise 4
    def apply(numberOfTimes: Int): String = s"$name watched $favouriteMovie $numberOfTimes times"
    // apply methods are special because they allow you to call your objects like they were functions
  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent to above
  // this is called infix notation/operator notation and it only works with methods which have only one parameter.

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangoutWith tom) //  this method can also be used in an infix style because it receives a single parameter
  // I used the term operator earlier because in this case the method hangoutWith acts like an operator between Mary and Tom, which yields a string.
  // In this case, the string Mary is hanging out with Tom. So this guy acts like an operator between two things, yielding a third thing.

  // scala has an extremely permissive method naming scheme. We can rename method hangoutWith to + and it will still work ok.
  // Then above method will equivalent: println(mary + tom) or println(mary.+(tom))

  //another example of operators:
  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have such methods: ! ?

  // this style of writing methods of calling methods in infix notation is called syntactic sugar
  // Syntactic sugars are nicer ways of writing code that are equivalent to more complex or more cumbersome ways of writing code.

  // prefix notation - another form of syntactic sugar
  val x = -1 //  this negative sign over here is a unary operator. Unary operators are also methods
  val y = 1.unary_- // equivalent to above. unary operators are actually methods with unary_ prefix
  // unary_ prefix only works with - + ~ (tilda) ! (bang)

  // we use ! method from Person class for these 2 below equivalent methods
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  // The functions that do not receive any parameters can be used in a postfix notation
  println(mary.isAlive)
  //println(mary isAlive) // - to run this postfix operation "isAlive" we need to make implicit value scala.language.postfixOps visible

  // in practice we often use the dot notation, this one because the space notation, the postfix notation
  // can introduce potential ambiguities when reading the code not to the compiler but to us as humans.

  // postfix operator notation is only available to methods without parameters

  // apply - we'll define method apply() in Person class
  println(mary.apply())
  println(mary()) // equivalent to above
  // whenever the compiler sees an object being called like a function, it actually looks for a definition of apply() in that particular class.

  /*
    1. Overload the + operator - I want you to add another plus operator which receives a string, and it will return a new person with a nickname
       e.g. mary + "the rockstar" => new person with name "Mary (the rockstar)"
    2. Add an age to the Person class with default zero value
       Add a unary + operator which increments the value of the age and returns a new person with age plus one
       e.g. +mary => mary with the age incrementer
       This resembles the prefix ++ operators that you've probably seen in Java or C++.
    3. Add a "learns" method in the Person class. This receives a string parameter and returns a sentence which says: Mary learns XXX e.g. Mary learns Scala
       Add a learnsScala method which doesn't receive any parameters and calls the learns method with "Scala" as a parameter. use it in postfix notation
    4. Overload the apply method to receive a number and returns a string.
       mary.apply(2) => "Mary watched $hereFavouriteMove' 2 times"
   */

  // exercise 1:
  println("New person with name " + (mary + "the rockstar").name) // + in parenthesis is here method from mary class

  // exercise 2:
  println("marys age: " + mary.age)
  println("new marys age after + method call: " + (+mary).age) //+mary - this is prefix notation

  // exercise 3:
  println(mary learns "Java")
  // takeaway:
  // mary learns "Java"
  // is infix notation with 3 elements:
  // object method parameter - infix notation (it only works for methods with one parameter)
  // where:
  // mary is object
  // learns is method
  // "Java" is parameter

  println(mary.learns) // should be: mary learns, but I don't want to make implicit value scala.language.postfixOps visible. this unused way is called postfix notation

  // exercise 4:
  println(mary(5)) // apply() is special because it allow you to call objects like functions
}
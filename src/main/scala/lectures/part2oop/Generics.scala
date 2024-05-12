package lectures.part2oop

// video nr 18: Generics
object Generics extends App {

  // MyList[A] is generic class. A - the name of a type parameter.
  class MyList[A] {
    // the way that we do that in the Scala generics world would be to define a class mylist parameterized with a Type A, like I wrote here
    // So the type A here in between square brackets denotes a generic type and once you define that, you can use the type A inside the class definition.

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //this also works with trait
  trait MyListTrait[A]{
    // use the typa A
  }

  //another example with 2 parameters
  class MyMap[Key, Value]

  // generic methods
  // this is companion object for MyList. Objects cannot be typed parameterized
  object MyList {
    // This is the method called empty type parameterized with A and this will return a MyList parameterized with A.
    def empty[A]: MyList[A] = ??? // This is how you define a method signature type parameterized with a generic type parameter
  }

  val emptyListOfIntegers = MyList.empty[Int]


  // variance probleem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // If Cat extends animal does a list of cat also extend list of animal?
  // there are 3 possible answers:
  // 1. yes - List[Cat] extends List[Animal] = this behaviour is called COVARIANCE
  class CovariantList[+A] // this is the way that you declare a covariant list. +A means that this is covariant list

  // the way that you would use polymorphism for cats and animals you will use for list of cat and list of animal
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION That's not a trivial question because animal list is defined to be a list of animals.
  // So in theory I should be able to add any animal, but adding a new dog to an animal list, which is in fact a list of cats, would actually pollute the list of animals here.

  // 2. no - list of cat and list of animal are two separate things
  // this behaviour is called INVARIANCE
  class InvariantList[A] // this is the way that you declare a invariant list. A means that this is invariant list.
  // So I'm defining an invariant list class here is to simply specify the type parameter without any signs before or after it

  // Invariant classes are each in its own world and you cannot substitute one for another.
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // causes error

  // 3. Hell, no! - This third option is very counterintuitive, and it's basically the opposite relationship.
  // this behaviour is called CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]


}

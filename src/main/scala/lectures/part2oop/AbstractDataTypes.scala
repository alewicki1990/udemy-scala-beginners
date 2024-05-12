package lectures.part2oop

// video nr 13: Method Notations (Exercises)
object AbstractDataTypes extends App{

  //abstract
  // There are situations where you need to leave some fields or methods blank or unimplemented.
  // Classes which contain unimplemented or abstract fields or methods are called abstract classes
  abstract class Animal {
    val creatureType: String // I'm not supplying a value here on the right hand side, that means this value is abstract.
    val creatureType2: String = "wild" // non abstract member, non abstract value
    def eat: Unit // abstract method
  }

  // abstract classes cannot be instantiated
  // val animal = new Animal // error

  // Basically, abstract classes and abstract data types are made to be extended later
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // traits
  // traits by default, like abstract classes have abstract fields and methods.
  trait Carnivore {
    def eat(animal: Animal): Unit // abstract member
    val preferredMeal: String = "fresh meat" // non abstract member, non abstract value
  }

  trait ColdBlooded

  // Unlike abstract classes, traits can be inherited along classes
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    override val creatureType2: String = "wild croc 2"
    val eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // both abstract classes and traits have both abstract and non abstract members
  //  trait Carnivore {
  //    def eat(animal: Animal): Unit // abstract member
  //    val preferredMeal: String = "fresh meat" // non abstract member, non abstract value
  //  }

  // how are traits actually different from abstract classes?
  // 1 - traits cannot have constructor parameters, so traits do not have constructor parameters

  // this will not compile
//  trait Carnivore(name: String) {
//    def eat(animal: Animal): Unit // abstract member
//
//    val preferredMeal: String = "fresh meat" // non abstract member, non abstract value
//  }

  // 2 - multiple traits may be inherited by the same class. You can only extend one class, but you can mix in multiple traits

  // 3 - we choose a trait (versus an abstract class) if it describes a type of behavior.
  // E.g. here we use name of trait "Carnivore" because it describes the type of things that eat animals.
  // Abstract class describes a type of thing e.g. Animal
  // IMO these examples are totally wrong....


  // at the end of this video there is description of all Scala types:
  // scala.Any
  // scala.AnyRef
  // scala.Null
  // scala.AnyVal
  // scala.Nothing


}

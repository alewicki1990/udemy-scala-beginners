package lectures.part2oop

// video nr 16: Inheritance, Continued: Abstract Classes and Traits
object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat: Unit = println("nomnom")

    // if method will be private like below subclasses will not use it
    // private def eat = println("nomnom")

    protected def eat2: Unit = println("eat2: nomnom nomnom")
    final def eat3: Unit = println("eat2: final nomnom")
  }

  // Cat is subclass of Animal
  // Animal we call superclass of Cat
  class Cat extends Animal {
    def crunch = {
      eat2
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.eat // valid expression

  // we cannot access eat2 method like below
  //cat.eat2
  // but we can access crunch method which uses eat2 superclass method
  cat.crunch

  // Access modifiers that you can have in Scala are private protected and no modifier, which by default means public.
  // That means anyone can access this method once this class is accessible.

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  // class Adult(name: String, age: Int, idCard: String) extends Person
  // this code will not compile and the compiler will complain that we have unspecified value parameters: name and age.
  // This code does not compile because when you instantiate a derived class, in this case adult, JVM will need to call a constructor from a parent class first.
  // It needs to call a constructor of person before you call the constructor of adult.
  // Scala compiler forces you to guarantee that there is a correct super constructor to call when using such a derived class.

  // Now, this call compiler forces you to guarantee that there is a correct super constructor to call when using such a derived class.
  //So you must pass in the correct arguments.
  // Otherwise the compiler will look for and in this case fail to find a constructor that looks like this, like the one you provided.
  // So in this example, the constructor person with no parameters does not exist, so you need to pass in the correct parameters like name and age.
  // This is the correct way of extending a class with parameters:
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // This is also valid because the compiler found auxiliary constructor with just the name for the superclass.
  class Adult2(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat = println("crunch, crunch")
  }

  val dog = new Dog
  dog.eat // we see crunch, crunch value instead of nomnom
  println(dog.creatureType) // we see domestic value instead of wild

  // fields as opposed to methods have the special property that they can be overridden directly in the constructor as well
  // this is a valid definition of the class dog with the creature type field directly overridden in the constructor as a class parameter.
  class Dog2( override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    override def eat: Unit = println("eat2")
    override def eat2: Unit = println("crunch, crunch2") // now eat is public and not protected
  }

  val dog2 = new Dog2("K9")
  dog2.eat2
  println(dog2.creatureType) // we see domestic value instead of wild

  // we can create above class Dog2 different above way but it will be same thing:
  class Dog3(dogType: String) extends Animal {
    override val creatureType: String = dogType
  }

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog2("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING
  // overRIDING - which means supplying a different implementation in derived classes.
  // overLOADING - which means supplying multiple methods with different signatures but with the same name in the same class.

  // super
  class Dog4(override val creatureType: String) extends Animal {
    override def eat: Unit = {
      super.eat
      println("eat2")
    }
  }

  // preventing overrides
  // 1 - use final on class member
  // 2 - use final on the entire class
  // 3 - seal the class

  // ad1 - this will cause error because eat3 is final in superclass
//  class Dog4(override val creatureType: String) extends Animal {
//    override def eat3: Unit = {
//      super.eat
//      println("eat2")
//    }
//  }

  // ad2 - you cannot extend such class as below
  final class Animal2 {
    val creatureType = "wild"
    def eat: Unit = println("nomnom")
  }

  // impossible
//  class Cat2 extends Animal2 {
//    def crunch = {
//      eat2
//      println("crunch crunch")
//    }
//  }

  // ad3 - sealing the class is a software restriction in that you can extend classes in THIS FILE. It prevent extension in other files.
  // The sealed keyword is often used when you want to be exhaustive in your type hierarchy.
  // For example, if the only two possible animals in this world would be cats and dogs, then you
  // would normally use a sealed class animal and extend cat and dog in this file and prevent animal from being extended in other files.
  // Because cats and dogs are the only types that you can have.
  sealed class Animal3 {
    val creatureType = "wild"
    def eat: Unit = println("nomnom")
  }
}

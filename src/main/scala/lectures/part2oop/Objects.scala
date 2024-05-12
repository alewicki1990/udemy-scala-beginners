package lectures.part2oop

// video nr 14: Scala Objects
object Objects extends App {
  // One of the fundamental aspects of object oriented programming is something that we call class level functionality.
  // That means functionality that does not depend on an instance of a class.
  // If you've noticed, everything that we have written so far had a connection to an instance of some class at any given point.
  // Now there are cases where we really shouldn't need to do that.
  // For example, universal constants or universal functionality that we should be able to access without relying on an instance of some class.

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (concept of "static" like in below Person class example)
  // Scala actually has something even better. And it's called objects. So an object can actually have this kind of static like functionality.
  //
  /*
        public class JavaPlayground {
            public static void main(String[] args) {
                System.out.println(Person.N_EYES);
            }
        }

        class Person {
            public static final int N_EYES = 2;
        }
   */

  // below object is equivalent in Scala for that little Java code that we wrote in JavaPlayground class and which is copied above.
  // To use class level definition in Scala we use objects.
  // Objects can be defined in a similar way that classes can, with the exception that objects do not receive parameters.
  object Person { // type + its only instance
    // you can define vals vars and methods inside objects and you can access them as you would in a class level setting. Object cannot have parameters.

    // "static/class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method, very popular, object can create instance of class
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  // note that an object can have values or vars and can also have method definitions. But it cannot take parameters

  // Pattern that's often used in practice is that we write objects and classes with the same name.
  // So class Person in the same file or even in the same scope for practical reasons.
  class Person(val name: String) {
    // instance-level functionality
  }
  // This pattern of writing classes and objects with the same name in the same scope is called COMPANIONS.
  // The class person and the object person are companions because they reside in the same scope and have the same name.

  println(Person.N_EYES)
  println(Person.canFly)

  // In Scala we use an object as a singleton instance.
  // Scala object = SINGLETON INSTANCE
  // when I define the object person, I basically define its type, but I also define its only instance.
  val person1 = Person // this thing is an instance of Person type which is the only instance that this Person type can have.
  val person2 = Person
  println(person1 == person2 ) // same object == true

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // not same object != true

  val bobbie = Person(mary, john) // in other words: val bobbie = Person.apply(mary, john)

  // Scala Applications - Scala object with very, very important and very particular method:
  // def main(args: Array[String]): Unit
  // This method have to be Java virtual machine applications entry point
}

package lectures.part2oop

// video nr 11: Object-Oriented Basics (exercises)
// my solution
object OOBasicsExercises extends App {
  /*
    1. Exercise 1
    Novel and a writer class. A novel means a book, and a writer is the one writing the novels.
    Writer: first name, surname, year of birth
      - method: fullname - returns concatenation of name and surname

    Novel: name, year of release, author (which is instance of type Writer)
      - method: authorAge which returns the age of the author at the year of release
      - method: isWrittenBy(author)
      - method: copy (new year of release) = new instance of Novel with new year of release
    2. Exercise 2
    Counter class
      - receives an int value
      - method: currentCount - which returns current count
      - method: to increment/decrement the counter by one => these guys will return new Counter
      - overload inc/dec methods to receive parameter which is the amount by which you increment or decrement the counter => result will be new Counter
   */

  val writerBoleslawPrus = new Writer("Aleksander", "Głowacki", 1847)

  val kamizelka = new Novel("Kamizelka", 1882, writerBoleslawPrus)

  println(writerBoleslawPrus.fullName)

  println(kamizelka.authorAge)

  println(kamizelka.isWrittenBy("Bolesław Prus"))
  println(kamizelka.isWrittenBy("Aleksander Głowacki"))

  val kamizelka2 = kamizelka.copy(1990)
  println(kamizelka2.authorAge)

  val counter = new Counter()
  counter.increment().print
  counter.increment().increment().increment().print
  counter.increment(10).print
  counter.print


}

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: String): Boolean = this.author.fullName == author

  def copy(yearOfRelease: Int): Novel = new Novel(name, yearOfRelease, author)
}

// In practice, the way that we reunite a field with a method that just returns that field, basically
// a getter is to define a val.
class Counter(val value: Int = 0) {

  // This is very important. The fact that we're returning a new Counter rather than modifying the current count in this instance
  // is called immutability and is the same principle with declaring vals for primitive types but extend it to objects and to classes.
  //This is extremely important in functional programming. This basically says that instances are fixed. They cannot be modified inside.
  //Whenever you need to modify the contents of an instance, you actually need to return a new instance.
  //This is an incredibly important concept and we're going to use it a lot in this course and you're going to need it a lot in your Scala code in the future.
  def increment(): Counter = {
    println("incrementing")
    new Counter(value + 1)
  }

  def decrement(): Counter = {
    println("decrementing")
    new Counter(value - 1)
  }

  def increment(n: Int): Counter = {
    if (n <= 0)
      println("n <= 0: " + n)
      this
    else
      println("increment(n: Int), where n is counter, n=" + n)
      increment().increment(n - 1)
  }

  def decrement(n: Int): Counter = {
    if (n <= 0)
      println("n <= 0: " + n)
      this
    else
      println("decrement(n: Int), where n is counter, n=" + n)
      decrement().decrement(n - 1)
  }

  def print = println(value)

}

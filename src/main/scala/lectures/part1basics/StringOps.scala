package lectures.part1basics


// video nr 9: Smart Operations on Strings
object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) // will return: l
  println(str.substring(7, 11)) //  first parameter is inclusive and second exclusive. it will return: I am
  println(str.split(" ")) // will return an array of all substrings: [Ljava.lang.String;@3d24753a
  println(str.split(" ").toList) // will return list which will be little more prettier: List(Hello,, I, am, learning, Scala)
  println(str.startsWith("Hello")) // will return: true
  println(str.replace(" ", "-")) // will return: Hello,-I-am-learning-Scala
  println(str.toLowerCase()) // will return: hello, i am learning scala
  println(str.length) // will return: 26

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  // +: this is prepending operator,
  // :+ this is appending operator
  println('a' +: aNumberString :+ 'z') // will return: a45z, scala specific utility function
  println(str.reverse) // will return: alacS gninrael ma I ,olleH, scala specific utility function
  println(str.take(2)) // will return: He

  // Scala-specific things: String interpolators.

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old" //  this dollar sign tells the compiler that name will be injected in the string
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old" // we can do evaluate complex expressions inside {}. here is example of sum: ${age + 1}
  println(anotherGreeting)

  // F-interpolators
  // f interpolators act as s interpolators in the sense that they can expand values or complex expressions inside, but they can also receive printf like formats.
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute" // here we use $speed%2.2f and because of that we can see such string printed: 1,20.
  // %2.2f  means two characters total minimum and two decimals. For 0 we'll get 0,00
  // %s means string format
  println(myth)

  // f interpolated strings also have the amazing property that they can also check for type correctness in the values that they expand.
  // check such example:
  val x = 1.1f // f - value is float
  //val str = f"$x%3d" // %3d - this format requires Int. - if the types don't match, the compiler will issue an error, because x is float


  // raw-interpolator - works the same as the S-interpolator. Although it has the property that can print characters literally
  println(raw"This is a \n newline") // will return literally: This is a \n newline
  val escaped = "This is a \n newline"

  println(raw"$escaped")
  // this println will return:
  // This is a
  // newline

}
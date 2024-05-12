package lectures.part1basics


// video nr 2 (there was no files for video nr 1) 
object ValuesVariablesTypes extends App {


  //val x: Int  = 42
  val x = 42 // alternative to "val x: Int  = 42", type of val is optional because scala can infer the type of x, we prefer to use code without types
  println(x)
  // TYPES OF VALS ARE OPTIONAL, COMPILER can infer types

  // x = 2 - it will give us error because:
  // VALS ARE IMMUTABLE

  val aString: String = "hello"

  val aString2: String = "hello"; // semicolons (;) are allowed in scala
  // but we don't use them, we need to use them if we have multiple expressions on the same line:
  val aString3: String = "hello"; val anotherString = "goodbye"
  // but we don't write such code because it's anti pattern

  val anotherSting = "goodbye"

  val aBoolean: Boolean = false; // Boolean can use only true/false values
  val aChar: Char = 'a'
  val anInt: Int = x // you can give val value of another val
  val aShort: Short = 12354
  val aLong: Long = 1433499954466565345L // to mark number as long we always need to use 'L' as a suffix,
  // without 'L' compiler will think that our number (on right side of expression) is Int, and it'll complain
  val aFloat: Float = 2.0f // to mark number as float we always need to use 'f' as a suffix,
  // without 'f' compiler will think that our number (on right side of expression) is Double, and it'll complain
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  // variables (var) can be reassigned, VARIABLES ARE MUTABLE
  aVariable = 5; // side effects
  // side effects are useful because they allow us to see what our programs are doing.
  // Examples of side effects are, for example, changing a variable, like here we're printing something to the console or displaying something on screen.

  // Programs without side effects are easier to understand, as we will see in this course because there
  // are no variables and logic to keep track of.
  // However, we cannot really eliminate side effects completely because we need our programs to do something
  // to the world.

  var aVariableWithInferredType = 4

  //functional programming involves working less with variables, so we'll start thinking more in terms
  //of VALs rather than VARs, and you'll learn this style of thinking along the way.

}

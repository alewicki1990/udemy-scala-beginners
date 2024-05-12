package lectures.part1basics

// video nr 8: Default and Named Arguments
object DefaultArgs extends App {

  // here w set default value as argument for parameter named acc,
  // thanks to this we can use such function call trFact(10), instead of trFact(10, 1)
  // trFact is shortcut name for tail recursive factorial
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10)

  // nothing stops us to run such function also if we want to:
  val fact10acc2 = trFact(10, 2) // default value of 1 will be overwritten

  // Values for parameters are useful for the case where your functions are called many, many, many times with the same parameters.

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  // savePicture(800) // will fail
  // savePicture((800,600)) // will fail
  /*
    to fix 2 above lines of code we have 2 solutions:
    1. pass in every leading argument. E.g.: "jpg",800 or "jpg",800,600
    2. name the arguments
   */

  // ad1
  // savePicture(800) // will fail, because if we'll pass in a parameter the compiler will think that 800 is the first parameter of save picture and at this moment it's confused.
  savePicture("jpg",800) // it will run if we'll type in first string argument

  // ad2
  // savePicture(800) // will fail
  savePicture(width = 800) // it will also run if we'll type in first string argument, here we emphasize that we pass in value for parameter named width

  // different order of arguments - permissible
  savePicture(height=600, width=800, format="bmp") // we can also type in argument values in different order if we'll emphasize which value is assigned to which parameter

}
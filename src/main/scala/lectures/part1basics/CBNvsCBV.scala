package lectures.part1basics

// video nr 7: Call-by-Name and Call-by-Value
object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // This little arrow here tells the compiler that the parameter will be called by name
  // This is a different evaluating parameters in functions.
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  // Here using calling by value System.nanoTime() is evaluated firstly and then its value is used by println functions
  // result:
  // by value: 267655673404400
  // by value: 267655673404400
  // code done by jvm was similar to below in this case:
  // def calledByName(x: => Long): Unit = {
  //    println("by name: " + 267655673404400)
  //    println("by name: " + 267655673404400)
  //  }


  calledByName(System.nanoTime())
  // Here using call by name System.nanoTime() is evaluated with delay, that's mean
  // - every time when println method call it, it's called 2 times, firstly by 1st println and second by 2nd print.
  // Time goes on and result of for every System.nanoTime() is different for each println method
  // result:
  // by name: 267655772027999
  // by name: 267655773665600
  // these two values are different because here code in calledByName(x: => Long) function is equal to:
  // def calledByName(x: => Long): Unit = {
  //    println("by name: " + System.nanoTime())
  //    println("by name: " + System.nanoTime())
  //  }
  // So System.nanoTime() gives us different result every time we call this function which is obvious


  // Calling by name is extremely useful in lazy streams and in things that might fail.

  // infinite recursive function - dumb function. nobody would use it, but just for the sake of proving the "by name" concept
  def infinite(): Int = 1 + infinite()

  // another function, for checking how by name and by value functions works
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(),34) // it will crash with a stack overflow error of course

  printFirst(34, infinite()) //  as we said, the by name parameter (y: => Int) delays the evaluation of the expression passed here until it's used.
  // since the parameter y is not used, this guy is never actually evaluated, which is why our program seems to survive.

}

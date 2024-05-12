package lectures.part1basics

import scala.annotation.tailrec

// video nr 6 (there was no coding in video nr 5)
object Recursion extends App {

  // this function is recursive
  // Technical detail: In order to run a recursive function, the Java virtual machine, on top of which Scala runs, uses
  // a call stack to keep partial results so that it can get back to computing the desired result.
  // So each call of the recursive function uses what we call a stack frame.
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(10))
  //println(factorial(5000)) // will return stack overflow error

  // smarter way of above function which will not cause stack overflow if input number argument is high.
  def anotherFactorial(n: Int): BigInt = {
    @tailrec // to check if this function is TAIL RECURSION we can use this annotation, if it isn't we'll get error.
    // We can also inform developers about tail recursion this way.
    // auxiliary function
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION - use recursive call as the LAST expression

    factHelper(n, 1)
  }

  println(anotherFactorial(10))
  // how this code will work?
  /*
      anotherFactorial(10) = factHelper(10, 1)
      = factHelper(9, 10 * 1)
      = factHelper(8, 9 * 10 * 1)
      = factHelper(7, 8 * 9 * 10 * 1)
      = ...
      = factHelper(2, 3 * 4 * ... * 10 * 1)
      = factHelper(2, 2 * 3 * 4 * ... * 10 * 1)
      = accumulator = 1 * 2 * 3 * 4 * ... * 10
   */
  // this way of writing the recursive function actually works with a big number, we'll not get stack overflow, so above example for 5000 will work ok, even 20000 will work ok
  // (but we need to use BigInt instead of Int)

  // So the question is, why does anotherFactorial work and why doesn't the first one (factorial) work?
  // The trick here is that we wrote factHelper right over here as the last expression of its code path.
  // This allows Scala to preserve the same stack frame and not use additional stack frames for recursive calls.
  // In the previous implementation, Scala needed a recursive call stack frame for each recursive call so
  // that it computes the intermediate result so that it can then multiply it with a number and then pass it back from the stack.
  // But here it doesn't need to. The Scala doesn't need to save intermediate results to be used later.
  // So when you evaluate this recursive call, the current stack frame,
  // for example factHelper(10) is replaced with factHelper(something else) without using extra stack memory.
  // This is called TAIL RECURSION

  // The trick here is to use these little accumulators to store intermediate results rather than call the function recursively.
  // You need as many accumulators as you have recursive calls on your code path.
  // Sometimes you need more than one accumulators.
  // This is a hint.


  println(anotherFactorial(20000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.
  // Now on, we'll try to make our recursive methods tail recursive because that's how we can actually achieve the
  // iteration versus recursion approach that we talked about in the previous videos.
  // Any function can be turned into a tail recursive function.

  /*
    1. Concatenate a string n times using tail recursion
    2. isPrime function, tail recursive
    3. Fibonacci function, tail recursive
   */

  def stringConcatenation(baseString: String, numberOfConcatenations: Int): String = {
    @tailrec
    def concatenationHelper(baseString: String, numberOfConcatenations: Int, concatenatedStrings: String): String =
      // concatenatedStrings is accumulator there and it should have same type as returning value
      if(numberOfConcatenations <= 0) concatenatedStrings
      else concatenationHelper(baseString, numberOfConcatenations-1, concatenatedStrings + baseString)

    concatenationHelper(baseString, numberOfConcatenations, "")
  }

  println(stringConcatenation("Number", 3))

  // analyze: firstly check which situation should return true, which false, which should continue iteration and which should stop iteration
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      // isStillPrime is accumulator
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(6))
  println(isPrime(7))


  // Here we have 2 accumulators
  // General rule of thumb is however many recursive calls you have on the same code path.
  // That's how many accumulators you need to have in the tail recursive function version of the function that you want to implement.
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n)
        println("last=" + last)
        last
      else
        println("i+1=" + (i + 1) + " nextToLast=" + nextToLast + " last=" + last + " last+nextToLast=" + (last + nextToLast))
        fiboTailrec(i + 1, last + nextToLast, last)

    if(n<=2) 1
    else fiboTailrec(2,1,1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13
}
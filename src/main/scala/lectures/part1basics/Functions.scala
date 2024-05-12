package lectures.part1basics


// video nr 4
object Functions extends App {

  // def is keyword for defining a function
  def aFunction(a: String, b: Int): String = { // we can use block here or not
    a + " " + b
  }

  def bFunction(a: String, b: Int): String =
    a + " " + b

  // here is example how we call function
  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  // println(aParameterlessFunction) - we can call parameterless function like this in scala 2 but in scala 3 not


  // proper way of looping over data using recursive function which works like loop and is not for or while loop (which are prohibited in functional programming)
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION. - this is fundamental idea of functional programming

  // compiler can infer the type of function so we don't need to type it
  def aFunctionWithoutReturnType(a: String, b: Int) = {
    a + " " + b
  }
  // but the best practice is to always specify return type of functions nonetheless

  // you cannot omit return value type for recursive functions because compiler will complain.
  /*
    def aWrongRepeatedFunction(aString: String, n: Int) = {
      if (n == 1) aString
      else aString + aWrongRepeatedFunction(aString, n - 1)
    }
    println(aWrongRepeatedFunction("hello", 3))
  */

  // You can use Unit as return type. That means you define a function as only executing side effects.
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    // code block allows us to define auxiliary things inside like values, variables and now auxiliary functions:
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old" - use name Dawid and 12 in your test
    2. Factorial function 1 * 2 * 3 * .. * n
    3.  A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
    4. Tests if a number is prime
   */

  // my solution for exercise 1
  def greeting(name: String, age: Int): String =
    s"Hi, my name is $name and I am $age years old"


  println(greeting("Dawid", 12))

  // my solution for exercise 2
  def factorial(number: Int): Int =
    if (number <= 0) 1
    else factorial(number - 1) * number

  println(factorial(5)) // for 5 result will be 120

  // teachers solution for exercise 3
  def fibonacci(number: Int): Int =
    if (number <= 2) 1
    else fibonacci(number - 1) + fibonacci(number - 2)

  println(fibonacci(8)) // result for 8 should be 21

  // my solution for exercise 4
  def isNumberPrime(number: Int): Boolean = {
    def isNumberDivisible(checkedNumber: Double, denominator: Double): Boolean = {
      if (denominator != 1) {
        (checkedNumber % denominator) == 0 | isNumberDivisible(checkedNumber, denominator - 1)
      }
      else false
    }

    if (number == 1) true
    else !isNumberDivisible(number, number / 2)
  }

  println(isNumberPrime(37)) // prime
  println(isNumberPrime(2003)) // prime
  println(isNumberPrime(37 * 17)) // not prime

  // teachers solution for exercise 4
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37)) // prime
  println(isPrime(2003)) // prime
  println(isPrime(37 * 17)) // not prime
}

package lectures.part1basics

// video nr 3
object Expressions extends App {
  val x = 1 + 2 // 1 + 2 is EXPRESSION
  // Expressions are evaluated to a value in this case three, and they have a type in this case INT
  // COMPILER can infer types of expressions
  println(x)

  println(2 + 3 * 4) // Math expressions preserve the operation ordering we've been taught in school. So multiplication (3 * 4) is done first, then the addition.
  // Math operators are: + - * / & | ^ << >> >>> (right shift with zero extension)

  print(x == 1)
  // relational operations: == != > >= < <=

  println(!(1 == x))
  // boolean operators: ! && ||

  // operators for changing variables
  var aVariable = 2
  aVariable += 3 // also works with -= *= /= .......  but remember: changing a variable is called side effect, so these are all side effects.
  println(aVariable)

  // Instructions/Statements (DO) vs Expressions (GIVE ME VALUE)

  // INSTRUCTION is st that you tell the computer TO DO. For example, change a variable, print to the console, do this or do that.
  // In imperative languages like Java you work with instructions
  // By contrast, an EXPRESSION is something that has a value or and or a type.
  // In Scala and in functional programming in general, we'll think in terms of expressions. That is, every single bit of your code will compute a value.

  // IF expression in Scala, acts in a very, very different way than in most other languages.
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION, not an if instruction
  // So notice that unlike other languages where you would say if a condition do something that is set the value of five, otherwise set the value of three.
  // The if expression gives back a value. That's why it's called an if expression, not an if instruction.
  print(aConditionedValue)
  println(1 + 3)
  println(if (aCondition) 5 else 3) // if statement evaluates like 1 + 3, this mean this is expression, not instruction



  // there are loops (while, for) in Scala, but we discourage using them because they're reminiscent of imperative programming like Java.
  // They don't really return anything meaningful and only execute side effects.
  // here is example:
  // NEVER WRITE THIS AGAIN:
  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }
  // EVERYTHING in Scala is an Expression! Scala forces everything to be EXPRESSION, not INSTRUCTION! SO NEVER WRITE THIS AGAIN
  // Only definitions like the definition of a Vals or a class or a package are not expressions,
  // but everything else is: Operations, Calling Functions, If Expressions, every single thing. Even reassigning a variable is expression, it just doesn't return anything meaningful.

  // even expression "aVariable = 3" has it's own value which is unit
  val aWeirdValue = (aVariable = 3) // Unit == void in another languages
  println(aWeirdValue) // will return (), parenthesis parenthesis which is only value which unit type can hold

  // side effects in Scala are actually expressions returning unit.
  // side effects examples: println(), whiles, reassigning
  // Side effects are reminiscent of imperative programming. That is, they are like instructions but in Scala they're still expressions returning unit.

  // Code blocks (are also expressions). The value of the block is the value of its last expression.
  // Even the fact that I put code block on the right hand side of a value definition should tell you that this guy is an expression.
  val aCodeBlock = {
    val y = 2
    val z = y + 1 // these 2 lines are auxiliary definitions. variables y and z will be not visible outside code block
    if (z > 2) "hello" else "goodbye" // the value of this whole block is the value of this if expression because it occurs last
  }


  // Exercises
  // 1. difference between "hello world" vs "println("hello world")

  // exercise solution:
  // "hello world" is  value of type string
  // println("hello world") is expression which is side effect of type Unit

  // 2. What's the value of this:

  val someValue = {
    2 < 3
  }

  // exercise solution: true (Boolean)

  // 3. What's the value of this:
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  // exercise solution: 42 (Int)

}

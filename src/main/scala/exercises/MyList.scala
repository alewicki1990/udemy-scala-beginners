package exercises

// video nr 17: Inheritance Exercises: Implementing Our Own Collection
abstract class MyList  {
  /*
    We're going to create an abstract class which describes a list of integers.
    This list will be a singly linked list which holds integers and it will have the following methods.
    methods named:
    head - will return an int, which is going to be the first element of this list
    tail - which is the remainder of the list
    isEmpty - boolean, is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list

    I want you to add these methods in two or more or however many you decide subclasses or subtypes of this MyList abstract class.
    But first, decide on the method signatures for each of these methods and then implement them in their subtypes.

   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}


object Empty extends MyList {
  //def head: Int = ??? // ??? - This is an expression returning nothing. If you paid attention to the last couple of minutes, this guy returns nothing.
  // And when this method is called, this guy will throw a not implemented error because we'll implement them later.

  def head: Int = throw new NoSuchElementException // Throw expressions are expressions which return nothing
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean  = true
  def add(element: Int): MyList = new Cons(element, Empty)

  def printElements: String = ""
}


class Cons(h:  Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list1 = new Cons(1, Empty)
  println(list1.head)
  println(list1.add(4).head)
  println(list1.isEmpty)





  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list2.tail.tail.head)
  println(list2.toString)


}
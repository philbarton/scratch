package functions

import scala.math._

object HighOrder extends App {

  // HOF takes a function with a double parameter and returns a double as a parameter
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  println(valueAtOneQuarter(ceil _))

  // HOF returns a function
  def mulBy(factor:Double) = (x:Double) => factor * x
  val quin = mulBy(5)
  println(quin(3)) // 15

  println(valueAtOneQuarter(x => x * 3))

  (1 to 9).map("$" * _).foreach(println _)

  // currying and partially applied function
  val a = Array("Hello", "World")
  val b = Array("hello", "world")

  val c = a.corresponds(b) _

  println(c(_.equalsIgnoreCase(_))) // true
  println(c(_.equals(_)))           // false

}

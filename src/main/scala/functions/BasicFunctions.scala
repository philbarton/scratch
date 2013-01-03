package functions

object BasicFunctions extends App {
  val f = (x:Int) => x * 6
  println(f(6))

  println(Array(1,2,3).map((x:Int) => x + 1).mkString)
}





val nums = new Array[Int](6)

nums(5) = 7

println(nums(5))

import scala.collection.mutable.ArrayBuffer

val ab = new ArrayBuffer[Any]()

ab +=(1, 2, 3, "wow")

println(ab(0))

for (elem <- ab) {
  println(elem)
}

println(ab.mkString("[", ",", "]"))

val newAb = nums.filter(_ == 7).map(2 * _)

println(newAb.mkString(","))



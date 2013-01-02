
val map = scala.collection.mutable.Map("phil" -> 10, "paul" -> 5)

val myScore = map.getOrElse("phil", 20)

println(myScore)

map += ("chris" -> 3)

println(map.size)

val tup = ("ping", 5, true)

println(tup._2)

val symbols = Array("<", "-", ">")
val times = Array(2, 10, 3)
val pairs = symbols.zip(times)

for ((s, n) <- pairs) println(s * n)








package enumuration

import TrafficLightColour._

object TrafficLight extends App {
  val tl: TrafficLightColour = GREEN

  if (tl == GREEN) {
    println("Go")
    println(tl.id)
    println(tl)
    println(RED)
  }

}


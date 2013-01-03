package unapply

object Unapply extends App {
  val author = "Phil Barton"
  val Name(first, last) = author
  println(first)
  println(last)
}

object Name {
  def unapply(author:String) = {
    val pos = author.indexOf(" ")
    if (pos == -1) None
    else Some(author.substring(0, pos), author.substring(pos + 1))
  }
}

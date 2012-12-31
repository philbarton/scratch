package forloop

import org.scalatest.FunSuite

class ForLoop extends FunSuite {

  test("for generator") {

    info("this generates a list of files")
    val filesHere = (new java.io.File(".")).listFiles

    info("foreach <- is a generator")
    for (file <- filesHere
         if file.getName.endsWith(".iml"))
      info(file.toString)


    info("foreach using yield")
    val files = for (file <- filesHere
    ) yield file

    info(files.size.toString)
  }
}

import sbt._
import sbt.Keys._

object ScratchBuild extends Build {

  lazy val scratch = Project(
    id = "scratch",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scratch",
      organization := "scratch",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2"
      // add other settings here
    )
  )
}

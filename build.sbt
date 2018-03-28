name := "scala-for-the-impatient"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test",
  "org.scala-lang.modules" %% "scala-xml" % "1.1.0"
)

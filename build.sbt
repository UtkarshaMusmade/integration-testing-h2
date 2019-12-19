name := "integration-testing-h2"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "com.h2database" % "h2" % "1.4.196"

lazy val h2example = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings,
    libraryDependencies ++= Seq(
         "org.scalatest" %% "scalatest" % "3.0.1" % "it,test"
    )
  )
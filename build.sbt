

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scalaErgast",
    scalacOptions += "-Ymacro-annotations",
    libraryDependencies ++= Dependencies.allCats ++ Dependencies.allHttp4s ++ Dependencies.allOther ++ Dependencies.allDerevo
  )
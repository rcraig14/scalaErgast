ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scalaErgast",
    scalacOptions += "-Ymacro-annotations",
    libraryDependencies ++= Dependencies.allCats ++ Dependencies.allHttp4s ++ Dependencies.allOther ++ Dependencies.allDerevo
  )

inThisBuild(List(
  organization := "io.github.rcraig14",
  homepage := Some(url("https://github.com/rcraig14/scalaErgast")),
  licenses := List("MIT" -> url("https://github.com/rcraig14/scalaErgast/blob/main/LICENSE")),
  developers := List(
    Developer(
      "rcraig14",
      "Ryan Craig",
      "",
      url("https://github.com/rcraig14")
    )
  ),
  sonatypeCredentialHost := "s01.oss.sonatype.org",
  sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
))
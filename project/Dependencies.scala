import sbt._

object Dependencies {

  object version {
    val cats = "2.7.0"
    val catsEffect = "3.3.4"
    val http4s = "0.23.1"
    val newType = "0.4.4"
    val derevo = "0.13.0"
  }

  val cats       = "org.typelevel"    %% "cats-core"   % version.cats
  val catsEffect = "org.typelevel"    %% "cats-effect" % version.catsEffect

  val allCats = Seq(cats, catsEffect)


  //Http4s
  val http4sDsl    = "org.http4s" %% s"http4s-dsl" % version.http4s
  val http4sClient = "org.http4s" %% s"http4s-ember-client" % version.http4s
  val http4sJsonParser = "org.http4s" %% "http4s-circe" % version.http4s

  val allHttp4s = Seq(http4sDsl, http4sClient, http4sJsonParser)

  //derevo
  val derevoCore = "tf.tofu"    %% s"derevo-core" % version.derevo
  val derevoCats = "tf.tofu"    %% s"derevo-cats" % version.derevo
  val derevoMag = "tf.tofu"    %% s"derevo-circe-magnolia" % version.derevo

  val allDerevo = Seq(derevoCore, derevoCats, derevoMag)

  //Other
  val newTypes = "io.estatico" %% "newtype" % version.newType
  val scalaTic = "org.scalactic" %% "scalactic" % "3.2.11"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.11" % "test"

  val allOther = Seq(newTypes, scalaTic, scalaTest)
}

package scalaErgast

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import clients.SeasonsClient
import org.http4s.client.{Client, JavaNetClientBuilder}
import scalaErgast.domain.ResponseDataWrapper.Limit

object trialScripts {

  def main(args: Array[String]) = {
    val httpClient: Client[IO] = JavaNetClientBuilder[IO].create

    //Seasion list
    //    val seasons = httpClient
    //      .expect[ResponseDataWrapper]("http://ergast.com/api/f1/seasons.json?limit=10")

    //    //Race Schedule
    //    val seasons = httpClient
    //      .expect[ResponseDataWrapper]("http://ergast.com/api/f1/current.json")

    val seasons = SeasonsClient.make(httpClient).getSeasons(Limit(30), constructors = Some("renault"), results = Some("3"))
    println(seasons.unsafeRunSync())

    //    val mrdata = ResponseDataWrapper(ResponseData(Xmlns("http://ergast.com/mrd/1.4"),
    //      Series("f1"),
    //      Url("http://ergast.com/api/f1/seasons.json"),
    //      Limit(10),
    //      Offset(0),
    //      Total(73)
    //      , Some(SeasonTable(Seasons(List(
    //        Season(Season.Url("https://en.wikipedia.org/wiki/1950_Formula_One_season"), Season.seasonYear("1950")),
    //        Season(Season.Url("https://en.wikipedia.org/wiki/1951_Formula_One_season"), Season.seasonYear("1951"))
    //      )))), None
    //    ))
    //
    //    val mrAsJson = mrdata.asJson.noSpaces
    //    println(mrAsJson)
    //    circe.jawn.decode[ResponseDataWrapper](mrAsJson)
    //    println(circe.jawn.decode[ResponseDataWrapper](mrAsJson))

    //    val uriBuilder = new UriBuilder().withPath("seasons.json", List(("constructor", Some("1")))).urlTemplate.toString
    //    println(uriBuilder)
    ()
  }
}

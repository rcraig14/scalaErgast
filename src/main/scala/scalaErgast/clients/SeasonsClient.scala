package scalaErgast.clients

import cats.effect.Async
import cats.implicits.toFunctorOps
import org.http4s.circe.CirceSensitiveDataEntityDecoder.circeEntityDecoder
import org.http4s.circe.JsonDecoder
import org.http4s.client.Client
import scalaErgast.domain.ResponseDataWrapper
import scalaErgast.domain.ResponseDataWrapper.{Limit, Offset}
import scalaErgast.domain.SeasonList.SeasonTable
import scalaErgast.util.UriBuilder

trait SeasonsClient[F[_]] {
  def getSeasons(
                  limit: Limit = Limit(10),
                  offset: Offset = Offset(0),
                  circuits: Option[String] = None,
                  constructors: Option[String] = None,
                  drivers: Option[String] = None,
                  grid: Option[String] = None,
                  results: Option[String] = None,
                  fastest: Option[String] = None,
                  status: Option[String] = None
                ): F[Option[SeasonTable]]

}

object SeasonsClient {
  def make[F[_] : JsonDecoder : Async](
                                        httpClient: Client[F]
                                      ): SeasonsClient[F] =
    new SeasonsClient[F] {
      override def getSeasons(
                               limit: Limit = Limit(10),
                               offset: Offset = Offset(0),
                               circuits: Option[String] = None,
                               constructors: Option[String] = None,
                               drivers: Option[String] = None,
                               grid: Option[String] = None,
                               results: Option[String] = None,
                               fastest: Option[String] = None,
                               status: Option[String] = None
                             ): F[Option[SeasonTable]] = {
        val uri = new UriBuilder()
          .withPath("seasons.json",
            List(
              ("circuits", circuits),
              ("constructors", constructors),
              ("drivers", drivers),
              ("grid", grid),
              ("results", results),
              ("fastest", fastest),
              ("status", status)
            ))
          .withParameters(List(("limit", limit.toString), ("offset", offset.toString)))

        val seasons = httpClient.expect[ResponseDataWrapper](uri.urlTemplate.toString)
        seasons.map(resWrapper => resWrapper.mrData.SeasonTable)
      }
    }
}

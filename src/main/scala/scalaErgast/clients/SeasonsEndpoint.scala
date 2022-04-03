package scalaErgast.clients

import scalaErgast.domain.ResponseDataV2.{Limit, Offset}
import scalaErgast.domain.SeasonList.SeasonTable
import scalaErgast.util.UriBuilder

case class SeasonsRequest(limit: Limit = Limit(10),
  offset: Offset = Offset(0),
  circuits: Option[String] = None,
  constructors: Option[String] = None,
  drivers: Option[String] = None,
  grid: Option[String] = None,
  results: Option[String] = None,
  fastest: Option[String] = None,
  status: Option[String] = None)


object SeasonsEndpoint extends ApiEndpoint[SeasonsRequest, SeasonTable] {
  override def buildUri(apiRequest: SeasonsRequest): UriBuilder = {
    new UriBuilder()
      .withPath("seasons.json",
        List(
          ("circuits", apiRequest.circuits),
          ("constructors", apiRequest.constructors),
          ("drivers", apiRequest.drivers),
          ("grid", apiRequest.grid),
          ("results", apiRequest.results),
          ("fastest", apiRequest.fastest),
          ("status", apiRequest.status)
        ))
      .withParameters(List(("limit", apiRequest.limit.toString), ("offset", apiRequest.offset.toString)))
  }
}

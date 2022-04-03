//package scalaErgast.clients
//
//import scalaErgast.domain.RaceSchedule.RaceTable.RaceTable
//import scalaErgast.domain.ResponseDataWrapper
//import scalaErgast.domain.ResponseDataWrapper.{Limit, Offset, ResponseData, Series, Total, Xmlns}
//import scalaErgast.domain.SeasonList.SeasonTable
//import scalaErgast.domain.SharedClasses.Url
//import scalaErgast.util.UriBuilder
//
//class RaceScheduleResponse(xmlns: Xmlns,
//                               series: Series,
//                               url: Url,
//                               limit: Limit,
//                               offset: Offset,
//                               total: Total,
//                               SeasonTable: Option[SeasonTable],
//                               RaceTable: Option[RaceTable]) extends ResponseData(xmlns, series, url, limit, offset, total, SeasonTable)
//
//class RaceResponseDataWrapper(RaceScheduleResponse: RaceScheduleResponse) extends ResponseDataWrapper(RaceScheduleResponse)
//
//class RaceScheduleRequest()
//
//object RaceScheduleClient extends ApiEndpoint[RaceScheduleRequest, RaceScheduleResponse] {
//  override def buildUri(apiRequest: RaceScheduleRequest): UriBuilder = ???
//
//  override def getResponse(response: ResponseDataWrapper): RaceScheduleResponse = ???
//}

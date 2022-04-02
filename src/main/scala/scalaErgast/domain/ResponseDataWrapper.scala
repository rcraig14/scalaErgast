package scalaErgast.domain

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import io.circe.{Decoder, Encoder}
import io.estatico.newtype.macros.newtype
import scalaErgast.domain.RaceSchedule.RaceTable.RaceTable
import scalaErgast.domain.ResponseDataWrapper.ResponseData
import scalaErgast.domain.SeasonList.SeasonTable
import scalaErgast.domain.SharedClasses.Url

case class ResponseDataWrapper(
                                mrData: ResponseData
                              )

object ResponseDataWrapper {

  implicit val MRDataEncoder: Encoder[ResponseDataWrapper] =
    Encoder.forProduct1("MRData")(_.mrData)

  implicit val MRDataDecoder: Decoder[ResponseDataWrapper] =
    Decoder.forProduct1("MRData")(ResponseDataWrapper(_))


  @derive(decoder, encoder)
  @newtype
  case class Xmlns(value: String)

  @derive(decoder, encoder)
  @newtype
  case class Series(value: String)

  @derive(decoder, encoder)
  @newtype
  case class Limit(value: Int)

  @derive(decoder, encoder)
  @newtype
  case class Offset(value: Int)

  @derive(decoder, encoder)
  @newtype
  case class Total(value: Int)

  @derive(decoder, encoder)
  //TODO: Maybe a better way to handle the Options
  case class ResponseData(xmlns: Xmlns,
                          series: Series,
                          url: Url,
                          limit: Limit,
                          offset: Offset,
                          total: Total,
                          SeasonTable: Option[SeasonTable],
                         )

}

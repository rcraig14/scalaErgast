package scalaErgast.domain

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import io.circe.{Decoder, Encoder}
import io.estatico.newtype.macros.newtype
import scalaErgast.domain.ResponseDataV2.{Limit, Offset, Series, Total, Xmlns}
import scalaErgast.domain.SharedClasses.Url

@derive(decoder, encoder)
case class  ResponseDataV2[T](
                       xmlns: Xmlns,
                       series: Series,
                       url: Url,
                       limit: Limit,
                       offset: Offset,
                       total: Total,
                       data: T
                     )

object ResponseDataV2 {
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
}

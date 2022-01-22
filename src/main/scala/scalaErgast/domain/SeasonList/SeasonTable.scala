package scalaErgast.domain.SeasonList

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import io.estatico.newtype.macros.newtype
import scalaErgast.domain.SeasonList.SeasonTable.Seasons

//TODO: Look to see if encoding can become case insensitive
@derive(encoder, decoder)
case class SeasonTable(Seasons: Seasons)

object SeasonTable {

  @derive(encoder, decoder)
  @newtype
  case class Seasons(seasons: List[Season])
}

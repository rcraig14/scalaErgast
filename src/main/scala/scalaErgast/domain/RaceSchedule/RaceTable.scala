package scalaErgast.domain.RaceSchedule

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import io.estatico.newtype.macros.newtype
import scalaErgast.domain.RaceSchedule.Race.Race


object RaceTable {

  @derive(encoder, decoder)
  @newtype
  case class Season(value: Int)

  @derive(encoder, decoder)
  @newtype
  case class Races(races: List[Race])

  @derive(encoder, decoder)
  case class RaceTable(season: Season, Races: Races)
}

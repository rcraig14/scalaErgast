package scalaErgast.domain.RaceSchedule

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import io.estatico.newtype.macros.newtype

object Race {

  @derive(encoder, decoder)
  @newtype
  case class Season(value: Int)

  @derive(encoder, decoder)
  @newtype
  case class Round(value: Int)

  @derive(encoder, decoder)
  @newtype
  case class Url(value: String)

  @derive(encoder, decoder)
  @newtype
  case class RaceName(value: String)

  @derive(encoder, decoder)
  @newtype
  //TODO look at date conversion instead of string
  case class Date(value: String)

  @derive(encoder, decoder)
  @newtype
  //TODO convert to time data type
  case class Time(value: String)


  @derive(encoder, decoder)
  case class Race(
                   season: Season,
                   round: Round,
                   url: Url,
                   raceName: RaceName,
                   date: Date,
                   time: Time
                 )
}

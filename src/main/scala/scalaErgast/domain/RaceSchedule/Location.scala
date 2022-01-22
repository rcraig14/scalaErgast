package scalaErgast.domain.RaceSchedule

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import io.estatico.newtype.macros.newtype

object Location {

  @derive(encoder, decoder)
  @newtype
  //TODO maybe cast to decimal?
  case class Latitude(value: String)

  @derive(encoder, decoder)
  @newtype
  case class Longitude(value: String)

  @derive(encoder, decoder)
  @newtype
  case class Locality(value: String)

  @derive(encoder, decoder)
  @newtype
  case class Country(value: String)

  @derive(encoder, decoder)
  case class Location(
                     lat: Latitude,
                     long: Longitude,
                     locality: Locality,
                     country: Country
                     )

}

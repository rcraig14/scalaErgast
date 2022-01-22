package scalaErgast.domain.RaceSchedule

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import io.estatico.newtype.macros.newtype
import scalaErgast.domain.RaceSchedule.Location.Location

object Circuit {

  @derive(encoder, decoder)
  @newtype
  case class CircuitId(value: String)

  @derive(encoder, decoder)
  @newtype
  case class Url(value: String)

  @derive(encoder, decoder)
  @newtype
  case class CircuitName(value: String)

  @derive(encoder, decoder)
  case class Circuit(
                      circuitId: CircuitId,
                      url: Url,
                      circuitName: CircuitName,
                      location: Location
                    )

}

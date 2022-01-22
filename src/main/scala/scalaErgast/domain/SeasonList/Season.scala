package scalaErgast.domain.SeasonList

import derevo.circe.magnolia.{decoder, encoder, keyDecoder, keyEncoder}
import derevo.derive
import io.estatico.newtype.macros.newtype
import scalaErgast.domain.SeasonList.Season.seasonYear
import scalaErgast.domain.SharedClasses.Url

@derive(decoder, encoder, keyDecoder, keyEncoder)
case class Season(url: Url, season: seasonYear)

object Season {

  @derive(decoder, encoder, keyDecoder, keyEncoder)
  @newtype
  case class seasonYear(s: String)
}

package scalaErgast.domain

import derevo.circe.magnolia.{decoder, encoder, keyDecoder, keyEncoder}
import derevo.derive
import io.estatico.newtype.macros.newtype

object SharedClasses {
  @derive(decoder, encoder, keyDecoder, keyEncoder)
  @newtype
  case class Url(s: String)
}



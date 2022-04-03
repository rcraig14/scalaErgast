package scalaErgast.domain

import io.circe.{Decoder, Encoder}
import org.http4s.EntityEncoder

case class ResponseDataWrapperV2[T](mrData: ResponseDataV2[T])

object ResponseDataWrapperV2 {
  implicit def encoder[T](implicit encoder: Encoder[T]): Encoder[ResponseDataWrapperV2[T]] =
    Encoder.forProduct1("MRData")(_.mrData.asInstanceOf[T])

  implicit def decoder[T](implicit encoder: Encoder[T], decoder: Decoder[T]): Decoder[ResponseDataWrapperV2[T]] =
    Decoder.forProduct1("MRData")(ResponseDataWrapperV2[T])
}


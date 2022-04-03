package scalaErgast.clients

import cats.effect.Async
import io.circe.{Decoder, Encoder}
import org.http4s.circe.CirceSensitiveDataEntityDecoder.circeEntityDecoder
import org.http4s.circe._
import org.http4s.client.Client
import scalaErgast.domain.ResponseDataWrapperV2
import scalaErgast.util.UriBuilder

trait ApiEndpoint [ApiRequest, T] {


  def buildUri(apiRequest: ApiRequest): UriBuilder

  def get[F[_] : Client : JsonDecoder : Async](apiRequest: ApiRequest)
                                              (
                                                implicit client: Client[F],
                                                decoder: Decoder[T],
                                                encoder: Encoder[T]
                                              ): F[ResponseDataWrapperV2[T]] = {
    client
      .expect[ResponseDataWrapperV2[T]](buildUri(apiRequest).urlTemplate.toString)
  }

}

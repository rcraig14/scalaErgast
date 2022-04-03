package scalaErgast.clients

import cats.effect.{Async, Sync}
import io.circe.Decoder
import org.http4s.circe.JsonDecoder
import org.http4s.client.Client
import scalaErgast.domain.ResponseDataWrapperV2
import scalaErgast.domain.ResponseDataWrapperV2.decoder
import scalaErgast.util.UriBuilder

trait ApiEndpoint [ApiRequest, T] {


  def buildUri(apiRequest: ApiRequest): UriBuilder

  def get[F[_] : Client : Decoder : Async](apiRequest: ApiRequest)(implicit client: Client[F]): F[ResponseDataWrapperV2[T]] = {
    client
      .expect[ResponseDataWrapperV2[T]](buildUri(apiRequest).urlTemplate.toString)
  }

}

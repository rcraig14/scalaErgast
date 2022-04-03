package scalaErgast.clients

import cats.effect.Async
import cats.implicits.toFunctorOps
import org.http4s.circe.CirceSensitiveDataEntityDecoder.circeEntityDecoder
import org.http4s.circe.JsonDecoder
import org.http4s.client.Client
import scalaErgast.domain.ResponseDataWrapper
import scalaErgast.util.UriBuilder

trait ApiEndpoint [ApiRequest, ApiResponse] {

  def buildUri(apiRequest: ApiRequest): UriBuilder

  def getResponse(response: ResponseDataWrapper): ApiResponse

  def get[F[_] : Client : JsonDecoder: Async](apiRequest: ApiRequest)(implicit client: Client[F]): F[ApiResponse] = {
    client
      .expect[ResponseDataWrapper](buildUri(apiRequest).urlTemplate.toString)
      .map(getResponse)
  }

}

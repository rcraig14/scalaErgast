import cats.effect.IO
import cats.effect.unsafe.implicits.global
import org.http4s.client.{Client, JavaNetClientBuilder}
import scalaErgast.clients.{SeasonsEndpoint, SeasonsRequest}

var endpoint = SeasonsEndpoint
var request = new SeasonsRequest
implicit var httpClient: Client[IO] = JavaNetClientBuilder[IO].create
var response = endpoint.get(request)

println(response.unsafeRunSync())
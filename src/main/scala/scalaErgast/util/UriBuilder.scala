package scalaErgast.util

import org.http4s.UriTemplate.{ParamElm, PathElm}
import org.http4s.{Uri, UriTemplate}

class UriBuilder(uriTemplate: UriTemplate = UriBuilder.baseUri) {
  val urlTemplate = uriTemplate

  def withPath(ending: String, filters: List[(String, Option[String])]): UriBuilder = {
    val addedPath: List[PathElm] = filters.map(_ match {
      case (key, Some(value)) => List[PathElm](PathElm(key), PathElm(value))
      case _ => List.empty[PathElm]
    }).flatten.appended(PathElm(ending))
    new UriBuilder(this.uriTemplate.copy(path = addedPath))
  }

  def withParameters(parameters: List[(String, String)]): UriBuilder = {
    val paramElm: List[ParamElm] = parameters.map(_ match{
      case (key,value) => ParamElm(key,value)
    })
    new UriBuilder(this.uriTemplate.copy(query = paramElm))
  }
}

object UriBuilder {
  val baseUri = UriTemplate(
    authority = Some(Uri.Authority(host = Uri.RegName("ergast.com/api/f1"))),
    scheme = Some(Uri.Scheme.http)
  )
}


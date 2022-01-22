package scalaErgast.util

import org.http4s.UriTemplate.{ParamElm, PathElm}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import util.UriBuilder

class UriBuilderShould extends AnyFlatSpec with Matchers {
  "UriBuidler" should "return the default values" in {
    val uriBuilder = new UriBuilder()
    uriBuilder.urlTemplate shouldBe UriBuilder.baseUri
  }

  "withPath" should "append ending value on list" in {
    val results = new UriBuilder().withPath("test", List())
    results.urlTemplate.path shouldBe List(PathElm("test"))
    results.urlTemplate.toString shouldBe UriBuilder.baseUri + "/test"
  }

  it should "append filters in path before appending ending" in {
    val results = new UriBuilder().withPath("testingString", List(("path1", Some("1st")), ("path2", None), ("path3", Some("3rd"))))
    results.urlTemplate.path shouldBe List(PathElm("path1"), PathElm("1st"), PathElm("path3"), PathElm("3rd"), PathElm("testingString"))
  }

  "withParameters" should "return empty list of params if empty list is passed in" in {
    val results = new UriBuilder().withParameters(List())
    results.urlTemplate.query shouldBe List()
  }

  it should "return query params from list" in {
    val results = new UriBuilder().withParameters(List(("limit", "10"), ("offset", "15")))
    results.urlTemplate.query shouldBe List(ParamElm("limit", "10"), ParamElm("offset", "15"))
    results.urlTemplate.toString shouldBe UriBuilder.baseUri + "/?limit=10&offset=15"
  }
}

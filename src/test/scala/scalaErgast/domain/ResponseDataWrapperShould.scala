package scalaErgast.domain

import io.circe
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import scalaErgast.domain.ResponseDataWrapper._
import scalaErgast.domain.SeasonList.Season.seasonYear
import scalaErgast.domain.SeasonList.SeasonTable.Seasons
import scalaErgast.domain.SeasonList.{Season, SeasonTable}
import scalaErgast.domain.SharedClasses.Url

class ResponseDataWrapperShould extends AnyFlatSpec with Matchers {
  "ResponseDataWrapper" should "return object with Season List poulated" in {
    //response date from: http://ergast.com/api/f1/seasons.json?limit=5
    val json = "{\"MRData\":{\"xmlns\":\"http:\\/\\/ergast.com\\/mrd\\/1.4\",\"series\":\"f1\",\"url\":\"http://ergast.com/api/f1/seasons.json\",\"limit\":\"5\",\"offset\":\"0\",\"total\":\"73\",\"SeasonTable\":{\"Seasons\":[{\"season\":\"1950\",\"url\":\"https:\\/\\/en.wikipedia.org\\/wiki\\/1950_Formula_One_season\"},{\"season\":\"1951\",\"url\":\"https:\\/\\/en.wikipedia.org\\/wiki\\/1951_Formula_One_season\"},{\"season\":\"1952\",\"url\":\"https:\\/\\/en.wikipedia.org\\/wiki\\/1952_Formula_One_season\"},{\"season\":\"1953\",\"url\":\"https:\\/\\/en.wikipedia.org\\/wiki\\/1953_Formula_One_season\"},{\"season\":\"1954\",\"url\":\"https:\\/\\/en.wikipedia.org\\/wiki\\/1954_Formula_One_season\"}]}}}"

    val expected = ResponseDataWrapper(
      ResponseData(
        xmlns = Xmlns("http://ergast.com/mrd/1.4"),
        series = Series("f1"),
        url = Url("http://ergast.com/api/f1/seasons.json"),
        limit = Limit(5),
        offset = Offset(0),
        total = Total(73),
        SeasonTable = Some(
          SeasonTable(
            Seasons(
              List[Season](
                Season(Url("https://en.wikipedia.org/wiki/1950_Formula_One_season"), seasonYear("1950")),
                Season(Url("https://en.wikipedia.org/wiki/1951_Formula_One_season"), seasonYear("1951")),
                Season(Url("https://en.wikipedia.org/wiki/1952_Formula_One_season"), seasonYear("1952")),
                Season(Url("https://en.wikipedia.org/wiki/1953_Formula_One_season"), seasonYear("1953")),
                Season(Url("https://en.wikipedia.org/wiki/1954_Formula_One_season"), seasonYear("1954"))
              )
            )
          )
        )
      )
    )

    circe.jawn.decode[ResponseDataWrapper](json).map(_ shouldBe expected)
  }
}

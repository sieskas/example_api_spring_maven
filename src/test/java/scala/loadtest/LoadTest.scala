package scala.loadtest

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.protocol.HttpProtocolBuilder
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


class LoadTest extends Simulation {

  val name = "LoadTest";
  val numberUserMin: Int = 5;
  val numberUserMax: Int = 6;
  val time: Int = 180;
  val timeResponseMax = 5000;
  val serverBaseUrl  = "http://localhost:8080"; //getProperties("serverBaseUrl");

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(serverBaseUrl)
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val header: Map[String, String] = Map(
    "Content-Type" -> "application/json")

  val scn: ScenarioBuilder = scenario(name)
    .exec(
      http("get posts")
        .get("/api/example/spring/v1/posts")
        .headers(header)
        .queryParam("id", 1)
        //.asJson
        //.body(RawFileBody(file))
        .check(status.is(200))
    )

  setUp(
    scn.inject(
    rampUsersPerSec(numberUserMin)
      .to(numberUserMax)
      .during (time.seconds)
    )
  ).protocols(httpProtocol)
    .assertions(
      global.responseTime.max.lt(timeResponseMax),
      global.successfulRequests.percent.is(100)
  )
}
package controllers

import model.FootballFormats
import play.api.libs.json.Json
import play.api.mvc._
import services.FakeApi

import scala.concurrent.{ExecutionContext, Future}

class AsyncHelloWorldController(components: ControllerComponents, fakeApi: FakeApi)(implicit executionContext: ExecutionContext)
  extends AbstractController(components) with FootballFormats{

  def delayedHello(delay: Int) = Action.async {
    println(s"Delaying: $delay")
    Future {
      Thread.sleep(delay)
      Ok(s"Came back to say hello after $delay")
    }
  }

  def latestScores() = Action.async {
    val matches = fakeApi.getLatestScoresAsync(450)
    matches.map(m => Ok(Json.toJson(m)))
  }
}

package controllers

import model.FootballFormats
import play.api.mvc._
import play.api.libs.json._
import services.FakeApi

class HelloWorldController(components: ControllerComponents, fakeApi: FakeApi) extends AbstractController(components) with FootballFormats {



  def helloworld = Action {
    Ok("hello world")
  }

  def latestScores = Action {
    val matches = fakeApi.getLatestScores(10)
    Ok(Json.toJson(matches)).withHeaders(("content-type", "application/json"))
  }
}

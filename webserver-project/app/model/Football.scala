package model

import play.api.libs.json._

trait FootballFormats {
  implicit val scoreFormat: Format[Score] = Json.format[Score]
  implicit val teamFormat: Format[FootballTeam] = Json.format[FootballTeam]
  implicit val matchFormat: Format[FootballMatch] = Json.format[FootballMatch]
}

case class Score(scorer: String, time: Int, penalty: Option[String] = None)
case class FootballTeam(name: String, score: Int, scores: List[Score])
case class FootballMatch(home: FootballTeam, away: FootballTeam)

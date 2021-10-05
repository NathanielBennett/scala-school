package services

import model.{FootballMatch, FootballTeam, Score}

import scala.concurrent.{ExecutionContext, Future}

class FakeApi {

  val scores = List(FootballMatch(FootballTeam("Leicester", 4,
    List(
      Score("Jamie Vardy", 20),
      Score("Jamie Vardy", 27, Some("pen")),
      Score("Marc Albrighton", 66),
      Score("Kelechi Iheanacho", 27)
    )),
    FootballTeam("West Ham", 0, List.empty)
  ),
    FootballMatch(FootballTeam("Chelsea", 2,
      List(
        Score("Reece James", 32),
        Score("Timo Warner", 89)
      )),
      FootballTeam("Burnley", 2,
        List(
          Score("Ben Mee", 66),
          Score("Chris Wood", 85)
        )
      )
    ),
    FootballMatch(FootballTeam("Beatles", 2,
      List(
        Score("Jones", 27),
        Score("Watts", 80)
      )),
      FootballTeam("Burnley", 2,
        List(
          Score("Lennon ", 40, Some("pen")),
          Score("Harrison", 57)
        )
      )
    )
  )

  def getLatestScores(delay: Int): List[FootballMatch] = {
     Thread.sleep(delay)
    scores
  }

  def getLatestScoresAsync(delay: Int)(implicit executionContext: ExecutionContext): Future[List[FootballMatch]] = {
    Future {
      Thread.sleep(delay)
      scores
    }
  }
}

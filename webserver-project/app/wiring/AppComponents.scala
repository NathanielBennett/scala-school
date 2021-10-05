package wiring

import play.api.routing.Router
import play.api.ApplicationLoader.Context
import play.api.{BuiltInComponentsFromContext, NoHttpFiltersComponents}
import controllers._
import play.api.libs.ws.ahc.AhcWSComponents
import router.Routes
import services.FakeApi

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context) with NoHttpFiltersComponents with AssetsComponents with AhcWSComponents {

  val fakeApi = new FakeApi()
  override lazy val router: Router = new Routes(
    httpErrorHandler,
    new HelloWorldController(controllerComponents, fakeApi),
    new AsyncHelloWorldController(controllerComponents, fakeApi)
  )
}

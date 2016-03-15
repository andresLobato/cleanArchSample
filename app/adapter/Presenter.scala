package adapter

import contract.Callback
import play.api.mvc.{Result, Results}

import scala.concurrent.{ExecutionContext, Future}

trait Presenter[C <: Callback[_]] extends Results {

  type UseCaseExecutor = C => Unit

  type Rendered = Result

  def response(call: UseCaseExecutor)(implicit ec: ExecutionContext): Future[Rendered]
}

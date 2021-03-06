package contract

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

// Input Port
trait PullPort[PullArg, Arg, Result] {
  self: UseCase =>

  override final type In = Arg

  override final type Out = Result

  // Pull型は何かしらのパラメータを渡して、Inputを貰うという形
  def execute[T <: Callback[Result]](arg: PullArg => Arg)(callback: T)(implicit ec: ExecutionContext): Unit = {
    call(arg(pullArg)).onComplete {
      case Success(result) =>
        callback.onSuccess(result)
      case Failure(t) =>
        callback.onFailure(t)
    }
  }

  protected def pullArg: PullArg
}

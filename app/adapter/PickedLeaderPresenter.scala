package adapter

import contract.callback.PickedLeaderCallback
import domain.UserId
import play.api.libs.json.Json

import scala.concurrent.{ExecutionContext, Future, Promise}

class PickedLeaderPresenter extends Presenter[PickedLeaderCallback] {

  implicit val writer = Json.writes[UserId]

  override def response(call: UseCaseExecutor)(implicit ec: ExecutionContext): Future[Rendered] = {
    val callback = new CallbackImpl
    call(callback)
    callback.promise.future.map { userId =>
      Ok(Json.toJson(userId))
    }
  }

  private class CallbackImpl extends PickedLeaderCallback {
    val promise = Promise[UserId]()
    override def onSuccess(userId: UserId): Unit = {
      promise.success(userId)
    }

    override def onFailure(throwable: Throwable): Unit = {
      promise.failure(throwable)
    }
  }

}

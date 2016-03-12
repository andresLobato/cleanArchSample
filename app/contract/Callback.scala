package contract

// Output Port
trait Callback[Result] {

  def onSuccess(result: Result): Unit

  def onFailure(t: Throwable): Unit
}

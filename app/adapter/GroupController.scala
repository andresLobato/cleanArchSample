package adapter

import javax.inject.Inject

import contract.usecase.PickLeaderUseCase
import domain.GroupId
import play.api.data.Forms._
import play.api.data._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future

class GroupController @Inject()(useCase: PickLeaderUseCase, presenter: PickedLeaderPresenter) extends Controller {

  val form = Form(
    mapping(
      "groupId" -> number
    )(GroupId.apply)(GroupId.unapply)
  )

  def pickLeader = Action.async { implicit request =>
    form.bindFromRequest.fold(_ => Future.successful(BadRequest("not found query parameter: `groupId`")), (groupId: GroupId) =>
      presenter.present(useCase.execute(groupId))
    )
  }

}

package adapter

import contract.usecase.PickLeaderUseCase
import domain.GroupId
import javax.inject.{Inject, Singleton}
import play.api.data.Forms._
import play.api.data._
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext

@Singleton
class GroupController @Inject()(useCase: PickLeaderUseCase, presenter: PickedLeaderPresenter, controllerComponents: ControllerComponents) extends AbstractController(controllerComponents) {

  private implicit lazy val ec: ExecutionContext = defaultExecutionContext

  private val form = Form(
    mapping(
      "groupId" -> number
    )(GroupId.apply)(GroupId.unapply)
  )

  def pickLeader = Action.async(parse.form(form)) { implicit request =>
    val groupId = request.body
    presenter.response(useCase.execute(groupId))
  }

}

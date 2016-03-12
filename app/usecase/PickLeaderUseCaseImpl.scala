package usecase

import javax.inject.Inject
import contract.usecase.PickLeaderUseCase
import domain.UserRepository

import scala.concurrent.{ExecutionContext, Future}

class PickLeaderUseCaseImpl @Inject()(userRepository: UserRepository) extends PickLeaderUseCase {

  override protected def call(groupId: In)(implicit ec: ExecutionContext): Future[Out] = {
    userRepository.findBy(groupId).map { board =>
      board.pickLeader  // 誰をどうリーダにするかはドメイン知識
    }
  }
}

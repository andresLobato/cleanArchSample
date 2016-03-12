package contract.usecase

import contract.{PushPort, UseCase}
import domain.{GroupId, UserId}

trait PickLeaderUseCase extends UseCase with PushPort[GroupId, UserId]

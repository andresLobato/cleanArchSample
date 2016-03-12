package usecase

import com.google.inject.AbstractModule
import contract.usecase.PickLeaderUseCase

class UseCaseModule extends AbstractModule {

  def configure(): Unit = {
    bind(classOf[PickLeaderUseCase]).to(classOf[PickLeaderUseCaseImpl])
  }
}

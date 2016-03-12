package adapter

import adapter.repository.InMemoryUserRepository
import com.google.inject.AbstractModule
import domain.UserRepository

class AdapterModule extends AbstractModule {

  def configure(): Unit = {
    bind(classOf[UserRepository]).to(classOf[InMemoryUserRepository])
    bind(classOf[PickedLeaderPresenter])
  }
}

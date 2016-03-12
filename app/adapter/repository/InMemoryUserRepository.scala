package adapter.repository

import domain.{UserRepository, UserId, UserBoard, GroupId}

import scala.concurrent.{Future, ExecutionContext}

class InMemoryUserRepository extends UserRepository {

  override def findBy(groupId: GroupId)(implicit ec: ExecutionContext): Future[UserBoard] = {
    // 本来はDBにアクセスしたり、外部APIにアクセスしたりといったことを実装する
    Future.successful {
      UserBoard(groupId, UserId(1), UserId(2), UserId(3))
    }
  }
}

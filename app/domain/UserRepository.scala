package domain

import scala.concurrent.{ExecutionContext, Future}

trait UserRepository {

  def findBy(groupId: GroupId)(implicit ec: ExecutionContext): Future[UserBoard]
}

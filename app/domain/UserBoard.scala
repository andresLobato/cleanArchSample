package domain

case class UserBoard private (groupId: GroupId, private val users: IndexedSeq[UserId]) {

  def pickLeader: UserId = {
    // 本来はSeq.emptyだった場合などを想定する必要がある
    users(groupId.id % users.size)
  }
}

object UserBoard {
  def apply(groupId: GroupId, userIds: UserId*): UserBoard = {
    UserBoard(groupId, userIds.toVector)
  }
}

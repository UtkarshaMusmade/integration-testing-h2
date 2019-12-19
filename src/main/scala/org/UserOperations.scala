package org


case class User(id: Int, name: String, age: Int)

class UserOperations(dbOperations: DbOperations) {

  def addUser: String = {
    val result = dbOperations.add
    if (result > 0) {
      "User Added"
    }
    else {
      "User Not Added"
    }
  }

  def updateUser(userid: Int): String = {
    val result = dbOperations.update(userid)
    if (result > 0) {
      "User Updated"
    }
    else {
      "User Not Updated"
    }
  }

  def getUser(userid: Int): Option[User] = {
    val resultSet = dbOperations.get(userid)
    if (resultSet.next()) {
      Some(User(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)))
    }
    else {
      None
    }
  }
}


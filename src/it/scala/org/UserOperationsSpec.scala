package org

import java.sql.{Connection, DriverManager, Statement}

import org.scalatest.BeforeAndAfterAll


class UserOperationsSpec extends DbBaseSpec with BeforeAndAfterAll{

  Class.forName("org.h2.Driver")
  val conn: Connection = DriverManager.getConnection("jdbc:h2:mem:test;MODE=Oracle;")
 val stmt: Statement =conn.createStatement()
  val dbOperations = new DbOperations(stmt)
  val userOperations = new UserOperations(dbOperations)
  createJDBCTable(conn)


  "UserOperations" should {

    "return message user added" in {
      val result = userOperations.addUser
      result shouldBe "User Added"
    }

    "return message user updated" in {
      val result = userOperations.updateUser(2)
      result shouldBe "User Updated"
    }

    "return user info" in {
      val result = userOperations.getUser(2)
      result shouldBe Some(User(2,"Zoya",23))
    }
  }

  override def afterAll(): Unit = {
    cleanUpDatabase(conn)
  }

}

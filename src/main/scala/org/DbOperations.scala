package org

import java.sql.{ResultSet, Statement}

class DbOperations(stmt: Statement) {

  def add: Int = {
    val sqlInsert = "INSERT INTO myusers VALUES (2,'Zara', 23);"
    stmt.executeUpdate(sqlInsert)
  }

  def update(userid:Int): Int = {
    val sqlUpdate = s"UPDATE myusers SET name='Zoya' where id=$userid;"
    stmt.executeUpdate(sqlUpdate)
  }

  def get(userid:Int):ResultSet = {
    val sqlSelect = s"SELECT * FROM myusers where id=$userid;"
    stmt.executeQuery(sqlSelect)
  }

}

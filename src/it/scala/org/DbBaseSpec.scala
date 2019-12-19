package org

import java.io.FileReader
import java.sql.Connection

import org.scalatest.{WordSpec, Matchers}
import org.h2.tools.RunScript


class DbBaseSpec extends WordSpec with Matchers {

  def createJDBCTable( jdbcConnection: Connection): Unit = {
    val fileName = "src/it/resources/createTable.sql"
    RunScript.execute(jdbcConnection, new FileReader(fileName))
  }

  def cleanUpDatabase(jdbcConnection: Connection): Unit = {
    RunScript.execute(jdbcConnection, new FileReader("src/it/resources/dropTable.sql"))
    jdbcConnection.close()
  }
}

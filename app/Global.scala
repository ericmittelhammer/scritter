package global

import play.api._
import play.api.db._
import play.api.Play.current

import scala.slick.driver.MySQLDriver

import models.Tables

object Global extends GlobalSettings {

	lazy val dataSource = DB.getDataSource()
	
}
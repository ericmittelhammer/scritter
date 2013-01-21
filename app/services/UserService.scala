package services

import models.Tables
import models.User

import scala.slick.driver.{ ExtendedProfile, ExtendedDriver }
import scala.slick.session.Database.threadLocalSession

import javax.sql.DataSource

abstract class UserService {
	def findById(id: Int): Option[User]
}

class SlickUserService(ds: DataSource) extends UserService {

	this: ExtendedProfile with Tables =>

	import simple._

	val queries = new SlickUserServiceQueries() with ExtendedDriver with Tables

	override def findById(id: Int): Option[User] = Database.forDataSource(ds) withSession {
		queries.findById(id).firstOption
	}
}

class SlickUserServiceQueries {

	this: ExtendedProfile with Tables =>

	import simple._

	val findById = (id: Int) => for {
		u <- Users if u.id === id
	} yield u

}
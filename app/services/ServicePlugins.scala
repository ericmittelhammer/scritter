package services

import play.api._
import play.api.db._
import play.api.Play.current

import scala.slick.driver.H2Driver

import models.Tables
import services._


trait UserServiceProvider {
	val userService : UserService
}

class UserServicePlugin(app:Application) extends Plugin with UserServiceProvider {
	val userService = new SlickUserService(DB.getDataSource()) with H2Driver with Tables
}
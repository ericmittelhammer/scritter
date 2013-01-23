import play.api._
import play.api.db._
import play.api.Play.current

import scala.slick.driver.H2Driver

import models.Tables
import services.SlickUserService
/*
object Global extends GlobalSettings {

	lazy val ds = DB.getDataSource()

	lazy val userService = new SlickUserService(ds) with H2Driver with Tables
}*/
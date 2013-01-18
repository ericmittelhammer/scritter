package models

import scala.slick.driver.ExtendedProfile

trait Tables {

	this: ExtendedProfile =>

	import simple._

	implicit lazy val timestampTypeMapper = MappedTypeMapper.base[java.util.Date, java.sql.Timestamp](
		{ date => new java.sql.Timestamp(date.getTime()) },
		{ timestamp => new java.util.Date(timestamp.getTime()) })

	object Users extends Table[User]("users") {
		def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
		def username = column[String]("username")
		def email = column[String]("email")
		def passwordHash = column[String]("password_hash")
		def * = id.? ~ username ~ email ~ passwordHash <> (User, User.unapply _)
	}

	object Followers extends Table[(Int, Int)]("followers") {
		def user = column[Int]("user")
		def following = column[Int]("following")
		def * = user ~ following
	}

	object Screets extends Table[Screet]("screets") {
		def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
		def authorId = column[Int]("auhtor_id")
		def message = column[String]("message")
		def publishDate = column[java.util.Date]("publish_date", O.Default(new java.util.Date(System.currentTimeMillis)))
		def * = id.? ~ authorId ~ message ~ publishDate <> (Screet, Screet.unapply _)
	}
}
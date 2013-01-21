package models

//behold, the anemia...

case class User(id:Option[Int], username:String, email:String, passwordHash:String)

object AnonymousUser extends User(Some(0), "ANONYMOUS_USER", "ANONYMOUS_USER", "")

case class Screet(id:Option[Int], authorId:Int, message:String, publishDate:java.util.Date)
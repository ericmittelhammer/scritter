package models

case class User(id:Option[Int], username:String, email:String, passwordHash:String)

case class Screet(id:Option[Int], authorId:Int, message:String, publishDate:java.util.Date)
package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.Play.current

import global.Global

import models.User
import models.AnonymousUser

import services.UserService

object Application extends Controller {

	def userService = Global.userService

	def registrationForm = Form(tuple("username" -> text, 
									"email" -> email, 
									"password" -> text, 
									"passwordVerify" -> text ))

	def withUser(f: User => Request[AnyContent] => Result) = {
		Action { request =>
			request.session.get("userId").flatMap(id => userService.findById(id.toInt)) match {
				case Some(user) => f(user)(request)
				case _ => f(AnonymousUser)(request)
			}     
		}
	}

	def index = withUser { user => request =>
		if(user == AnonymousUser) Ok(views.html.index(user, registrationForm))
		else Ok(views.html.homepage(user))
	}

	def register = withUser { user => request =>
		Ok(views.html.homepage(user))
	}

}
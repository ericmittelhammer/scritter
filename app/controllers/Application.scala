package controllers

import play.api._
import play.api.mvc._

import models.User
import models.AnonymousUser
import global.Global

object Application extends Controller {

	def userService = Global.userService

	def withUser(f: User => Request[AnyContent] => Result) = {
	  Action { request =>
	    request.session.get("userId").flatMap(id => userService.findById(id.toInt)) match {
	    	case Some(user) => f(user)(request)
	    	case _ => f(AnonymousUser)(request)
	    	}     
		}
	}

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
}
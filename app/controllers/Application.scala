package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current

import models.User
import models.AnonymousUser

import services.UserServiceProvider

object Application extends Controller {

	def userService = current.plugin(classOf[UserServiceProvider]).get.userService

	def withUser(f: User => Request[AnyContent] => Result) = {
	  Action { request =>
	    request.session.get("userId").flatMap(id => userService.findById(id.toInt)) match {
	    	case Some(user) => f(user)(request)
	    	case _ => f(AnonymousUser)(request)
	    	}     
		}
	}

  def index = withUser { user => request =>
    Ok(views.html.index(user))
  }
  
}
package test

import org.specs2.mutable._
import org.specs2.mock._

import play.api.Plugin

import play.api.mvc._
import Results._

import play.api.test._
import play.api.test.Helpers._

import services._
import controllers._
import models._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends Mockito with Specification {
  /*
  "withUser" should {

    "return the AnonymousUser" in {
      val mockUserService = mock[services.UserService]
      mockUserService.findById(0) returns None
      //userService.findById(1) returns Some(models.User(Some(1), "testuser1", "testuser1@example.com", "testpwhash"))

      class TestUserServiceProvider(app:Application) extends Plugin with UserServiceProvider{
        val userService = mockUserService
      }

      implicit val request = FakeRequest().withSession("userId" -> "0")

      running(FakeApplication(additionalPlugins = Seq("TestUserServiceProvider"))) {
        
        Application.withUser { user => request =>
          user must beEqualTo(AnonymousUser)
          Ok("ok")
        } 
    
      }
    }*/
    /*
    "send 404 on a bad request" in {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/boum")) must beNone        
      }
    }
    
    "render the index page" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("Your new application is ready.")
      }
    }*/
  }
}
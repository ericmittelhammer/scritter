package test

import org.specs2.mutable._
import org.specs2.specification._

import play.api.test._
import play.api.test.Helpers._

import scala.slick.driver.H2Driver
import scala.slick.driver.H2Driver.simple._
import Database.threadLocalSession

import models.User
import models.Tables
import services.{UserService, SlickUserService}

class UserServiceSpec extends Specification {
  
  "findById(2)" should {
    
    "return testuser2" in new UserServiceSpecScope {
      userService.findById(2).get.username must beEqualTo("testuser2")
    }
    /*
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

trait UserServiceSpecScope extends Scope {
    val ds = new org.h2.jdbcx.JdbcDataSource
    ds.setURL("jdbc:h2:mem:USerServiceSpecDB;DB_CLOSE_DELAY=-1")

    ds.getConnection().createStatement().execute("DROP ALL OBJECTS") //reset the DB

    val t = new Tables with H2Driver

    Database.forDataSource(ds) withSession {

      t.Users.ddl.create
      
      t.Users.insert( User(Some(1), "testuser1", "testuser1@testuser.com", "testpwhash") )
      t.Users.insert( User(Some(2), "testuser2", "testuser2@testuser.com", "testpwhash") )

    }

    val userService = new SlickUserService(ds) with H2Driver with Tables
  }
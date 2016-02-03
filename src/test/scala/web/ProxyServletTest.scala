package web

/**
  * Created by salim on 03/02/2016.
  */
import org.scalatest.FunSuiteLike
import org.scalatra.ScalatraServlet
import org.scalatra.test.scalatest.ScalatraSuite

class ProxyServletTest extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[ProxyServlet], "/*")

  class FixtureServlet extends ScalatraServlet {
    get("/") {

    }
  }


    test("simple get") {
    get("/status") {
      status should equal (200)
      body should include ("OK!")
    }
  }
}
package web

/**
  * Created by salim on 03/02/2016.
  */

import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest.ScalatraSuite
class FixtureServlet extends JSONServlet {
  var hitCount: Int = 0

  get("/status") {
    val ret = s"OK! $hitCount"
    hitCount += 1
    ret
  }

  get("/foo") {
    val baseUrl = request.getRequestURL.toString
    List("a", "b", "c").map((s: String) =>
      EndpointInfo(baseUrl + "/" + s)
    )
  }


}

class ProxyServletTest extends ScalatraSuite with FunSuiteLike {



  addServlet(classOf[FixtureServlet], "/fixtures/*")
  addServlet(classOf[ProxyServlet], "/proxy/*")

  test("get status") {
    get("/proxy/status") {
      status should equal(200)
      body should include("OK!")
    }
  }

  test("get foo") {
    get("/proxy/foo") {
      status should equal(200)
    }
  }

  test("verify fixtures") {
    get("/fixtures/foo") {
      status should equal(200)
      //      body should include ("a" +
      //        "")
    }
  }

}
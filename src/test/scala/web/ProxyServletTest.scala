package web

/**
  * Created by salim on 03/02/2016.
  */
import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest.ScalatraSuite

class ProxyServletTest extends ScalatraSuite with FunSuiteLike {



  class FixtureServlet extends JSONServlet {

    get("/fixtures") {
      "hello"
    }

    get("/foo") {
      val all:List[EndpointInfo] = List(
        EndpointInfo("http://foo.bar.baz"),
        EndpointInfo("http://foo.bar.bof"),
        EndpointInfo("http://foo.bar.boo")
      )
      all
    }

  }

  addServlet(classOf[ProxyServlet], "/fixtures/*")
  addServlet(classOf[ProxyServlet], "/proxy/*")

  test("get status") {
    get("/proxy/status") {
      status should equal (200)
      body should include ("OK!")
    }
  }

  test("get foo") {
    get("/proxy/foo") {
      status should equal (200)
    }
  }

  test("verify fixtures") {
    get("/fixtures/foo") {
      status should equal (200)
//      body should include ("a" +
//        "")
    }
  }

}
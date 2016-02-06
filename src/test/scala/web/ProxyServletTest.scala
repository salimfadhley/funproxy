package web

/**
  * Created by salim on 03/02/2016.
  */

import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest.ScalatraSuite


class ProxyServletTest extends ScalatraSuite with FunSuiteLike {
  val model = new ProxyModel(EndpointInfo.makeFromStrings(List("http://foo.bar", "http://bar.foo")))
  addServlet(new FixtureServlet, "/fixtures/*")
  addServlet(new ProxyServlet(model), "/proxy/*")

  test("get fixtures status") {
    get("/fixtures/status") {
      status should equal(200)
      JsonDecode.decodeStatus(body).status should include("OK!")
    }

  }

  test("get proxy status") {
    get("/proxy/status") {
      status should equal(200)
      JsonDecode.decodeStatus(body).status should include("OK!")
    }
  }

  test("get foo") {
    get("/proxy/status") {
      status should equal(200)
    }
  }


  test("build model from fixtures content") {
    get("/fixtures/foo") {
      ProxyModel(JsonDecode.decodeEndpointInfoList(body))
    }
  }
}


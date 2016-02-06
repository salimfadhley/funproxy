package web

/**
  * Created by salim on 03/02/2016.
  */
import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest.ScalatraSuite


class FixtureServlet extends JSONServlet {
  var hitCount: Int = 0

  get("/status") {
    new StatusInfo(request.getRequestURL.toString, 0, "OK!")
  }

  get("/foo") {
    val baseUrl = request.getRequestURL.toString
    new EndpointInfo(List("a", "b", "c").map((s: String) =>
      SingleEndpointInfo(baseUrl + "/" + s)
    ))
  }

  get("/foo/a") {
    "a"
  }

  get("/foo/b") {
    "c"
  }

  get("/foo/c") {
    "c"
  }

}

class ProxyServletTest extends ScalatraSuite with FunSuiteLike {
  addServlet(classOf[FixtureServlet], "/fixtures/*")

  val model = new ProxyModel(EndpointInfo.makeFromStrings(List("http://foo.bar", "http://bar.foo")))
  addServlet(new ProxyServlet(model), "/proxy/*")

  test("get status") {

    get("/fixtures/status") {
      status should equal(200)
      JsonDecode.decodeStatus(body).status should include("OK!")
    }

  }

  test("get foo") {
    get("/proxy/foo") {
      status should equal(200)
    }
  }


  test("build model from fixtures content") {
    get("/fixtures/foo") {
      ProxyModel(JsonDecode.decodeEndpointInfoList(body))
    }
  }
}

class ProxyServletWithActualData extends ScalatraSuite with FunSuiteLike {
  val model = new ProxyServlet(ProxyModel.defaultProxyModel)
  addServlet(new FixtureServlet, "/fixtures/*")
  addServlet(model, "/proxy/*")

  test("update model from fixtures") {

    model.updateFromWeb()

  }





}
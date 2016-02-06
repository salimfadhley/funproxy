package web

import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest.ScalatraSuite

class ProxyServletTestWithActualData extends ScalatraSuite with FunSuiteLike {
  val model = ProxyModel.defaultProxyModel

  val proxyServlet = new ProxyServlet(model)
  addServlet(proxyServlet, "/proxy/*")

  val fixturesServlet = new FixtureServlet
  addServlet(fixturesServlet, "/fixtures/*")

  test("verify that the fixture servlet is wired up") {
    get(s"/fixtures/status") {
      status should equal(200)
    }
  }

  test("verify that the proxy servlet is wired up") {
    get(s"/proxy/status") {
      status should equal(200)
    }
  }

  test("update model from fixtures") {

    val port: Int = localPort match {
      case Some(x) => x
      case _ => throw new RuntimeException("No port")
    }
    model.updateFromWeb(s"http://localhost:$port/fixtures/foo")

    assert(model.roundRobinUrl==s"http://localhost:$port/fixtures/foo/a")
    assert(model.roundRobinUrl==s"http://localhost:$port/fixtures/foo/b")
//
//    get(s"/proxy/") {
//      status should equal(200)
//      assert("c"==body)
//    }
//
//
  }


}
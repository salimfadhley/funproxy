/**
  * Created by salim on 30/01/2016.
  */

package web

import org.scalatra.ScalatraServlet
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

class ProxyServlet extends ScalatraServlet with JacksonJsonSupport{

  var hitCount:Int = 0

  before() {
    contentType = formats("json")
  }

  get("/") {
    response.setHeader("content-type", "text/html")
    val ret =s"<html><head><title>Hello World ${hitCount}</title></head><body><p>Hello World ${hitCount}!</p></body></html>"
    hitCount += 1
    ret
  }

  get("/status") {
    "OK!"
  }

  get("/foo") {
    val all:List[EndpointInfo] = List(
      EndpointInfo("http://foo.bar.baz"),
      EndpointInfo("http://foo.bar.bof"),
      EndpointInfo("http://foo.bar.boo")
    )

    all
  }

  protected implicit val jsonFormats: Formats = DefaultFormats
}


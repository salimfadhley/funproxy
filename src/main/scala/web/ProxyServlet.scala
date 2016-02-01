/**
  * Created by salim on 30/01/2016.
  */

package web

import org.scalatra.ScalatraServlet

class ProxyServlet extends ScalatraServlet {

  var hitCount:Int = 0

  //  protected implicit val jsonFormats: Formats = DefaultFormats

  get("/") {



    response.setHeader("content-type", "text/html")
    val ret =s"<html><head><title>Hello World ${hitCount}</title></head><body><p>Hello World ${hitCount}!</p></body></html>"
    hitCount += 1
    ret
  }
}

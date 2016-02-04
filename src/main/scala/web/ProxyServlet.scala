/**
  * Created by salim on 30/01/2016.
  */

package web


class ProxyServlet extends JSONServlet{
  var hitCount:Int = 0

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


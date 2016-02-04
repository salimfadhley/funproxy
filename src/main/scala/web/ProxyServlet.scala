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
    val all:List[EndpointInfo] = List(
      EndpointInfo("http://foo.bar.baz"),
      EndpointInfo("http://foo.bar.bof"),
      EndpointInfo("http://foo.bar.boo")
    )
    all
  }


}


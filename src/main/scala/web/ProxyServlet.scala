/**
  * Created by salim on 30/01/2016.
  */

package web


class ProxyServlet(model:ProxyModel) extends JSONServlet{
  def updateFromWeb(): Unit = {}

  var hitCount:Int = 0

  get("/foo") {
    val baseUrl = request.getRequestURL.toString
    val foo = List("a", "b", "c")
    EndpointInfo(foo.map((s: String) =>
      SingleEndpointInfo(baseUrl + "/" + s)
    ))
  }


}


/**
  * Created by salim on 30/01/2016.
  */
class ProxyServlet extends ScalatraServlet {

  //  protected implicit val jsonFormats: Formats = DefaultFormats

  get("/") {

    response.setHeader("content-type", "text/html")

    "<html><head><title>Hello World!</title></head><body><p>Hello World</p></body></html>"

  }
}

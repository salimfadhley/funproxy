package web

/**
  * Created by salim on 06/02/2016.
  */
class FixtureServlet extends JSONServlet {
  var hitCount: Int = 0

  get("/status") {
    val url: String = request.getRequestURL.toString
    val baseUrl: String = url.slice(0, url.length - 7)
    new StatusInfo(baseUrl, 0, "OK!")
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
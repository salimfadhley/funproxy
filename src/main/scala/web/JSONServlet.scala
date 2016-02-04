package web

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport

/**
  * Created by salim on 04/02/2016.
  */
class JSONServlet extends ScalatraServlet with JacksonJsonSupport{

  before() {
    contentType = formats("json")
  }

  protected implicit val jsonFormats: Formats = DefaultFormats
}
package web

import org.json4s._
import org.json4s.jackson.JsonMethods._



object JsonDecode {
  implicit val formats = DefaultFormats

  val notNullFormats = new DefaultFormats {
    override val allowNull = false
  }

  def decodeEndpointInfoList(json: String): List[EndpointInfo] = {
    List(new EndpointInfo("http://foo"))
    parse(json).extract[List[EndpointInfo]]
  }

}
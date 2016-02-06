package web

/**
  * Created by sal on 03/02/16.
  */
case class SingleEndpointInfo(url:String)

case class EndpointInfo(endpoints:List[SingleEndpointInfo])

object EndpointInfo {
  def makeFromStrings(endpoints: List[String]): EndpointInfo = {
    new EndpointInfo(endpoints.map((s: String) => new SingleEndpointInfo(s)))
  }
}


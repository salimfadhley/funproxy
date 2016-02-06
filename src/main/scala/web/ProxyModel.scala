package web

import scala.io.{BufferedSource, Source}

/**
  * Created by salim on 06/02/2016.
  */


/*

import scala.io.Source
val html = Source.fromURL("http://google.com")
val s = html.mkString
println(s)


 */

case class ProxyModel(var endpoints:EndpointInfo, var accessCount:Int=0) {
  def updateFromWeb(url: String): Unit = {
    endpoints = JsonDecode.decodeEndpointInfoList(Source.fromURL(url).mkString)
  }


  def getAndIncrementCount:Int = {
    val result = accessCount
    accessCount += 1
    result
  }

  def getAndIncrementSourceIndex:Int = {
    getAndIncrementCount % endpoints.endpoints.length
  }


  def roundRobinUrl:String = {
    endpoints.endpoints(getAndIncrementSourceIndex).url
  }
}

object ProxyModel {

  def defaultProxyModel:ProxyModel = new ProxyModel(endpoints = EndpointInfo.makeFromStrings(List()))
}
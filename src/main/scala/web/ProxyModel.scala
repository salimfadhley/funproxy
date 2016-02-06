package web

/**
  * Created by salim on 06/02/2016.
  */
case class ProxyModel(var endpoints:EndpointInfo, var accessCount:Int=0) {

  def roundRobinUrl = {
    endpoints.endpoints(getAndIncrementSourceIndex).url
  }


  def getAndIncrementCount:Int = {
    val result = accessCount
    accessCount += 1
    result
  }

  def getAndIncrementSourceIndex:Int = {
    getAndIncrementCount % endpoints.endpoints.length
  }

}

object ProxyModel {

  def defaultProxyModel:ProxyModel = new ProxyModel(endpoints = EndpointInfo.makeFromStrings(List()))
}
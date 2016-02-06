package web

/**
  * Created by salim on 06/02/2016.
  */
case class ProxyModel(endpoints:EndpointInfo, var accessCount:Int=0) {

  def getAndIncrementCount:Int = {
    val result = accessCount
    accessCount += 1
    result
  }

  def getAndIncrementSourceIndex:Int = {
    getAndIncrementCount % endpoints.endpoints.length
  }

}

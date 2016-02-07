/**
  * Created by salim on 30/01/2016.
  */

package web


class ProxyServlet(model:ProxyModel) extends JSONServlet{
  def updateFromWeb(): Unit = {}

  get("/x") {
//    model.fetchReSult()
    List("A", "B", "C")
  }

  get("/status") {
    new StatusInfo(url=request.getRequestURL.toString, model.accessCount, "OK!")
  }

  get("/") {
    new StatusInfo(url=request.getRequestURL.toString, model.accessCount, "OK!")
  }
}


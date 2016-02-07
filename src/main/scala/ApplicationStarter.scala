import java.net.InetSocketAddress

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletHolder

import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener
import web.{EndpointInfo, ProxyModel, ProxyServlet}

/**
  * Created by sal on 31/01/16.
  */
object ApplicationStarter extends App {

  def buildJettyServer() = {
    val socketAddress = new InetSocketAddress(8080)
    val server = new Server(socketAddress)
    val context = new WebAppContext()
    context.setContextPath("/")
    context.setResourceBase("src/main/webapp")
    context.addEventListener(new ScalatraListener)
    server.setHandler(context)
    server
  }

  val model = ProxyModel.defaultProxyModel
  val server = buildJettyServer()

  server.start()
  server.join()

}

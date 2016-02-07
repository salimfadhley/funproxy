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

  def buildJettyServer(model:ProxyModel) = {
    val socketAddress = new InetSocketAddress(8080)
    val server = new Server(socketAddress)
    val context = new WebAppContext()

    val servlet = new ProxyServlet(model)
    val servletHolder:ServletHolder = new ServletHolder(servlet)

    context.setContextPath("/")
    context.setResourceBase("src/main/webapp")

    context.addEventListener(new ScalatraListener)
    context.addServlet(servletHolder, "/")
    server.setHandler(context)
    server
  }

  val model = ProxyModel.defaultProxyModel
  val server = buildJettyServer(model)

  server.start()
  server.join()

}

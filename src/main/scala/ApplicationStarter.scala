import java.net.InetSocketAddress

import org.eclipse.jetty.server.Server

import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener
import web.ProxyServlet

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
    context.addServlet(classOf[ProxyServlet], "/")
    server.setHandler(context)
    server
  }

  val server = buildJettyServer()

  server.start()
  server.join()

}

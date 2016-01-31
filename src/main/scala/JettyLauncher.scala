//package launch
//
//import org.eclipse.jetty.server.Server
//import org.eclipse.jetty.webapp.WebAppContext
//import org.scalatra.servlet.ScalatraListener
//import proxy.ProxyServlet
//
//object JettyLauncher extends App {
//  val port = 8082
//  val server: Server = new Server(port)
//  val context = new WebAppContext()
//
//  context.setContextPath("/")
//  context.setResourceBase("src/main/webapp")
//
//  context.addEventListener(new ScalatraListener)
//  context.addServlet(classOf[ProxyServlet], "/")
//  server.setHandler(context)
//
//  server.start()
//  server.join()
//}

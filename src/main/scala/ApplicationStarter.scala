import java.net.InetSocketAddress

/**
  * Created by sal on 31/01/16.
  */
object ApplicationStarter extends App {
  val socketAddress = new InetSocketAddress(8080)
  val server = new Server(socketAddress)
  val context = new WebAppContext()
  context.setContextPath("/")
  context.setResourceBase("src/main/webapp")
  context.addEventListener(new ScalatraListener)
  context.addServlet(classOf[DefaultServlet], "/")
  server.setHandler(context)
  server.start()
  server.join()

}

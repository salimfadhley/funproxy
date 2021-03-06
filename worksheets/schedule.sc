import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

val system = akka.actor.ActorSystem("system")
system.scheduler.schedule(0 seconds, 1 seconds)(AuthTasker.cleanTokens)
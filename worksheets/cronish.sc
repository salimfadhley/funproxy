import cronish._
import cronish.dsl._

val schedule: Cron = Cron("*/2", "*", "*", "*", "*", "*", "*")

def foo = {
  val msg = "hello"
  println(msg)
  msg
}

foo



job(foo).describedAs("General Greetings").runs(schedule)

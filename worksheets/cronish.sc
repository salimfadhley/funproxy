import cronish._

Cron("0", "*/3", "1,9,22", "11-26", "1-6", "*", "2003")

job (println("Hello there")) describedAs "General Greetings"
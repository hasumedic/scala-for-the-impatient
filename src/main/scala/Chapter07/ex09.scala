package Chapter07

object ex09 extends App {

  import java.lang.System

  val username = System.getProperty("user.name")
  val password = readLine()

  if (password != "secret") error("ERROR! Password is not secret.")
  else println("Welcome, boss.")
}

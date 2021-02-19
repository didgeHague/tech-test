package uk.co.qsc.tt

import org.scalatra._

class TechTestApi extends ScalatraServlet {

  val searchKey = "AIzaSyAc3heo3mrVByUG9PZuOxw6_0l9fK9SoLs"
  val cse = "37972183bae83bf19"

  get("/") {
    views.html.hello()
  }

  get("/primes"){
    val input = params.get("input").map(_.toInt)
    val algorithm = params.get("algorithm")

    input match {
      case None => halt(400 , "parameter input cannot be empty")
      case Some(value) => {
        algorithm match {
          case None => Ok(Primes.primesFilter(value).mkString(","))
          case Some("sieve") =>  Ok(Primes.primesSieve(value).mkString(","))
          case Some("filter") => Ok(Primes.primesFilter(value).mkString(","))
          case Some(_) => halt(400, "algorithm not found: " + _)
        }
      }
    }
  }
}

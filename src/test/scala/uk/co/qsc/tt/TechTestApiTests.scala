package uk.co.qsc.tt

import org.scalatra.test.scalatest._

class TechTestApiTests extends ScalatraFunSuite {

  addServlet(classOf[TechTestApi], "/*")

  test("GET /primes on TestApi should return status 500") {
    get("/primes") {
      status should equal (400)
      body should equal ("parameter input cannot be empty")
    }
  }

  test("GET /primes with input parameter on TestApi should return status 200 and primes") {
    get("/primes", List(("input", "5")))  {
      status should equal (200)
      body should equal ("2,3,5")
    }
  }

  test("GET /primes with 5 and sieve on TestApi should return status 200 and primes") {
    get("/primes", List(("input", "5"), ("algorithm", "sieve")))  {
      status should equal (200)
      body should equal ("2,3,5")
    }
  }

  test("GET /primes with 5 and filter on TestApi should return status 200 and primes") {
    get("/primes", List(("input", "5"), ("algorithm", "filter")))  {
      status should equal (200)
      body should equal ("2,3,5")
    }
  }

  test("GET /primes with 50 and sieve on TestApi should return status 200 and primes") {
    get("/primes", List(("input", "50"), ("algorithm", "sieve")))  {
      status should equal (200)
      body should equal ("2,3,5,7,11,13,17,19,23,29,31,37,41,43,47")
    }
  }

  test("GET /primes with 50 and filter on TestApi should return status 200 and primes") {
    get("/primes", List(("input", "50"), ("algorithm", "filter")))  {
      status should equal (200)
      body should equal ("2,3,5,7,11,13,17,19,23,29,31,37,41,43,47")
    }
  }
}

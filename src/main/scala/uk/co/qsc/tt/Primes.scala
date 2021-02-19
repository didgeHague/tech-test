package uk.co.qsc.tt


object Primes {

  def primesSieve(end: Int): List[Int] = {
    val no_of_primes = sieveOfEratosthenes(numberStream(2))
    (no_of_primes take end).filter(_ <= end).toList
  }

  def numberStream(n: Int):
  LazyList[Int] = LazyList.from(n)

  def sieveOfEratosthenes(stream: LazyList[Int]):
  LazyList[Int] = stream.head #:: sieveOfEratosthenes(
    (stream.tail)
      filter (x => x % stream.head!= 0)
  )

  def primesFilter(end: Int): List[Int] = {
    (numberStream(2) take end).filter(isPrime).toList
  }

  def isPrime(i: Int): Boolean =
    if (i <= 1)
      false
    else if (i == 2)
      true
    else
      !(2 until i).exists(n => i % n == 0)
}

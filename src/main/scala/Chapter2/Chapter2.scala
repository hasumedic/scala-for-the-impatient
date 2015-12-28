package Chapter2

object Chapter2 {

  // Exercise 1
  // The signum of a number is 1 if the number is positive, -1 if it is negative, and 0 if it is zero. Write a function that computes this value
  def signum(i: Long): Int = {
    if (i == 0) 0
    else if (i > 0) 1
    else -1
  }

  //Exercise 2
  // What is the value of an empty block expression {}? Empty value/ no value
  // What is its type? Unit

  //Exercise 3
  // Come up with one situation where the assignment x = y - 1 is valid in Scala. (Hint: Pick a suitable type for x.)
  // When 'y' contains a numeric type, x will type infer the numeric computation of y - 1. I'd also work for other types like Chars.

  //Exercise 4
  // Write a Scala equivalent for the Java loop
  // for(int i = 10; i >= 0; i--) System.out.println(i);
  def exercise4(): Unit =
    (10 to 0 by -1).foreach(println)

  //Exercise 5
  // Write a procedure countdown(n: Int) that prints the numbers from n to 0
  def countdown(start: Int): Unit = {
    if (start > 0) (start to 0 by -1).foreach(println)
    else if (start < 0) (start to 0).foreach(println)
    else println(start)
  }

  //Exercise 6
  // Write a for loop for computing the product of the Unicode codes of all letters in a string. For example the product of the characters in "Hello" is 9415087488L
  def unicodeProduct(word: String): Long = {
    (for {char <- word} yield char.toLong).product
  }

  //Exercise 7
  // Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
  def unicodeProductNoLoop(word: String): Long = {
    word map (_.toLong) product
  }

  //Exercise 8
  // Write a function product(s: String) that computes the product, as described in the preceding exercises
  def product(s: String): Long = {
    unicodeProduct(s)
  }

  //Exercise 9
  // Make the function of the preceding exercise a recursive function
  def recursiveProduct(s: String): Long = {
    if (s.isEmpty) 1
    else s(0) * recursiveProduct(s.drop(1))
  }

  //Exercise 10
  // Write a function that computes x to the n, where n is an integer. Use the following recursive definition:
  // x to the n = y * y if n is even and positive, where y = x to the n/2
  // x to the n = x * x to the n-1 if n is odd and positive
  // x to the 0 = 1
  // x to the n = 1 / x to the -n if n is negative
  // Don't use return statement
  def pow(x: Long, n: Int): Float = {
    if (n == 0) 1
    else if (n % 2 == 0 && n > 0) pow(x, n / 2) * pow(x, n / 2)
    else if (n % 2 != 0 && n > 0) x * pow(x, n - 1)
    else 1 / pow(x, -n)
  }
}


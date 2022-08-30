/*
There's some unrest in the minion ranks: minions with ID numbers like "1", "42", and other "good" numbers have been lording it over the poor minions who are stuck with more boring IDs. To quell the unrest, Commander Lambda has tasked you with reassigning everyone new random IDs based on a Completely Foolproof Scheme.

Commander Lambda has concatenated the prime numbers in a single long string: "2357111317192329...". Now every minion must draw a number from a hat. That number is the starting index in that string of primes, and the minion's new ID number will be the next five digits in the string. So if a minion draws "3", their ID number will be "71113".

Help the Commander assign these IDs by writing a function solution(n) which takes in the starting index n of Lambda's string of all primes, and returns the next five digits in the string. Commander Lambda has a lot of minions, so the value of n will always be between 0 and 10000.
 */

public class Reid {

  public static String solution(int n) {
    int upperBound = n + 5;
    StringBuilder primes = new StringBuilder("2");

    // Generate primes until n + 5
    int curr = 3;
    while (primes.length() < upperBound) {
      if (isPrime(curr)) {
        primes.append(curr);
      }
      curr++;
    }

    return primes.substring(n, upperBound);
  }

  private static boolean isPrime(int num) {
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(solution(3));
  }
}

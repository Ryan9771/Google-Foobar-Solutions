import static org.junit.Assert.assertSame;

public class QueueToDo {

  public static int solution(int curr, int length) {
    int res = curr; // Initialize res to start value
    int skip = 0; // Initialize skip to 0
    while (length > 0) { // want to process until list length is -
      for (int i = 0; i < length; i++) { // iterate curr length of the list
        if (!(skip == 0
            && i == 0)) { // Edge case -> very first value (don't want to process first num twice)
          curr++; // increment current value
          res ^= curr; // res = res ^ start
        }
      }
      length--; // decrement length
      curr += skip; // increment current value according to the skip value
      skip++; // increment the skip value
    }
    return res;
  }

  public static void main(String[] args) {
    assertSame(solution(0, 3), 2);
    assertSame(solution(17, 4), 14);
  }
}

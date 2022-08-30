import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MinionSolution {

  /**
   * Takes a list of integers and a number and returns the same list but with all numbers that occur
   * > n times removed.
   *
   * @param data The list of integers.
   * @param n The number of occurrences to remove items based on.
   * @return The list with numbers occuring ≤ n times.
   */
    public static int[] solution(int[] data, int n) {
      List<Integer> list = Arrays.stream(data).boxed().collect(Collectors.toList());
      Set<Integer> set = Arrays.stream(data).boxed().collect(Collectors.toSet());
      for (int elem : set) {
        if (Collections.frequency(list, elem) > n) {
          list.removeAll(Collections.singleton(elem));
        }
      }
      int[] res = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
      }
      return res;
    }

  public static void main(String[] args) {
    int[] test = {1, 2, 2, 3, 3, 3, 4, 5, 5};
    int[] solution = solution(test, 1);
    for (int sol : solution) {
      System.out.println(sol);
    }
  }
}

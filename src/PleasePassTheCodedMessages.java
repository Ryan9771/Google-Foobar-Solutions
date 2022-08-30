import java.util.*;
import java.util.stream.Collectors;

public class PleasePassTheCodedMessages {
  public static int solution(int[] nums) {
    List<Integer> numsList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
    int maxSum = 0;
    int maxIndex = -1;

    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = 0; j < nums.length; j++) {
        if (j != i) {
          sum += numsList.get(j);
        }
      }
      if (sum % 3 == 0 && sum > maxSum) {
        maxIndex = i;
      }
    }

    if (maxIndex == -1) {
      return 0;
    }

    numsList.remove(maxIndex);
    numsList.sort(Collections.reverseOrder());

    return Integer.parseInt(
        numsList.stream().map(Objects::toString).collect(Collectors.joining("")));
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{3,1,4,1}));
  }
}

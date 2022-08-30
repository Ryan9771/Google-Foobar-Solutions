import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HeyIAlreadyDidThat {

  public static int solution(String n, int b) {
    String length = "%0" + n.length() + "d";
    List<String> tracker = new ArrayList<>();
    return solutionHelper(n, b, tracker, length);
  }

  private static int solutionHelper(String n, int b, List<String> tracker, String lenFormat) {
    String[] str = n.split("");
    List<String> input = new ArrayList<>();
    Collections.addAll(input, str);
    List<String> sorted =
        input.stream()
            .map(Integer::parseInt)
            .sorted()
            .map(Object::toString)
            .collect(Collectors.toList());

    int smaller = Integer.parseInt(String.join("", sorted));
    Collections.reverse(sorted);
    int larger = Integer.parseInt(String.join("", sorted));

    int subRes = baseConverter(larger, b, 10) - baseConverter(smaller, b, 10);
    String newN = String.format(lenFormat, baseConverter(subRes, 10, b));

    if (tracker.contains(newN)) {
      int index = tracker.indexOf(newN);
      return tracker.size() - index;
    }

    tracker.add(newN);
    return solutionHelper(newN, b, tracker, lenFormat);
  }

  private static int baseConverter(int num, int from, int to) {
    if (num == 0) {
      return 0;
    }

    List<Integer> res = new ArrayList<>();

    if (to == 10) {
      List<Integer> numList = toDigits(num);
      for (int i = 0; i < numList.size(); i++) {
        int resCalc = (int) (numList.get(i) * (Math.pow(from, (numList.size() - i - 1))));
        res.add(resCalc);
      }
      return res.stream().mapToInt(Integer::intValue).sum();
    }

    while (num != 0) {
      res.add(num % to);
      num = num / to;
    }

    Collections.reverse(res);
    String str = res.stream().map(Object::toString).collect(Collectors.joining(""));
    return Integer.parseInt(str);
  }

  private static List<Integer> toDigits(int num) {
    List<Integer> res = new ArrayList<>();
    while (num != 0) {
      res.add(num % 10);
      num = num / 10;
    }
    Collections.reverse(res);
    return res;
  }

  public static void main(String[] args) {
    System.out.println(solution("210022", 3));
  }
}

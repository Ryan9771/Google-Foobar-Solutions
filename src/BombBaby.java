public class BombBaby {
  public static String solution(String x, String y) {
    long prog_x = Long.parseLong(x);
    long prog_y = Long.parseLong(y);
    int counter = 0;
    while (prog_x >= 1 && prog_y >= 1) {
      if (prog_x == 1 && prog_y == 1) {
        break;
      }
      if (prog_x > prog_y) {
        prog_x = prog_x - prog_y;
      } else {
        prog_y = prog_y - prog_x;
      }
      counter++;
    }
    if (prog_x == 1 && prog_y == 1) {
      return String.valueOf(counter);
    }
    return "impossible";
  }

  public static void main(String[] args) {
    System.out.println(solution("4", "7"));
  }
}

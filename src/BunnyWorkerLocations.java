public class BunnyWorkerLocations {

  public static String solution(long x, long y) {
    return String.valueOf((((x * x + 1) / 2) + ((y - 1) * x) + (((y - 2) * (y - 1)) / 2)));
  }

  public static void main(String[] args) {
    System.out.println((int) Math.pow(50000, 2));
    System.out.println(50000 * 50000);
    System.out.println((long) Math.pow(50000, 2));
    System.out.println(50000L * 50000L);
    System.out.println((int) (500 * 500 + 500));
    System.out.println(500 * 500 + 500);
  }
}

public class IonFluxRelabeling {

  public static int[] solution(int h, int[] q) {

    int nodes = (int) Math.pow(2, h) - 1;
    int[] tree = new int[nodes];
    int[] sequence = buildSequence(nodes);
    treeCreate(0, sequence.length, 0, tree, sequence);

    // finding result
    int[] res = new int[q.length];
    for (int i = 0; i < q.length; i++) {
      int ind = findIndex(tree, q[i]);
      if (ind == 0) {
        res[i] = -1;
      } else {
        res[i] = tree[(ind - 1) / 2];
      }
    }
    return res;
  }

  private static void treeCreate(int start, int end, int index, int[] tree, int[] sequence) {
    tree[index] = sequence[start];
    if (start + 1 != end) {
      treeCreate(start + 1, (end + start + 1) / 2, 2 * index + 2, tree, sequence);
      treeCreate((end + start + 1) / 2, end, 2 * index + 1, tree, sequence);
    }
  }

  private static int[] buildSequence(int nodes) {
    int[] res = new int[nodes];
    for (int i = nodes; i > 0; i--) {
      res[nodes - i] = i;
    }
    return res;
  }

  private static int findIndex(int[] array, int num) {
    // pre: number will always be in the array
    for (int i = 0; i < array.length; i++) {
      if (array[i] == num) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] seq = {19, 14, 28};
    int[] res = solution(5, seq);
    for (int i : res) {
      System.out.println(i);
    }
  }
}


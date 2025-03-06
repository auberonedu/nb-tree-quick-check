import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate
   * line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    if (!tree.containsKey(root)) {
      return;
    }

    System.out.println(root);

    List<Integer> childrenList = tree.get(root);

    for (Integer child : childrenList) {
      preOrder(tree, child);
    }

  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) {
    int minVal = Integer.MAX_VALUE;

    if (root == null) {
      return minVal;
    }

    // check root value
    if (root.value < minVal) {
      minVal = root.value;
    }

    for (Node<Integer> child : root.children) {
      // compare child val with current minVal
      if (child.value <= minVal) {
        minVal = child.value;
      }

      // recurse on child. update minVal if necessary
      int childMin = minVal(child);

      if (childMin < minVal) {
        minVal = childMin;
      }

    }

    return minVal;
    
  }

}

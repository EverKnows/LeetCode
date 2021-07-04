import java.util.ArrayList;
import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2021/6/3
 */
public class s437 {

    public int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        doWork(root, targetSum, new ArrayList<Integer>(), 1);
        return count;
    }

    private void doWork(TreeNode root, int targetSum, List<Integer> sum, int depth) {
        if (root == null) {
            return;
        }

        List<Integer> temp = new ArrayList<>(sum);

        if (temp.size() < depth) {
            for (int i = 0; i < temp.size(); i++) {
                temp.set(i, temp.get(i) + root.val);
                if (temp.get(i) == targetSum) {
                    count++;
                }
            }
            temp.add(root.val);
            if (root.val == targetSum) {
                count++;
            }
        }

        doWork(root.left, targetSum, temp, depth + 1);

        doWork(root.right, targetSum, temp, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        System.out.println(new s437().pathSum(root, 8));

    }
}
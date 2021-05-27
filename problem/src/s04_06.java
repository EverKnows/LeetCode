import java.util.ArrayList;
import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2021/5/27
 */
public class s04_06 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> nodeList = new ArrayList<>();
        MidOrder(root, nodeList);
        int index = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i) == p) {
                index = i;
            }
        }

        if (index == nodeList.size() - 1) {
            return null;
        }

        return nodeList.get(index);
    }

    private void MidOrder(TreeNode root, List<TreeNode> nodeList) {
        if (root == null) {
            return;
        }

        MidOrder(root.left, nodeList);
        nodeList.add(root);
        MidOrder(root.right, nodeList);
    }


}
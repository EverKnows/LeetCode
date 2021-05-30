import java.util.Arrays;

public class s889 {


    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        int leftBranchLen = 0;

        if (len == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        if (len == 1) {
            return root;
        }

        for (int i = 0; i < len; i++) {
            if (post[i] == pre[1]) {
                leftBranchLen = i + 1;
                break;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, 1 + leftBranchLen)
                                        , Arrays.copyOfRange(post, 0, leftBranchLen));

        root.right = constructFromPrePost(Arrays.copyOfRange(pre, 1 + leftBranchLen, pre.length)
                , Arrays.copyOfRange(post, leftBranchLen, post.length - 1));


        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new s889().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});


        new s889().prePrint(root);

        System.out.println("=====");
        new s889().postPrint(root);

    }

    private void prePrint(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            prePrint(root.left);
            prePrint(root.right);
        }
    }

    private void postPrint(TreeNode root) {
        if (root != null) {
            postPrint(root.left);
            postPrint(root.right);
            System.out.print(root.val);
        }
    }
}

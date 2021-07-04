import java.util.ArrayList;
import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2021/5/31
 */
public class s417 {

    public List<List<Integer>> result = new ArrayList<>();

    public int[][] heights;

    public int[][] flag;

    public boolean reachA = false;

    public boolean reachB = false;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;

        int row = heights.length;
        int col = heights[0].length;



        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flag = new int[row][col];
                reachA = false;
                reachB = false;
                if (doWork(i, j)) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    result.add(ans);
                }
            }
        }

        return result;
    }

    private boolean doWork(int i, int j) {
        flag[i][j] = 1;

        if (i == 0 || j == 0) {
            reachA = true;
        }

        if (i == heights.length - 1 || j == heights[0].length - 1) {
            reachB = true;
        }

        if (reachA && reachB) {
            return true;
        }

        if (i + 1 < heights.length && heights[i + 1][j] <= heights[i][j] && flag[i + 1][j] == 0) {
            if (doWork(i + 1, j)) {
                return true;
            }
        }

        if (i - 1 >= 0 && heights[i - 1][j] <= heights[i][j] && flag[i - 1][j] == 0) {
            if (doWork(i - 1, j)) {
                return true;
            }
        }

        if (j + 1 < heights[0].length && heights[i][j + 1] <= heights[i][j] && flag[i][j + 1] == 0) {
            if (doWork(i, j + 1)) {
                return true;
            }
        }

        if (j - 1 >= 0 && heights[i][j - 1] <= heights[i][j] && flag[i][j - 1] == 0) {
            if (doWork(i, j - 1)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] ans = {{1, 2, 2, 3, 5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};

        System.out.println(new s417().pacificAtlantic(ans));

    }
}
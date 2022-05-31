package array;


import java.util.ArrayList;
import java.util.List;

//leetcode 48
public class RotateImge {
    public void rotate(int[][] matrix) {
        int ttlCol = matrix[0].length;
        int ttlRow = matrix.length;
        int a = 0;
        List<Integer> tmpList = new ArrayList<>();

        while (a < ttlCol) {
            for (int row = ttlRow - 1; row >= 0; row--) {
                tmpList.add(Integer.valueOf(matrix[row][a]));
            }
            a++;
        }


        int b = 0;
        for (int i = 0; i < ttlRow; i++) {
            for (int j = 0; j < ttlCol; j++) {
                matrix[i][j] = tmpList.get(b).intValue();
                b++;
            }
        }


    }
}

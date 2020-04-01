package Java15;


import java.util.ArrayList;
import java.util.List;

public class Interview {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。
// 你需要将 grid 迁移 k 次
//每次「迁移」操作将会引发下述活动：
//位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
//位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
//位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
//请你返回 k 次迁移操作后最终得到的 二维网格
        List<List<Integer>> listlist = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        //获取行数
        int rowLength = grid.length;
        //获取列数
        int colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                list1.add(grid[i][j]);
            }
        }
        List<Integer> list2 = new ArrayList<>();
        int total = rowLength * colLength;
        int prev = total - k;
        int count = 0;
        while(count < total){

            list2.add(list1.get(prev % total));
            prev++;
            count++;
            if(count % colLength == 0){
                listlist.add(((List)new ArrayList<>(list1).clone()));
                list1.clear();
            }

        }
        return listlist;
    }
}

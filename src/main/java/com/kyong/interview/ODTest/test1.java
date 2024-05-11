package com.kyong.interview.ODTest;

/**
 * @author kyong
 * @date 2023/3/17 20:30
 */


/*你有一个用于表示一片土地的整数矩阵land，
该矩阵中每个点的值代表对应地点的海拔高度。
若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。
池塘的大小是指相连接的水域的个数。
写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。*/
/*
* 示例：
输入：
[
  [0,2,1,0],
  [0,1,0,1],
  [1,1,0,1],
  [0,1,0,1]
]
输出： [1,2,4]

提示：
0 < len(land) <= 1000
0 < len(land[i]) <= 1000*/
public class test1 {
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    Integer[] poolSize(int[][] arr){
        int m = arr.length; //长
        int n = arr[0].length;//宽
        boolean[][] visited = new boolean[m][n];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int size = dfs(arr, visited, m, n, i, j, 0);
                if(size>0){
                    res.add(size);
                }
            }
        }
        return (Integer[]) res.toArray();

    }

    int dfs(int[][] arr, boolean[][] visited, int m, int n,int i,int j, int poolSize){
        if(visited[i][j]||arr[i][j]!=0){
            return poolSize;
        }
        poolSize++;
        if(i-1>=0){
            dfs(arr,visited,m,n,i-1,j,poolSize);
            if(j-1>=0){
                dfs(arr,visited,m,n,i-1,j-1,poolSize);
            }
            if(j+1<=n){
                dfs(arr,visited,m,n,i-1,j+1,poolSize);
            }
        }
        if(i+1<=m){
             dfs(arr,visited,m,n,i+1,j,poolSize);
            if(j-1>=0){
                 dfs(arr,visited,m,n,i+1,j-1,poolSize);
            }
            if(j+1<=n){
                dfs(arr,visited,m,n,i+1,j+1,poolSize);
            }
        }
        if(j-1>=0){
             dfs(arr,visited,m,n,i,j-1,poolSize);
        }
        if(j+1<=n){
            dfs(arr,visited,m,n,i,j+1,poolSize);
        }
    }*/
}

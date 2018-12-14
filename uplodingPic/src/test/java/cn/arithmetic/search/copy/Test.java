package cn.arithmetic.search.copy;

/**
 * @Desc 题目：在数字矩阵中，从左上角到右下角，每次只能向右或向下，如何规划路径，能获得最大数字总和？
 * @author wzz
 */
public class Test {
	public static void main(String[] args) {

        int[][] matrix1 = {
            {300, 500, 560, 400, 160},
            {1000, 100, 200, 340, 690},
            {600, 500, 500, 460, 320},
            {300, 400, 250, 210, 760}
        };

        int[][] matrix2 = {
            {300, 500, 2560, 400},
            {1000, 100, 200, 340},
            {600, 500, 500, 460},
            {300, 400, 250, 210},
            {860, 690, 320, 760}
        };

        DeepFirstSearch dp = new DeepFirstSearch();

        System.out.println(dp.getMaxAward(matrix1));
        dp.printBestPath();

        System.out.println(dp.getMaxAward(matrix2));
        dp.printBestPath();
        
        System.out.println("+++++++++++++++++");
        
        BreadthFirstSearch dp2 = new BreadthFirstSearch();


    }
}

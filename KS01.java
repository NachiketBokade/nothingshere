public class KnapSack {
    static int [][]knapSack(int[] profit, int[] weight, int W, int N) {
        int[][] mat = new int[N + 1][W + 1];
       
        for (int i = 1; i <=N; i++) {
            

            for (int j = 1; j <=W; j++) {
                int withoutcurrent = mat[i-1][j];
                int withcurrent = 0;
                if(j>=weight[i-1]){
                    withcurrent = profit[i-1];
                    int remaining = j-weight[i-1];
                    withcurrent = withcurrent + mat[i-1][remaining]; 
                }
               
                mat[i][j] = Math.max(withoutcurrent, withcurrent);
                
            }
            
        }
        return mat;
    
    }

    public static void main(String[] args) {
        int profit[] = { 10, 15, 40 };
        int weight[] = { 1, 2, 3 };

        int W = 6;
        int N = profit.length;
        int[][] m1=knapSack(profit, weight, W, N);

        System.out.println(m1[N][W]);

    }

}

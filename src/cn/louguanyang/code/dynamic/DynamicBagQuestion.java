package cn.louguanyang.code.dynamic;

/**
 * 动态规划算法 解决 背包问题
 *
 * @author louguanyang
 * @createAt 2021/4/19 10:10 下午
 */
public class DynamicBagQuestion {

    private int maxCw = Integer.MIN_VALUE;

    private int[] weight;

    private int w;

    private boolean[][] status;

    public int getMaxCw(int[] weight, int w) {
        int n = weight.length;
        status = new boolean[n][ w + 1];
        // 第一行的数据要特殊处理，可以利用哨兵优化
        status[0][0] = true;
        if (weight[0] < w) {
            status[0][weight[0]] = true;
        }
        // 动态规划状态转移
        for (int i = 1; i <= n; i++) {
            // 不第i个物品放入背包
            for (int j = 0; j <= w; j++) {
                if (status[i - 1][j]) {
                    // 当前节点等于上一节点
                    status[i][j] = status[i - 1][j];
                }
            }
            //把第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (status[i - 1][j]) {
                    status[i - 1][(j +  weight[i])] = true;
                }
            }
        }

        for (int i = w; i >= 0; --i) {
            // 输出结果
            if (status[n - 1][i]) {
                return i;
            }

        }

        return this.maxCw;
    }

}

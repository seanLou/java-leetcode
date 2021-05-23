package cn.louguanyang.code.dynamic;

/**
 * 回溯算法 解决 背包问题
 *
 * @author louguanyang
 * @createAt 2021/4/19 10:10 下午
 */
public class BackTrackingBagQuestion {

    private int maxCw = Integer.MIN_VALUE;

    private int[] weight;

    private int w;

    private boolean[][] mem;

    public int getMaxCw(int[] weight, int w) {
        mem = new boolean[weight.length][w + 1];
        this.weight = weight;
        this.w = w;
        f(0, 0);
        return this.maxCw;
    }

    private void f(int i, int cw) {
        if (cw == w || i == weight.length) {
            this.maxCw = cw;
            return;
        }
        if (mem[i][cw]) {
            // 重复状态
            return;
        }
        // 记录(i, cw)这个状态
        mem[i][cw] = true;

        // 选择不装第i个物品
        f(i + 1, cw);

        if (cw + weight[i] > maxCw) {
            // 选择装第i个物品
            f(i, cw + weight[i]);
        }
    }


}

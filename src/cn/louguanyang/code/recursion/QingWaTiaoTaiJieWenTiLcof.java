package cn.louguanyang.code.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2 输出：2 示例 2：
 * <p>
 * 输入：n = 7 输出：21 示例 3：
 * <p>
 * 输入：n = 0 输出：1 提示：
 * <p>
 * 0 <= n <= 100
 *
 * @author louguanyang
 * @createAt 2021/3/20 3:01 下午
 */
public class QingWaTiaoTaiJieWenTiLcof {

  public static final int MAX_NUM = 1000000007;
  private static Map<Integer, Integer> cacheMap = new HashMap<>(100);

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      System.out.println("青蛙跳上一个 " + i + "级的台阶总共有 " + numWays(i) + " 种跳法");
    }
  }

  public static int numWays(int n) {
    // f(n) = f(n - 1) + f(n-2);
    // f(1) = 1;
    // f(2) = 2;
    if (n <= 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    // 避免重复查询，避免超时
    if (cacheMap.containsKey(n)) {
      return cacheMap.get(n);
    }
    int sum = numWays(n - 1) + numWays(n - 2);
    if (sum >= MAX_NUM) {
      sum -= MAX_NUM;
    }
    if (!cacheMap.containsKey(n)) {
      cacheMap.putIfAbsent(n, sum);
    }
    return sum;
  }
}

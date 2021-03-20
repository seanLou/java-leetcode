package cn.louguanyang.code.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0, F(1)= 1 F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2 输出：1 示例 2：
 * <p>
 * 输入：n = 5 输出：5
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 *
 * @author louguanyang
 * @createAt 2021/3/20 3:01 下午
 */
public class FeiBoNaQiShuLieLcof {

  public static final int MAX_NUM = 1000000007;
  private static Map<Integer, Integer> cache = new HashMap<>(100);

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      System.out.println("第" + i + "个 斐波那契数列的值是:" + fib(i));
    }
  }

  public static int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    Integer tmp = cache.get(n);
    if (tmp != null) {
      return tmp;
    }
    tmp = (fib(n - 1) + fib(n - 2));
    if (tmp >= MAX_NUM) {
      tmp -= 1000000007;
    }
    cache.putIfAbsent(n, tmp);
    return tmp;
  }

}

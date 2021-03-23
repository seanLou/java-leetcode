package cn.louguanyang.code.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author louguanyang
 * @createAt 2021/3/22 9:42 下午
 */
public class ShellSort {

  public static void main(String[] args) {
    int[] a = {4, 5, 6, 3, 2, 1};
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  /**
   * 4, 5, 6, 3, 2, 1 step = 6 / 2 = 3
   * <p>
   * 1.step = 3 i = 3, tmp = arr[3] = 3
   * <p>
   * j = 3 - 3 = 0
   * <p>
   * j >= 0 arr[0] = 4 > 3 --> arr[0 + 3] = arr[0] = 4
   * <p>
   * j = 0 - 3 < 0 -> break
   * <p>
   * arr[-3 + 3] = tmp = 3  当前数组->>> 3, 5, 6, 4, 2, 1
   * <p>
   * 2.step =  3 / 2 = 1 // 变为插入排序
   *
   * @param arr
   */
  public static void sort(int[] arr) {
    int length = arr.length;
    if (length <= 1) {
      return;
    }
    // 初始步长为 长度的1/2
    for (int step = length / 2; step >= 1; step /= 2) {
      // 当step为1
      for (int i = step; i < length; i++) {
        int tmp = arr[i];
        int j = i - step;
        while (j >= 0 && arr[j] > tmp) {
          // 交换
          arr[j + step] = arr[j];
          j -= step;
        }
        // 插入
        arr[j + step] = tmp;
      }
    }
  }

}

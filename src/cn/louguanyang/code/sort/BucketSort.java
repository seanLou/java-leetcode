package cn.louguanyang.code.sort;

import static cn.louguanyang.code.sort.QuickSort.getInts;

import java.util.Arrays;

/**
 * 桶排序
 *
 * @author louguanyang
 * @createAt 2021/3/22 11:16 下午
 */
public class BucketSort {

  public static void main(String[] args) {
    int count = 20;
    int[] a = getInts(count);

    System.out.println(Arrays.toString(a));
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  public static  void sort(int[] arr) {
    if (arr.length <= 1) {
      return;
    }
    // 计算最大值
    int max = 0;
    for (int j : arr) {
      if (j > max) {
        max = j;
      }
    }
    // 生成桶数组
    int[] brr = new int[max + 1];
    // 将原数组的数据入桶
    for (int j : arr) {
      brr[j]++;
    }

    // 遍历桶数组
    int index = 0;
    for (int i = 0; i < brr.length; i++) {
      while (brr[i]-- > 0) {
        // 将桶数组的值更新到原数组
        arr[index++] = i;
      }
    }
  }

}

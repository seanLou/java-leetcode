package cn.louguanyang.code.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author louguanyang
 * @createAt 2021/3/21 10:20 下午
 */
public class InsertionSort {

  public static void main(String[] args) {
    int[] a = {4,5,6,3,2,1};
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  public static void sort(int[] a) {
    int length = a.length;
    if (length <= 1) {
      return;
    }
    for (int i = 1; i < length; i++) {
      int value = a[i];
      int j = i - 1;
      // 查找插入的位置
      while (j >= 0 && a[j] > value) {
        a[j + 1] = a[j];
        j--;
      }
      // 插入数据
      a[j + 1] = value;
    }
  }
}

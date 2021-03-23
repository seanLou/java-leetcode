package cn.louguanyang.code.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 快速排序
 *
 * @author louguanyang
 * @createAt 2021/3/22 11:16 下午
 */
public class QuickSort {

  public static void main(String[] args) {
    int count = 20;
    int[] a = getInts(count);
    System.out.println(Arrays.toString(a));
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  public static void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  public static void sort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    // 计算出中间位置
    int mid = partition(arr, left, right);

    // 左边部分排序
    sort(arr, left, mid - 1);

    // 右边部分排序
    sort(arr, mid + 1, right);
  }

  private static int partition(int[] arr, int left, int right) {
    if (left == right) {
      return left;
    }
    int point = arr[right];
    int i = left;
    for (int j = left; j < right; j++) {
      if (arr[j] < point) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
        i = i + 1;
      }
    }
    int tmp = arr[right];
    arr[right] = arr[i];
    arr[i] = tmp;

    return i;
  }

  public static int[] getInts(int count) {
    int[] a = new int[count];
    for (int i = 0; i < count; i++) {
      a[i] = ThreadLocalRandom.current().nextInt(count) + 1;
    }
    return a;
  }

}

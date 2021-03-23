package cn.louguanyang.code.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author louguanyang
 * @createAt 2021/3/22 11:16 下午
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] a = {4,5,6,3,2,1};
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  public static  void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  public static void sort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    int mid = (left + right) /2;
    sort(arr, left, mid);
    sort(arr, mid + 1, right);

    merge(arr, left, mid, right);
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }
    // 计算出剩余部分
    int start = i, end = mid;
    if (j <= right) {
      start = j;
      end = right;
    }

    // 将剩余部分复制到临时数组中
    while (start <= end) {
      temp[k++] = arr[start++];
    }

    // 拷贝 temp 数据到 arr, 开始位置为 left 指针
    if (temp.length >= 0) {
      System.arraycopy(temp, 0, arr, left, temp.length);
    }
  }

}

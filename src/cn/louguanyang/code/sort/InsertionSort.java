package cn.louguanyang.code.sort;

/**
 * 插入排序
 *
 * @author louguanyang
 * @createAt 2021/3/21 10:20 下午
 */
public class InsertionSort {

  public void insertionSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }
    for (int i = 1; i < n; ++i) {
      int value = a[i];
      int j = i - 1;
      // 查找插入的位置
      for (; j >=0; --j) {
        if (a[j] > value) {
          // 数据移动
          a[j + 1] = a[j];
        } else {
          break;
        }
      }
      // 插入数据
      a[j + 1] = value;
    }
  }
}

package cn.louguanyang.code.sort;

/**
 * 冒泡排序
 *
 * @author louguanyang
 * @createAt 2021/3/31 10:25 下午
 */
public class BubbleSort {

    public void sort(int[] a) {
        boolean flag = false;

        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            // 若没有发生交换，则退出循环
            if (!flag) {
                break;
            }
        }
    }
}

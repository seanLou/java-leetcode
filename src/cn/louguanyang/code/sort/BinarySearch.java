package cn.louguanyang.code.sort;

/**
 * 二分法查找
 *
 * @author louguanyang
 * @createAt 2021/3/24 11:23 下午
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = 9;

        long start = System.nanoTime();
        int index = simpleSearch(a, a.length, value);
        System.out.println("usage:" + (System.nanoTime() - start) + "ns, value:" + value + " index:" + index);

        start =  System.nanoTime();
        index = recursionSearch(a, a.length, value);
        System.out.println("usage:" + (System.nanoTime() - start) + "ns, value:" + value + " index:" + index);
    }

    public static int simpleSearch(int[] a, int n, int value) {
        int low = 0;
        int hi = n - 1;

        while (low <= hi) {
            // int mid = (low + hi) / 2; // 直接相加可能会出现溢出，改成 low + (hi - low) / 2
            // 位运算
            int mid = low + ((hi - low) >> 1);
            System.out.println("mid:" + mid + " value:" + a[mid]);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

    public static int recursionSearch(int[] a, int n, int value) {
        return recursionSearch(a, 0, n, value);
    }

    public static int recursionSearch(int[] a, int low, int hi, int value) {
        if (low > hi) {
            return -1;
        }
        int mid = low + ((hi - low) >> 1);
        System.out.println("mid:" + mid + " value:" + a[mid]);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            return recursionSearch(a, low, mid - 1, value);
        } else {
            return recursionSearch(a, mid + 1, hi, value);
        }
    }
}

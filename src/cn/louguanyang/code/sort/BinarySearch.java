package cn.louguanyang.code.sort;

import java.util.Arrays;

import static cn.louguanyang.code.sort.QuickSort.getInts;

/**
 * 二分法查找
 *
 * @author louguanyang
 * @createAt 2021/3/24 11:23 下午
 */
public class BinarySearch {

    public static void main(String[] args) {
        int count = 20;
        int[] a = getInts(count);
        int value = a[10];

        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));

        long start = System.nanoTime();
        int index = simpleSearch(a, a.length, value);
        System.out.println("usage:" + (System.nanoTime() - start) + "ns, 遍历查找 " + value + " index:" + index);

        start = System.nanoTime();
        index = recursionSearch(a, a.length, value);
        System.out.println("usage:" + (System.nanoTime() - start) + "ns, 递归查找" + value + " index:" + index);

        start = System.nanoTime();
        index = searchFirstEquals(a, a.length, value);
        System.out.println("usage:" + (System.nanoTime() - start) + "ns, 查找第一个 " + value + " index:" + index);

        start = System.nanoTime();
        index = searchLastEquals(a, a.length, value);
        System.out.println("usage:" + (System.nanoTime() - start) + "ns, 查找最后一个" + value + " index:" + index);

        start = System.nanoTime();
        value = 9;
        index = searchFirstEqualOrLarge(a, a.length, value);
        System.out.println("usage:" + (System.nanoTime() - start) + "ns, 查找第一个大于等于" + value + "的 index:" + index);

        start = System.nanoTime();
        index = searchLastEqualsOrSmall(a, a.length, value);
        System.out.println("usage:" + (System.nanoTime() - start) + "ns, 查找最后一个小于等于" + value + "的 index:" + index);

    }

    /**
     * 二分法简单查找-遍历实现
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
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


    /**
     * 二分法简单查找第一个符合的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int searchFirstEquals(int[] a, int n, int value) {
        int low = 0;
        int hi = n - 1;

        while (low <= hi) {
            // int mid = (low + hi) / 2; // 直接相加可能会出现溢出，改成 low + (hi - low) / 2
            // 位运算
            int mid = low + ((hi - low) >> 1);
            System.out.println("mid:" + mid + " value:" + a[mid]);
            if (a[mid] == value) {
                if (mid == 0 || (a[mid - 1] < value)) {
                    return mid;
                }
                hi = mid - 1;
            } else if (a[mid] > value) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }


    /**
     * 二分法简单查找 查找第一个大于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int searchFirstEqualOrLarge(int[] a, int n, int value) {
        int low = 0;
        int hi = n - 1;

        while (low <= hi) {
            // int mid = (low + hi) / 2; // 直接相加可能会出现溢出，改成 low + (hi - low) / 2
            // 位运算
            int mid = low + ((hi - low) >> 1);
            System.out.println("mid:" + mid + " value:" + a[mid]);
            if (a[mid] >= value) {
                if (mid == 0 || (a[mid - 1] < value)) {
                    return mid;
                }
                hi = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }


    /**
     * 二分法简单查找最后一个符合的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int searchLastEquals(int[] a, int n, int value) {
        int low = 0;
        int hi = n - 1;
        if (value == a[hi]) {
            return hi;
        }

        while (low <= hi) {
            // int mid = (low + hi) / 2; // 直接相加可能会出现溢出，改成 low + (hi - low) / 2
            // 位运算
            int mid = low + ((hi - low) >> 1);
            System.out.println("mid:" + mid + " value:" + a[mid]);
            if (a[mid] == value) {
                if ((a[mid + 1] > value)) {
                    return mid;
                }
                low = mid + 1;
            } else if (a[mid] > value) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
    /**
     * 二分法简单查找 查找最后一个小于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int searchLastEqualsOrSmall(int[] a, int n, int value) {
        int low = 0;
        int hi = n - 1;
        if (value == a[hi]) {
            return hi;
        }

        while (low <= hi) {
            // int mid = (low + hi) / 2; // 直接相加可能会出现溢出，改成 low + (hi - low) / 2
            // 位运算
            int mid = low + ((hi - low) >> 1);
            System.out.println("mid:" + mid + " value:" + a[mid]);
            if (a[mid] <= value) {
                if ((a[mid + 1] > value)) {
                    return mid;
                }
                low = mid + 1;
            } else if (a[mid] > value) {
                hi = mid - 1;
            }

        }
        return -1;
    }


    /**
     * 二分法简单查找-递归实现
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
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

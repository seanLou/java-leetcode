package cn.louguanyang.code.match;

/**
 * @author louguanyang
 * @createAt 2021/4/10 3:11 下午
 */
public class BmStringMatch {

    private final static int SIZE = 256;

    /**
     * @param b  模式串
     * @param m  模式串长度
     * @param bc 散列表
     */
    public void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = b[i];
            bc[ascii] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {
        // 记录模式串中每个字符最后出现的位置
        int[] bc = new int[SIZE];
        // 构建坏字符哈希表
        generateBC(b, m, bc);
        // i表示主串与模式串对齐的第一个字符
        int i = 0;
        while (i <= n - m) {
            int j;
            // 模式串从后往前匹配
            for (j = m - 1; j >= 0; --j) {
                if (a[i + j] != b[j]) {
                    // 坏字符对应模式串中的下标是j
                    break;
                }
            }
            if (j < 0) {
                // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                return i;
            }
            // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
            i = i + (j - b[a[i + j]]);
        }
        return -1;
    }
}

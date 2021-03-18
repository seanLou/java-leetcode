package cn.louguanyang.code.array;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
 * 请使用字符数组实现，以便直接在数组上操作。）
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 *
 *
 *  示例 2：
 *
 *
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 *
 *
 *
 *
 *  提示：
 *
 *
 *  字符串长度在 [0, 500000] 范围内。
 *
 *  Related Topics 字符串
 *  👍 32 👎 0
 *  URL 化
 * @author louguanyang
 * @createAt 2021/3/18 10:18 下午
 */
public class StringToUrl {

    public static void main(String[] args) {
        String answer = replaceSpaces("Mr John Smith    ", 13);
        System.out.println("Mr%20John%20Smith".equals(answer));

        answer = replaceSpaces("               ", 5);
        System.out.println("%20%20%20%20%20".equals(answer));
    }

    public static String replaceSpaces(String s, int length) {
        char[] chars = s.toCharArray();
        int end = s.length();
        int index = length - 1;
        while (index >= 0) {
            if (chars[index] == ' ') {
                chars[--end] = '0';
                chars[--end] = '2';
                chars[--end] = '%';
            } else {
                chars[--end] = chars[index];
            }
            index--;
        }
        return new String(chars).substring(end);
    }
}

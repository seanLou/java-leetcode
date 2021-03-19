package cn.louguanyang.code.array;

/**
 * 重新排列字符串
 * <p>
 * https://leetcode-cn.com/problems/shuffle-string/
 * <p>
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * <p>
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * <p>
 * 返回重新排列后的字符串。
 *
 * @author louguanyang
 * @createAt 2021/3/18 11:11 下午
 */
public class StringRestore {

  public static void main(String[] args) {
    // 解题思路
    // 新建一个字符数组，循环遍历所在位置的下标数组，将原字符串转换的字符数组的值赋值给新的字符数组。
    String answer = restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3});
    System.out.println("leetcode".equals(answer));
  }

  public static String restoreString(String s, int[] indices) {
    char[] chars = s.toCharArray();
    char[] newChars = new char[chars.length];
    for (int i = 0; i < indices.length; i++) {
      newChars[indices[i]] = chars[i];
    }
    return new String(newChars);
  }
}

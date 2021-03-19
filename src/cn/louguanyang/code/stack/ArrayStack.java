package cn.louguanyang.code.stack;

/**
 * 数组实现的栈
 *
 * @author louguanyang
 * @createAt 2021/3/19 9:20 下午
 */
public class ArrayStack {

  /**
   * 数组
   */
  private String[] items;

  /**
   * 容量
   */
  private Integer n;

  /**
   * 当前数量
   */
  private Integer count;

  public ArrayStack(Integer n) {
    this.n = n;
    items = new String[n];
    this.count = 0;
  }

  public boolean push(String s) {
    if (count == n) {
      // 当数组满的时候 直接返回false
      return false;
    }
    items[count++] = s;
    return true;
  }

  public String pop() {
    // 栈为空，则直接返回null
    if (count == 0) {
      return null;
    }
    //返回下标为count-1的数组元素，并且栈中元素个数count减一
    String tmp = items[count - 1];
    --count;
    return tmp;
  }
}

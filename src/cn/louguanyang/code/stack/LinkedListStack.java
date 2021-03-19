package cn.louguanyang.code.stack;

import java.util.LinkedList;

/**
 * 链表实现的栈
 * @author louguanyang
 * @createAt 2021/3/19 9:28 下午
 */
public class LinkedListStack {

  private LinkedList<String> items;

  private Integer count;

  public LinkedListStack() {
    items = new LinkedList<>();
    count = 0;
  }

  public boolean push(String s) {
    return items.add(s);
  }

  public String pop() {
    if (count == 0) {
      return null;
    }
    String tmp = items.removeLast();
    count = items.size();
    return tmp;
  }

}

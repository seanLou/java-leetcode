package cn.louguanyang.code.dynamic;

import cn.louguanyang.code.dynamic.BackTrackingBagQuestion;

/**
 * 基础回溯法测算
 *
 * @author louguanyang
 * @createAt 2021/4/19 10:23 下午
 */
public class BackTrackingBagQuestionTest {

    public static void main(String[] args) {
        int[] weight = {2,2,4,6,3};
        int w = 9;

        BackTrackingBagQuestion q = new BackTrackingBagQuestion();
        int max = q.getMaxCw(weight, w);

        System.out.println(max);
    }
}

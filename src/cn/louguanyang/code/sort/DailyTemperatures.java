package cn.louguanyang.code.sort;

import java.util.Arrays;

/**
 * 每日温度计
 *
 * @author louguanyang
 * @createAt 2021/4/5 4:09 下午
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
        int[] temperatures2 = {55,38,53,81,61,93,97,32,43,78};
        ints = dailyTemperatures(temperatures2);
        System.out.println(Arrays.toString(ints));;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0) {
            return temperatures;
        }
        int currentTemp = 0;
        for (int i = 0; i < temperatures.length; i++) {
            currentTemp = temperatures[i];
            temperatures[i] = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > currentTemp) {
                    temperatures[i] = j - i;
                    break;
                }
            }
        }
        return temperatures;
    }
}

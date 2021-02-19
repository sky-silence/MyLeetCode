import array.No015ThreeSum;
import array.No018FourSum;
import dynamicPlanning.DPPractice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: chengzeshan
 * @date: 2019-06-06 15:43
 */
public class LeetCode {

    static DPPractice dpPractice = new DPPractice();
    static No015ThreeSum no015ThreeSum = new No015ThreeSum();
    static No014LongestCommonPre no014LongestCommonPre = new No014LongestCommonPre();
    static No016ThreeSumClosest no016ThreeSumClosest = new No016ThreeSumClosest();
    static No017LetterCombinations no017LetterCombinations = new No017LetterCombinations();
    static No018FourSum no018FourSum = new No018FourSum();
    static No002AddTwoNumbers no002AddTwoNumbers = new No002AddTwoNumbers();

    public static void main(String[] args) {

        System.out.println(WeekOnWeek(0,5534));

        int count = 0;
        double x = 3400;
        while (x < 14000) {

            x = x + (0.2 * x);
            count++;
            System.out.println("x = " + x);
        }
        System.out.println(count);
        Date date = new Date(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(System.currentTimeMillis() / (1000 * 60) * 1000 * 60));

        List<String> a = new ArrayList<>();
        a.add("aaa");
        a.add("bbb");
        for (String s : a) {
            s = s + 1;
        }
        System.out.println(a.toString());

        // String x = "0.000";
        System.out.println(new BigDecimal(x).compareTo(new BigDecimal(0)));
    }
    private static BigDecimal WeekOnWeek(Integer before,Integer last){
        BigDecimal a = new BigDecimal(before);
        BigDecimal b = new BigDecimal(last);

        return a.compareTo(BigDecimal.ZERO) ==0 ? new BigDecimal(0):b.subtract(a).divide(a,10, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     */
    private static long factorial(int n) {
        long sum = 1;
        while (n > 0) {
            sum = sum * n--;
        }
        return sum;
    }

    /**
     * 组合计算公式C<sup>m</sup><sub>n</sub> = n! / (m! * (n - m)!)
     *
     * @param m
     * @param n
     * @return
     */
    public static long combination(int m, int n) {
        return m <= n ? factorial(n) / (factorial(m) * factorial((n - m))) : 0;
    }

    public static List<List<String>> combinationSelect(String[] dataList, int dataIndex) {
        List<List<String>> resultList = new ArrayList<>();
        resultList = combinationSelect(dataList, 0, new String[dataIndex], 0, dataIndex, resultList);
        return resultList;
    }

    /**
     * @param dataList
     * @param dataIndex
     * @param resultList
     * @param resultIndex
     * @param returnList
     * @return
     */
    public static List<List<String>> combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex, int count, List<List<String>> returnList) {

        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) {
            System.out.println("" + Arrays.asList(resultList));
            String[] temp = new String[count];
            temp = resultList.clone();
            returnList.add(Arrays.asList(temp));
            return returnList;
        }
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            returnList = combinationSelect(dataList, i + 1, resultList, resultIndex + 1, count, returnList);
        }
        return returnList;
    }
}

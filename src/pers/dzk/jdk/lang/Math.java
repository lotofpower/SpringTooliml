package pers.dzk.jdk.lang;

import pers.dzk.jdk.convert.ObjectTypeConvert;

import java.util.ArrayList;

public class Math {

    /**
     * 计算斐波纳契数列
     * @param min 最小值
     * @param max 最大值
     * @return 一组斐波纳契数列
     */
    public static int[] fibonacciSequence(int min,int max){
        ArrayList<Integer> array = new ArrayList<>();
        return fibonacciSequence(min,max,array);
    }

    private static int[] fibonacciSequence(int min, int max, ArrayList<Integer> array){
        if(array.size() == 0){
            array.add(min);
            array.add(min);
        }
        if(array.get(array.size()-1) + array.get(array.size()-2) > max) {
            int[] array_ = array.stream().mapToInt(Integer::valueOf).toArray();
            return array_;
        }
        array.add(array.get(array.size()-1)+ array.get(array.size()-2));
        return fibonacciSequence(min,max,array);
    }

    /**
     * 计算阶乘
     * @param number 数字
     * @return n的阶乘
     */
    public static int factorial(int number) {
        return  number <= 2 ? number : number * factorial(--number);
    }

    /**
     *乘法
     * @param number1 数字1
     * @param number2 数字2
     * @return n1*n2
     */
    public static int multiplication(int number1,int number2){
        return number1 == 1 ? number2 : multiplication(number1 - 1,number2) + number2;
    }

    /**
     * 计算某数的次方
     * @param n 底数
     * @param m 指数
     * @return
     */
    public static int pow(int n,int m){
        return m == 1 ? n : pow(n,m-1)*n;
    }

    /**
     * 是否为对称数
     * @param number 数
     * @return
     */
    public static boolean isSymmetryNumber(int number){
        int l = Tool.getLength(number);
        int[] a = new int[l/2];
        int[] b = new int[l/2];
        for (int i = 1,j=0;j < a.length;i*=10,j++){
            a[j] = number/i%10;
        }
        for (int i = pow(10,l-1),j=0;j < a.length;i/=10,j++){
            b[j] = number/i%10;
        }
        for (int i = 0;i < a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 是否是完数
     * @param number 数
     * @return
     */
    public static boolean isWholeNumber(int number){
        int c = 0;
        for (int i = 1;i <= number/2;i++){
            if(number%i == 0){
                c += i;
            }
        }
        if(c == number){
            return true;
        }
        return false;
    }

    /**
     * 求两数之间最大公约数
     * @param minNumber 小的数
     * @param maxNumber 大的数
     * @return
     */
    public static int maxCommonDivisor(int minNumber,int maxNumber){
        return maxCommonDivisor(minNumber,maxNumber,minNumber);
    }

    private static int maxCommonDivisor(int min,int max,int i){
        return min%i == 0 && max%i == 0? i:maxCommonDivisor(min,max,i-1);
    }

    /**
     * 求某范围内的所有素数
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static int[]  primeNumber(int min,int max){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min;i <= max;i++){
            boolean b =true;
            if(i%2 != 0){
                for (int j = 2;j <= i/2;j++){   //此处的j<=i/2对应注释b，原始行在228
                    if(i%j == 0){
                        b = false;
                    }
                }
                if(b){
                    list.add(i);
                }
            }
        }
        return ObjectTypeConvert.toIntArray(list);
    }

    /**
     * 最小公倍数
     * @param min
     * @param max
     * @return
     */
    public static int minCommonMultiple(int min,int max){
        for (int i = max*2;;i+=max){
            if(i%min == 0 && i%max == 0){
                return i;
            }
        }
    }

    /**
     * 杨辉三角形
     * @param n 行数
     * @return
     */
    public static int[][] pascalTriangle(int n){
        int[][] a = new int[n][];
        for (int i = 0;i < n;i++){
            a[i] = new int[i+1];
            for (int j = 0;j < i+1;j++){
                if(j == 0 || j == i){
                    a[i][j] = 1;
                }else {
                    a[i][j] = a[i-1][j-1]+a[i-1][j];
                }
            }
        }
        return a;
    }
    /**
     * 无限黄金分割
     * @param number 初始值
     * @return
     */
    public static ArrayList goldenCut(double number){
        ArrayList arrayList =  new ArrayList<>();
        return goldenCut(number,arrayList);
    }
    private static ArrayList goldenCut(double l,ArrayList arrayList){
        if(l <= 1){
            return arrayList;
        }
        arrayList.add(l);
        return goldenCut(0.618*l,arrayList);
    }

    /**
     * 绝对值
     * @param number 数
     * @return
     */
    public static int absolute(int number){
        return number < 0 ? -number: number;
    }

}

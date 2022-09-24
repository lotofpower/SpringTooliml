package pers.dzk.jdk.lang;

import pers.dzk.jdk.convert.ObjectTypeConvert;

import java.io.File;
import java.util.ArrayList;

public class Tool {

    public static String deleteString(String str, char delChar) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != delChar) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 目录下所有文件首字母大写
     * @param path 路径
     */
    public void firstUpperCaseFileName(String path){
        File[] files = new File(path).listFiles();
        int errCount = 0;
        for (File file:files) {
            String s1 = file.getParent();
            String s2 = file.getName();
            s2 = Tool.upperCase(s2);
            File newfile = new File(s1+File.separator+s2);
            if(!file.renameTo(newfile)){
                errCount++;
            }
        }
        System.out.println(String.format("执行完毕!\n%s处成功,%s处失败.",files.length-errCount,errCount));
    }

    /**
     * 字符串首字母大写
     * @param str 字符串
     * @return 字符串
     */
    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 把数字汉化，如：110001111：1亿1000万1千1百1十1个
     * @param number 数
     * @return 汉化的数
     */
    public static String numberChinesize(long number){
        StringBuffer sb = new StringBuffer();
        char[] chinesize = new char[]{'个','十','百','千','万'};
        boolean minus = false;
        String numberString;
        if(number < 0){
            minus = true;
            numberString = -number + "";
        }else {
            numberString = number + "";
        }

        for (int i = 0;i < chinesize.length;i++){
            if(i == numberString.length()){
                break;
            }
            sb.insert(0,chinesize[i]);
            sb.insert(0,numberString.charAt(numberString.length()-i-1));
        }
        if (numberString.length() > 4){
            String wans = numberString.substring(0,numberString.length()-5);
            if(wans.length() > 3){
                String yis = wans.substring(0,wans.length()-3);
                wans = wans.substring(wans.length()-3);
                sb.insert(0,wans);
                sb.insert(0,'亿');
                sb.insert(0,yis);
            }else {
                sb.insert(0,wans);
            }
        }
        if(minus){
            sb.insert(0,"负");
        }
        return sb.toString();
    }

    /**
     * 判断数组内值是否存在重复
     * @param array
     * @return
     */
    public static boolean isNotRepetition(Object[] array){
        for (int i = 0;i < array.length;i++){
            for (int j = i+1;j < array.length;j++){
                if (array[i] == array[j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断数组内值是否存在重复
     * @param array
     * @return
     */
    public static boolean isNotRepetition(ArrayList<Integer> array){
        for (int i = 0;i < array.size();i++){
            for (int j = i+1;j < array.size();j++){
                if (array.get(i) == array.get(j)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 将一个数组前后两值交换,如输入数组[1,2,3,4]，则输出[2,1,4,3]
     * @param array 数组
     * @return 前后交换后的数组
     */
    public static Object[] reversalTwo(Object[] array){
        return reversalTwo(array,0);
    }

    private static Object[] reversalTwo(Object[] array,int index){
        if(index == array.length){
            return  array;
        }
        if(index%2 != 0){
            Object date = array[index];
            array[index] = array[index-1];
            array[index-1] = date;
        }
        return reversalTwo(array,index+1);
    }


    /**
     * 判断该数组是否有序
     * @param array 数组
     * @return 是否有序
     */
    public static boolean isOrderly(int[] array){
        if(array[1] < array[0]){
            for (int i = 1;i < array.length;i++){
                if(array[i] > array[i-1]){
                    return false;
                }
            }
        }else {
            for (int i = 1;i < array.length;i++){
                if(array[i] < array[i-1]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断int数组内所有值是否相等
     * @param array 数组
     * @return 是否相等
     */
    public static boolean isEquality(int[] array){
        for (int i = 1;i < array.length;i++){
            if(array[i] != array[i-1]){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个字符是否是汉字
     * PS：中文汉字的编码范围：[\u4e00-\u9fa5]
     *
     * @param c 需要判断的字符
     * @return 是汉字(true), 不是汉字(false)
     */
    public static boolean isChineseChar(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }

    /**
     * 判断数组内是否有某个值
     * @param array
     * @return
     */
    public static boolean query(int[] array,int value){
        for (int i = 0;i < array.length;i++){
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }

    /**
     * 数组内所有值相加
     * @param a
     * @return
     */
    public static double sum(double... a){
        double v = 0;
        for (int i = 0;i < a.length;i++){
            v+= a[i];
        }
        return v;
    }

    /**
     * 数组内所有值相加
     * @param a
     * @return
     */
    public static int sum(int... a){
        int v = 0;
        for (int i = 0;i < a.length;i++){
            v += a[i];
        }
        return v;
    }

    /**
     * 获取int总位数
     * @param value
     * @return
     */
    public static int getLength(int value){
        int l = 1;
        for (int i = value;i/10>=1;){
            i = i/10;
            l++;
        }
        return l;
    }

    /**
     * 判断是否为整数
     * @param d
     * @return
     */
    public static boolean isInt(double d) {
        return ((long) d) + 0.0 == d;
    }

    /**
     * 找最大值
     * @param a
     * @return
     */
    public static int max(int... a){
        int max = a[0];
        for (int i = 1;i < a.length;i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }

    /**
     * 找最小值
     * @param a
     * @return
     */
    public static int min(int... a){
        int min = a[0];
        for (int i = 1;i < a.length;i++){
            if(min > a[i]){
                min = a[i];
            }
        }
        return min;
    }


    public static void println(int[] array,String separator){
        separator = separator == null ? "" : separator;
        for (int i = 0;i < array.length;i++) {
            System.out.println(i+separator+array[i]);
        }
    }

    public static void println(int[][] matrix,String separator){
        separator = separator == null ? "" : separator;
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length;j++){
                System.out.print(matrix[i][j]);
                if(j != matrix[i].length-1){
                    System.out.print(separator);
                }
            }
            System.out.println();
        }
    }


    /**
     * 把一个数字拆分成两个相乘的整数
     * @param number
     * @return
     */
    public static int[][] multiplicationSplit(int number){
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 2;i <= number/2;i++){              //b
            int[] c = new int[2];
            if(number%i == 0){
                c[0] = i;
                c[1] = number/i;
                list.add(c);
            }
        }
        int[][] a = new int[list.size()/2][2];
        for (int i = 0;i < a.length;i++){
            for (int j = 0;j < 2;j++){
                a[i][j] = list.get(i)[j];
            }
        }
        return a;
    }

    /**
     * 把一个数字拆分成两个相加的整数
     * @param number
     * @return
     */
    public static int[][] additionSplit(int number){
        ArrayList<int[]> list = new ArrayList<>();
        for (int a = 1;a <= number/2;a++){
            int b = number-a;
            list.add(new int[]{a,b});
        }
        return ObjectTypeConvert.toTowIntArray(list);
    }

    /**
     * 数字排序
     * @param number
     * @param order true：从大到小
     * @return
     */
    public static int sort(int number,boolean order){
        int[] c = ObjectTypeConvert.toIntArray(number);
        int[] a = sort(c,order);
        return ObjectTypeConvert.toInt(a);
    }

    /**
     * 数组排序
     * @param array
     * @param order true:从大到小
     */
    public static int[] sort(int[] array, boolean order){
        int cache;
        if(order){
            for (int i = 0;i < array.length;i++){
                for (int j = 1;j < array.length-i;j++){
                    if(array[j] > array[j-1]){
                        cache = array[j];
                        array[j] = array[j-1];
                        array[j-1] = cache;
                    }
                }
            }
        }else {
            for (int i = 0;i < array.length;i++){
                for (int j = 1;j < array.length-i;j++){
                    if(array[j] < array[j-1]){
                        cache = array[j];
                        array[j] = array[j-1];
                        array[j-1] = cache;
                    }
                }
            }
        }
        return array;
    }

    /**
     * 判断数字所有位数是否相等
     * @param number
     * @return
     */
    public static boolean isEquality(int number){
        if(number < 0){
            number = -number;
        }
        int last = number%10;
        int this_;
        number/=10;
        while (number>=1){
            this_ = number%10;
            if(this_ != last){
                return false;
            }
            number /= 10;
            last = this_;
        }
        return true;
    }

    /**
     * 反的数字
     * @param number
     * @return
     */
    public static int opposite(int number){
        int number2 = 0;
        int s = Math.pow(10,getLength(number)-1);
        while (number>=1){
            number2 += number%10*s;
            number/=10;
            s/=10;
        }
        return number2;
    }

}

package pers.dzk.jdk;

import pers.dzk.jdk.io.File;
import pers.dzk.jdk.convert.StringCompiler;
import pers.dzk.jdk.lang.Math;
import pers.dzk.jdk.convert.ObjectTypeConvert;
import pers.dzk.jdk.lang.Tool;
import pers.dzk.jdk.security.CrackingDevice;
import pers.dzk.jdk.security.Encryption;
import pers.dzk.jdk.lang.Random;

import java.io.IOException;

public class TestFunction {
    public final static void javaStringCompiler_AllFunction() throws IOException, ClassNotFoundException {
        String java = "package pers.dzk.jdk;\n" +
                "\n" +
                "\n" +
                "/**\n" +
                " * 测试类实验体\n" +
                " */\n" +
                "public class Person {\n" +
                "    private String name;\n" +
                "    private int age;\n" +
                "\n" +
                "    public Person(){\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    public Person(String name,Integer age){\n" +
                "        this.name = name;\n" +
                "        this.age = age;\n" +
                "    }\n" +
                "\n" +
                "    public void test(){\n" +
                "        System.out.println(\"test2\");\n" +
                "    }\n" +
                "\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    public int getAge() {\n" +
                "        return age;\n" +
                "    }\n" +
                "\n" +
                "    public void setName(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    public void setAge(int age) {\n" +
                "        this.age = age;\n" +
                "    }\n" +
                "\n" +
                "}";
        Class clazz = StringCompiler.loadClass(StringCompiler.compile(java));
    }

    public final static void encryption_AllFunction(){
        String txt = "https://www.baidu.com/";
        System.out.println("原始数据："+txt);
        String txt2 = Encryption.encryption(txt);
        System.out.println("加密后："+txt2);
        System.out.println("解密后："+ Encryption.decode(txt2));
    }

    public final static void file_CreationTxt_generateStringDrawing() {
        String imgPath = "D:\\Root\\Desktop\\img\\1.jpg";
        String txtPath = "D:\\Root\\Desktop\\txt";
        String str = File.generateStringDrawing(imgPath);
        File.creationTxt("我打你吗！",txtPath,str);
    }

    public final static void math_split(){
        for (int z = 50;z < 1000;z+=50){
            System.out.println("****"+z+"的组合"+"****");
            int[][] list = Tool.multiplicationSplit(z);
            Tool.println(list,"");
        }
    }


    public final static void ObjectTypeConvert_toIntArray() throws Exception {
        int[] ar = ObjectTypeConvert.toIntArray(new char[]{'8','9','a','B'});
        for (int i:ar) {
            System.out.println(i);
        }
    }

    public final static void crackingDevice_crack()  {
        CrackingDevice password = new CrackingDevice(new char[]{'a','b','c','d'},4);
        String[] str = password.crack();
        System.out.println(password.getCount());
        for (int i = 0;i < str.length;i++){
            System.out.println(str[i]);
        }
    }

    public final static void random_getArray(){
        for (int i = 0;i < 100;i++){
            int[] array = ObjectTypeConvert.toIntArray(Random.getArray(ObjectTypeConvert.toObjectArray(new int[]{1,2,3})));
            for (int j = 0;j < array.length;j++){
                System.out.print(array[j]);
            }
            System.out.println();
        }
    }

    public final static void math_factorial(){
        Math math = new Math();
        System.out.println(math.factorial(3));
    }

    public final static void math_fibonacciSequence(){
        Math math = new Math();
        int[] array = math.fibonacciSequence(1,500);
        for (int i = 0;i < array.length;i++){
            System.out.println("["+i+"]"+array[i]);
            if(i>0){
                System.out.println("前后值比："+(double)array[i-1]/(double)array[i]);
            }
        }

    }
    public final static void math_reversalTwo(){
        Object[] array = Tool.reversalTwo(new Object[]{1,2,3,4,5,6,7,8});
        for (Object i: array) {
            System.out.println("array："+i);
        }
    }

    public final static void file_Serializable_Deserialization() throws IOException, ClassNotFoundException {
        TestObject ps = new TestObject();
        ps.setAge(18);
        ps.setName("张三");
        File.Serialize("G:\\Guest\\out.txt",ps);
        TestObject ps2 = (TestObject) File.Deserialization("G:\\Guest\\out.txt");
        System.out.println(ps2.toString());
    }
}

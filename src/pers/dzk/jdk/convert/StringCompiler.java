package pers.dzk.jdk.convert;

import pers.dzk.jdk.lang.Tool;

import java.io.IOException;
import java.util.Map;

/**
 * 可以把字符串变成类
 */
public class StringCompiler {

    private static com.itranswarp.compiler.JavaStringCompiler compiler = new com.itranswarp.compiler.JavaStringCompiler();
    private static String javaSourceCode;

    /**
     * 把.java編譯成.class
     * @param javaSourceCode .java代碼
     * @return .class的字節碼
     * @throws IOException
     */
    public static Map<String, byte[]> compile(String javaSourceCode) throws IOException {
        StringCompiler.javaSourceCode = javaSourceCode;
        Map<String, byte[]> results = compiler.compile(getJavaName(javaSourceCode)+".java", javaSourceCode);
        return results;
    }

    /**
     * 把.class字節碼載入jvm
     * @param results
     * @return .class對應的類
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Class loadClass(Map<String,byte[]> results) throws IOException, ClassNotFoundException {
        /*
        ClassLoader通過class資源(byte[])把它載入内存。
        forname通過類名去内存裏面找class資源(byte[])然後把它載入内存
        所以這裏一定要用ClassLoader的方法去把他載入jvm裏
        一個類只需要被載入一次，只要載完這次后就直接引用這個類就可以了。
     */
        Class clazz = compiler.loadClass(getPackage(StringCompiler.javaSourceCode), results);
        return clazz;
    }

    private static String getPackage(String java){
        String packageName;
        String java2 = Tool.deleteString(java,' ');
        java2 = Tool.deleteString(java2,'\n');
        java2 = java2.substring(java2.indexOf("package")+"package".length());
        packageName = java2.substring(0,java2.indexOf(";"));
        return packageName+"."+getJavaName(java);
    }

    private static String getJavaName(String java){
        String javaName;
        String java2 = Tool.deleteString(java,' ');
        java2 = Tool.deleteString(java2,'\n');
        java2 = java2.substring(java2.indexOf("publicclass")+"publicclass".length());
        javaName = java2.substring(0,java2.indexOf("{"));
        return javaName;
    }



}

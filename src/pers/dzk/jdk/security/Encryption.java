package pers.dzk.jdk.security;

/**
 * 字符串加密
 */
public class Encryption {

    /**
     * 加密
     * @param plainText
     * @return
     */
    public static String encryption(String plainText){  //算法过程：1：字符串前后颠倒 2：所有字符减该字符串长度
        String cipherText = "";
        char[] array = plainText.toCharArray();
        for (int i = 0;i < array.length/2;i++){
            char c = (char) (array[i]-array.length);
            array[i] = (char) (array[array.length-1-i]-array.length);
            array[array.length-1-i] = c;
            cipherText += array[i];
        }
        for (int i = array.length/2;i < array.length;i++){
            cipherText += array[i];
        }
        return cipherText;
    }

    /**
     * 解密
     * @param cipherText
     * @return
     */
    public static String decode(String cipherText){
        String plainText = "";
        char[] array = cipherText.toCharArray();
        for (int i = 0;i < array.length/2;i++){
            char c = (char) (array[i]+array.length);
            array[i] = (char) (array[array.length-1-i]+array.length);
            array[array.length-1-i] = c;
            plainText += array[i];
        }
        for (int i = array.length/2;i < array.length;i++){
            plainText += array[i];
        }
        return plainText;
    }

}

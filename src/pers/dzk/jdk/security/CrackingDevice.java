package pers.dzk.jdk.security;

/**
 * 字符串求所有组合
 */
public class CrackingDevice {

    private String[] list;
    private char[] dict;
    private int length;
    private int index;

    public CrackingDevice(char[] dict, int length) {
        this.dict = dict;
        this.length = length;
    }

    /**
     * 设置字典
     * @param dict
     */
    public void setDict(char[] dict) {
        this.dict = dict;
    }

    /**
     * 设置字符串长度
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    public int getCount(){
        return (int) Math.pow(dict.length,length-1)*dict.length;
    }

    /**
     * 计算所有组合
     * @return
     */
    public String[] crack(){
        list = new String[getCount()];
        crack(0,"");
        index = 0;
        return list;
    }

    private void crack(int index, String str){
        if(index == length){
            list[this.index++] = str;
        }else {
            for (int i = 0;i < dict.length;i++){
                String s = str + dict[i];
                crack(index+1,s);
            }
        }
    }







}

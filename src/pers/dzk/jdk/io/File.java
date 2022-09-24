package pers.dzk.jdk.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class File {
    /**
     * 读取txt文件并输出
     * @param txtPath 文本路径
     * @return txt内容
     */
    public static String readText(String txtPath) {
        java.io.File file = new java.io.File(txtPath);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    /**
     * 文件写入
     * @param txtPath txt路径
     * @param content 内容
     */
    public static void txtWrite(String txtPath, String content) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(txtPath));
            out.write(content); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建txt
     * @param fileName 文件名
     * @param savePath 保存地址
     * @param content 内容,可为空
     */
    public static void creationTxt(String fileName, String savePath, String content){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(savePath+"\\"+fileName+".txt"));
            bw.write(content);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成字符串画
     * @param imgPath 图片路径
     * @throws IOException
     */
    public static String generateStringDrawing(String imgPath) {
        String img = "";
        try {
            BufferedImage binaryBufferedImage = ImageIO.read(new java.io.File(imgPath));
            int orgWidth=binaryBufferedImage.getWidth();
            int orgHeight=binaryBufferedImage.getHeight();
            int size=Math.max(orgHeight,orgWidth);
            int w = size>1000?binaryBufferedImage.getWidth()/12:orgWidth;
            int h = size>1000?binaryBufferedImage.getHeight()/12:orgHeight;
            binaryBufferedImage.getGraphics().drawImage(binaryBufferedImage, 0, 0, w, h, null);
            final String base = "%%*o!;.";// 字符串由复杂到简单,备选 %%*o!;.
            for (int y = 0; y < h; y += 2) {
                for (int x = 0; x < w; x++) {
                    final int pixel = binaryBufferedImage.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    img += (index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                img += "\n";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return img;
    }

    /**
     * 序列化
     * @param url
     * @param object
     * @throws IOException
     */
    public static void Serialize(String url,Object object) throws IOException {
        // 序列化---把对象从虚拟机里掏出来变成文件并永久保存到硬盘里
        FileOutputStream fos = new FileOutputStream(url);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
    }

    /**
     * 反序列化
     * @param url
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object Deserialization(String url) throws IOException, ClassNotFoundException {
        // 反序列化---把文件反序列化转换成对象放进内存里
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(url));
        return ois.readObject();
    }

}

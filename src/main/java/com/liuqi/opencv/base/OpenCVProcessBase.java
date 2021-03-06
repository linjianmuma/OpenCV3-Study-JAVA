package com.liuqi.opencv.base;

import com.liuqi.opencv.OpenCVHandler;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author : alexliu
 * @Description : something do..
 * @Date : Create at 下午2:16 2018/4/11
 */
public class OpenCVProcessBase {

    static {
        //加载OpenCV 动态链接库
        OpenCVHandler.loadLibraries();
    }

    private String files_dir = System.getProperty("user.dir") + File.separator + "testFiles";

    /**
     * 测试文件路径
     */
    protected String p_test_file_path = this.files_dir + File.separator + "src";

    /**
     * 保存文件到测试目录
     * @param path
     * @param image
     * @return File
     */
    protected File saveImage(String path,Mat image){

        String outPath = this.files_dir + File.separator + path;

        File file = new File(outPath);
        //目录是否存在
        this.dirIsExist(file.getParent());

        //opencv的写出文件
        Imgcodecs.imwrite(outPath,image);

        return file;

    }

    protected File saveImageFile(String path,BufferedImage image){
        String outPath = this.files_dir + File.separator + path;

        File file = new File(outPath);
        //目录是否存在
        this.dirIsExist(file.getParent());

//        System.out.println(file.getAbsolutePath());
        try {
            ImageIO.write(image , "jpg",new File(file.getAbsolutePath()));

        } catch (Exception e){
            e.printStackTrace();
        }

        return file;

    }


    private void dirIsExist(String dirPath){
        File dir = new File(dirPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
    }

}

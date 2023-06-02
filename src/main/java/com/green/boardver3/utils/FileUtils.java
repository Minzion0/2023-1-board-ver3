package com.green.boardver3.utils;


public class FileUtils {
    public static void main(String[] args) {
        String ext = getExt("임정호.하하");
        System.out.println("ext = " + ext);
    }

    public static String getExt(String fileNm){

      return   fileNm.substring(fileNm.lastIndexOf(".")+1);
    }
}

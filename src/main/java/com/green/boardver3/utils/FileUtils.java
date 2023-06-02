package com.green.boardver3.utils;


public class FileUtils {
    public static void main(String[] args) {
        String ext = getFileNm("임정호.하하.hi");
        System.out.println("ext = " + ext);
    }

//    public static String getExt(String fileNm){
//        return fileNm.substring(fileNm.lastIndexOf(".")+1);
//
//    }
    public static String getFileNm(String fileNm){

        return fileNm.substring(0,fileNm.lastIndexOf("."));
    }
}

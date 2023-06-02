package com.green.boardver3.utils;


import java.util.UUID;

public class FileUtils {
    public static void main(String[] args) {
        String ext = getFileNm("임정호.하하.jpg");
        System.out.println("ext = " + ext);

        String sdf = makeRandomFileNm("gkgkgk.jpg");
        System.out.println("sdf = " + sdf);
    }

//    public static String getExt(String fileNm){
//        return fileNm.substring(fileNm.lastIndexOf(".")+1);
//
//    }
    public static String getFileNm(String fileNm){

        return fileNm.substring(0,fileNm.lastIndexOf("."));
    }
    public static String makeRandomFileNm(String fileNm){
        String uuID = UUID.randomUUID().toString();
        String random = fileNm.substring(fileNm.lastIndexOf("."));
        String urd = uuID+random;
        return urd;
    }
}

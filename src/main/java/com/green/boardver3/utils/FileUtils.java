package com.green.boardver3.utils;


import java.util.UUID;

public class FileUtils {
    public static void main(String[] args) {
        String ext = getFileNm("임정호.하하.hi");
        System.out.println("ext = " + ext);

        String s = makeRandomFileNm("하하호호호.jpg");
        System.out.println("s = " + s);
    }

    public static String makeRandomFileNm(String fileNm){
        String uuid = UUID.randomUUID().toString();
        String substring = fileNm.substring(fileNm.lastIndexOf("."));
        String RdNm = uuid + substring;
        return RdNm;
    }


//    public static String getExt(String fileNm){
//        return fileNm.substring(fileNm.lastIndexOf(".")+1);
//
//    }
    public static String getFileNm(String fileNm){

        return fileNm.substring(0,fileNm.lastIndexOf("."));
    }
}

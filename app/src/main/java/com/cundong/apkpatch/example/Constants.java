package com.cundong.apkpatch.example;

import java.io.File;

import android.os.Environment;

/**
 * 类说明：  	常量类
 *
 * @author Cundong
 * @version 1.0
 * @date 2013-9-6
 */
public class Constants {

    public static final boolean DEBUG = true;

    public static final String MD5_FILE_PATH = "/mnt/internal_sd/md5.txt";

    //用于测试的packageName
    public static final String TEST_PACKAGENAME = "com.example.test2";

    public static final String PATH = Environment.getExternalStorageDirectory() + File.separator;

    //合成得到的新版apk
    public static final String NEW_APK_PATH = PATH + "new.apk";

    //从服务器下载来的差分包
    public static final String PATCH_PATH = PATH + "patch.patch";
}
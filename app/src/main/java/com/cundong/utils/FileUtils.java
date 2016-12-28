package com.cundong.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by liuenbao on 1/25/16.
 */
public class FileUtils {


    private static final String TAG = FileUtils.class.getSimpleName();
    private File file;

    public static String getJsonFromAssets(Context context, String filename) {
        InputStream mInputStream = null;
        String resultString = "";
        try {
            mInputStream = context.getAssets().open(filename);
            byte[] buffer = new byte[mInputStream.available()];
            mInputStream.read(buffer);
            resultString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                mInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString.toString();
    }

    public static Bitmap getBitmapFromAssets(Context context, String fileName) {
        Bitmap bitmap = null;
        InputStream imageStream = null;
        try {
            imageStream = context.getAssets().open(fileName);
            bitmap = BitmapFactory.decodeStream(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (imageStream != null) {
                try {
                    imageStream.close();
                } catch (IOException e) {

                }
            }
        }
        return bitmap;
    }

    public static boolean CopyRawResource(Context context, int id, String path) {
        Log.d(TAG, "copy -> " + path);
        try {
            InputStream ins = context.getResources().openRawResource(id);
            int size = ins.available();

            // Read the entire resource into a local byte buffer.
            byte[] buffer = new byte[size];
            ins.read(buffer);
            ins.close();

            FileOutputStream fos = new FileOutputStream(path);
            fos.write(buffer);
            fos.close();

            return true;
        } catch (Exception e) {
            Log.d(TAG, "public void createBinary() error! : " + e.getMessage());
        }

        return false;
    }

    /**
     * json文件转成字符串
     *
     * @param file
     * @return
     */
    public static String getStringFromJsonFile(File file) {
        StringBuffer sb = null;
        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            String readline = "";
            sb = new StringBuffer();
            while ((readline = br.readLine()) != null) {
                sb.append(readline);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String getStringFromJsonFilePath(String path) {
        StringBuffer sb = null;
        File file;
        if (!TextUtils.isEmpty(path)) {
            file = new File(path);
        } else {
            return null;
        }
        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            String readline = "";
            sb = new StringBuffer();
            while ((readline = br.readLine()) != null) {
                sb.append(readline);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}

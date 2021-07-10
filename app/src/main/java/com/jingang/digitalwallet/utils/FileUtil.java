package com.jingang.digitalwallet.utils;

import android.content.res.AssetManager;

import com.jingang.digitalwallet.base.MainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Author: jingang.Li
 * @CreateTime: 2021/7/10-4:37 PM
 */
public class FileUtil {
    public static synchronized String getStringFromAssets(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = MainApp.getApplication().getAssets();
            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}


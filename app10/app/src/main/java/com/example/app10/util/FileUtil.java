package com.example.app10.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    public static void saveText(String path, String text) {
        BufferedWriter os = null;
        try {
            os = new BufferedWriter(new FileWriter(path));
            os.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static String openText(String path) {
        BufferedReader is = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            is = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = is.readLine() )!= null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return stringBuilder.toString();
    }

}

/*
 * Copyright (c) 2021
 * User:jan
 * File:FileUtil.java
 * Date:2021/01/01 21:06:01
 */

package football.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author jan
 * @since 2021/1/1 21:06
 */
public class FileUtil {
    public static void createFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void writeFile(String path, List<String> dataList) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            dataList.forEach((data) -> {
                try {
                    bufferedWriter.write(data);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

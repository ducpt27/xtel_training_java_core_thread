package com.xtel.training.ptd.utils;

import java.io.*;
import java.util.*;

public class FileUtils {

    public static final boolean deleteFile(String filePath) {
        if (filePath == null) return true;
        File file = new File(filePath);
        if (file.exists()) return file.delete();
        return true;
    }

    public static void writeFile(String outFile, String data) throws Exception {
        writeFile(outFile, data, false);
    }

    public static void writeFile(String outFile, String data, boolean isAppend) throws Exception {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File(outFile);
            if (!file.exists()) file.createNewFile();
            fw = new FileWriter(file.getAbsoluteFile(), isAppend);
            bw = new BufferedWriter(fw);
            bw.write(data);
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String[] readFile(String filePath, int lineIndex) throws Exception {
        File f = new File(filePath);
        Scanner scanner = null;
        ArrayList<String> arr = new ArrayList<>();
        try {
            if (canRead(f)) {
                scanner = new Scanner(f);
                int i = 0;
                while (scanner.hasNextLine()) {
                    if (i != lineIndex) {
                        arr.add(scanner.nextLine());
                    } else {
                        String[] line = new String[1];
                        line[1] = scanner.nextLine();
                        return line;
                    }
                    i++;
                }
                scanner.close();
            }
            String[] lines = new String[arr.size()];
            return arr.toArray(lines);
        } catch (Exception e) {
            throw e;
        } finally {
            scanner.close();
            return null;
        }
    }

    public static String readLine(String filePath, int lineIndex) throws Exception {
        return readFile(filePath, lineIndex)[0];
    }

    public static String[] readFile(String filePath) throws Exception {
        return readFile(filePath, -1);
    }

    public static boolean canRead(File file) {
        return (file.isFile() && file.exists() && file.canRead());
    }
}

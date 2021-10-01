package ru.nsu.malov;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FindSubstring {
    private int[] zFunc(char[] str, int len) {
        int[] a = new int[len];
        int l = 0, r = 0;
        for (int i = 1; i < len; i++) {
            if (r < i) {
                a[i] = 0;
            } else {
                a[i] = Math.min((a[i - l]), r - i);
            }
            while (i + a[i] < len && str[a[i]] == str[i + a[i]]) {
                ++a[i];
            }
            if (i + a[i] > r) {
                l = i;
                r = i + a[i];
            }
        }
        return (a);
    }

    public void fileOpener(String filename) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader file;
        String sample;
        sample = scanner.nextLine();
        int samplelen = sample.length();
        char[] samplechar = new char[samplelen];
        samplechar = sample.toCharArray();
        try {
            file = new FileReader(filename, StandardCharsets.UTF_8);
            findSubstring(file, samplechar);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Integer> findSubstring(FileReader file, char[] sample) throws IOException {
        ArrayList<Integer> result = new ArrayList<>();
        int samplesize = sample.length;
        int buffsize = 12 * samplesize;
        char[] buff = new char[buffsize];
        int originalsize = buffsize + samplesize + 1;
        char[] original = new char[originalsize];
        System.arraycopy(sample, 0, original, 0, samplesize);
        original[samplesize] = '$';
        System.out.println(original);
        int i = 0, symbol = 0;
        symbol = file.read(buff);
        while (true) {
            if (symbol != -1) {
                System.arraycopy(buff, 0, original, samplesize + 1, buffsize);
                System.out.println(original);
                int[] res = new int[originalsize];
                res = zFunc(original, originalsize);
                int lastidx = 0;
                for (int j = samplesize + 1; j < originalsize; j++) {
                    if (res[j] == samplesize) {
                        System.out.println("Found matching");
                        lastidx = j - (samplesize + 1);
                        result.add(lastidx + i * buffsize + 1);
                    }
                }
                for (int j = 0; j < buffsize; j++) {
                    buff[j] = '\0';
                }
                int movei = lastidx + 2*samplesize;
                System.arraycopy(original, movei, original, samplesize + 1, originalsize - movei);
                System.out.println(original);
                symbol = file.read(buff);
                if (symbol == -1) {
                    System.out.println("End");
                    break;
                }
                System.arraycopy(buff, 0, original, originalsize - lastidx - samplesize, lastidx + samplesize);
                System.out.println();
                res = zFunc(original, originalsize);
                for (int j = samplesize + 1; j < originalsize; j++) {
                    if (res[j] == samplesize) {
                        result.add(i * buffsize + lastidx + j + 2);
                        System.out.println(i * buffsize + lastidx + j + 2);
                    }
                }
                ++i;

            } else {
                break;
            }
        }
        file.close();
        System.out.println(result);
        return result;
    }
}

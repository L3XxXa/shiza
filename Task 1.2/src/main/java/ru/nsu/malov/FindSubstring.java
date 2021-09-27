package ru.nsu.malov;

import java.io.*;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class FindSubstring {
    private static void zFunc(String str, int[] z) {
        int n = str.length();
        int l = 0, r = 0;
        for (int i = 1; i < n; ++i) {
            if (i > r) {
                l = r = i;
                while (r < n && str.charAt(r - l) == str.charAt(r))
                    r++;
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1)
                    z[i] = z[k];
                else {
                    l = i;
                    while (r < n && str.charAt(r - l) == str.charAt(r))
                        r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }
    }

    public int substringFinder(String filename) throws IOException {
        int buffsize = 256;
        String originalstring = null;
        String samplestring = null;
        BufferedReader buffread = new BufferedReader(new InputStreamReader(new FileInputStream(filename),
                StandardCharsets.UTF_8), buffsize);
        originalstring = buffread.readLine();
        samplestring = buffread.readLine();
        char sentinel = '$';
        String concat = samplestring + sentinel + originalstring;
        int concatlen = concat.length();
        int[] z = new int[concatlen];
        zFunc(concat, z);
        int l = -1;
        for (int i = 0; i < concatlen; i++) {
            if (z[i] == samplestring.length()) {
                l = i - samplestring.length() - 1;
            }
        }
        return l;
    }

    public int fileOpener(String filename) throws IOException {
        File file1 = new File(filename);
        int l = -1;
        if (!file1.exists()) {
            System.out.println("File doesn't exists");
            return -1;
        } else {
            System.out.println("File Successfully opened");
        }
        try {
            l = substringFinder(filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }
}

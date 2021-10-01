package ru.nsu.malov;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.lang.String;
import static org.junit.jupiter.api.Assertions.*;

class FindSubstringTest {
    FindSubstring test = new FindSubstring();
    FileReader reader;
    @Test
    void findSubstring_smalltext() throws IOException {
        String filename = "input1.txt";
        String sample = "pirog";
        char [] samplechar = sample.toCharArray();
        reader = new FileReader(filename);
        ArrayList<Integer> res = test.findSubstring(reader, samplechar);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        ans.add(7);
        assertEquals(ans, res);
    }
    @Test
    void findSubstring_bigtext() throws IOException{
        String filename = "input2.txt";
        String sample = "says";
        char [] samplechar = sample.toCharArray();
        reader = new FileReader(filename);
        ArrayList<Integer> res = test.findSubstring(reader, samplechar);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        String str = new String(Files.readAllBytes(Path.of(filename)));
        System.out.println(str);
        int c = str.indexOf(sample);
        System.out.println(c);
        if (c == -1){
            assertEquals(res, ans);
        }
        else{
            ans.add(c+1);
            assertEquals(res, ans);
        }
    }
    @Test
    void findSubstring_emptytext() throws IOException{
        String filename = "input3.txt";
        String sample = "hello";
        char [] samplechar = sample.toCharArray();
        reader = new FileReader(filename);
        ArrayList<Integer> res = test.findSubstring(reader, samplechar);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        String str = new String(Files.readAllBytes(Path.of(filename)));
        System.out.println(str);
        int c = str.indexOf(sample);
        System.out.println(c);
        if (c == -1){
            assertEquals(res, ans);
        }
        else{
            ans.add(c+1);
            assertEquals(res, ans);
        }


    }
    @Test
    void findSubstring_verybigtext() throws IOException{
        String filename = "input4.txt";
        String sample = "BIG BROTHER";
        char[] samplechar = sample.toCharArray();
        reader = new FileReader(filename);
        ArrayList<Integer> res = test.findSubstring(reader, samplechar);
        ArrayList<Integer> ans = new ArrayList<>();
        String str = new String(Files.readAllBytes(Path.of(filename)));
        System.out.println(str);
        int c = str.indexOf(sample);
        System.out.println(c);
        if (c == -1){
            assertEquals(res, ans);
        }
        else{
            ans.add(c+1);
            assertEquals(res, ans);
        }

    }
}
package ru.nsu.malov;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestFindSubstring {
    FindSubstring fb = new FindSubstring();
    @Test
    public void test1()throws IOException {
        String filename = "inputs/input1.txt";
        int l = fb.fileOpener(filename);
        int res = 0;
        assertEquals(l, res);
    }
    @Test
    public void test2()throws IOException{
        String filename = "inputs/input2.txt";
        int l = fb.fileOpener(filename);
        int res = -1;
        assertEquals(l, res);

    }

}

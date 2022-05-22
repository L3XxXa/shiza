import java.io.*;
import java.util.List;
import java.util.Scanner;

public class CachingClass {
    private static List<Json> notes;
    private static final String FILENAME = "CASSSSSSSSSSSSSSSSSSSSSSSSH.json";
    private static File file;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        file = new File(FILENAME);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int sentinel;
        System.out.println("""
                What you want to do:\s
                1 - cache something
                2 - get cache""");
        sentinel = scanner.nextInt();
        switch (sentinel){
            case 1:
            {
                System.out.println("What you want to cache?");
                String text = scanner.next();
                cache(text);
            }
            case 2:
            {
                String cachedMessage = readCache();
                System.out.println(cachedMessage);
            }
        }

    }

    private static String readCache() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME));
        Zavod zavod = new Zavod();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }
        return zavod.jsonUnzavod(stringBuilder.toString());

    }

    private static void cache(String text) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILENAME));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME));
        Zavod zavod = new Zavod();
        //notes.addAll();

    }
}

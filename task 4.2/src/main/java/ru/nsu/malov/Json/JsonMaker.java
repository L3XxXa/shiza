package ru.nsu.malov.Json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.nsu.malov.Note;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class JsonMaker {
    private final String name = "Notes";
    private final String extension = ".json";
    private File file;
    private FileWriter fileWriter;
    private String filename;
    private FileReader fileReader;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");
    Gson builder = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>)
                    (json, typeOfT, context) ->
                            LocalDateTime.parse(json.getAsString(), dateTimeFormatter.withLocale(Locale.ENGLISH)))
            .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>)
                    (src, typeOfSrc, context) -> new JsonPrimitive(dateTimeFormatter.format(src)))
            .setPrettyPrinting()
            .create();

    public JsonMaker(String name){
        this.filename = name+extension;
        this.file = new File(filename);
    }

    public String getName() {
        return name;
    }

    public JsonMaker(){
        this.filename = name+extension;
        this.file = new File(filename);
    }

    public void jsonWriter(List<Note> notes){
        try {
            fileWriter = new FileWriter(filename);
            Type type = new TypeToken<List<Note>>(){}.getType();
            String str = builder.toJson(notes, type);
            fileWriter.append(str);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public List<Note> jsonReader()  {
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file);
            Type type = new TypeToken<List<Note>>(){}.getType();
            System.out.println(type);
            System.out.println("file"+fileReader);
            String data = readFile(fileReader);
            System.out.println(data);
            return builder.fromJson(data, type);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    private String readFile(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data;
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.readLine()!=null){
            data = bufferedReader.readLine();
            stringBuilder.append(data);
        }
        return stringBuilder.toString();
    }
}

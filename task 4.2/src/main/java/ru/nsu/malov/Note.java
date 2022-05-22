package ru.nsu.malov;

import java.time.LocalDateTime;

public class Note {
    private String name;
    private String text;
    private LocalDateTime localDateTime;

    public Note(String name, String text){
        this.name = name;
        this.text = text;
        localDateTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}

package ru.nsu.malov;

import ru.nsu.malov.Json.JsonMaker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook {
    private String name;
    private List<Note> notes;

    public Notebook (String name){
        this.name = name;
        this.notes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addNote(String name, String text) {
        Note note = new Note(name, text);
        notes.add(note);
    }

    public void addNote(Note note){
        notes.add(note);
    }

    public void addNotes(List<Note> notesToAdd) {
        System.out.println(notesToAdd);
        for (Note note: notesToAdd) {
            System.out.println(note);
            notes.add(note);
        }
    }

    public void removeNote(String name) {
        notes.removeIf(note -> name.equals(note.getName()));
    }

    public List<Note> showAllNotes() {
        return notes;
    }



    public List<Note> showNotesByDateAndKeyWords(LocalDateTime before, LocalDateTime after, List<String> keys) {
        List<Note> res = notes.stream()
                .filter(a -> a.getLocalDateTime().isAfter(after))
                .filter(a -> a.getLocalDateTime().isBefore(before))
                .filter(b -> keys.stream().anyMatch(a -> b.getText().contains(a)))
                .collect(Collectors.toList());
        return res;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int c = 0;
        for (Note note : notes) {
            c++;
            stringBuilder.append("#" + c)
                    .append("\n")
                    .append("Name: ")
                    .append(note.getName())
                    .append("\n")
                    .append("Text:")
                    .append(note.getText())
                    .append("\n")
                    .append("Time:")
                    .append(note.getLocalDateTime())
                    .append("\n");

        }
        return stringBuilder.toString();
    }
}

package ru.nsu.malov.Json;

import org.apache.commons.cli.*;
import ru.nsu.malov.Note;
import ru.nsu.malov.Notebook;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Application {
    private Options options;
    private Notebook notebook;
    private JsonMaker jsonMaker = new JsonMaker();
    private File file;
    public Application() {
        options = new Options();
        Option add = Option.builder("a").hasArg().numberOfArgs(2).build();
        options.addOption(add);
        Option rm = Option.builder("rm").hasArg().numberOfArgs(1).build();
        options.addOption(rm);
        Option help = Option.builder("h").build();
        options.addOption(help);
        Option show = Option.builder("s").optionalArg(true).build();
        options.addOption(show);
    }

    public void init(String[] arg){
        CommandLineParser commandLineParser = new DefaultParser();
        try {
            CommandLine cli = commandLineParser.parse(options, arg);
            parseCLI(cli);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void addNotes(String name, String text) {
        notebook = new Notebook(jsonMaker.getName());
        Note note = new Note(name, text);
        notebook.addNote(note);
        System.out.println(jsonMaker.jsonReader());
        notebook.addNotes(jsonMaker.jsonReader());
        jsonMaker.jsonWriter(notebook.showAllNotes());
    }

    private void removeNotes(String name) {
        notebook = new Notebook(jsonMaker.getName());
        notebook.addNotes(jsonMaker.jsonReader());
        notebook.removeNote(name);
        jsonMaker.jsonWriter(notebook.showAllNotes());
    }

    private void showAllNotes() {
        notebook = new Notebook(jsonMaker.getName());
        List<Note> res = jsonMaker.jsonReader();
        if (res.size() != 0) {
            notebook.addNotes(res);
            System.out.println("====All notes====");
            System.out.println(notebook.toString());
            System.out.println("=================");
        } else {
            System.out.println("Can't find your notes");
        }
    }

    private void showNote(String before, String after, List<String> key) {
        notebook = new Notebook(jsonMaker.getName());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");
        LocalDateTime beforeDate = LocalDateTime.parse(before, dateTimeFormatter);
        LocalDateTime afterDate = LocalDateTime.parse(after, dateTimeFormatter);
        notebook.addNotes(jsonMaker.jsonReader());
        List<Note> res = notebook.showNotesByDateAndKeyWords(beforeDate, afterDate, key);
        if (res.size() == 0) {
            System.out.println("I can't find any note for your search query");
        } else {
            System.out.println("==========NOTES=========");
            System.out.println(notebook.toString());
            System.out.println("========================");
        }
    }

    private void sendHelpMessage(){
        String stringBuilder = "Hello!\n" +
                "This is a notebook by Ma61c_L3XxXa\n" +
                "CL options:\n" +
                "'-a'(2) - add new note. Arguments: (1) name of your note; (2) your note\n" +
                "'-rm'(1)  - delete your note. Arguments: (1) name of your note\n" +
                "'-s'(0) - show all notes\n" +
                "'-s'(3) - show notes sorted by date. Arguments: (1) date before; (2) date after; (3) keyword";
        System.out.println(stringBuilder);
    }

    private void parseCLI(CommandLine cl){
        if (cl.hasOption("a")) {
            String[] values = cl.getOptionValues("a");
            file = new File(values[0]);
            if (!file.exists()){
                jsonMaker = new JsonMaker(values[0]);
            } else {
                jsonMaker = new JsonMaker();
            }
            addNotes(values[0], values[1]);
        }
        else if (cl.hasOption("rm")) {
            String s = cl.getOptionValue("rm");
            removeNotes(s);
        }
        else if (cl.hasOption("h")){
            sendHelpMessage();
        }
        else if (cl.hasOption("s")) {
            String[] values = cl.getOptionValues("s");
            if (values != null) {
                List<String> keys = new ArrayList<>(Arrays.asList(values).subList(2, values.length));
                showNote(values[0], values[1], keys);
            } else {
                showAllNotes();
            }
        }
        else{
            sendHelpMessage();
        }
    }

}

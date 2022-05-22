package ru.nsu.voronova;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a note with specified title, content and its creation date.
 */
public class Note {
  private final String title;
  private final String content;
  private final Date creationDate;

  /**
   * Creates an instance of the class Note.
   *
   * @param title   - the title of the note.
   * @param content - the content of the note.
   */
  public Note(String title, String content) {
    this.title = title;
    this.content = content;
    this.creationDate = new Date();
  }

  /**
   * Allows getting the title of the note.
   *
   * @return the title of the note.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Allows getting the content of the note.
   *
   * @return the content of the note.
   */
  public String getContent() {
    return content;
  }

  /**
   * Allows getting the note's creation date.
   *
   * @return the note's creation date.
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Represents the note as a string.
   *
   * @return the note as a string.
   */
  @Override
  public String toString() {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    String date = formatter.format(creationDate);
    return "Title: \"" + title + "\"\n" +
            "Date of creation: " + date + "\n" +
            "Note: \"" + content + "\"";
  }

}
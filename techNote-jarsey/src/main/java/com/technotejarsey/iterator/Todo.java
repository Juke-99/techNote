package com.technotejarsey.iterator;

public class Todo {
  private String title;
  private String description;
  private String timestamp;

  public Todo(String title, String description, String timestamp) {
    this.title = title;
    this.description = description;
    this.timestamp = timestamp;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getTimestamp() {
    return timestamp;
  }
}

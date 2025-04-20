package DiaryApp;

import java.time.LocalDateTime;

public class Entry {
    private String title;
    private String bodyOfText;
    private int id;
    int count;
    private LocalDateTime dateCreated;

    public Entry(int id,String bodyOfText,String title) {
        this.id = id;
        this.bodyOfText = bodyOfText;
        this.title = title;
        this.dateCreated = LocalDateTime.now();
    }

    public void setId(int id) {
        if(id < 1) throw new IllegalArgumentException("ID must be greater than 1");
    }
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public String getBodyOfText() {
        return bodyOfText;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return count++;
    }


    }



//public void updateEntry() {
//        this.title = this.title.replaceAll(" ", "_");
//        this.bodyOfText = this.bodyOfText.replaceAll(" ", "_");
//        this.dateCreated = LocalDateTime.now();
//    }
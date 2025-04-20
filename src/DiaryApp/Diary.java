package DiaryApp;


import java.util.ArrayList;
import java.util.List;

public class Diary {
    private boolean unlocked;
    private String userName;
    private String password;
    private List<Entry> entries;

    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.entries = new ArrayList<>();

    }
    public String getUserName() {
        return this.userName;
    }
    public String getPassword() {
        return password;
    }
    public void lock() {
        unlocked = false;
    }

    public void unlock(String correctPassword) {
        if(getPassword().equals(correctPassword)) {
            unlocked = true;
        }
    }

    public boolean isLocked() {
        return unlocked;
    }

    public void createEntry(String title, String bodyOfText) {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(entry);
     //  Entry entry = new Entry(title,bodyOfText);


    }
}|

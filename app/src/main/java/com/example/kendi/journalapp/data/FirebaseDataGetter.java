package com.example.kendi.journalapp.data;

public class FirebaseDataGetter {
    String notesbody,notestitle;

    public FirebaseDataGetter() {
    }

    public FirebaseDataGetter(String notesbody, String notestitle) {
        this.notesbody = notesbody;
        this.notestitle = notestitle;
    }

    public String getNotesbody() {
        return notesbody;
    }

    public void setNotesbody(String notesbody) {
        this.notesbody = notesbody;
    }

    public String getNotestitle() {
        return notestitle;
    }

    public void setNotestitle(String notestitle) {
        this.notestitle = notestitle;
    }
}

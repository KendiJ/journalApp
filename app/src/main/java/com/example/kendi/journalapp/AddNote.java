package com.example.kendi.journalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kendi.journalapp.data.FirebaseDataGetter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNote extends AppCompatActivity {
    EditText noteb,notet;
    String notebstring,notetstring;
    Button saveb;
    DatabaseReference firebaseDatabase;
    FirebaseDataGetter firebaseDataGetter;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        noteb = findViewById(R.id.notebody);
        notet = findViewById(R.id.notetitle);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        saveb = findViewById(R.id.buttonset);
        saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();
            }
        });



    }
    public void savedata(){
        notebstring = noteb.getText().toString().trim();
        notetstring = notet.getText().toString().trim();
        firebaseDataGetter = new FirebaseDataGetter(notebstring,notebstring);
        firebaseDataGetter.setNotestitle(notetstring);
        firebaseDataGetter.setNotesbody(notebstring);
        firebaseDatabase.child("test").push().setValue(firebaseDataGetter);
        notet.setText("");
        noteb.setText("");
    }
}

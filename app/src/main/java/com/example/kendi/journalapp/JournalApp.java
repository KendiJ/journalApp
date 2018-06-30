package com.example.kendi.journalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.kendi.journalapp.data.FirebaseAdapterone;
import com.example.kendi.journalapp.data.FirebaseDataGetter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class JournalApp extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Button button;
    DatabaseReference databaseReference;
    FirebaseDataGetter firebaseDataGetter;
    List<FirebaseDataGetter> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_app);
        recyclerView = findViewById(R.id.RecyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference();
        button = findViewById(R.id.addnote);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JournalApp.this,AddNote.class));
            }
        });
        databaseReference.child("test").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    firebaseDataGetter = snapshot.getValue(FirebaseDataGetter.class);
                    list.add(firebaseDataGetter);

                }
                adapter = new FirebaseAdapterone(getApplicationContext(),list);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

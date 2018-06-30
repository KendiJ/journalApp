package com.example.kendi.journalapp.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kendi.journalapp.JournalApp;
import com.example.kendi.journalapp.R;

import java.util.List;

public class FirebaseAdapterone extends RecyclerView.Adapter<FirebaseAdapterone.ViewHolder>{
    Context mcontext;
    List<FirebaseDataGetter> data;
    JournalApp journalApp;

    public FirebaseAdapterone(Context mcontext, List<FirebaseDataGetter> data) {
        this.mcontext = mcontext;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View v = layoutInflater.inflate(R.layout.displaydata,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FirebaseDataGetter firebaseDataGetter = data.get(position);

        holder.text1.setText(firebaseDataGetter.getNotestitle());
        holder.text2.setText(firebaseDataGetter.getNotesbody());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView text1, text2;

        public ViewHolder(View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
        }
    }
}

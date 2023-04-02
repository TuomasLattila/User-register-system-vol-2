package com.example.viikko10_tehtava;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView userName, userDegreeProgram, userEmail, userDegrees;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.textViewUserName);
        userDegreeProgram = itemView.findViewById(R.id.textViewUserDegreeProgram);
        userEmail = itemView.findViewById(R.id.textViewUserEmail);
        userDegrees = itemView.findViewById(R.id.textViewDegrees);
    }
}

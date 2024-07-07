package com.example.smartbinn;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<String> userList;
    private Context context;

    public UserAdapter(List<String> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        String userName = userList.get(position);
        int userIndex = position + 1;
        String userIndexString = String.valueOf(userIndex);

        holder.textViewUserIndex.setText(userIndexString);
        holder.textViewUserName.setText(userName);
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewUserName;
        TextView textViewUserIndex;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            textViewUserIndex = itemView.findViewById(R.id.textViewUserIndex);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                String userName = userList.get(position);

                // Create an Intent to start the UserDetailsActivity
                Context context = view.getContext();
                Intent intent = new Intent(context, UserrDetailsActivity.class);

                // Pass the necessary user details to the UserDetailsActivity
                intent.putExtra("userName", userName);
                // Add more extras for other user details if needed

                context.startActivity(intent);
            }
        }

    }
    }



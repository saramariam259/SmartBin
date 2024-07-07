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

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.DriverViewHolder> {

    private List<String> driverList;
    private Context context;

    public DriverAdapter(List<String> driverList, Context context) {
        this.driverList = driverList;
        this.context = context;
    }

    @NonNull
    @Override
    public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.driver_item, parent, false);
        return new DriverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverViewHolder holder, int position) {
        String driverName = driverList.get(position);
        int driverIndex = position + 1;
        String driverIndexString = String.valueOf(driverIndex);

        holder.textViewDriverIndex.setText(driverIndexString);
        holder.textViewDriverName.setText(driverName);
    }


    @Override
    public int getItemCount() {
        return driverList.size();
    }

    public class DriverViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewDriverName;
        TextView textViewDriverIndex;
        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDriverName = itemView.findViewById(R.id.textViewDriverName);
            textViewDriverIndex = itemView.findViewById(R.id.textViewDriverIndex);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                String driverName = driverList.get(position);

                // Create an Intent to start the DriverDetailsActivity
                Context context = view.getContext();
                Intent intent = new Intent(context, viewdriverrlist.class);

                // Pass the necessary user details to the DriverDetailsActivity
                intent.putExtra("driverName", driverName);
                // Add more extras for other user details if needed

                context.startActivity(intent);
            }
        }

    }
}



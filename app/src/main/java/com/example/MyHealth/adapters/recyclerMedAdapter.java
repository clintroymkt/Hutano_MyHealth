package com.example.MyHealth.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyHealth.MedicalAids;
import com.example.MyHealth.R;

import java.util.ArrayList;

public class recyclerMedAdapter extends RecyclerView.Adapter<recyclerMedAdapter.MyViewHolder> {
    private ArrayList<MedicalAids> aidsList;
    private RecyclerViewClickListener listener;

    public  recyclerMedAdapter(ArrayList<MedicalAids> aidsList, RecyclerViewClickListener listener){
        this.aidsList = aidsList;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView aidnametxt;

        public MyViewHolder(final View view){
            super(view);
            aidnametxt = view.findViewById(R.id.providername);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public recyclerMedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.medaid_list, parent, false);
        return  new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerMedAdapter.MyViewHolder holder, int position) {
        String aidname = aidsList.get(position).getName();
        holder.aidnametxt.setText(aidname);

    }

    @Override
    public int getItemCount() {

        return aidsList.size();
    }

    public  interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}

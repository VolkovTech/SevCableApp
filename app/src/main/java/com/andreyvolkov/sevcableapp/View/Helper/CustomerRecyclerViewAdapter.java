package com.andreyvolkov.sevcableapp.View.Helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andreyvolkov.sevcableapp.R;

import java.util.ArrayList;

public class CustomerRecyclerViewAdapter extends RecyclerView.Adapter<CustomerRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> eventNames = new ArrayList<>();
    private ArrayList<String> eventDescriptions = new ArrayList<>();
    private ArrayList<String> eventDates = new ArrayList<>();
    private Context context;

    public CustomerRecyclerViewAdapter(Context context, ArrayList<String> eventTitles, ArrayList<String> eventDescriptions, ArrayList<String> eventDates) {
        this.eventNames = eventTitles;
        this.eventDescriptions = eventDescriptions;
        this.eventDates = eventDates;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        ViewHolder holder;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_event_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
//            Glide.with(context)
//                    .asBitmap()
//                    .load(personResultImages.get(position))
//                    .into(holder.itemImage);

        holder.customerEventName.setText(eventNames.get(position));
        holder.customerEventShortDescription.setText(eventDescriptions.get(position));
        holder.customerEventTime.setText(eventDates.get(position));

        holder.customerEventItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return eventNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView customerEventName;
        TextView customerEventShortDescription;
        TextView customerEventTime;
        RelativeLayout customerEventItemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            customerEventName = itemView.findViewById(R.id.customerEventName);
            customerEventShortDescription = itemView.findViewById(R.id.customerEventShortDescription);
            customerEventTime = itemView.findViewById(R.id.customerEventTime);
            customerEventItemLayout = itemView.findViewById(R.id.customerEventItemLayout);
        }
    }


}

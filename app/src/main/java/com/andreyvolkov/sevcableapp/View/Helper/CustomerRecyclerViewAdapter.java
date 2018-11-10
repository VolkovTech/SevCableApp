package com.andreyvolkov.sevcableapp.View.Helper;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andreyvolkov.sevcableapp.R;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomerRecyclerViewAdapter extends RecyclerView.Adapter<CustomerRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> eventNames = new ArrayList<>();
    private ArrayList<String> eventDescriptions = new ArrayList<>();
    private ArrayList<String> eventDates = new ArrayList<>();
    private ArrayList<String> eventPhotos = new ArrayList<>();
    private Context context;

    // vars for dialog
    private Dialog dialogEvents;
    private ImageView imageClose;
    private Button okButton;

    // dialog data
    private TextView customerEventTitle;
    private TextView customerEventDescription;

    private Typeface skRegular;

    public CustomerRecyclerViewAdapter(Context context, ArrayList<String> eventTitles, ArrayList<String> eventDescriptions, ArrayList<String> eventDates, ArrayList<String> eventPhotos) {
        this.eventNames = eventTitles;
        this.eventDescriptions = eventDescriptions;
        this.eventDates = eventDates;
        this.eventPhotos = eventPhotos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_event_item_layout, parent, false);
        skRegular = Typeface.createFromAsset(context.getAssets(), "fonts/AkzidenzGroteskPro-Regular.ttf");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context)
                .asBitmap()
                .load(eventPhotos.get(position))
                .into(holder.imageView);

        holder.customerEventName.setText(eventNames.get(position));
        holder.customerEventShortDescription.setText(eventDescriptions.get(position));
        holder.customerEventTime.setText(eventDates.get(position));

        holder.customerEventItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putTempDataToSharedPref(eventNames.get(position), eventDescriptions.get(position),
                        eventDates.get(position), "");
                openCustomerNewsfeedDialog(position);
            }
        });
    }

    private void putTempDataToSharedPref(String eventName, String eventDescription, String eventDate, String photoUrl) {
        SharedPreferences sharedPref = context.getSharedPreferences("tempData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("eventName", eventName);
        editor.putString("eventDescription", eventDescription);
        editor.putString("eventDate", eventDate);
        editor.putString("photoUrl", photoUrl);
        editor.apply();

    }

    public void openCustomerNewsfeedDialog(Integer position) {
        dialogEvents = new Dialog(context);
        dialogEvents.setContentView(R.layout.customer_layout_dialog);
        dialogEvents.show();

        imageClose = dialogEvents.findViewById(R.id.customerDialogClose);
        okButton = dialogEvents.findViewById(R.id.customerIAmInButton);

        customerEventTitle.setText(eventNames.get(position));
        customerEventDescription.setText(eventDescriptions.get(position));

        customerEventTitle.setTypeface(skRegular);
        customerEventDescription.setTypeface(skRegular);
        okButton.setTypeface(skRegular);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEvents.dismiss();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEvents.dismiss();
            }
        });

//        CustomerIAmInDialog customerIAmInDialog = new CustomerIAmInDialog();
//        customerIAmInDialog.show(((FragmentActivity)context).getSupportFragmentManager(), "customerIAmInDialog");
    }

    @Override
    public int getItemCount() {
        return eventNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView customerEventName;
        TextView customerEventShortDescription;
        TextView customerEventTime;
        ImageView imageView;
        RelativeLayout customerEventItemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            customerEventName = itemView.findViewById(R.id.customerEventName);
            customerEventShortDescription = itemView.findViewById(R.id.customerEventShortDescription);
            customerEventTime = itemView.findViewById(R.id.customerEventTime);
            imageView = itemView.findViewById(R.id.imageView);
            customerEventItemLayout = itemView.findViewById(R.id.customerEventItemLayout);

            customerEventName.setTypeface(skRegular);
            customerEventShortDescription.setTypeface(skRegular);
            customerEventTime.setTypeface(skRegular);
        }
    }


}

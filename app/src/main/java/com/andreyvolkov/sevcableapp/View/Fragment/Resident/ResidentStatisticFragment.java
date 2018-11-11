package com.andreyvolkov.sevcableapp.View.Fragment.Resident;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andreyvolkov.sevcableapp.R;

public class ResidentStatisticFragment extends Fragment {

    TextView residentAddingEventTitle;

    TextView residentEventNameText;
    EditText residentEventNameData;
    TextView residentEventDescriptionText;
    EditText residentEventDescriptionData;
    TextView residentEventDateText;
    EditText residentEventDateData;
    TextView residentEventPhotoText;
    EditText residentEventPhotoData;
    TextView residentEventVkLinkText;
    EditText residentEventVkLinkData;
    Button residentSendNewPerformanceButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resident_statistic_layout, container, false);
        init(view);
        setFonts();
        return view;
    }

    private void init(View view) {
        residentAddingEventTitle = view.findViewById(R.id.residentAddingEventTitle);

        residentEventNameText = view.findViewById(R.id.residentEventNameText);
        residentEventNameData = view.findViewById(R.id.residentEventNameData);

        residentEventDescriptionText = view.findViewById(R.id.residentEventDescriptionText);
        residentEventDescriptionData = view.findViewById(R.id.residentEventDescriptionData);

        residentEventDateText = view.findViewById(R.id.residentEventDateText);
        residentEventDateData = view.findViewById(R.id.residentEventDateData);

        residentEventPhotoText = view.findViewById(R.id.residentEventPhotoText);
        residentEventPhotoData = view.findViewById(R.id.residentEventPhotoData);

        residentEventVkLinkText = view.findViewById(R.id.residentEventVkLinkText);
        residentEventVkLinkData = view.findViewById(R.id.residentEventVkLinkData);

        residentSendNewPerformanceButton = view.findViewById(R.id.residentSendNewPerformanceButton);

        residentSendNewPerformanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = residentEventNameData.getText().toString();
                String description = residentEventDescriptionData.getText().toString();
                String date = residentEventDateData.getText().toString();
                String photo = residentEventPhotoData.getText().toString();
                String vkLink = residentEventVkLinkData.getText().toString();

            }
        });
    }

    private void setFonts() {
        Typeface skRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AkzidenzGroteskPro-Regular.ttf");
        residentAddingEventTitle.setTypeface(skRegular);
        residentEventNameText.setTypeface(skRegular); residentEventNameData.setTypeface(skRegular);
        residentEventDescriptionText.setTypeface(skRegular); residentEventDescriptionData.setTypeface(skRegular);
        residentEventDateText.setTypeface(skRegular); residentEventDateData.setTypeface(skRegular);
        residentEventPhotoText.setTypeface(skRegular); residentEventPhotoData.setTypeface(skRegular);
        residentEventVkLinkText.setTypeface(skRegular); residentEventVkLinkData.setTypeface(skRegular);
        residentSendNewPerformanceButton.setTypeface(skRegular);

    }
}

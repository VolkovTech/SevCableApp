package com.andreyvolkov.sevcableapp.View.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.andreyvolkov.sevcableapp.R;
import com.andreyvolkov.sevcableapp.View.Helper.CustomerRecyclerViewAdapter;

import java.util.ArrayList;

public class CustomerNewsfeedFragment extends Fragment {

    private ArrayList<String> eventNames = new ArrayList<>();
    private ArrayList<String> eventDescriptions = new ArrayList<>();
    private ArrayList<String> eventDates = new ArrayList<>();

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customer_newsfeed_layout, container, false);
        init(view);

        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    public void initRecyclerView(){
        CustomerRecyclerViewAdapter adapter = new CustomerRecyclerViewAdapter(
                getContext(), eventNames, eventDescriptions, eventDates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}

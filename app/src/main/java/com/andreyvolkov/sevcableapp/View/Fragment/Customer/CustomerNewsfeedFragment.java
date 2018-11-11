package com.andreyvolkov.sevcableapp.View.Fragment.Customer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel.IVkAuthModel;
import com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel.VkAuthModel;
import com.andreyvolkov.sevcableapp.R;
import com.andreyvolkov.sevcableapp.View.Helper.CustomerRecyclerViewAdapter;

import java.util.ArrayList;

public class CustomerNewsfeedFragment extends Fragment {

    private ArrayList<String> eventNames = new ArrayList<>();
    private ArrayList<String> eventDescriptions = new ArrayList<>();
    private ArrayList<String> eventDates = new ArrayList<>();
    private ArrayList<String> imageViews = new ArrayList<>();

    private RecyclerView recyclerView;

    private VkAuthModel model = new VkAuthModel();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customer_newsfeed_layout, container, false);
        try {
            init(view);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initRecyclerView();
        return view;
    }

    private void init(View view) throws InterruptedException {
        recyclerView = view.findViewById(R.id.customerNewsfeedRecyclerView);
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("userId", Context.MODE_PRIVATE);
        String userId = sharedPref.getString("id", "");
        model.sendWallRequest(userId);

        class UICheckAsyncTask extends AsyncTask<Void, Integer, Void> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (model.getNames() != null){
                    initRecyclerView();
                } else {
                    Toast.makeText(getContext(), "Что-то пошло не так", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    while (true){
                        if (model.getNames() == null || model.getNames().size() != 0) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        new UICheckAsyncTask().execute();
        Thread.sleep(2000);
    }

    public void initRecyclerView(){
        eventNames = model.getNames();
        eventDescriptions = model.getDescription();
        eventDates = model.getDates();
        imageViews = model.getImages();

        CustomerRecyclerViewAdapter adapter = new CustomerRecyclerViewAdapter(
                getContext(), eventNames, eventDescriptions, eventDates, imageViews);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}

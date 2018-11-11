package com.andreyvolkov.sevcableapp.View.Fragment.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andreyvolkov.sevcableapp.R;
import com.andreyvolkov.sevcableapp.View.Helper.CustomerRecyclerViewAdapter;

import java.util.ArrayList;

public class CustomerSearchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customer_search_layout, container, false);
        Intent i = new Intent(getContext(), CustomerMap.class);
        startActivity(i);
        return view;
    }

}

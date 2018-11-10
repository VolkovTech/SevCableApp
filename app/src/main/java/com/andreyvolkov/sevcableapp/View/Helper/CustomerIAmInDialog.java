package com.andreyvolkov.sevcableapp.View.Helper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.andreyvolkov.sevcableapp.R;


public class CustomerIAmInDialog extends AppCompatDialogFragment {

    private ImageView closeDialog;
    private Button iAmInButton;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.customer_layout_dialog, null);
        closeDialog = view.findViewById(R.id.customerDialogClose);
        iAmInButton = view.findViewById(R.id.customerIAmInButton);

        builder.setView(view);

        iAmInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        builder.setView(view);
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
        return builder.create();

//        return super.onCreateDialog(savedInstanceState);
    }
}

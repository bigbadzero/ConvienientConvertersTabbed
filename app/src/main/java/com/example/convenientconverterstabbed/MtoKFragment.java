package com.example.convenientconverterstabbed;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class MtoKFragment extends Fragment implements View.OnClickListener{

    public MtoKFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_mto_k, container, false);
        Button conversion = (Button)v.findViewById(R.id.ConversionButton);   // Acquire button reference
        Button clear = (Button)v.findViewById(R.id.clearButton); // Acquire button reference
        conversion.setOnClickListener(this);
        clear.setOnClickListener(this);

        return v;
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.ConversionButton:
                convertDistance();
                break;
            case R.id.clearButton:
                clear();
                break;

        }
    }

    private void convertDistance(){
        EditText milesText = getView().findViewById(R.id.milesText);
        EditText kilosText = getView().findViewById(R.id.kiloText);
        if(!milesText.getText().toString().matches("")){
            Double miles = Double.parseDouble(milesText.getText().toString());
            Double kilos = (miles * 1.609344);

            kilosText.setText(String.format("%.2f", kilos));
        }

        else if(!kilosText.getText().toString().matches("")){
            Double kilos = Double.parseDouble(kilosText.getText().toString());
            Double miles = (kilos * 0.621371);

            milesText.setText(String.format("%.2f", miles));
        }
    }

    private void clear(){
        EditText milesText = getView().findViewById(R.id.milesText);
        EditText kilosText = getView().findViewById(R.id.kiloText);
        milesText.setText("");
        kilosText.setText("");
    }

}

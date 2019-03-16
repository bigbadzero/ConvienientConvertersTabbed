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



public class FtoCFragment extends Fragment implements View.OnClickListener {

    public FtoCFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fto_c, container, false);
        Button conversion = (Button) v.findViewById(R.id.Calculate); // Acquire button reference
        Button clear = (Button) v.findViewById(R.id.Clear);
        conversion.setOnClickListener(this);
        clear.setOnClickListener(this);

        return v;
    }
    private void convertDegrees(){
        EditText farenheitText = getView().findViewById(R.id.fText);
        EditText celsiusText = getView().findViewById(R.id.cText);
        if(!farenheitText.getText().toString().matches("")){
            Double farenheit = Double.parseDouble(farenheitText.getText().toString());
            Double celsius = (farenheit - 32) * 5/9;

            celsiusText.setText(String.format("%.2f", celsius));
        }
        else if(!celsiusText.getText().toString().matches("")){
            Double celsius = Double.parseDouble(celsiusText.getText().toString());
            Double farenheit = ((celsius * 1.8) + 32);

            farenheitText.setText(String.format("%.2f", farenheit));
        }
    }

    private void clear(){
        EditText farenheitText = getView().findViewById(R.id.fText);
        EditText celsiusText = getView().findViewById(R.id.cText);
        farenheitText.setText("");
        celsiusText.setText("");
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.Calculate:
                convertDegrees();
                break;
            case R.id.Clear:
                clear();
                break;
        }

    }


}

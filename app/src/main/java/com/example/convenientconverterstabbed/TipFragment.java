package com.example.convenientconverterstabbed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipFragment extends Fragment implements View.OnClickListener {


    public TipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tip,container, false);
        Button calculate = (Button)v.findViewById(R.id.Calculate);
        Button clear = (Button)v.findViewById(R.id.Clear);
        calculate.setOnClickListener(this);
        clear.setOnClickListener(this);
        return v;
    }

    private void calculateEachPerson(){
        EditText totalText = getView().findViewById(R.id.TotalBillText);
        EditText percentText = getView().findViewById(R.id.tipPercentage);
        EditText peopleText = getView().findViewById(R.id.numberOfPeople);
        TextView message = getView().findViewById(R.id.Message);

        if(!totalText.getText().toString().matches("") || percentText.getText().toString().matches("") || peopleText.getText().toString().matches("")){
            Double bill = Double.parseDouble(totalText.getText().toString());
            Double tip = calculateTip(Double.parseDouble(percentText.getText().toString()), bill);
            Double people = Double.parseDouble(peopleText.getText().toString());
            Double eachPerson = (bill / people) + (tip / people);

            message.setText(String.format("Each person pays $%.2f each.", eachPerson));
        }
        else{
            message.setText("Make sure to enter all three fields");
        }
    }

    private double calculateTip(Double percent, Double bill){
        if(percent % 1 != 0){
            return percent * bill;
        }
        else{
            return (percent / 100) * bill;
        }
    }

    private void clear(){
        EditText totalText = getView().findViewById(R.id.TotalBillText);
        EditText percentText = getView().findViewById(R.id.tipPercentage);
        EditText peopleText = getView().findViewById(R.id.numberOfPeople);
        TextView message = getView().findViewById(R.id.Message);

        totalText.setText("");
        percentText.setText("");
        peopleText.setText("");
        message.setText("");
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.Calculate:
                calculateEachPerson();
                break;
            case R.id.Clear:
                clear();
                break;
        }
    }
}

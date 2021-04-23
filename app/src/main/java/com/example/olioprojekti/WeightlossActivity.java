package com.example.olioprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WeightlossActivity extends AppCompatActivity {
    static ArrayList<WeightData> weightDataArrayList = new ArrayList<>();

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightloss_);
        mEditText = findViewById(R.id.edit_text);
        mTextView = findViewById(R.id.BMI_textview);
    }


    public double calculateBMI(String text){
        double constant = 1.3;
        double height = (Double.parseDouble(DataHandler.getInstance().getAccount().getHeight()))/100;
        double weight = Double.parseDouble(text);
        weight = (constant*weight);
        height = Math.pow(height,2.5);
        double result = Math.round((weight/height)*10)/10.0;
        mTextView.setText("Your current BMI (rounded) is "+result+".");
        return result;
    }


    public void saveWeightData(View v) {
        String text = mEditText.getText().toString();
        Date currentTime = Calendar.getInstance().getTime();
        String dateToday = currentTime.toString();

        calculateBMI(text);

        WeightData data_input = new WeightData(dateToday, text);
        weightDataArrayList.add(data_input);
        DataHandler.getInstance().getAccount().setWeightDataArrayList(weightDataArrayList);
        DataHandler.getInstance().updateAccount(this);
        mEditText.getText().clear();
        Toast.makeText(WeightlossActivity.this, "Data added!", Toast.LENGTH_SHORT).show();
    }




}
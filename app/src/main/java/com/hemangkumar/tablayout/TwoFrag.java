package com.hemangkumar.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TwoFrag extends Fragment{

    EditText a1;
    EditText b1;
    EditText a2;
    EditText b2;

    EditText result1;
    EditText result2;

    EditText mPolarFormResult;
    EditText tPolarFormResult;

    Double r;
    Double theta;

    Float val1, val2;

    float a,b,c,d;

    Double rInput1;
    Double rInput2;

    Double thetaInput1;
    Double thetaInput2;

    Double w,x,y,z;

    Double inputCalcValue;
    Double inputCalcAngle;

    Double inputCalcRecta;
    Double inputCalcRectb;

    public TwoFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_two, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Variables a1,a2,b1,b2
        a1 = (EditText) getView().findViewById(R.id.editText1);
        b1 = (EditText) getView().findViewById(R.id.editText2);
        a2 = (EditText) getView().findViewById(R.id.editText3);
        b2 = (EditText) getView().findViewById(R.id.editText4);

        //Result Variable
        result1 = (EditText) getView().findViewById(R.id.editText5);
        result2 = (EditText) getView().findViewById(R.id.editText6);

        //Polar Form Variable
        mPolarFormResult = (EditText) getView().findViewById(R.id.editText7);
        tPolarFormResult = (EditText) getView().findViewById(R.id.editText8);

        //Buttons
        Button add = (Button) getView().findViewById(R.id.button);
        Button sub = (Button) getView().findViewById(R.id.button2);
        Button multiply = (Button) getView().findViewById(R.id.button3);
        Button divide = (Button) getView().findViewById(R.id.button4);

        final Button polarFormConverter = (Button) getView().findViewById(R.id.button5);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub(v);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiply(v);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divide(v);
            }
        });

        polarFormConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPolarForm();
                if(r!=null && theta!=null) {
                    mPolarFormResult.setText(String.valueOf(Math.round(r)));
                    tPolarFormResult.setText(String.valueOf(Math.round(theta)));
                }
            }
        });
    }

    public void add(View v){
        if(valuesAreValid()){
            getValues();

            result1.setText(String.valueOf(a + c));
            result2.setText(String.valueOf(b + d));
        }
    }

    public void sub(View v){
        if(valuesAreValid()){
            getValues();

            result1.setText(String.valueOf(a - c));
            result2.setText(String.valueOf(b - d));
        }
    }

    public void multiply(View v) {
        if(valuesAreValid()){
            getValues();
            getPolarFormOfInput();
            multiplyPolar();

            result1.setText(String.valueOf(Math.round(inputCalcRecta)));
            result2.setText(String.valueOf(Math.round(inputCalcRectb)));

        }
    }

    public void divide(View v){
        if(valuesAreValid()){
            getValues();
            getPolarFormOfInput();
            dividePolar();

            result1.setText(String.valueOf(Math.round(inputCalcRecta)));
            result2.setText(String.valueOf(Math.round(inputCalcRectb)));

        }

    }

    public void getValues(){
        a = Float.parseFloat(a1.getText().toString());
        b = Float.parseFloat(b1.getText().toString());
        c = Float.parseFloat(a2.getText().toString());
        d = Float.parseFloat(b2.getText().toString());
    }

    public Boolean valuesAreValid(){
        String first, second, third, fourth;
        first = a1.getText().toString();
        second = b1.getText().toString();
        third = a2.getText().toString();
        fourth = b2.getText().toString();

        if(first.equals(" ") || first.equals("")){
            Toast.makeText(TwoFrag.this.getActivity(), "Give a value of a1", Toast.LENGTH_SHORT).show();
        }

        else if(second.equals(" ") || second.equals("")){
            Toast.makeText(TwoFrag.this.getActivity(), "Give a value of b1", Toast.LENGTH_SHORT).show();
        }
        else if(third.equals(" ") || third.equals("")){
            Toast.makeText(TwoFrag.this.getActivity(), "Give a value of a2", Toast.LENGTH_SHORT).show();
        }
        else if(fourth.equals(" ") || fourth.equals("")){
            Toast.makeText(TwoFrag.this.getActivity(), "Give a value of b2", Toast.LENGTH_SHORT).show();
        }
        else{
            return true;
        }
        return false;
    }

    public Boolean denominatorNotZero(){
        return true;
    }

    public void getPolarForm(){
        if(getValueFromResult()) {
            r = Math.sqrt(val1 * val1 + val2 * val2);
            theta = Math.atan2(val2, val1) * 180 / Math.PI;
        }

    }



    public Boolean getValueFromResult(){
        if(result1.getText().toString().equals("") || result1.getText().toString().equals(" ") || result2.getText().toString().equals("") || result2.getText().toString().equals(" ")){
            Toast.makeText(TwoFrag.this.getActivity(), "Enter values of a and b!", Toast.LENGTH_SHORT).show();

            return false;
        }
        val1 = Float.parseFloat(result1.getText().toString());
       // Log.e("val1", String.valueOf(val1));
        val2 = Float.parseFloat(result2.getText().toString());
       // Log.e("val2", String.valueOf(val2));
        return true;
    }

    public void getPolarFormOfInput(){
        rInput1 = Math.sqrt(a * a + b * b);
        rInput2 = Math.sqrt(c * c + d * d);

        thetaInput1 = Math.atan2(b, a) * 180/Math.PI;
        thetaInput2 = Math.atan2(d, c) * 180/Math.PI;


    }

    public void convertPolarToRectangular(Double inputCalcAngle, Double inputCalcValue){
        inputCalcRecta = inputCalcValue * Math.cos(inputCalcAngle);
        inputCalcRectb = inputCalcValue * Math.sin(inputCalcAngle);

    }
    public void multiplyPolar(){
        inputCalcAngle = thetaInput1 + thetaInput2;
        inputCalcValue = rInput1 * rInput2;
        convertPolarToRectangular(inputCalcAngle, inputCalcValue);

    }

    public void dividePolar(){
        inputCalcAngle = thetaInput1 - thetaInput2;
        inputCalcValue = rInput1 / rInput2;
        convertPolarToRectangular(inputCalcAngle, inputCalcValue);

    }

}
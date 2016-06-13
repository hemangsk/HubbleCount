package com.hemangkumar.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ThreeFrag extends Fragment{

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

    float w,x,y,z;

    Double inputCalcValue;
    Double inputCalcAngle;

    Double inputCalcRecta;
    Double inputCalcRectb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_three, container, false);
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

        final Button rectangularFormConverter = (Button) getView().findViewById(R.id.button5);

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

        rectangularFormConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Double r1 = Double.parseDouble(result1.getText().toString());
                Double r2 = Double.parseDouble(result2.getText().toString());

                    shortConvertPolatToRectangular(r1, r2);
                    mPolarFormResult.setText(String.valueOf(Math.round(w)));
                    tPolarFormResult.setText(String.valueOf(Math.round(x)));


            }
        });
    }

    public void add(View v){
        if(valuesAreValid()){

            getValues();
            convertPolarToRectangular(a, b, c, d);
            convertRectangularToPolar(w+y, x+z);

            result1.setText(String.valueOf(Math.round(inputCalcValue)));
            result2.setText(String.valueOf(Math.round(inputCalcAngle)));

        }
    }

    public void sub(View v){
        if(valuesAreValid()){

            getValues();
            convertPolarToRectangular(a, b, c, d);
            convertRectangularToPolar(w-y, x-z);

            result1.setText(String.valueOf(Math.round(inputCalcValue)));
            result2.setText(String.valueOf(Math.round(inputCalcAngle)));

        }
    }

    public void multiply(View v) {
        if(valuesAreValid()){
            getValues();

            result1.setText(String.valueOf(Math.round(a * c)));
            result2.setText(String.valueOf(Math.round(b+d)));


        }
    }

    public void divide(View v){
        if(valuesAreValid()){
            getValues();

            result1.setText(String.valueOf(Math.round(a/c)));
            result2.setText(String.valueOf(Math.round(b-d)));

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
            Toast.makeText(ThreeFrag.this.getActivity(), "Give a value of r1", Toast.LENGTH_SHORT).show();
        }

        else if(second.equals(" ") || second.equals("")){
            Toast.makeText(ThreeFrag.this.getActivity(), "Give a value of \\u039811", Toast.LENGTH_SHORT).show();
        }
        else if(third.equals(" ") || third.equals("")){
            Toast.makeText(ThreeFrag.this.getActivity(), "Give a value of r2", Toast.LENGTH_SHORT).show();
        }
        else if(fourth.equals(" ") || fourth.equals("")){
            Toast.makeText(ThreeFrag.this.getActivity(), "Give a value of \\u039812", Toast.LENGTH_SHORT).show();
        }
        else{
            return true;
        }
        return false;
    }

    public void convertPolarToRectangular(float a, float b, float c, float d){
        w = Float.parseFloat(String.valueOf(a * Math.cos(b)));
        x = Float.parseFloat(String.valueOf(a * Math.sin(b)));
        y = Float.parseFloat(String.valueOf(c * Math.cos(b)));
        z = Float.parseFloat(String.valueOf(c * Math.sin(d)));

    }

    public void convertRectangularToPolar(float a, float b){
        Double a1 =  Double.parseDouble(String.valueOf(a));
        Double a2 = Double.parseDouble(String.valueOf(b));

        inputCalcValue = Math.sqrt(a1 * a1 + a2 * a2);
        inputCalcAngle = Math.atan2(a2,a1) * 180/Math.PI;

    }

    public void shortConvertPolatToRectangular(Double a, Double b){
        w = Float.parseFloat(String.valueOf(a * Math.cos(b)));
        x = Float.parseFloat(String.valueOf(a * Math.sin(b)));

    }

}
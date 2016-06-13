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

import org.w3c.dom.Text;


public class OneFrag extends Fragment{

    EditText editText;

    Button sin, cos, tan;

    Button radian, degree;

    TextView result;

    public OneFrag() {
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
        return inflater.inflate(R.layout.frag_one, container, false);



    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = (EditText) getView().findViewById(R.id.editText);

        sin = (Button) getView().findViewById(R.id.button6);
        cos = (Button) getView().findViewById(R.id.button7);
        tan = (Button) getView().findViewById(R.id.button8);

        radian = (Button) getView().findViewById(R.id.button9);
        degree = (Button) getView().findViewById(R.id.button10);

        result = (TextView) getView().findViewById(R.id.textView13);

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("Heyeyeye", String.valueOf(Math.acos(2.09)));
                Log.e("Hey", String.valueOf(Math.round(Math.asin(Float.parseFloat(editText.getText().toString())))));
                result.setText(String.valueOf((Math.asin(Float.parseFloat(editText.getText().toString())))));
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(String.valueOf((Math.acos(Float.parseFloat(editText.getText().toString())))));

            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(String.valueOf((Math.atan(Float.parseFloat(editText.getText().toString())))));

            }
        });

        degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("Deg", String.valueOf(Float.parseFloat(editText.getText().toString())));
                result.setText(String.valueOf(Float.parseFloat(editText.getText().toString()) * 180/Math.PI));
            }
        });

        radian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(String.valueOf((Float.parseFloat(editText.getText().toString()) * Math.PI)/180));
            }
        });
    }
}
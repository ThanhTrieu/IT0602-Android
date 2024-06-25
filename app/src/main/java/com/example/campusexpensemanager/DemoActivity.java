package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DemoActivity extends AppCompatActivity {
    private CheckBox Agree;
    private Button Submit;
    private RadioButton Age;
    private Button Confirm;
    private final String FlagTag = "DemoActivity";
    private RadioButton radNormal, radGood, radVeryGood;
    private TextView tvDialog;

    CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            tvDialog = findViewById(R.id.tv_dialog);
            if(isChecked){
                tvDialog.setText("You choose : " + buttonView.getText());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Agree = findViewById(R.id.cb_agree); // tim ra checkbox
        Submit = findViewById(R.id.btn_submit); // tim ra Button Submit
        Submit.setEnabled(false); // khoa khong cho click vao Button
        Confirm = findViewById(R.id.btn_confirm); // tim ra Button Confirm
        Confirm.setEnabled(false); // khoa Button Confirm
        Age = findViewById(R.id.rad_age);
        Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Confirm.setEnabled(true);
            }
        });
        Agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Submit.setEnabled(true); // mo khoa Button
                    Log.i(FlagTag, " Checkbox is checked");
                } else {
                    Submit.setEnabled(false); // khoa Button lai
                    Log.i(FlagTag, " Checkbox is not checked");
                }
            }
        });
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            }
        });


        radNormal = findViewById(R.id.rad_normal);
        radGood = findViewById(R.id.rad_good);
        radVeryGood = findViewById(R.id.rad_very_good);
        radNormal.setOnCheckedChangeListener(listenerRadio);
        radGood.setOnCheckedChangeListener(listenerRadio);
        radVeryGood.setOnCheckedChangeListener(listenerRadio);
    }
}

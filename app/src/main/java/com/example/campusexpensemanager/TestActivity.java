package com.example.campusexpensemanager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button buttonToast = findViewById(R.id.btn_showToast);
        Button buttonAlert = findViewById(R.id.btn_alertDialog);

        buttonAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("Dialog", "Learning androidX java", "Yes");
            }
        });
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Hello you - IT0601");
            }
        });
    }

    private void showToast(String mess){
        Toast.makeText(TestActivity.this,mess, Toast.LENGTH_SHORT).show();
    }
    private void showAlertDialog(String title, String message, String iconText){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(iconText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Successfully");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Cancel");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

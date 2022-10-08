package com.example.gky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    ImageButton logout;
    BottomNavigationView nav;
    EditText etmail, etphone, etdate, etsex, etaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        logout = (ImageButton)  findViewById(R.id.logout);
        nav =  findViewById(R.id.nav);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(ProfileActivity.this);
                alertDiaLog.setTitle("Are you sure log out?");

                alertDiaLog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                alertDiaLog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDiaLog.show();
            }
        });
        etmail = (EditText) findViewById(R.id.etmail);
        etphone = (EditText) findViewById(R.id.etphone);
        etdate = (EditText) findViewById(R.id.etdate);
        etsex = (EditText) findViewById(R.id.etsex);
        etaddress = (EditText) findViewById(R.id.etaddress);

        etmail.setEnabled(false);
        etphone.setEnabled(false);
        etsex.setEnabled(false);
        etaddress.setEnabled(false);
        etdate.setEnabled(false);

        nav.setSelectedItemId(R.id.pro);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.artw:
                        startActivity(new Intent(getApplicationContext(), ListviewArtActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.pro:
                        return true;
                }
                return false;
            }
        });

    }
}
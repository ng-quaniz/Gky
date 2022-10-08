package com.example.gky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetialActivity extends AppCompatActivity {
        ImageButton dtback;
        TextView dtname, dttitle;
        ImageView dtimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detial);

        dttitle = (TextView) findViewById(R.id.dttitle);
        dtback = (ImageButton) findViewById(R.id.dtback);
        dtimg = (ImageView) findViewById(R.id.dtimg);
        dtname = (TextView) findViewById(R.id.dtname);

        dttitle.setEnabled(false);

        dtback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetialActivity.this, ListviewArtActivity.class);
                startActivity(intent);
            }
        });

        Intent intent= getIntent();
        dtname.setText(intent.getStringExtra("name"));
        dtimg.setImageResource(intent.getIntExtra("img",0));
        dttitle.setText(intent.getStringExtra("title"));
    }
}
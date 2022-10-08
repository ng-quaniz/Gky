package com.example.gky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;


public class ListviewArtActivity extends AppCompatActivity {

    private ListView lv;
    ArrayList<listview> arrayCourse = new ArrayList<>();
    ListviewAdapter adapter;

    boolean kt=false;
    BottomNavigationView nav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_art);

        lv = (ListView)  findViewById(R.id.lv);
        nav = (BottomNavigationView) findViewById(R.id.nav);


        arrayCourse.add(new listview("Ếch đi bụi", R.drawable.ech, "Ếch cửi nấm đi bụi.")) ;
        arrayCourse.add(new listview("Cửa", R.drawable.cua, "À chỉ là 1 cánh cửa!")) ;
        arrayCourse.add(new listview("Hồ đêm", R.drawable.cay, "Mặt hồ phản chiếu buổi đêm.")) ;
        arrayCourse.add(new listview("Cá voi", R.drawable.ca, "Con cá voi đang bơi dưới trời đêm.")) ;
        arrayCourse.add(new listview("Hoa", R.drawable.hoa, " Hướng (dương) trái, phải  hồng.")) ;
        arrayCourse.add(new listview("Biển", R.drawable.bien, "Sóng biển, cát và cua.")) ;
        arrayCourse.add(new listview("Lâu đài", R.drawable.nha, "Lâu đài trên mây.")) ;
        adapter = new ListviewAdapter(ListviewArtActivity.this, arrayCourse);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListviewArtActivity.this,DetialActivity.class);
                intent.putExtra("name",arrayCourse.get(i).getName());
                intent.putExtra("img",arrayCourse.get(i).getImg());
                intent.putExtra("title",arrayCourse.get(i).getTitle());

                if (kt!=true)
                    startActivity(intent);
                kt=false;
            }
        });

        nav.setSelectedItemId(R.id.artw);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.artw:
                        return true;

                    case R.id.pro:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
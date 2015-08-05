package com.google.android.gms.location.app.gpsmybus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

import com.google.android.gms.location.sample.locationupdates.R;

public class hotels extends Activity {
    ListView list;
    String[] web = {
            "Arbor Breweries",
            "Brewsky",
            "Fujian-24",
            "Toit",
            "skybar",
            "leela-palace"

    } ;
    Integer[] imageId = {
            R.drawable.abc,
            R.drawable.brewsky,
            R.drawable.fujian,
            R.drawable.toit,
            R.drawable.skybar,
            R.drawable.leelapalace


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        CustomList adapter = new
                CustomList(hotels.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(hotels.this, "You have selected" +web[+ position], Toast.LENGTH_SHORT).show();

                // 0 - for private mode`
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

                SharedPreferences.Editor editor1 = pref.edit();


//            editor1.putString("Bus_Route_no", route_no);
                editor1.putString("hotel", web[+ position]);
                editor1.commit();
                Intent intent = new Intent(hotels.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

}
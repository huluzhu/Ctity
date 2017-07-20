package com.bwie.ctity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.city_picker.CityListActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCity = (Button) findViewById(R.id.buttom);
        btnCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityListActivity.startCityActivityForResult(MainActivity.this);
            }
        });
    }

    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CityListActivity.REQUEST_CODE && resultCode == CityListActivity.RESULT_CODE) {
            String city = data.getStringExtra(CityListActivity.RESULT_KEY);
            btnCity.setText(city);
        }
    }
}

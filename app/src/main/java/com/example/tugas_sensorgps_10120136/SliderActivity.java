package com.example.tugas_sensorgps_10120136;
//Nama  : Alif Aziz Alviansyah
//NIM   : 10120136
//Kelas : IF 4
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SliderActivity extends AppCompatActivity{
    ViewPager viewPager;
    Button tombolVP;
    int[] layouts;
    Adapter_VP adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        viewPager = findViewById(R.id.Pager);
        tombolVP = findViewById(R.id.tombolViewPager);

        layouts = new int[]{
                R.layout.vp1_layout,
                R.layout.vp2_layout,
                R.layout.vp3_layout
        };

        adapter = new Adapter_VP(this, layouts);
        viewPager.setAdapter(adapter);
        tombolVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() + 1 < layouts.length) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    //kembali ke main activity
                    startActivity(new Intent(SliderActivity.this, MainActivity.class));
                    finish();
                }
            }
        });

        viewPager.addOnPageChangeListener(viewPagerChangeListener);
    }

    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if(i == layouts.length -1 ){
                tombolVP.setText("Mulai");
            }else {
                tombolVP.setText("Selanjutnya");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

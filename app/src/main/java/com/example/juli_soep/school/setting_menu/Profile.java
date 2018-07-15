package com.example.juli_soep.school.setting_menu;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.main_menu.Setting;
import com.example.juli_soep.school.tab.MyAdapter;
import com.example.juli_soep.school.tab.SlidingTabLayout;

public class Profile extends AppCompatActivity {

    private ViewPager mViewPager;
    private SlidingTabLayout mSlidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mViewPager = (ViewPager)findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout = (SlidingTabLayout)findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorAqua));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAquaDark));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {
        Intent kembali = new Intent(Profile.this, Setting.class);
        startActivity(kembali);
        finish();
    }
}

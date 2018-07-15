package com.example.juli_soep.school.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.example.juli_soep.school.R;
import com.example.juli_soep.school.fragment.KontakFragment;
import com.example.juli_soep.school.fragment.MisiFragment;
import com.example.juli_soep.school.fragment.SejarahFragment;
import com.example.juli_soep.school.fragment.VisiFragment;

/**
 * Created by juli_soep on 14/07/2018.
 */

public class MyAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] titles = {"A","B","C","D"};
    int[] icon = new int[]{R.drawable.ic_slide_sejarah, R.drawable.ic_slide_visi, R.drawable.ic_slide_misi, R.drawable.ic_slide_kontak};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        if(position ==0){
            frag = new SejarahFragment();
        }else if(position == 1){
            frag = new VisiFragment();
        }else if(position == 2){
            frag = new MisiFragment();
        }else if(position == 3){
            frag = new KontakFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }
}

package com.example.juli_soep.school.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juli_soep.school.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by juli_soep on 14/07/2018.
 */

public class KontakFragment extends Fragment{

    private SupportMapFragment mapFragment;

    public KontakFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kontak, container, false);
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    LatLng latLng = new LatLng(-5.4285755, 105.200697);
                    googleMap.addMarker(new MarkerOptions().position(latLng)
                            .title("My School"));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                    googleMap.getMinZoomLevel();
                    googleMap.getMaxZoomLevel();
                }
            });
        }

        // R.id.map is a FrameLayout, not a Fragment
        getChildFragmentManager().beginTransaction().replace(R.id.maps, mapFragment).commit();

        return v;
    }

}

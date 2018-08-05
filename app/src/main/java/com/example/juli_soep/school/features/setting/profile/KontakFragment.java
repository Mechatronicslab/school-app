package com.example.juli_soep.school.features.setting.profile;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juli_soep.school.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by juli_soep on 14/07/2018.
 */

public class KontakFragment extends Fragment implements OnMapReadyCallback {
    Context mContext;
    private SupportMapFragment GmapView;
    GoogleMap Gmap;

    public KontakFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kontak, container, false);
        /*if (mapFragment == null) {
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
        getChildFragmentManager().beginTransaction().replace(R.id.maps, mapFragment).commit();*/
        GmapView = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.maps);
        GmapView.getMapAsync(this);

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Gmap = googleMap;
        Gmap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        LatLng latLng = new LatLng(-5.382825,  105.293276);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Gmap.setMyLocationEnabled(true);
        //Gmap.getUiSettings().setMyLocationButtonEnabled(true);
        Gmap.getUiSettings().setZoomControlsEnabled(true);

        Gmap.addMarker(new MarkerOptions().position(latLng)
                .title("SMK BLK"));
        Gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                latLng, 20));
        //Gmap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        Gmap.getMinZoomLevel();
        Gmap.getMaxZoomLevel();
    }
    @Override
    public void onResume() {
        super.onResume();

        if (GmapView != null)
            GmapView.onResume();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (GmapView == null)
        GmapView.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (GmapView != null)
            GmapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (GmapView != null)
            GmapView.onStop();

    }
}

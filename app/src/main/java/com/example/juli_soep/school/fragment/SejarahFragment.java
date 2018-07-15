    package com.example.juli_soep.school.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juli_soep.school.R;


    /**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SejarahFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SejarahFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SejarahFragment extends Fragment {

    public SejarahFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sejarah, container, false);
    }

}

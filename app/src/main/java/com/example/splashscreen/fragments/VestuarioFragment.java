package com.example.splashscreen.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.splashscreen.R;
import com.example.splashscreen.activities.Activity_detalhes;
import com.example.splashscreen.activities.ProfileActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VestuarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VestuarioFragment extends Fragment {


    LinearLayout Produto01;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VestuarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VestuarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VestuarioFragment newInstance(String param1, String param2) {
        VestuarioFragment fragment = new VestuarioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vestuario, container, false);

        Produto01 = view.findViewById(R.id.produto_01);
        Produto01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getActivity(), Activity_detalhes.class);
                startActivity(b);
            }
        });
        return view;
    }
}
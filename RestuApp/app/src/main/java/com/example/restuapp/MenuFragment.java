package com.example.restuapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "dishesName";
    private static final String ARG_PARAM2 = "dishesPrice";
    private static final String ARG_PARAM3 = "dishesIng";


    // TODO: Rename and change types of parameters
    private String mDishesName;
    private int mDishesPrice;
    private String mDishesIng;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mDishesName Parameter 1.
     * @param mDishesPrice Parameter 2.
     * @param mDishesIng Parameter 3.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String mDishesName, int mDishesPrice,String mDishesIng) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mDishesName);
        args.putInt(ARG_PARAM2, mDishesPrice);
        args.putString(ARG_PARAM3, mDishesIng);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDishesName = getArguments().getString(ARG_PARAM1);
            mDishesPrice = getArguments().getInt(ARG_PARAM2);
            mDishesIng = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
}
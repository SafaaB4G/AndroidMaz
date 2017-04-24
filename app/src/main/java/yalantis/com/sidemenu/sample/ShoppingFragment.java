package yalantis.com.sidemenu.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import static yalantis.com.sidemenu.sample.R.layout.activity_excursion_fragment;

/**
 * Created by macbookair on 05/04/2017.
 */

public class ShoppingFragment  extends Fragment {


    public ShoppingFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(activity_excursion_fragment, container, false);
    }



}
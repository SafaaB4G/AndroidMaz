package yalantis.com.sidemenu.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import static yalantis.com.sidemenu.sample.R.layout.activity_villa_fragment;

public class VillaFragment extends ListFragment {


    public VillaFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {

                return inflater.inflate(activity_villa_fragment, container, false);
            }


            public void onListItemClick(ListView l, View v, int position, long id) {
                // TODO Auto-generated method stub
                // super.onListItemClick(l, v, position, id);

                Toast.makeText(getActivity(), "Position " + position, Toast.LENGTH_SHORT).show();
            }
        }
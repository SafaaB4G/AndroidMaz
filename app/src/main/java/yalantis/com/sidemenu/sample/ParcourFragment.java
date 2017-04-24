package yalantis.com.sidemenu.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tools.CallWebService;
import tools.Menus;

import static yalantis.com.sidemenu.sample.R.layout.activity_parcour_fragment;

/**
 * Created by macbookair on 05/04/2017.
 */

public class ParcourFragment extends Fragment {



    public ParcourFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ArrayList<Menus> l =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("PARCOURS"));

        Log.d("  content",""+l.get(0).getDescription());



        View RootView = inflater.inflate(R.layout.activity_parcour_fragment, container, false);

        TextView tv = (TextView)RootView.findViewById(R.id.textView1);
        tv.setText(""+l.get(0).getDescription());

        return RootView;    }



}
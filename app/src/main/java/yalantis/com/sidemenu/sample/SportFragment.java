package yalantis.com.sidemenu.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import static yalantis.com.sidemenu.sample.R.layout.activity_sport_fragment;

/**
 * Created by macbookair on 05/04/2017.
 */

public class SportFragment extends Fragment{

  private WebView webView;


    public SportFragment() {

        // Required empty public constructor
    }



    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.activity_sport_fragment, container, false);

        webView = (WebView) v.findViewById(R.id.webView);
        webView.loadUrl("http://www.ul.com");

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setBackgroundColor(0);

        webView.getSettings().setJavaScriptEnabled(true);

        String str= "<h2>Activités terrestres :</h2><br><li>Mazagan dispose d un large choix d activités en plein air<ul>" +
                "<li>Tennis</li><li>Karting</li><li>Footing</li><li>Tir à l arc</li><li>Paintball</li><li>VTT</li>" +
                "<li>Marche nordique</li>" + "<li>Tennis de table</li><li>Le Cavalier</li></ul></li><h2>Activités nautiques</h2>" +
                "<br><ul><li>Beach volley</li><li>Jet-ski </li>" +
                "<li>Surf / Body-board</li><li>Quad / Buggy</li></ul><br>" +
                "<br><h2>Les activités gratuites<h2><a href='https://drive.google.com/open?id=0B7ybqcnuBpwYZmRzS1c5a2Y5SlU'>" +
                "<img src=\"file:///android_res/drawable/gra.jpg\"  height=\"350\" width=\"350\"/></a><br><br>" +
                "<h2>Les activités payantes<h2><a href='https://drive.google.com/open?id=0B3z9iesl3xe8NnNiNHRzcFFOUE0'><img src=\"file:///android_res/drawable/pay.jpg\" height=\"350\" width=\"350\" /></a>";
        webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);

        return v;




    }



}
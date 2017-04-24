package yalantis.com.sidemenu.sample;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import tools.CallWebService;
import yalantis.com.sidemenu.interfaces.Resourceble;
import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.model.SlideMenuItem;
import yalantis.com.sidemenu.sample.fragment.ContentFragment;
import yalantis.com.sidemenu.util.ViewAnimator;


public class HomeActivity extends AppCompatActivity implements ViewAnimator.ViewAnimatorListener {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private List<SlideMenuItem> list = new ArrayList<>();
    private ContentFragment contentFragment;
    private ViewAnimator viewAnimator;
    private int res = R.drawable.content_music;
    private LinearLayout linearLayout;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        contentFragment = ContentFragment.newInstance(R.drawable.content_music);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, contentFragment)
                .commit();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        linearLayout = (LinearLayout) findViewById(R.id.left_drawer);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });


        setActionBar();
        createMenuList();
        viewAnimator = new ViewAnimator<>(this, list, contentFragment, drawerLayout, this);

//lauch dialog
        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        Log.println(Log.ASSERT, "loglog", "My Flot" + myFab);
        if (myFab != null) {
            myFab.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    final Dialog mDialog;
                    mDialog = new Dialog(HomeActivity.this);
                    mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    mDialog.setContentView(R.layout.dialog_choise_destination);
                    TextView ok = (TextView) mDialog.findViewById(R.id.dialogyes);
                    ok = (TextView) mDialog.findViewById(R.id.dialogyes);
                    //cancel=(TextView) mDialog.findViewById(R.id.fab);
                    ok.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {


                            mDialog.cancel();

                        }
                    });
                    ok.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {

                            Spinner mySpinner=(Spinner) mDialog.findViewById(R.id.spinner4);
                            String choise = mySpinner.getSelectedItem().toString();
                            //getting the valur of choise here from the spinner
                            final Intent intent = new  Intent(HomeActivity.this,MapsActivity.class);
                            LatLng latLng = null;
                            switch (choise){

                                case "Restauration":
                                    latLng = new LatLng(33.990235,-6.837755);
                                    break;
                                case "SPA":
                                    latLng = new LatLng(34.0182478,-6.8355187);
                                    break;

                                case "GOLF":
                                    latLng = new LatLng(34.025719,-6.82607);
                                    break;

                                case "Shopping":
                                    latLng = new LatLng(34.0124885,-6.8494103);
                                    break;

                                case "Baby Club":
                                    latLng = new LatLng(34.0159083,-6.8353092);
                                    break;

                            }
                            intent.putExtra("Menu",latLng);
                            mDialog.dismiss();
                            startActivity(intent);
                        }
                    });
                    mDialog.show();

                }
            });


    }}

    /**
     * Initialize all required variables
     */

    //create the menu
    private void createMenuList() {
        SlideMenuItem menuItem0 = new SlideMenuItem(ContentFragment.CLOSE, R.drawable.icn_close);
        list.add(menuItem0);
        SlideMenuItem menuItem1 = new SlideMenuItem(ContentFragment.Home, R.drawable.icn_1);
        list.add(menuItem1);
        SlideMenuItem menuItem = new SlideMenuItem(ContentFragment.BUILDING, R.drawable.icn_1);
        list.add(menuItem);
        SlideMenuItem menuItem2 = new SlideMenuItem(ContentFragment.BOOK, R.drawable.icn_2);
        list.add(menuItem2);
        SlideMenuItem menuItem3 = new SlideMenuItem(ContentFragment.PAINT, R.drawable.icn_3);
        list.add(menuItem3);
        SlideMenuItem menuItem4 = new SlideMenuItem(ContentFragment.CASE, R.drawable.icn_4);
        list.add(menuItem4);
        SlideMenuItem menuItem5 = new SlideMenuItem(ContentFragment.SHOP, R.drawable.icn_5);
        list.add(menuItem5);
        SlideMenuItem menuItem6 = new SlideMenuItem(ContentFragment.PARTY, R.drawable.icn_6);
        list.add(menuItem6);



    }



    private void setActionBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                linearLayout.removeAllViews();
                linearLayout.invalidate();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset > 0.6 && linearLayout.getChildCount() == 0)
                    viewAnimator.showMenuContent();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }





    private ScreenShotable replaceFragment(ScreenShotable screenShotable, int topPosition) {

        this.res = this.res == R.drawable.content_music ?
                R.drawable.content_films :
                R.drawable.content_music;
        View view = findViewById(R.id.content_frame);

        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, topPosition, 0, finalRadius);
        animator.setInterpolator(new AccelerateInterpolator());

        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);

        findViewById(R.id.content_overlay).setBackgroundDrawable(new BitmapDrawable(getResources(), screenShotable.getBitmap()));
        animator.start();

        ContentFragment contentFragment = ContentFragment.newInstance(this.res);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();

        return contentFragment;
    }


    public ScreenShotable onSwitch(Resourceble slideMenuItem, ScreenShotable screenShotable, int position) {
        switch (slideMenuItem.getName()) {
            case ContentFragment.CLOSE:
                return screenShotable;

            case ("Home"):{
                Log.d("test de tagp1 "," je suis Hebergemnt ");
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);



                break;
            }

            case ("Hebergement"):{
                Log.d("test de tagp1 "," je suis Hebergemnt ");

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);


                break;
            }

            case ("Restaurants"):{
                Log.d("test de tagp1 "," je suis Restaurants ");
                Intent intent = new Intent(this, RestaurationActivity.class);
                startActivity(intent);

                break;


            }
            case ("Golf"):{
                Log.d("test de tagp1 "," je suis Golf ");
                Intent intent = new Intent(this, GolfActivity.class);
                startActivity(intent);


                break;


            }
            case ("Spa"):{
                Log.d("test de tagp1 "," je suis spa ");
                Intent intent = new Intent(this, SpaActivity.class);
                startActivity(intent);


                break;


            }
            case ("Enfants"):{
                Log.d("test de tagp1 "," je suis eng ");
                Intent intent = new Intent(this, EnfantActivity.class);
                startActivity(intent);


                break;


            }
            case ("Activités"):{
                Log.d("test de tagp1 "," je suis activ ");
                Intent intent = new Intent(this, ActiviteActivity.class);
                startActivity(intent);

                break;


            }






            default:
                Log.d("test de tagp2 ","  "+slideMenuItem.getName());
                return replaceFragment(screenShotable, position);
        }
        return screenShotable; }


    public void disableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(false);

    }


    public void enableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout.closeDrawers();

    }


    public void addViewToContainer(View view) {
        linearLayout.addView(view);
    }

    //table
    private void setupViewPager(ViewPager viewPager) {
        HomeActivity.ViewPagerAdapter adapter = new HomeActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentHome(),"Home Page");

        viewPager.setAdapter(adapter);
    }



    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);


        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }




    }

    public void clickEvent(View view) {
        switch (view.getId()) {
            case R.id.linMain:
                if (view.getTag() != null) {
                    int poisition = Integer.parseInt(view.getTag().toString());
                    Toast.makeText(getApplicationContext(), "Poistion: " + poisition, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


}

package yalantis.com.sidemenu.sample;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import tools.CallWebService;
import tools.MenuPrincipale;
import tools.Menus;
import yalantis.com.sidemenu.interfaces.Resourceble;
import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.model.SlideMenuItem;
import yalantis.com.sidemenu.sample.fragment.ContentFragment;
import yalantis.com.sidemenu.util.ViewAnimator;

import static tools.CallWebService.CallMazaganWebServicePincipale;


public class RestaurationActivity extends AppCompatActivity implements ViewAnimator.ViewAnimatorListener {


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
    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView14;
    TextView textView15;
    TextView textView16;
    TextView textView17;

    FloatingActionButton button1;
    FragmentManager fm = getSupportFragmentManager();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restauration);





        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager (viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        //fin

        //menuu itemm
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


        // create table


        Log.d("My fm",""+fm);



        button1 = (FloatingActionButton) findViewById(R.id.fab);

        Log.d("My Button",""+button1);

        if (button1 != null ) {
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    final ArrayList<MenuPrincipale> l = new ArrayList<MenuPrincipale>(CallMazaganWebServicePincipale("Restauration"));

                    final ArrayList<Menus>lS =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("MarketPlace"));
                    final ArrayList<Menus>l1 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("Morjana"));

                    final ArrayList<Menus>l2 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("Jin-Ja"));

                    final ArrayList<Menus>l3 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("AlFirma"));

                    final ArrayList<Menus>l4 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("SeldeMer"));

                    final ArrayList<Menus>l5 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("LaCave"));

                    final ArrayList<Menus>l6 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("Chiringuito"));

                    final ArrayList<Menus>l7 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("BeachBarbecue"));

                    final ArrayList<Menus>l8 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("Pizzeria"));

                    final ArrayList<Menus>l9 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("ClubHouse"));

                    final ArrayList<Menus>l10 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("Oasis"));

                    final ArrayList<Menus>l11 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("TuttiFrutti"));

                    final ArrayList<Menus>l12 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("JockeyClub"));

                    final ArrayList<Menus>l13 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("Atrium"));

                    final ArrayList<Menus>l14 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("Alias"));

                    final ArrayList<Menus>l15 =new ArrayList<Menus>( CallWebService.CallMazaganWebSousMenu("Olives"));





                    Log.d("list", "" + l.get(0).getDescription());


                    final Dialog mDialog;
                    mDialog = new Dialog(RestaurationActivity.this);
                    mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    mDialog.setContentView(R.layout.dialog_restauration);
                    textView = (TextView) mDialog.findViewById(R.id.content);

                    textView1 = (TextView) mDialog.findViewById(R.id.dialogtitle);

                    //item restauration

                    textView2 = (TextView) mDialog.findViewById(R.id.cont2);

                    textView3 = (TextView) mDialog.findViewById(R.id.cont3);
                    textView4 = (TextView) mDialog.findViewById(R.id.cont4);

                    textView5 = (TextView) mDialog.findViewById(R.id.cont6);
                    textView6= (TextView) mDialog.findViewById(R.id.cont7);

                    textView7 = (TextView) mDialog.findViewById(R.id.cont8);
                    textView8= (TextView) mDialog.findViewById(R.id.cont9);

                    textView9 = (TextView) mDialog.findViewById(R.id.cont13);
                    textView10 = (TextView) mDialog.findViewById(R.id.cont14);

                    textView11 = (TextView) mDialog.findViewById(R.id.cont15);
                    textView12 = (TextView) mDialog.findViewById(R.id.cont16);

                    textView13 = (TextView) mDialog.findViewById(R.id.cont17);
                    textView14 = (TextView) mDialog.findViewById(R.id.cont18);

                    textView15 = (TextView) mDialog.findViewById(R.id.cont19);
                    textView16 = (TextView) mDialog.findViewById(R.id.cont20);

                    textView17 = (TextView) mDialog.findViewById(R.id.cont21);




                    TextView ok = (TextView) mDialog.findViewById(R.id.dialogyes);
                    Log.d("ok", "fjv" + ok);
                    textView1.setText("Restauration");
                    textView.setText(l.get(0).getDescription());


                    //item restauration


                    textView2.setText(lS.get(0).getDescription());

                    textView3.setText(l1.get(0).getDescription());
                    textView4.setText(l2.get(0).getDescription());
                    textView5.setText(l3.get(0).getDescription());
                    textView6.setText(l4.get(0).getDescription());

                    textView7.setText(l5.get(0).getDescription());
                    textView8.setText(l6.get(0).getDescription());

                    textView9.setText(l7.get(0).getDescription());
                    textView10.setText(l8.get(0).getDescription());

                    textView11.setText(l9.get(0).getDescription());
                    textView12.setText(l10.get(0).getDescription());

                    textView13.setText(l11.get(0).getDescription());
                    textView14.setText(l12.get(0).getDescription());

                    textView15.setText(l13.get(0).getDescription());
                    textView16.setText(l14.get(0).getDescription());

                    textView17.setText(l15.get(0).getDescription());




                    ok.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {


                            mDialog.cancel();

                        }
                    });
                    ok.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            //Log.println(Log.ASSERT, "My logoooo","tichaaaa");


                            mDialog.dismiss();
                        }
                    });
                    mDialog.show();

                }
            });


        }}



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
                Log.d("test de tagp1 "," je suis Home ");
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

        RestaurationActivity.ViewPagerAdapter adapter = new RestaurationActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RestaurationFragment(),getResources().getString(R.string.four));

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




}

package carouseleffect;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import yalantis.com.sidemenu.sample.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpagerTop, viewPagerBackground;
    public static final int ADAPTER_TYPE_TOP = 1;
    public static final int ADAPTER_TYPE_BOTTOM = 2;

    private int[] listItems = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setupViewPager();
    }

    /**
     * Initialize all required variables
     */
    private void init() {
        viewpagerTop = (ViewPager) findViewById(R.id.viewpagerTop);
        viewPagerBackground = (ViewPager) findViewById(R.id.viewPagerbackground);

        viewpagerTop.setClipChildren(false);
        viewpagerTop.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.pager_margin));
        viewpagerTop.setOffscreenPageLimit(3);
        viewpagerTop.setPageTransformer(false, new CarouselEffectTransformer(this)); // Set transformer
    }

    /**
     * Setup viewpager and it's events
     */
    private void setupViewPager() {
        // Set Top ViewPager Adapter
        MyPagerAdapter adapter = new MyPagerAdapter(this, listItems, ADAPTER_TYPE_TOP);
        viewpagerTop.setAdapter(adapter);

        // Set Background ViewPager Adapter
        MyPagerAdapter adapterBackground = new MyPagerAdapter(this, listItems, ADAPTER_TYPE_BOTTOM);
        viewPagerBackground.setAdapter(adapterBackground);


        viewpagerTop.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int index = 0;

            @Override
            public void onPageSelected(int position) {
                index = position;

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int width = viewPagerBackground.getWidth();
                viewPagerBackground.scrollTo((int) (width * position + width * positionOffset), 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    viewPagerBackground.setCurrentItem(index);
                }

            }
        });
    }

    /**
     * Handle all click event of activity
     */
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

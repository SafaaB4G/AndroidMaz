package yalantis.com.sidemenu.sample;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class SplachScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i=new Intent(SplachScreen.this,HomeActivity.class);
                startActivity(i);
                finish();


            }
        },SPLASH_TIME_OUT);





    }
}
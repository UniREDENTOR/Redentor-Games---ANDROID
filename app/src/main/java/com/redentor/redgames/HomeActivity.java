package com.redentor.redgames;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.redentor.redgames.fragment.EquipesFragment;
import com.redentor.redgames.fragment.GamesFragment;
import com.redentor.redgames.fragment.PhotoFragment;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {


                case R.id.navigation_home:

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PhotoFragment()).commit();
                    break;

                case R.id.navigation_dashboard:

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new GamesFragment()).commit();
                    break;

                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new EquipesFragment()).commit();
                    break;

            }


            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new PhotoFragment()).commit();
    }


}

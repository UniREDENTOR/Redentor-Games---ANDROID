package com.redentor.redgames;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.redentor.redgames.fragment.EquipesFragment;
import com.redentor.redgames.fragment.GamesFragment;
import com.redentor.redgames.fragment.PhotoFragment;
import com.redentor.redgames.fragment.RankFragment;
import com.redentor.redgames.fragment.VoteFragment;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Toolbar toolbar;
    private TextView txtToolbar;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {


                case R.id.navigation_home:

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PhotoFragment()).commit();
                    txtToolbar.setText("Redentor Games 2018");

                    break;

                case R.id.navigation_dashboard:

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new GamesFragment()).commit();
                    txtToolbar.setText("Programação");
                    break;

                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new EquipesFragment()).commit();
                    txtToolbar.setText("Equipes");
                    break;
                case R.id.navigation_ranking:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,new RankFragment()).commit();
                    txtToolbar.setText("Ranking");
                    break;
                case R.id.navigation_vote:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,new VoteFragment()).commit();
                    txtToolbar.setText("Vote");
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
        txtToolbar = findViewById(R.id.txtToolbar);

        txtToolbar.setText("Redentor Games 2018");

        toolbar = findViewById(R.id.toolbar);




    }


}

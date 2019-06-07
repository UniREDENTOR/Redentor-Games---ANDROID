package com.redentor.redgames;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.redentor.redgames.fragment.EquipesFragment;
import com.redentor.redgames.fragment.GamesFragment;
import com.redentor.redgames.fragment.PhotoFragment;
import com.redentor.redgames.fragment.RankFragment;
import com.redentor.redgames.fragment.VoteFragment;
import com.redentor.redgames.helper.Permissao;

public class HomeActivity extends AppCompatActivity {
    private TextView txtToolbar;
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.INTERNET

    };


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
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new PhotoFragment()).commit();
        txtToolbar = findViewById(R.id.txtToolbar);

        txtToolbar.setText("Redentor Games 2018");

        Permissao.validarPermissoes(permissoesNecessarias,this,1);






    }





}

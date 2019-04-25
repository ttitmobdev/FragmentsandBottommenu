package com.example.user.fragmentsandbottommenu;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.botId);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        loadFragment(ThreeFragment.newInstance());
    }
   private void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frId,fragment);
        fragmentTransaction.commit();
   }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.one:
                            loadFragment(OneFragment.newInstance());
                            break;
                        case R.id.two:
                            loadFragment(TwoFragment.newInstance());
                            break;
                        case R.id.three:
                            loadFragment(ThreeFragment.newInstance());
                            break;
                    }
                    return false;
                }
            };
}

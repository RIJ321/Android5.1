package com.example.android51;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android51.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirstFragment firstFragment = new FirstFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();
    private Dash_Fragment dashFragment = new Dash_Fragment();
    Fragment active = firstFragment;
    private FragmentManager fm = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener listener = item -> {
        switch (item.getItemId()) {
            case R.id.home_fr:
                fm.beginTransaction().hide(active).show(firstFragment).commit();
                active = firstFragment;
                return true;
            case R.id.dashboard_fr:
                fm.beginTransaction().hide(active).show(dashFragment).commit();
                active = dashFragment;
                return true;
            case R.id.notification_fr:
                fm.beginTransaction().hide(active).show(notificationFragment).commit();
                active = notificationFragment;
                return true;
        }
        return false;
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarIn);

        binding.btnNavi.setOnNavigationItemSelectedListener(listener);

        fm.beginTransaction().add(R.id.container2, notificationFragment, "notif")
                .hide(notificationFragment).commit();
        fm.beginTransaction().add(R.id.container2, dashFragment, "dash")
                .hide(dashFragment).commit();
        fm.beginTransaction().add(R.id.container2, firstFragment, "home")
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_fr, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings ) {
            startActivity(new Intent(MainActivity.this,SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void hide(){
        binding.btnNavi.setVisibility(View.GONE);
    }

    public void setVisible(){
        binding.btnNavi.setVisibility(View.VISIBLE);
    }

}
package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vk.api.sdk.VK;
import com.vk.api.sdk.auth.VKScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String, String> applications = new HashMap<String, String>(); // dictionary for tokens


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applications.put("vk", ""); // put keys for every app's token

        /*List list = new ArrayList<VKScope>();
        list.add(VKScope.WALL);
        list.add(VKScope.PHOTOS);

        VK.login(this, list);*/

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                    new NewsFragment()).commit();
        }

    }

    public void loginApp(View view) { // logging to other apps
        switch (view.getId()) {
            case R.id.buttonVk: // Vkontakte
                List list = new ArrayList<VKScope>();
                list.add(VKScope.WALL);
                list.add(VKScope.PHOTOS);
                list.add(VKScope.MESSAGES);

                VK.login(this, list);


                break;
            case R.id.buttonFacebook: // Facebook
                Toast.makeText(this, "Вы вошли в FaceBook", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonOk: // Odnoclassniki
                Toast.makeText(this, "Вы вошли в Ok", Toast.LENGTH_LONG).show();
        }
    }

    public void clickMyApps(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                new AppsFragment()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    // lower block for fragment navigation
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_news:
                            selectedFragment = new NewsFragment();
                            break;
                        case R.id.nav_messages:
                            selectedFragment = new MessagesFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                            selectedFragment).commit();

                    return true;
                }
            };
}

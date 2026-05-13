package com.example.gopath;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPagerAdapter.addTab(new Tab(new Category(1,"All Paths",R.drawable.baseline_explore_24),new Path()));
        viewPagerAdapter.addTab(new Tab(new Category(2,"Map",R.drawable.baseline_map_24),new Map()));
        viewPagerAdapter.addTab(new Tab(new Category(3,"Favorite",R.drawable.baseline_favorite_24),new Favorite()));
        viewPagerAdapter.addTab(new Tab(new Category(4,"Notifications",R.drawable.baseline_notifications_24),new Notifications()));
        viewPagerAdapter.addTab(new Tab(new Category(5,"Profile",R.drawable.baseline_account_circle_24),new Profile()));

        viewPager.setAdapter(viewPagerAdapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                ViewPagerAdapter adapter = (ViewPagerAdapter) viewPager.getAdapter();
                if( adapter != null )
                    adapter.setTab(tab,i);
            }
        });
        tabLayoutMediator.attach();




        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().setAlpha(0.5f);
                Toast.makeText(MainActivity.this,tab.getText()+" Selected ",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().setAlpha(1f);

                Toast.makeText(MainActivity.this,tab.getText()+" UnSelected",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this,tab.getText()+" Released ",Toast.LENGTH_LONG).show();

            }
        });

    }
}
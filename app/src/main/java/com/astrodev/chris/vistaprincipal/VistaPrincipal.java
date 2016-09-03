package com.astrodev.chris.vistaprincipal;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VistaPrincipal extends AppCompatActivity {

    public CollapsingToolbarLayout collapsingToolbarLayout;
    public static Toolbar toolbar;
    public ViewPager viewPager;
    public TabLayout tablayout;

    public static VistaPrincipal vp;

    public int iconos[] = {
            R.mipmap.ic_local_cafe_white_24dp,
            R.mipmap.ic_restaurant_white_24dp,
            R.mipmap.ic_favorite_white_24dp,
            R.mipmap.ic_location_on_white_24dp,
            R.mipmap.ic_call_white_24dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_colapsing);

        viewPager = (ViewPager) findViewById(R.id.viewPager_principal);
        ponViewPager(viewPager);

        tablayout = (TabLayout) findViewById(R.id.tablayout_principal);
        tablayout.setupWithViewPager(viewPager);

        iconosTabs();

        collapsingToolbarLayout.setTitleEnabled(true);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                    switch (tab.getPosition()) {
                        case 0:
                            getSupportActionBar().setTitle("Cafés");
                            Toast.makeText(getApplicationContext(), "Fragment 1", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            getActionBar().setTitle("Restaurantes");
                            Toast.makeText(getApplicationContext(), "Fragment 2", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            toolbar.setTitle("Favoritos");
                            Toast.makeText(getApplicationContext(), "Fragment 3", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            toolbar.setTitle("Ubicación");
                            Toast.makeText(getApplicationContext(), "Fragment 4", Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            toolbar.setTitle("Contáctanos");
                            break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
            setActionbarTitulo("Cafés");
    }



    class adaptadorViewPager extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public adaptadorViewPager(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            return mFragmentList.get(position);
        }


        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return mFragmentTitleList.get(position);
            return null;
        }

        public void addFragment(Fragment fragment, String titulo) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(titulo);

        }
    }

    private void ponViewPager(ViewPager viewPager) {
        adaptadorViewPager adaptador = new adaptadorViewPager(getSupportFragmentManager());
        adaptador.addFragment(new FragmentUno(), "Lugares");
        adaptador.addFragment(new FragmentDos(), "Productos");
        adaptador.addFragment(new FragmentTres(), "Novedades");
        adaptador.addFragment(new FragmentCuatro(), "Eventos");
        adaptador.addFragment(new FragmentCinco(), "Promos");
        viewPager.setAdapter(adaptador);

    }

    public void setActionbarTitulo(String titulo) {
        toolbar.setTitle(titulo);
    }

    public void iconosTabs() {
        tablayout.getTabAt(0).setIcon(iconos[0]);
        tablayout.getTabAt(1).setIcon(iconos[1]);
        tablayout.getTabAt(2).setIcon(iconos[2]);
        tablayout.getTabAt(3).setIcon(iconos[3]);
        tablayout.getTabAt(4).setIcon(iconos[4]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vista_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

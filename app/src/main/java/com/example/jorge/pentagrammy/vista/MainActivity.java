package com.example.jorge.pentagrammy.vista;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.adaptadores.Pager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_EXTRA_NAME = "name";
    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.barraSup);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Log.e("MainActivity", "onCreate");
        setUpViewPager();


    }


    @Override
    public void onResume() {
        super.onResume();
        Fragment fragment = ((Pager) viewPager.getAdapter()).getFragment(1);
        if (fragment != null) {
            fragment.onResume();
        }
    }

    private void setUpViewPager(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PetsFragment());
        fragments.add(new PerfilFragment());

        viewPager.setAdapter(new Pager(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.hueso);
        tabLayout.getTabAt(1).setIcon(R.drawable.hueso2);
    }

    public void verFavoritos() {
        Toast.makeText(getApplicationContext(), "Ver los 5 favoritos!",
                Toast.LENGTH_LONG).show();
        Intent ventanaFav = new Intent(this, FavoritosActivity.class);
        startActivity(ventanaFav);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavoritos:
                verFavoritos();
                break;
            case R.id.mContacto:
                Intent ventanaContacto = new Intent(this, ContactoActivity.class);
                startActivity(ventanaContacto);
                break;
            case R.id.mAcerca:
                Intent ventanaAcerca = new Intent(this, AcercaActivity.class);
                startActivity(ventanaAcerca);
                break;
            case R.id.mNotificaciones:
                Intent ventanaNotificaciones = new Intent(this, Notificaciones.class);
                startActivity(ventanaNotificaciones);

                break;

            case R.id.mPerfil:
                Intent ventanaPerfil = new Intent(this, ConfigPerfilActivity.class);
                startActivity(ventanaPerfil);
                break;
        }
        return true;
    }
}

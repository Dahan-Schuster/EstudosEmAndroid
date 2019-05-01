package com.example.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.navigationdrawer.fragment.CameraFragment;
import com.example.navigationdrawer.fragment.CompartilharFragment;
import com.example.navigationdrawer.fragment.EnviarFragment;
import com.example.navigationdrawer.fragment.FerramentasFragment;
import com.example.navigationdrawer.fragment.GaleriaFragment;
import com.example.navigationdrawer.fragment.ImportFragment;
import com.example.navigationdrawer.fragment.PerfilFragment;
import com.example.navigationdrawer.fragment.SlidesFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FrameLayout frameLayout;

    private PerfilFragment perfilFragment;
    private ImportFragment importFragment;
    private CameraFragment cameraFragment;
    private GaleriaFragment galeriaFragment;
    private SlidesFragment slidesFragment;
    private FerramentasFragment ferramentasFragment;
    private CompartilharFragment compartilharFragment;
    private EnviarFragment enviarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "FAB pressionado", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Okay, sir!", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // ação
                            }
                        }).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        frameLayout = findViewById(R.id.conteiner);

        perfilFragment = new PerfilFragment();
        abrirFragment(perfilFragment);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            importFragment = new ImportFragment();
            abrirFragment(importFragment);

        } else if (id == R.id.nav_new) {
            cameraFragment = new CameraFragment();
            abrirFragment(cameraFragment);

        } else if (id == R.id.nav_gallery) {
            galeriaFragment = new GaleriaFragment();
            abrirFragment(galeriaFragment);

        } else if (id == R.id.nav_slideshow) {
            slidesFragment = new SlidesFragment();
            abrirFragment(slidesFragment);

        } else if (id == R.id.nav_tools) {
            ferramentasFragment = new FerramentasFragment();
            abrirFragment(ferramentasFragment);

        } else if (id == R.id.nav_share) {
            compartilharFragment = new CompartilharFragment();
            abrirFragment(compartilharFragment);

        } else if (id == R.id.nav_send) {
            enviarFragment = new EnviarFragment();
            abrirFragment(enviarFragment);
        }


        fecharNavigationDrawer();
        return true;
    }

    private void fecharNavigationDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void abrirFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, fragment);
        transaction.commit();
    }

    public void telaPerfil(View view) {
        abrirFragment(perfilFragment);
        fecharNavigationDrawer();
    }
}

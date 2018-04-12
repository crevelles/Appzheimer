package com.appzheimer.uem.appzheimer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class EnfermedadActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Button btnEnfermedad, btnCuadroClinico;
    private TextView textoEnfermedad, textoIntroEnfermedad, textoCuadroClinico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfermedad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.GRAY);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        btnEnfermedad = findViewById(R.id.idBtnEnfermedad);
        btnCuadroClinico = findViewById(R.id.idBtnCuadroClinico);

        textoEnfermedad = findViewById(R.id.idTextoEnfermedad);
        textoIntroEnfermedad = findViewById(R.id.idTextoIntroEnfermedad);
        textoCuadroClinico = findViewById(R.id.idTextoCuadroClinico);



        btnEnfermedad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textoEnfermedad.getVisibility() == View.GONE || textoEnfermedad.getVisibility()
                        == View.INVISIBLE ) {
                    btnEnfermedad.setText("Ocultar");
                    textoEnfermedad.setVisibility(View.VISIBLE );
                    textoIntroEnfermedad.setVisibility(View.VISIBLE );
                } else {
                    btnEnfermedad.setText("La enfermedad");
                    textoEnfermedad.setVisibility(View.GONE);
                    textoIntroEnfermedad.setVisibility(View.GONE);
            }
            }
        });


        btnCuadroClinico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textoCuadroClinico.getVisibility() == View.GONE || textoEnfermedad.getVisibility()
                        == View.INVISIBLE ) {
                    btnCuadroClinico.setText("Ocultar");
                    textoCuadroClinico.setVisibility(View.VISIBLE );
                } else {
                    btnCuadroClinico.setText("Cuadro Clinico");
                    textoCuadroClinico.setVisibility(View.GONE);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.enfermedad, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.info_legal) {
            mensaInfoLegal();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void mensaInfoLegal(){
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setIcon(R.drawable.ley);
        alertDialog.setTitle("Info legal");
        alertDialog.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        alertDialog.show();
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.icono_inicio) {
            Intent intent = new Intent(this, InicioActivity.class);
            startActivity(intent);
        } else if (id == R.id.icono_enfermedad) {
            Intent intent = new Intent(this, EnfermedadActivity.class);
            startActivity(intent);
        } else if (id == R.id.icono_test) {
            Intent intent = new Intent(this, EvaluacionActivity.class);
            startActivity(intent);
        } else if (id == R.id.icono_dieta) {
            Intent intent = new Intent(this, DietaActivity.class);
            startActivity(intent);
        } else if (id == R.id.icono_ejercicio) {
            Intent intent = new Intent(this, EjercicioActivity.class);
            startActivity(intent);
        } else if (id == R.id.icono_prevencion) {
            Intent intent = new Intent(this, PrevencionActivity.class);
            startActivity(intent);
        } else if (id == R.id.icono_ayuda) {
            Intent intent = new Intent(this, AyudaActivity.class);
            startActivity(intent);
        } else if (id == R.id.icono_contacto) {
            Intent intent = new Intent(this, ContactoActivity.class);
            startActivity(intent);
        } else if (id == R.id.icono_somos) {
            Intent intent = new Intent(this, QuienesSomosActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

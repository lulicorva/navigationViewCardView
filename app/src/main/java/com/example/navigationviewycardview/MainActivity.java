package com.example.navigationviewycardview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    //creo los objetos para mis IDs
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private CardView navigationViewCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creo los findViewById
        drawerLayout = findViewById(R.id.drawerLayoutMain);
        navigationView = findViewById(R.id.navigationViewMain);

        //Este find no funciona sin hacer lo siguiente ya que el id navHeaderCardView se encuentra en el navigation_header.xml
        // y en el onCreate figura como layout el activity_main PERO el NavigationViewCardView se encuentra
        navigationViewCardView = navigationView.getHeaderView(0).findViewById(R.id.navHeaderCardView);

        //Hago unicamente un SetNavigation (EQUIVALE AL SetOnClick) para el NavigationView, no para cada boton del mismo
        // la funcion recibe al ITEM del menu que hicimos en el xml de clase MenuItem
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //creo If para identificar que boton se apreto y para que me direccione al lugar que la persona desea
                //pero esto me generaria por cada item un anidado de IFs, que no es lo mejor

                //if(item.getItemId() == R.id.itemInicio)

                //entonces creo un SWITCH, llamo al item y le geteo el ID entonces compara el Id del Item y en CASO que el ID
                //coincida con el case efectuara la accion indicada bajo cada case y si no llegara hasta el DEFAULT

                switch (item.getItemId()) {
                    case R.id.itemInicio:
                        Toast.makeText(MainActivity.this, "Le diste a inicio", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.itemMiPerfil:
                        Toast.makeText(MainActivity.this, "Le diste a mi perfil", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.itemFavoritos:
                        Toast.makeText(MainActivity.this, "Le diste a favs", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "En construccion, lo siento amigo", Toast.LENGTH_SHORT).show();
                        break;
                }
                //para que el NavigationView se cierre una vez que hacemos clic en un item, le decimos el DrawerLayout que cierre el Navigation
                drawerLayout.closeDrawers();
                return false;
            }
        });

        //SetOnClick del CardView para cambiar imagen
        navigationViewCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cambiamos foto de perfil!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

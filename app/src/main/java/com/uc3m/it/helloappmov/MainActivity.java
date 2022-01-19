package com.uc3m.it.helloappmov;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //  Metodo que procesa la pulsacion (onClick) del boton
    //  se indica en el atributo "android:onClick" del elemento Button definido en XML
    public void sendName(View view) {
        // Creamos el Intent que va a lanzar la segunda activity (SecondActivity)
        Intent intent = new Intent(this, SecondActivity.class);
        // Obtenemos referencias a los elementos del interfaz grafico
        EditText nameText = (EditText) findViewById(R.id.edit_message);
        Button okButton = (Button) findViewById(R.id.button_ok);

        // Creamos la informacion a pasar entre actividades
        Bundle b = new Bundle();
        b.putString("NAME", nameText.getText().toString());

        // Asociamos esta informacion al intent
        intent.putExtras(b);

        // Iniciamos la nueva actividad
        startActivity(intent);
    }

    // Método que permite mostrar el menu definido como recurso externo en res/menu/menu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Se recrea el menu que aparece en AppBar de la actividad.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Método que permite responder a la selección de opciones del menú
    // En esta versión escribe mensajes en LogCat
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Se obtiene el identificador del item que ha sido seleccionado
        int id = item.getItemId();

        // Se comprueba cuál de las dos posibles opciones es, settings o about
        if (id == R.id.action_settings) {
            System.out.println("APPMOV: Settings action en actividad MainActivity...");
            return true;
        }

        if (id == R.id.action_about) {
            System.out.println("APPMOV: About action en actividad MainActivity...");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

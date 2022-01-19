package com.uc3m.it.helloappmov;

import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Obtener referencia al TextView que visualizara el saludo
        TextView text_hello = (TextView)findViewById(R.id.text_hello_name);

        // Recuperamos la informacion pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        // Construimos el saludo a partir del nombre que le pasa la actividad principal
        Resources res = getResources();
        String text = String.format(res.getString(R.string.hello), bundle.getString("NAME"));
        text_hello.setText(text);
    }

    // Método que permite mostrar el menu definido como recurso externo en res/menu/menu_main.xml
    // podría ser distinto al de la anterior actividad, en este ejemplo es el mismo.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
            System.out.println("APPMOV: Settings action en actividad SecondActivity...");
            return true;
        }

        if (id == R.id.action_about) {
            System.out.println("APPMOV: About action en actividad SecondActivity...");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

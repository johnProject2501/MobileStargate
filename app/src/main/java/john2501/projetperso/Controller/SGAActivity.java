package john2501.projetperso.Controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import john2501.projetperso.R;

public class SGAActivity extends AppCompatActivity implements View.OnClickListener {
    private Button SGA_11,SGA_12,SGA_13,SGA_14,SGA_15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sga);


        SGA_11 = (Button) findViewById(R.id.SGA_1);
        SGA_12 = (Button) findViewById(R.id.SGA_2);
        SGA_13 = (Button) findViewById(R.id.SGA_3);
        SGA_14 = (Button) findViewById(R.id.SGA_4);
        SGA_15 = (Button) findViewById(R.id.SGA_5);


        SGA_11.setOnClickListener(this);
        SGA_12.setOnClickListener(this);
        SGA_13.setOnClickListener(this);
        SGA_14.setOnClickListener(this);
        SGA_15.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == SGA_11){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 11);
            startActivity(intent);
        }

        if (v == SGA_12){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 12);
            startActivity(intent);
        }

        if (v == SGA_13){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 13);
            startActivity(intent);
        }

        if (v == SGA_14){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 14);
            startActivity(intent);
        }

        if (v == SGA_15){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 15);
            startActivity(intent);
        }
    }

    //Crée et Remplir le menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Acceuil");
        menu.add(0, 2, 0, "SG1");
        menu.add(0,3,0,"SGA");
        menu.add(0,4,0,"SGU");
        menu.add(0,5,0,"Films");

        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, SG1Activity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, SGAActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, SGUActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, SGFilm.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

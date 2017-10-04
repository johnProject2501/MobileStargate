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

public class SG1Activity extends AppCompatActivity implements View.OnClickListener {


    private Button SG1_1,SG1_2,SG1_3,SG1_4,SG1_5,SG1_6,SG1_7,SG1_8,SG1_9,SG1_10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sg1);

        SG1_1 = (Button) findViewById(R.id.SG1_1);
        SG1_2 = (Button) findViewById(R.id.SG1_2);
        SG1_3 = (Button) findViewById(R.id.SG1_3);
        SG1_4 = (Button) findViewById(R.id.SG1_4);
        SG1_5 = (Button) findViewById(R.id.SG1_5);
        SG1_6 = (Button) findViewById(R.id.SG1_6);
        SG1_7 = (Button) findViewById(R.id.SG1_7);
        SG1_8 = (Button) findViewById(R.id.SG1_8);
        SG1_9 = (Button) findViewById(R.id.SG1_9);
        SG1_10 = (Button) findViewById(R.id.SG1_10);


        SG1_1.setOnClickListener(this);
        SG1_2.setOnClickListener(this);
        SG1_3.setOnClickListener(this);
        SG1_4.setOnClickListener(this);
        SG1_5.setOnClickListener(this);
        SG1_6.setOnClickListener(this);
        SG1_7.setOnClickListener(this);
        SG1_8.setOnClickListener(this);
        SG1_9.setOnClickListener(this);
        SG1_10.setOnClickListener(this);



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

    @Override
    public void onClick(View v) {

        if (v == SG1_1){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 1);
            startActivity(intent);
        }

        if (v == SG1_2){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 2);
            startActivity(intent);
        }

        if (v == SG1_3){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 3);
            startActivity(intent);
        }

        if (v == SG1_4){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 4);
            startActivity(intent);
        }

        if (v == SG1_5){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 5);
            startActivity(intent);
        }

        if (v == SG1_6){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 6);
            startActivity(intent);
        }

        if (v == SG1_7){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 7);
            startActivity(intent);
        }

        if (v == SG1_8){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 8);
            startActivity(intent);
        }

        if (v == SG1_9){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 9);
            startActivity(intent);
        }

        if (v == SG1_10){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 10);
            startActivity(intent);
        }

    }



}

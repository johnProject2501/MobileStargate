package john2501.projetperso.Controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import john2501.projetperso.R;

public class SGFilm extends AppCompatActivity implements View.OnClickListener {

    private ImageView SGFilm1;
    private ImageView SGFilm2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgfilm);
        SGFilm1= (ImageView) findViewById(R.id.iv_Arche);
        SGFilm2= (ImageView) findViewById(R.id.iv_Continuum);


        SGFilm1.setOnClickListener(this);
        SGFilm2.setOnClickListener(this);

    }













    @Override
    public void onClick(View v) {
        if (v== SGFilm1){
            Intent intent = new Intent(this, FilmDetail.class);
            intent.putExtra("EXTRA_MESSAGE", 35);
            startActivity(intent);
        }

        if (v== SGFilm2){
            Intent intent = new Intent(this, FilmDetail.class);
            intent.putExtra("EXTRA_MESSAGE", 36);
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

package john2501.projetperso.Controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import john2501.projetperso.R;
import john2501.projetperso.model.beans.Episode;
import john2501.projetperso.model.webervice.OpenDataWS;

public class FilmDetail extends AppCompatActivity {
    //Données
    private TextView titre;
    private TextView description;
    private ImageView image;

    private Integer film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        film = getIntent().getIntExtra("EXTRA_MESSAGE", 1);

        image= (ImageView) findViewById(R.id.iv_FilmDescription);

        titre= (TextView) findViewById(R.id.tv_TitreFilm);

        description= (TextView) findViewById(R.id.tv_FilmDescription);




        try {
            MonAT MonAT = new MonAT();

            MonAT.execute();


        } catch (Exception e) {
            e.printStackTrace();

        }

    }




    public class MonAT extends AsyncTask {

        private Episode resultat = null;
        private Exception exeption = null;

        @Override
        protected Object doInBackground(Object[] objects) {

            try {
                resultat = OpenDataWS.getFieldsfilm(film);
            } catch (Exception e) {
                exeption = e;

            }
            return resultat;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (exeption != null) {
                exeption.printStackTrace();


            } else {
                Episode episode= (Episode) o;

                description.setText(episode.getResumerLong());

                String img="http://jonathan-bury-reste.fr/Symfony/SynfoStargate/web/"+episode.getPhoto()  ;

                Glide.with(image.getContext()).load(img).into(image);

            }
        }
    }

    //Crée et Remplir le menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Acceuil");
        menu.add(0, 2, 0, "SG1");
        menu.add(0 ,3, 0,"SGA");
        menu.add(0 ,4, 0,"SGU");
        menu.add(0 ,5, 0,"Films");

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

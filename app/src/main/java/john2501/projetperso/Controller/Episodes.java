package john2501.projetperso.Controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import john2501.projetperso.R;
import john2501.projetperso.model.beans.Episode;
import john2501.projetperso.model.webervice.OpenDataWS;
import john2501.projetperso.view.EpisodesAdapter;


public class Episodes extends AppCompatActivity implements EpisodesAdapter.OnFieldsListener, View.OnClickListener {




    private RecyclerView rv2;

    //Données
    private ArrayList<Episode> field2;

    //outils
    private EpisodesAdapter fieldAdapter2;



    private Integer nb_Saison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        nb_Saison= getIntent().getIntExtra("EXTRA_MESSAGE",1);




        rv2 = (RecyclerView) findViewById(R.id.rv2);

        field2 = new ArrayList<>();

        fieldAdapter2 = new EpisodesAdapter(field2, this);


        rv2.setLayoutManager(new LinearLayoutManager(this));

        rv2.setAdapter(fieldAdapter2);



        try {
            MonAT MonAT = new MonAT();

            MonAT.execute();


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onClick(Episode episode) {
        Intent intent = new Intent(this, DetailEpisodeActivity.class);

        intent.putExtra(DetailEpisodeActivity.FIELD_KEY2, episode);

        startActivity(intent);
    }


    public class MonAT extends AsyncTask {

        private ArrayList<Episode> resultat = null;
        private Exception exeption = null;

        @Override
        protected Object doInBackground(Object[] objects) {

            try {
                resultat = OpenDataWS.getFieldsEpisodes(nb_Saison);
            } catch (Exception e) {
                exeption = e;

            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (exeption != null) {
                exeption.printStackTrace();


            } else {
                field2.clear();
                field2.addAll(resultat);
                fieldAdapter2.notifyDataSetChanged();
            }
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

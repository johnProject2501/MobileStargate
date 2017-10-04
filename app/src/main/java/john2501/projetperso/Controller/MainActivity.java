package john2501.projetperso.Controller;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import john2501.projetperso.R;
import john2501.projetperso.model.beans.News;
import john2501.projetperso.model.webervice.OpenDataWS;
import john2501.projetperso.view.NewsAdapter;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnFieldsListener, View.OnClickListener {

    //composant graphique

    private RecyclerView rv;


    private Button SG1;
    private Button SGA;
    private Button SGU;
    private Button Film;


    //Données
    private ArrayList<News> field;

    //outils
    private NewsAdapter fieldAdapter;

    public static boolean isInternetConnexion(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isInternetConnexion(this)){
            SG1 = (Button) findViewById(R.id.button_SG1);
            SGA = (Button) findViewById(R.id.button_SGA);
            SGU = (Button) findViewById(R.id.button_SGU);
            Film= (Button) findViewById(R.id.button_film);

            rv = (RecyclerView) findViewById(R.id.rv);


            SG1.setOnClickListener(this);
            SGA.setOnClickListener(this);
            SGU.setOnClickListener(this);
            Film.setOnClickListener(this);

            field = new ArrayList<>();


            fieldAdapter = new NewsAdapter(field, this);

            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setAdapter(fieldAdapter);


            try {
                MonAT MonAT = new MonAT();

                MonAT.execute();


            } catch (Exception e) {
                e.printStackTrace();

            }

        }

        else {
            Toast.makeText(this, "Connection internet requise", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    public void onClick(View v) {
        if (v==SG1){
            Intent intent = new Intent(this, SG1Activity.class);

            startActivity(intent);
        }

        if (v==SGA){
            Intent intent = new Intent(this, SGAActivity.class);
            startActivity(intent);
        }

        if (v==SGU){
            Intent intent = new Intent(this, SGUActivity.class);
            startActivity(intent);
        }
        if (v==Film){
            Intent intent = new Intent(this, SGFilm.class);
            startActivity(intent);
        }
    }


    @Override
    public void onClick(News news) {

        Intent intent = new Intent(this, DetailNewsActivity.class);

        intent.putExtra(DetailNewsActivity.FIELD_KEY, news);

        startActivity(intent);
    }




    public class MonAT extends AsyncTask {

        private ArrayList<News> resultat = null;
        private Exception exeption = null;

        @Override
        protected Object doInBackground(Object[] objects) {

            try {
                resultat = OpenDataWS.getFieldsDuServeur();
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
                field.clear();
                field.addAll(resultat);
                fieldAdapter.notifyDataSetChanged();
            }
        }
    }
}

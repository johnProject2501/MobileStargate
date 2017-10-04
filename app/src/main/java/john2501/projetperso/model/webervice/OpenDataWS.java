package john2501.projetperso.model.webervice;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import john2501.projetperso.model.beans.Episode;
import john2501.projetperso.model.beans.News;

/**
 * Created by john2501 on 11/06/2017.
 */

public class OpenDataWS {

    private static final String WS_URL = "http://jonathan-bury-reste.fr/Symfony/SynfoStargate/web/json/";
    private static final String WS_News = "News/Json";
    private static final String WS_Episode = "Episode/Json/";
    private static final String WS_Film = "Film/Json/";


    private static Gson gson = new Gson();


    public static ArrayList<News> getFieldsDuServeur() throws Exception {
        //récuperation du json
        String reponseEnJson = OkHttpUtils.SendGetOkHttpRequest(WS_URL + WS_News);
        //Transformation du Json en liste D'objet
        ArrayList<News> listeNews = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<News>>() {
        }.getType());

        Log.v("TAG", reponseEnJson);

        return listeNews;
    }


    public static ArrayList<Episode> getFieldsEpisodes(int nb_saison) throws Exception {
        //récuperation du json
        String reponseEnJson = OkHttpUtils.SendGetOkHttpRequest(WS_URL + WS_Episode + nb_saison);
        //Transformation du Json en liste D'objet
        ArrayList<Episode> listeEpisode = gson.fromJson(reponseEnJson, new TypeToken<ArrayList<Episode>>() {
        }.getType());

        Log.v("TAG", reponseEnJson);

        return listeEpisode;
    }

    public static Episode getFieldsfilm(int film) throws Exception {
        //récuperation du json
        String reponseEnJson = OkHttpUtils.SendGetOkHttpRequest(WS_URL + WS_Film + film);
        //Transformation du Json en liste D'objet
        Episode listeEpisode = gson.fromJson(reponseEnJson , Episode.class);

        Log.v("TAG", reponseEnJson);

        return listeEpisode;
    }

}

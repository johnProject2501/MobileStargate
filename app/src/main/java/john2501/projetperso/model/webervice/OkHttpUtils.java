package john2501.projetperso.model.webervice;

import android.util.Log;

import java.net.HttpURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by john2501 on 11/06/2017.
 */

public class OkHttpUtils {

    public static String SendGetOkHttpRequest (String url) throws Exception{
        Log.v("TAG",url);
        OkHttpClient client=new OkHttpClient();
        Log.v("TAG","ok 1 ");
        //création de la requete
        Request request=new Request.Builder().url(url).build();
        Log.v("TAG","requete: "+request.toString());
        //Execution de la requete
        Response response= client.newCall(request).execute();
        Log.v("TAG", "reponse de la quete : "+String.valueOf(response));
        //analyse du code retour


        if (response.code() != HttpURLConnection.HTTP_OK){
            throw new Exception("Réponse du serveur inccorect "+ response.code());
        }
        else {
            //Resultat de la requete

            return response.body().string();
        }
    }

}

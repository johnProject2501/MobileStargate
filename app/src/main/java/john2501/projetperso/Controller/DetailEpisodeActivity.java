package john2501.projetperso.Controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import john2501.projetperso.R;
import john2501.projetperso.model.beans.Episode;

public class DetailEpisodeActivity extends AppCompatActivity {
    public final static String FIELD_KEY2 = "FIELD_KEY2";

    private TextView tv_titre;
    private TextView tv_detail;
    private ImageView IMG_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_episode);

        tv_titre = (TextView) findViewById(R.id.tv_titreEpisode);
        tv_detail = (TextView) findViewById(R.id.tv_DescriptionEpisode);
        IMG_View = (ImageView) findViewById(R.id.iv_DescriptionEpisode);

        Episode fields = (Episode) getIntent().getExtras().getSerializable(FIELD_KEY2);


        tv_titre.setText(fields.getTitre());
        tv_detail.setText(Html.fromHtml(fields.getResumerLong()));

        String img="http://jonathan-bury-reste.fr/Symfony/SynfoStargate/web/"+fields.getPhoto();

        Glide.with(IMG_View.getContext()).load(img).into(IMG_View);


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

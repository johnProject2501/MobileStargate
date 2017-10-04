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

public class SGUActivity extends AppCompatActivity implements View.OnClickListener {
    private Button SGU_16,SGU_17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgu);

        SGU_16 = (Button) findViewById(R.id.SGU_1);
        SGU_17 = (Button) findViewById(R.id.SGU_2);

        SGU_16.setOnClickListener(this);
        SGU_17.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == SGU_16){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 16);
            startActivity(intent);
        }

        if (v == SGU_17){
            Intent intent = new Intent(this, Episodes.class);
            intent.putExtra("EXTRA_MESSAGE", 17);
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

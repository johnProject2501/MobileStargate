package john2501.projetperso.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import john2501.projetperso.R;
import john2501.projetperso.model.beans.Episode;


/**
 * Created by john2501 on 31/08/2017.
 */

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.ViewHolder> {

    private ArrayList<Episode> fields;
    private OnFieldsListener studentListener;



    //Constructeur
    public EpisodesAdapter(ArrayList<Episode> fields, OnFieldsListener studentListener) {



        this.fields = fields;

        this.studentListener = studentListener;
    }




    protected class ViewHolder extends RecyclerView.ViewHolder {


        public TextView tv_titre;

        public ImageView LoadIMG;

        public View root;



        public ViewHolder(View itemView) {
            super(itemView);
            tv_titre = (TextView) itemView.findViewById(R.id.tv_titreEpisode);

            LoadIMG = (ImageView) itemView.findViewById(R.id.img_FileEpisode);

            root = itemView.findViewById(R.id.root2);

        }


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup vg, int viewType) {
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.ligne_episode, vg, false);

        return new EpisodesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //L'élève correspondant à la ligne
        final Episode field = fields.get(position);

            holder.tv_titre.setText(field.getTitre());



        String img="http://jonathan-bury-reste.fr/Symfony/SynfoStargate/web/"+field.getPhoto();

            Glide.with(holder.LoadIMG.getContext()).load(img).into(holder.LoadIMG);






            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (studentListener != null) {
                        studentListener.onClick(field);
                    }


                }
            });





    }

    @Override
    public int getItemCount() {

        return fields.size();
    }


    public interface OnFieldsListener {

        void onClick(Episode fields);
    }
}

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
import john2501.projetperso.model.beans.News;

/**
 * Created by john2501 on 30/08/2017.
 */


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


    private ArrayList<News> fields;
    private OnFieldsListener studentListener;

    //Constructeur
    public NewsAdapter(ArrayList<News> fields, OnFieldsListener studentListener) {

        this.fields = fields;

        this.studentListener = studentListener;
    }




    protected class ViewHolder extends RecyclerView.ViewHolder {

        
        public TextView tv_titre;

        public ImageView LoadIMG;

        public View root;



        public ViewHolder(View itemView) {
            super(itemView);
            tv_titre = (TextView) itemView.findViewById(R.id.tv_titre);
            LoadIMG = (ImageView) itemView.findViewById(R.id.img_File);
            root = itemView.findViewById(R.id.root);

        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup vg, int viewType) {
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.ligne_evenement, vg, false);
        return new NewsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //L'élève correspondant à la ligne
        final News field = fields.get(position);

        holder.tv_titre.setText(field.getTitre());

        String img="http://jonathan-bury-reste.fr/Symfony/SynfoStargate/web/img/news/"+field.getFile();

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
        void onClick(News  fields);
    }
}

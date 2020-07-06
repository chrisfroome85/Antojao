package adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.PictureDetailActivity;
import com.example.prueba.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.Picture;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList <Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        final Picture picture = pictures.get(position);
        holder.userNameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.puntuacionCard.setText(picture.getRatingNumber());
        Picasso.get().load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView userNameCard;
        private TextView timeCard;
        private TextView puntuacionCard;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            pictureCard    = (ImageView) itemView.findViewById(R.id.PictureCard);
            userNameCard   = (TextView) itemView.findViewById(R.id.UsernameCard);
            timeCard       = (TextView) itemView.findViewById(R.id.FirstWord);
            puntuacionCard = (TextView) itemView.findViewById(R.id.Rating);
        }
    }
}

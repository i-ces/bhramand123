package com.example.bhramand123.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bhramand123.R;
import com.example.bhramand123.models.Post;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesAdapterViewHolder> {
    private List<com.example.bhramand123.models.Post> mPosts;
    private FirebaseAuth mAuth;
    private FirebaseStorage mStorage;
    private String userID;
    private Context mContext;

    public PlacesAdapter(List<Post> posts, Context mContext) {
        this.mPosts= posts;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PlacesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.post_single_item,parent,false);
        return new PlacesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesAdapterViewHolder holder, int position) {
        final Post post=mPosts.get(position);
     Picasso.get().load(post.getImageUrl()).centerCrop().into(holder.placeImageContainer);
     holder.placeName.setText(post.getName());
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent postDetails= new Intent();
                 }
     });
    }

    @Override
    public int getItemCount() {
        return mPosts.size();

    }

    public class PlacesAdapterViewHolder extends RecyclerView.ViewHolder
    {
        private TextView placeName;
        private ImageView placeImageContainer;

        public PlacesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            placeName=itemView.findViewById(R.id.singlePostItem_title);
            placeImageContainer=itemView.findViewById(R.id.singlePostItem_Image);
//            locationTextView=itemView.findViewById(R.id.postDetails_place);
//            postDescriptionText=itemView.findViewById(R.id.postDetails_postDescription);
//            publisherFullName=itemView.findViewById(R.id.postDetails_publisherName);
//            placeImageContainer=itemView.findViewById(R.id.postDetails_image);
//            postTitle=itemView.findViewById(R.id.postDetails_postTitle);

        }
    }
}

package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.R;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Comment;
import io.swagger.client.model.KindergartenPost;


public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.MyViewHolder>
{

    Context mContext;
    List<KindergartenPost> mData;
    DefaultApi db = new DefaultApi();

    public PostRecyclerViewAdapter(Context mContext, List<KindergartenPost> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.group_post_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onViewAttachedToWindow(MyViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        final KindergartenPost item = holder.item;


        if (item != null && item.getPath() != null) {
            holder.getMapFragmentAndCallback(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    for(int i = 0; i < item.getPath().size(); i++) {
                        LatLng latLng = new LatLng(item.getPath().get(i).getX(), item.getPath().get(i).getY());
                        googleMap.addMarker(new MarkerOptions().position(latLng));
                        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                    }
                }
            });
        }
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

        if (holder.item != null && holder.item.getPath() != null) {
            // If error still occur unpredictably, it's best to remove fragment here
            // holder.removeMapFragment();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_name.setText(mData.get(position).getCreator().getName());

        if(mData.get(position).getImage() != null) {
            Picasso.get()
                    .load(mData.get(position).getImage().getPath())
                    .centerCrop()
                    .into(holder.iv_picture);
            holder.iv_picture.setVisibility(View.VISIBLE);
        } else
            holder.iv_picture.setVisibility(View.GONE);

        holder.tv_context.setText(mData.get(position).getContent());

        holder.mapLayout.setVisibility(View.GONE);

        if(mData.get(position).getPoll() != null) {
            holder.tv_question.setText(mData.get(position).getPoll().getQuestion());

            List<String> answers = mData.get(position).getPoll().getOptions();
            AnswerRecyclerViewAdapter recycleAnswersAdapter = new AnswerRecyclerViewAdapter(mContext, answers);
            holder.answer.setLayoutManager(new LinearLayoutManager(mContext));
            holder.answer.setAdapter(recycleAnswersAdapter);

            holder.tv_question.setVisibility(View.VISIBLE);
            holder.answer.setVisibility(View.VISIBLE);

        } else {
            holder.tv_question.setVisibility(View.GONE);
            holder.answer.setVisibility(View.GONE);
        }
        holder.btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    db.likePost(mData.get(position).getId());

                } catch (TimeoutException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        });

        int likesCount = mData.get(position).getLikes().size();
        holder.tv_likes.setText(mContext.getString(R.string.like_text, likesCount));

        String comment = "";
        if(holder.tietf_comment.getText() != null) {
            comment = holder.tietf_comment.getText().toString();
        }
        final String finalComment = comment;
        holder.btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!finalComment.equals("")) {
                    try {
                        db.commentOnPost(mData.get(position).getId(), finalComment);
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        List<Comment> comments = mData.get(position).getComments();
        CommentRecyclerViewAdapter recycleCommentAdapter = new CommentRecyclerViewAdapter(mContext, comments);
        holder.comment.setLayoutManager(new LinearLayoutManager(mContext));
        holder.comment.setAdapter(recycleCommentAdapter);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;
        private ImageView iv_picture;
        private TextView tv_context;
        private TextView tv_question;
        private Button btn_like;
        private TextView tv_likes;
        private TextInputEditText tietf_comment;
        private Button btn_send;
        private RecyclerView answer;
        private RecyclerView comment;

        public FrameLayout mapLayout;
        private SupportMapFragment mapFragment;

        private KindergartenPost item;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.user_name);
            iv_picture = (ImageView) itemView.findViewById(R.id.posted_image);
            tv_context = (TextView) itemView.findViewById(R.id.post_text);
            tv_question = (TextView) itemView.findViewById(R.id.question);
            tietf_comment = (TextInputEditText) itemView.findViewById(R.id.CommentTextInputEditText);
            btn_send = (Button) itemView.findViewById(R.id.sendBtn);
            btn_like = (Button) itemView.findViewById(R.id.LikeBtn);
            tv_likes = (TextView) itemView.findViewById(R.id.like_text);
            answer = (RecyclerView) itemView.findViewById(R.id.answersRecycleView);
            comment = (RecyclerView) itemView.findViewById(R.id.commentRecycleView);

            mapLayout = (FrameLayout) itemView.findViewById(R.id.map);
        }

        public SupportMapFragment getMapFragmentAndCallback(OnMapReadyCallback callback) {
            if (mapFragment == null) {
                mapFragment = SupportMapFragment.newInstance();
                mapFragment.getMapAsync(callback);
            }

            /*
            FragmentManager fragmentManager;
            fragmentManager.beginTransaction().replace(R.id.map, mapFragment).commit();
            */
            return mapFragment;
        }
    }
}
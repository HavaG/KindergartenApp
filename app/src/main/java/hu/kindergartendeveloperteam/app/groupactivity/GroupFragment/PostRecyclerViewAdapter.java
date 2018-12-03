package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.R;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.KindergartenPost;
import io.swagger.client.model.KindergartenUser;
import io.swagger.client.model.Post;
import io.swagger.client.model.KindergartenPost;


public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.MyViewHolder> {

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_name.setText(mData.get(position).getCreator().getName());
        Picasso.get()
                .load(mData.get(position).getImage().getPath())
                .resize(50, 50)
                .centerCrop()
                .into(holder.iv_picture);
        holder.tv_context.setText(mData.get(position).getContent());
        holder.tv_question.setText(mData.get(position).getPoll().getQuestion());
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
        holder.tv_likes.setText(mContext.getString(R.string.like_text, "" + likesCount));

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
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        //TODO: mivan ha maps activity?

        private TextView tv_name;
        private ImageView iv_picture;
        private TextView tv_context;
        private TextView tv_question;
        private Button btn_like;
        private TextView tv_likes;
        private TextInputEditText tietf_comment;
        private Button btn_send;
        private Fragment f_map;

        /*
        commentRecycleView
        answersRecycleView
        */

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
            //f_map = (Fragment) itemView.findViewById(R.id.map);

            /*
            answersRecycleView
            commentRecycleView
            */
        }
    }
}
package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.GroupActivity;
import hu.kindergartendeveloperteam.app.groupactivity.R;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.KindergartenChild;
import io.swagger.client.model.KindergartenPost;
import io.swagger.client.model.Post;

public class PostsFragment extends Fragment {

    private View v;
    private RecyclerView myRecycleView;
    private List<KindergartenPost> posts;
    private DefaultApi db = new DefaultApi();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int groupId = getArguments().getInt(GroupActivity.GROUP_ID);

        try {

            posts = db.getGroup(groupId).getPosts();

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
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            myRecycleView = (RecyclerView) v.findViewById(R.id.userRecycleView);
            PostRecyclerViewAdapter recycleAdapter = new PostRecyclerViewAdapter(getContext(),posts);
            myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
            myRecycleView.setAdapter(recycleAdapter);
            return v;
    }
}
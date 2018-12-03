package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.GroupActivity;
import hu.kindergartendeveloperteam.app.groupactivity.GroupChooseActivity;
import hu.kindergartendeveloperteam.app.groupactivity.R;
import hu.kindergartendeveloperteam.app.groupactivity.async.Async;
import hu.kindergartendeveloperteam.app.groupactivity.async.OnResult;
import hu.kindergartendeveloperteam.app.groupactivity.async.Task;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.KindergartenUser;

public class TeacherFragment extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    DefaultApi db = new DefaultApi();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.group_user_fragment, container, false);
        final boolean onlyMessage = getArguments().getBoolean(GroupChooseActivity.ONLY_MESSAGE, false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.userRecycleView);
        UserRecyclerViewAdapter recycleAdapter = new UserRecyclerViewAdapter(getContext(), new ArrayList<KindergartenUser>(), onlyMessage);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);


        final int groupId = getArguments().getInt(GroupActivity.GROUP_ID);

        (new Async<List<KindergartenUser>>()).execute(new Task<List<KindergartenUser>>() {
            @Override
            public List<KindergartenUser> work() {
                try {
                    return db.getGroup(groupId).getUsers();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                }

                return new ArrayList<KindergartenUser>();
            }
        }, new OnResult<List<KindergartenUser>>() {
            @Override
            public void onResult(List<KindergartenUser> data) {
                ((UserRecyclerViewAdapter)myRecycleView.getAdapter()).mData = data;
                ((UserRecyclerViewAdapter)myRecycleView.getAdapter()).notifyDataSetChanged();
            }
        });


        return v;
    }
}

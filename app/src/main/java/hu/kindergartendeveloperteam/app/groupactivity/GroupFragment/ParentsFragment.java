package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.os.Bundle;
import android.util.Log;
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
import hu.kindergartendeveloperteam.app.groupactivity.async.Async;
import hu.kindergartendeveloperteam.app.groupactivity.async.OnResult;
import hu.kindergartendeveloperteam.app.groupactivity.async.Task;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.KindergartenChild;
import io.swagger.client.model.KindergartenUser;

public class ParentsFragment extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    private List<KindergartenUser> Parents;
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
        myRecycleView = (RecyclerView) v.findViewById(R.id.userRecycleView);
        UserRecyclerViewAdapter recycleAdapter = new UserRecyclerViewAdapter(getContext(), new ArrayList<KindergartenUser>(), false); // todo
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);



        final int groupId = getArguments().getInt(GroupActivity.GROUP_ID);
        Log.d("gtoupID", "" + groupId);

        (new Async<List<KindergartenUser>>()).execute(new Task<List<KindergartenUser>>() {
            @Override
            public List<KindergartenUser> work() {
                List<KindergartenUser> Parents = new ArrayList<>();
                try {
                    List<KindergartenChild> allChildren = db.getGroup(groupId).getChildren();
                    for(int i = 0; i < allChildren.size(); i++){
                        KindergartenUser parent = db.getUser(allChildren.get(i).getParentId());
                        if(!Parents.contains(parent)) {
                            Parents.add(parent);
                        }
                    }

                } catch (TimeoutException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                }

                return Parents;
            }
        }, new OnResult<List<KindergartenUser>>() {
            @Override
            public void onResult(List<KindergartenUser> data) {
                Log.d("data is", data.toString());
                ((UserRecyclerViewAdapter)myRecycleView.getAdapter()).mData = data;
                ((UserRecyclerViewAdapter)myRecycleView.getAdapter()).notifyDataSetChanged();
            }
        });


        return v;
    }
}

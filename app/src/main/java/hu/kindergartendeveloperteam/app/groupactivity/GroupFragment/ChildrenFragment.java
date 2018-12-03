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
import hu.kindergartendeveloperteam.app.groupactivity.async.Async;
import hu.kindergartendeveloperteam.app.groupactivity.async.OnResult;
import hu.kindergartendeveloperteam.app.groupactivity.async.Task;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.KindergartenChild;

public class ChildrenFragment extends Fragment {

    private View v;
    private RecyclerView myRecycleView;
    private DefaultApi db = new DefaultApi();

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
        ChildrenRecyclerViewAdapter recycleAdapter = new ChildrenRecyclerViewAdapter(getContext(), new ArrayList<KindergartenChild>());
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);

        (new Async<List<KindergartenChild>>()).execute(new Task<List<KindergartenChild>>() {
            @Override
            public List<KindergartenChild> work() {
                List<KindergartenChild> Children = new ArrayList<>();
                assert getArguments() != null;
                int groupId = getArguments().getInt(GroupActivity.GROUP_ID);

                try {

                    Children = db.getGroup(groupId).getChildren();

                } catch (TimeoutException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                }

                return Children;
            }
        }, new OnResult<List<KindergartenChild>>() {
            @Override
            public void onResult(List<KindergartenChild> data) {
                ((ChildrenRecyclerViewAdapter)myRecycleView.getAdapter()).mData = data;
                ((ChildrenRecyclerViewAdapter)myRecycleView.getAdapter()).notifyDataSetChanged();
            }
        });


        return v;
    }
}

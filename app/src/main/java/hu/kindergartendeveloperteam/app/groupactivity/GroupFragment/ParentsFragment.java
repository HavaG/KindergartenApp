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
import io.swagger.client.model.KindergartenUser;

public class ParentsFragment extends Fragment {

    View v;
    private RecyclerView myRecycleView;
    private List<KindergartenUser> Parents;
    DefaultApi db = new DefaultApi();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Parents = new ArrayList<>();

        assert getArguments() != null;
        int groupId = getArguments().getInt(GroupActivity.GROUP_ID);

        try {
            List<KindergartenChild> allChildren = db.getGroup(groupId).getChildren();
            for(int i = 0; i < allChildren.size(); i++){
                if(!Parents.contains(allChildren.get(i).getParent())) {
                    Parents.add(allChildren.get(i).getParent());
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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.group_user_fragment, container, false);
        myRecycleView = (RecyclerView) v.findViewById(R.id.userRecycleView);
        UserRecyclerViewAdapter recycleAdapter = new UserRecyclerViewAdapter(getContext(),Parents);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(recycleAdapter);
        return v;
    }
}

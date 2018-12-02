package hu.kindergartendeveloperteam.app.groupactivity.GroupFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import hu.kindergartendeveloperteam.app.groupactivity.R;

public class PostsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.group_posts_fragment, container, false);
        //TODO: mivan ha maps???
        //TODO: post kirajzolása (csak az a része ami kell)

        return rootView;
    }
}

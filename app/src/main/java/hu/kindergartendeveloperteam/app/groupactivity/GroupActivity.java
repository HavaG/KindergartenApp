package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ChildrenFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.ParentsFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.PostsFragment;
import hu.kindergartendeveloperteam.app.groupactivity.GroupFragment.TeacherFragment;

public class GroupActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager_id);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Boolean onlyMessage = getIntent().getBooleanExtra("only_message", false);

        //TODO: ehhez a csoporthoz tartozó dolgokat kell kiírni (ha az id = 0 akkor csak chat, de kell az összes user)
        String groupName = getIntent().getStringExtra("group_name");
        int  groupId = getIntent().getIntExtra("groupId", 0);


        if(onlyMessage){
            adapter.AddFragment(new TeacherFragment(), "Teachers");
            adapter.AddFragment(new ParentsFragment(), "Parents");
        }
        else{
            adapter.AddFragment(new PostsFragment(), "Posts");
            adapter.AddFragment(new TeacherFragment(), "Teachers");
            adapter.AddFragment(new ParentsFragment(), "Parents");
            adapter.AddFragment(new ChildrenFragment(), "Children");
        }

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}
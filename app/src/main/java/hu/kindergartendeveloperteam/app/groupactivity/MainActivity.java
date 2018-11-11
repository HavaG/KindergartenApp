package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_group:
                openGroupChooseActivity();
                break;
            case R.id.nav_message:
                openMessengerActivity();
                break;
            case R.id.nav_CreatePost:
                openCreatePostActivity();
                break;
            case R.id.nav_CreateMapPost:
                openCreateMapPostActivity();
                break;
            case R.id.nav_CreatePoll:
                openCreatePollActivity();
                break;
            case R.id.nav_logout:
                Logout();
                break;
            default:
                return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openCreatePollActivity() {
        startActivity(new Intent(this, CreatePollActivity.class));
    }

    private void openCreatePostActivity() {
        startActivity(new Intent(this, CreatePostActivity.class));
    }

    private void openCreateMapPostActivity() {
        startActivity(new Intent(this, MapsActivity.class));
    }

    private void openMessengerActivity() {
        startActivity(new Intent(this, MessengerActivity.class));
    }

    private void Logout() {
        //TODO: logout the user
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void openGroupChooseActivity() {
        startActivity(new Intent(this, GroupChooseActivity.class));
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

}
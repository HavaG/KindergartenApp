package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
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
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_group:
                openGroupActivity();
                break;
            case R.id.nav_child:
                openMyChildActivity();
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

    private void openMyChildActivity() {
        startActivity(new Intent(this, MyChildActivity.class));
    }

    private void openCreatePollActivity() {
        startActivity(new Intent(this, GroupChooseActivity.class).putExtra("open", "poll"));
    }

    private void openCreatePostActivity() {
        startActivity(new Intent(this, GroupChooseActivity.class).putExtra("open", "post"));
    }

    private void openCreateMapPostActivity() {
        startActivity(new Intent(this, GroupChooseActivity.class).putExtra("open", "maps"));
    }

    private void openMessengerActivity() {
        startActivity(new Intent(this, MessengerActivity.class).putExtra("only_message", true));
    }

    private void Logout() {
        //TODO: logout the user
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void openGroupActivity() {
        startActivity(new Intent(this, GroupChooseActivity.class).putExtra("open", "group"));
    }
}
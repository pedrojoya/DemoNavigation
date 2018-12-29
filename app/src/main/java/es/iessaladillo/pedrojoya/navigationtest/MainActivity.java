package es.iessaladillo.pedrojoya.navigationtest;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get navController from activity.
        navController = Navigation.findNavController(this, R.id.navHostFragment);
        drawerLayout  = findViewById(R.id.drawerLayout);
        // Title isn't preserved automatically on configuration change with diferent layouts
        navController.addOnDestinationChangedListener((controller, destination, arguments) ->
            setTitle(destination.getLabel()));
        if (drawerLayout != null) {
            // Navigation drawer mode.
            setupToolbarWithDrawerLayout();
            setupNavigationDrawer();
        } else {
            // BottomNavigationView mode
            setupToolbar();
            setupBottomNavigationView();
        }
    }

    private void setupToolbarWithDrawerLayout() {
        Toolbar toolbar = ActivityCompat.requireViewById(this, R.id.toolbar);
        setSupportActionBar(toolbar);
        AppBarConfiguration appBarConfiguration =
            new AppBarConfiguration.Builder(R.id.mainDestination, R.id.galleryDestination, R.id.slideshowDestination)
                .setDrawerLayout(drawerLayout)
                .build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void setupNavigationDrawer() {
        NavigationView navigationView = ActivityCompat.requireViewById(this, R.id.navigationView);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void setupToolbar() {
        Toolbar toolbar = ActivityCompat.requireViewById(this, R.id.toolbar);
        setSupportActionBar(toolbar);
        AppBarConfiguration appBarConfiguration =
            new AppBarConfiguration.Builder(R.id.mainDestination, R.id.galleryDestination, R.id.slideshowDestination)
                .build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = ActivityCompat.requireViewById(this, R.id
            .bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

}

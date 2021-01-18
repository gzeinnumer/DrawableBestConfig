package com.gzeinnumer.drawablebestconfig;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.gzeinnumer.drawablebestconfig.databinding.ActivityDashboardBinding;

import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        int decore = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //enable this tho maker icon Navigation bar become black
            decore =  View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //enable this tho maker icon status bar become black
            decore += View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }

        getWindow().getDecorView().setSystemUiVisibility(decore);

        View headerView = binding.navView.getHeaderView(0);

        ImageView sd_how_to_use = (ImageView) MenuItemCompat.getActionView(binding.navView.getMenu().findItem(R.id.sd_how_to_use));
        ImageView sd_faq = (ImageView) MenuItemCompat.getActionView(binding.navView.getMenu().findItem(R.id.sd_faq));
        ImageView sd_log_out = (ImageView) MenuItemCompat.getActionView(binding.navView.getMenu().findItem(R.id.sd_log_out));
        ImageView sd_about = (ImageView) MenuItemCompat.getActionView(binding.navView.getMenu().findItem(R.id.sd_about));
        TextView tvEmployeeNavHeader = headerView.findViewById(R.id.tvNama);
        tvEmployeeNavHeader.setText("Nama Disini");

        sd_how_to_use.setImageResource(R.drawable.ic_navigate_next_normal_green);
        sd_faq.setImageResource(R.drawable.ic_navigate_next_normal_green);
        sd_log_out.setImageResource(R.drawable.ic_navigate_next_normal_green);
        sd_about.setImageResource(R.drawable.ic_navigate_next_normal_green);

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.toolbar.setElevation(0);

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home).setDrawerLayout(binding.drawerLayout).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
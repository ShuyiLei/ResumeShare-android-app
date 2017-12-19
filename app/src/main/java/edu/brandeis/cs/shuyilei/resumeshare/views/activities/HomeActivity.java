package edu.brandeis.cs.shuyilei.resumeshare.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.brandeis.cs.shuyilei.resumeshare.R;
import edu.brandeis.cs.shuyilei.resumeshare.views.fragments.ProfileFragment;
import edu.brandeis.cs.shuyilei.resumeshare.views.fragments.RequestsFragment;
import edu.brandeis.cs.shuyilei.resumeshare.views.fragments.ResumeFragment;
import edu.brandeis.cs.shuyilei.resumeshare.views.widgets.CircleImageView;
import edu.brandeis.cs.shuyilei.resumeshare.views.widgets.MenuItem;
import edu.brandeis.cs.shuyilei.resumeshare.adapters.MenuItemAdapter;
import edu.brandeis.cs.shuyilei.resumeshare.views.fragments.ContactsFragment;
import edu.brandeis.cs.shuyilei.resumeshare.views.fragments.HomeFragment;
import edu.brandeis.cs.shuyilei.resumeshare.views.fragments.SettingsFragment;

public class HomeActivity extends AppCompatActivity  {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private CircleImageView mCircleImageView;

    private String[] mMenuItemTitle;

    private static String mCurrentAccount;
    private static String ResumeAccount;
    private static String RequestAccount;

    public String getRequestAccount() {
        return RequestAccount;}

    public void setRequestAccount(String requestAccount) {
        RequestAccount = requestAccount;}

    public String getResumeAccount(){return ResumeAccount;}
    public void setResumeAccount(String resumeAccount){
        this.ResumeAccount=resumeAccount;}

    public String getCurrentUser(){
        return mCurrentAccount;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentAccount=getIntent().getStringExtra("account");
        setContentView(R.layout.activity_home);
        mMenuItemTitle=getResources().getStringArray(R.array.menuitem_title);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mNavigationView = (NavigationView) findViewById(R.id.navigationview);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCircleImageView=(CircleImageView)mNavigationView.getHeaderView(0).findViewById(R.id.civ_profile);

        setSupportActionBar(mToolbar);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new HomeFragment()).addToBackStack(null).commit();

        mCircleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new ProfileFragment()).addToBackStack(null).commit();
                mToolbar.setTitle("Profile");
                mDrawerLayout.closeDrawer(mNavigationView);

            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
               String title=item.getTitle().toString();
                item.setChecked(true);
                if(title.equals("Home")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new HomeFragment()).addToBackStack(null).commit();

                    mToolbar.setTitle("ShareResume");
                    mDrawerLayout.closeDrawer(mNavigationView);

                }else if(title.equals("Profile")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new ProfileFragment()).addToBackStack(null).commit();
                    mToolbar.setTitle("Profile");
                    mDrawerLayout.closeDrawer(mNavigationView);

                }else if(title.equals("Contacts")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new ContactsFragment()).addToBackStack(null).commit();
                        mToolbar.setTitle("Contacts");
                        mDrawerLayout.closeDrawer(mNavigationView);

                }else if(title.equals("Invitation")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new RequestsFragment()).addToBackStack(null).commit();
                    mToolbar.setTitle("Invitation");
                    mDrawerLayout.closeDrawer(mNavigationView);
                }
                else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SettingsFragment()).addToBackStack(null).commit();
                        mToolbar.setTitle("Settings");
                        mDrawerLayout.closeDrawer(mNavigationView);

                }

                return false;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            getSupportFragmentManager().popBackStack();
        }
        return true;
    }


}

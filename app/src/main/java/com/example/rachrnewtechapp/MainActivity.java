package com.example.rachrnewtechapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.rachrnewtechapp.Activities.LoginActivity;
import com.example.rachrnewtechapp.Activities.ManageActivity;
import com.example.rachrnewtechapp.Activities.SaesFormActivity;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.StatusResponse;
import com.example.rachrnewtechapp.Model.UserDto;
import com.example.rachrnewtechapp.Utils.CustomTypefaceSpan;
import com.example.rachrnewtechapp.Utils.DatabaseUtil;
import com.example.rachrnewtechapp.Utils.FontUtils;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer_layout;
    private NavigationView navigation_view;
    private TextView txt_username;
    private LinearLayout ll_nav_icon;
    private TextView txt_dashborda;
    private UserDto userDto;
    private StatusResponse response;
    private TextView view_balance_activity,header_ioclBalance,txt_no,billingTV;
    private LinearLayout ll_no,ll_yes;
    private StatusResponse statusResponse;
    private String deptname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_layout);

        drawer_layout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigation_view = (NavigationView)findViewById(R.id.navigation_view);
        txt_dashborda = (TextView)findViewById(R.id.txt_dashborda);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawer_layout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        navigation_view.setNavigationItemSelectedListener(this);
        View view = navigation_view.getHeaderView(0);
        txt_username = (TextView)view.findViewById(R.id.txt_username);

        DatabaseUtil databaseUtil = new DatabaseUtil(getApplicationContext ());
        userDto = databaseUtil.fetchRegisteredDeviceData ();
   //     statusResponse = databaseUtil.fetchStatusData();
        databaseUtil.close ();

        txt_username.setText(userDto.getUserName());

        Menu menu = navigation_view.getMenu();
        for (int i=0;i<menu.size();i++) {
            MenuItem mi = menu.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }

      //  navigationView.setBackgroundColor(getResources().getColor(R.color.nav_background));
     //   NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
     //   navMenuView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        toggle.syncState();

        ll_nav_icon = (LinearLayout)findViewById(R.id.ll_nav_icon);
        ll_nav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_layout.openDrawer(GravityCompat.START);
            }
        });

        FontUtils.changeFont(getApplicationContext(),txt_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_dashborda, AppConstant.FONT_SANS_SEMIBOLD);
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(),"font/VarelaRound-Regular.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_item_dashboard:

                break;

            case R.id.nav_item_manage_user:
                Intent intent = new Intent(MainActivity.this, ManageActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_item_sales_form:
                Intent intent1 = new Intent(MainActivity.this, SaesFormActivity.class);
                startActivity(intent1);
                break;

            case R.id.nav_item_R_D:

                break;

            case R.id.nav_item_operation_form:

                break;

            case R.id.nav_item_GA_Form:

                break;

            case R.id.nav_item_project_execution:

                break;

            case R.id.nav_item_shared_form:

                break;

            case R.id.nav_item_profile:

                break;

            case R.id.nav_item_Logout:

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_logout_dialog,null,false);
                view_balance_activity = (TextView)dialogView.findViewById(R.id.view_balance_activity);
                header_ioclBalance = (TextView)dialogView.findViewById(R.id.header_ioclBalance);
                txt_no = (TextView)dialogView.findViewById(R.id.txt_no);
                billingTV = (TextView)dialogView.findViewById(R.id.billingTV);
                ll_no = (LinearLayout)dialogView.findViewById(R.id.ll_no);
                ll_yes = (LinearLayout)dialogView.findViewById(R.id.ll_yes);

                builder.setView(dialogView);
                final AlertDialog dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                FontUtils.changeFont(MainActivity.this,txt_no,AppConstant.FONT_SANS_SEMIBOLD);
                FontUtils.changeFont(MainActivity.this,billingTV,AppConstant.FONT_SANS_SEMIBOLD);
                FontUtils.changeFont(MainActivity.this,view_balance_activity,AppConstant.FONT_SANS_SEMIBOLD);
                FontUtils.changeFont(MainActivity.this,header_ioclBalance,AppConstant.FONT_SANS_SEMIBOLD);

                ll_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                ll_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final DatabaseUtil db = new DatabaseUtil (getApplicationContext ());
                        db.truncateTable("DEVICE_LOGIN");
                        db.close();
                        finish();

                        Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent1);

                        dialog.dismiss();
                    }
                });
                dialog.show();

                break;

               /* //do this on logout button click

                break;*/
        }

        drawer_layout.closeDrawer(GravityCompat.START, false);
        return true;
    }
}
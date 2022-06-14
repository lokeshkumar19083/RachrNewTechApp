package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rachrnewtechapp.Adapter.LevelAdapter;
import com.example.rachrnewtechapp.Adapter.ManageUserAdapter;
import com.example.rachrnewtechapp.Adapter.PermissionAdapter;
import com.example.rachrnewtechapp.Adapter.UserRoleAdapter;
import com.example.rachrnewtechapp.Adapter.WorkFlowAdapter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.GetUserRoleData;
import com.example.rachrnewtechapp.Model.UserRoleDepartmentModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class ViewRoleActivity extends AppCompatActivity {
    private GetUserRoleData getUserRoleData;
    private LinearLayout ll_wf,ll_level,ll_permission;
    private TextView txt_wf,txt_level,txt_permission;
    private LinearLayout ll_level_layout,ll_permission_layout,ll_workflow_layout;
    private TextView txt_viewrole,txt_usertype,txt_username,form_level,txt_view,txt_add,txt_edit,txt_delete,
            form_permisson,txt_l1,txt_l2,txt_l3,txt_l4,txt_l5,form_wf,txt_i,txt_r,txt_a,txt_department;
    private EditText et_department,et_usertype,et_username;
    private List<UserRoleDepartmentModel> getUserRoleDepartmentModel;
    private RecyclerView recyclerview_level,recyclerview_permission,recyclerview_workflow;
    private RecyclerView.LayoutManager recyclerviewLayout, recyclerviewlayout_one,recyclerview_two;
    private LevelAdapter levelAdapter;
    private PermissionAdapter permissionAdapter;
    private WorkFlowAdapter workFlowAdapter;
    private UserRoleDepartmentModel userRoleDepartmentModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_role);

        final Intent inte = getIntent();
        getUserRoleData = (GetUserRoleData) inte.getSerializableExtra("getUserRoleData");
        System.out.println("getUserRoleData :::: " + getUserRoleData.getId());

        ll_wf = (LinearLayout)findViewById(R.id.ll_wf);
        ll_level = (LinearLayout)findViewById(R.id.ll_level);
        ll_permission = (LinearLayout)findViewById(R.id.ll_permission);
        txt_wf = (TextView)findViewById(R.id.txt_wf);
        txt_level = (TextView)findViewById(R.id.txt_level);
        txt_permission = (TextView)findViewById(R.id.txt_permission);
        txt_viewrole = (TextView)findViewById(R.id.txt_viewrole);
        txt_usertype = (TextView)findViewById(R.id.txt_usertype);
        txt_username = (TextView)findViewById(R.id.txt_username);
        form_level = (TextView)findViewById(R.id.form_level);
        txt_view = (TextView)findViewById(R.id.txt_view);
        txt_add = (TextView)findViewById(R.id.txt_add);
        txt_edit = (TextView)findViewById(R.id.txt_edit);
        txt_delete = (TextView)findViewById(R.id.txt_delete);
        form_permisson = (TextView)findViewById(R.id.form_permisson);
        txt_l1 = (TextView)findViewById(R.id.txt_l1);
        txt_l2 = (TextView)findViewById(R.id.txt_l2);
        txt_l3 = (TextView)findViewById(R.id.txt_l3);
        txt_l4 = (TextView)findViewById(R.id.txt_l4);
        txt_l5 = (TextView)findViewById(R.id.txt_l5);
        form_wf = (TextView)findViewById(R.id.form_wf);
        txt_i = (TextView)findViewById(R.id.txt_i);
        txt_r = (TextView)findViewById(R.id.txt_r);
        txt_a = (TextView)findViewById(R.id.txt_a);
        txt_department = (TextView)findViewById(R.id.txt_department);
        et_department = (EditText)findViewById(R.id.et_department);
        et_usertype = (EditText)findViewById(R.id.et_usertype);
        et_username = (EditText)findViewById(R.id.et_username);

        et_department.setText(getUserRoleData.getDepartmentName());
        et_usertype.setText(getUserRoleData.getUserTypeName());
        et_username.setText(getUserRoleData.getUserName());

        recyclerview_level = (RecyclerView)findViewById(R.id.recyclerview_level);
        recyclerview_permission = (RecyclerView)findViewById(R.id.recyclerview_permission);
        recyclerview_workflow = (RecyclerView)findViewById(R.id.recyclerview_workflow);


        FontUtils.changeFont(getApplicationContext(), txt_wf, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_level, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_permission, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_viewrole, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_usertype, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), form_level, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_view, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_add, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_edit, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_delete, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), form_permisson, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l1, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_department, AppConstant.FONT_SANS_SEMIBOLD);


        FontUtils.changeFont(getApplicationContext(), txt_l2, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l3, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l4, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l5, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(), form_wf, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_i, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_r, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_a, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(), et_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_usertype, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_username, AppConstant.FONT_SANS_SEMIBOLD);

        ll_level.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
        txt_level.setTextColor(getResources().getColor(R.color.white));
        ll_permission.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
        txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));
        ll_wf.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
        txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));


        ll_level_layout = (LinearLayout)findViewById(R.id.ll_level_layout);
        ll_permission_layout = (LinearLayout)findViewById(R.id.ll_permission_layout);
        ll_workflow_layout = (LinearLayout)findViewById(R.id.ll_workflow_layout);

        ll_level_layout.setVisibility(View.VISIBLE);
        ll_workflow_layout.setVisibility(View.GONE);
        ll_permission_layout.setVisibility(View.GONE);
        new GetDataById().execute();



        ll_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_level.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                txt_level.setTextColor(getResources().getColor(R.color.white));
                ll_permission.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_wf.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));

                ll_level_layout.setVisibility(View.VISIBLE);
                ll_workflow_layout.setVisibility(View.GONE);
                ll_permission_layout.setVisibility(View.GONE);
                new GetDataById().execute();
                recyclerview_level.setVisibility(View.VISIBLE);
                recyclerview_permission.setVisibility(View.GONE);
                recyclerview_workflow.setVisibility(View.GONE);
            }
        });

        ll_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_level.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_level.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_permission.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                txt_permission.setTextColor(getResources().getColor(R.color.white));
                ll_wf.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_level_layout.setVisibility(View.GONE);
                ll_workflow_layout.setVisibility(View.GONE);
                ll_permission_layout.setVisibility(View.VISIBLE);
                new GetDataById().execute();
               /* recyclerview_level.setVisibility(View.GONE);
                recyclerview_permission.setVisibility(View.VISIBLE);
                recyclerview_workflow.setVisibility(View.GONE);*/
            }
        });


        ll_wf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 ll_wf.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                 txt_wf.setTextColor(getResources().getColor(R.color.white));
                ll_level.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_level.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_permission.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));
                recyclerview_level.setVisibility(View.GONE);
                recyclerview_permission.setVisibility(View.GONE);
                recyclerview_workflow.setVisibility(View.VISIBLE);
                ll_workflow_layout.setVisibility(View.VISIBLE);
                ll_level_layout.setVisibility(View.GONE);
                ll_permission_layout.setVisibility(View.GONE);
                new GetDataById().execute();

            }
        });
    }

    public class GetDataById extends AsyncTask<Void,Void,List<UserRoleDepartmentModel>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<UserRoleDepartmentModel> doInBackground(Void... voids) {
            ApiService service = ApiClient.getApiService();
            Call<List<UserRoleDepartmentModel>> call = service.getDepartmentForm(getUserRoleData.getId());
            try {
                getUserRoleDepartmentModel = (List<UserRoleDepartmentModel>) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return getUserRoleDepartmentModel;
        }

        @Override
        protected void onPostExecute(List<UserRoleDepartmentModel> departmentFormReceiverModels) {


            ll_level.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
            txt_level.setTextColor(getResources().getColor(R.color.white));
            ll_permission.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
            txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));
            ll_wf.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
            txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));

            ll_level_layout.setVisibility(View.VISIBLE);
            ll_workflow_layout.setVisibility(View.GONE);
            ll_permission_layout.setVisibility(View.GONE);
            recyclerview_level.setVisibility(View.VISIBLE);
            recyclerview_permission.setVisibility(View.GONE);
            recyclerviewLayout = new LinearLayoutManager(ViewRoleActivity.this);
            recyclerview_level.setLayoutManager(recyclerviewLayout);
            levelAdapter = new LevelAdapter(getApplicationContext(),getUserRoleDepartmentModel);
            recyclerview_level.setAdapter(levelAdapter);
            levelAdapter.notifyDataSetChanged();

            ll_level.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ll_level.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                    txt_level.setTextColor(getResources().getColor(R.color.white));
                    ll_permission.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                    txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));
                    ll_wf.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                    txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));

                    ll_level_layout.setVisibility(View.VISIBLE);
                    ll_workflow_layout.setVisibility(View.GONE);
                    ll_permission_layout.setVisibility(View.GONE);
                    recyclerview_level.setVisibility(View.VISIBLE);
                    recyclerview_permission.setVisibility(View.GONE);
                    recyclerviewLayout = new LinearLayoutManager(ViewRoleActivity.this);
                    recyclerview_level.setLayoutManager(recyclerviewLayout);
                    levelAdapter = new LevelAdapter(getApplicationContext(),getUserRoleDepartmentModel);
                    recyclerview_level.setAdapter(levelAdapter);
                    levelAdapter.notifyDataSetChanged();

                }
            });

            ll_permission.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ll_level.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                    txt_level.setTextColor(getResources().getColor(R.color.spinner_color));
                    ll_permission.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                    txt_permission.setTextColor(getResources().getColor(R.color.white));
                    ll_wf.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                    txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));
                    recyclerview_level.setVisibility(View.GONE);
                    ll_level_layout.setVisibility(View.GONE);
                    ll_workflow_layout.setVisibility(View.GONE);
                    ll_permission_layout.setVisibility(View.VISIBLE);
                    recyclerview_level.setVisibility(View.GONE);
                    recyclerview_permission.setVisibility(View.VISIBLE);

                    recyclerviewlayout_one = new LinearLayoutManager(ViewRoleActivity.this);
                    recyclerview_permission.setLayoutManager(recyclerviewlayout_one);
                    permissionAdapter = new PermissionAdapter(getApplicationContext(),getUserRoleDepartmentModel);
                    recyclerview_permission.setAdapter(permissionAdapter);
                    permissionAdapter.notifyDataSetChanged();
                }
            });

            ll_wf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ll_wf.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                    txt_wf.setTextColor(getResources().getColor(R.color.white));
                    ll_level.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                    txt_level.setTextColor(getResources().getColor(R.color.spinner_color));
                    ll_permission.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                    txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));
                    recyclerview_level.setVisibility(View.GONE);
                    recyclerview_level.setVisibility(View.GONE);
                    recyclerview_permission.setVisibility(View.VISIBLE);
                    ll_workflow_layout.setVisibility(View.VISIBLE);
                    ll_level_layout.setVisibility(View.GONE);
                    ll_permission_layout.setVisibility(View.GONE);
                    recyclerview_two = new LinearLayoutManager(ViewRoleActivity.this);
                    recyclerview_workflow.setLayoutManager(recyclerview_two);
                    workFlowAdapter = new WorkFlowAdapter(getApplicationContext(),getUserRoleDepartmentModel);
                    recyclerview_workflow.setAdapter(workFlowAdapter);
                    workFlowAdapter.notifyDataSetChanged();
                }
            });

        }
    }

}
package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rachrnewtechapp.Adapter.EditDepartmentRecieverAdpter;
import com.example.rachrnewtechapp.Adapter.ManageUserAdapter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.GetFormDataModel;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.GetUserTypeDataModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class CreateRoleActivity extends AppCompatActivity {

    private TextView txt_reporting,txt_department,txt_select,txt_usertype,txt_select_two,txt_username,
            txt_level,txt_permission,txt_wf;
    private Spinner spinner_two,spinner_three,spinner_four;
    private LinearLayout ll_level,ll_permission,ll_wf,ll_layout_one;
    private List<GetUserTypeDataModel> getuserType = new ArrayList<>();
    private List subscriptionsStrings = new ArrayList<>();
    private List<GetFormDataModel> getFormDataList;
    private List subscriptionsStringTwo = new ArrayList<>();
    private LinearLayout ll_level_layout,ll_permission_layout,ll_workflow_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_role);
        txt_reporting = (TextView)findViewById(R.id.txt_reporting);
        txt_department = (TextView)findViewById(R.id.txt_department);
        txt_select = (TextView)findViewById(R.id.txt_select);
        txt_usertype = (TextView)findViewById(R.id.txt_usertype);
        txt_select_two = (TextView)findViewById(R.id.txt_select_two);
        txt_username = (TextView)findViewById(R.id.txt_username);
        txt_level = (TextView)findViewById(R.id.txt_level);
        txt_permission = (TextView)findViewById(R.id.txt_permission);
        txt_wf = (TextView)findViewById(R.id.txt_wf);
        spinner_two = (Spinner)findViewById(R.id.spinner_two);
        spinner_three = (Spinner)findViewById(R.id.spinner_three);
        spinner_four = (Spinner)findViewById(R.id.spinner_four);
        ll_level = (LinearLayout)findViewById(R.id.ll_level);
        ll_permission = (LinearLayout)findViewById(R.id.ll_permission);
        ll_wf = (LinearLayout)findViewById(R.id.ll_wf);
        ll_layout_one = (LinearLayout)findViewById(R.id.ll_layout_one);

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

        new GetDepartmentList().execute();

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
                ll_workflow_layout.setVisibility(View.VISIBLE);
                ll_level_layout.setVisibility(View.GONE);
                ll_permission_layout.setVisibility(View.GONE);


            }
        });

        FontUtils.changeFont(getApplicationContext(),txt_reporting, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_select, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_usertype, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_usertype, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_select_two, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_level, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_permission, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_wf, AppConstant.FONT_SANS_SEMIBOLD);
        new DownloadUsertype().execute();

    }


    public class GetDepartmentList extends AsyncTask<Void, Void, List<GetFormDataModel>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<GetFormDataModel> doInBackground(Void... voids) {
            ApiService service = ApiClient.getApiService();
            Call<List<GetFormDataModel>> call = service.getFormData();
            try {
                getFormDataList = (List<GetFormDataModel>) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return getFormDataList;
        }

        @Override
        protected void onPostExecute(List<GetFormDataModel> getFormDataModels) {
            for (int i=0;i < getFormDataList.size();i++){
                if (!subscriptionsStringTwo.contains(getFormDataList.get(i).getDepartmentName())){
                    subscriptionsStringTwo.add(getFormDataList.get(i).getDepartmentName());

                    ArrayAdapter<ArrayList<CharSequence>> adapterTwo = new ArrayAdapter<ArrayList<CharSequence>>(CreateRoleActivity.this,R.layout.spinner_item,subscriptionsStringTwo);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_two.setAdapter(adapterTwo);
                }

            }

        }
    }

    public class DownloadUsertype extends AsyncTask<Void,Void,List<GetUserTypeDataModel>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<GetUserTypeDataModel> doInBackground(Void... voids) {
            ApiService service = ApiClient.getApiService();
            Call<List<GetUserTypeDataModel>> call = service.getUserTypeData();
            try {
                getuserType = (List<GetUserTypeDataModel>) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return getuserType;
        }

        @Override
        protected void onPostExecute(List<GetUserTypeDataModel> getUserTypeDataModels) {
            super.onPostExecute(getUserTypeDataModels);
            for (int i=0;i < getuserType.size();i++){
                subscriptionsStrings.add(getuserType.get(i).getUserTypeName());

                ArrayAdapter<ArrayList<CharSequence>> adapterTwo = new ArrayAdapter<ArrayList<CharSequence>>(CreateRoleActivity.this,R.layout.spinner_item,subscriptionsStrings);
                adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner_three.setAdapter(adapterTwo);
            }




          /*  ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,subscriptionsStrings,
                    R.layout.spinner_item);
            adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spinner_six.setAdapter(adapterTwo);
            spinner_six.setEnabled(true);*/

        }
    }


}
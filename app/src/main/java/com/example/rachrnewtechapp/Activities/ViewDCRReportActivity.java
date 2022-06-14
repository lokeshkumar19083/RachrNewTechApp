package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rachrnewtechapp.Adapter.EditDepartmentRecieverAdpter;
import com.example.rachrnewtechapp.Adapter.ViewDcrAdapter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.AddDARFCDetail;
import com.example.rachrnewtechapp.Model.DcrResponseIdModel;
import com.example.rachrnewtechapp.Model.DcrResponseModel;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.EditDepartmentFormWrapper;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewDCRReportActivity extends AppCompatActivity {
    private TextView txt_view_dcr,txt_username,txt_territory,txt_date,txt_week_year,txt_name;
    private EditText et_username,et_territory,et_date,et_week_year;
    private DcrResponseIdModel dcrResponseIdModel;
    private DcrResponseModel dcrResponseModel;
    private RecyclerView recycler_viewDcr;
    private ViewDcrAdapter viewDcrAdapter;
    private RecyclerView.LayoutManager recyclerviewLayout, recyclerviewlayout_one,recyclerview_two;
    private List<AddDARFCDetail> addDARFCDetails;
    private List<DcrResponseIdModel> dcrResponseIdModels;
    private LinearLayout ll_nav_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dcrreport);

        final Intent inte = getIntent();
        addDARFCDetails = (List<AddDARFCDetail>) inte.getSerializableExtra("addDARFCDetails");
        dcrResponseModel = (DcrResponseModel)inte.getSerializableExtra("dcrResponseModel");

   //     System.out.println("dcrResponseModel ::" + addDARFCDetails.getCreatedOn());


        txt_view_dcr = (TextView)findViewById(R.id.txt_view_dcr);
        txt_username = (TextView)findViewById(R.id.txt_username);
        txt_territory = (TextView)findViewById(R.id.txt_territory);
        txt_date = (TextView)findViewById(R.id.txt_date);
        txt_week_year = (TextView)findViewById(R.id.txt_week_year);
        txt_name = (TextView)findViewById(R.id.txt_name);
        ll_nav_icon = (LinearLayout)findViewById(R.id.ll_nav_icon);

        recycler_viewDcr = (RecyclerView)findViewById(R.id.recycler_viewDcr);

        et_username = (EditText)findViewById(R.id.et_username);
        et_territory = (EditText)findViewById(R.id.et_territory);
        et_date = (EditText)findViewById(R.id.et_date);
        et_week_year = (EditText)findViewById(R.id.et_week_year);

        ll_nav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        et_username.setText("" +dcrResponseModel.getEmployeeName());
        et_territory.setText("" + dcrResponseModel.getTerritory());
        et_date.setText("" + dcrResponseModel.getDate());
        et_week_year.setText("" + dcrResponseModel.getWeekAndYear());
     //   new GetDcrByGetId().execute();
       /* ApiService service = ApiClient.getApiService();
        Call<List<DcrResponseIdModel>> call = service.getDataDcrById(dcrResponseModel.getId());
        call.enqueue(new Callback<List<DcrResponseIdModel>>() {
            @Override
            public void onResponse(Call<List<DcrResponseIdModel>> call, Response<List<DcrResponseIdModel>> response) {
                if (response.isSuccessful()){

                    et_username.setText("" +dcrResponseModel.getEmployeeName());
                    et_territory.setText("" + dcrResponseModel.getTerritory());
                    et_date.setText("" + dcrResponseModel.getDate());
                    et_week_year.setText("" + dcrResponseModel.getWeekAndYear());

                    recyclerviewLayout = new LinearLayoutManager(ViewDCRReportActivity.this);
                    recycler_viewDcr.setLayoutManager(recyclerviewLayout);
                    viewDcrAdapter = new ViewDcrAdapter(ViewDCRReportActivity.this,dcrResponseIdModels);
                    recycler_viewDcr.setAdapter(viewDcrAdapter);
                    viewDcrAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<DcrResponseIdModel>> call, Throwable t) {

            }
        });*/


        recyclerviewLayout = new LinearLayoutManager(ViewDCRReportActivity.this);
        recycler_viewDcr.setLayoutManager(recyclerviewLayout);
        viewDcrAdapter = new ViewDcrAdapter(ViewDCRReportActivity.this,addDARFCDetails);
        recycler_viewDcr.setAdapter(viewDcrAdapter);
        viewDcrAdapter.notifyDataSetChanged();


        FontUtils.changeFont(getApplicationContext(), txt_view_dcr, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_territory, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_date, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_week_year, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_name, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_territory, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_date, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_week_year, AppConstant.FONT_SANS_SEMIBOLD);


    }


  /*  public class GetDcrByGetId extends AsyncTask<Void,Void,List<DcrResponseIdModel>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<DcrResponseIdModel> doInBackground(Void... voids) {
            ApiService service = ApiClient.getApiService();
            Call<List<DcrResponseIdModel>> call = service.getDataDcrById(dcrResponseModel.getId());
            try {
    //            dcrResponseIdModels = (List<DcrResponseIdModel>)call.execute().body();
                dcrResponseIdModels = (List<DcrResponseIdModel>) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return dcrResponseIdModels;
        }

        @Override
        protected void onPostExecute(List<DcrResponseIdModel> dcrResponseIdModel) {
            super.onPostExecute(dcrResponseIdModel);

            recyclerviewLayout = new LinearLayoutManager(ViewDCRReportActivity.this);
            recycler_viewDcr.setLayoutManager(recyclerviewLayout);
            viewDcrAdapter = new ViewDcrAdapter(ViewDCRReportActivity.this,dcrResponseIdModel);
            recycler_viewDcr.setAdapter(viewDcrAdapter);
            viewDcrAdapter.notifyDataSetChanged();
        }
    }*/
}
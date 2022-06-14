package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rachrnewtechapp.Adapter.DCRAdapter;
import com.example.rachrnewtechapp.Adapter.DepartmentFormReceiverAdapter;
import com.example.rachrnewtechapp.Adapter.ProjectNPAdapter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.MainActivity;
import com.example.rachrnewtechapp.Model.DcrRequestModel;
import com.example.rachrnewtechapp.Model.DcrResponseModel;
import com.example.rachrnewtechapp.Model.GetFormDataModel;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.NPRequestModel;
import com.example.rachrnewtechapp.Model.ProjectNPModel;
import com.example.rachrnewtechapp.Model.StatusCreateUser;
import com.example.rachrnewtechapp.Model.StatusResponse;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.DatabaseUtil;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;

public class SaesFormActivity extends AppCompatActivity {
    private TextView txt_sales_form;
    private EditText edit_search,edit_search_two,edit_search_seven,edit_search_np;
    private Spinner spinner_one,spinner_two,spinner_seven,filter_spinner_district,filter_spinner_order_status,filter_spinner_form_stage;
    private LinearLayout ll_dcr,ll_system_cost,ll_user_one,ll_dcr_layout,ll_project_layout;
    private RecyclerView.LayoutManager recyclerviewLayout, recyclerviewlayout_one,recyclerview_two;
    private TextView txt_dcr,txt_system_cost,txt_create_np;
    private RecyclerView recyclerView_dcr,recyclerView_np;
    private DcrRequestModel dcrRequestModel;
    private DCRAdapter dcrAdapter;
    private StatusResponse statusResponse;
    private LinearLayout ll_nav_icon;
    private List<DcrResponseModel> dcrResponseModel;
    private LinearLayout ll_create;
    private  DatabaseUtil databaseUtil;
    private NPRequestModel npRequestModel;
    private List<ProjectNPModel> projectNPModels;
    private ProjectNPAdapter projectNPAdapter;
    private LinearLayout ll_mange_np,ll_mange_user;
    private LinearLayout ll_filter_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saes_form);
        txt_sales_form = (TextView)findViewById(R.id.txt_sales_form);
        txt_dcr = (TextView)findViewById(R.id.txt_dcr);
        txt_system_cost = (TextView)findViewById(R.id.txt_system_cost);
        edit_search = (EditText)findViewById(R.id.edit_search);
        edit_search_np = (EditText)findViewById(R.id.edit_search_np);
        spinner_one = (Spinner)findViewById(R.id.spinner_one);
        spinner_seven = (Spinner)findViewById(R.id.spinner_seven);
        ll_dcr = (LinearLayout)findViewById(R.id.ll_dcr);
        ll_dcr_layout = (LinearLayout)findViewById(R.id.ll_dcr_layout);
        ll_system_cost = (LinearLayout)findViewById(R.id.ll_system_cost);
        ll_user_one = (LinearLayout)findViewById(R.id.ll_user_one);
        spinner_two= (Spinner)findViewById(R.id.spinner_two);
        recyclerView_dcr = (RecyclerView)findViewById(R.id.recyclerView_dcr);
        edit_search_two = (EditText)findViewById(R.id.edit_search_two);
        edit_search_seven = (EditText)findViewById(R.id.edit_search_seven);
        ll_project_layout = (LinearLayout)findViewById(R.id.ll_project_layout);
        recyclerView_np = (RecyclerView)findViewById(R.id.recyclerView_np);
        txt_create_np = (TextView)findViewById(R.id.txt_create_np);
        ll_mange_user = (LinearLayout)findViewById(R.id.ll_mange_user);
        filter_spinner_district = (Spinner)findViewById(R.id.filter_spinner_district);
        filter_spinner_order_status = (Spinner)findViewById(R.id.filter_spinner_order_status);
        filter_spinner_form_stage = (Spinner)findViewById(R.id.filter_spinner_form_stage);





        ll_nav_icon = (LinearLayout)findViewById(R.id.ll_nav_icon);
        ll_create = (LinearLayout)findViewById(R.id.ll_create);
        ll_mange_np = (LinearLayout)findViewById(R.id.ll_mange_np);


        ll_nav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaesFormActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ll_dcr.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
        txt_dcr.setTextColor(getResources().getColor(R.color.white));
        ll_system_cost.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
        txt_system_cost.setTextColor(getResources().getColor(R.color.spinner_color));
        ll_user_one.setVisibility(View.VISIBLE);

        FontUtils.changeFont(getApplicationContext(), txt_sales_form, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_dcr, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_system_cost, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_create_np, AppConstant.FONT_SANS_SEMIBOLD);

        spinner_one = (Spinner)findViewById(R.id.spinner_one);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sales_form,
                R.layout.spinner_item_two);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        spinner_one.setAdapter(adapter);


        spinner_two= (Spinner)findViewById(R.id.spinner_two);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this, R.array.dcr_values,
                R.layout.spinner_item_two);
        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        spinner_two.setAdapter(adapterTwo);

        databaseUtil = new DatabaseUtil(getApplicationContext ());
        statusResponse = databaseUtil.fetchStatusData();
        databaseUtil.close ();

        dcrRequestModel = new DcrRequestModel();
        dcrRequestModel.setDepartmentID(statusResponse.getDepartmentId());
        dcrRequestModel.setUserID(statusResponse.getUserId());
        dcrRequestModel.setFormsSharedMode(false);

        GETdcrList(dcrRequestModel);

        ll_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SaesFormActivity.this,CreateDCRActivity.class);
                startActivity(intent);
            }
        });



        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter_user(editable.toString());
            }
        });

        edit_search_np.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter_np(editable.toString());
            }
        });

        spinner_two.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_two.getSelectedItem().toString().trim().equals("Territory")){
                    edit_search_two.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            filter(editable.toString());
                        }
                    });
                }else if (spinner_two.getSelectedItem().toString().trim().equals("Employee Name")){
                    edit_search_two.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            filterTwo(editable.toString());
                        }
                    });
                }else if (spinner_two.getSelectedItem().toString().trim().equals("Date")){
                    edit_search_two.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            filterThree(editable.toString());
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapterTwelve = ArrayAdapter.createFromResource(this, R.array.order_status,
                R.layout.spinner_item_two);
        adapterTwelve.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        filter_spinner_order_status.setAdapter(adapterTwelve);


        ArrayAdapter<CharSequence> adapterThirteen = ArrayAdapter.createFromResource(this, R.array.form_stage,
                R.layout.spinner_item_two);
        adapterThirteen.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        filter_spinner_order_status.setAdapter(adapterThirteen);

        spinner_seven.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (spinner_seven.getSelectedItem().toString().trim().equals("Business Name")){
                   filter_spinner_order_status.setVisibility(View.GONE);
                   filter_spinner_district.setVisibility(View.GONE);
                   filter_spinner_form_stage.setVisibility(View.GONE);

                   edit_search_seven.addTextChangedListener(new TextWatcher() {
                       @Override
                       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void afterTextChanged(Editable editable) {
                           filter_business_name(editable.toString());
                       }
                   });
               }else if (spinner_seven.getSelectedItem().toString().trim().equals("Floor Area")){
                   filter_spinner_order_status.setVisibility(View.GONE);
                   filter_spinner_district.setVisibility(View.GONE);
                   filter_spinner_form_stage.setVisibility(View.GONE);
                   edit_search_seven.addTextChangedListener(new TextWatcher() {
                       @Override
                       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void afterTextChanged(Editable editable) {
                           filter_floor_area(editable.toString());
                       }
                   });
               }else if (spinner_seven.getSelectedItem().toString().trim().equals("CreatedOn")){
                   filter_spinner_order_status.setVisibility(View.GONE);
                   filter_spinner_district.setVisibility(View.GONE);
                   filter_spinner_form_stage.setVisibility(View.GONE);
                   edit_search_seven.addTextChangedListener(new TextWatcher() {
                       @Override
                       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void afterTextChanged(Editable editable) {
                           filter_created_on(editable.toString());
                       }
                   });
               }else if (spinner_seven.getSelectedItem().toString().trim().equals("Created By")){
                   filter_spinner_order_status.setVisibility(View.GONE);
                   filter_spinner_district.setVisibility(View.GONE);
                   filter_spinner_form_stage.setVisibility(View.GONE);
                   edit_search_seven.addTextChangedListener(new TextWatcher() {
                       @Override
                       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void afterTextChanged(Editable editable) {
                           filter_created_by(editable.toString());
                       }
                   });
               }else if (spinner_seven.getSelectedItem().toString().equals("District")){
                   filter_spinner_order_status.setVisibility(View.GONE);
                   filter_spinner_district.setVisibility(View.VISIBLE);
                   filter_spinner_form_stage.setVisibility(View.GONE);
               }else if (spinner_seven.getSelectedItem().toString().equals("Order Status")){
                  filter_spinner_order_status.setVisibility(View.VISIBLE);
                  filter_spinner_district.setVisibility(View.GONE);
                  filter_spinner_form_stage.setVisibility(View.GONE);
               }else if (spinner_seven.getSelectedItem().toString().equals("Form Stage")){
                   filter_spinner_order_status.setVisibility(View.GONE);
                   filter_spinner_district.setVisibility(View.GONE);
                   filter_spinner_form_stage.setVisibility(View.VISIBLE);
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        filter_spinner_order_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (filter_spinner_order_status.getSelectedItem().toString().equals("Please Select")){

                }else if (filter_spinner_order_status.getSelectedItem().toString().equals("Confirmed")){

                }else if (filter_spinner_order_status.getSelectedItem().toString().equals("Lost")){
                    ArrayList<ProjectNPModel> filteredList = new ArrayList<>();
                    for (ProjectNPModel worker : filteredList) {
                        if (worker.getOrderStatus().equals("Lost")) {
                            filteredList.add(worker);
                        }
                    }
                }else if (filter_spinner_order_status.getSelectedItem().toString().equals("Hold")){
                    ArrayList<ProjectNPModel> filteredList = new ArrayList<>();
                    for (ProjectNPModel worker : filteredList) {
                        if (worker.getOrderStatus().equals("Hold")) {
                            filteredList.add(worker);
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        ll_dcr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_dcr.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                txt_dcr.setTextColor(getResources().getColor(R.color.white));
                ll_system_cost.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_system_cost.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_user_one.setVisibility(View.VISIBLE);
                dcrRequestModel = new DcrRequestModel();
                dcrRequestModel.setDepartmentID(statusResponse.getDepartmentId());
                dcrRequestModel.setUserID(statusResponse.getUserId());
                dcrRequestModel.setFormsSharedMode(false);

                GETdcrList(dcrRequestModel);

            }
        });

        ll_system_cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_system_cost.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                txt_system_cost.setTextColor(getResources().getColor(R.color.white));
                ll_dcr.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_dcr.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_user_one.setVisibility(View.GONE);
            }
        });


        spinner_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_one.getSelectedItem().toString().trim().equals("Daily Call Report")){
                    ll_dcr_layout.setVisibility(View.VISIBLE);
                    ll_project_layout.setVisibility(View.GONE);
                    ll_mange_np.setVisibility(View.GONE);
                    ll_mange_user.setVisibility(View.VISIBLE);
                }else if (spinner_one.getSelectedItem().toString().trim().equals("Application Partner")){
                    ll_dcr_layout.setVisibility(View.GONE);
                    ll_project_layout.setVisibility(View.GONE);
                }else if (spinner_one.getSelectedItem().toString().trim().equals("New Project and Maintainece Project")){
                    ll_dcr_layout.setVisibility(View.GONE);
                    ll_project_layout.setVisibility(View.GONE);
                }else if (spinner_one.getSelectedItem().toString().trim().equals("Sales Order Requisition Form")){
                    ll_dcr_layout.setVisibility(View.GONE);
                    ll_project_layout.setVisibility(View.GONE);
                }else if (spinner_one.getSelectedItem().toString().trim().equals("Project")){
                    ll_dcr_layout.setVisibility(View.GONE);
                    ll_project_layout.setVisibility(View.VISIBLE);
                    ll_mange_np.setVisibility(View.VISIBLE);
                    ll_mange_user.setVisibility(View.GONE);


                    npRequestModel = new NPRequestModel();
                    npRequestModel.setDepartmentID(statusResponse.getDepartmentId());
                    npRequestModel.setUserID(statusResponse.getUserId());
                    npRequestModel.setFormsSharedMode(false);
                    npRequestModel.setStatus("All");
                    npRequestModel.setStartDate("All");
                    npRequestModel.setEndDate("All");
                    GetProjectList(npRequestModel);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapterThree = ArrayAdapter.createFromResource(this, R.array.array_np_list,
                R.layout.spinner_item_two);
        adapterThree.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        spinner_seven.setAdapter(adapterThree);

    }

    public void GETdcrList(DcrRequestModel dcrRequestModel){
        AsyncTask<Void,Void,Void> task = new AsyncTask<Void, Void, Void>() {
            ProgressDialog dialog = new ProgressDialog(SaesFormActivity.this,R.style.AlertDialogColor);

            @Override
            protected void onPreExecute() {
                dialog = new ProgressDialog(SaesFormActivity.this);
                dialog.setCancelable(false);
                dialog.setIndeterminate(true);
                dialog.show();
            }

            @Override
            protected Void doInBackground(Void... voids) {

                dialog.isShowing();
                try {
                    ApiService service = ApiClient.getApiService();
                   Call<List<DcrResponseModel>> resp = service.getDcrData(dcrRequestModel);
                   dcrResponseModel = resp.execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {

                }
                return null;

            }

            @Override
            protected void onPostExecute(Void unused) {
                if (dialog != null) {
                    dialog.dismiss();
                }
                recyclerview_two = new LinearLayoutManager(SaesFormActivity.this);
                recyclerView_dcr.setLayoutManager(recyclerview_two);
                dcrAdapter = new DCRAdapter(getApplicationContext(),dcrResponseModel);
                recyclerView_dcr.setAdapter(dcrAdapter);
                dcrAdapter.notifyDataSetChanged();
            }
        };
        task.execute();
    }

    private void GetProjectList(NPRequestModel npRequestModel){
      AsyncTask<Void,Void,Void> task = new AsyncTask<Void, Void, Void>() {
          ProgressDialog dialog = new ProgressDialog(SaesFormActivity.this,R.style.AlertDialogColor);

          @Override
          protected void onPreExecute() {
              dialog = new ProgressDialog(SaesFormActivity.this);
              dialog.setCancelable(false);
              dialog.setIndeterminate(true);
              dialog.show();
          }

          @Override
          protected Void doInBackground(Void... voids) {
              dialog.isShowing();
              try {
                  ApiService service = ApiClient.getApiService();
                  Call<List<ProjectNPModel>> resp = service.getDataProjectNPData(npRequestModel);
                  projectNPModels = resp.execute().body();
              } catch (Exception e) {
                  e.printStackTrace();
              }finally {

              }
              return null;
          }

          @Override
          protected void onPostExecute(Void unused) {
              if (dialog != null) {
                  dialog.dismiss();
              }
              recyclerviewLayout = new LinearLayoutManager(SaesFormActivity.this);
              recyclerView_np.setLayoutManager(recyclerviewLayout);
              projectNPAdapter = new ProjectNPAdapter(getApplicationContext(),projectNPModels);
              recyclerView_np.setAdapter(projectNPAdapter);
              projectNPAdapter.notifyDataSetChanged();
          }
      };
        task.execute();
    }


    private void GetdistrictList(NPRequestModel npRequestModel){
        AsyncTask<Void,Void,Void> task = new AsyncTask<Void, Void, Void>() {
            ProgressDialog dialog = new ProgressDialog(SaesFormActivity.this,R.style.AlertDialogColor);

            @Override
            protected void onPreExecute() {

            }

            @Override
            protected Void doInBackground(Void... voids) {
                dialog.isShowing();
                try {
                    ApiService service = ApiClient.getApiService();
                    Call<List<ProjectNPModel>> resp = service.getDataProjectNPData(npRequestModel);
                    projectNPModels = resp.execute().body();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {

                }
                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {

            }
        };
        task.execute();
    }

    private void filter_user(String text){
        ArrayList<DcrResponseModel> filteredList = new ArrayList<>();

        for (DcrResponseModel item : dcrResponseModel) {
            if (item.getTerritory().toLowerCase().contains(text.toLowerCase()) || item.getEmployeeName().toLowerCase().contains(text.toLowerCase()) || item.getDate().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        dcrAdapter.filterList(filteredList);
    }

    private void filter(String text) {
        ArrayList<DcrResponseModel> filteredList = new ArrayList<>();

        for (DcrResponseModel item : dcrResponseModel) {
            if (item.getTerritory().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        dcrAdapter.filterList(filteredList);
    }

    private void filterTwo(String text) {
        ArrayList<DcrResponseModel> filteredList = new ArrayList<>();

        for (DcrResponseModel item : dcrResponseModel) {
            if (item.getEmployeeName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        dcrAdapter.filterList(filteredList);
    }

    private void filterThree(String text) {
        ArrayList<DcrResponseModel> filteredList = new ArrayList<>();

        for (DcrResponseModel item : dcrResponseModel) {
            if (item.getDate().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        dcrAdapter.filterList(filteredList);
    }


    private void filter_np(String text){
        ArrayList<ProjectNPModel> filteredList = new ArrayList<>();

        for (ProjectNPModel item : projectNPModels) {
            if (item.getBusinessName().toLowerCase().contains(text.toLowerCase()) || item.getFloorArea().toLowerCase().contains(text.toLowerCase()) || item.getCreatedOn().toLowerCase().contains(text.toLowerCase()) || item.getCreatedBy().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        projectNPAdapter.filterList(filteredList);
    }

    private void filter_business_name(String text){
        ArrayList<ProjectNPModel> filteredList = new ArrayList<>();

        for (ProjectNPModel item : projectNPModels) {
            if (item.getBusinessName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        projectNPAdapter.filterList(filteredList);
    }


    private void filter_floor_area(String text){
        ArrayList<ProjectNPModel> filteredList = new ArrayList<>();

        for (ProjectNPModel item : projectNPModels) {
            if (item.getFloorArea().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        projectNPAdapter.filterList(filteredList);
    }

    private void filter_created_on(String text){
        ArrayList<ProjectNPModel> filteredList = new ArrayList<>();

        for (ProjectNPModel item : projectNPModels) {
            if (item.getCreatedOn().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        projectNPAdapter.filterList(filteredList);
    }

    private void filter_created_by(String text){
        ArrayList<ProjectNPModel> filteredList = new ArrayList<>();

        for (ProjectNPModel item : projectNPModels) {
            if (item.getCreatedBy().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        projectNPAdapter.filterList(filteredList);
    }
}
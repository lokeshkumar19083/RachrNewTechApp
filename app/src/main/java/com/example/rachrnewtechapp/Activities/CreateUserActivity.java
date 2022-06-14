
package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.CreateUserModel;
import com.example.rachrnewtechapp.Model.GetUserIdDetails;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.GetUserTypeDataModel;
import com.example.rachrnewtechapp.Model.StatusCreateUser;
import com.example.rachrnewtechapp.Model.StatusResponse;
import com.example.rachrnewtechapp.Model.UserDetailList;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.DatabaseUtil;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class CreateUserActivity extends AppCompatActivity {

    private TextView txt_editUser,txt_username,txt_email,txt_userType,txt_department,txt_reporting,txt_manager,txt_region,
            txt_state,txt_branch_office,txt_address,txt_submit_reg,txt_territory;
    private EditText et_username,et_email,et_department,et_address;
    private LinearLayout ll_nav_icon;
    private Spinner spinner_one,spinner_two,spinner_three,spinner_six,spinner_four,spinner_five;
    private String text_reportingmanager;
    private LinearLayout submitBtn;
    private String username,email,department,address;
    private GetUserListModel getUserListModel;
    private CreateUserModel createUserModel;
    private UserDetailList userDetailList;
    private List<GetUserTypeDataModel> getuserType = new ArrayList<>();
    private List subscriptionsStrings = new ArrayList<>();
    private String deptname;
    private String text_usertype,text_reporting_manager,txt_regionone,txt_stateone,txt_branchone,txt_territoryone;
 //   private List<UserDetailList> userDetailLists;
    private ArrayList<UserDetailList> userDetailLists = new ArrayList<>();
    private StatusResponse statusResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        txt_editUser = (TextView)findViewById(R.id.txt_editUser);
        txt_username = (TextView)findViewById(R.id.txt_username);
        txt_email = (TextView)findViewById(R.id.txt_email);
        txt_userType = (TextView)findViewById(R.id.txt_userType);
        txt_department = (TextView)findViewById(R.id.txt_department);
        txt_reporting = (TextView)findViewById(R.id.txt_reporting);
        txt_manager = (TextView)findViewById(R.id.txt_manager);
        txt_region = (TextView)findViewById(R.id.txt_region);
        txt_state = (TextView)findViewById(R.id.txt_state);
        txt_branch_office = (TextView)findViewById(R.id.txt_branch_office);
        txt_address = (TextView)findViewById(R.id.txt_address);
        txt_territory = (TextView)findViewById(R.id.txt_territory);
        txt_submit_reg = (TextView)findViewById(R.id.txt_submit_reg);

        et_username = (EditText)findViewById(R.id.et_username);
        et_email = (EditText)findViewById(R.id.et_email);
        et_department = (EditText)findViewById(R.id.et_department);
        et_address = (EditText)findViewById(R.id.et_address);


        DatabaseUtil databaseUtil = new DatabaseUtil(getApplicationContext ());
        statusResponse = databaseUtil.fetchStatusData();
        databaseUtil.close ();

        et_department.setText(statusResponse.getDepartmentName());

        spinner_one = (Spinner)findViewById(R.id.spinner_one);
        spinner_two = (Spinner)findViewById(R.id.spinner_two);
        spinner_three = (Spinner)findViewById(R.id.spinner_three);
        spinner_six = (Spinner)findViewById(R.id.spinner_six);
        spinner_four = (Spinner)findViewById(R.id.spinner_four);
        spinner_five = (Spinner)findViewById(R.id.spinner_five);

        submitBtn = (LinearLayout)findViewById(R.id.submitBtn);

        ll_nav_icon = (LinearLayout)findViewById(R.id.ll_nav_icon);

        ll_nav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        new DownloadUsertype().execute();

        FontUtils.changeFont(getApplicationContext(),txt_submit_reg, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_editUser, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_userType, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_reporting, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_manager, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_region, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_state, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_branch_office, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_address, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_submit_reg, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_territory, AppConstant.FONT_SANS_SEMIBOLD);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.reporting,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_two.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this,R.array.regionOne,
                R.layout.spinner_item);
        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_three.setAdapter(adapterTwo);

        spinner_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text_usertype = spinner_one.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_two.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text_reporting_manager = spinner_two.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_three.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txt_regionone = spinner_three.getSelectedItem().toString();
                if (spinner_three.getSelectedItem().toString().trim().equals("North")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.north,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterTwo);
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().trim().equals("East")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.east,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterTwo);
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().trim().equals("West")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.west,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterTwo);
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().trim().equals("South")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.south,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterTwo);
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().trim().equals("Center")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.center,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterTwo);
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().equals("Select")){
                    spinner_six.setEnabled(false);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.center,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterTwo);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_six.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txt_stateone = spinner_six.getSelectedItem().toString();
                if (spinner_six.getSelectedItem().toString().trim().equals("Delhi NCR")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.delhi_ncr,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Punjab")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.Punjab,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Haryana")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.haryana,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Uttarakhand")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.Uttarakhand,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Rajasthan")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.Rajasthan,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Uttar Pradesh")){
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.UttarPradesh,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().equals("Select")){
                    spinner_four.setEnabled(false);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.UttarPradesh,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                }else if (spinner_six.getSelectedItem().toString().equals("West Bengal")){
                    spinner_four.setEnabled(true);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.UttarPradesh,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                }else if (spinner_six.getSelectedItem().toString().equals("Maharashtra")){
                    spinner_four.setEnabled(true);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.Maharashtra,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                }else if (spinner_six.getSelectedItem().toString().equals("Karnataka")){
                    spinner_four.setEnabled(true);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.Karnataka,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                }else if (spinner_six.getSelectedItem().toString().equals("Andhra Pradesh")){
                    spinner_four.setEnabled(true);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.Karnataka,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                }else if (spinner_six.getSelectedItem().toString().equals("Tamil Nadu")){
                    spinner_four.setEnabled(true);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.Karnataka,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                }else if (spinner_six.getSelectedItem().toString().equals("Kerala")){
                    spinner_four.setEnabled(true);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,R.array.Karnataka,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapterThree = ArrayAdapter.createFromResource(this,R.array.territory,
                R.layout.spinner_item);
        adapterThree.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_five.setAdapter(adapterThree);

        FontUtils.changeFont(getApplicationContext(),et_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_address, AppConstant.FONT_SANS_SEMIBOLD);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              username = et_username.getText().toString();
              email = et_email.getText().toString();
              department = et_department.getText().toString();
              address = et_address.getText().toString();

              if (username.isEmpty()){
                  Toast.makeText(CreateUserActivity.this,"Please Enter Username",Toast.LENGTH_SHORT).show();
              }else if (email.isEmpty()){
                  Toast.makeText(CreateUserActivity.this,"Please Enter Email",Toast.LENGTH_SHORT).show();
              }else if (department.isEmpty()){
                  Toast.makeText(CreateUserActivity.this,"Please Enter Department",Toast.LENGTH_SHORT).show();
              }else if (address.isEmpty()){
                  Toast.makeText(CreateUserActivity.this,"Please Enter Address",Toast.LENGTH_SHORT).show();
              }else if (spinner_two.getSelectedItem().toString().trim().equals("Select")){
                  Toast.makeText(CreateUserActivity.this,"Please Select Reporting Manager",Toast.LENGTH_SHORT).show();
              }else if (spinner_three.getSelectedItem().toString().trim().equals("Select")){
                  Toast.makeText(CreateUserActivity.this,"Please Select Region",Toast.LENGTH_SHORT).show();
              }else if (spinner_five.getSelectedItem().toString().trim().equals("Select")){
                  Toast.makeText(CreateUserActivity.this,"Please Select Territory",Toast.LENGTH_SHORT).show();
              }else {
                   /*createUserModel = new CreateUserModel();
                   createUserModel.setUserName(username);
                   createUserModel.setUserEmail(email);*/
                  createUserModel = new CreateUserModel();
                  createUserModel.setUserName(username);
                  createUserModel.setUserEmail(email);
                  createUserModel.setUserType(text_usertype);
                  createUserModel.setActive(true);
                  createUserModel.setDepartmentID("");
                  createUserModel.setContactNumber("");
                  createUserModel.setUserPassword("");
                  createUserModel.setRegion(txt_regionone);
                  createUserModel.setTerritory(txt_territoryone);
                  createUserModel.setCareTaker("");
                  createUserModel.setUserState(txt_stateone);
                  createUserModel.setReporting(text_reporting_manager);
                  createUserModel.setSubDepartment("");
                  createUserModel.setCreatedBy("");

                  userDetailLists =createUserModel.getUserDetailList();
                 for (int i =0; i<userDetailLists.size();i++){
                     userDetailLists.get(i).setFirstName("");
                     userDetailLists.get(i).setMiddleName("");
                     userDetailLists.get(i).setLastName("");
                     userDetailLists.get(i).setCity("");
                     userDetailLists.get(i).setState("");
                     userDetailLists.get(i).setCountry("");
                     userDetailLists.get(i).setAddress(address);
                 }
                 createUserModel.setUserDetailList(userDetailLists);

                 uploadData(createUserModel);

              }
            }
        });

    }



    public class DownloadUsertype extends AsyncTask<Void,Void,List<GetUserTypeDataModel>>{

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

                ArrayAdapter<ArrayList<CharSequence>> adapterTwo = new ArrayAdapter<ArrayList<CharSequence>>(CreateUserActivity.this,R.layout.spinner_item,subscriptionsStrings);
                adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner_one.setAdapter(adapterTwo);
            }

          /*  ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,subscriptionsStrings,
                    R.layout.spinner_item);
            adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spinner_six.setAdapter(adapterTwo);
            spinner_six.setEnabled(true);*/



        }
    }


    public void uploadData(CreateUserModel createUserModel){
        AsyncTask<Void,Void,Void> task = new AsyncTask<Void, Void, Void>() {
            StatusCreateUser statusCreateUser = new StatusCreateUser();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {

                    ApiService service = ApiClient.getApiService();
                    Call<StatusCreateUser> resp = service.createUser(createUserModel);
                    statusCreateUser = resp.execute().body();

                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                Intent intent = new Intent(CreateUserActivity.this,ManageActivity.class);
                startActivity(intent);
            }
        };
        task.execute();
    }


}
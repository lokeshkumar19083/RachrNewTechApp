package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

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

import com.android.volley.toolbox.Volley;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.CreateUserModel;
import com.example.rachrnewtechapp.Model.GetUserIdDetails;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.GetUserTypeDataModel;
import com.example.rachrnewtechapp.Model.StatusCreateUser;
import com.example.rachrnewtechapp.Model.UserDetailList;
import com.example.rachrnewtechapp.Model.UserUpdateModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;

public class EditUserActivity extends AppCompatActivity {
    private GetUserListModel getUserListModel;
    private GetUserIdDetails getUserIdDetails;
    private TextView txt_editUser, txt_username, txt_email, txt_userType, txt_department, txt_reporting, txt_manager, txt_region,
            txt_state, txt_branch_office, txt_address, txt_submit_reg, txt_territory;
    private EditText et_username, et_email, et_department, et_address;
    private LinearLayout ll_nav_icon;
    private Spinner spinner_one, spinner_two, spinner_three, spinner_six, spinner_four, spinner_five;
    private String text_reportingmanager;

    private List<GetUserTypeDataModel> getuserType = new ArrayList<>();
    private List subscriptionsStrings = new ArrayList<>();
    private TextView txt_usertype;
    private LinearLayout submitBtn;
    private UserUpdateModel userUpdateModel;
    private ArrayList<UserDetailList> lists = new ArrayList<>();
    private String username,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        final Intent inte = getIntent();
        getUserListModel = (GetUserListModel) inte.getSerializableExtra("getUserListModel");

        System.out.println("getuserlist::: " + getUserListModel.getId());

        txt_editUser = (TextView) findViewById(R.id.txt_editUser);
        txt_username = (TextView) findViewById(R.id.txt_username);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_userType = (TextView) findViewById(R.id.txt_userType);
        txt_department = (TextView) findViewById(R.id.txt_department);
        txt_reporting = (TextView) findViewById(R.id.txt_reporting);
        txt_manager = (TextView) findViewById(R.id.txt_manager);
        txt_region = (TextView) findViewById(R.id.txt_region);
        txt_state = (TextView) findViewById(R.id.txt_state);
        txt_branch_office = (TextView) findViewById(R.id.txt_branch_office);
        txt_address = (TextView) findViewById(R.id.txt_address);
        txt_territory = (TextView) findViewById(R.id.txt_territory);
        txt_submit_reg = (TextView) findViewById(R.id.txt_submit_reg);

        et_username = (EditText) findViewById(R.id.et_username);
        et_email = (EditText) findViewById(R.id.et_email);
        et_department = (EditText) findViewById(R.id.et_department);
        et_address = (EditText) findViewById(R.id.et_address);

        spinner_one = (Spinner) findViewById(R.id.spinner_one);
        spinner_two = (Spinner) findViewById(R.id.spinner_two);
        spinner_three = (Spinner) findViewById(R.id.spinner_three);
        spinner_six = (Spinner) findViewById(R.id.spinner_six);
        spinner_four = (Spinner) findViewById(R.id.spinner_four);
        spinner_five = (Spinner) findViewById(R.id.spinner_five);

        submitBtn = (LinearLayout)findViewById(R.id.submitBtn);


        ll_nav_icon = (LinearLayout) findViewById(R.id.ll_nav_icon);

        ll_nav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FontUtils.changeFont(getApplicationContext(), txt_submit_reg, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_editUser, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_userType, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_reporting, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_manager, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_region, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_state, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_branch_office, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_address, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_submit_reg, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_territory, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(), et_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_address, AppConstant.FONT_SANS_SEMIBOLD);

    //    new EditUser().execute();


        et_username.setText(getUserListModel.getUserName());
        et_email.setText(getUserListModel.getUserEmail());
        et_department.setText(getUserListModel.getUserDeptName());
        et_address.setText(getUserListModel.getAddress());

        new DownloadUsertype().execute();

        String compareValue = getUserListModel.getReporting();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.reporting, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_two.setAdapter(adapter);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinner_two.setSelection(spinnerPosition);
        }

        String compareValueOne = getUserListModel.getRegion();
        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.regionOne, R.layout.spinner_item);
        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_three.setAdapter(adapterOne);
        if (compareValue != null) {
            int spinnerPosition = adapterOne.getPosition(compareValueOne);
            spinner_three.setSelection(spinnerPosition);
        }

        String compareValueTwo = getUserListModel.getTerritory();
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(EditUserActivity.this,R.array.territory,R.layout.spinner_item);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_five.setAdapter(adapter1);
        if (compareValue != null){
            int spinnerPosition = adapterOne.getPosition(compareValueTwo);
            spinner_five.setSelection(spinnerPosition);
        }

        spinner_three.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_three.getSelectedItem().toString().trim().equals("North")){
                    /*    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(EditUserActivity.this,R.array.north,
                                R.layout.spinner_item);
                        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_six.setAdapter(adapterTwo);
                        spinner_six.setEnabled(true);*/
                    String compareValueOne = getUserListModel.getUserState();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.north, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_six.setSelection(spinnerPosition);
                    }
                    spinner_six.setEnabled(true);

                }else if (spinner_three.getSelectedItem().toString().trim().equals("East")){
                    String compareValueOne = getUserListModel.getUserState();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.east, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_six.setSelection(spinnerPosition);
                    }
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().trim().equals("West")){
                    String compareValueOne = getUserListModel.getUserState();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.west, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_six.setSelection(spinnerPosition);
                    }
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().trim().equals("South")){
                    String compareValueOne = getUserListModel.getUserState();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.south, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_six.setSelection(spinnerPosition);
                    }
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().trim().equals("Center")){
                    String compareValueOne = getUserListModel.getUserState();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.center, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_six.setSelection(spinnerPosition);
                    }
                    spinner_six.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().equals("Select")){
                    spinner_six.setEnabled(false);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(EditUserActivity.this,R.array.center,
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
                if (spinner_six.getSelectedItem().toString().trim().equals("Delhi NCR")){
                    String compareValueOne = getUserListModel.getCareTaker();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.delhi_ncr, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Punjab")){
                    String compareValueOne = getUserListModel.getCareTaker();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.Punjab, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Haryana")){
                    String compareValueOne = getUserListModel.getCareTaker();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.haryana, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Uttarakhand")){
                    String compareValueOne = getUserListModel.getCareTaker();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.Uttarakhand, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Rajasthan")){
                    String compareValueOne = getUserListModel.getCareTaker();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.delhi_ncr, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (spinner_six.getSelectedItem().toString().trim().equals("Uttar Pradesh")){
                    String compareValueOne = getUserListModel.getCareTaker();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.UttarPradesh, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (spinner_three.getSelectedItem().toString().equals("Select")){
                    spinner_four.setEnabled(false);
                    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(EditUserActivity.this,R.array.center,
                            R.layout.spinner_item);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterTwo);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

       submitBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                  userUpdateModel = new UserUpdateModel();
                  userUpdateModel.setId(getUserListModel.getId());
                  userUpdateModel.setUserName(et_username.getText().toString());
                  userUpdateModel.setUserEmail(et_email.getText().toString());
                  userUpdateModel.setUserType(spinner_one.getSelectedItem().toString());
                  userUpdateModel.setActive(getUserListModel.isActive());
                  userUpdateModel.setDepartmentID(getUserListModel.getDepartmentId());
                  userUpdateModel.setContactNumber(getUserListModel.getContactNumber());
                  userUpdateModel.setRegion(spinner_three.getSelectedItem().toString());
                  userUpdateModel.setTerritory(spinner_five.getSelectedItem().toString());
                  userUpdateModel.setCareTaker(spinner_four.getSelectedItem().toString());
                  userUpdateModel.setUserState(spinner_six.getSelectedItem().toString());
                  userUpdateModel.setReporting(spinner_two.getSelectedItem().toString());
                  userUpdateModel.setSubDepartment(getUserListModel.getSubDepartment());
                  userUpdateModel.setModifiedBy(getUserListModel.getModifiedBy());
                  lists = userUpdateModel.getUserDetailList();
                  for (int i = 0;i<lists.size();i++){
                      lists.get(i).setFirstName("");
                      lists.get(i).setMiddleName("");
                      lists.get(i).setLastName("");
                      lists.get(i).setCity("");
                      lists.get(i).setState("");
                      lists.get(i).setCountry("");
                      lists.get(i).setAddress(et_address.getText().toString());
                  }
                  userUpdateModel.setUserDetailList(lists);
                  updateUserData(userUpdateModel);

           }
       });
    }




    private class EditUser extends AsyncTask<Void, Void, GetUserIdDetails> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected GetUserIdDetails doInBackground(Void... voids) {
            ApiService service = ApiClient.getApiService();
            Call<GetUserIdDetails> call = service.editUser(getUserListModel.getId());
            try {
                getUserIdDetails = (GetUserIdDetails) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return getUserIdDetails;
        }

        @Override
        protected void onPostExecute(GetUserIdDetails getUserIdDetails) {
            super.onPostExecute(getUserIdDetails);
            /*   txt_one.setText(getUserIdDetails.getUserName());*/
            et_username.setText(getUserIdDetails.getUserName());
            et_email.setText(getUserIdDetails.getUserEmail());
            et_department.setText(getUserListModel.getUserDeptName());
            et_address.setText(getUserIdDetails.getAddress());

            new DownloadUsertype().execute();

            String compareValue = getUserListModel.getReporting();
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.reporting, R.layout.spinner_item);
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spinner_two.setAdapter(adapter);
            if (compareValue != null) {
                int spinnerPosition = adapter.getPosition(compareValue);
                spinner_two.setSelection(spinnerPosition);
            }

            String compareValueOne = getUserListModel.getRegion();
            ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.regionOne, R.layout.spinner_item);
            adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spinner_three.setAdapter(adapterOne);
            if (compareValue != null) {
                int spinnerPosition = adapterOne.getPosition(compareValueOne);
                spinner_three.setSelection(spinnerPosition);
            }

            String compareValueTwo = getUserListModel.getTerritory();
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(EditUserActivity.this,R.array.territory,R.layout.spinner_item);
            adapter1.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spinner_five.setAdapter(adapter1);
            if (compareValue != null){
                int spinnerPosition = adapterOne.getPosition(compareValueTwo);
                spinner_five.setSelection(spinnerPosition);
            }

            spinner_three.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (spinner_three.getSelectedItem().toString().trim().equals("North")){
                    /*    ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(EditUserActivity.this,R.array.north,
                                R.layout.spinner_item);
                        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_six.setAdapter(adapterTwo);
                        spinner_six.setEnabled(true);*/
                        String compareValueOne = getUserListModel.getUserState();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.north, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_six.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_six.setSelection(spinnerPosition);
                        }
                        spinner_six.setEnabled(true);

                    }else if (spinner_three.getSelectedItem().toString().trim().equals("East")){
                        String compareValueOne = getUserListModel.getUserState();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.east, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_six.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_six.setSelection(spinnerPosition);
                        }
                        spinner_six.setEnabled(true);
                    }else if (spinner_three.getSelectedItem().toString().trim().equals("West")){
                        String compareValueOne = getUserListModel.getUserState();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.west, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_six.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_six.setSelection(spinnerPosition);
                        }
                        spinner_six.setEnabled(true);
                    }else if (spinner_three.getSelectedItem().toString().trim().equals("South")){
                        String compareValueOne = getUserListModel.getUserState();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.south, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_six.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_six.setSelection(spinnerPosition);
                        }
                        spinner_six.setEnabled(true);
                    }else if (spinner_three.getSelectedItem().toString().trim().equals("Center")){
                        String compareValueOne = getUserListModel.getUserState();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.center, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_six.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_six.setSelection(spinnerPosition);
                        }
                        spinner_six.setEnabled(true);
                    }else if (spinner_three.getSelectedItem().toString().equals("Select")){
                        spinner_six.setEnabled(false);
                        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(EditUserActivity.this,R.array.center,
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
                    if (spinner_six.getSelectedItem().toString().trim().equals("Delhi NCR")){
                        String compareValueOne = getUserListModel.getCareTaker();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.delhi_ncr, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_four.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_four.setSelection(spinnerPosition);
                        }
                        spinner_four.setEnabled(true);
                    }else if (spinner_six.getSelectedItem().toString().trim().equals("Punjab")){
                        String compareValueOne = getUserListModel.getCareTaker();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.Punjab, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_four.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_four.setSelection(spinnerPosition);
                        }
                        spinner_four.setEnabled(true);
                    }else if (spinner_six.getSelectedItem().toString().trim().equals("Haryana")){
                        String compareValueOne = getUserListModel.getCareTaker();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.haryana, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_four.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_four.setSelection(spinnerPosition);
                        }
                        spinner_four.setEnabled(true);
                    }else if (spinner_six.getSelectedItem().toString().trim().equals("Uttarakhand")){
                        String compareValueOne = getUserListModel.getCareTaker();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.Uttarakhand, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_four.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_four.setSelection(spinnerPosition);
                        }
                        spinner_four.setEnabled(true);
                    }else if (spinner_six.getSelectedItem().toString().trim().equals("Rajasthan")){
                        String compareValueOne = getUserListModel.getCareTaker();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.delhi_ncr, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_four.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_four.setSelection(spinnerPosition);
                        }
                        spinner_four.setEnabled(true);
                    }else if (spinner_six.getSelectedItem().toString().trim().equals("Uttar Pradesh")){
                        String compareValueOne = getUserListModel.getCareTaker();
                        ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(EditUserActivity.this, R.array.UttarPradesh, R.layout.spinner_item);
                        adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_four.setAdapter(adapterOne);
                        if (compareValueOne != null) {
                            int spinnerPosition = adapterOne.getPosition(compareValueOne);
                            spinner_four.setSelection(spinnerPosition);
                        }
                        spinner_four.setEnabled(true);
                    }else if (spinner_three.getSelectedItem().toString().equals("Select")){
                        spinner_four.setEnabled(false);
                        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(EditUserActivity.this,R.array.center,
                                R.layout.spinner_item);
                        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        spinner_four.setAdapter(adapterTwo);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            /*try {
                spinner_two.setSelection(Integer.parseInt(getUserListModel.getReporting()));
            }catch (NumberFormatException e){
                e.printStackTrace();
            }*/


           /* try {
                text_reportingmanager = getUserListModel.getReporting();
                int i = Integer.parseInt(text_reportingmanager);
                spinner_two.setSelection(i);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }*/

        }
    }

    public class DownloadUsertype extends AsyncTask<Void, Void, List<GetUserTypeDataModel>> {

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

            String compareValue = getUserListModel.getUserType();
            for (int i = 0; i < getuserType.size(); i++) {
                subscriptionsStrings.add(getuserType.get(i).getUserTypeName());

                ArrayAdapter<String> adapterTwo = new ArrayAdapter<String>(EditUserActivity.this, R.layout.spinner_item, subscriptionsStrings);
                adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner_one.setAdapter(adapterTwo);

                if (compareValue != null) {
                    int spinnerPosition = adapterTwo.getPosition(compareValue);
                    spinner_one.setSelection(spinnerPosition);
                }


           /* for (int i=0;i < getuserType.size();i++){
                subscriptionsStrings.add(getuserType.get(i).getUserTypeName());

                ArrayAdapter<ArrayList<CharSequence>> adapterTwo = new ArrayAdapter<ArrayList<CharSequence>>(EditUserActivity.this,R.layout.spinner_item,subscriptionsStrings);
                adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner_one.setAdapter(adapterTwo);

            }*/

          /*  ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(CreateUserActivity.this,subscriptionsStrings,
                    R.layout.spinner_item);
            adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spinner_six.setAdapter(adapterTwo);
            spinner_six.setEnabled(true);*/


            }
        }

    }
    public void updateUserData(UserUpdateModel userUpdateModel){
        AsyncTask<Void,Void,Void> task = new AsyncTask<Void, Void, Void>() {
            boolean statusResponse = true;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {

                    ApiService service = ApiClient.getApiService();
                    Call<Boolean> resp = service.updateUser(userUpdateModel);
                    statusResponse = resp.execute().body();

                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                Intent intent = new Intent(EditUserActivity.this,ManageActivity.class);
                startActivity(intent);

            }
        };
        task.execute();
    }
}
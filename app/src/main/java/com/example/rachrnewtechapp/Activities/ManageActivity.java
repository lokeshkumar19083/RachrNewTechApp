package com.example.rachrnewtechapp.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.ViewGroup;

import com.example.rachrnewtechapp.Adapter.DepartmentFormReceiverAdapter;
import com.example.rachrnewtechapp.Adapter.LevelAdapter;
import com.example.rachrnewtechapp.Adapter.ManageUserAdapter;
import com.example.rachrnewtechapp.Adapter.UserRoleAdapter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.MainActivity;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.GetUserRoleData;
import com.example.rachrnewtechapp.Model.StatusResponse;
import com.example.rachrnewtechapp.Model.UserRoleDepartmentModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.CustomTypeSpanTwo;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;

public class ManageActivity extends AppCompatActivity {
    private TextView txt_manageUser;
    private RecyclerView recyclerView_user,recyclerView_user_role,recyclerView_Form_reciver;
    private LinearLayout ll_user, ll_user_Role, ll__manage_shared;
    private TextView txt_user, txt_user_role, txt_form_reciever, txt_manage_shared;
    private List<GetUserListModel> getUserListModels;
    private List<GetUserRoleData> getUserRoleDataList;
    private List<DepartmentFormReceiverModel> getDepartmentForm;
    private RecyclerView.LayoutManager recyclerviewLayout, recyclerviewlayout_one,recyclerview_two;
    private LinearLayoutManager horizontallayout;
    private ManageUserAdapter manageUserAdapter;
    private TextView txt_add;
    private RelativeLayout rl_user,rl_user_role,rl_form_receiver;
    private UserRoleAdapter userRoleAdapter;
    private EditText edit_search,edit_search_role,edit_search_form_reciver;
    private DepartmentFormReceiverAdapter departmentFormReceiverAdapter;
    private LinearLayout ll_mange_user,ll_mange_user_role,ll_form_reciver_search;
    private RelativeLayout ll_account;
    private LinearLayout ll_nav_icon;
    private LinearLayout ll_create;
    private Spinner spinner_one;
    private Spinner spinner_two;
    private Spinner spinner_three,spinner_four;
    private  String text,textOne;
    private LinearLayout ll_user_one,ll_user_role,ll_form_reciver;
    private TextView txt_create_new_user,txt_create_userrole;
    private LinearLayout ll_create_form_receiver;
    private TextView txt_create_formreciver;
    private LinearLayout ll_account_txt,ll_account_txtone,ll_account_txttwo;
    private TextView text_noofferone;
    private EditText edit_search_two,edit_search_three,edit_search_four;
    private LinearLayout ll_full_layout;
    private GetUserListModel getUserListModelOne;
    private int pos;
    private StatusResponse statusResponse;
    private String deptname;
    private LinearLayout ll_create_role;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);



        txt_manageUser = (TextView) findViewById(R.id.txt_manageUser);
        txt_create_new_user = (TextView)findViewById(R.id.txt_create_new_user);
        txt_create_userrole = (TextView)findViewById(R.id.txt_create_userrole);
        txt_create_formreciver = (TextView)findViewById(R.id.txt_create_formreciver);

        ll_mange_user = (LinearLayout)findViewById(R.id.ll_mange_user);
        ll_mange_user_role = (LinearLayout)findViewById(R.id.ll_mange_user_role);
        ll_form_reciver_search = (LinearLayout)findViewById(R.id.ll_form_reciver_search);
        ll_full_layout = (LinearLayout)findViewById(R.id.ll_full_layout);



        ll_nav_icon = (LinearLayout)findViewById(R.id.ll_nav_icon);
        ll_create = (LinearLayout)findViewById(R.id.ll_create);
        rl_user = (RelativeLayout)findViewById(R.id.rl_user);
        ll_user_one = (LinearLayout)findViewById(R.id.ll_user_one);
        ll_user_role = (LinearLayout)findViewById(R.id.ll_user_role);
        ll_form_reciver = (LinearLayout)findViewById(R.id.ll_form_reciver);
        ll_create_form_receiver = (LinearLayout)findViewById(R.id.ll_create_form_receiver);
        rl_form_receiver = (RelativeLayout)findViewById(R.id.rl_form_reciver);
        edit_search_two = (EditText)findViewById(R.id.edit_search_two);
        edit_search_three = (EditText)findViewById(R.id.edit_search_three);
        edit_search_four = (EditText)findViewById(R.id.edit_search_four);
        ll_create_role = (LinearLayout)findViewById(R.id.ll_create_role);


        ll_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageActivity.this,CreateUserActivity.class);
                startActivity(intent);
            }
        });

        ll_create_role.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageActivity.this,CreateRoleActivity.class);
                startActivity(intent);
            }
        });

        ll_create_form_receiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(ManageActivity.this,CreateDepartmentFormActivity.class);
              startActivity(intent);
            }
        });

        ll_full_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_search.clearFocus();

            }
        });


        ll_account_txt = (LinearLayout)findViewById(R.id.ll_account_txt);
        ll_account_txtone = (LinearLayout)findViewById(R.id.ll_account_txtone);
        ll_account_txttwo = (LinearLayout)findViewById(R.id.ll_account_txttwo);



        recyclerView_user = (RecyclerView)findViewById(R.id.recyclerView_user);
        recyclerView_user_role = (RecyclerView)findViewById(R.id.recyclerView_user_role);
        recyclerView_Form_reciver = (RecyclerView)findViewById(R.id.recyclerView_Form_reciver);

        spinner_one = (Spinner)findViewById(R.id.spinner_one);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.manage_item,
                R.layout.spinner_item_two);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        spinner_one.setAdapter(adapter);


        spinner_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_one.getSelectedItem().toString().trim().equals("User")){
                    ll_user_one.setVisibility(View.VISIBLE);
                    ll_user_role.setVisibility(View.GONE);
                    ll_form_reciver.setVisibility(View.GONE);
                    ll_mange_user.setVisibility(View.VISIBLE);
                    ll_mange_user_role.setVisibility(View.GONE);
                    ll_form_reciver_search.setVisibility(View.GONE);
                    new DownloadGetData().execute();
                }else if (spinner_one.getSelectedItem().toString().trim().equals("User Role Mapping")){
                    ll_user_one.setVisibility(View.GONE);
                    ll_user_role.setVisibility(View.VISIBLE);
                    ll_form_reciver.setVisibility(View.GONE);
                    ll_mange_user.setVisibility(View.GONE);
                    ll_mange_user_role.setVisibility(View.VISIBLE);
                    ll_form_reciver_search.setVisibility(View.GONE);
                    new DownloadGetUserRoleData().execute();
                }else if (spinner_one.getSelectedItem().toString().trim().equals("Form Reciver Config")){
                    ll_user_one.setVisibility(View.GONE);
                    ll_user_role.setVisibility(View.GONE);
                    ll_form_reciver.setVisibility(View.VISIBLE);
                    ll_mange_user.setVisibility(View.GONE);
                    ll_mange_user_role.setVisibility(View.GONE);
                    ll_form_reciver_search.setVisibility(View.VISIBLE);
                    new DownloadFormData().execute();
                }else if (spinner_one.getSelectedItem().toString().trim().equals("Manage Shared Form")){
                    ll_user_one.setVisibility(View.GONE);
                    ll_user_role.setVisibility(View.GONE);
                    ll_form_reciver.setVisibility(View.GONE);
                }else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_two = (Spinner)findViewById(R.id.spinner_two);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this, R.array.itemOne,
                R.layout.spinner_item_two);
        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        spinner_two.setAdapter(adapterTwo);


        spinner_two.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (spinner_two.getSelectedItem().toString().trim().equals("UserName")){
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
               }else if (spinner_two.getSelectedItem().toString().trim().equals("Email")){
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
               }else if (spinner_two.getSelectedItem().toString().equals("UserType")){
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
               }else if (spinner_two.getSelectedItem().toString().equals("Department")){
                   edit_search_two.addTextChangedListener(new TextWatcher() {
                       @Override
                       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                       }

                       @Override
                       public void afterTextChanged(Editable editable) {
                           filterFour(editable.toString());
                       }
                   });
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_three = (Spinner)findViewById(R.id.spinner_three);
        ArrayAdapter<CharSequence> adapterThree = ArrayAdapter.createFromResource(this, R.array.itemTwo,
                R.layout.spinner_item_two);
        adapterThree.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        spinner_three.setAdapter(adapterThree);

        spinner_three.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              if (spinner_three.getSelectedItem().toString().trim().equals("UserName")){
                  edit_search_three.addTextChangedListener(new TextWatcher() {
                      @Override
                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void afterTextChanged(Editable editable) {
                            filterFive(editable.toString());
                      }
                  });
              }else if (spinner_three.getSelectedItem().toString().trim().equals("Department")){
                  edit_search_three.addTextChangedListener(new TextWatcher() {
                      @Override
                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void afterTextChanged(Editable editable) {
                          filterSix(editable.toString());
                      }
                  });
              }else if (spinner_three.getSelectedItem().toString().trim().equals("UserType")){
                  edit_search_three.addTextChangedListener(new TextWatcher() {
                      @Override
                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void afterTextChanged(Editable editable) {
                          filterSeven(editable.toString());
                      }
                  });
              }else if (spinner_three.getSelectedItem().toString().trim().equals("Form Name")){
                  edit_search_three.addTextChangedListener(new TextWatcher() {
                      @Override
                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void afterTextChanged(Editable editable) {
                          filterEight(editable.toString());
                      }
                  });
              }else if (spinner_three.getSelectedItem().toString().equals("CreatedOn")){
                  edit_search_three.addTextChangedListener(new TextWatcher() {
                      @Override
                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void afterTextChanged(Editable editable) {
                          filterNine(editable.toString());
                      }
                  });
              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_four = (Spinner)findViewById(R.id.spinner_four);
        ArrayAdapter<CharSequence> adapterfour = ArrayAdapter.createFromResource(this, R.array.itemThree,
                R.layout.spinner_item_two);
        adapterfour.setDropDownViewResource(R.layout.spinner_dropdown_item_two);
        spinner_four.setAdapter(adapterfour);

        spinner_four.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              if (spinner_four.getSelectedItem().toString().trim().equals("UserName")){
                edit_search_four.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        filterThirteen(editable.toString());
                    }
                });
              }else if (spinner_four.getSelectedItem().toString().trim().equals("Department")){
                  edit_search_four.addTextChangedListener(new TextWatcher() {
                      @Override
                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void afterTextChanged(Editable editable) {
                         filterTen(editable.toString());
                      }
                  });
              }else if (spinner_four.getSelectedItem().toString().trim().equals("Form Name")){
                  edit_search_four.addTextChangedListener(new TextWatcher() {
                      @Override
                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void afterTextChanged(Editable editable) {
                          filterEleven(editable.toString());
                      }
                  });
              }else if (spinner_four.getSelectedItem().toString().trim().equals("Receiving Department")){
                  edit_search_four.addTextChangedListener(new TextWatcher() {
                      @Override
                      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      }

                      @Override
                      public void afterTextChanged(Editable editable) {
                          filterTwelve(editable.toString());
                      }
                  });
              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ll_nav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(ManageActivity.this,MainActivity.class);
              startActivity(intent);
              finish();
            }
        });

        edit_search = (EditText)findViewById(R.id.edit_search);


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
        edit_search_role = (EditText)findViewById(R.id.edit_search_role);
        edit_search_role.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter_userRole(editable.toString());
            }
        });

        edit_search_form_reciver = (EditText)findViewById(R.id.edit_search_form_reciver);
        edit_search_form_reciver.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter_departmentRole(editable.toString());
            }
        });

        FontUtils.changeFont(getApplicationContext(), txt_manageUser, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_create_new_user, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_create_userrole, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_create_formreciver,AppConstant.FONT_SANS_SEMIBOLD);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/VarelaRound-Regular.ttf");
        TypefaceSpan typefaceSpan = new CustomTypeSpanTwo(typeface);
        SpannableString spannableString = new SpannableString("Search");
        spannableString.setSpan(typefaceSpan,0,spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        edit_search.setHint(spannableString);
        edit_search_role.setHint(spannableString);
        edit_search_form_reciver.setHint(spannableString);
        edit_search_two.setHint(spannableString);
        edit_search_three.setHint(spannableString);
        edit_search_four.setHint(spannableString);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public class DownloadGetData extends AsyncTask<Void, Void, List<GetUserListModel>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<GetUserListModel> doInBackground(Void... voids) {
            ApiService service = ApiClient.getApiService();
            Call<List<GetUserListModel>> call = service.getUserList();
            try {
                getUserListModels = (List<GetUserListModel>) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return getUserListModels;
        }

        @Override
        protected void onPostExecute(List<GetUserListModel> getUserListModels) {
            if (getUserListModels.size() == 0){
                ll_account_txt.setVisibility(View.VISIBLE);
                recyclerView_user.setVisibility(View.GONE);
            }else {
                ll_account_txt.setVisibility(View.GONE);
                recyclerviewlayout_one = new LinearLayoutManager(ManageActivity.this);
                recyclerView_user.setLayoutManager(recyclerviewlayout_one);
                manageUserAdapter = new ManageUserAdapter(getApplicationContext(),getUserListModels);
                recyclerView_user.setAdapter(manageUserAdapter);
                manageUserAdapter.notifyDataSetChanged();
            }

        }
    }

    private void filter_user(String text){
        ArrayList<GetUserListModel> filteredList = new ArrayList<>();

        for (GetUserListModel item : getUserListModels) {
            if (item.getUserName().toLowerCase().contains(text.toLowerCase()) || item.getUserEmail().toLowerCase().contains(text.toLowerCase()) || item.getUserType().toLowerCase().contains(text.toLowerCase()) || item.getUserType().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        manageUserAdapter.filterList(filteredList);
    }

    private void filter_userRole(String text){
        ArrayList<GetUserRoleData> filteredList = new ArrayList<>();

        for (GetUserRoleData item : getUserRoleDataList) {
            if (item.getUserName().toLowerCase().contains(text.toLowerCase()) || item.getDepartmentName().toLowerCase().contains(text.toLowerCase()) || item.getUserTypeName().toLowerCase().contains(text.toLowerCase()) || item.getFormName().toLowerCase().contains(text.toLowerCase()) || item.getCreatedOn().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        userRoleAdapter.filterList(filteredList);
    }

    private void filter_departmentRole(String text){
        ArrayList<DepartmentFormReceiverModel> filteredList = new ArrayList<>();

        for (DepartmentFormReceiverModel item : getDepartmentForm) {
            if (item.getUserName().toLowerCase().contains(text.toLowerCase()) || item.getDepartmentName().toLowerCase().contains(text.toLowerCase()) || item.getFormName().toLowerCase().contains(text.toLowerCase()) || item.getReceiverDepartmentName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        departmentFormReceiverAdapter.filterList(filteredList);
    }

    private void filter(String text) {
        ArrayList<GetUserListModel> filteredList = new ArrayList<>();

        for (GetUserListModel item : getUserListModels) {
            if (item.getUserName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        manageUserAdapter.filterList(filteredList);
    }

    private void filterTwo(String text) {
        ArrayList<GetUserListModel> filteredList = new ArrayList<>();

        for (GetUserListModel item : getUserListModels) {
            if (item.getUserEmail().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        manageUserAdapter.filterList(filteredList);
    }

    private void filterThree(String text) {
        ArrayList<GetUserListModel> filteredList = new ArrayList<>();

        for (GetUserListModel item : getUserListModels) {
            if (item.getUserType().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        manageUserAdapter.filterList(filteredList);
    }

    private void filterFour(String text) {
        ArrayList<GetUserListModel> filteredList = new ArrayList<>();

        for (GetUserListModel item : getUserListModels) {
            if (item.getUserDeptName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        manageUserAdapter.filterList(filteredList);
    }

    private void filterFive(String text) {
        ArrayList<GetUserRoleData> filteredList = new ArrayList<>();

        for (GetUserRoleData item : getUserRoleDataList) {
            if (item.getUserName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        userRoleAdapter.filterList(filteredList);
    }


    private void filterSix(String text) {
        ArrayList<GetUserRoleData> filteredList = new ArrayList<>();

        for (GetUserRoleData item : getUserRoleDataList) {
            if (item.getDepartmentName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        userRoleAdapter.filterList(filteredList);
    }

    private void filterSeven(String text) {
        ArrayList<GetUserRoleData> filteredList = new ArrayList<>();

        for (GetUserRoleData item : getUserRoleDataList) {
            if (item.getUserTypeName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        userRoleAdapter.filterList(filteredList);
    }

    private void filterEight(String text) {
        ArrayList<GetUserRoleData> filteredList = new ArrayList<>();

        for (GetUserRoleData item : getUserRoleDataList) {
            if (item.getFormName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        userRoleAdapter.filterList(filteredList);
    }

    private void filterNine(String text) {
        ArrayList<GetUserRoleData> filteredList = new ArrayList<>();

        for (GetUserRoleData item : getUserRoleDataList) {
            if (item.getCreatedOn().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        userRoleAdapter.filterList(filteredList);
    }


    private void filterTen(String text) {
        ArrayList<DepartmentFormReceiverModel> filteredList = new ArrayList<>();

        for (DepartmentFormReceiverModel item : getDepartmentForm) {
            if (item.getDepartmentName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        departmentFormReceiverAdapter.filterList(filteredList);
    }

    private void filterEleven(String text) {
        ArrayList<DepartmentFormReceiverModel> filteredList = new ArrayList<>();

        for (DepartmentFormReceiverModel item : getDepartmentForm) {
            if (item.getFormName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        departmentFormReceiverAdapter.filterList(filteredList);
    }

    private void filterTwelve(String text) {
        ArrayList<DepartmentFormReceiverModel> filteredList = new ArrayList<>();

        for (DepartmentFormReceiverModel item : getDepartmentForm) {
            if (item.getReceiverDepartmentName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        departmentFormReceiverAdapter.filterList(filteredList);
    }

    private void filterThirteen(String text) {
        ArrayList<DepartmentFormReceiverModel> filteredList = new ArrayList<>();

        for (DepartmentFormReceiverModel item : getDepartmentForm) {
            if (item.getUserName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        departmentFormReceiverAdapter.filterList(filteredList);
    }

    public class DownloadGetUserRoleData extends AsyncTask<Void, Void, List<GetUserRoleData>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<GetUserRoleData> doInBackground(Void... voids) {

            ApiService service = ApiClient.getApiService();
            Call<List<GetUserRoleData>> call = service.getUserRoleData();
            try {
                getUserRoleDataList = (List<GetUserRoleData>) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return getUserRoleDataList;
        }

        @Override
        protected void onPostExecute(List<GetUserRoleData> getUserRoleDataList) {
            if (getUserRoleDataList.size() == 0){
                ll_account_txtone.setVisibility(View.VISIBLE);
                recyclerView_user_role.setVisibility(View.GONE);
            }else {
                recyclerviewLayout = new LinearLayoutManager(ManageActivity.this);
                recyclerView_user_role.setLayoutManager(recyclerviewLayout);
                userRoleAdapter = new UserRoleAdapter(getApplicationContext(),getUserRoleDataList);
                recyclerView_user_role.setAdapter(userRoleAdapter);
                userRoleAdapter.notifyDataSetChanged();
            }
        }
    }


    public class DownloadFormData extends AsyncTask<Void, Void, List<DepartmentFormReceiverModel>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<DepartmentFormReceiverModel> doInBackground(Void... voids) {

            ApiService service = ApiClient.getApiService();
            Call<List<DepartmentFormReceiverModel>> call = service.getDepartmentFormDetails();
            try {
                getDepartmentForm = (List<DepartmentFormReceiverModel>) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return getDepartmentForm;

        }

        @Override
        protected void onPostExecute(List<DepartmentFormReceiverModel> getDepartmentForm) {
            if (getDepartmentForm.size() == 0){
                ll_account_txttwo.setVisibility(View.VISIBLE);
                recyclerView_Form_reciver.setVisibility(View.GONE);
            }else {
                recyclerview_two = new LinearLayoutManager(ManageActivity.this);
                recyclerView_Form_reciver.setLayoutManager(recyclerview_two);
                departmentFormReceiverAdapter = new DepartmentFormReceiverAdapter(getApplicationContext(),getDepartmentForm);
                recyclerView_Form_reciver.setAdapter(departmentFormReceiverAdapter);
                departmentFormReceiverAdapter.notifyDataSetChanged();
            }

        }
    }


}
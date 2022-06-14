package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.GetFormDataModel;
import com.example.rachrnewtechapp.Model.GetUserTypeDataModel;
import com.example.rachrnewtechapp.Model.UserRoleDepartmentModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class CreateDepartmentFormActivity extends AppCompatActivity {

    private TextView txt_reciving_department, txt_access_permission, txt_l1, txt_wf_one, txt_fs_one, txt_l2, txt_wf_two, txt_fs_two,
            txt_l3, txt_wf_three, txt_fs_three, txt_l4, txt_wf_four, txt_fs_four, txt_l5, txt_wf_five, txt_fs_five;
    private CheckBox chk_l1, chk_l2, chk_l3, chk_l4, chk_l5;
    private Spinner spinner_one, spinner_two, spinner_three, spinner_four, spinner_five, spinner_six, spinner_seven,
            spinner_eight, spinner_nine, spinner_ten, spinner_eleven,spinner_department;

    private TextView txt_createDepartment, txt_department, txt_forms;
    private Spinner spinner_form;
    private TextView txt_add_form, txt_submit_reg;
    private LinearLayout submitBtn;
    LinearLayout.LayoutParams layoutParams;
    private LinearLayout ll_addForm, ll_addlayout;
    private EditText et_department;
    private List<GetFormDataModel> getFormDataList;
    private List subscriptionsStrings = new ArrayList<>();
    private List subscriptionsStringTwo = new ArrayList<>();
    private LinearLayoutCompat cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_department_form);
        txt_reciving_department = (TextView) findViewById(R.id.txt_reciving_department);
        txt_access_permission = (TextView) findViewById(R.id.txt_access_permission);
        txt_l1 = (TextView) findViewById(R.id.txt_l1);
        txt_wf_one = (TextView) findViewById(R.id.txt_wf_one);
        txt_fs_one = (TextView) findViewById(R.id.txt_fs_one);
        txt_l2 = (TextView) findViewById(R.id.txt_l2);
        txt_wf_two = (TextView) findViewById(R.id.txt_wf_two);
        txt_fs_two = (TextView) findViewById(R.id.txt_fs_two);
        txt_l3 = (TextView) findViewById(R.id.txt_l3);
        txt_wf_three = (TextView) findViewById(R.id.txt_wf_three);
        txt_fs_three = (TextView) findViewById(R.id.txt_fs_three);
        txt_l4 = (TextView) findViewById(R.id.txt_l4);
        txt_wf_four = (TextView) findViewById(R.id.txt_wf_four);
        txt_fs_four = (TextView) findViewById(R.id.txt_fs_four);
        txt_l5 = (TextView) findViewById(R.id.txt_l5);
        txt_wf_five = (TextView) findViewById(R.id.txt_wf_five);
        txt_fs_five = (TextView) findViewById(R.id.txt_fs_five);
        txt_createDepartment = (TextView) findViewById(R.id.txt_createDepartment);
        txt_department = (TextView) findViewById(R.id.txt_department);
        txt_forms = (TextView) findViewById(R.id.txt_forms);
        txt_add_form = (TextView) findViewById(R.id.txt_add_form);
        txt_submit_reg = (TextView) findViewById(R.id.txt_submit_reg);
        ll_addlayout = (LinearLayout) findViewById(R.id.ll_addlayout);
        et_department = (EditText) findViewById(R.id.et_department);
        cards = findViewById(R.id.cards);
        ll_addForm = (LinearLayout) findViewById(R.id.ll_addForm);

        /*ll_addForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CardView newCard = new CardView(CreateDepartmentFormActivity.this);
                getLayoutInflater().inflate(R.layout.editdepartment_adapter, newCard);

                TextView t = newCard.findViewById(R.id.textviewClassesBlock1);

                String current = Character.toString((char));

                t.setText("Block " + current);
                newCard.setTag(current); //

                cards.addView(newCard);
            }
        });*/

        ll_addForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        submitBtn = (LinearLayout) findViewById(R.id.submitBtn);

        chk_l1 = (CheckBox) findViewById(R.id.chk_l1);
        chk_l2 = (CheckBox) findViewById(R.id.chk_l2);
        chk_l3 = (CheckBox) findViewById(R.id.chk_l3);
        chk_l4 = (CheckBox) findViewById(R.id.chk_l4);
        chk_l5 = (CheckBox) findViewById(R.id.chk_l5);


        spinner_one = (Spinner) findViewById(R.id.spinner_one);
        spinner_two = (Spinner) findViewById(R.id.spinner_two);
        spinner_three = (Spinner) findViewById(R.id.spinner_three);
        spinner_four = (Spinner) findViewById(R.id.spinner_four);
        spinner_five = (Spinner) findViewById(R.id.spinner_five);
        spinner_six = (Spinner) findViewById(R.id.spinner_six);
        spinner_seven = (Spinner) findViewById(R.id.spinner_seven);
        spinner_eight = (Spinner) findViewById(R.id.spinner_eight);
        spinner_nine = (Spinner) findViewById(R.id.spinner_nine);
        spinner_ten = (Spinner) findViewById(R.id.spinner_ten);
        spinner_eleven = (Spinner) findViewById(R.id.spinner_eleven);
        spinner_form = (Spinner) findViewById(R.id.spinner_form);
        spinner_department = (Spinner)findViewById(R.id.spinner_department);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.workflow,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_two.setAdapter(adapter);
        spinner_four.setAdapter(adapter);
        spinner_six.setAdapter(adapter);
        spinner_eight.setAdapter(adapter);
        spinner_ten.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this,R.array.flowstatus,
                R.layout.spinner_item);
        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_three.setAdapter(adapterTwo);
        spinner_five.setAdapter(adapterTwo);
        spinner_seven.setAdapter(adapterTwo);
        spinner_nine.setAdapter(adapterTwo);
        spinner_eleven.setAdapter(adapterTwo);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        FontUtils.changeFont(getApplicationContext(), txt_submit_reg, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_reciving_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_access_permission, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l1, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_wf_one, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_fs_one, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l2, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_wf_two, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_fs_two, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l3, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_wf_three, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_fs_three, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l4, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_wf_four, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_fs_four, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_l5, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_fs_five, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_createDepartment, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_forms, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_add_form, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_submit_reg, AppConstant.FONT_SANS_SEMIBOLD);


        new GetFormData().execute();
        new GetDepartmentList().execute();
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

                    ArrayAdapter<ArrayList<CharSequence>> adapterTwo = new ArrayAdapter<ArrayList<CharSequence>>(CreateDepartmentFormActivity.this,R.layout.spinner_item,subscriptionsStringTwo);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_department.setAdapter(adapterTwo);
                }

            }

        }
    }

    public class GetFormData extends AsyncTask<Void, Void, List<GetFormDataModel>> {

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
                if (!subscriptionsStrings.contains(getFormDataList.get(i).getFormName())){
                    subscriptionsStrings.add(getFormDataList.get(i).getFormName());

                    ArrayAdapter<ArrayList<CharSequence>> adapterTwo = new ArrayAdapter<ArrayList<CharSequence>>(CreateDepartmentFormActivity.this,R.layout.spinner_item,subscriptionsStrings);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_form.setAdapter(adapterTwo);
                }
            }
        }
    }



}
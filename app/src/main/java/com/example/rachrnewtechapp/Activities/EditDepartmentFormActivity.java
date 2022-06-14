package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rachrnewtechapp.Adapter.EditDepartmentRecieverAdpter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.EditDepartmentFormWrapper;
import com.example.rachrnewtechapp.Model.GetFormDataModel;
import com.example.rachrnewtechapp.Model.GetUserRoleData;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class EditDepartmentFormActivity extends AppCompatActivity {
    private DepartmentFormReceiverModel departmentFormReceiverModel;
    private TextView txt_editDepartment,txt_department,txt_form;
    private EditText et_department,et_form;
    private Spinner spinner_two,spinner_three;
    private EditDepartmentFormWrapper editDepartmentFormWrapper;
    private RecyclerView recyclerview_editdepartment;
    private RecyclerView.LayoutManager recyclerviewLayout, recyclerviewlayout_one,recyclerview_two;
    private EditDepartmentRecieverAdpter editDepartmentRecieverAdpter;
    private List<GetFormDataModel> getFormDataList;
    private List subscriptionsStrings = new ArrayList<>();
    private List subscriptionsStringTwo = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_department_form);

        final Intent inte = getIntent();
        departmentFormReceiverModel = (DepartmentFormReceiverModel) inte.getSerializableExtra("departmentFormReceiverModel");

        txt_editDepartment = (TextView)findViewById(R.id.txt_editDepartment);
        txt_department = (TextView)findViewById(R.id.txt_department);
        txt_form = (TextView)findViewById(R.id.txt_form);
        recyclerview_editdepartment = (RecyclerView)findViewById(R.id.recyclerview_editdepartment);



        et_department = (EditText)findViewById(R.id.et_department);
        et_form = (EditText)findViewById(R.id.et_form);

        et_department.setText(departmentFormReceiverModel.getDepartmentName());
        et_form.setText(departmentFormReceiverModel.getFormName());

        new GetDepartmentById().execute();


        FontUtils.changeFont(getApplicationContext(), txt_editDepartment, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_form, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_form, AppConstant.FONT_SANS_SEMIBOLD);

    }

    public class GetDepartmentById extends AsyncTask<Void,Void,EditDepartmentFormWrapper>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected EditDepartmentFormWrapper doInBackground(Void... voids) {
            ApiService service = ApiClient.getApiService();
            Call<EditDepartmentFormWrapper> call = service.getDapermentformById(departmentFormReceiverModel.getRecordID());
            try {
                editDepartmentFormWrapper = (EditDepartmentFormWrapper)call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return editDepartmentFormWrapper;
        }

        @Override
        protected void onPostExecute(EditDepartmentFormWrapper editDepartmentFormWrapper) {
           /* recyclerviewLayout = new LinearLayoutManager(EditDepartmentFormActivity.this);
            recyclerview_editdepartment.setLayoutManager(recyclerviewLayout);
            editDepartmentRecieverAdpter = new EditDepartmentRecieverAdpter(editDepartmentFormWrapper,getApplicationContext());
            recyclerview_editdepartment.setAdapter(editDepartmentRecieverAdpter);
            editDepartmentRecieverAdpter.notifyDataSetChanged();*/
            new GetDepartmentList().execute();

        }
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
            /*for (int i=0;i < getFormDataList.size();i++){
                if (!subscriptionsStringTwo.contains(getFormDataList.get(i).getDepartmentName())){
                    subscriptionsStringTwo.add(getFormDataList.get(i).getDepartmentName());

                    ArrayAdapter<ArrayList<CharSequence>> adapterTwo = new ArrayAdapter<ArrayList<CharSequence>>(CreateDepartmentFormActivity.this,R.layout.spinner_item,subscriptionsStringTwo);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_one.setAdapter(adapterTwo);
                }

            }*/

            recyclerviewLayout = new LinearLayoutManager(EditDepartmentFormActivity.this);
            recyclerview_editdepartment.setLayoutManager(recyclerviewLayout);
            editDepartmentRecieverAdpter = new EditDepartmentRecieverAdpter(editDepartmentFormWrapper,getApplicationContext(),getFormDataModels);
            recyclerview_editdepartment.setAdapter(editDepartmentRecieverAdpter);
            editDepartmentRecieverAdpter.notifyDataSetChanged();
        }
    }

}
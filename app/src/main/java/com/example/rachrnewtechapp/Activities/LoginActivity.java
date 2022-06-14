package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rachrnewtechapp.Adapter.UserRoleAdapter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.MainActivity;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.GetUserRoleData;
import com.example.rachrnewtechapp.Model.GetUserTypeDataModel;
import com.example.rachrnewtechapp.Model.StatusResponse;
import com.example.rachrnewtechapp.Model.UserDto;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.CustomTypeSpanTwo;
import com.example.rachrnewtechapp.Utils.CustomTypefaceSpan;
import com.example.rachrnewtechapp.Utils.DatabaseUtil;
import com.example.rachrnewtechapp.Utils.FontUtils;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class LoginActivity extends AppCompatActivity {
    private EditText et_name,et_password;
    private Spinner spinner;
    private LinearLayout btn_submit;
    private String username,password;
    private List<String> rout_list;
    private  String text;
    private TextView txt_submit_reg;
    private UserDto userDto;
    private TextView text1;
    private List<GetUserTypeDataModel> getUserTypeDataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_name = (EditText)findViewById(R.id.et_name);
        et_password = (EditText)findViewById(R.id.et_password);
        spinner = (Spinner)findViewById(R.id.spinner_one);
        btn_submit = (LinearLayout)findViewById(R.id.submitBtn);
        txt_submit_reg = (TextView)findViewById(R.id.txt_submit_reg);

        /*
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/VarelaRound-Regular.ttf");
        TypefaceSpan typefaceSpan = new CustomTypeSpanTwo(typeface);
        SpannableString spannableString = new SpannableString("UserName");
        spannableString.setSpan(typefaceSpan,0,spannableString.length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        et_name.setHint(spannableString);

        Typeface typefaceTwo = Typeface.createFromAsset(getAssets(),"font/VarelaRound-Regular.ttf");
        TypefaceSpan typefaceSpanTwo = new CustomTypeSpanTwo(typefaceTwo);
        SpannableString spannableStringTwo = new SpannableString("Password");
        spannableString.setSpan(typefaceSpanTwo,0,spannableString.length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        et_password.setHint(spannableStringTwo);*/


        FontUtils.changeFont(getApplicationContext(),txt_submit_reg, AppConstant.FONT_SANS_SEMIBOLD);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.reading_position,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 username = et_name.getText().toString();
                 password = et_password.getText().toString();


               if (spinner.getSelectedItem().toString().trim().equals("Select")){
                   Toast.makeText(LoginActivity.this,"Please Select UserType",Toast.LENGTH_SHORT).show();
               }else if (username.isEmpty()){
                   Toast.makeText(LoginActivity.this,"Please Enter Username",Toast.LENGTH_SHORT).show();
               }else if (password.isEmpty()){
                   Toast.makeText(LoginActivity.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
               }else {
                   userDto = new UserDto();
                   userDto.setUserName(username);
                   userDto.setPassword(password);
                   userDto.setUserType(text);

                   uploadData(userDto);

               }
            }
        });
    }

        public void uploadData(UserDto userDto){
        AsyncTask<Void,Void,Void> task = new AsyncTask<Void, Void, Void>() {
            StatusResponse response = new StatusResponse();
            ProgressDialog dialog = new ProgressDialog(LoginActivity.this,R.style.AlertDialogColor);

            @Override
            protected void onPreExecute() {
                dialog = new ProgressDialog(LoginActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setCancelable(false);
                dialog.setIndeterminate(true);
                dialog.show();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {

                    ApiService service = ApiClient.getApiService();
                    Call<StatusResponse> resp = service.uploadRegistationDetails (userDto);
                    response = resp.execute().body();

                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                final DatabaseUtil db = new DatabaseUtil(getApplicationContext ());
                final long ret = db.saveDeviceRegistationDetails (userDto);
                final long ret1 = db.saveStatusResponse(response);
                db.close();
                if(ret>0 && ret1>0) {
                    finish();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"Failed to insert Data",Toast.LENGTH_SHORT).show();
                }
            }
        };
        task.execute();
        }
}
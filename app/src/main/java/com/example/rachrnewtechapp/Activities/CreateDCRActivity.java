package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.StatusResponse;
import com.example.rachrnewtechapp.Model.UserDto;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Utils.DatabaseUtil;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class CreateDCRActivity extends AppCompatActivity {
    private TextView txt_Create_dcr,txt_username,txt_name,txt_territory,txt_date,txt_week_year,txt_add_form;
    private EditText et_username,et_territory,et_date,et_week_year;
    private LinearLayout ll_addForm;
    private LinearLayout ll_nav_icon;
    private StatusResponse userDto;

    private LinearLayout parentRelativeLayout;
    private ViewGroup.LayoutParams params;
    private int count = 1;
    CardView experienceInfoActivityFormCardVw;
    boolean expanded = true;
    private LinearLayout ll_layout,ll_drop_down;
    private TextView txt_userType,txt_class,txt_customer_class,busineename,industry,txt_address,txt_location,txt_state,
            txt_district,txt_concered_person,txt_contactno,txt_customer_typeone,txt_designation,txt_departmentone,txt_emailone,
            txt_reasonofvisit,busineename_new,industry_new,txt_address_new,txt_location_new,txt_state_new,txt_district_new,txt_concered_person_new,
            txt_contactno_new,txt_visit_report,txt_customer_typeone_two,txt_designation_two,txt_departmentone_two,txt_emailone_two,txt_project_Deadline,
            txt_floor_type,txt_floor_area,txt_select_contact_manager,txt_manager,name,contact_no,txt_email_one,txt_deadline;

    private Spinner spinner_one,spinner_two,spinner_three,spinner_four,spinner_five,spinner_six,spinner_seven,spinner_eight,spinner_nine,spinner_ten,spinner_eleven,spinner_twelve,spinner_thirteen,spinner_fourteen;
    private EditText et_business_name,et_address,et_location,et_concerned_person,et_contact_no,et_desination, et_emailone,et_business_name_new,et_address_new,
            et_location_new,et_concerned_person_new,et_contact_no_new,et_desinationone,et_emailone_two,et_deadline,et_floor_type,et_floor_area,et_name,et_contact_no_two,et_email_one,et_projectdeadline;
    private CardView card_view,card_viewOne,card_three,card_four;
    private LinearLayout ll_prospect,ll_non_prospect,ll_customer_class,ll_new;
    private LinearLayout ll_layout_existing,ll_full,ll_deadline,ll_createdfg;


    private CheckBox check_one,check_two,check_three;
    private LinearLayout ll_manager;
    private String selectedDistrict, selectedState;
    private ArrayAdapter<CharSequence> stateAdapter, districtAdapter;
    private LinearLayout ll_savebtn;
    private TextView txt_save;
    private LinearLayout ll_full_expanadable,ll_drop_down_expanadable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dcr_layout);
        txt_Create_dcr = (TextView)findViewById(R.id.txt_create_dcr);
        txt_username = (TextView)findViewById(R.id.txt_username);
        txt_name = (TextView)findViewById(R.id.txt_name);
        txt_territory = (TextView)findViewById(R.id.txt_territory);
        txt_date = (TextView)findViewById(R.id.txt_date);
        txt_week_year = (TextView)findViewById(R.id.txt_week_year);
        txt_add_form = (TextView)findViewById(R.id.txt_add_form);
        et_username = (EditText) findViewById(R.id.et_username);
        et_territory = (EditText)findViewById(R.id.et_territory);
        et_date = (EditText)findViewById(R.id.et_date);
        et_week_year = (EditText)findViewById(R.id.et_week_year);
        experienceInfoActivityFormCardVw = findViewById(R.id.experienceInfoActivityFormCardVw);

        params = experienceInfoActivityFormCardVw.getLayoutParams();
        ll_drop_down = (LinearLayout)findViewById(R.id.ll_drop_down);
        ll_full = (LinearLayout)findViewById(R.id.ll_full);
        //     ll_layout = (LinearLayout)findViewById(R.id.ll_layout);

        txt_userType = (TextView)findViewById(R.id.txt_userType);
        txt_class = (TextView)findViewById(R.id.txt_class);
        txt_customer_class = (TextView)findViewById(R.id.txt_customer_class);
        busineename = (TextView)findViewById(R.id.busineename);
        industry = (TextView)findViewById(R.id.industry);
        txt_address = (TextView)findViewById(R.id.txt_address);
        txt_location = (TextView)findViewById(R.id.txt_location);
        txt_state = (TextView)findViewById(R.id.txt_state);
        txt_district = (TextView)findViewById(R.id.txt_district);
        txt_concered_person = (TextView)findViewById(R.id.txt_concered_person);
        txt_contactno = (TextView)findViewById(R.id.txt_contactno);
        txt_customer_typeone = (TextView)findViewById(R.id.txt_customer_typeone);
        txt_designation = (TextView)findViewById(R.id.txt_designation);
        txt_departmentone = (TextView)findViewById(R.id.txt_departmentone);
        txt_emailone = (TextView)findViewById(R.id.txt_emailone);
        txt_reasonofvisit = (TextView)findViewById(R.id.txt_reasonofvisit);
        busineename_new = (TextView)findViewById(R.id.busineename_new);
        industry_new = (TextView)findViewById(R.id.industry_new);
        txt_address_new = (TextView)findViewById(R.id.txt_address_new);
        txt_location_new = (TextView)findViewById(R.id.txt_location_new);
        txt_state_new = (TextView)findViewById(R.id.txt_state_new);
        txt_district_new = (TextView)findViewById(R.id.txt_district_new);
        txt_concered_person_new = (TextView)findViewById(R.id.txt_concered_person_new);
        txt_contactno_new = (TextView)findViewById(R.id.txt_contactno_new);
        txt_visit_report = (TextView)findViewById(R.id.txt_visit_report);
        txt_customer_typeone_two = (TextView)findViewById(R.id.txt_customer_typeone_two);
        txt_designation_two = (TextView)findViewById(R.id.txt_designation_two);
        txt_departmentone_two = (TextView)findViewById(R.id.txt_departmentone_two);
        txt_emailone_two = (TextView)findViewById(R.id.txt_emailone_two);
        txt_project_Deadline = (TextView)findViewById(R.id.txt_project_Deadline);
        txt_floor_type = (TextView)findViewById(R.id.txt_floor_type);
        txt_floor_area = (TextView)findViewById(R.id.txt_floor_area);
        txt_select_contact_manager = (TextView)findViewById(R.id.txt_select_contact_manager);
        txt_manager = (TextView)findViewById(R.id.txt_manager);
        name = (TextView)findViewById(R.id.name);
        contact_no = (TextView)findViewById(R.id.contact_no);
        txt_email_one = (TextView)findViewById(R.id.txt_email_one);
        txt_deadline = (TextView)findViewById(R.id.txt_deadline);
        et_projectdeadline = (EditText)findViewById(R.id.et_projectdeadline);
        txt_save = (TextView)findViewById(R.id.txt_save);
        ll_savebtn = (LinearLayout)findViewById(R.id.ll_savebtn);



        spinner_one = (Spinner)findViewById(R.id.spinner_one);
        spinner_two = (Spinner)findViewById(R.id.spinner_two);
        spinner_three = (Spinner)findViewById(R.id.spinner_three);
        spinner_four = (Spinner)findViewById(R.id.spinner_four);
        spinner_five = (Spinner)findViewById(R.id.spinner_five);
        spinner_six = (Spinner)findViewById(R.id.spinner_six);
        spinner_seven = (Spinner)findViewById(R.id.spinner_seven);
        spinner_eight = (Spinner)findViewById(R.id.spinner_eight);
        spinner_nine = (Spinner)findViewById(R.id.spinner_nine);
        spinner_ten = (Spinner)findViewById(R.id.spinner_ten);
        spinner_eleven = (Spinner)findViewById(R.id.spinner_eleven);
        spinner_twelve = (Spinner)findViewById(R.id.spinner_twelve);
        spinner_thirteen = (Spinner)findViewById(R.id.spinner_thirteen);
        spinner_fourteen = (Spinner)findViewById(R.id.spinner_fourteen);

        et_business_name = (EditText)findViewById(R.id.et_business_name);
        et_address = (EditText)findViewById(R.id.et_address);
        et_location = (EditText)findViewById(R.id.et_location);
        et_concerned_person = (EditText)findViewById(R.id.et_concerned_person);
        et_contact_no = (EditText)findViewById(R.id.et_contact_no);
        et_desination = (EditText)findViewById(R.id.et_desination);
        et_emailone = (EditText)findViewById(R.id.et_emailone);
        et_business_name_new = (EditText)findViewById(R.id.et_business_name_new);
        et_address_new = (EditText)findViewById(R.id.et_address_new);
        et_location_new = (EditText)findViewById(R.id.et_location_new);
        et_concerned_person_new = (EditText)findViewById(R.id.et_concerned_person_new);
        et_contact_no_new = (EditText)findViewById(R.id.et_contact_no_new);
        et_desinationone = (EditText)findViewById(R.id.et_desinationone);
        et_emailone_two = (EditText)findViewById(R.id.et_emailone_two);
        et_deadline = (EditText)findViewById(R.id.et_deadline);
        et_floor_type = (EditText)findViewById(R.id.et_floor_type);
        et_floor_area = (EditText)findViewById(R.id.et_floor_area);
        et_name = (EditText)findViewById(R.id.et_name);
        et_contact_no_two = (EditText)findViewById(R.id.et_contact_no_two);
        et_email_one = (EditText)findViewById(R.id.et_email_one);

        ll_layout_existing = (LinearLayout)findViewById(R.id.ll_layout_existing);
        ll_new = (LinearLayout)findViewById(R.id.ll_new);
        ll_deadline = (LinearLayout)findViewById(R.id.ll_deadline);
        ll_prospect = (LinearLayout)findViewById(R.id.ll_prospect);
        ll_non_prospect = (LinearLayout)findViewById(R.id.ll_non_prospect);
        ll_createdfg = (LinearLayout)findViewById(R.id.ll_createdfg);

        check_one = (CheckBox)findViewById(R.id.check_one);
        check_two = (CheckBox)findViewById(R.id.check_two);
        check_three = (CheckBox)findViewById(R.id.check_three);

        ll_manager = (LinearLayout)findViewById(R.id.ll_manager);


        TransitionManager.beginDelayedTransition(ll_full, new AutoTransition());
        ll_full.setVisibility(View.GONE);

        ll_drop_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (ll_full.getVisibility() == View.VISIBLE){
                  // The transition of the hiddenView is carried out
                  //  by the TransitionManager class.
                  // Here we use an object of the AutoTransition
                  // Class to create a default transition.
                  TransitionManager.beginDelayedTransition(ll_full,
                          new AutoTransition());
                  ll_full.setVisibility(View.GONE);
              }else {
                  TransitionManager.beginDelayedTransition(ll_full,
                          new AutoTransition());
                  ll_full.setVisibility(View.VISIBLE);

              }
            }
        });

        initViews();
        initListeners();

        DatabaseUtil databaseUtil = new DatabaseUtil(getApplicationContext ());
        userDto = databaseUtil.fetchStatusData();
        databaseUtil.close ();

        et_username.setText("" + userDto.getUserName());
        et_territory.setText("" + userDto.getTerritory());

        txt_save = (TextView)findViewById(R.id.txt_save);



        ArrayAdapter<CharSequence> adapterEleven = ArrayAdapter.createFromResource(this,R.array.array_indian_states,
                R.layout.spinner_item);
        adapterEleven.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_four.setAdapter(adapterEleven);

       spinner_four.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

               selectedState = spinner_four.getSelectedItem().toString();
               int parentID = adapterView.getId();

               if (parentID == R.id.spinner_four){
                   switch (selectedState){
                       case "Select Your State": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_default_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Andhra Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_andhra_pradesh_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Arunachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_arunachal_pradesh_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Assam": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_assam_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Bihar": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_bihar_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Chhattisgarh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_chhattisgarh_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Goa": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_goa_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Gujarat": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_gujarat_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Haryana": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_haryana_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Himachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_himachal_pradesh_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Jharkhand": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_jharkhand_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Karnataka": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_karnataka_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       break;


                       case "Kerala": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_kerala_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Madhya Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_madhya_pradesh_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Maharashtra": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_maharashtra_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Manipur": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_manipur_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Meghalaya": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_meghalaya_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Mizoram": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_mizoram_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Nagaland": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_nagaland_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Odisha": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_odisha_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Punjab": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_punjab_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Rajasthan": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_rajasthan_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Sikkim": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_sikkim_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Tamil Nadu": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_tamil_nadu_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;

                       case "Telangana": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_telangana_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Tripura": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_tripura_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Uttar Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_uttar_pradesh_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Uttarakhand": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_uttarakhand_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "West Bengal": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_west_bengal_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Andaman and Nicobar Islands": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_andaman_nicobar_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Chandigarh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_chandigarh_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Dadra and Nagar Haveli": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_dadra_nagar_haveli_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Daman and Diu": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_daman_diu_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Delhi": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_delhi_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Jammu and Kashmir": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_jammu_kashmir_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Lakshadweep": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_lakshadweep_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Ladakh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_ladakh_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       case "Puducherry": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                               R.array.array_puducherry_districts, R.layout.spinner_item);
                           districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                           break;
                       default:  break;
                   }
             //      districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   spinner_five.setAdapter(districtAdapter);

                   spinner_five.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                       @Override
                       public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                           selectedDistrict = spinner_five.getSelectedItem().toString();
                       }

                       @Override
                       public void onNothingSelected(AdapterView<?> adapterView) {

                       }
                   });
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });


        ArrayAdapter<CharSequence> adaptertwelve = ArrayAdapter.createFromResource(this,R.array.array_indian_states,
                R.layout.spinner_item);
        adaptertwelve.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_ten.setAdapter(adaptertwelve);



        spinner_ten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedState = spinner_ten.getSelectedItem().toString();
                int parentID = adapterView.getId();

                if (parentID == R.id.spinner_ten){
                    switch (selectedState){
                        case "Select Your State": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_default_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Andhra Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_andhra_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Arunachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_arunachal_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Assam": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_assam_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Bihar": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_bihar_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Chhattisgarh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_chhattisgarh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Goa": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_goa_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Gujarat": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_gujarat_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Haryana": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_haryana_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Himachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_himachal_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Jharkhand": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_jharkhand_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Karnataka": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_karnataka_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Kerala": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_kerala_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Madhya Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_madhya_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Maharashtra": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_maharashtra_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Manipur": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_manipur_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Meghalaya": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_meghalaya_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Mizoram": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_mizoram_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Nagaland": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_nagaland_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Odisha": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_odisha_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Punjab": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_punjab_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Rajasthan": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_rajasthan_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Sikkim": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_sikkim_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Tamil Nadu": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_tamil_nadu_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Telangana": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_telangana_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Tripura": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_tripura_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Uttar Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_uttar_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Uttarakhand": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_uttarakhand_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "West Bengal": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_west_bengal_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Andaman and Nicobar Islands": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_andaman_nicobar_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Chandigarh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_chandigarh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Dadra and Nagar Haveli": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_dadra_nagar_haveli_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Daman and Diu": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_daman_diu_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Delhi": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_delhi_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Jammu and Kashmir": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_jammu_kashmir_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Lakshadweep": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_lakshadweep_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Ladakh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_ladakh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Puducherry": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_puducherry_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        default:  break;
                    }
                    //      districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_eleven.setAdapter(districtAdapter);

                    spinner_eleven.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedDistrict = spinner_eleven.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.customer_class,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_one.setAdapter(adapter);

        spinner_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (spinner_one.getSelectedItem().toString().equals("Existing")){
                     ll_layout_existing.setVisibility(View.VISIBLE);
                     ll_new.setVisibility(View.GONE);
                     ll_drop_down.setVisibility(View.VISIBLE);
               }else if (spinner_one.getSelectedItem().toString().equals("New")){
                   ll_new.setVisibility(View.VISIBLE);
                   ll_layout_existing.setVisibility(View.GONE);
                   ll_drop_down.setVisibility(View.VISIBLE);
               }else if (spinner_one.getSelectedItem().toString().equals("Select")){
                   ll_new.setVisibility(View.GONE);
                   ll_layout_existing.setVisibility(View.GONE);
                   ll_drop_down.setVisibility(View.GONE);
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this,R.array.industry,
                R.layout.spinner_item);
        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_three.setAdapter(adapterTwo);

        spinner_three.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapterThree = ArrayAdapter.createFromResource(this,R.array.industry,
                R.layout.spinner_item);
        adapterThree.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_nine.setAdapter(adapterTwo);

        spinner_three.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapterFour = ArrayAdapter.createFromResource(this,R.array.customer_type,
                R.layout.spinner_item);
        adapterFour.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_six.setAdapter(adapterFour);

        spinner_six.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_six.getSelectedItem().toString().equals("Select")){
                    ll_deadline.setVisibility(View.GONE);
                }else if (spinner_six.getSelectedItem().toString().equals("New Project")){
                    ll_deadline.setVisibility(View.VISIBLE);
                    txt_deadline.setText("Project Deadline");

                    final Calendar calendar = Calendar.getInstance();

                    final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            //       String myFormat = "MM/dd/yy"; //In which you need put here
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                            et_projectdeadline.setText(sdf.format(calendar.getTime()));
                        }
                    };

                    et_projectdeadline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new DatePickerDialog(CreateDCRActivity.this,dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                        }
                    });

                }else if (spinner_six.getSelectedItem().toString().equals("Maintenance Project")){
                    ll_deadline.setVisibility(View.VISIBLE);
                    txt_deadline.setText("Project Deadline");

                    final Calendar calendar = Calendar.getInstance();

                    final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            //       String myFormat = "MM/dd/yy"; //In which you need put here
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                            et_projectdeadline.setText(sdf.format(calendar.getTime()));
                        }
                    };

                    et_projectdeadline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new DatePickerDialog(CreateDCRActivity.this,dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                        }
                    });


                }else if (spinner_six.getSelectedItem().toString().equals("Application Partner")){
                    ll_deadline.setVisibility(View.VISIBLE);
                    txt_deadline.setText("Deadline for AGI");

                    final Calendar calendar = Calendar.getInstance();

                    final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            //       String myFormat = "MM/dd/yy"; //In which you need put here
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                            et_projectdeadline.setText(sdf.format(calendar.getTime()));
                        }
                    };

                    et_projectdeadline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new DatePickerDialog(CreateDCRActivity.this,dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> adapterFive = ArrayAdapter.createFromResource(this,R.array.choose_department,
                R.layout.spinner_item);
        adapterFive.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_seven.setAdapter(adapterFive);

        spinner_seven.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> adapterSix = ArrayAdapter.createFromResource(this,R.array.reason_of_visit,
                R.layout.spinner_item);
        adapterSix.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_eight.setAdapter(adapterSix);

        spinner_eight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> adapterseven = ArrayAdapter.createFromResource(this,R.array.visit_report,
                R.layout.spinner_item);
        adapterseven.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_twelve.setAdapter(adapterseven);

        spinner_twelve.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              if (spinner_twelve.getSelectedItem().toString().equals("Select")){
                  ll_prospect.setVisibility(View.GONE);
                  ll_non_prospect.setVisibility(View.GONE);
              }else if (spinner_twelve.getSelectedItem().toString().equals("Prospect")){
                  ll_prospect.setVisibility(View.VISIBLE);
                  ll_non_prospect.setVisibility(View.GONE);
              }else if (spinner_twelve.getSelectedItem().toString().equals("Non-Prospect")){
                  ll_prospect.setVisibility(View.GONE);
                  ll_non_prospect.setVisibility(View.VISIBLE);
              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        final Calendar calendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                //       String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                et_date.setText(sdf.format(calendar.getTime()));
            }
        };

        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CreateDCRActivity.this,dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ArrayAdapter<CharSequence> adapternine = ArrayAdapter.createFromResource(this,R.array.customer_type,
                R.layout.spinner_item);
        adapternine.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_thirteen.setAdapter(adapternine);

        spinner_thirteen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_thirteen.getSelectedItem().toString().equals("Select")){
                    ll_createdfg.setVisibility(View.GONE);
                }else if (spinner_thirteen.getSelectedItem().toString().equals("New Project")){
                    ll_createdfg.setVisibility(View.VISIBLE);
                    txt_project_Deadline.setText("Project Deadline");

                    final Calendar calendar = Calendar.getInstance();

                    final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            //       String myFormat = "MM/dd/yy"; //In which you need put here
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                            et_deadline.setText(sdf.format(calendar.getTime()));
                        }
                    };

                    et_deadline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new DatePickerDialog(CreateDCRActivity.this,dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                        }
                    });

                }else if (spinner_thirteen.getSelectedItem().toString().equals("Maintenance Project")){
                    ll_createdfg.setVisibility(View.VISIBLE);
                    txt_project_Deadline.setText("Project Deadline");

                    final Calendar calendar = Calendar.getInstance();

                    final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            //       String myFormat = "MM/dd/yy"; //In which you need put here
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                            et_deadline.setText(sdf.format(calendar.getTime()));
                        }
                    };

                    et_deadline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new DatePickerDialog(CreateDCRActivity.this,dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                        }
                    });


                }else if (spinner_thirteen.getSelectedItem().toString().equals("Application Partner")){
                    ll_createdfg.setVisibility(View.VISIBLE);
                    txt_project_Deadline.setText("Deadline for AGI");

                    final Calendar calendar = Calendar.getInstance();

                    final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            //       String myFormat = "MM/dd/yy"; //In which you need put here
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                            et_deadline.setText(sdf.format(calendar.getTime()));
                        }
                    };

                    et_deadline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new DatePickerDialog(CreateDCRActivity.this,dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
/*
        if (check_one.isChecked()){
            ll_manager.setVisibility(View.VISIBLE);
            txt_manager.setText("Purchase Manager");
        }else if (check_two.isChecked()){
            ll_manager.setVisibility(View.VISIBLE);
            txt_manager.setText("Maintaenace Manager");
        }else if (check_three.isChecked()){
            ll_manager.setVisibility(View.VISIBLE);
            txt_manager.setText("Civil Manager");
        }else{
            ll_manager.setVisibility(View.GONE);
        }*/

        ArrayAdapter<CharSequence> adapterTen = ArrayAdapter.createFromResource(this,R.array.choose_department,
                R.layout.spinner_item);
        adapterTen.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_fourteen.setAdapter(adapterTen);

        spinner_fourteen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ll_manager.setVisibility(View.GONE);


        check_one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ll_manager.setVisibility(View.VISIBLE);
                    txt_manager.setText("Purchase Manager");

                }else {
                    ll_manager.setVisibility(View.GONE);
                }
            }
        });

        check_two.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ll_manager.setVisibility(View.VISIBLE);
                    txt_manager.setText("Maintaenace Manager");
                }else {
                    ll_manager.setVisibility(View.GONE);
                }
            }
        });


        check_three.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ll_manager.setVisibility(View.VISIBLE);
                    txt_manager.setText("Civil Manager");
                }else {
                    ll_manager.setVisibility(View.GONE);
                }
            }
        });


        ll_addForm = (LinearLayout)findViewById(R.id.ll_addForm);
        ll_nav_icon = (LinearLayout)findViewById(R.id.ll_nav_icon);



        FontUtils.changeFont(getApplicationContext(), txt_Create_dcr, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_name, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_territory, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_date, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_week_year, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_add_form, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_username, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_territory, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_date, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_week_year, AppConstant.FONT_SANS_SEMIBOLD);

         FontUtils.changeFont(getApplicationContext(), txt_userType, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_class, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_customer_class, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), busineename, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), industry, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_address, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_location, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_state, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_district, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_concered_person, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_contactno, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_customer_typeone, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_designation, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_departmentone, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_emailone, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_reasonofvisit, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), busineename_new, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), industry_new, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_address_new, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_location_new, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_state_new, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), txt_district_new, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_concered_person_new,AppConstant.FONT_SANS_SEMIBOLD);


         FontUtils.changeFont(getApplicationContext(), txt_contactno_new, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_visit_report, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_customer_typeone_two, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_designation_two, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_departmentone_two, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_emailone_two, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_project_Deadline, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_floor_type, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_floor_area, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_select_contact_manager, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), txt_manager, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), name, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), contact_no, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(), et_contact_no_two, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_email_one,AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_email_one,AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),et_business_name,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_address,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_location,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_concerned_person,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_contact_no,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_desination,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_business_name_new,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_address_new,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_location_new,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_concerned_person_new,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_contact_no_new,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_desinationone,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_emailone_two,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_deadline,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_floor_type,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_floor_area,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_name,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_email_one,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_projectdeadline,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_deadline,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_save,AppConstant.FONT_SANS_SEMIBOLD);



      /*   FontUtils.changeFont(getApplicationContext(), et_email_one, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), et_customer_type, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), et_designation, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), et_department, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), et_email, AppConstant.FONT_SANS_SEMIBOLD);
         FontUtils.changeFont(getApplicationContext(), et_reasonVisit, AppConstant.FONT_SANS_SEMIBOLD);*/


        ll_addForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onAddField(view);

            }
        });

        ll_nav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initListeners() {

    }

    private void initViews() {

        parentRelativeLayout = (LinearLayout) findViewById(R.id.experienceDetailsInfoRelLayout);
    }

    public void onAddField(View view) {
        try{
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View rowView = inflater.inflate(R.layout.expanadable_create_dcr, null);
            rowView.setLayoutParams(params);
            parentRelativeLayout.addView(rowView, parentRelativeLayout.getChildCount());
           /* EditText employerNameEditText = rowView.findViewById(R.id.employerNameEditText);
            employerNameEditText.requestFocus();*/


            ll_drop_down_expanadable = (LinearLayout)rowView.findViewById(R.id.ll_drop_down_expanadable);
            ll_full_expanadable = (LinearLayout)rowView.findViewById(R.id.ll_full_expanadable);


            txt_userType = (TextView)rowView.findViewById(R.id.txt_userType);
            txt_class = (TextView)rowView.findViewById(R.id.txt_class);
            txt_customer_class = (TextView)rowView.findViewById(R.id.txt_customer_class);
            busineename = (TextView)rowView.findViewById(R.id.busineename);
            industry = (TextView)rowView.findViewById(R.id.industry);
            txt_address = (TextView)rowView.findViewById(R.id.txt_address);
            txt_location = (TextView)rowView.findViewById(R.id.txt_location);
            txt_state = (TextView)rowView.findViewById(R.id.txt_state);
            txt_district = (TextView)rowView.findViewById(R.id.txt_district);
            txt_concered_person = (TextView)rowView.findViewById(R.id.txt_concered_person);
            txt_contactno = (TextView)rowView.findViewById(R.id.txt_contactno);
            txt_customer_typeone = (TextView)rowView.findViewById(R.id.txt_customer_typeone);
            txt_designation = (TextView)rowView.findViewById(R.id.txt_designation);
            txt_departmentone = (TextView)rowView.findViewById(R.id.txt_departmentone);
            txt_emailone = (TextView)rowView.findViewById(R.id.txt_emailone);
            txt_reasonofvisit = (TextView)rowView.findViewById(R.id.txt_reasonofvisit);
            busineename_new = (TextView)findViewById(R.id.busineename_new);
            industry_new = (TextView)rowView.findViewById(R.id.industry_new);
            txt_address_new = (TextView)rowView.findViewById(R.id.txt_address_new);
            txt_location_new = (TextView)rowView.findViewById(R.id.txt_location_new);
            txt_state_new = (TextView)rowView.findViewById(R.id.txt_state_new);
            txt_district_new = (TextView)rowView.findViewById(R.id.txt_district_new);
            txt_concered_person_new = (TextView)rowView.findViewById(R.id.txt_concered_person_new);
            txt_contactno_new = (TextView)rowView.findViewById(R.id.txt_contactno_new);
            txt_visit_report = (TextView)rowView.findViewById(R.id.txt_visit_report);
            txt_customer_typeone_two = (TextView)rowView.findViewById(R.id.txt_customer_typeone_two);
            txt_designation_two = (TextView)rowView.findViewById(R.id.txt_designation_two);
            txt_departmentone_two = (TextView)rowView.findViewById(R.id.txt_departmentone_two);
            txt_emailone_two = (TextView)rowView.findViewById(R.id.txt_emailone_two);
            txt_project_Deadline = (TextView)rowView.findViewById(R.id.txt_project_Deadline);
            txt_floor_type = (TextView)rowView.findViewById(R.id.txt_floor_type);
            txt_floor_area = (TextView)rowView.findViewById(R.id.txt_floor_area);
            txt_select_contact_manager = (TextView)rowView.findViewById(R.id.txt_select_contact_manager);
            txt_manager = (TextView)rowView.findViewById(R.id.txt_manager);
            name = (TextView)rowView.findViewById(R.id.name);
            contact_no = (TextView)rowView.findViewById(R.id.contact_no);
            txt_email_one = (TextView)rowView.findViewById(R.id.txt_email_one);
            txt_deadline = (TextView)rowView.findViewById(R.id.txt_deadline);
            et_projectdeadline = (EditText)rowView.findViewById(R.id.et_projectdeadline);
            txt_save = (TextView)rowView.findViewById(R.id.txt_save);
            ll_savebtn = (LinearLayout)rowView.findViewById(R.id.ll_savebtn);



            spinner_one = (Spinner)rowView.findViewById(R.id.spinner_one);
            spinner_two = (Spinner)rowView.findViewById(R.id.spinner_two);
            spinner_three = (Spinner)rowView.findViewById(R.id.spinner_three);
            spinner_four = (Spinner)rowView.findViewById(R.id.spinner_four);
            spinner_five = (Spinner)rowView.findViewById(R.id.spinner_five);
            spinner_six = (Spinner)rowView.findViewById(R.id.spinner_six);
            spinner_seven = (Spinner)rowView.findViewById(R.id.spinner_seven);
            spinner_eight = (Spinner)rowView.findViewById(R.id.spinner_eight);
            spinner_nine = (Spinner)rowView.findViewById(R.id.spinner_nine);
            spinner_ten = (Spinner)rowView.findViewById(R.id.spinner_ten);
            spinner_eleven = (Spinner)rowView.findViewById(R.id.spinner_eleven);
            spinner_twelve = (Spinner)rowView.findViewById(R.id.spinner_twelve);
            spinner_thirteen = (Spinner)rowView.findViewById(R.id.spinner_thirteen);
            spinner_fourteen = (Spinner)rowView.findViewById(R.id.spinner_fourteen);

            et_business_name = (EditText)rowView.findViewById(R.id.et_business_name);
            et_address = (EditText)rowView.findViewById(R.id.et_address);
            et_location = (EditText)rowView.findViewById(R.id.et_location);
            et_concerned_person = (EditText)rowView.findViewById(R.id.et_concerned_person);
            et_contact_no = (EditText)rowView.findViewById(R.id.et_contact_no);
            et_desination = (EditText)rowView.findViewById(R.id.et_desination);
            et_emailone = (EditText)rowView.findViewById(R.id.et_emailone);
            et_business_name_new = (EditText)rowView.findViewById(R.id.et_business_name_new);
            et_address_new = (EditText)rowView.findViewById(R.id.et_address_new);
            et_location_new = (EditText)rowView.findViewById(R.id.et_location_new);
            et_concerned_person_new = (EditText)rowView.findViewById(R.id.et_concerned_person_new);
            et_contact_no_new = (EditText)rowView.findViewById(R.id.et_contact_no_new);
            et_desinationone = (EditText)rowView.findViewById(R.id.et_desinationone);
            et_emailone_two = (EditText)rowView.findViewById(R.id.et_emailone_two);
            et_deadline = (EditText)rowView.findViewById(R.id.et_deadline);
            et_floor_type = (EditText)rowView.findViewById(R.id.et_floor_type);
            et_floor_area = (EditText)rowView.findViewById(R.id.et_floor_area);
            et_name = (EditText)rowView.findViewById(R.id.et_name);
            et_contact_no_two = (EditText)rowView.findViewById(R.id.et_contact_no_two);
            et_email_one = (EditText)rowView.findViewById(R.id.et_email_one);

            ll_layout_existing = (LinearLayout)rowView.findViewById(R.id.ll_layout_existing);
            ll_new = (LinearLayout)rowView.findViewById(R.id.ll_new);
            ll_deadline = (LinearLayout)rowView.findViewById(R.id.ll_deadline);
            ll_prospect = (LinearLayout)rowView.findViewById(R.id.ll_prospect);
            ll_non_prospect = (LinearLayout)rowView.findViewById(R.id.ll_non_prospect);
            ll_createdfg = (LinearLayout)rowView.findViewById(R.id.ll_createdfg);

            check_one = (CheckBox)rowView.findViewById(R.id.check_one);
            check_two = (CheckBox)rowView.findViewById(R.id.check_two);
            check_three = (CheckBox)rowView.findViewById(R.id.check_three);

            ll_manager = (LinearLayout)rowView.findViewById(R.id.ll_manager);
            ll_drop_down.setVisibility(View.VISIBLE);


            TransitionManager.beginDelayedTransition(ll_full_expanadable,
                    new AutoTransition());
            ll_full_expanadable.setVisibility(View.GONE);

            ll_drop_down_expanadable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ll_full_expanadable.getVisibility() == View.VISIBLE){
                        // The transition of the hiddenView is carried out
                        //  by the TransitionManager class.
                        // Here we use an object of the AutoTransition
                        // Class to create a default transition.
                        TransitionManager.beginDelayedTransition(ll_full_expanadable,
                                new AutoTransition());
                        ll_full_expanadable.setVisibility(View.GONE);
                    }else {
                        TransitionManager.beginDelayedTransition(ll_full_expanadable,
                                new AutoTransition());
                        ll_full_expanadable.setVisibility(View.VISIBLE);

                    }
                }
            });
            count++;
        }catch (Exception e){
            e.printStackTrace();
        }



        ArrayAdapter<CharSequence> adapterEleven = ArrayAdapter.createFromResource(this,R.array.array_indian_states,
                R.layout.spinner_item);
        adapterEleven.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_four.setAdapter(adapterEleven);

        spinner_four.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedState = spinner_four.getSelectedItem().toString();
                int parentID = adapterView.getId();

                if (parentID == R.id.spinner_four){
                    switch (selectedState){
                        case "Select Your State": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_default_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Andhra Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_andhra_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Arunachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_arunachal_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Assam": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_assam_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Bihar": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_bihar_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Chhattisgarh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_chhattisgarh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Goa": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_goa_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Gujarat": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_gujarat_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Haryana": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_haryana_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Himachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_himachal_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Jharkhand": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_jharkhand_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Karnataka": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_karnataka_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;


                        case "Kerala": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_kerala_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Madhya Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_madhya_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Maharashtra": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_maharashtra_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Manipur": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_manipur_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Meghalaya": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_meghalaya_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Mizoram": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_mizoram_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Nagaland": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_nagaland_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Odisha": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_odisha_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Punjab": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_punjab_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Rajasthan": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_rajasthan_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Sikkim": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_sikkim_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Tamil Nadu": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_tamil_nadu_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;

                        case "Telangana": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_telangana_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Tripura": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_tripura_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Uttar Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_uttar_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Uttarakhand": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_uttarakhand_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "West Bengal": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_west_bengal_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Andaman and Nicobar Islands": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_andaman_nicobar_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Chandigarh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_chandigarh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Dadra and Nagar Haveli": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_dadra_nagar_haveli_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Daman and Diu": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_daman_diu_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Delhi": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_delhi_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Jammu and Kashmir": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_jammu_kashmir_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Lakshadweep": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_lakshadweep_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Ladakh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_ladakh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        case "Puducherry": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_puducherry_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            break;
                        default:  break;
                    }
                    //      districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_five.setAdapter(districtAdapter);

                    spinner_five.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedDistrict = spinner_five.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.customer_class,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_one.setAdapter(adapter);

        spinner_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner_one.getSelectedItem().toString().equals("Existing")){
                    ll_layout_existing.setVisibility(View.VISIBLE);
                    ll_new.setVisibility(View.GONE);
                    ll_drop_down.setVisibility(View.VISIBLE);
                }else if (spinner_one.getSelectedItem().toString().equals("New")){
                    ll_new.setVisibility(View.VISIBLE);
                    ll_layout_existing.setVisibility(View.GONE);
                    ll_drop_down.setVisibility(View.VISIBLE);
                }else if (spinner_one.getSelectedItem().toString().equals("Select")){
                    ll_new.setVisibility(View.GONE);
                    ll_layout_existing.setVisibility(View.GONE);
                    ll_drop_down.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



}
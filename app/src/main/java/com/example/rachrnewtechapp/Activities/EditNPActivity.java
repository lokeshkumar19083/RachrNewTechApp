package com.example.rachrnewtechapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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

import com.example.rachrnewtechapp.Adapter.RemarksAdapter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.AddREDetailTwo;
import com.example.rachrnewtechapp.Model.FormHistoryDataTwo;
import com.example.rachrnewtechapp.Model.ProjectNPModel;
import com.example.rachrnewtechapp.Model.ProjectNpModelTwo;
import com.example.rachrnewtechapp.Model.UpdateNpModel;
import com.example.rachrnewtechapp.Model.UserUpdateModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class EditNPActivity extends AppCompatActivity {

    private ProjectNPModel projectNPModel;
    private TextView txt_create_project_site,txt_np,txt_project_status,txt_deadline,txt_submit_reg;
    private EditText et_project_status,et_deadline;
    private LinearLayout ll_fill,ll_fill_out_sampling,ll_fill_out_inspection_details,ll_fill_out_negotiation_details;
    private TextView txt_fill_out,txt_fill_out_sampling,txt_fill_out_inspecion_details,txt_fill_out_negotiation_details;
    private TextView txt_form_reference_no,txt_customer_type,txt_business_name,txt_territory,txt_industry_segment,txt_state,txt_address,txt_district,txt_location,txt_decision_maker,txt_designation,txt_email,txt_department,txt_contactno;
    private EditText et_form_reference_no,et_business_name,et_territory,et_industry_segment,et_address,et_distrct,
            et_location,et_decision_maker,et_designation,et_email,et_department,et_contact_no;
    private LinearLayout ll_layout_general_info,ll_recycler,ll_layout_fill_out_inspection_details;
    private RecyclerView recyclerview;
    private List<ProjectNpModelTwo> projectNpModelTwos;
    private RemarksAdapter remarksAdapter;
    private RecyclerView.LayoutManager recyclerviewLayout, recyclerviewlayout_one,recyclerview_two;
    private ProjectNpModelTwo projectNpModelTwo;
    private TextView txt_sample_aprover,txt_sampling_designation,txt_contact_no,txt_email_sampling,txt,txt_sampling_required;
    private EditText et_sample_approver,et_sampling_desigation,et_sample_contact_no,et_sampling_email,et_sampling_departmnet;
    private TextView txt_negotaiation_person,txt_negotiation_designation,txt_negotiation_contact,txt_email_negotiation,txt_department_negotiation,txt_order_status;
    private EditText et_negotiation_person,et_negotiation_designation,et_negotiation_contact_no,et_negotiation_email,et_negotiation_departmnet;

    private LinearLayout ll_layout_fill_out_negotiation_details,ll_confirmed,ll_lost,ll_layout_fill_out_samplig_details;
    private TextView txt_order_value,txt_competitor_name,txt_price,txt_project,txt_decision_maker_site_assesment,txt_project_decision_designation,txt_sampling_contact,txt_sampling_email,txt_department_Sampling;
    private EditText et_order_value,et_competitor_name,et_price,et_desicion_making_details,et_designation_sampling_details,et_contact_sampling,et_email_sampling,et_department_Sampling;
    private TextView txt_date,txt_week;
    private EditText et_date,et_week;
    private LinearLayout ll_general_info_site,ll_general_info,ll_floor_check,ll_joint_check;
    private TextView txt_floor_area_one,txt_floor_type,txt_specify,txt_general_info,txt_permission;
    private EditText et_floor_area,et_floor_type,et_specify;
    private TextView txt_concrete_floor_strength,txt_floor_hardner,txt_soundness_of_floor,txt_scratching_surface,txt_problem_with_soundness_floor,txt_check_of_moisture,txt_cracks_pits,txt_impurities_of_floor,txt_floor_undulution,txt_attach_image,txt_link;
    private EditText et_concrete_floor_strength,et_if_yes,et_problem_with_soundness_floor,
            et_check_of_moisture;
    private LinearLayout ll_ifyes,ll_problem_with_soundness,ll_floor_checks,ll_covings,ll_coving;
    private TextView txt_coving,txt_height,txt_coving_current_status,txt_attach_image_coving;
    private EditText et_height;
    private TextView txt_create_new_user,txt_wf;
    private TextView txt_expansion_joints,txt_width,txt_depth,txt_expansion_joints_current_status,txt_attach_image_expansion_image,et_image,
            txt_construction_joints,txt_width_construction,txt_depth_construction,txt_construction_joints_current_status,
            txt_attach_image_construction_image,et_image_construction;
    private EditText et_width_mm,et_depth_cms,
            et_width_construction,et_depth_construction;
    private LinearLayout ll_joint_checks;
    private Spinner spinner_one_customer_type,spinner_state,spinner_district,spinner_one_order_status;
    private String selectedDistrict, selectedState;

    private ArrayAdapter<CharSequence> stateAdapter, districtAdapter;
    private String comparevalueThree;
    private Spinner spinner_one_floor_type,spinner_one_floor_hardner,spinner_one_problem_soundness,spinner_scratching_surface,spinner_one_cracks_pot;
    private LinearLayout ll_specifyOne;
    private TextView txt_if_yes;
    private Spinner spinner_impurities_onfloor,spinner_floor_undulation,spinner_movementonthefloor;
    private Spinner spinner_expasion_joints,spinner_expasion_joints_current_status;
    private LinearLayout ll_expansion_joints,ll_construction_joints;
    private Spinner spinner_construction_joints,spinner_construction_current_status;
    private Spinner spinner_coving,spinner_coving_current_status;
    private LinearLayout ll_layout_coving;
    private Spinner spinner_sampling_required;
    private LinearLayout ll_sample_required;
    private TextView txt_sampling_details,txt_sampling_applicator,txt_sample_approver_name,txt_sampling_contact_no;
    private TextView txt_sample_feedback,txt_sample_apprval_status,txt_sampling_rating,txt_attach_primer_image,
            txt_screed_image,txt_attch_imageone,txt_attch_imageTwo,txt_attach_topcoat,txt_attach_;
    private EditText et_sample_approver_name,et_sampling_approver_contact_no;
    private Spinner spinner_sample_approval_status,spinner_sample_rating;
    private LinearLayout submitBtn;
    private UpdateNpModel updateNpModel;
    private String text_customer_type,txt_sampliningrequired,txt_sample_approval_status,txt_spinner_sample_rating;
    private String txt_order_stus,txt_floor_type_selection,spiiner_floor_hardener,txt_spinner_soundness_floor;
    private String txt_scraching_surface,txt_crackspot,txt_floor_undulation,movementOnFloor,expansionJoints;
    private String expansioJointCurrentStatus,constructionJoints,constructionJointsCurrentStatus,coving,covingCurrentStatus;
    private ArrayList<AddREDetailTwo> addREDetail;
    private FormHistoryDataTwo formHistoryDataTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_npactivity);

        final Intent inte = getIntent();
        projectNPModel = (ProjectNPModel) inte.getSerializableExtra("projectNPModel");

        txt_create_project_site = (TextView)findViewById(R.id.txt_create_project_site);
        txt_np = (TextView)findViewById(R.id.txt_np);
        txt_project_status = (TextView)findViewById(R.id.txt_project_status);
        txt_deadline = (TextView)findViewById(R.id.txt_deadline);
        txt_submit_reg = (TextView)findViewById(R.id.txt_submit_reg);
        et_project_status = (EditText)findViewById(R.id.et_project_status);
        et_deadline = (EditText)findViewById(R.id.et_deadline);
        ll_fill = (LinearLayout)findViewById(R.id.ll_fill);
        ll_fill_out_sampling = (LinearLayout)findViewById(R.id.ll_fill_out_sampling);
        ll_fill_out_inspection_details = (LinearLayout)findViewById(R.id.ll_fill_out_inspection_details);
        ll_fill_out_negotiation_details = (LinearLayout)findViewById(R.id.ll_fill_out_negotiation_details);
        ll_recycler = (LinearLayout)findViewById(R.id.ll_recycler);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);

        ll_layout_fill_out_inspection_details = (LinearLayout)findViewById(R.id.ll_layout_fill_out_inspection_details);
        ll_layout_fill_out_negotiation_details = (LinearLayout)findViewById(R.id.ll_layout_fill_out_negotiation_details);
        ll_confirmed = (LinearLayout)findViewById(R.id.ll_confirmed);
        ll_lost = (LinearLayout)findViewById(R.id.ll_lost);
        ll_layout_fill_out_samplig_details = (LinearLayout)findViewById(R.id.ll_layout_fill_out_samplig_details);
        ll_joint_check = (LinearLayout)findViewById(R.id.ll_joint_check);

        ll_ifyes = (LinearLayout)findViewById(R.id.ll_ifyes);
        ll_problem_with_soundness = (LinearLayout)findViewById(R.id.ll_problem_with_soundness);

        ll_sample_required = (LinearLayout)findViewById(R.id.ll_sample_required);





        txt_fill_out = (TextView)findViewById(R.id.txt_fill_out);
        txt_fill_out_sampling = (TextView)findViewById(R.id.txt_fill_out_sampling);
        txt_fill_out_inspecion_details = (TextView)findViewById(R.id.txt_fill_out_inspecion_details);
        txt_fill_out_negotiation_details = (TextView)findViewById(R.id.txt_fill_out_negotiation_details);

        txt_if_yes = (TextView)findViewById(R.id.txt_if_yes);

        txt_form_reference_no = (TextView)findViewById(R.id.txt_form_reference_no);
        txt_customer_type = (TextView)findViewById(R.id.txt_customer_type);
        txt_business_name = (TextView)findViewById(R.id.txt_business_name);
        txt_territory = (TextView)findViewById(R.id.txt_territory);
        txt_industry_segment = (TextView)findViewById(R.id.txt_industry_segment);
        txt_state = (TextView)findViewById(R.id.txt_state);
        txt_address = (TextView)findViewById(R.id.txt_address);
        txt_district = (TextView)findViewById(R.id.txt_district);
        txt_location = (TextView)findViewById(R.id.txt_location);
        txt_decision_maker = (TextView)findViewById(R.id.txt_decision_maker);
        txt_designation = (TextView)findViewById(R.id.txt_designation);
        txt_email = (TextView)findViewById(R.id.txt_email);
        txt_department = (TextView)findViewById(R.id.txt_department);
        txt_contactno = (TextView)findViewById(R.id.txt_contactno);
        txt_wf = (TextView)findViewById(R.id.txt_wf);

        txt_sample_aprover = (TextView)findViewById(R.id.txt_sample_aprover);
        txt_sampling_designation = (TextView)findViewById(R.id.txt_sampling_designation);
        txt_contact_no = (TextView)findViewById(R.id.txt_contact_no);
        txt_email_sampling = (TextView)findViewById(R.id.txt_email_sampling);
        txt = (TextView)findViewById(R.id.txt);
        txt_sampling_required = (TextView)findViewById(R.id.txt_sampling_required);

        et_sample_approver = (EditText)findViewById(R.id.et_sample_approver);
        et_sampling_desigation = (EditText)findViewById(R.id.et_sampling_desigation);
        et_sample_contact_no = (EditText)findViewById(R.id.et_sample_contact_no);
        et_sampling_email = (EditText)findViewById(R.id.et_sampling_email);
        et_sampling_departmnet = (EditText)findViewById(R.id.et_sampling_departmnet);
   //     et_sampling_required = (EditText)findViewById(R.id.et_sampling_required);





        et_form_reference_no = (EditText)findViewById(R.id.et_form_reference_no);

        et_business_name = (EditText)findViewById(R.id.et_business_name);
        et_territory = (EditText)findViewById(R.id.et_territory);
        et_industry_segment = (EditText)findViewById(R.id.et_industry_segment);
        et_address = (EditText)findViewById(R.id.et_address);
        et_distrct = (EditText)findViewById(R.id.et_distrct);
        et_location = (EditText)findViewById(R.id.et_location);
        et_decision_maker = (EditText)findViewById(R.id.et_decision_maker);
        et_designation = (EditText)findViewById(R.id.et_designation);
        et_email = (EditText)findViewById(R.id.et_email);
        et_department = (EditText)findViewById(R.id.et_department);
        et_contact_no = (EditText)findViewById(R.id.et_contact_no);

        txt_negotaiation_person = (TextView)findViewById(R.id.txt_negotaiation_person);
        txt_negotiation_designation = (TextView)findViewById(R.id.txt_negotiation_designation);
        txt_negotiation_contact = (TextView)findViewById(R.id.txt_negotiation_contact);
        txt_email_negotiation = (TextView)findViewById(R.id.txt_email_negotiation);
        txt_department_negotiation = (TextView)findViewById(R.id.txt_department_negotiation);
        txt_order_status = (TextView)findViewById(R.id.txt_order_status);
        txt_order_value = (TextView)findViewById(R.id.txt_order_value);
        txt_competitor_name = (TextView)findViewById(R.id.txt_competitor_name);
        txt_price = (TextView)findViewById(R.id.txt_price);
        txt_project = (TextView)findViewById(R.id.txt_project);
        txt_decision_maker_site_assesment = (TextView)findViewById(R.id.txt_decision_maker_site_assesment);
        txt_project_decision_designation = (TextView)findViewById(R.id.txt_project_decision_designation);
        txt_sampling_contact = (TextView)findViewById(R.id.txt_sampling_contact);
        txt_sampling_email = (TextView)findViewById(R.id.txt_sampling_email);
        txt_department_Sampling = (TextView)findViewById(R.id.txt_department_Sampling);
        txt_date = (TextView)findViewById(R.id.txt_date);
        txt_week = (TextView)findViewById(R.id.txt_week);
        et_date = (EditText)findViewById(R.id.et_date);
        et_week = (EditText)findViewById(R.id.et_week);

        ll_expansion_joints = (LinearLayout)findViewById(R.id.ll_expansion_joints);
        ll_construction_joints = (LinearLayout)findViewById(R.id.ll_construction_joints);


        spinner_one_customer_type = (Spinner) findViewById(R.id.spinner_one_customer_type);

        spinner_state = (Spinner)findViewById(R.id.spinner_state);
        spinner_district = (Spinner)findViewById(R.id.spinner_district);

        spinner_one_order_status = (Spinner)findViewById(R.id.spinner_one_order_status);

        spinner_one_floor_type = (Spinner)findViewById(R.id.spinner_one_floor_type);

        spinner_one_floor_hardner = (Spinner)findViewById(R.id.spinner_one_floor_hardner);

        spinner_one_cracks_pot = (Spinner)findViewById(R.id.spinner_one_cracks_pot);


        submitBtn = (LinearLayout)findViewById(R.id.submitBtn);





        et_negotiation_person = (EditText)findViewById(R.id.et_negotiation_person);
        et_negotiation_designation = (EditText)findViewById(R.id.et_negotiation_designation);
        et_negotiation_contact_no = (EditText)findViewById(R.id.et_negotiation_contact_no);
        et_negotiation_email = (EditText)findViewById(R.id.et_negotiation_email);
        et_negotiation_departmnet = (EditText)findViewById(R.id.et_negotiation_departmnet);
  //      et_order_status = (EditText) findViewById(R.id.et_order_status);
        et_order_value = (EditText)findViewById(R.id.et_order_value);
        et_competitor_name = (EditText)findViewById(R.id.et_competitor_name);
        et_price = (EditText)findViewById(R.id.et_price);
        et_desicion_making_details = (EditText)findViewById(R.id.et_desicion_making_details);
        et_designation_sampling_details = (EditText)findViewById(R.id.et_designation_sampling_details);
        et_contact_sampling = (EditText)findViewById(R.id.et_contact_sampling);
        et_email_sampling = (EditText)findViewById(R.id.et_email_sampling);
        et_department_Sampling = (EditText)findViewById(R.id.et_department_Sampling);


        ll_layout_general_info = (LinearLayout)findViewById(R.id.ll_layout_general_info);
        ll_floor_checks = (LinearLayout)findViewById(R.id.ll_floor_checks);


        ll_general_info = (LinearLayout)findViewById(R.id.ll_general_info);
        ll_general_info_site = (LinearLayout)findViewById(R.id.ll_general_info_site);
        txt_floor_area_one = (TextView)findViewById(R.id.txt_floor_area_one);
        txt_floor_type = (TextView)findViewById(R.id.txt_floor_type);
        txt_specify = (TextView)findViewById(R.id.txt_specify);
        txt_general_info = (TextView)findViewById(R.id.txt_general_info);
        txt_create_new_user = (TextView)findViewById(R.id.txt_create_new_user);



        ll_floor_check = (LinearLayout)findViewById(R.id.ll_floor_check);
        txt_permission = (TextView)findViewById(R.id.txt_permission);

        txt_concrete_floor_strength = (TextView)findViewById(R.id.txt_concrete_floor_strength);
        txt_floor_hardner = (TextView)findViewById(R.id.txt_floor_hardner);
        txt_soundness_of_floor = (TextView)findViewById(R.id.txt_soundness_of_floor);
        txt_scratching_surface = (TextView)findViewById(R.id.txt_scratching_surface);
        txt_problem_with_soundness_floor = (TextView)findViewById(R.id.txt_problem_with_soundness_floor);
        txt_check_of_moisture = (TextView)findViewById(R.id.txt_check_of_moisture);
        txt_cracks_pits = (TextView)findViewById(R.id.txt_cracks_pits);
        txt_impurities_of_floor = (TextView)findViewById(R.id.txt_impurities_of_floor);
        txt_floor_undulution = (TextView)findViewById(R.id.txt_floor_undulution);
        txt_attach_image = (TextView)findViewById(R.id.txt_attach_image);
        txt_link = (TextView)findViewById(R.id.txt_link);

        ll_covings = (LinearLayout)findViewById(R.id.ll_covings);
        ll_coving = (LinearLayout)findViewById(R.id.ll_coving);
        txt_coving = (TextView)findViewById(R.id.txt_coving);
        txt_height = (TextView)findViewById(R.id.txt_height);
        txt_coving_current_status = (TextView)findViewById(R.id.txt_coving_current_status);
        txt_attach_image_coving = (TextView)findViewById(R.id.txt_attach_image_coving);
    //    et_covings = (EditText) findViewById(R.id.et_covings);
        et_height = (EditText)findViewById(R.id.et_height);
    //    et_coving_current_status = (EditText)findViewById(R.id.et_coving_current_status);

        ll_joint_checks = (LinearLayout)findViewById(R.id.ll_joint_checks);



        et_floor_area = (EditText)findViewById(R.id.et_floor_area);
        et_floor_type = (EditText)findViewById(R.id.et_floor_type);
        et_specify = (EditText)findViewById(R.id.et_specify);

        et_concrete_floor_strength = (EditText) findViewById(R.id.et_concrete_floor_strength);
    //    et_floor_hardener = (EditText)findViewById(R.id.et_floor_hardener);
        et_if_yes = (EditText)findViewById(R.id.et_if_yes);

        et_problem_with_soundness_floor = (EditText)findViewById(R.id.et_problem_with_soundness_floor);
        et_check_of_moisture = (EditText)findViewById(R.id.et_check_of_moisture);
  //      et_cracks_pits = (EditText)findViewById(R.id.et_cracks_pits);
  //      et_check_of_ = (EditText)findViewById(R.id.et_check_of_);
 //       et_movementon_thefloor = (EditText)findViewById(R.id.et_movementon_thefloor);



        txt_expansion_joints = (TextView)findViewById(R.id.txt_expansion_joints);
        txt_width = (TextView)findViewById(R.id.txt_width);
        txt_depth = (TextView)findViewById(R.id.txt_depth);
        txt_expansion_joints_current_status = (TextView)findViewById(R.id.txt_expansion_joints_current_status);
        txt_attach_image_expansion_image = (TextView)findViewById(R.id.txt_attach_image_expansion_image);
        et_image = (TextView)findViewById(R.id.et_image);
        txt_construction_joints = (TextView)findViewById(R.id.txt_construction_joints);
        txt_width_construction = (TextView)findViewById(R.id.txt_width_construction);
        txt_depth_construction = (TextView)findViewById(R.id.txt_depth_construction);
        txt_construction_joints_current_status = (TextView)findViewById(R.id.txt_construction_joints_current_status);
        txt_attach_image_construction_image = (TextView)findViewById(R.id.txt_attach_image_construction_image);
        et_image_construction = (TextView)findViewById(R.id.et_image_construction);

  //      et_expansion_joints = (EditText) findViewById(R.id.et_expansion_joints);
        et_width_mm = (EditText)findViewById(R.id.et_width_mm);
        et_depth_cms = (EditText)findViewById(R.id.et_depth_cms);
      /*  et_expansion_joints_current_status = (EditText)findViewById(R.id.et_expansion_joints_current_status);
        et_construction_joints = (EditText)findViewById(R.id.et_construction_joints);*/
        et_width_construction = (EditText)findViewById(R.id.et_width_construction);
        et_depth_construction = (EditText)findViewById(R.id.et_depth_construction);
   //     et_construction_joints_current_status = (EditText)findViewById(R.id.et_construction_joints_current_status);


        ll_fill.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.spinner_color));
        ll_fill_out_sampling.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
        ll_fill_out_inspection_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
        ll_fill_out_negotiation_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
        txt_fill_out.setTextColor(getResources().getColor(R.color.white));
        txt_fill_out_sampling.setTextColor(getResources().getColor(R.color.spinner_color));
        txt_fill_out_inspecion_details.setTextColor(getResources().getColor(R.color.spinner_color));
        txt_fill_out_negotiation_details.setTextColor(getResources().getColor(R.color.spinner_color));
        ll_layout_general_info.setVisibility(View.VISIBLE);
        ll_layout_fill_out_inspection_details.setVisibility(View.GONE);
        ll_layout_fill_out_negotiation_details.setVisibility(View.GONE);
        ll_layout_fill_out_samplig_details.setVisibility(View.GONE);
        ll_floor_checks.setVisibility(View.GONE);
        ll_covings.setVisibility(View.GONE);
        ll_joint_checks.setVisibility(View.GONE);


        ll_fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_fill.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.spinner_color));
                ll_fill_out_sampling.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_inspection_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_negotiation_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                txt_fill_out.setTextColor(getResources().getColor(R.color.white));
                txt_fill_out_sampling.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_inspecion_details.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_negotiation_details.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_layout_general_info.setVisibility(View.VISIBLE);
                ll_layout_fill_out_inspection_details.setVisibility(View.GONE);
                ll_layout_fill_out_negotiation_details.setVisibility(View.GONE);
                ll_layout_fill_out_samplig_details.setVisibility(View.GONE);
                txt_submit_reg.setText("Save For Later");
            }
        });


        ll_fill_out_sampling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_fill.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_sampling.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.spinner_color));
                ll_fill_out_inspection_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_negotiation_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                txt_fill_out.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_sampling.setTextColor(getResources().getColor(R.color.white));
                txt_fill_out_inspecion_details.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_negotiation_details.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_layout_general_info.setVisibility(View.GONE);
                ll_layout_fill_out_inspection_details.setVisibility(View.VISIBLE);
                ll_layout_fill_out_negotiation_details.setVisibility(View.GONE);
                ll_layout_fill_out_samplig_details.setVisibility(View.GONE);
                txt_submit_reg.setText("Save For Later");
            }
        });

        ll_fill_out_inspection_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_fill.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_sampling.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_inspection_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.spinner_color));
                ll_fill_out_negotiation_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                txt_fill_out.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_sampling.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_inspecion_details.setTextColor(getResources().getColor(R.color.white));
                txt_fill_out_negotiation_details.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_layout_general_info.setVisibility(View.GONE);
                ll_layout_fill_out_inspection_details.setVisibility(View.GONE);
                ll_layout_fill_out_negotiation_details.setVisibility(View.GONE);
                ll_layout_fill_out_samplig_details.setVisibility(View.VISIBLE);
                txt_submit_reg.setText("Save For Later");
            }
        });

        ll_fill_out_negotiation_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_fill.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_sampling.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_inspection_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                ll_fill_out_negotiation_details.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.spinner_color));
                txt_fill_out.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_sampling.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_inspecion_details.setTextColor(getResources().getColor(R.color.spinner_color));
                txt_fill_out_negotiation_details.setTextColor(getResources().getColor(R.color.white));
                ll_layout_general_info.setVisibility(View.GONE);
                ll_layout_fill_out_inspection_details.setVisibility(View.GONE);
                ll_layout_fill_out_negotiation_details.setVisibility(View.VISIBLE);
                ll_layout_fill_out_samplig_details.setVisibility(View.GONE);
                txt_submit_reg.setText("Save");
            }
        });


        ll_general_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_general_info.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                txt_general_info.setTextColor(getResources().getColor(R.color.white));
                ll_general_info_site.setVisibility(View.VISIBLE);
                ll_floor_check.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));

                ll_floor_checks.setVisibility(View.GONE);

                ll_coving.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                ll_covings.setVisibility(View.GONE);
                ll_joint_check.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_joint_checks.setVisibility(View.GONE);
            }
        });

        ll_floor_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_floor_check.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                txt_permission.setTextColor(getResources().getColor(R.color.white));
                ll_general_info_site.setVisibility(View.GONE);
                ll_general_info.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_general_info.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_floor_checks.setVisibility(View.VISIBLE);

                ll_coving.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_create_new_user.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_covings.setVisibility(View.GONE);

                ll_joint_check.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_joint_checks.setVisibility(View.GONE);
            }
        });

        ll_joint_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_joint_check.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                txt_wf.setTextColor(getResources().getColor(R.color.white));

                ll_general_info_site.setVisibility(View.GONE);
                ll_general_info.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_general_info.setTextColor(getResources().getColor(R.color.spinner_color));

                ll_floor_check.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_floor_checks.setVisibility(View.GONE);

                ll_coving.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_create_new_user.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_covings.setVisibility(View.GONE);
                ll_joint_checks.setVisibility(View.VISIBLE);
            }
        });


        ll_coving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_floor_check.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                ll_general_info_site.setVisibility(View.GONE);
                ll_general_info.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_general_info.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_floor_checks.setVisibility(View.GONE);
                txt_permission.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_coving.setBackground(getResources().getDrawable(R.drawable.bg_spinner));
                txt_create_new_user.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_covings.setVisibility(View.VISIBLE);

                ll_joint_check.setBackground(getResources().getDrawable(R.drawable.transparent_bg_background));
                txt_create_new_user.setTextColor(getResources().getColor(R.color.white));
                txt_wf.setTextColor(getResources().getColor(R.color.spinner_color));
                ll_joint_checks.setVisibility(View.GONE);

            }
        });


        String comparevaluescracks_pot = projectNPModel.getCracksPitPots();
        ArrayAdapter<CharSequence> adaapter_cracks_pots = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.cracks_pot, R.layout.spinner_item);
        adaapter_cracks_pots.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_one_cracks_pot.setAdapter(adaapter_cracks_pots);
        if (adaapter_cracks_pots != null) {
            int spinnerPosition = adaapter_cracks_pots.getPosition(comparevaluescracks_pot);
            spinner_one_cracks_pot.setSelection(spinnerPosition);
        }else {

        }

        spinner_one_cracks_pot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            txt_crackspot = spinner_one_cracks_pot.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_expasion_joints = (Spinner)findViewById(R.id.spinner_expasion_joints);
        String comparevaluesexpansion_joints = projectNPModel.getExpansionJoints();
        ArrayAdapter<CharSequence> adaapter_expasion_joints = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.expansion_joints, R.layout.spinner_item);
        adaapter_expasion_joints.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_expasion_joints.setAdapter(adaapter_expasion_joints);
        if (comparevaluesexpansion_joints != null) {
            int spinnerPosition = adaapter_expasion_joints.getPosition(comparevaluesexpansion_joints);
            spinner_expasion_joints.setSelection(spinnerPosition);
        }else {

        }

        spinner_expasion_joints.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                expansionJoints = spinner_expasion_joints.getSelectedItem().toString();
                if (spinner_expasion_joints.getSelectedItem().toString().equals("Select")){
                    ll_expansion_joints.setVisibility(View.GONE);
                }else if (spinner_expasion_joints.getSelectedItem().toString().equals("Yes")){
                    ll_expansion_joints.setVisibility(View.VISIBLE);
                    et_width_mm.setText("" + projectNPModel.getWidthJoints());
                    et_depth_cms.setText("" + projectNPModel.getDepth());
                    spinner_expasion_joints_current_status = (Spinner)findViewById(R.id.spinner_expasion_joints_current_status);

                    String comparevaluexpansion_joint_current_status = projectNPModel.getExpansioJointCurrentStatus();
                    ArrayAdapter<CharSequence> adaapter_expasion_jointscurrentStaus = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.expansion_joints_current_status, R.layout.spinner_item);
                    adaapter_expasion_jointscurrentStaus.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_expasion_joints_current_status.setAdapter(adaapter_expasion_jointscurrentStaus);
                    if (comparevaluexpansion_joint_current_status != null) {
                        int spinnerPosition = adaapter_expasion_jointscurrentStaus.getPosition(comparevaluexpansion_joint_current_status);
                        spinner_expasion_joints_current_status.setSelection(spinnerPosition);
                    }else {

                    }

                    spinner_expasion_joints_current_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            expansioJointCurrentStatus = spinner_expasion_joints_current_status.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                    //      et_expansion_joints_current_status.setText("" + projectNPModel.getExpansioJointCurrentStatus());

                }else if (spinner_expasion_joints.getSelectedItem().toString().equals("No")){
                    ll_expansion_joints.setVisibility(View.GONE);
                }else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_construction_joints = (Spinner)findViewById(R.id.spinner_construction_joints);
        String comparevaluesconstruction_joints = projectNPModel.getConstructionJoints();
        ArrayAdapter<CharSequence> adaapter_construction_joints = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.expansion_joints, R.layout.spinner_item);
        adaapter_construction_joints.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_construction_joints.setAdapter(adaapter_construction_joints);
        if (comparevaluesconstruction_joints != null) {
            int spinnerPosition = adaapter_expasion_joints.getPosition(comparevaluesconstruction_joints);
            spinner_construction_joints.setSelection(spinnerPosition);
        }else {

        }
        spinner_construction_joints.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                constructionJoints = spinner_construction_joints.getSelectedItem().toString();

                if (spinner_construction_joints.getSelectedItem().toString().equals("Select")){
                    ll_construction_joints.setVisibility(View.GONE);
                }else if (spinner_construction_joints.getSelectedItem().toString().equals("Yes")){
                    ll_construction_joints.setVisibility(View.VISIBLE);
                    et_width_construction.setText("" + projectNPModel.getWidth());
                    spinner_construction_current_status = (Spinner)findViewById(R.id.spinner_construction_current_status);


                    String comparevaluesconstruction_joint_current_status = projectNPModel.getConstructionJointsCurrentStatus();
                    ArrayAdapter<CharSequence> adaapter_construction_joint_current_status = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.expansion_joints, R.layout.spinner_item);
                    adaapter_construction_joint_current_status.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_construction_current_status.setAdapter(adaapter_construction_joint_current_status);
                    if (comparevaluesconstruction_joint_current_status != null) {
                        int spinnerPosition = adaapter_construction_joint_current_status.getPosition(comparevaluesconstruction_joints);
                        spinner_construction_current_status.setSelection(spinnerPosition);
                    }else {

                    }
                    spinner_construction_current_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            constructionJointsCurrentStatus = spinner_construction_current_status.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                    //             et_construction_joints_current_status.setText("" + projectNPModel.getConstructionJointsCurrentStatus());
                }else if (spinner_construction_joints.getSelectedItem().toString().equals("No")){
                    ll_construction_joints.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        spinner_movementonthefloor = (Spinner)findViewById(R.id.spinner_movementonthefloor);
        String comparevaluesmovementonthefloor = projectNPModel.getMovementOnFloor();
        ArrayAdapter<CharSequence> adaapter_movementontghefloor = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.movementon_the_floor, R.layout.spinner_item);
        adaapter_movementontghefloor.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_movementonthefloor.setAdapter(adaapter_movementontghefloor);
        if (comparevaluesmovementonthefloor != null) {
            int spinnerPosition = adaapter_movementontghefloor.getPosition(comparevaluesmovementonthefloor);
            spinner_movementonthefloor.setSelection(spinnerPosition);
        }else {

        }

        spinner_movementonthefloor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                movementOnFloor = spinner_movementonthefloor.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        spinner_floor_undulation = (Spinner)findViewById(R.id.spinner_floor_undulation);
        String comparevaluesundulation = projectNPModel.getFloorUndulations();
        ArrayAdapter<CharSequence> adaapter_undulation = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.floor_undulation, R.layout.spinner_item);
        adaapter_undulation.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_floor_undulation.setAdapter(adaapter_undulation);
        if (comparevaluesundulation != null) {
            int spinnerPosition = adaapter_undulation.getPosition(comparevaluesundulation);
            spinner_floor_undulation.setSelection(spinnerPosition);
        }else {

        }

        spinner_floor_undulation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txt_floor_undulation = spinner_floor_undulation.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinner_scratching_surface = (Spinner)findViewById(R.id.spinner_scratching_surface);


        String comparevaluesscracthing_surface = projectNPModel.getScratchingTheSurface();
        ArrayAdapter<CharSequence> adaapter_scracthing_surface = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.spinner_sound_of_floor, R.layout.spinner_item);
        adaapter_scracthing_surface.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_scratching_surface.setAdapter(adaapter_scracthing_surface);
        if (comparevaluesscracthing_surface != null) {
            int spinnerPosition = adaapter_scracthing_surface.getPosition(comparevaluesscracthing_surface);
            spinner_scratching_surface.setSelection(spinnerPosition);
        }else {

        }

        spinner_scratching_surface.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txt_scraching_surface = spinner_scratching_surface.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_one_problem_soundness = (Spinner)findViewById(R.id.spinner_one_problem_soundness);

        String comparevaluessoundness_offloor = projectNPModel.getSoundnessOfTheFloor();
        ArrayAdapter<CharSequence> adaapter_soundness_floor = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.spinner_sound_of_floor, R.layout.spinner_item);
        adaapter_soundness_floor.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_one_problem_soundness.setAdapter(adaapter_soundness_floor);
        if (comparevaluessoundness_offloor != null) {
            int spinnerPosition = adaapter_soundness_floor.getPosition(comparevaluessoundness_offloor);
            spinner_one_problem_soundness.setSelection(spinnerPosition);
        }else {

        }



        spinner_one_problem_soundness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txt_spinner_soundness_floor = spinner_one_problem_soundness.getSelectedItem().toString();
                if (spinner_one_problem_soundness.getSelectedItem().toString().equals("Select")){
                    ll_problem_with_soundness.setVisibility(View.GONE);
                }else if (spinner_one_problem_soundness.getSelectedItem().toString().equals("Yes")){
                    ll_problem_with_soundness.setVisibility(View.GONE);
                }else if (spinner_one_problem_soundness.getSelectedItem().toString().equals("No")){
                    ll_problem_with_soundness.setVisibility(View.VISIBLE);
                    et_problem_with_soundness_floor.setText("" + projectNPModel.getSoundnessOfTheFloorProblems());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ll_specifyOne = (LinearLayout)findViewById(R.id.ll_specifyOne);

        String comparevaluesfloor_hardner = projectNPModel.getFloorHardnerOrAnyCuringAgent();
        ArrayAdapter<CharSequence> adapterfloorhardner = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.floor_hardner, R.layout.spinner_item);
        adapterfloorhardner.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_one_floor_hardner.setAdapter(adapterfloorhardner);
        if (comparevaluesfloor_hardner != null) {
            int spinnerPosition = adapterfloorhardner.getPosition(comparevaluesfloor_hardner);
            spinner_one_floor_type.setSelection(spinnerPosition);
        }else {

        }

        spinner_one_floor_hardner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spiiner_floor_hardener = spinner_one_floor_hardner.getSelectedItem().toString();
                if (spinner_one_floor_hardner.getSelectedItem().toString().equals("Select")){
                    ll_ifyes.setVisibility(View.GONE);
                }else if (spinner_one_floor_hardner.getSelectedItem().toString().equals("Yes")){
                    ll_ifyes.setVisibility(View.VISIBLE);
                    et_if_yes.setText("" + projectNPModel.getFloorHardnerOrAnyCuringAgentYes());
                }else if (spinner_one_floor_hardner.getSelectedItem().toString().equals("No")){
                    ll_ifyes.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String comparevaluesfloor_area = projectNPModel.getFloorType();
        ArrayAdapter<CharSequence> adapterfloorarea = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.floor_type, R.layout.spinner_item);
        adapterfloorarea.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_one_floor_type.setAdapter(adapterfloorarea);
        if (comparevaluesfloor_area != null) {
            int spinnerPosition = adapterfloorarea.getPosition(comparevaluesfloor_area);
            spinner_one_floor_type.setSelection(spinnerPosition);
        }else {

        }

        spinner_one_floor_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txt_floor_type_selection = spinner_one_floor_type.getSelectedItem().toString();
                if (spinner_one_floor_type.getSelectedItem().toString().equals("Select")){
                    ll_specifyOne.setVisibility(View.GONE);
                }else if (spinner_one_floor_type.getSelectedItem().toString().equals("Old Concrete")){
                    ll_specifyOne.setVisibility(View.GONE);
                }else if (spinner_one_customer_type.getSelectedItem().toString().equals("New Concrete")){
                    ll_specifyOne.setVisibility(View.GONE);
                }else if (spinner_one_floor_type.getSelectedItem().toString().equals("Stone")){
                    ll_specifyOne.setVisibility(View.GONE);
                }else if (spinner_one_floor_type.getSelectedItem().toString().equals("Tiles")){
                    ll_specifyOne.setVisibility(View.GONE);
                }else if (spinner_one_floor_type.getSelectedItem().toString().equals("Old Flooring")){
                    ll_specifyOne.setVisibility(View.GONE);
                }else if (spinner_one_floor_type.getSelectedItem().toString().equals("Others")){
                    ll_specifyOne.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        String comparevalues = projectNPModel.getOrderStatus();
        ArrayAdapter<CharSequence> adapterorderstatus = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.array_order_status, R.layout.spinner_item);
        adapterorderstatus.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_one_order_status.setAdapter(adapterorderstatus);
        if (comparevalues != null) {
            int spinnerPosition = adapterorderstatus.getPosition(comparevalues);
            spinner_one_order_status.setSelection(spinnerPosition);
        }else {

        }

        spinner_one_order_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txt_order_stus = spinner_one_order_status.getSelectedItem().toString();

                if (spinner_one_order_status.getSelectedItem().toString().equals("Select")){
                    ll_confirmed.setVisibility(View.GONE);
                    ll_lost.setVisibility(View.GONE);
                }else if (spinner_one_customer_type.getSelectedItem().toString().equals("Confirmed")){
                    ll_confirmed.setVisibility(View.VISIBLE);
                    ll_lost.setVisibility(View.GONE);
                    et_order_value.setText("" + projectNPModel.getOrderValue());
                }else if (spinner_one_customer_type.getSelectedItem().toString().equals("Lost")){
                    ll_confirmed.setVisibility(View.GONE);
                    ll_lost.setVisibility(View.VISIBLE);
                    et_competitor_name.setText("" + projectNPModel.getCompetitorName());
                    et_price.setText("" + projectNPModel.getPrice());
                }else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String compareValue = projectNPModel.getCustomerType();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.customer_type_Np, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_one_customer_type.setAdapter(adapter);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinner_one_customer_type.setSelection(spinnerPosition);

            spinner_one_customer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    text_customer_type = spinner_one_customer_type.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        String CompareValue = projectNPModel.getState();
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.array_indian_states, R.layout.spinner_item);
        adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_state.setAdapter(adapterTwo);
        if (compareValue != null) {
            int spinnerPosition = adapterTwo.getPosition(CompareValue);
            spinner_state.setSelection(spinnerPosition);
        }
        //    spinner_state.setAdapter(adapterEleven);

        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedState = spinner_state.getSelectedItem().toString();
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
                            comparevalueThree = projectNPModel.getDistrict();
                            if (comparevalueThree != null) {
                                int spinnerPosition = districtAdapter.getPosition(comparevalueThree);
                                spinner_district.setSelection(spinnerPosition);
                            }
                            break;

                        case "Arunachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_arunachal_pradesh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            comparevalueThree = projectNPModel.getDistrict();
                            if (comparevalueThree != null) {
                                int spinnerPosition = districtAdapter.getPosition(comparevalueThree);
                                spinner_district.setSelection(spinnerPosition);
                            }
                            break;

                        case "Assam": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_assam_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            comparevalueThree = projectNPModel.getDistrict();
                            if (comparevalueThree != null) {
                                int spinnerPosition = districtAdapter.getPosition(comparevalueThree);
                                spinner_district.setSelection(spinnerPosition);
                            }
                            break;
                        case "Bihar": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_bihar_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            comparevalueThree = projectNPModel.getDistrict();
                            if (comparevalueThree != null) {
                                int spinnerPosition = districtAdapter.getPosition(comparevalueThree);
                                spinner_district.setSelection(spinnerPosition);
                            }
                            break;
                        case "Chhattisgarh": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_chhattisgarh_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            comparevalueThree = projectNPModel.getDistrict();
                            if (comparevalueThree != null) {
                                int spinnerPosition = districtAdapter.getPosition(comparevalueThree);
                                spinner_district.setSelection(spinnerPosition);
                            }
                            break;

                        case "Goa": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_goa_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            comparevalueThree = projectNPModel.getDistrict();
                            if (comparevalueThree != null) {
                                int spinnerPosition = districtAdapter.getPosition(comparevalueThree);
                                spinner_district.setSelection(spinnerPosition);
                            }
                            break;
                        case "Gujarat": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_gujarat_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            comparevalueThree = projectNPModel.getDistrict();
                            if (comparevalueThree != null) {
                                int spinnerPosition = districtAdapter.getPosition(comparevalueThree);
                                spinner_district.setSelection(spinnerPosition);
                            }
                            break;
                        case "Haryana": districtAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_haryana_districts, R.layout.spinner_item);
                            districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            comparevalueThree = projectNPModel.getDistrict();
                            if (comparevalueThree != null) {
                                int spinnerPosition = districtAdapter.getPosition(comparevalueThree);
                                spinner_district.setSelection(spinnerPosition);
                            }
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
                    //        spinner_district.setAdapter(districtAdapter);


                    spinner_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedDistrict = spinner_district.getSelectedItem().toString();
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

        ll_layout_coving = (LinearLayout)findViewById(R.id.ll_layout_coving);
        spinner_coving = (Spinner)findViewById(R.id.spinner_coving);
        spinner_coving_current_status = (Spinner)findViewById(R.id.spinner_coving_current_status);
        String compareValuecoving = projectNPModel.getCustomerType();
        ArrayAdapter<CharSequence> adaptercoving = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.coving, R.layout.spinner_item);
        adaptercoving.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_coving.setAdapter(adaptercoving);
        if (compareValue != null) {
            int spinnerPosition = adaptercoving.getPosition(compareValuecoving);
            spinner_coving.setSelection(spinnerPosition);
        }


        spinner_coving.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                coving = spinner_coving.getSelectedItem().toString();

                if (spinner_coving.getSelectedItem().toString().equals("Select")){
                    ll_layout_coving.setVisibility(View.GONE);
                }else if (spinner_coving.getSelectedItem().toString().equals("Yes")){
                    ll_layout_coving.setVisibility(View.VISIBLE);
                    et_height.setText("" + projectNPModel.getHeightCoving());
                    String compareValuecovingcurrent_status = projectNPModel.getCovingCurrentStatus();
                    ArrayAdapter<CharSequence> adaptercoving = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.coving, R.layout.spinner_item);
                    adaptercoving.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_coving_current_status.setAdapter(adaptercoving);
                    if (compareValuecovingcurrent_status != null) {
                        int spinnerPosition = adaptercoving.getPosition(compareValuecovingcurrent_status);
                        spinner_coving_current_status.setSelection(spinnerPosition);
                    }else {

                    }
                    spinner_coving_current_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            covingCurrentStatus = spinner_coving_current_status.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

            //        et_coving_current_status.setText("" + projectNPModel.getCovingCurrentStatus());
                } else if (spinner_coving.getSelectedItem().toString().equals("No")) {
                    ll_layout_coving.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_sampling_required = (Spinner)findViewById(R.id.spinner_sampling_required);
        spinner_sample_approval_status = (Spinner)findViewById(R.id.spinner_sample_approval_status);
        spinner_sample_rating = (Spinner)findViewById(R.id.spinner_sample_rating);
        String compareValuespinner_sampling = projectNPModel.getSamplingRequired();
        ArrayAdapter<CharSequence> adapterspinner_sampling = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.sampling_required, R.layout.spinner_item);
        adapterspinner_sampling.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_sampling_required.setAdapter(adapterspinner_sampling);
        if (compareValuespinner_sampling != null) {
            int spinnerPosition = adapterspinner_sampling.getPosition(compareValuespinner_sampling);
            spinner_sampling_required.setSelection(spinnerPosition);
        }

        spinner_sampling_required.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (spinner_sampling_required.getSelectedItem().toString().equals("Select")){
                   ll_sample_required.setVisibility(View.GONE);
               }else if (spinner_sampling_required.getSelectedItem().toString().equals("Yes")){
                   ll_sample_required.setVisibility(View.VISIBLE);
                   et_sample_approver_name.setText(""+projectNPModel.getSampleApprover());
                   et_sampling_approver_contact_no.setText(""+ projectNPModel.getContactNoSampling());
                   txt_sampliningrequired = spinner_sampling_required.getSelectedItem().toString();

                   String compareValuespinner_samplingAproval = projectNPModel.getSampleApprovalStatus();
                   ArrayAdapter<CharSequence> adapterspinner_sampling = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.sampling_approval, R.layout.spinner_item);
                   adapterspinner_sampling.setDropDownViewResource(R.layout.spinner_dropdown_item);
                   spinner_sample_approval_status.setAdapter(adapterspinner_sampling);
                   if (compareValuespinner_samplingAproval != null) {
                       int spinnerPosition = adapterspinner_sampling.getPosition(compareValuespinner_samplingAproval);
                       spinner_sample_approval_status.setSelection(spinnerPosition);
                   }else {

                   }

                   spinner_sample_approval_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                       @Override
                       public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                           txt_sample_approval_status = spinner_sample_approval_status.getSelectedItem().toString();
                       }

                       @Override
                       public void onNothingSelected(AdapterView<?> adapterView) {

                       }
                   });



                   String compareValuespinner_sampling = projectNPModel.getSampleApprovalRating();
                   ArrayAdapter<CharSequence> adapterspinner_sampling_Rating = ArrayAdapter.createFromResource(EditNPActivity.this, R.array.sampling_rating, R.layout.spinner_item);
                   adapterspinner_sampling_Rating.setDropDownViewResource(R.layout.spinner_dropdown_item);
                   spinner_sample_rating.setAdapter(adapterspinner_sampling_Rating);
                   if (compareValuespinner_sampling != null) {
                       int spinnerPosition = adapterspinner_sampling.getPosition(compareValuespinner_sampling);
                       spinner_sample_rating.setSelection(spinnerPosition);
                   }

                   spinner_sample_rating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                       @Override
                       public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                           txt_spinner_sample_rating = spinner_sample_rating.getSelectedItem().toString();
                       }

                       @Override
                       public void onNothingSelected(AdapterView<?> adapterView) {

                       }
                   });

               }else if (spinner_sampling_required.getSelectedItem().toString().equals("No")){
                   ll_sample_required.setVisibility(View.GONE);
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        txt_sampling_details = (TextView)findViewById(R.id.txt_sampling_details);
        txt_sampling_applicator = (TextView)findViewById(R.id.txt_sampling_applicator);
        txt_sample_approver_name = (TextView)findViewById(R.id.txt_sample_approver_name);
        txt_sampling_contact_no = (TextView)findViewById(R.id.txt_sampling_contact_no);
        txt_sample_feedback = (TextView)findViewById(R.id.txt_sample_feedback);
        txt_sample_apprval_status = (TextView)findViewById(R.id.txt_sample_apprval_status);
        txt_sampling_rating = (TextView)findViewById(R.id.txt_sampling_rating);
        txt_attach_primer_image = (TextView)findViewById(R.id.txt_attach_primer_image);
        txt_screed_image = (TextView)findViewById(R.id.txt_screed_image);
        txt_attch_imageone = (TextView)findViewById(R.id.txt_attch_imageone);
        txt_attch_imageTwo = (TextView)findViewById(R.id.txt_attch_imageTwo);
        txt_attach_topcoat = (TextView)findViewById(R.id.txt_attach_topcoat);
        txt_attach_ = (TextView)findViewById(R.id.txt_attach_);

        et_sample_approver_name = (EditText)findViewById(R.id.et_sample_approver_name);
        et_sampling_approver_contact_no = (EditText)findViewById(R.id.et_sampling_approver_contact_no);




        FontUtils.changeFont(getApplicationContext(),txt_sampling_details, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sampling_applicator, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sample_approver_name, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sampling_contact_no, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sample_feedback, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sample_apprval_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sampling_rating, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attach_primer_image, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_screed_image, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attch_imageone, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attch_imageTwo, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attach_topcoat, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attach_, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_sampling_approver_contact_no, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_sample_approver_name, AppConstant.FONT_SANS_SEMIBOLD);





        FontUtils.changeFont(getApplicationContext(),txt_create_project_site, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_np, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_project_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_deadline, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_submit_reg, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_fill_out, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_fill_out_sampling, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_fill_out_inspecion_details, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_fill_out_negotiation_details, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_project_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_deadline, AppConstant.FONT_SANS_SEMIBOLD);


        FontUtils.changeFont(getApplicationContext(),txt_form_reference_no, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_territory, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_business_name, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_industry_segment, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_state, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_address, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_district, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_location, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_decision_maker, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_designation, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_contactno, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_form_reference_no, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),et_business_name, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_territory, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_decision_maker, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_designation, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_contact_no, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),et_industry_segment, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_address, AppConstant.FONT_SANS_SEMIBOLD);
 //       FontUtils.changeFont(getApplicationContext(),et_distrct, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_location, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_sample_aprover, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sampling_designation, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_email_sampling, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_contact_no, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sampling_required, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_sample_approver, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_sampling_desigation, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_sample_contact_no, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_sampling_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_sampling_departmnet, AppConstant.FONT_SANS_SEMIBOLD);


        FontUtils.changeFont(getApplicationContext(),txt_coving, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_height, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_coving_current_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attach_image_coving, AppConstant.FONT_SANS_SEMIBOLD);
    //    FontUtils.changeFont(getApplicationContext(),et_covings, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_height, AppConstant.FONT_SANS_SEMIBOLD);
   //     FontUtils.changeFont(getApplicationContext(),et_coving_current_status,AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_negotaiation_person, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_negotiation_designation, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_negotiation_contact, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_email_negotiation, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_department_negotiation, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_order_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_negotiation_person, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_negotiation_designation, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_negotiation_contact_no, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_negotiation_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_negotiation_departmnet, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_negotiation_departmnet, AppConstant.FONT_SANS_SEMIBOLD);
  //      FontUtils.changeFont(getApplicationContext(),et_order_status, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_order_value, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_competitor_name, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_price, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_order_value, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_competitor_name, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_price,AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_project,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_decision_maker_site_assesment,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_project_decision_designation,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sampling_contact,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_sampling_email,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_department_Sampling,AppConstant.FONT_SANS_SEMIBOLD);


        FontUtils.changeFont(getApplicationContext(),et_desicion_making_details,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_designation_sampling_details,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_contact_sampling,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_email_sampling,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_department_Sampling,AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_date,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_week,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_date,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_week,AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_floor_area_one,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_floor_type,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_specify,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_permission,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_floor_area,AppConstant.FONT_SANS_SEMIBOLD);
    //    FontUtils.changeFont(getApplicationContext(),et_floor_type,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_specify,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_concrete_floor_strength,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_floor_hardner,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_soundness_of_floor,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_scratching_surface,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_problem_with_soundness_floor,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_check_of_moisture,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_cracks_pits,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_impurities_of_floor,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_floor_undulution,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attach_image,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_link,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_concrete_floor_strength,AppConstant.FONT_SANS_SEMIBOLD);
   //     FontUtils.changeFont(getApplicationContext(),et_floor_hardener,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_if_yes,AppConstant.FONT_SANS_SEMIBOLD);
   //     FontUtils.changeFont(getApplicationContext(),et_scratching_surface,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_problem_with_soundness_floor,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_check_of_moisture,AppConstant.FONT_SANS_SEMIBOLD);
   //     FontUtils.changeFont(getApplicationContext(),et_cracks_pits,AppConstant.FONT_SANS_SEMIBOLD);
   //     FontUtils.changeFont(getApplicationContext(),et_check_of_,AppConstant.FONT_SANS_SEMIBOLD);
  //      FontUtils.changeFont(getApplicationContext(),et_movementon_thefloor,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_general_info,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_wf,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_create_new_user,AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),txt_expansion_joints, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_width, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_depth, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_expansion_joints_current_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attach_image_expansion_image, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_image, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_construction_joints, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_width_construction, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_depth_construction, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_construction_joints_current_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_attach_image_construction_image, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_image_construction, AppConstant.FONT_SANS_SEMIBOLD);
  //      FontUtils.changeFont(getApplicationContext(),et_expansion_joints, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_width_mm, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_depth_cms, AppConstant.FONT_SANS_SEMIBOLD);
       /* FontUtils.changeFont(getApplicationContext(),et_expansion_joints_current_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_construction_joints, AppConstant.FONT_SANS_SEMIBOLD);*/
        FontUtils.changeFont(getApplicationContext(),et_width_construction, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_depth_construction, AppConstant.FONT_SANS_SEMIBOLD);
    //    FontUtils.changeFont(getApplicationContext(),et_construction_joints_current_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),txt_if_yes, AppConstant.FONT_SANS_SEMIBOLD);




        et_project_status.setText("" + projectNPModel.getProjectStatus());
        et_deadline.setText("" + projectNPModel.getDeadline());
        et_form_reference_no.setText("" + projectNPModel.getFormReferenceNo());
        et_form_reference_no.setText("" + projectNPModel.getFormReferenceNo());
        et_business_name.setText("" + projectNPModel.getBusinessName());
        et_territory.setText("" + projectNPModel.getTerritory());
        et_industry_segment.setText("" + projectNPModel.getSegment());
        et_address.setText("" + projectNPModel.getAddress());
//        et_distrct.setText("" + projectNPModel.getDistrict());
        et_location.setText("" + projectNPModel.getLocation());
        et_decision_maker.setText("" + projectNPModel.getDecisionMaker());
        et_designation.setText("" + projectNPModel.getDesignation());
        et_email.setText("" + projectNPModel.getEmail());
        et_department.setText("" + projectNPModel.getDepartmentGI());
        et_contact_no.setText("" + projectNPModel.getContactNo());

        et_sample_approver.setText("" + projectNPModel.getSampleApprover());
        et_sampling_desigation.setText("" + projectNPModel.getDesignationInspection());
        et_sample_contact_no.setText("" + projectNPModel.getContactNoInspection());
        et_sampling_email.setText("" + projectNPModel.getEmailInspection());
        et_sampling_departmnet.setText("" + projectNPModel.getDepartmentsampling());
    //    et_sampling_required.setText("" + projectNPModel.getSamplingRequired());
        et_negotiation_person.setText("" + projectNPModel.getNegotiatingPerson());
        et_negotiation_designation.setText("" + projectNPModel.getDesignationNegotiatingPerson());
        et_negotiation_contact_no.setText("" + projectNPModel.getContactNoNegotiatingPerson());
        et_negotiation_email.setText("" + projectNPModel.getEmailNegotiatingPerson());
        et_negotiation_departmnet.setText("" + projectNPModel.getDepartmentNegotiatingPerson());
  //      et_order_status.setText(("" + projectNPModel.getOrderStatus()));
   //     et_sampling_required.setText("" + projectNPModel.getSamplingRequired());
       /* if (et_order_status.getText().toString().equals("Confirmed")){
            ll_confirmed.setVisibility(View.VISIBLE);
            ll_lost.setVisibility(View.GONE);
            et_order_value.setText("" + projectNPModel.getOrderValue());

        }else if (et_order_status.getText().toString().equals("Lost")){
            ll_confirmed.setVisibility(View.GONE);
            ll_lost.setVisibility(View.VISIBLE);
            et_competitor_name.setText("" + projectNPModel.getCompetitorName());
            et_price.setText("" + projectNPModel.getPrice());
        }else if (et_order_status.getText().toString().equals("")){
            ll_confirmed.setVisibility(View.GONE);
            ll_lost.setVisibility(View.GONE);
        }*/

        et_desicion_making_details.setText("" + projectNPModel.getDecisionMaker());
        et_designation_sampling_details.setText("" + projectNPModel.getDesignationSampling());
        et_contact_sampling.setText("" + projectNPModel.getContactNoSampling());
        et_email_sampling.setText("" + projectNPModel.getEmailInspection());
        et_department_Sampling.setText("" + projectNPModel.getDepartmentInspection());
        et_date.setText("" + projectNPModel.getDate());
        et_week.setText("" + projectNPModel.getWeek());

        et_concrete_floor_strength.setText("" + projectNPModel.getConcreteFloorStrength());
      /*  et_floor_hardener.setText("" + projectNPModel.getFloorHardnerOrAnyCuringAgent());
        if (projectNPModel.getFloorHardnerOrAnyCuringAgent().equals("Yes")){
            ll_ifyes.setVisibility(View.VISIBLE);
            et_if_yes.setText("" + projectNPModel.getFloorHardnerOrAnyCuringAgentYes());
        }else if (projectNPModel.getFloorHardnerOrAnyCuringAgent().equals("No")){
            ll_ifyes.setVisibility(View.GONE);
        }*/

       /* if (projectNPModel.getSoundnessOfTheFloor().equals("Yes")){
            ll_problem_with_soundness.setVisibility(View.GONE);
        }else if (projectNPModel.getSoundnessOfTheFloor().equals("No")){
            ll_problem_with_soundness.setVisibility(View.VISIBLE);
            et_problem_with_soundness_floor.setText("" + projectNPModel.getSoundnessOfTheFloorProblems());
        }*/

    //    et_scratching_surface.setText("" + projectNPModel.getScratchingTheSurface());
        et_check_of_moisture.setText("" + projectNPModel.getCheckofMoisture());
   //     et_cracks_pits.setText("" + projectNPModel.getCracksPitPots());
   //     et_check_of_.setText("" + projectNPModel.getImpuritiesOnFloor());
   //     et_movementon_thefloor.setText("" + projectNPModel.getFloorUndulations());

  //      et_covings.setText("" + projectNPModel.getCoving());
        /*et_height.setText("" + projectNPModel.getHeightCoving());
        et_coving_current_status.setText("" + projectNPModel.getCovingCurrentStatus());*/

     /*   et_expansion_joints.setText("" + projectNPModel.getExpansionJoints());
        et_width_mm.setText("" + projectNPModel.getWidthJoints());
        et_depth_cms.setText("" + projectNPModel.getDepth());
        et_expansion_joints_current_status.setText("" + projectNPModel.getExpansioJointCurrentStatus());*/

      /*  et_construction_joints.setText("" +projectNPModel.getConstructionJoints());
        et_width_construction.setText("" + projectNPModel.getWidth());
        et_construction_joints_current_status.setText("" + projectNPModel.getConstructionJointsCurrentStatus());*/

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              updateNpModel = new UpdateNpModel();
              updateNpModel.setId("");
              updateNpModel.setDepartmentID("");
              updateNpModel.setUserID("");
              updateNpModel.setFormReferenceNo(et_form_reference_no.getText().toString());
              updateNpModel.setCustomerType(text_customer_type);
              updateNpModel.setBusinessName(et_business_name.getText().toString());
              updateNpModel.setAddress(et_address.getText().toString());
              updateNpModel.setLocation(et_location.getText().toString());
              updateNpModel.setDecisionMaker(et_decision_maker.getText().toString());
              updateNpModel.setDesignation(et_designation.getText().toString());
              updateNpModel.setContactNo(et_contact_no.getText().toString());
              updateNpModel.setEmail(et_email.getText().toString());
              updateNpModel.setArea("");
              updateNpModel.setExpectedJobClosureDate("");
              updateNpModel.setEarlierFCsystem("");
              updateNpModel.setEarlierFCsystemSpecify("");
              updateNpModel.setProductSupplier("");
              updateNpModel.setProductSupplierOther("");
              updateNpModel.setAreaCurrentProject("");
              updateNpModel.setExpectedJobClosureDateCurrentProject("");
              updateNpModel.setSpecifiedSystem("");
              updateNpModel.setDecisionMakerInspection(et_desicion_making_details.getText().toString());
              updateNpModel.setDesignationInspection(et_designation_sampling_details.getText().toString());
              updateNpModel.setContactNoInspection(et_contact_sampling.getText().toString());
              updateNpModel.setEmailInspection(et_email_sampling.getText().toString());
              updateNpModel.setDesignationSampling(et_sampling_desigation.getText().toString());
              updateNpModel.setContactNoSampling(et_sample_contact_no.getText().toString());
              updateNpModel.setEmailsampling(et_sampling_email.getText().toString());
              updateNpModel.setSamplingRequired(txt_sampliningrequired);
              updateNpModel.setName(et_sample_approver_name.getText().toString());
              updateNpModel.setContactNoApplicator(et_sampling_approver_contact_no.getText().toString());
              updateNpModel.setSampleApprovalStatus(txt_sample_approval_status);
              updateNpModel.setSampleApprovalRating(txt_spinner_sample_rating);
              updateNpModel.setSampleApprovalRejected("");
              updateNpModel.setNegotiatingPerson(et_negotiation_person.getText().toString());
              updateNpModel.setDesignationNegotiatingPerson(et_negotiation_designation.getText().toString());
              updateNpModel.setContactNoNegotiatingPerson(et_negotiation_contact_no.getText().toString());
              updateNpModel.setEmailNegotiatingPerson(et_negotiation_email.getText().toString());
              updateNpModel.setAgenda("");
              updateNpModel.setMoM("");
              updateNpModel.setOrderStatus(txt_order_stus);
              updateNpModel.setCompetitorName(et_competitor_name.getText().toString());
              updateNpModel.setPrice(et_price.getText().toString());
              updateNpModel.setDate(et_date.getText().toString());
              updateNpModel.setWeek(et_week.getText().toString());
              updateNpModel.setFloorArea(et_floor_area.getText().toString());
              updateNpModel.setFloorType(txt_floor_type_selection);
              updateNpModel.setFloorTypeOthers("");
              updateNpModel.setConcreteFloorStrength(et_concrete_floor_strength.getText().toString());
              updateNpModel.setFloorHardnerOrAnyCuringAgent(spiiner_floor_hardener);
              updateNpModel.setFloorHardnerOrAnyCuringAgentYes(et_if_yes.getText().toString());
              updateNpModel.setSoundnessOfTheFloor(txt_spinner_soundness_floor);
              updateNpModel.setScratchingTheSurface(txt_scraching_surface);
              updateNpModel.setCheckofMoisture(et_check_of_moisture.getText().toString());
              updateNpModel.setCracksPitPots(txt_crackspot);
              updateNpModel.setImpuritiesOnFloor("");
              updateNpModel.setFloorUndulations(txt_floor_undulation);
              updateNpModel.setMovementOnFloor(movementOnFloor);
              updateNpModel.setExpansionJoints(expansionJoints);
              updateNpModel.setWidth(et_width_mm.getText().toString());
              updateNpModel.setWidth(et_width_mm.getText().toString());
              updateNpModel.setDepth(et_depth_cms.getText().toString());
              updateNpModel.setExpansioJointCurrentStatus(expansioJointCurrentStatus);
              updateNpModel.setConstructionJoints(constructionJoints);
              updateNpModel.setConstructionJointsCurrentStatus(constructionJointsCurrentStatus);
              updateNpModel.setCoving(coving);
              updateNpModel.setCovingCurrentStatus(covingCurrentStatus);
              updateNpModel.setWidthJoints(et_width_construction.getText().toString());
              updateNpModel.setHeightCoving(et_height.getText().toString());
              updateNpModel.setFloorCheckImage("");
              updateNpModel.setJointsCheckImage("");
              updateNpModel.setExpansionJointsCheckImage("");
              updateNpModel.setCovingsImage("");
              updateNpModel.setProjectStatus(et_project_status.getText().toString());
              updateNpModel.setRating("");
              updateNpModel.setDeadline(et_deadline.getText().toString());
              updateNpModel.setSoundnessOfTheFloorProblems(et_problem_with_soundness_floor.getText().toString());
              updateNpModel.setSampleApprover("");
              updateNpModel.setState(selectedState);
              updateNpModel.setDistrict(selectedDistrict);
              updateNpModel.setPrimerImage("");
              updateNpModel.setScreedImage("");
              updateNpModel.setTopcoatImage("");
              updateNpModel.setOrderValue(et_order_value.getText().toString());

                updateNpModel.setStatus("");
                updateNpModel.setTerritory("");
                updateNpModel.setSegment("");
                updateNpModel.setFormStage("");
                updateNpModel.setDepartmentGI("");
                updateNpModel.setDepartmentInspection("");
                updateNpModel.setDepartmentsampling("");
                updateNpModel.setDepartmentNegotiatingPerson("");
                updateNpModel.setActive(true);
                updateNpModel.setModifiedBy("");
                updateNpModel.setWorkFlowStatus("");
                addREDetail = updateNpModel.getAddREDetail();
                for (int i =0; i<addREDetail.size();i++){
                    addREDetail.get(i).setEmployeeName("");
                    addREDetail.get(i).setDate("");
                    addREDetail.get(i).getRemark();
                }
                updateNpModel.setAddREDetail(addREDetail);
                formHistoryDataTwo = updateNpModel.getFormHistoryData();
                formHistoryDataTwo.setFormValue("");
                formHistoryDataTwo.setDepartmentId("");
                formHistoryDataTwo.setInitiatedBy("");
                formHistoryDataTwo.setActionTakenDepartmentId("");
                formHistoryDataTwo.setWorkFlowStatus("");
                formHistoryDataTwo.setRemarks("");
                updateNpModel.setFormHistoryData(formHistoryDataTwo);




              uploadData(updateNpModel);


            }
        });


    }

    public void uploadData(UpdateNpModel updateNpModel){
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
                    Call<Boolean> resp = service.updateNpData(updateNpModel);
                    statusResponse = resp.execute().body();

                }catch (Exception e){
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
}
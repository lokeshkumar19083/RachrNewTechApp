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
import com.example.rachrnewtechapp.Adapter.RemarksAdapter;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.EditDepartmentFormWrapper;
import com.example.rachrnewtechapp.Model.ProjectNPModel;
import com.example.rachrnewtechapp.Model.ProjectNpModelTwo;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;

public class ViewNpActivity extends AppCompatActivity {
    private ProjectNPModel projectNPModel;
    private TextView txt_create_project_site,txt_np,txt_project_status,txt_deadline,txt_submit_reg;
    private EditText et_project_status,et_deadline;
    private LinearLayout ll_fill,ll_fill_out_sampling,ll_fill_out_inspection_details,ll_fill_out_negotiation_details;
    private TextView txt_fill_out,txt_fill_out_sampling,txt_fill_out_inspecion_details,txt_fill_out_negotiation_details;
    private TextView txt_form_reference_no,txt_customer_type,txt_business_name,txt_territory,txt_industry_segment,txt_state,txt_address,txt_district,txt_location,txt_decision_maker,txt_designation,txt_email,txt_department,txt_contactno;
    private EditText et_form_reference_no,et_customertype,et_business_name,et_territory,et_industry_segment,et_state,et_address,et_distrct,
            et_location,et_decision_maker,et_designation,et_email,et_department,et_contact_no;
    private LinearLayout ll_layout_general_info,ll_recycler,ll_layout_fill_out_inspection_details;
    private RecyclerView recyclerview;
    private List<ProjectNpModelTwo> projectNpModelTwos;
    private RemarksAdapter remarksAdapter;
    private RecyclerView.LayoutManager recyclerviewLayout, recyclerviewlayout_one,recyclerview_two;
    private ProjectNpModelTwo projectNpModelTwo;
    private TextView txt_sample_aprover,txt_sampling_designation,txt_contact_no,txt_email_sampling,txt,txt_sampling_required;
    private EditText et_sample_approver,et_sampling_desigation,et_sample_contact_no,et_sampling_email,et_sampling_departmnet,et_sampling_required;
    private TextView txt_negotaiation_person,txt_negotiation_designation,txt_negotiation_contact,txt_email_negotiation,txt_department_negotiation,txt_order_status;
    private EditText et_negotiation_person,et_negotiation_designation,et_negotiation_contact_no,et_negotiation_email,et_negotiation_departmnet,et_order_status;

    private LinearLayout ll_layout_fill_out_negotiation_details,ll_confirmed,ll_lost,ll_layout_fill_out_samplig_details;
    private TextView txt_order_value,txt_competitor_name,txt_price,txt_project,txt_decision_maker_site_assesment,txt_project_decision_designation,txt_sampling_contact,txt_sampling_email,txt_department_Sampling;
    private EditText et_order_value,et_competitor_name,et_price,et_desicion_making_details,et_designation_sampling_details,et_contact_sampling,et_email_sampling,et_department_Sampling;
    private TextView txt_date,txt_week;
    private EditText et_date,et_week;
    private LinearLayout ll_general_info_site,ll_general_info,ll_floor_check,ll_joint_check;
    private TextView txt_floor_area_one,txt_floor_type,txt_specify,txt_general_info,txt_permission;
    private EditText et_floor_area,et_floor_type,et_specify;
    private TextView txt_concrete_floor_strength,txt_floor_hardner,txt_soundness_of_floor,txt_scratching_surface,txt_problem_with_soundness_floor,txt_check_of_moisture,txt_cracks_pits,txt_impurities_of_floor,txt_floor_undulution,txt_attach_image,txt_link;
    private EditText et_concrete_floor_strength,et_floor_hardener,et_if_yes,et_scratching_surface,et_problem_with_soundness_floor,
            et_check_of_moisture,et_cracks_pits,et_check_of_,et_movementon_thefloor,et_sound_of_floor;
    private LinearLayout ll_ifyes,ll_problem_with_soundness,ll_floor_checks,ll_covings,ll_coving;
    private TextView txt_coving,txt_height,txt_coving_current_status,txt_attach_image_coving;
    private EditText et_covings,et_height,et_coving_current_status;
    private TextView txt_create_new_user,txt_wf;
    private TextView txt_expansion_joints,txt_width,txt_depth,txt_expansion_joints_current_status,txt_attach_image_expansion_image,et_image,
            txt_construction_joints,txt_width_construction,txt_depth_construction,txt_construction_joints_current_status,
            txt_attach_image_construction_image,et_image_construction;
    private EditText et_expansion_joints,et_width_mm,et_depth_cms,et_expansion_joints_current_status,et_construction_joints,
            et_width_construction,et_depth_construction,et_construction_joints_current_status;
    private LinearLayout ll_joint_checks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_np);

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




        txt_fill_out = (TextView)findViewById(R.id.txt_fill_out);
        txt_fill_out_sampling = (TextView)findViewById(R.id.txt_fill_out_sampling);
        txt_fill_out_inspecion_details = (TextView)findViewById(R.id.txt_fill_out_inspecion_details);
        txt_fill_out_negotiation_details = (TextView)findViewById(R.id.txt_fill_out_negotiation_details);

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
        et_sampling_required = (EditText)findViewById(R.id.et_sampling_required);





        et_form_reference_no = (EditText)findViewById(R.id.et_form_reference_no);
        et_customertype = (EditText)findViewById(R.id.et_customertype);
        et_business_name = (EditText)findViewById(R.id.et_business_name);
        et_territory = (EditText)findViewById(R.id.et_territory);
        et_industry_segment = (EditText)findViewById(R.id.et_industry_segment);
        et_state = (EditText)findViewById(R.id.et_state);
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




        et_negotiation_person = (EditText)findViewById(R.id.et_negotiation_person);
        et_negotiation_designation = (EditText)findViewById(R.id.et_negotiation_designation);
        et_negotiation_contact_no = (EditText)findViewById(R.id.et_negotiation_contact_no);
        et_negotiation_email = (EditText)findViewById(R.id.et_negotiation_email);
        et_negotiation_departmnet = (EditText)findViewById(R.id.et_negotiation_departmnet);
        et_order_status = (EditText) findViewById(R.id.et_order_status);
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
        et_covings = (EditText) findViewById(R.id.et_covings);
        et_height = (EditText)findViewById(R.id.et_height);
        et_coving_current_status = (EditText)findViewById(R.id.et_coving_current_status);

        ll_joint_checks = (LinearLayout)findViewById(R.id.ll_joint_checks);



        et_floor_area = (EditText)findViewById(R.id.et_floor_area);
        et_floor_type = (EditText)findViewById(R.id.et_floor_type);
        et_specify = (EditText)findViewById(R.id.et_specify);

        et_concrete_floor_strength = (EditText) findViewById(R.id.et_concrete_floor_strength);
        et_floor_hardener = (EditText)findViewById(R.id.et_floor_hardener);
        et_if_yes = (EditText)findViewById(R.id.et_if_yes);
        et_scratching_surface = (EditText)findViewById(R.id.et_scratching_surface);
        et_problem_with_soundness_floor = (EditText)findViewById(R.id.et_problem_with_soundness_floor);
        et_check_of_moisture = (EditText)findViewById(R.id.et_check_of_moisture);
        et_cracks_pits = (EditText)findViewById(R.id.et_cracks_pits);
        et_check_of_ = (EditText)findViewById(R.id.et_check_of_);
        et_movementon_thefloor = (EditText)findViewById(R.id.et_movementon_thefloor);
        et_sound_of_floor = (EditText)findViewById(R.id.et_sound_of_floor);


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

        et_expansion_joints = (EditText) findViewById(R.id.et_expansion_joints);
        et_width_mm = (EditText)findViewById(R.id.et_width_mm);
        et_depth_cms = (EditText)findViewById(R.id.et_depth_cms);
        et_expansion_joints_current_status = (EditText)findViewById(R.id.et_expansion_joints_current_status);
        et_construction_joints = (EditText)findViewById(R.id.et_construction_joints);
        et_width_construction = (EditText)findViewById(R.id.et_width_construction);
        et_depth_construction = (EditText)findViewById(R.id.et_depth_construction);
        et_construction_joints_current_status = (EditText)findViewById(R.id.et_construction_joints_current_status);





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

        ll_ifyes = (LinearLayout)findViewById(R.id.ll_ifyes);
        ll_problem_with_soundness = (LinearLayout)findViewById(R.id.ll_problem_with_soundness);




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
        FontUtils.changeFont(getApplicationContext(),txt_customer_type, AppConstant.FONT_SANS_SEMIBOLD);
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
        FontUtils.changeFont(getApplicationContext(),et_customertype, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_business_name, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_territory, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_decision_maker, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_designation, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_email, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_department, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_contact_no, AppConstant.FONT_SANS_SEMIBOLD);

        FontUtils.changeFont(getApplicationContext(),et_industry_segment, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_state, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_address, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_distrct, AppConstant.FONT_SANS_SEMIBOLD);
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
        FontUtils.changeFont(getApplicationContext(),et_covings, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_height, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_coving_current_status,AppConstant.FONT_SANS_SEMIBOLD);

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
        FontUtils.changeFont(getApplicationContext(),et_order_status, AppConstant.FONT_SANS_SEMIBOLD);

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
        FontUtils.changeFont(getApplicationContext(),et_floor_type,AppConstant.FONT_SANS_SEMIBOLD);
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
        FontUtils.changeFont(getApplicationContext(),et_floor_hardener,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_if_yes,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_scratching_surface,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_problem_with_soundness_floor,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_check_of_moisture,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_cracks_pits,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_check_of_,AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_movementon_thefloor,AppConstant.FONT_SANS_SEMIBOLD);
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
        FontUtils.changeFont(getApplicationContext(),et_expansion_joints, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_width_mm, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_depth_cms, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_expansion_joints_current_status, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_construction_joints, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_width_construction, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_depth_construction, AppConstant.FONT_SANS_SEMIBOLD);
        FontUtils.changeFont(getApplicationContext(),et_construction_joints_current_status, AppConstant.FONT_SANS_SEMIBOLD);




        et_project_status.setText("" + projectNPModel.getProjectStatus());
        et_deadline.setText("" + projectNPModel.getDeadline());
        et_form_reference_no.setText("" + projectNPModel.getFormReferenceNo());
        et_form_reference_no.setText("" + projectNPModel.getFormReferenceNo());
        et_customertype.setText("" + projectNPModel.getCustomerType());
        et_business_name.setText("" + projectNPModel.getBusinessName());
        et_territory.setText("" + projectNPModel.getTerritory());
        et_industry_segment.setText("" + projectNPModel.getSegment());
        et_state.setText("" + projectNPModel.getState());
        et_address.setText("" + projectNPModel.getAddress());
        et_distrct.setText("" + projectNPModel.getDistrict());
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
        et_sampling_required.setText("" + projectNPModel.getSamplingRequired());
        et_negotiation_person.setText("" + projectNPModel.getNegotiatingPerson());
        et_negotiation_designation.setText("" + projectNPModel.getDesignationNegotiatingPerson());
        et_negotiation_contact_no.setText("" + projectNPModel.getContactNoNegotiatingPerson());
        et_negotiation_email.setText("" + projectNPModel.getEmailNegotiatingPerson());
        et_negotiation_departmnet.setText("" + projectNPModel.getDepartmentNegotiatingPerson());
        et_order_status.setText(("" + projectNPModel.getOrderStatus()));
        et_sampling_required.setText("" + projectNPModel.getSamplingRequired());
        if (et_order_status.getText().toString().equals("Confirmed")){
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
        }

        et_desicion_making_details.setText("" + projectNPModel.getDecisionMaker());
        et_designation_sampling_details.setText("" + projectNPModel.getDesignationSampling());
        et_contact_sampling.setText("" + projectNPModel.getContactNoSampling());
        et_email_sampling.setText("" + projectNPModel.getEmailInspection());
        et_department_Sampling.setText("" + projectNPModel.getDepartmentInspection());
        et_date.setText("" + projectNPModel.getDate());
        et_week.setText("" + projectNPModel.getWeek());

        et_concrete_floor_strength.setText("" + projectNPModel.getConcreteFloorStrength());
        et_floor_hardener.setText("" + projectNPModel.getFloorHardnerOrAnyCuringAgent());
        if (projectNPModel.getFloorHardnerOrAnyCuringAgent().equals("Yes")){
            ll_ifyes.setVisibility(View.VISIBLE);
            et_if_yes.setText("" + projectNPModel.getFloorHardnerOrAnyCuringAgentYes());
        }else if (projectNPModel.getFloorHardnerOrAnyCuringAgent().equals("No")){
            ll_ifyes.setVisibility(View.GONE);
        }
        et_sound_of_floor.setText("" + projectNPModel.getSoundnessOfTheFloor());
        if (projectNPModel.getSoundnessOfTheFloor().equals("Yes")){
            ll_problem_with_soundness.setVisibility(View.GONE);
        }else if (projectNPModel.getSoundnessOfTheFloor().equals("No")){
            ll_problem_with_soundness.setVisibility(View.VISIBLE);
            et_problem_with_soundness_floor.setText("" + projectNPModel.getSoundnessOfTheFloorProblems());
        }

        et_scratching_surface.setText("" + projectNPModel.getScratchingTheSurface());
        et_check_of_moisture.setText("" + projectNPModel.getCheckofMoisture());
        et_cracks_pits.setText("" + projectNPModel.getCracksPitPots());
        et_check_of_.setText("" + projectNPModel.getImpuritiesOnFloor());
        et_movementon_thefloor.setText("" + projectNPModel.getFloorUndulations());

        et_covings.setText("" + projectNPModel.getCoving());
        et_height.setText("" + projectNPModel.getHeightCoving());
        et_coving_current_status.setText("" + projectNPModel.getCovingCurrentStatus());

        et_expansion_joints.setText("" + projectNPModel.getExpansionJoints());
        et_width_mm.setText("" + projectNPModel.getWidthJoints());
        et_depth_cms.setText("" + projectNPModel.getDepth());
        et_expansion_joints_current_status.setText("" + projectNPModel.getExpansioJointCurrentStatus());

        et_construction_joints.setText("" +projectNPModel.getConstructionJoints());
        et_width_construction.setText("" + projectNPModel.getWidth());
        et_construction_joints_current_status.setText("" + projectNPModel.getConstructionJointsCurrentStatus());


 //       new GetRemarksDetails().execute();

    }

    public class GetRemarksDetails extends AsyncTask<Void,Void,ProjectNpModelTwo>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ProjectNpModelTwo doInBackground(Void... voids) {
            ApiService service = ApiClient.getApiService();
            Call<ProjectNpModelTwo> call = service.getRemarksData(projectNPModel.getId());
            try {
                projectNpModelTwo = (ProjectNpModelTwo) call.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return projectNpModelTwo;
        }

        @Override
        protected void onPostExecute(ProjectNpModelTwo projectNpModelTwo) {
            recyclerviewLayout = new LinearLayoutManager(ViewNpActivity.this);
            recyclerview.setLayoutManager(recyclerviewLayout);
            remarksAdapter = new RemarksAdapter(getApplicationContext(),projectNpModelTwos);
            recyclerview.setAdapter(remarksAdapter);
            remarksAdapter.notifyDataSetChanged();
        }
    }
}
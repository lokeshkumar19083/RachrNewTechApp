package com.example.rachrnewtechapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Activities.EditUserActivity;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.AddDARFCDetail;
import com.example.rachrnewtechapp.Model.DcrResponseIdModel;
import com.example.rachrnewtechapp.Model.DcrResponseModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.List;

public class ViewDcrAdapter extends RecyclerView.Adapter<ViewDcrAdapter.MyViewHolder> {

    private Context context;
    private List<AddDARFCDetail> addDARFCDetails;

    public ViewDcrAdapter(Context context, List<AddDARFCDetail> addDARFCDetails) {
        this.context = context;
        this.addDARFCDetails = addDARFCDetails;
    }

    @NonNull
    @Override
    public ViewDcrAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_viewdcr_adapter,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewDcrAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final AddDARFCDetail addDARFCDetail = addDARFCDetails.get(position);
        if (addDARFCDetail != null){
            holder.setData(addDARFCDetail);
            holder.txt_srno.setText(String.valueOf(position + 1));
        }

        holder.ll_drop_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean expanded = addDARFCDetail.isExpanded();
                addDARFCDetail.setExpanded(!expanded);

                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return addDARFCDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private Spinner spinner_one;
        private TextView txt_userType,txt_class,txt_srno,sr_no;
        private LinearLayout ll_drop_down;
        private TextView txt_custome_name,busineename,industry,txt_address,txt_location,txt_state,txt_district,txt_concered_person,txt_reasonofvisit;
        private EditText et_username,et_business_name,et_industry_segment,et_address,et_location,et_state,et_district,et_concerned_person;
        private AddDARFCDetail addDARFCDetail;
        private CardView card_view,card_viewOne;
        private TextView txt_customer_type,txt_desgnation,txt_department,txt_email,txt_contactno;
        private EditText et_customer_type,et_designation,et_department,et_email,et_contact_no,et_reasonVisit;
        private LinearLayout ll_layout,ll_non_prospect,ll_customer;
        private TextView txt_visit_report,txt_floor_type,txt_floor_area,txt_select_contact_manager,txt_manager,name,contact_no,txt_email_one;
        private EditText et_visitreport,et_floor_type,et_floor_area,et_contact_no_two,et_email_one,et_name;
        private CheckBox check_one,check_two,check_three;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spinner_one = (Spinner)itemView.findViewById(R.id.spinner_one);
            txt_userType= (TextView)itemView.findViewById(R.id.txt_userType);
            txt_class = (TextView)itemView.findViewById(R.id.txt_class);
            ll_drop_down = (LinearLayout)itemView.findViewById(R.id.ll_drop_down);
            txt_srno = (TextView)itemView.findViewById(R.id.txt_srno);
            sr_no = (TextView)itemView.findViewById(R.id.sr_no);
            txt_custome_name = (TextView)itemView.findViewById(R.id.txt_custome_name);
            busineename = (TextView)itemView.findViewById(R.id.busineename);
            industry = (TextView)itemView.findViewById(R.id.industry);
            txt_address = (TextView)itemView.findViewById(R.id.txt_address);
            txt_location = (TextView)itemView.findViewById(R.id.txt_location);
            txt_state = (TextView)itemView.findViewById(R.id.txt_state);
            txt_district = (TextView)itemView.findViewById(R.id.txt_district);
            txt_concered_person = (TextView)itemView.findViewById(R.id.txt_concered_person);
            txt_department = (TextView)itemView.findViewById(R.id.txt_department);
            ll_layout = (LinearLayout)itemView.findViewById(R.id.ll_layout);
            et_contact_no = (EditText) itemView.findViewById(R.id.et_contact_no);
            txt_email = (TextView)itemView.findViewById(R.id.txt_email);
            txt_contactno = (TextView)itemView.findViewById(R.id.txt_contactno);
            txt_reasonofvisit = (TextView)itemView.findViewById(R.id.txt_reasonofvisit);
            txt_visit_report = (TextView)itemView.findViewById(R.id.txt_visit_report);
            txt_floor_type = (TextView)itemView.findViewById(R.id.txt_floor_type);
            txt_floor_area = (TextView)itemView.findViewById(R.id.txt_floor_area);
            txt_select_contact_manager = (TextView)itemView.findViewById(R.id.txt_select_contact_manager);
            txt_manager = (TextView)itemView.findViewById(R.id.txt_manager);
            name = (TextView)itemView.findViewById(R.id.name);
            contact_no = (TextView)itemView.findViewById(R.id.contact_no);
            txt_email_one = (TextView)itemView.findViewById(R.id.txt_email_one);
            et_name = (EditText)itemView.findViewById(R.id.et_name);
            ll_non_prospect = (LinearLayout)itemView.findViewById(R.id.ll_non_prospect);
            ll_customer = (LinearLayout)itemView.findViewById(R.id.ll_customer);



            et_username = (EditText)itemView.findViewById(R.id.et_username);
            et_business_name = (EditText)itemView.findViewById(R.id.et_business_name);
            et_industry_segment = (EditText)itemView.findViewById(R.id.et_industry_segment);
            et_address = (EditText)itemView.findViewById(R.id.et_address);
            et_location = (EditText)itemView.findViewById(R.id.et_location);
            et_state = (EditText)itemView.findViewById(R.id.et_state);
            et_district = (EditText)itemView.findViewById(R.id.et_district);
            et_concerned_person = (EditText)itemView.findViewById(R.id.et_concerned_person);
            txt_customer_type = (TextView)itemView.findViewById(R.id.txt_customer_type);
            txt_desgnation = (TextView)itemView.findViewById(R.id.txt_desgnation);
            et_customer_type = (EditText) itemView.findViewById(R.id.et_customer_type);
            et_designation = (EditText)itemView.findViewById(R.id.et_designation);
            et_department = (EditText)itemView.findViewById(R.id.et_department);
            et_email = (EditText)itemView.findViewById(R.id.et_email);
            et_reasonVisit = (EditText)itemView.findViewById(R.id.et_reasonVisit);
            card_view = (CardView)itemView.findViewById(R.id.card_view);
            card_viewOne = (CardView)itemView.findViewById(R.id.card_viewOne);

            et_visitreport = (EditText)itemView.findViewById(R.id.et_visitreport);
            et_floor_type = (EditText)itemView.findViewById(R.id.et_floor_type);
            et_floor_area = (EditText)itemView.findViewById(R.id.et_floor_area);
            et_contact_no_two = (EditText)itemView.findViewById(R.id.et_contact_no_two);
            et_email_one = (EditText)itemView.findViewById(R.id.et_email_one);

            check_one = (CheckBox)itemView.findViewById(R.id.check_one);
            check_two = (CheckBox)itemView.findViewById(R.id.check_two);
            check_three = (CheckBox)itemView.findViewById(R.id.check_three);





            FontUtils.changeFont(context,txt_userType, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_srno,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_class,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,sr_no,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_custome_name, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,busineename,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,industry,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_address,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_location, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_state,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_district,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_concered_person,AppConstant.FONT_SANS_SEMIBOLD);

            FontUtils.changeFont(context,et_username, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_business_name,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_industry_segment,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_address,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_location, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_state,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_district,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_concerned_person,AppConstant.FONT_SANS_SEMIBOLD);

            FontUtils.changeFont(context,txt_customer_type, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_desgnation,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_department,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_email,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_contactno, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_customer_type,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_designation,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_department,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_email,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_contact_no,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_reasonofvisit,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_reasonVisit,AppConstant.FONT_SANS_SEMIBOLD);


            FontUtils.changeFont(context,txt_visit_report, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_floor_type,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_floor_area,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_manager,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_select_contact_manager, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,name,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,contact_no,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_email_one,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_visitreport,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_floor_type,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_floor_area,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_contact_no_two,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_email_one,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,et_name,AppConstant.FONT_SANS_SEMIBOLD);

        }

        public void setData(final AddDARFCDetail addDARFCDetail){
            this.addDARFCDetail = addDARFCDetail;
            boolean expanded = addDARFCDetail.isExpanded();
            ll_layout.setVisibility(expanded ? View.VISIBLE : View.GONE);
                String compareValueOne = addDARFCDetail.getSelectedCustomerClass();
                ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.customer_class, R.layout.spinner_item);
                adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner_one.setAdapter(adapterOne);
                if (compareValueOne != null) {
                    int spinnerPosition = adapterOne.getPosition(compareValueOne);
                    spinner_one.setSelection(spinnerPosition);

            }

                spinner_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (spinner_one.getSelectedItem().toString().trim().equals("New")){
                            card_view.setVisibility(View.GONE);
                            card_viewOne.setVisibility(View.VISIBLE);
                       //     et_contact_no.setVisibility(View.VISIBLE);

                            et_username.setText(""+ addDARFCDetail.getBusinessName());
                            et_business_name.setText(""+ addDARFCDetail.getSelectedBusinessName());
                            et_industry_segment.setText("" + addDARFCDetail.getIndustry());
                            et_address.setText("" + addDARFCDetail.getAddress());
                            et_location.setText("" + addDARFCDetail.getLocation());
                            et_state.setText("" + addDARFCDetail.getState());
                            et_district.setText("" + addDARFCDetail.getDistrict());
                            et_concerned_person.setText("" + addDARFCDetail.getConcernedPerson());
                            et_contact_no.setText("" + addDARFCDetail.getContactNo());
                            et_visitreport.setText(""+addDARFCDetail.getSelectedVisitReport());
                            if (addDARFCDetail.getSelectedVisitReport().equals("Non-Prospect")){
                                ll_non_prospect.setVisibility(View.VISIBLE);
                                card_view.setVisibility(View.GONE);
                                et_floor_type.setText("" + addDARFCDetail.getSelectedFloorType());
                                et_floor_area.setText("" + addDARFCDetail.getArea());
                                if (addDARFCDetail.getSelectedPM().equals("Purchase Manager")){
                                    check_one.setChecked(true);
                                    txt_manager.setText("Purchase Manger");
                                    et_name.setText(""+addDARFCDetail.getPurchaseManagerName());
                                    et_contact_no_two.setText("" + addDARFCDetail.getPurchaseManagerContact());
                                    et_email_one.setText("" + addDARFCDetail.getPurchaseManagerEmail());

                                }else if (addDARFCDetail.getSelectedPM().equals("Maintenance Manager")){
                                    check_two.setChecked(true);
                                    txt_manager.setText("Maintenance Manager");
                                    et_name.setText(""+addDARFCDetail.getMaintenanceManagerName());
                                    et_contact_no_two.setText("" + addDARFCDetail.getMaintenanceManagerContact());
                                    et_email_one.setText("" + addDARFCDetail.getMaintenanceManagerEmail());
                                }else if (addDARFCDetail.getSelectedCM().equals("Civil Manager")){
                                    check_three.setChecked(true);
                                    txt_manager.setText("Civil Manager");
                                    et_name.setText(""+addDARFCDetail.getCivilManagerName());
                                    et_contact_no_two.setText("" + addDARFCDetail.getCivilManagerContact());
                                    et_email_one.setText("" + addDARFCDetail.getCivilManagerEmail());
                                }else {

                                }

                            }else if (addDARFCDetail.getSelectedVisitReport().equals("Prospect")){
                                ll_non_prospect.setVisibility(View.GONE);
                                card_view.setVisibility(View.VISIBLE);
                                ll_customer.setVisibility(View.GONE);
                                et_customer_type.setText("" + addDARFCDetail.getCustomerType());
                                et_designation.setText("" + addDARFCDetail.getDesignation());
                                et_department.setText("" + addDARFCDetail.getDepartment());
                                et_email.setText("" + addDARFCDetail.getEmail());
                       //         et_contact_no.setVisibility(View.GONE);
                                et_reasonVisit.setVisibility(View.GONE);
                            }


                        }else if (spinner_one.getSelectedItem().toString().trim().equals("Existing")){
                            card_view.setVisibility(View.VISIBLE);
                            card_viewOne.setVisibility(View.GONE);

                            et_username.setText(""+ addDARFCDetail.getBusinessName());
                            et_business_name.setText(""+ addDARFCDetail.getSelectedBusinessName());
                            et_industry_segment.setText("" + addDARFCDetail.getIndustry());
                            et_address.setText("" + addDARFCDetail.getAddress());
                            et_location.setText("" + addDARFCDetail.getLocation());
                            et_state.setText("" + addDARFCDetail.getState());
                            et_district.setText("" + addDARFCDetail.getDistrict());
                            et_concerned_person.setText("" + addDARFCDetail.getConcernedPerson());
                            et_customer_type.setText("" + addDARFCDetail.getCustomerType());
                            et_designation.setText("" + addDARFCDetail.getDesignation());
                            et_department.setText("" + addDARFCDetail.getDepartment());
                            et_email.setText("" + addDARFCDetail.getEmail());
                            et_contact_no.setText("" + addDARFCDetail.getContactNo());
                            et_reasonVisit.setText("" + addDARFCDetail.getSelectedReasonVisit());
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });







        }
    }
}

package com.example.rachrnewtechapp.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Activities.CreateDCRActivity;
import com.example.rachrnewtechapp.Activities.EditDCRActivity;
import com.example.rachrnewtechapp.Activities.SaesFormActivity;
import com.example.rachrnewtechapp.Activities.ViewDCRReportActivity;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.AddDARFCDetail;
import com.example.rachrnewtechapp.Model.DcrResponseModel;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DCRAdapter extends RecyclerView.Adapter<DCRAdapter.MyViewHolder> {

    private Context context;
    private List<DcrResponseModel> dcrResponseModels;

    public DCRAdapter(Context context, List<DcrResponseModel> dcrResponseModels) {
        this.context = context;
        this.dcrResponseModels = dcrResponseModels;
    }

    @NonNull
    @Override
    public DCRAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dcr_adapter,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DCRAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final DcrResponseModel dcrResponseModel = dcrResponseModels.get(position);
        if (dcrResponseModel != null){
            holder.setData(dcrResponseModel);
            holder.txt_srno.setText(String.valueOf(position + 1));
        }

        holder.ll_drop_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i =0; i<dcrResponseModel.getAddDARFCDetail().size();i++){
                    boolean expanded = dcrResponseModel.getAddDARFCDetail().get(i).isExpanded();
                    dcrResponseModel.getAddDARFCDetail().get(i).setExpanded(!expanded);

                }

                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dcrResponseModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_meter_no_adapter,txt_bill_status_adapter,txt_reporting_adapter,txt_status_adapter,txt_created_on_adapter;
        private TextView txt_territory,txt_employee_name,txt_date,txt_week_year,txt_assigned,sr_no,txt_srno;
        private DcrResponseModel dcrResponseModel;
        private TextView txt_view,txt_delete;
        private LinearLayout ll_delete,ll_edit;
        private TextView view_balance_activity,header_ioclBalance,txt_no,billingTV;
        private LinearLayout ll_no,ll_yes;
        private TextView username;
        private TextView txt_businee_name,txt_visit_report,txt_customer_class,txt_location;
        private TextView txt_business_name,visit_report,customer_class,location;
     //   private ArrayList<AddDARFCDetail> addDARFCDetails = new ArrayList<>();
        ArrayList<AddDARFCDetail> addDARFCDetails;
        private LinearLayout ll_click,ll_drop_down;
        private ImageView image_up,image_down;
        private RecyclerView recyclerview;
        private InnerAdapter innerAdapter;
        private RecyclerView.LayoutManager recyclerviewLayout, recyclerviewlayout_one,recyclerview_two;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sr_no = (TextView)itemView.findViewById(R.id.sr_no);
            txt_srno = (TextView)itemView.findViewById(R.id.txt_srno);
            txt_meter_no_adapter = (TextView)itemView.findViewById(R.id.txt_meter_no_adapter);
            txt_bill_status_adapter = (TextView)itemView.findViewById(R.id.txt_bill_status_adapter);
            txt_reporting_adapter = (TextView)itemView.findViewById(R.id.txt_reporting_adapter);
            txt_status_adapter = (TextView)itemView.findViewById(R.id.txt_status_adapter);
            txt_territory = (TextView)itemView.findViewById(R.id.txt_territory);
            txt_employee_name = (TextView)itemView.findViewById(R.id.txt_employee_name);
            txt_date = (TextView)itemView.findViewById(R.id.txt_date);
            txt_week_year = (TextView)itemView.findViewById(R.id.txt_week_year);
            txt_view = (TextView)itemView.findViewById(R.id.txt_view);
            txt_delete = (TextView)itemView.findViewById(R.id.txt_delete);
            ll_delete = (LinearLayout)itemView.findViewById(R.id.ll_delete);
            ll_edit = (LinearLayout)itemView.findViewById(R.id.ll_edit);
            ll_click = (LinearLayout)itemView.findViewById(R.id.ll_click);
            ll_drop_down = (LinearLayout)itemView.findViewById(R.id.ll_drop_down);
            txt_businee_name = (TextView)itemView.findViewById(R.id.txt_businee_name);
            txt_visit_report = (TextView)itemView.findViewById(R.id.txt_visit_report);
            txt_customer_class = (TextView)itemView.findViewById(R.id.txt_customer_class);
            txt_location = (TextView)itemView.findViewById(R.id.txt_location);
            image_up = (ImageView)itemView.findViewById(R.id.image_up);
            image_down = (ImageView)itemView.findViewById(R.id.image_down);

            txt_business_name = (TextView)itemView.findViewById(R.id.txt_business_name);
            visit_report = (TextView)itemView.findViewById(R.id.visit_report);
            customer_class = (TextView)itemView.findViewById(R.id.customer_class);
            location = (TextView)itemView.findViewById(R.id.location);
            recyclerview = (RecyclerView)itemView.findViewById(R.id.recyclerview);
        }

        public void setData(final DcrResponseModel dcrResponseModel){
            this.dcrResponseModel = dcrResponseModel;
            addDARFCDetails = dcrResponseModel.getAddDARFCDetail();
            txt_territory.setText("" + dcrResponseModel.getTerritory());
            txt_employee_name.setText("" + dcrResponseModel.getEmployeeName());
            txt_date.setText("" + dcrResponseModel.getCreatedOn());
            txt_week_year.setText("" + dcrResponseModel.getWeekAndYear());


            for (int i=0;i<addDARFCDetails.size();i++){
                boolean expanded = addDARFCDetails.get(i).isExpanded();
                ll_click.setVisibility(expanded ? View.VISIBLE : View.GONE);

                recyclerview_two = new LinearLayoutManager(context);
                recyclerview.setLayoutManager(recyclerview_two);
                innerAdapter= new InnerAdapter(context,addDARFCDetails,dcrResponseModel);
                recyclerview.setAdapter(innerAdapter);
                if (!expanded){
                    recyclerview.setVisibility(View.GONE);
                }else {
                    recyclerview.setVisibility(View.VISIBLE);
                }
                innerAdapter.notifyDataSetChanged();
            }

            ll_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ViewDCRReportActivity.class);
                    intent.putExtra("addDARFCDetails",addDARFCDetails);
                    intent.putExtra("dcrResponseModel",dcrResponseModel);
                    context.startActivity(intent);
                }
            });

            ll_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_delete_user,null,false);
                    view_balance_activity = (TextView)dialogView.findViewById(R.id.view_balance_activity);
                    header_ioclBalance = (TextView)dialogView.findViewById(R.id.header_ioclBalance);
                    txt_no = (TextView)dialogView.findViewById(R.id.txt_no);
                    billingTV = (TextView)dialogView.findViewById(R.id.billingTV);
                    ll_no = (LinearLayout)dialogView.findViewById(R.id.ll_no);
                    ll_yes = (LinearLayout)dialogView.findViewById(R.id.ll_yes);
                    username = (TextView)dialogView.findViewById(R.id.username);
                    username.setText("" + dcrResponseModel.getEmployeeName() +  " " + "?");

                    builder.setView(dialogView);
                    final AlertDialog dialog = builder.create();
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                    FontUtils.changeFont(context,txt_no,AppConstant.FONT_SANS_SEMIBOLD);
                    FontUtils.changeFont(context,billingTV,AppConstant.FONT_SANS_SEMIBOLD);
                    FontUtils.changeFont(context,view_balance_activity,AppConstant.FONT_SANS_SEMIBOLD);
                    FontUtils.changeFont(context,header_ioclBalance,AppConstant.FONT_SANS_SEMIBOLD);
                    FontUtils.changeFont(context,username,AppConstant.FONT_SANS_SEMIBOLD);

                    ll_no.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    ll_yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ApiService service = ApiClient.getApiService();
                            Call<Boolean> call = service.deleteDCREPORT(dcrResponseModel.getId());
                            call.enqueue(new Callback<Boolean>() {
                                @Override
                                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                    if (!response.isSuccessful()){
                                        return;
                                    }
                                    Toast.makeText(context,"DCR Deleted Successfully",Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }

                                @Override
                                public void onFailure(Call<Boolean> call, Throwable t) {
                                }
                            });

                        }
                    });
                    dialog.show();
                }
            });


            FontUtils.changeFont(context,sr_no, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_srno,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_meter_no_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_bill_status_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_reporting_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_status_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_territory,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_employee_name,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_date,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_week_year,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_view,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_delete,AppConstant.FONT_SANS_SEMIBOLD);

            FontUtils.changeFont(context,txt_businee_name, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_visit_report,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_customer_class,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_location,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_business_name,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,visit_report,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,customer_class,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,location,AppConstant.FONT_SANS_SEMIBOLD);

        }
    }

    public void filterList(ArrayList<DcrResponseModel> filteredList) {
        dcrResponseModels = filteredList;
        notifyDataSetChanged();
    }
}

package com.example.rachrnewtechapp.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Activities.EditUserActivity;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.MainActivity;
import com.example.rachrnewtechapp.Model.GetUserIdDetails;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageUserAdapter extends RecyclerView.Adapter<ManageUserAdapter.MyViewHolder> {
    private Context context;
    private List<GetUserListModel> getUserListModel;


    public ManageUserAdapter(Context context, List<GetUserListModel> getUserListModel) {
        this.context = context;
        this.getUserListModel = getUserListModel;
    }

    @Override
    public ManageUserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.manage_user_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ManageUserAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
       final GetUserListModel getUserListModelone = getUserListModel.get(position);
       if (getUserListModelone != null){
         holder.setData(getUserListModelone);
         holder.txt_srno.setText(String.valueOf(position + 1));
       }

/*
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            boolean expanded = getUserListModelone.isExpanded();
            getUserListModelone.setExpanded(!expanded);
            notifyItemChanged(position);
           }
       });*/
    }

    @Override
    public int getItemCount() {
        return getUserListModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_username,txt_emailid,txt_userType,txt_department,txt_address,txt_reporting_on,txt_created_on;
        private GetUserListModel getUserListModel;
        private LinearLayout ll_expand;
        private TextView txt_srno;
        private TextView txt_user,txt_consumer_id_adapter,txt_name_adapter,txt_meter_no_adapter,txt_bill_status_adapter,txt_reporting_adapter,txt_created_on_adapter;
        private TextView sr_no,txt_edit,txt_delete;
        private LinearLayout ll_edit,ll_delete;
        private TextView view_balance_activity,header_ioclBalance,txt_no,billingTV;
        private LinearLayout ll_no,ll_yes;
        private TextView username;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_username = (TextView)itemView.findViewById(R.id.txt_username);
            txt_emailid = (TextView)itemView.findViewById(R.id.txt_emailid);
            txt_userType = (TextView)itemView.findViewById(R.id.txt_userType);
            txt_department = (TextView)itemView.findViewById(R.id.txt_department);
            txt_address = (TextView)itemView.findViewById(R.id.txt_address);
            txt_reporting_on = (TextView)itemView.findViewById(R.id.txt_reporting_on);
            txt_created_on = (TextView)itemView.findViewById(R.id.txt_created_on);
            txt_user = (TextView)itemView.findViewById(R.id.txt_user);
            txt_consumer_id_adapter = (TextView)itemView.findViewById(R.id.txt_consumer_id_adapter);
            txt_name_adapter = (TextView)itemView.findViewById(R.id.txt_name_adapter);
            txt_meter_no_adapter = (TextView)itemView.findViewById(R.id.txt_meter_no_adapter);
            txt_bill_status_adapter = (TextView)itemView.findViewById(R.id.txt_bill_status_adapter);
            txt_reporting_adapter = (TextView)itemView.findViewById(R.id.txt_reporting_adapter);
            txt_created_on_adapter = (TextView)itemView.findViewById(R.id.txt_created_on_adapter);
            txt_srno = (TextView)itemView.findViewById(R.id.txt_srno);
            sr_no = (TextView)itemView.findViewById(R.id.sr_no);
            txt_edit = (TextView)itemView.findViewById(R.id.txt_edit);
            txt_delete = (TextView)itemView.findViewById(R.id.txt_delete);
            ll_edit = (LinearLayout)itemView.findViewById(R.id.ll_edit);
            ll_delete = (LinearLayout)itemView.findViewById(R.id.ll_delete);


            FontUtils.changeFont(context,txt_username, AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_emailid,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_userType,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_department,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_address,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_reporting_on,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_created_on,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_srno, AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_user,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_consumer_id_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_name_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_meter_no_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_bill_status_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_reporting_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_created_on_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,sr_no,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_edit,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_delete,AppConstant.FONT_SANS_SEMIBOLD);

        }

        public void setData(final GetUserListModel getUserListModel){
            this.getUserListModel = getUserListModel;
           /* boolean expanded = getUserListModel.isExpanded();
            ll_expand.setVisibility(expanded ? View.VISIBLE : View.GONE);*/
            txt_username.setText("" + getUserListModel.getUserName());
            txt_emailid.setText("" + getUserListModel.getUserEmail());
            txt_userType.setText("" + getUserListModel.getUserType());
            txt_department.setText("" + getUserListModel.getUserDeptName());
            txt_address.setText("" + getUserListModel.getAddress());
            txt_reporting_on.setText("" + getUserListModel.getReporting());
            txt_created_on.setText("" + getUserListModel.getCreatedOn());

             ll_edit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent intent = new Intent(context, EditUserActivity.class);
                     intent.putExtra("getUserListModel",getUserListModel);
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
                    username.setText("" + getUserListModel.getUserName() +  " " + "?");

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
                            Call<Void> call = service.deleteuser(getUserListModel.getId());
                            call.enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {
                                    if (!response.isSuccessful()){
                                        return;
                                    }
                                    Toast.makeText(context,"User Deleted Successfully",Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {

                                }
                            });

                        }
                    });
                    dialog.show();
                }
            });
        }
    }

    public void filterList(ArrayList<GetUserListModel> filteredList) {
        getUserListModel = filteredList;
        notifyDataSetChanged();
    }

}

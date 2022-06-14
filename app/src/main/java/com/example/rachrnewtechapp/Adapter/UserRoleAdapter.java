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

import com.example.rachrnewtechapp.Activities.EditRoleActivity;
import com.example.rachrnewtechapp.Activities.ViewRoleActivity;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.GetUserRoleData;
import com.example.rachrnewtechapp.Model.UserRoleDepartmentModel;
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

public class UserRoleAdapter extends RecyclerView.Adapter<UserRoleAdapter.MyViewHolder> {

    private Context context;
    private List<GetUserRoleData> getUserRoleDataList;

    public UserRoleAdapter(Context context, List<GetUserRoleData> getUserRoleDataList) {
        this.context = context;
        this.getUserRoleDataList = getUserRoleDataList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_role_adapter,parent,false);
        return new UserRoleAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final GetUserRoleData getUserRoleDataOne = getUserRoleDataList.get(position);
        if (getUserRoleDataOne != null){
            holder.setData(getUserRoleDataOne);
            holder.txt_srno.setText(String.valueOf(position + 1));
        }
    }

    @Override
    public int getItemCount() {
        return getUserRoleDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_user,txt_name_adapter,txt_meter_no_adapter,txt_bill_status_adapter,txt_reporting_adapter,txt_created_on_adapter,txt_modified_on_adapter;
        private TextView txt_userType,txt_username,txt_department,txt_form,txt_isActive,txt_Created_on,txt_modified_on;
        private GetUserRoleData getUserRoleData;
        private TextView txt_edit,txt_view,txt_delete,sr_no,txt_srno;
        private LinearLayout ll_edit,ll_view,ll_delete;
        private TextView view_balance_activity,header_ioclBalance,txt_no,billingTV;
        private LinearLayout ll_no,ll_yes;
        private TextView username;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_user = (TextView)itemView.findViewById(R.id.txt_user);
            txt_name_adapter = (TextView)itemView.findViewById(R.id.txt_name_adapter);
            txt_meter_no_adapter = (TextView)itemView.findViewById(R.id.txt_meter_no_adapter);
            txt_bill_status_adapter = (TextView)itemView.findViewById(R.id.txt_bill_status_adapter);
            txt_reporting_adapter = (TextView)itemView.findViewById(R.id.txt_reporting_adapter);
            txt_created_on_adapter = (TextView)itemView.findViewById(R.id.txt_created_on_adapter);
            txt_modified_on_adapter = (TextView)itemView.findViewById(R.id.txt_modified_on_adapter);

            txt_userType = (TextView)itemView.findViewById(R.id.txt_userType);
            txt_username = (TextView)itemView.findViewById(R.id.txt_username);
            txt_department = (TextView)itemView.findViewById(R.id.txt_department);
            txt_form = (TextView)itemView.findViewById(R.id.txt_form);
            txt_isActive = (TextView)itemView.findViewById(R.id.txt_isActive);
            txt_Created_on = (TextView)itemView.findViewById(R.id.txt_Created_on);
            txt_modified_on = (TextView)itemView.findViewById(R.id.txt_modified_on);
            txt_view = (TextView)itemView.findViewById(R.id.txt_view);


            txt_srno = (TextView)itemView.findViewById(R.id.txt_srno);
            sr_no = (TextView)itemView.findViewById(R.id.sr_no);
            txt_edit = (TextView)itemView.findViewById(R.id.txt_edit);
            txt_delete = (TextView)itemView.findViewById(R.id.txt_delete);
            txt_view = (TextView)itemView.findViewById(R.id.txt_view);
            ll_edit = (LinearLayout)itemView.findViewById(R.id.ll_edit);
            ll_view = (LinearLayout)itemView.findViewById(R.id.ll_view);
            ll_delete = (LinearLayout)itemView.findViewById(R.id.ll_delete);

            FontUtils.changeFont(context,txt_username, AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_form,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_userType,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_department,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_isActive,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_Created_on,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_modified_on,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_user,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_name_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_meter_no_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_bill_status_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_reporting_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_created_on_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_modified_on_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_srno, AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,sr_no,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_edit,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_delete,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_view,AppConstant.FONT_SANS_SEMIBOLD);
        }

        public void setData(final GetUserRoleData getUserRoleData){
            this.getUserRoleData = getUserRoleData;
            txt_username.setText("" + getUserRoleData.getUserName());
            txt_userType.setText("" + getUserRoleData.getUserTypeName());
            txt_department.setText("" + getUserRoleData.getDepartmentName());
            txt_form.setText("" + getUserRoleData.getFormName());
            txt_isActive.setText("" + getUserRoleData.isActive());
            txt_Created_on.setText("" + getUserRoleData.getCreatedOn());
            txt_modified_on.setText("" + getUserRoleData.getModifiedOn());

            ll_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ViewRoleActivity.class);
                    intent.putExtra("getUserRoleData",getUserRoleData);
                    context.startActivity(intent);

                }
            });

            ll_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, EditRoleActivity.class);
                    intent.putExtra("getUserRoleData",getUserRoleData);
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
                    username = (TextView)dialogView.findViewById(R.id.username);
                    billingTV = (TextView)dialogView.findViewById(R.id.billingTV);
                    ll_no = (LinearLayout)dialogView.findViewById(R.id.ll_no);
                    ll_yes = (LinearLayout)dialogView.findViewById(R.id.ll_yes);
                    username.setText("" + getUserRoleData.getUserName() + " " + "?");

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
                           Call<Void> call = service.deleteItem(getUserRoleData.getId());
                           call.enqueue(new Callback<Void>() {
                               @Override
                               public void onResponse(Call<Void> call, Response<Void> response) {
                                   if (!response.isSuccessful()){
                                       return;
                                   }
                                   Toast.makeText(context,"Deleted User Role Sucessessfully",Toast.LENGTH_SHORT).show();
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

    public void filterList(ArrayList<GetUserRoleData> filteredList) {
        getUserRoleDataList = filteredList;
        notifyDataSetChanged();
    }




}

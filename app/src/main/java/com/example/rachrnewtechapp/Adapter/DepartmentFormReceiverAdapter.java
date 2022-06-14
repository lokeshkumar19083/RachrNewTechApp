package com.example.rachrnewtechapp.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Service;
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

import com.example.rachrnewtechapp.Activities.EditDepartmentFormActivity;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.GetUserRoleData;
import com.example.rachrnewtechapp.Model.RemoveFormReciverData;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentFormReceiverAdapter extends RecyclerView.Adapter<DepartmentFormReceiverAdapter.MyViewholder> {

    private Context context;
    private List<DepartmentFormReceiverModel> getDepartmentForm;

    public DepartmentFormReceiverAdapter(Context context, List<DepartmentFormReceiverModel> getDepartmentForm) {
        this.context = context;
        this.getDepartmentForm = getDepartmentForm;
    }

    @NonNull
    @Override
    public DepartmentFormReceiverAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.department_form_reciever_adapter,parent,false);
        return new MyViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentFormReceiverAdapter.MyViewholder holder, @SuppressLint("RecyclerView") int position) {
        final DepartmentFormReceiverModel getDepartmentFormreciver = getDepartmentForm.get(position);
        if (getDepartmentFormreciver != null){
            holder.setData(getDepartmentFormreciver);
            holder.txt_srno.setText(String.valueOf(position + 1));
        }
    }

    @Override
    public int getItemCount() {
        return getDepartmentForm.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        private TextView txt_user,txt_meter_no_adapter,txt_bill_status_adapter,txt_reporting_adapter,txt_status_adapter,txt_created_on_adapter,txt_modified_on_adapter;
        private TextView txt_departmentname,txt_form_name,txt_receiving_department,txt_status,txt_Created_on,txt_modified_on,txt_username;
        private DepartmentFormReceiverModel departmentFormReceiverModel;
        private LinearLayout ll_expand;
        private TextView sr_no,txt_edit,txt_delete;
        private TextView txt_srno;
        private LinearLayout ll_edit,ll_delete;

        private TextView view_balance_activity,header_ioclBalance,txt_no,billingTV;
        private LinearLayout ll_no,ll_yes;
        private TextView username;
        RemoveFormReciverData removeFormReciverData;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            txt_user = (TextView)itemView.findViewById(R.id.txt_user);
            txt_meter_no_adapter = (TextView)itemView.findViewById(R.id.txt_meter_no_adapter);
            txt_bill_status_adapter = (TextView)itemView.findViewById(R.id.txt_bill_status_adapter);
            txt_reporting_adapter = (TextView)itemView.findViewById(R.id.txt_reporting_adapter);
            txt_status_adapter = (TextView)itemView.findViewById(R.id.txt_status_adapter);
            txt_created_on_adapter = (TextView)itemView.findViewById(R.id.txt_created_on_adapter);
            txt_modified_on_adapter = (TextView)itemView.findViewById(R.id.txt_modified_on_adapter);

            txt_username = (TextView)itemView.findViewById(R.id.txt_username);
            txt_departmentname = (TextView)itemView.findViewById(R.id.txt_departmentname);
            txt_form_name = (TextView)itemView.findViewById(R.id.txt_form_name);
            txt_receiving_department = (TextView)itemView.findViewById(R.id.txt_receiving_department);
            txt_status = (TextView)itemView.findViewById(R.id.txt_status);
            txt_Created_on = (TextView)itemView.findViewById(R.id.txt_Created_on);
            txt_modified_on = (TextView)itemView.findViewById(R.id.txt_modified_on);
            txt_srno = (TextView)itemView.findViewById(R.id.txt_srno);
            sr_no = (TextView)itemView.findViewById(R.id.sr_no);
            txt_edit = (TextView)itemView.findViewById(R.id.txt_edit);
            txt_delete = (TextView)itemView.findViewById(R.id.txt_delete);
            ll_delete = (LinearLayout)itemView.findViewById(R.id.ll_delete);
            ll_edit = (LinearLayout)itemView.findViewById(R.id.ll_edit);



            FontUtils.changeFont(context,txt_departmentname, AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_form_name,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_receiving_department,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_status,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_Created_on,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_modified_on,AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_srno, AppConstant.FONT_VARELA_ROUND);
            FontUtils.changeFont(context,txt_user,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_modified_on_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_status_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_meter_no_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_bill_status_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_reporting_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_created_on_adapter,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,sr_no,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_edit,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_delete,AppConstant.FONT_SANS_SEMIBOLD);
        }

        public void setData(final DepartmentFormReceiverModel departmentFormReceiverModel){
            this.departmentFormReceiverModel = departmentFormReceiverModel;
            txt_username.setText("" + departmentFormReceiverModel.getUserName());
            txt_departmentname.setText("" + departmentFormReceiverModel.getDepartmentName());
            txt_status.setText("" + departmentFormReceiverModel.isActive());
            txt_form_name.setText("" + departmentFormReceiverModel.getFormName());
            txt_receiving_department.setText("" + departmentFormReceiverModel.getReceiverDepartmentName());
            txt_Created_on.setText("" + departmentFormReceiverModel.getCreatedOn());
            txt_modified_on.setText("" + departmentFormReceiverModel.getModifiedOn());

            ll_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,EditDepartmentFormActivity.class);
                    intent.putExtra("departmentFormReceiverModel",departmentFormReceiverModel);
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
                    username.setText("" + departmentFormReceiverModel.getUserName() +  " " + "?");

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
                              removeFormReciverData = new RemoveFormReciverData();
                              removeFormReciverData.setId(departmentFormReceiverModel.getRecordID());
                              removeFormReciverData.setDeleted(true);
                              removeFormReciverData.setModifiedBy(departmentFormReceiverModel.getUserName());
                              RemoveUserRole(removeFormReciverData);
                        }
                    });
                    dialog.show();
                }
            });
        }
    }

    public void filterList(ArrayList<DepartmentFormReceiverModel> filteredList) {
        getDepartmentForm = filteredList;
        notifyDataSetChanged();
    }

    public void RemoveUserRole(RemoveFormReciverData removeFormReciverData){
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
                    Call<Boolean> resp = service.removeformReciver(removeFormReciverData);
                    statusResponse = resp.execute().body();

                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                Toast.makeText(context,"Deleted Sucessfully",Toast.LENGTH_SHORT).show();
            }
        };
        task.execute();
    }

}

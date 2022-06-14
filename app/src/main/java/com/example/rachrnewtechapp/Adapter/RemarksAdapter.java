package com.example.rachrnewtechapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.AddDARFCDetail;
import com.example.rachrnewtechapp.Model.AddREDetail;
import com.example.rachrnewtechapp.Model.DcrResponseModel;
import com.example.rachrnewtechapp.Model.ProjectNPModel;
import com.example.rachrnewtechapp.Model.ProjectNpModelTwo;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.ArrayList;
import java.util.List;

public class RemarksAdapter extends RecyclerView.Adapter<RemarksAdapter.MyViewHolder> {
    private Context context;
    private List<ProjectNpModelTwo> projectNPModels;

    public RemarksAdapter(Context context, List<ProjectNpModelTwo> projectNPModels) {
        this.context = context;
        this.projectNPModels = projectNPModels;
    }

    @NonNull
    @Override
    public RemarksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.remark_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RemarksAdapter.MyViewHolder holder, int position) {
        final ProjectNpModelTwo projectNPModel = projectNPModels.get(position);
        if (projectNPModel != null){
            holder.setData(projectNPModel);
        }
    }

    @Override
    public int getItemCount() {
        return projectNPModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_employee_name,txt_date,txt_address;
        private EditText et_form_reference_no,et_customertype,et_address;
        ArrayList<AddREDetail> addREDetails;
        ProjectNpModelTwo projectNpModelTwo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_employee_name = (TextView)itemView.findViewById(R.id.txt_employee_name);
            txt_date = (TextView)itemView.findViewById(R.id.txt_date);
            txt_address= (TextView)itemView.findViewById(R.id.txt_address);
            et_form_reference_no = (EditText)itemView.findViewById(R.id.et_form_reference_no);
            et_customertype = (EditText)itemView.findViewById(R.id.et_customertype);
            et_address = (EditText)itemView.findViewById(R.id.et_address);


            FontUtils.changeFont(context, txt_employee_name, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_date, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_address, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, et_form_reference_no, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, et_customertype, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, et_address, AppConstant.FONT_SANS_SEMIBOLD);
        }

        public void setData(final ProjectNpModelTwo projectNpModelTwo){
            this.projectNpModelTwo = projectNpModelTwo;
            addREDetails = projectNpModelTwo.getAddREDetail();
            for (int i =0;i<addREDetails.size();i++){
                et_form_reference_no.setText("" + addREDetails.get(i).getEmployeeName());
                et_customertype.setText("" + addREDetails.get(i).getDate());
                et_address.setText("" + addREDetails.get(i).getRemark());
            }

        }
    }
}

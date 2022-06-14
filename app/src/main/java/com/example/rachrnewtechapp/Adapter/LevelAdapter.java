package com.example.rachrnewtechapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.UserRoleDepartmentModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.List;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.MyViewHolder> {
    private Context context;
    private List<UserRoleDepartmentModel> userRoleDepartmentModels;

    public LevelAdapter(Context context, List<UserRoleDepartmentModel> userRoleDepartmentModels) {
        this.context = context;
        this.userRoleDepartmentModels = userRoleDepartmentModels;
    }

    @NonNull
    @Override
    public LevelAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_level_adapter,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelAdapter.MyViewHolder holder, int position) {
        final UserRoleDepartmentModel getUserListModelone = userRoleDepartmentModels.get(position);
        if (getUserListModelone != null){
            holder.setData(getUserListModelone);
        }
    }

    @Override
    public int getItemCount() {
        return userRoleDepartmentModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_form;
        private CheckBox chk_l1,chk_l2,chk_l3,chk_l4,chk_l5;
        private UserRoleDepartmentModel userRoleDepartmentModel;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_form = (TextView)itemView.findViewById(R.id.txt_form);
            chk_l1 = (CheckBox) itemView.findViewById(R.id.chk_l1);
            chk_l2 = (CheckBox)itemView.findViewById(R.id.chk_l2);
            chk_l3 = (CheckBox)itemView.findViewById(R.id.chk_l3);
            chk_l4 = (CheckBox)itemView.findViewById(R.id.chk_l4);
            chk_l5 = (CheckBox)itemView.findViewById(R.id.chk_l5);
            FontUtils.changeFont(context,txt_form, AppConstant.FONT_SANS_SEMIBOLD);

        }

        public void setData(UserRoleDepartmentModel userRoleDepartmentModel){
            this.userRoleDepartmentModel = userRoleDepartmentModel;
            txt_form.setText("" + userRoleDepartmentModel.getFormName());
            if (userRoleDepartmentModel.getBandName().equals("L1")){
                chk_l1.setChecked(true);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
                chk_l5.setEnabled(false);
            }else if (userRoleDepartmentModel.getBandName().equals("L2")){
                chk_l2.setChecked(true);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
                chk_l5.setEnabled(false);
            }else if (userRoleDepartmentModel.getBandName().equals("L3")){
                chk_l3.setChecked(true);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
                chk_l5.setEnabled(false);
            }else if (userRoleDepartmentModel.getBandName().equals("L4")){
                chk_l4.setChecked(true);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
                chk_l5.setEnabled(false);
            }else if (userRoleDepartmentModel.getBandName().equals("L5")){
                chk_l5.setChecked(true);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
                chk_l5.setEnabled(false);
            }
        }
    }
}

package com.example.rachrnewtechapp.Adapter;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.UserRoleDepartmentModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.List;

public class PermissionAdapter extends RecyclerView.Adapter<PermissionAdapter.MyViewHolder> {
    private Context context;
    private List<UserRoleDepartmentModel> userRoleDepartmentModels;

    public PermissionAdapter(Context context, List<UserRoleDepartmentModel> userRoleDepartmentModels) {
        this.context = context;
        this.userRoleDepartmentModels = userRoleDepartmentModels;
    }

    @NonNull
    @Override
    public PermissionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_permission_adapter,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PermissionAdapter.MyViewHolder holder, int position) {
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
        private String text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_form = (TextView)itemView.findViewById(R.id.txt_form);
            chk_l1 = (CheckBox) itemView.findViewById(R.id.chk_l1);
            chk_l2 = (CheckBox)itemView.findViewById(R.id.chk_l2);
            chk_l3 = (CheckBox)itemView.findViewById(R.id.chk_l3);
            chk_l4 = (CheckBox)itemView.findViewById(R.id.chk_l4);
            FontUtils.changeFont(context,txt_form, AppConstant.FONT_SANS_SEMIBOLD);
        }

        public void setData(UserRoleDepartmentModel userRoleDepartmentModel){
            this.userRoleDepartmentModel = userRoleDepartmentModel;
            txt_form.setText("" + userRoleDepartmentModel.getFormName());
            String mystring=new String("/Add/Edit/Delete");
            SpannableString content = new SpannableString(mystring);
            content.setSpan(new UnderlineSpan(), 0, mystring.length(), 0);

            if (userRoleDepartmentModel.getAccessPermissionDescription().equals("None")){
                chk_l1.setChecked(false);
                chk_l2.setChecked(false);
                chk_l3.setChecked(false);
                chk_l4.setChecked(false);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
            }else if (userRoleDepartmentModel.getAccessPermissionDescription().equals("View"+content)){
                chk_l1.setChecked(true);
                chk_l2.setChecked(true);
                chk_l3.setChecked(true);
                chk_l4.setChecked(true);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
            }else if (userRoleDepartmentModel.getAccessPermissionDescription().equals("View")){
                chk_l1.setChecked(true);
                chk_l2.setChecked(false);
                chk_l3.setChecked(false);
                chk_l4.setChecked(false);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
            }else if (userRoleDepartmentModel.getAccessPermissionDescription().equals("Add")){
                chk_l1.setChecked(false);
                chk_l2.setChecked(true);
                chk_l3.setChecked(false);
                chk_l4.setChecked(false);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
            }else if (userRoleDepartmentModel.getAccessPermissionDescription().equals("Edit")){
                chk_l1.setChecked(false);
                chk_l2.setChecked(false);
                chk_l3.setChecked(true);
                chk_l4.setChecked(false);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
            }else if (userRoleDepartmentModel.getAccessPermissionDescription().equals("Delete")){
                chk_l1.setChecked(false);
                chk_l2.setChecked(false);
                chk_l3.setChecked(false);
                chk_l4.setChecked(true);
                chk_l1.setEnabled(false);
                chk_l2.setEnabled(false);
                chk_l3.setEnabled(false);
                chk_l4.setEnabled(false);
            }
        }
    }


}

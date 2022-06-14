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
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Activities.EditNPActivity;
import com.example.rachrnewtechapp.Activities.ViewNpActivity;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.DcrResponseModel;
import com.example.rachrnewtechapp.Model.ProjectNPModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Retrofit.ApiClient;
import com.example.rachrnewtechapp.Retrofit.ApiService;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectNPAdapter extends RecyclerView.Adapter<ProjectNPAdapter.MyViewHolder> {

    private Context context;
    private List<ProjectNPModel> projectNPModels;

    public ProjectNPAdapter(Context context, List<ProjectNPModel> projectNPModels) {
        this.context = context;
        this.projectNPModels = projectNPModels;
    }

    @NonNull
    @Override
    public ProjectNPAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_np_adapter_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectNPAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final ProjectNPModel projectNPModel = projectNPModels.get(position);
        if (projectNPModel != null) {
            holder.setData(projectNPModel);
            holder.txt_srno.setText(String.valueOf(position + 1));
            holder.ll_drop_down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean expanded = projectNPModel.isExpanaded();
                    projectNPModel.setExpanaded(!expanded);

                    notifyItemChanged(position);
                    if (!expanded) {
                        holder.image_up.setVisibility(View.VISIBLE);
                    } else {
                        holder.image_down.setVisibility(View.GONE);
                    }
                }
            });

            if (position % 2 == 0) {
                holder.ll_layout.setBackgroundColor(context.getResources().getColor(R.color.bg_colorTwo));
            } else {
                holder.ll_layout.setBackgroundColor(context.getResources().getColor(R.color.bg_color));
            }
        }
    }

    @Override
    public int getItemCount() {
        return projectNPModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView sr_no, txt_srno, business_name, txt_createdOn, et_business_name, et_createdOn;
        private LinearLayout ll_drop_down, ll_click, ll_edit, ll_view, ll_delete, ll_layout;
        private ProjectNPModel projectNPModel;
        private TextView district, floor_area, order_status, location, form_stage, created_by;
        private TextView txt_district, txt_floor_area, txt_order_status, txt_location, txt_form_stage, txt_created_by;
        private TextView edit, txt_view, txt_delete;
        private ImageView image_up, image_down;
        private TextView view_balance_activity, header_ioclBalance, txt_no, billingTV, username;
        private LinearLayout ll_no, ll_yes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sr_no = (TextView) itemView.findViewById(R.id.sr_no);
            txt_srno = (TextView) itemView.findViewById(R.id.txt_srno);
            business_name = (TextView) itemView.findViewById(R.id.business_name);
            txt_createdOn = (TextView) itemView.findViewById(R.id.txt_createdOn);
            et_business_name = (TextView) itemView.findViewById(R.id.et_business_name);
            et_createdOn = (TextView) itemView.findViewById(R.id.et_createdOn);
            ll_drop_down = (LinearLayout) itemView.findViewById(R.id.ll_drop_down);
            ll_click = (LinearLayout) itemView.findViewById(R.id.ll_click);
            district = (TextView) itemView.findViewById(R.id.district);
            floor_area = (TextView) itemView.findViewById(R.id.floor_area);
            order_status = (TextView) itemView.findViewById(R.id.order_status);
            location = (TextView) itemView.findViewById(R.id.location);
            form_stage = (TextView) itemView.findViewById(R.id.form_stage);
            created_by = (TextView) itemView.findViewById(R.id.created_by);
            txt_district = (TextView) itemView.findViewById(R.id.txt_district);
            txt_floor_area = (TextView) itemView.findViewById(R.id.txt_floor_area);
            txt_order_status = (TextView) itemView.findViewById(R.id.txt_order_status);
            txt_location = (TextView) itemView.findViewById(R.id.txt_location);
            txt_form_stage = (TextView) itemView.findViewById(R.id.txt_form_stage);
            txt_created_by = (TextView) itemView.findViewById(R.id.txt_created_by);
            edit = (TextView) itemView.findViewById(R.id.edit);
            txt_view = (TextView) itemView.findViewById(R.id.txt_view);
            txt_delete = (TextView) itemView.findViewById(R.id.txt_delete);
            ll_edit = (LinearLayout) itemView.findViewById(R.id.ll_edit);
            ll_view = (LinearLayout) itemView.findViewById(R.id.ll_view);
            ll_delete = (LinearLayout) itemView.findViewById(R.id.ll_delete);
            image_up = (ImageView) itemView.findViewById(R.id.image_up);
            image_down = (ImageView) itemView.findViewById(R.id.image_down);
            ll_layout = (LinearLayout) itemView.findViewById(R.id.ll_layout);



            FontUtils.changeFont(context, sr_no, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_srno, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, business_name, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_createdOn, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, et_business_name, AppConstant.FONT_SANS_SEMIBOLD);

            FontUtils.changeFont(context, district, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, floor_area, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, order_status, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, location, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, form_stage, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, created_by, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_created_by, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_district, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_floor_area, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_order_status, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_location, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_form_stage, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, edit, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_view, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_delete, AppConstant.FONT_SANS_SEMIBOLD);

        }

        public void setData(ProjectNPModel projectNPModel) {
            this.projectNPModel = projectNPModel;
            boolean expanded = projectNPModel.isExpanaded();
            ll_click.setVisibility(expanded ? View.VISIBLE : View.GONE);
            et_business_name.setText("" + projectNPModel.getBusinessName());
            et_createdOn.setText("" + projectNPModel.getCreatedOn());
            txt_district.setText("" + projectNPModel.getDistrict());
            txt_floor_area.setText("" + projectNPModel.getFloorArea());
            txt_order_status.setText("" + projectNPModel.getOrderStatus());
            txt_location.setText("" + projectNPModel.getLocation());
            txt_form_stage.setText("" + projectNPModel.getFormStage());
            txt_created_by.setText("" + projectNPModel.getCreatedBy());


            ll_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, EditNPActivity.class);
                    intent.putExtra("projectNPModel",projectNPModel);
                    context.startActivity(intent);
                }
            });

            ll_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ViewNpActivity.class);
                    intent.putExtra("projectNPModel",projectNPModel);
                    context.startActivity(intent);
                }
            });

            ll_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_delete_user, null, false);
                    view_balance_activity = (TextView) dialogView.findViewById(R.id.view_balance_activity);
                    header_ioclBalance = (TextView) dialogView.findViewById(R.id.header_ioclBalance);
                    txt_no = (TextView) dialogView.findViewById(R.id.txt_no);
                    billingTV = (TextView) dialogView.findViewById(R.id.billingTV);
                    ll_no = (LinearLayout) dialogView.findViewById(R.id.ll_no);
                    ll_yes = (LinearLayout) dialogView.findViewById(R.id.ll_yes);
                    username = (TextView) dialogView.findViewById(R.id.username);
                    username.setText("" + projectNPModel.getBusinessName() + " " + "?");

                    builder.setView(dialogView);
                    final AlertDialog dialog = builder.create();
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                    FontUtils.changeFont(context, txt_no, AppConstant.FONT_SANS_SEMIBOLD);
                    FontUtils.changeFont(context, billingTV, AppConstant.FONT_SANS_SEMIBOLD);
                    FontUtils.changeFont(context, view_balance_activity, AppConstant.FONT_SANS_SEMIBOLD);
                    FontUtils.changeFont(context, header_ioclBalance, AppConstant.FONT_SANS_SEMIBOLD);
                    FontUtils.changeFont(context, username, AppConstant.FONT_SANS_SEMIBOLD);

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
                            Call<Boolean> call = service.removeNpData(projectNPModel.getId());
                            call.enqueue(new Callback<Boolean>() {
                                @Override
                                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                    if (!response.isSuccessful()) {
                                        return;
                                    }
                                    Toast.makeText(context, "NP Deleted Successfully", Toast.LENGTH_SHORT).show();
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
        }


    }

    public void filterList(ArrayList<ProjectNPModel> filteredList) {
        projectNPModels = filteredList;
        notifyDataSetChanged();
    }

    public ArrayList<ProjectNPModel> filter2(List<ProjectNPModel> models, String filterType) {

        final ArrayList<ProjectNPModel> filteredModelList = new ArrayList<>();
        for (ProjectNPModel model:models) {
            final String cardTypeTest = model.getOrderStatus();

            if (cardTypeTest.equalsIgnoreCase(filterType)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}

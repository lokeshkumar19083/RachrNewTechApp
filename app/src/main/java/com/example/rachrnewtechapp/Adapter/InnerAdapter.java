package com.example.rachrnewtechapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Activities.ViewDCRReportActivity;
import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.AddDARFCDetail;
import com.example.rachrnewtechapp.Model.DcrResponseModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.List;

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.MyViewHolder> {

    private Context context;
    private List<AddDARFCDetail> addDARFCDetails;
    private DcrResponseModel dcrResponseModels;

    public InnerAdapter(Context context, List<AddDARFCDetail> addDARFCDetails,DcrResponseModel dcrResponseModels) {
        this.context = context;
        this.addDARFCDetails = addDARFCDetails;
        this.dcrResponseModels = dcrResponseModels;
    }

    @NonNull
    @Override
    public InnerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_layout_adapter,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerAdapter.MyViewHolder holder, int position) {
        final AddDARFCDetail addDARFCDetail = addDARFCDetails.get(position);
        if (addDARFCDetail != null){
            holder.setData(addDARFCDetail);
        }
    }

    @Override
    public int getItemCount() {
        return addDARFCDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_businee_name,txt_visit_report,txt_customer_class,txt_location;
        private TextView txt_business_name,visit_report,customer_class,location;
        private AddDARFCDetail addDARFCDetail;
        private LinearLayout ll_click;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_business_name = (TextView)itemView.findViewById(R.id.txt_business_name);
            visit_report = (TextView)itemView.findViewById(R.id.visit_report);
            customer_class = (TextView)itemView.findViewById(R.id.customer_class);
            location = (TextView)itemView.findViewById(R.id.location);
            txt_businee_name = (TextView)itemView.findViewById(R.id.txt_businee_name);
            txt_visit_report = (TextView)itemView.findViewById(R.id.txt_visit_report);
            txt_customer_class = (TextView)itemView.findViewById(R.id.txt_customer_class);
            txt_location = (TextView)itemView.findViewById(R.id.txt_location);
            ll_click = (LinearLayout)itemView.findViewById(R.id.ll_click);

            FontUtils.changeFont(context,txt_business_name, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,visit_report,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,customer_class,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,location,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_businee_name,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_visit_report,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_customer_class,AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context,txt_location,AppConstant.FONT_SANS_SEMIBOLD);

        }

        public void setData(final AddDARFCDetail addDARFCDetail){
            this.addDARFCDetail = addDARFCDetail;
            txt_business_name.setText(""+addDARFCDetail.getBusinessName());
            visit_report.setText("" + addDARFCDetail.getSelectedVisitReport());
            customer_class.setText("" + addDARFCDetail.getSelectedCustomerClass());
            location.setText("" + addDARFCDetail.getLocation());

           /* ll_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ViewDCRReportActivity.class);
                    intent.putExtra("addDARFCDetails", String.valueOf(addDARFCDetails));
                    intent.putExtra("dcrResponseModel",dcrResponseModels);
                    context.startActivity(intent);
                }
            });*/

        }
    }
}

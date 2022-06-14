package com.example.rachrnewtechapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rachrnewtechapp.Constants.AppConstant;
import com.example.rachrnewtechapp.Model.EditDepartmentFormWrapper;
import com.example.rachrnewtechapp.Model.FormReceiverDepartmentList;
import com.example.rachrnewtechapp.Model.GetFormDataModel;
import com.example.rachrnewtechapp.R;
import com.example.rachrnewtechapp.Utils.FontUtils;

import java.util.ArrayList;
import java.util.List;

public class EditDepartmentRecieverAdpter extends RecyclerView.Adapter<EditDepartmentRecieverAdpter.MyViewHolder> {
    private EditDepartmentFormWrapper editDepartmentFormWrapper;
    private Context context;
    private List<GetFormDataModel> getFormDataModels;

    public EditDepartmentRecieverAdpter(EditDepartmentFormWrapper editDepartmentFormWrapper, Context context, List<GetFormDataModel> getFormDataModels) {
        this.editDepartmentFormWrapper = editDepartmentFormWrapper;
        this.context = context;
        this.getFormDataModels = getFormDataModels;
    }

    @NonNull
    @Override
    public EditDepartmentRecieverAdpter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.editdepartment_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EditDepartmentRecieverAdpter.MyViewHolder holder, int position) {
        FormReceiverDepartmentList formReceiverDepartmentList = editDepartmentFormWrapper.getFormReceiverDepartmentList().get(position);
        if (formReceiverDepartmentList != null) {
            holder.setData(formReceiverDepartmentList);
        }
    }

    @Override
    public int getItemCount() {
        return editDepartmentFormWrapper.getFormReceiverDepartmentList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_reciving_department, txt_access_permission, txt_l1, txt_wf_one, txt_fs_one, txt_l2, txt_wf_two, txt_fs_two,
                txt_l3, txt_wf_three, txt_fs_three, txt_l4, txt_wf_four, txt_fs_four, txt_l5, txt_wf_five, txt_fs_five;
        private CheckBox chk_l1, chk_l2, chk_l3, chk_l4, chk_l5;
        private Spinner spinner_one, spinner_two, spinner_three, spinner_four, spinner_five, spinner_six, spinner_seven,
                spinner_eight, spinner_nine, spinner_ten, spinner_eleven;
        FormReceiverDepartmentList formReceiverDepartmentList;
        private String text;

        private List subscriptionsStrings = new ArrayList<>();
        private List subscriptionsStringTwo = new ArrayList<>();


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_reciving_department = (TextView) itemView.findViewById(R.id.txt_reciving_department);
            txt_access_permission = (TextView) itemView.findViewById(R.id.txt_access_permission);
            txt_l1 = (TextView) itemView.findViewById(R.id.txt_l1);
            txt_wf_one = (TextView) itemView.findViewById(R.id.txt_wf_one);
            txt_fs_one = (TextView) itemView.findViewById(R.id.txt_fs_one);
            txt_l2 = (TextView) itemView.findViewById(R.id.txt_l2);
            txt_wf_two = (TextView) itemView.findViewById(R.id.txt_wf_two);
            txt_fs_two = (TextView) itemView.findViewById(R.id.txt_fs_two);
            txt_l3 = (TextView) itemView.findViewById(R.id.txt_l3);
            txt_wf_three = (TextView) itemView.findViewById(R.id.txt_wf_three);
            txt_fs_three = (TextView) itemView.findViewById(R.id.txt_fs_three);
            txt_l4 = (TextView) itemView.findViewById(R.id.txt_l4);
            txt_wf_four = (TextView) itemView.findViewById(R.id.txt_wf_four);
            txt_fs_four = (TextView) itemView.findViewById(R.id.txt_fs_four);
            txt_l5 = (TextView) itemView.findViewById(R.id.txt_l5);
            txt_wf_five = (TextView) itemView.findViewById(R.id.txt_wf_five);
            txt_fs_five = (TextView) itemView.findViewById(R.id.txt_fs_five);

            chk_l1 = (CheckBox) itemView.findViewById(R.id.chk_l1);
            chk_l2 = (CheckBox) itemView.findViewById(R.id.chk_l2);
            chk_l3 = (CheckBox) itemView.findViewById(R.id.chk_l3);
            chk_l4 = (CheckBox) itemView.findViewById(R.id.chk_l4);
            chk_l5 = (CheckBox) itemView.findViewById(R.id.chk_l5);

            spinner_one = (Spinner) itemView.findViewById(R.id.spinner_one);
            spinner_two = (Spinner) itemView.findViewById(R.id.spinner_two);
            spinner_three = (Spinner) itemView.findViewById(R.id.spinner_three);
            spinner_four = (Spinner) itemView.findViewById(R.id.spinner_four);
            spinner_five = (Spinner) itemView.findViewById(R.id.spinner_five);
            spinner_six = (Spinner) itemView.findViewById(R.id.spinner_six);
            spinner_seven = (Spinner) itemView.findViewById(R.id.spinner_seven);
            spinner_eight = (Spinner) itemView.findViewById(R.id.spinner_eight);
            spinner_nine = (Spinner) itemView.findViewById(R.id.spinner_nine);
            spinner_ten = (Spinner) itemView.findViewById(R.id.spinner_ten);
            spinner_eleven = (Spinner) itemView.findViewById(R.id.spinner_eleven);


            FontUtils.changeFont(context, txt_reciving_department, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_access_permission, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_l1, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_wf_one, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_fs_one, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_l2, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_wf_two, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_fs_two, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_l3, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_wf_three, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_fs_three, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_l4, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_wf_four, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_fs_four, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_l5, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_wf_five, AppConstant.FONT_SANS_SEMIBOLD);
            FontUtils.changeFont(context, txt_fs_five, AppConstant.FONT_SANS_SEMIBOLD);
        }

        public void setData(final FormReceiverDepartmentList formReceiverDepartmentList) {
            this.formReceiverDepartmentList = formReceiverDepartmentList;


            for (int i = 0; i < getFormDataModels.size(); i++) {
                if (!subscriptionsStringTwo.contains(getFormDataModels.get(i).getDepartmentName())) {
                    subscriptionsStringTwo.add(getFormDataModels.get(i).getDepartmentName());

                    String compareValueOne = formReceiverDepartmentList.getReceiverDepartmentName();
                    ArrayAdapter<String> adapterTwo = new ArrayAdapter<String>(context, R.layout.spinner_item, subscriptionsStringTwo);
                    adapterTwo.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_one.setAdapter(adapterTwo);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterTwo.getPosition(compareValueOne);
                        spinner_one.setSelection(spinnerPosition);
                    }
                }
                if (formReceiverDepartmentList.getL1_Role().equals("Viewer")) {
                    chk_l1.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL1_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_two.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_two.setSelection(spinnerPosition);
                    }
                    spinner_two.setEnabled(true);
                } else if (formReceiverDepartmentList.getL1_Role().equals("Reviewer")) {
                    chk_l1.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL1_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_two.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_two.setSelection(spinnerPosition);
                    }
                    spinner_two.setEnabled(true);
                } else if (formReceiverDepartmentList.getL1_Role().equals("Approver")) {
                    chk_l1.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL1_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_two.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_two.setSelection(spinnerPosition);
                    }
                    spinner_two.setEnabled(true);
                } else if (formReceiverDepartmentList.getL1_Role().equals("NONE")) {
                    chk_l1.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.workflow,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_two.setAdapter(adapter);
                }else {

                }
                if (formReceiverDepartmentList.getL1_FormStage().equals("Initiated")) {
                    chk_l1.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL1_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_three.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_three.setSelection(spinnerPosition);
                    }
                    spinner_three.setEnabled(true);
                } else if (formReceiverDepartmentList.getL1_FormStage().equals("Reviewed")) {
                    chk_l1.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL1_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_three.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_three.setSelection(spinnerPosition);
                    }
                    spinner_three.setEnabled(true);
                } else if (formReceiverDepartmentList.getL1_FormStage().equals("Approved")) {
                    chk_l1.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL1_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_three.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_three.setSelection(spinnerPosition);
                    }
                    spinner_three.setEnabled(true);
                } else if (formReceiverDepartmentList.getL1_FormStage().equals("Rejected")) {
                    chk_l1.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL1_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_three.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_three.setSelection(spinnerPosition);
                    }
                    spinner_three.setEnabled(true);
                }else if (formReceiverDepartmentList.getL1_FormStage().equals("WIP")) {
                    chk_l1.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL1_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_three.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_three.setSelection(spinnerPosition);
                    }
                    spinner_three.setEnabled(true);
                } else if (formReceiverDepartmentList.getL1_FormStage().equals("NONE")) {
                    chk_l1.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.flowstatus,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_three.setAdapter(adapter);
                }else {

                }
                if (formReceiverDepartmentList.getL2_Role().equals("Viewer")){
                    chk_l2.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL2_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (formReceiverDepartmentList.getL2_Role().equals("Reviewer")){
                    chk_l2.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL2_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (formReceiverDepartmentList.getL2_Role().equals("Approver")){
                    chk_l2.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL2_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_four.setSelection(spinnerPosition);
                    }
                    spinner_four.setEnabled(true);
                }else if (formReceiverDepartmentList.getL2_Role().equals("NONE")) {
                    chk_l2.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.workflow,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_four.setAdapter(adapter);
                }else {
                }
                if (formReceiverDepartmentList.getL2_FormStage().equals("Initiated")) {
                    chk_l2.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL2_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_five.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_five.setSelection(spinnerPosition);
                    }
                    spinner_five.setEnabled(true);
                }else if (formReceiverDepartmentList.getL2_FormStage().equals("Reviewed")) {
                    chk_l2.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL2_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_five.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_five.setSelection(spinnerPosition);
                    }
                    spinner_five.setEnabled(true);
                }else if (formReceiverDepartmentList.getL2_FormStage().equals("Approved")) {
                    chk_l2.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL2_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_five.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_five.setSelection(spinnerPosition);
                    }
                    spinner_five.setEnabled(true);
                }else if (formReceiverDepartmentList.getL2_FormStage().equals("Rejected")) {
                    chk_l2.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL2_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_five.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_five.setSelection(spinnerPosition);
                    }
                    spinner_five.setEnabled(true);
                }else if (formReceiverDepartmentList.getL2_FormStage().equals("WIP")) {
                    chk_l2.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL2_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_five.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_five.setSelection(spinnerPosition);
                    }
                    spinner_five.setEnabled(true);
                } else if (formReceiverDepartmentList.getL2_FormStage().equals("NONE")) {
                    chk_l2.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.flowstatus,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_five.setAdapter(adapter);
                }else {
                }
                if (formReceiverDepartmentList.getL3_Role().equals("Viewer")){
                    chk_l3.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL3_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_six.setSelection(spinnerPosition);
                    }
                    spinner_six.setEnabled(true);
                }else if (formReceiverDepartmentList.getL3_Role().equals("Reviewer")){
                    chk_l3.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL3_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_six.setSelection(spinnerPosition);
                    }
                    spinner_six.setEnabled(true);
                }else if (formReceiverDepartmentList.getL3_Role().equals("Approver")){
                    chk_l3.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL3_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_six.setSelection(spinnerPosition);
                    }
                    spinner_six.setEnabled(true);
                }else if (formReceiverDepartmentList.getL3_Role().equals("NONE")) {
                    chk_l3.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.workflow,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_six.setAdapter(adapter);
                }else {

                }
                if (formReceiverDepartmentList.getL3_FormStage().equals("Initiated")){
                    chk_l3.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL3_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_seven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_seven.setSelection(spinnerPosition);
                    }
                    spinner_seven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL3_FormStage().equals("Reviewed")){
                    chk_l3.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL3_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_seven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_seven.setSelection(spinnerPosition);
                    }
                    spinner_seven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL3_FormStage().equals("Approved")){
                    chk_l3.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL3_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_seven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_seven.setSelection(spinnerPosition);
                    }
                    spinner_seven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL3_FormStage().equals("Rejected")){
                    chk_l3.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL3_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_seven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_seven.setSelection(spinnerPosition);
                    }
                    spinner_seven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL3_FormStage().equals("WIP")){
                    chk_l3.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL3_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_seven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_seven.setSelection(spinnerPosition);
                    }
                    spinner_seven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL3_FormStage().equals("NONE")) {
                    chk_l3.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.flowstatus,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_seven.setAdapter(adapter);
                }
                if (formReceiverDepartmentList.getL4_Role().equals("Viewer")){
                    chk_l4.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL4_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eight.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_eight.setSelection(spinnerPosition);
                    }
                    spinner_eight.setEnabled(true);
                }else if (formReceiverDepartmentList.getL4_Role().equals("Reviewer")){
                    chk_l4.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL4_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eight.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_eight.setSelection(spinnerPosition);
                    }
                    spinner_eight.setEnabled(true);
                }else if (formReceiverDepartmentList.getL4_Role().equals("Approver")){
                    chk_l4.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL4_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eight.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_eight.setSelection(spinnerPosition);
                    }
                    spinner_eight.setEnabled(true);
                }else if (formReceiverDepartmentList.getL4_Role().equals("NONE")) {
                    chk_l4.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.workflow,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eight.setAdapter(adapter);
                }else {

                }
                if (formReceiverDepartmentList.getL4_FormStage().equals("Initiated")){
                    chk_l4.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL4_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_nine.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_nine.setSelection(spinnerPosition);
                    }
                    spinner_nine.setEnabled(true);
                }else if (formReceiverDepartmentList.getL4_FormStage().equals("Reviewed")){
                    chk_l4.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL4_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_nine.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_nine.setSelection(spinnerPosition);
                    }
                    spinner_nine.setEnabled(true);
                }else if (formReceiverDepartmentList.getL4_FormStage().equals("Approved")){
                    chk_l4.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL4_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_nine.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_nine.setSelection(spinnerPosition);
                    }
                    spinner_nine.setEnabled(true);
                }else if (formReceiverDepartmentList.getL4_FormStage().equals("Rejected")){
                    chk_l4.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL4_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_nine.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_nine.setSelection(spinnerPosition);
                    }
                    spinner_nine.setEnabled(true);
                }else if (formReceiverDepartmentList.getL4_FormStage().equals("WIP")){
                    chk_l4.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL4_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_nine.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_nine.setSelection(spinnerPosition);
                    }
                    spinner_nine.setEnabled(true);
                }else if (formReceiverDepartmentList.getL4_FormStage().equals("NONE")) {
                    chk_l4.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.flowstatus,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_nine.setAdapter(adapter);
                }else {

                }
                if (formReceiverDepartmentList.getL5_Role().equals("Viewer")){
                    chk_l5.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL5_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_ten.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_ten.setSelection(spinnerPosition);
                    }
                    spinner_ten.setEnabled(true);
                }else if (formReceiverDepartmentList.getL5_Role().equals("Reviewer")){
                    chk_l5.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL5_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_ten.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_ten.setSelection(spinnerPosition);
                    }
                    spinner_ten.setEnabled(true);
                }else if (formReceiverDepartmentList.getL5_Role().equals("Approver")){
                    chk_l5.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL5_Role();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.workflow, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_ten.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_ten.setSelection(spinnerPosition);
                    }
                    spinner_ten.setEnabled(true);
                }else if (formReceiverDepartmentList.getL5_Role().equals("NONE")){
                    chk_l5.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.workflow,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_ten.setAdapter(adapter);
                }else {

                }
                if (formReceiverDepartmentList.getL5_FormStage().equals("Initiated")){
                    chk_l5.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL5_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eleven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_eleven.setSelection(spinnerPosition);
                    }
                    spinner_eleven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL5_FormStage().equals("Reviewed")){
                    chk_l5.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL5_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eleven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_eleven.setSelection(spinnerPosition);
                    }
                    spinner_eleven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL5_FormStage().equals("Approved")){
                    chk_l5.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL5_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eleven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_eleven.setSelection(spinnerPosition);
                    }
                    spinner_eleven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL5_FormStage().equals("Rejected")){
                    chk_l5.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL5_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eleven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_eleven.setSelection(spinnerPosition);
                    }
                    spinner_eleven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL5_FormStage().equals("WIP")){
                    chk_l5.setChecked(true);
                    String compareValueOne = formReceiverDepartmentList.getL5_FormStage();
                    ArrayAdapter<CharSequence> adapterOne = ArrayAdapter.createFromResource(context, R.array.flowstatus, R.layout.spinner_item);
                    adapterOne.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eleven.setAdapter(adapterOne);
                    if (compareValueOne != null) {
                        int spinnerPosition = adapterOne.getPosition(compareValueOne);
                        spinner_eleven.setSelection(spinnerPosition);
                    }
                    spinner_eleven.setEnabled(true);
                }else if (formReceiverDepartmentList.getL5_FormStage().equals("NONE")){
                    chk_l5.setChecked(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.flowstatus,
                            R.layout.spinner_item);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_eleven.setAdapter(adapter);
                }else {

                }
            }
        }
    }
}

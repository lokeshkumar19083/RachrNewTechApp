package com.example.rachrnewtechapp.Retrofit;

import com.example.rachrnewtechapp.Model.CreateUserModel;
import com.example.rachrnewtechapp.Model.DcrRequestModel;
import com.example.rachrnewtechapp.Model.DcrResponseIdModel;
import com.example.rachrnewtechapp.Model.DcrResponseModel;
import com.example.rachrnewtechapp.Model.DepartmentFormReceiverModel;
import com.example.rachrnewtechapp.Model.EditDepartmentFormWrapper;
import com.example.rachrnewtechapp.Model.GetFormDataModel;
import com.example.rachrnewtechapp.Model.GetUserIdDetails;
import com.example.rachrnewtechapp.Model.GetUserListModel;
import com.example.rachrnewtechapp.Model.GetUserRoleData;
import com.example.rachrnewtechapp.Model.GetUserTypeDataModel;
import com.example.rachrnewtechapp.Model.NPRequestModel;
import com.example.rachrnewtechapp.Model.ProjectNPModel;
import com.example.rachrnewtechapp.Model.ProjectNpModelTwo;
import com.example.rachrnewtechapp.Model.RemoveFormReciverData;
import com.example.rachrnewtechapp.Model.StatusCreateUser;
import com.example.rachrnewtechapp.Model.StatusResponse;
import com.example.rachrnewtechapp.Model.UpdateNpModel;
import com.example.rachrnewtechapp.Model.UpdateUserRoleModel;
import com.example.rachrnewtechapp.Model.UserDto;
import com.example.rachrnewtechapp.Model.UserRoleDepartmentModel;
import com.example.rachrnewtechapp.Model.UserUpdateModel;


import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


   @POST("user/user/UserLogin")
   Call<StatusResponse> uploadRegistationDetails(@Body UserDto userDto);

   @POST("user/user/CreateUser")
   Call<StatusCreateUser> createUser(@Body CreateUserModel createUserModel);

   @GET("user/user/GetUserList")
   Call<List<GetUserListModel>> getUserList();

   @GET("usertype/GetUserTypeDataList")
   Call<List<GetUserTypeDataModel>> getUserTypeData();

   @GET("user/user/GetUserData/{userId}")
   Call<GetUserIdDetails> editUser(@Path("userId") String userId);

   @GET("admin/userroledeptformmapping/GetDataById/{Id}")
   Call<List<UserRoleDepartmentModel>> getDepartmentForm(@Path("Id") String Id);

   @DELETE("user/user/RemoveUser/{userId}")
   Call<Void> deleteuser(@Path("userId") String userId);

   @DELETE("admin/userroledeptformmapping/Remove/{id}")
   Call<Void> deleteItem(@Path("id") String id);

   @GET("admin/userroledeptformmapping/GetDataList")
   Call<List<GetUserRoleData>> getUserRoleData();

   @POST("admin/userroledeptformmapping/Update")
   Call<Boolean> updateUserRoleData(@Body UpdateUserRoleModel updateUserRoleModel);

   @GET("deptFormReceiverConfiguration/GetDataList")
   Call<List<DepartmentFormReceiverModel>> getDepartmentFormDetails();

   @POST("user/user/ChangeUser")
   Call<Boolean> updateUser(@Body UserUpdateModel userUpdateModel);

   @GET("deptFormReceiverConfiguration/GetData/{Id}")
   Call<EditDepartmentFormWrapper> getDapermentformById(@Path("Id") String Id);

   @GET("deptFormReceiverConfiguration/GetFormDepartmentDataList")
   Call<List<GetFormDataModel>> getFormData();

   @POST("deptFormReceiverConfiguration/RemoveData")
   Call<Boolean> removeformReciver(@Body RemoveFormReciverData removeFormReciverData);

   @POST("form/darfc/GetFormDataList")
   Call<List<DcrResponseModel>> getDcrData(@Body DcrRequestModel dcrRequestModel);

   @DELETE("form/darfc/RemoveFormData/{Id}")
   Call<Boolean> deleteDCREPORT(@Path("id") String id);

   @GET("form/darfc/GetFormData/{Id}")
   Call<DcrResponseIdModel> getDataDcrById(@Path("Id") String Id);


   @POST("form/np/GetFormDataList")
   Call<List<ProjectNPModel>> getDataProjectNPData(@Body NPRequestModel npRequestModel);

   @DELETE("form/darfc/RemoveFormData/{Id}")
   Call<Boolean> removeNpData(@Path("Id") String Id);

   @GET("form/np/GetFormData/{Id}")
   Call<ProjectNpModelTwo> getRemarksData(@Path("Id") String Id);

   @POST("form/np/Update")
   Call<Boolean> updateNpData(@Body UpdateNpModel updateNpModel);

}

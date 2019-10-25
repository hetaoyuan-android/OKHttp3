package com.mengpeng.okhttpdemo.network;


import com.mengpeng.okhttpdemo.bean.UserInfoBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface RetrofitApiService {

    @GET("userinfo")
    Observable<UserInfo> getUserInfo(@Query("uid") int uid);

    @Headers("Connection: close")
    @GET("HelloWorld")
        //登陆
    Observable<UserInfoBean> getUserInfo();

//    //人脸识别登陆
//    @Headers("Connection: close")
//    @POST("olisServices/sm/faceLogin")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<LoginBean>> faceLogin(@Field("userCode") String userCode, @Field("userName") String userName, @Field("imei") String imei);
//
//    //人脸信息采集列表
//    @Headers("Connection: close")
//    @GET("olisServices/sm/user/querySmUserList")
//    Observable<AutoSingleResponse<FaceAcuqisitionBean>> faceAcquisition(@Query("cj") String cj, @Query("lib") String lib);
//
//    //人脸上传头像
//    @Headers("Connection: close")
//    @POST("olisServices/sm/user/uploadHeadImage")
//    Observable<AutoSingleResponse> uploadFaceImg(@Query("userCode") String userCode, @Query("lib") String lib);
//
//    //人像采集删除
//    @Headers("Connection: close")
//    @GET("olisServices/sm/user/delUserFace")
//    Observable<AutoSingleResponse> deleteFaceImg(@Query("userCode") String userCode);
//
//
//    @Headers("Connection: close")
//    @GET("detection/detectionTaskList")
//        //检测分页列表
//    Observable<AutoSingleResponse<ResistanceBean>> detectionList(@Query("taskName") String taskName, @Query("taskTime") String taskTime, @Query("endTime") String endTime,
//                                                                 @Query("taskType") int taskType, @Query("page") int page, @Query("rows") int rows);
//
//    @Headers("Connection: close")
//    @GET("detection/detectionTaskCount")
//        //检测分页底部数量
//    Observable<AutoSingleResponse<DetectionCountBean>> detectionCountList(@Query("taskName") String taskName, @Query("taskTime") String taskTime,
//                                                                          @Query("taskType") int taskType);
//
//    // 接地电阻分页列表
//    @Headers("Connection: close")
//    @GET("detection/resistanceList")
//    Observable<AutoSingleResponse<GroundResistanceListBean>> getGroundResistanceList(@Query("lineVol") String lineVol, @Query("lineName") String lineName, @Query("isInspected") String isInspected,
//                                                                                     @Query("towerNo") String towerNo, @Query("page") int page, @Query("rows") int rows, @Query("taskCode") String taskCode,
//                                                                                     @Query("lineId") String lineId, @Query("startDate") String startDate, @Query("endDate") String endDate);
//
//    // 接地电阻详情页
//    @Headers("Connection: close")
//    @GET("detection/resistanceMsg")
//    Observable<AutoSingleResponse<GroundResistanceDetailBean>> getGroundResistanceDetailList(@Query("recodeCode") String recodeCode);
//
//    // 新增接地电阻 不带图片
//    @Headers("Connection: close")
//    @POST("detection/addResistance ")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<AddGrounResistanceBean>> addGroundResistance(@FieldMap HashMap<String, Object> map);
//
//    // 退出登录
//    @Headers("Connection: close")
//    @POST("olisServices/sm/logout")
//    Observable<Logout> logout();
//
//    // 签到
//    @Headers("Connection: close")
//    @POST("olisServices/commuteCheck/checkin")
//    @FormUrlEncoded
//    Observable<SignBean> checkIn(@FieldMap HashMap<String, Object> map);
//
//    // 签退
//    @Headers("Connection: close")
//    @POST("olisServices/commuteCheck/checkout")
//    @FormUrlEncoded
//    Observable<SignBean> checkout(@FieldMap HashMap<String, Object> map);
//
//    //轨迹
//    @Headers("Connection: close")
//    @POST("olisServices/commuteGps/uploadGps")
//    @FormUrlEncoded
//    Observable<SignBean> uploadGps(@FieldMap HashMap<String, Object> map);
//
//    //值守轨迹
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/duty/alarmDutyUser")
//    @FormUrlEncoded
//    Observable<SignBean> alarmDutyUser(@FieldMap HashMap<String, Object> map);
//
//    // 检查新版本
//    @Headers("Connection: close")
//    @GET("olisServices/mobileVersion/getNewVersion")
//    Observable<AutoSingleResponse<SelectVersionBean>> inspectVersion();
//
//    // 扫一扫详情
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLinesByGt")
//    Observable<AutoSingleResponse<LineByTowerAllModel>> getLinesByGt(@Query("inteRid") String inteRid);
//
//
//    //新功能介绍
//    @Headers("Connection: close")
//    @GET("olisServices/tSmNotice/getNotice?type=1")
//    Observable<AutoSingleResponse<NewFunctionBean>> newFunction();
//
//    // 服务协议
//    @Headers("Connection: close")
//    @GET("olisServices/tSmNotice/getNotice?type=2")
//    Observable<AutoSingleResponse<NewFunctionBean>> serviceAgreement();
//
//    // 隐私政策
//    @Headers("Connection: close")
//    @GET("olisServices/tSmNotice/getNotice?type=3")
//    Observable<AutoSingleResponse<NewFunctionBean>> privacyPolicy();
//
//    // 今日工作list
//    @Headers("Connection: close")
//    @GET("olisServices/sm/user/getTodayWork")
//    Observable<AutoSingleResponse<TodayWorkBean>> todayWorkList(@Query("queryDate") String queryDate, @Query("userCode") String userCode);
//
//    // 今日工作的map
//    @Headers("Connection: close")
//    @GET("olisServices/sm/user/getTodayWorkMap")
//    Observable<AutoSingleResponse<TodatWorkMapBean>> todayWorkMap(@Query("queryDate") String queryDate, @Query("userCode") String userCode);
//
//    //巡视杆塔
//    @Headers("Connection: close")
//    @GET("olisServices/inspectRecord/getMyInspectRecordList")
//    Observable<AutoSingleResponse<TodayWorkDetailBean>> patrolDetail(@Query("queryDate") String queryDate, @Query("xlinteRid") String xlinteRid);
//
//    // 我的成就 list
//    @Headers("Connection: close")
//    @GET("olisServices/sm/user/getWorkAchievement")
//    Observable<AutoSingleResponse<TodayWorkBean>> myAchievement(@Query("startDate") String startDate, @Query("endDate") String endDate);
//
//    // 我的成就热力图
//    @Headers("Connection: close")
//    @GET("olisServices/sm/user/getHotmapList")
//    Observable<AutoSingleResponse<MyAchievementHeatMapBean>> myAchievementHeatMap(@Query("startDate") String startDate, @Query("endDate") String endDate);
//
//
//    // 新增开收工录音
//    @Headers("Connection: close")
//    @POST("overhaul/addSound")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<AddGrounResistanceBean>> addSoundRecord(@FieldMap HashMap<String, Object> map);
//
//    // 新增检修资料
//    @Headers("Connection: close")
//    @POST("overhaul/addOverhaulDatum")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<AddGrounResistanceBean>> addInformationRecord(@FieldMap HashMap<String, Object> map);
//
//
//    // 新增接地电阻带图片
//    @Multipart
//    @Headers("Connection: close")
//    @POST("detection/addResistance ")
//    Observable<AutoSingleResponse<AddGrounResistanceBean>> addGroundResistanceAndImage(@FieldMap HashMap<String, Object> map, @Part("file\"; filename=\"image.jpg") RequestBody file);
//
//    //红外测温记录列表
//    @Headers("Connection: close")
//    @GET("detection/temperatureRecordList")
//    Observable<AutoSingleResponse<InfraraedListBean>> getInfraredList(@Query("lineVol") String lineVol, @Query("lineName") String lineName, @Query("isInspected") String isInspected,
//                                                                      @Query("towerNo") String towerNo, @Query("page") int page, @Query("rows") int rows, @Query("taskCode") String taskCode);
//
//    // 红外测温详情页
//    @Headers("Connection: close")
//    @GET("detection/temperatureRecordMsg")
//    Observable<AutoSingleResponse<InfraredDetailBean>> getInfraredDetailList(@Query("recodeCode") String recodeCode);
//
//
//    // 新增红外测温
//    @Headers("Connection: close")
//    @POST("detection/addTemperatureRecord")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<AddGrounResistanceBean>> addInfrared(@FieldMap HashMap<String, Object> map);
//
//    // 交跨测量记录列表
//    @Headers("Connection: close")
//    @GET("detection/measureRecordList")
//    Observable<AutoSingleResponse<PayMeasureListBean>> getPayMeasureList(@Query("lineVol") String lineVol, @Query("lineName") String lineName, @Query("isInspected") String isInspected,
//                                                                         @Query("crossType") Integer crossType, @Query("exeUnitId") String exeUnitId, @Query("startTowerNo") String startTowerNo, @Query("endTowerNo") String endTowerNo,
//                                                                         @Query("taskCode") String taskCode, @Query("page") int page, @Query("rows") int rows, @Query("lineId") String lineId);
//
//    // 交跨测量详情页
//    @Headers("Connection: close")
//    @GET("detection/measureRecordMsg ")
//    Observable<AutoSingleResponse<PayMeasureDetailBean>> getPayMeasureDetailList(@Query("recodeCode") String recodeCode);
//
//    // 新增交跨测量
//    @Headers("Connection: close")
//    @POST("detection/addMeasureRecord")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<AddGrounResistanceBean>> addPayMeasure(@FieldMap HashMap<String, Object> map);
//
//    //上传图片停运图片
//    @Multipart
//    @POST("detection/uploadDetectionPicture")
//    Observable<ResponseBody> uploadImageOffLone(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("recodeCode") String recodeCode,
//                                                @Query("taskCode") String taskCode, @Query("picType") String picType, @Query("remarks") String remarks);
//
//    @Headers("Connection: close")
//    @GET("xiandu/category/wow")
//        //登陆
//    Observable<ResponseBody> test();
//
//    /**
//     * taskName	选填	任务名称
//     * startDate	选填	开始时间
//     * endDate	选填	结束时间
//     * overhaulType	选填	检修分类 1：技改 2：大修 3：日常维护 int
//     * createDeptId	选填	创建部门id
//     * page	必填	当前页数 int
//     * rows	必填	每页条数 int
//     * taskContent	选填	工作内容 android 端无
//     * isPowerCut	选填	是否停电 int,android 端无
//     * powerOutage	选填	停电范围    android 端无
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/overhaulTaskList")
//    //检修分页列表
//    Observable<AutoSingleResponse<RepairListBean>> checkList(@Query("taskName") String taskName, @Query("startDate") String startDate,
//                                                             @Query("endDate") String endDate, @Query("overhaulType") int overhaulType,
//                                                             @Query("createDeptId") String createDeptId, @Query("page") int page,
//                                                             @Query("rows") int rows);
//
//
//    @Headers("Connection: close")
//    @GET(" project/projectArchiveList")
//        //工程管理分页列表
//    Observable<AutoSingleResponse<ProjectListBean>> projectManageList(@Query("projectName") String projectName, @Query("startDate") String startDate,
//                                                                      @Query("endDate") String endDate, @Query("projectType") int projectType,
//                                                                      @Query("page") int page, @Query("rows") int rows);
//
//    @Headers("Connection: close")
//    @GET("overhaul/overhaulTaskMsg")
//        //任务台账
//    Observable<AutoSingleResponse<RepairBillBean>> repairBill(@Query("taskCode") String taskCode);
//
//    @Headers("Connection: close")
//    @GET("project/siteLogList")
//        //工作日志列表
//    Observable<AutoSingleResponse<RepairBillBean>> siteLogList(@Query("projectCode") String projectCode);
//
//    /**
//     * 登杆检查列表
//     * +
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/lamppostList")
//    Observable<AutoSingleResponse<RepairTowerListBean>> repairTower(@Query("startDate") String startDate, @Query("endDate") String endDate,
//                                                                    @Query("taskCode") String taskCode);
//
//    /**
//     * 消缺工作列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/rectifyDefectList")
//    Observable<AutoSingleResponse<RepairTowerListBean>> repairTaskList(@Query("startDate") String startDate, @Query("endDate") String endDate,
//                                                                       @Query("taskCode") String taskCode);
//
//    /**
//     * 绝缘子清扫列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/insulatorClearList")
//    Observable<AutoSingleResponse<RepairTowerListBean>> insulatorClearList(@Query("startDate") String startDate, @Query("endDate") String endDate,
//                                                                           @Query("taskCode") String taskCode);
//
//    /**
//     * 走线检查列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/traceCheckList")
//    Observable<AutoSingleResponse<RepairTowerListBean>> traceCheckList(@Query("startDate") String startDate, @Query("endDate") String endDate,
//                                                                       @Query("taskCode") String taskCode);
//
//    /**
//     * RTV喷涂列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/rtvSprayList")
//    Observable<AutoSingleResponse<RepairTowerListBean>> rtvSprayList(@Query("startDate") String startDate, @Query("endDate") String endDate,
//                                                                     @Query("taskCode") String taskCode);
//
//    /**
//     * 憎水性实验列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/hydrophobicTestList")
//    Observable<AutoSingleResponse<RepairTowerListBean>> hydrophobicTestList(@Query("startDate") String startDate, @Query("endDate") String endDate,
//                                                                            @Query("taskCode") String taskCode);
//
//    /**
//     * 现场勘察列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/siteSurveyList")
//    Observable<AutoSingleResponse<RepairTowerListBean>> siteSurveyList(@Query("taskCode") String taskCode);
//
//    /**
//     * 开收工录音列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/soundList")
//    Observable<AutoSingleResponse<RepairTowerListBean>> soundList(@Query("taskCode") String taskCode);
//
//    /**
//     * 检修资料列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/overhaulDatumList")
//    Observable<AutoSingleResponse<RepairInformationBean>> informationList(@Query("taskCode") String taskCode);
//
//    /**
//     * 接地线管理列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/groundWireMountList")
//    Observable<AutoSingleResponse<RepairGroundBean>> groundList(@Query("taskCode") String taskCode);
//
//    /**
//     * 线路杆塔列表
//     *
//     * @param taskCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/overhaulLineList")
//    Observable<AutoSingleResponse<EquipmentBean>> equipmentList(@Query("taskCode") String taskCode, @Query("selectType") int selectType);
//
//    /**
//     * 选择杆塔
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/overhaulTowerList")
//    Observable<AutoSingleResponse<TowerBean>> lineCheckList(@Query("taskCode") String taskCode, @Query("selectType") int selectType,
//                                                            @Query("lineId") String lineId);
//
//
//    /**
//     * 开收工录音详情
//     *
//     * @param recordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/soundMsg")
//    Observable<AutoSingleResponse<RecordDetailBean>> repairSoundDetail(@Query("recordCode") String recordCode);
//
//    /**
//     * 登杆检查详情
//     *
//     * @param checkRecordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/lamppostMsg")
//    Observable<AutoSingleResponse<RepairTowerDetailBean>> repairTowerDetail(@Query("checkRecordCode") String checkRecordCode);
//
//    /**
//     * 消缺工作详情
//     *
//     * @param recordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/rectifyDefectMsg")
//    Observable<AutoSingleResponse<DefectDetailBean>> repairTaskDetail(@Query("recordCode") String recordCode);
//
//    /**
//     * 绝缘子清扫详情
//     *
//     * @param recordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/insulatorClearMsg")
//    Observable<AutoSingleResponse<InsulatorDetailBean>> insulatorDetail(@Query("recordCode") String recordCode);
//
//    /**
//     * 工程管理详情
//     *
//     * @param projectCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("project/projectArchiveMsg")
//    Observable<AutoSingleResponse<ProjectListDetailBean>> projectManageDetail(@Query("projectCode") String projectCode);
//
//    /**
//     * 检修资料详情
//     *
//     * @param datumCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/overhaulDatumMsg")
//    Observable<AutoSingleResponse<InformationDetailBean>> informationDetail(@Query("datumCode") String datumCode);
//
//    /**
//     * 接地线管理详情
//     *
//     * @param recordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/groundWireMountMsg")
//    Observable<AutoSingleResponse<GroundDetailBean>> groundrDetail(@Query("recordCode") String recordCode);
//
//    /**
//     * 走线检查详情
//     *
//     * @param recordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/traceCheckMsg")
//    Observable<AutoSingleResponse<LineCheckBean>> traceCheckDetail(@Query("recordCode") String recordCode);
//
//    /**
//     * RTV喷涂详情
//     *
//     * @param recordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/rtvSprayMsg")
//    Observable<AutoSingleResponse<RtvSprayDetailBean>> sprayDetail(@Query("recordCode") String recordCode);
//
//    /**
//     * 憎水性实验详情
//     *
//     * @param recordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/hydrophobicTestMsg")
//    Observable<AutoSingleResponse<WaterTestDetailBean>> waterTestDetail(@Query("recordCode") String recordCode);
//
//    /**
//     * 现场查勘详情
//     *
//     * @param recordCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("overhaul/siteSurveyMsg")
//    Observable<AutoSingleResponse<RepairTaskDetailBean>> siteSurveyDetail(@Query("recordCode") String recordCode);
//
//
//    /**
//     * 上传开工收录音频
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadSoundAudio")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upSoundAudio(@Part("file\"; filename=\"video.mp4") RequestBody file, @Query("taskCode") String taskCode, @Query("remarks") String remarks);
//
//    /**
//     * 上传检修资料音频
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadOverhaulDatumAudio")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upInformationAudio(@Part("file\"; filename=\"video.mp4") RequestBody file, @Query("taskCode") String taskCode, @Query("remarks") String remarks);
//
//
//    /**
//     * 上传绝缘子清扫照片
//     * 照片类型 （1：清扫前 2：清扫后） int
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadInsulatorClearPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upInsulatorPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode,
//                                                                       @Query("picType") int picType, @Query("remarks") String remarks);
//
//    /**
//     * 上传RTV喷涂照片
//     * 1：喷涂前照片 2：第一道喷涂照片 3：第二道喷涂照片
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadRtvSprayPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upSprayPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode,
//                                                                   @Query("picType") int picType, @Query("remarks") String remarks);
//
//    /**
//     * 上传接地线管理照片
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadGroundWireMountPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upGroundPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode,
//                                                                    @Query("picType") String picType, @Query("remarks") String remarks);
//
//    /**
//     * 上传憎水性实验照片
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadHydrophobicTestPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upWaterTestPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode, @Query("remarks") String remarks);
//
//    /**
//     * 上传登杆检查照片
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadLamppostPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upTowerPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode,
//                                                                   @Query("picType") int picType, @Query("remarks") String remarks);
//
//    /**
//     * 上传检修资料照片
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadOverhaulDatumPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upInformationPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode,
//                                                                         @Query("picType") int picType, @Query("remarks") String remarks);
//
//    /**
//     * 上传现场查勘照片
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadSiteSurveyPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upSiteSurveyPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode,
//                                                                        @Query("remarks") String remarks);
//
//    /**
//     * 上传走线检查照片
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadTraceCheckPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upLineCheckPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode,
//                                                                       @Query("remarks") String remarks);
//
//    /**
//     * 上传开工收录照片
//     */
//    @Headers("Connection: close")
//    @Multipart
//    @POST("overhaul/uploadSoundPicture")
//    Observable<AutoSingleResponse<UpRepairPhotoBean>> upWorkRecordPhoto(@Part("file\"; filename=\"image.jpg") RequestBody file, @Query("taskCode") String taskCode,
//                                                                        @Query("remarks") String remarks);
//
//    /**
//     * 删除检修资料照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteOverhaulDatumPicture")
//    Observable<AutoSingleResponse<Object>> deleteInformationPicture(@Query("picCode") String picCode);
//
//    /**
//     * 删除开工收录照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteSoundPicture")
//    Observable<AutoSingleResponse<Object>> deleteSoundPicture(@Query("picCode") String picCode);
//
//    /**
//     * 删除开工收录音频
//     *
//     * @param audioCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteSoundAudio")
//    Observable<AutoSingleResponse<Object>> deleteSound(@Query("audioCode") String audioCode);
//
//    /**
//     * 删除检修资料音频
//     *
//     * @param audioCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteOverhaulDatumAudio")
//    Observable<AutoSingleResponse<Object>> deleteInformationSound(@Query("audioCode") String audioCode);
//
//    /**
//     * 删除憎水性实验照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteHydrophobicTestPicture")
//    Observable<AutoSingleResponse<Object>> deleteWaterTestPhoto(@Query("picCode") String picCode);
//
//    /**
//     * 删除走线检查照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteTraceCheckPicture")
//    Observable<AutoSingleResponse<Object>> deleteLineCheckPhoto(@Query("picCode") String picCode);
//
//    /**
//     * 删除RTV喷涂照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteRtvSprayPicture")
//    Observable<AutoSingleResponse<Object>> deleteSprayPhoto(@Query("picCode") String picCode);
//
//    /**
//     * 删除登杆检查照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteLamppostPicture")
//    Observable<AutoSingleResponse<Object>> deleteTowerPhoto(@Query("picCode") String picCode);
//
//    /**
//     * 删除登杆检查照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteRtvSprayPicture")
//    Observable<AutoSingleResponse<Object>> deleteRtvSprayPicture(@Query("picCode") String picCode);
//
//    /**
//     * 删除登杆检查照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteRtvSprayPicture")
//    Observable<AutoSingleResponse<Object>> deleteSiteSurveyPicture(@Query("picCode") String picCode);
//
//    /**
//     * 删除登杆检查照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteHydrophobicTestPicture")
//    Observable<AutoSingleResponse<Object>> deleteHydrophobicTestPicture(@Query("picCode") String picCode);
//
//    /**
//     * 删除登杆检查照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteInsulatorClearPicture")
//    Observable<AutoSingleResponse<Object>> deleteInsulatorClearPicture(@Query("picCode") String picCode);
//
//    /**
//     * 删除走线检查照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteTraceCheckPicture")
//    Observable<AutoSingleResponse<Object>> deleteTraceCheckPicture(@Query("picCode") String picCode);
//
//    /**
//     * 删除现场勘察照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteSiteSurveyPicture")
//    Observable<AutoSingleResponse<Object>> deleteSitePhoto(@Query("picCode") String picCode);
//
//    /**
//     * 删除接地线管理照片
//     *
//     * @param picCode 必填
//     */
//    @Headers("Connection: close")
//    @DELETE("overhaul/deleteGroundWireMountPicture")
//    Observable<AutoSingleResponse<Object>> deleteGroundPhoto(@Query("picCode") String picCode);
//
//    /**
//     * 新增登杆检查
//     * lineId	必填	线路id
//     * lineName	必填	线路名称
//     * towerId	必填	杆塔id
//     * towerNo	必填	杆号
//     * taskCode	必填	任务编码
//     * lineVol	必填	电压等级
//     * phase	必填	相别 0:A 1:B 2:C
//     * textName	选填	内容描述
//     * picCodes	选填	上传照片编号(字符串多个用逗号分隔)
//     */
//    @Headers("Connection: close")
//    @POST("overhaul/addLamppost")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addTowerCheck(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 新增走线检查
//     */
//    @Headers("Connection: close")
//    @POST("overhaul/addTraceCheck")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addLineCheck(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 新增工程管理
//     */
//    @Headers("Connection: close")
//    @POST("project/addProjectArchive")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<AddProjectBean>> addProjectManage(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 新增工程管理日志
//     */
//    @Headers("Connection: close")
//    @POST("project/addSiteLog")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<AddProjectBean>> addSiteLog(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 新增憎水性实验
//     */
//    @Headers("Connection: close")
//    @POST("overhaul/addHydrophobicTest")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addWaterTest(@FieldMap HashMap<String, Object> map);
//
//
//    /**
//     * 新增绝缘子清扫
//     * lineId	必填	线路id
//     * lineName	必填	线路名称
//     * towerId	必填	杆塔id
//     * towerNo	必填	杆号
//     * taskCode	必填	任务编码
//     * lineVol	必填	电压等级
//     * phase	必填	相别 0:A 1:B 2:C
//     * textName	选填	内容描述
//     * picCodes	选填	上传照片编号(字符串多个用逗号分隔)
//     */
//    @Headers("Connection: close")
//    @POST("overhaul/addInsulatorClear")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addInsulatorClear(@FieldMap HashMap<String, Object> map);
//
//
//    /**
//     * 新增现场查勘
//     * taskCode	必填	任务编号
//     * lineId	必填	线路id
//     * towerId	必填	杆塔id
//     * workContent	必填	安全措施
//     * surveyManId	必填	查勘人id
//     * picCodes	选填	上传照片编号(字符串多个用逗号分隔)
//     */
//    @Headers("Connection: close")
//    @POST("overhaul/addSiteSurvey")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addSiteSurvey(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 编辑接地线管理
//     */
//    @Headers("Connection: close")
//    @POST("overhaul/updateGroundWireMount")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateGroundCheck(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 新增接地线挂接
//     */
//    @Headers("Connection: close")
//    @POST("overhaul/addGroundWireMount")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addGroundMout(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 新增RTV喷涂
//     */
//    @Headers("Connection: close")
//    @POST("overhaul/addRtvSpray")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addSpray(@FieldMap HashMap<String, Object> map);
//
//
//    // // 审核提交
//    //    public static final String AUDIT_COMMIT_URL = "/eap/pmsServices/transmission/tower/checkDefect";
//    //
//    //    // 缺陷提交
//    //    public static final String FLAW_COMMIT_URL = "/eap/pmsServices/transmission/tower/workOutDefect";
//
//    // TODO: 2019/7/7
//
//    /**
//     * 审核提交
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/defect/checkDefect")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> checkDefect(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 班组审核、专职审核、专职验收、下发任务提交
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/process/updateProcess")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateProcess(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 值守隐患班组审核、专职审核、专职验收、下发任务提交
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/duty/process/updateProcess")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> dutyUpdateProcess(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 新增值守隐患
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/duty/insertDutyHiddenTrouble")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> insertDutyHiddenTrouble(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 修改值守隐患
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/duty/editDutyHiddenTrouble")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> editDutyHiddenTrouble(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 可更新当前值守人 更换隐患值守人(交接班发送任务)
//     * hiddenTroubleCode
//     * dutyUserCodeDesc
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/duty/updateDutyHiddenTroubleForDuty")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateDutyHiddenTroubleForDuty(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 我的值守上下工
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/duty/updateDutyHiddenTroubleForSign")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateDutyHiddenTroubleForSign(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 隐患消除
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/process/submitEliminateApply")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> submitEliminateApply(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 缺陷提交
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/defect/workOutDefect")
//    @Multipart
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> workOutDefect(@Part List<MultipartBody.Part> requestBodyMap);
//
//
//    /**
//     * 缺陷等级
//     *
//     * @param companyCode 必填
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getGrade")
//    Observable<AutoSingleResponse<PowerDefectLevelBean>> getDefectLevel(@Query("companyCode") String companyCode);
//
//    /**
//     * 缺陷管理列表   buffer.append("&gradeType=%s&shudianTeam=%s&daiweiTeam=%s&prefix=%s");
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getPageDefectList")
//    Observable<AutoSingleResponse<PagerDefectBean>> getPageDefectList(@Query("searchName") String searchName, @Query("currentPage") int currentPage,
//                                                                      @Query("state") String state, @Query("defectClass") String defectClass,
//                                                                      @Query("state1") String state1, @Query("voltageLevel") String voltageLevel,
//                                                                      @Query("xlinteRid") String xlinteRid, @Query("fromDate") String fromDate,
//                                                                      @Query("toDate") String toDate, @Query("orderBy") String orderBy,
//                                                                      @Query("selectUnits") String selectUnits, @Query("companyCode") String companyCode,
//                                                                      @Query("unitCode") String unitCode, @Query("prefix") String prefix,
//                                                                      @Query("gradeType") String gradeType, @Query("shudianTeam") String shudianTeam,
//                                                                      @Query("daiweiTeam") String daiweiTeam);
//
//    /**
//     * 缺陷分布列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getMapDefectList")
//    Observable<AutoSingleResponse<PagerDefectBean>> getMapDefectList(@Query("searchName") String searchName, @Query("currentPage") String currentPage,
//                                                                     @Query("state") String state, @Query("defectClass") String defectClass,
//                                                                     @Query("state1") String state1, @Query("voltageLevel") String voltageLevel,
//                                                                     @Query("xlinteRid") String xlinteRid, @Query("fromDate") String fromDate,
//                                                                     @Query("toDate") String toDate, @Query("orderBy") String orderBy,
//                                                                     @Query("selectUnits") String selectUnits, @Query("companyCode") String companyCode,
//                                                                     @Query("unitCode") String unitCode, @Query("prefix") String prefix);
//
//
//    /**
//     * 隐患管理列表
//     * 运维版新增参数（companyCode，unitCode，shudianTeam，daiweiTeam）
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/getPageHiddenTroubleList")
//    Observable<AutoSingleResponse<HiddenTroubleListBean>> getPageHiddenTroubleList(@Query("searchName") String xlName, @Query("currentPage") int currentPage,
//                                                                                   @Query("hiddenTroubleLevel") String hiddenTroubleLevel, @Query("isWatch") String isWatch,
//                                                                                   @Query("isEliminate") String isEliminate, @Query("voltageLevel") String voltageLevel,
//                                                                                   @Query("xlinteRid") String xlinteRid, @Query("fromDate") String fromDate,
//                                                                                   @Query("toDate") String toDate, @Query("orderBy") String orderBy,
//                                                                                   @Query("selectUnits") String selectUnits, @Query("prefix") String prefix,
//                                                                                   @Query("companyCode") String companyCode, @Query("unitCode") String unitCode,
//                                                                                   @Query("sdDeptCode") String shudianTeam, @Query("daiweiTeam") String daiweiTeam);
//
//
//    /**
//     * 隐患管理列表 运维版（只能查看，不能提交）
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/getMapHiddenTroubleList")
//    Observable<AutoSingleResponse<HiddenDefectBean>> getMapHiddenTroubleList(@Query("xlName") String xlName, @Query("currentPage") int currentPage,
//                                                                             @Query("hiddenTroubleLevel") String hiddenTroubleLevel, @Query("isWatch") String isWatch,
//                                                                             @Query("isEliminate") String isEliminate, @Query("voltageLevel") String voltageLevel,
//                                                                             @Query("xlinteRid") String xlinteRid, @Query("fromDate") String fromDate,
//                                                                             @Query("toDate") String toDate, @Query("orderBy") String orderBy,
//                                                                             @Query("selectUnits") String selectUnits, @Query("prefix") String prefix);
//
//    /**
//     * 值守隐患列表 运维版
//     * searchName:可搜索隐患编号，线路
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getAppDutyHiddenTroubleList")
//    Observable<AutoSingleResponse<HiddenTroubleListBean>> getDutyPageHiddenTroubleList(@Query("searchName") String xlName, @Query("currentPage") int currentPage,
//                                                                                       @Query("hiddenTroubleLevel") String hiddenTroubleLevel, @Query("haveProblem") String haveProblem,
//                                                                                       @Query("isEliminate") String isEliminate, @Query("voltageLevel") String voltageLevel,
//                                                                                       @Query("xlinteRid") String xlinteRid, @Query("fromDate") String fromDate,
//                                                                                       @Query("toDate") String toDate, @Query("orderBy") String orderBy,
//                                                                                       @Query("selectUnits") String selectUnits, @Query("prefix") String prefix,
//                                                                                       @Query("firstday") String firstday, @Query("lastday") String lastday,
//                                                                                       @Query("companyCode") String companyCode, @Query("unitCode") String unitCode,
//                                                                                       @Query("sdDeptCode") String shudianTeam, @Query("daiweiTeam") String daiweiTeam,
//                                                                                       @Query("perpage") int prepage);
//
//    /**
//     * 缺陷班组（所有的组织机构，包含运维班组和输电班组）
//     * 此接口暂时不用，使用代维班组接口和运维班组接口
//     * companyCode 不用传，后台已写token.getOrganization
//     * 1、传参数conpanyCode 非必填
//     * 2、去原来的电压
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getUnits")
//    Observable<AutoSingleResponse<PowerUnitsBean>> getUnits(@Query("companyCode") String companyCode);
//
//
//    /**
//     * 我的值守列表
//     *
//     * @param dutyUserCode code
//     * @param isWatch      1
//     * @param sourceType   1 排除值守现状的隐患
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getAppDutyHiddenTroubleList")
//    Observable<AutoSingleResponse<DutyTaskBean>> getAppDutyHiddenTroubleList(@Query("dutyUserCode") String dutyUserCode, @Query("isWatch") int isWatch,
//                                                                             @Query("sourceType") int sourceType, @Query("currentPage") int currentPage);
//
//    /**
//     * {{url}}/olis/eap//olisServices/sm/user/queryDeptMemberList?userType=2
//     * 值守隐患选择值守人
//     */
//    @Headers("Connection: close")
//    @GET("olisServices/sm/user/queryDeptMemberList")
//    Observable<AutoSingleResponse<HiddenPersonBean>> queryDeptMemberList(@Query("userType") int userType, @Query("userName") String searchName);
//
//    /**
//     * 获取未消除未值守的隐患列表
//     * hiddenTroubleLevel voltageLevel   fromDate  toDate
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/selectHiddenTroubleForDuty")
//    Observable<AutoSingleResponse<HiddenTroubleListBean>> selectHiddenTroubleForDuty(@Query("hiddenTroubleLevel") String hiddenTroubleLevel, @Query("currentPage") int currentPage,
//                                                                                     @Query("searchName") String searchName, @Query("fromDate") String fromDate,
//                                                                                     @Query("toDate") String toDate, @Query("voltageLevel") String voltageLevel,
//                                                                                     @Query("xlinteRid") String xlinteRid, @Query("selectUnits") String selectUnits);
//
//    /**
//     * 交接班选择人员
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/queryHiddenTroubleDutyUser")
//    Observable<AutoSingleResponse<HiddenPersonBean>> queryHiddenTroubleDutyUser(@Query("hiddenTroubleCode") String hiddenTroubleCode);
//
//    /**
//     * 值守上下工认证方式
//     * 1 普通打卡 2 人脸识别打卡 3 答题打卡
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getHiddenTroubleConfig")
//    Observable<AutoSingleResponse<DutyOnLineBean>> getHiddenTroubleConfig();
//
//    /**
//     * 值守上工答题
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getOneAnswerSheetToDuty")
//    Observable<AutoSingleResponse<HidenAnswerBean>> getOneAnswerSheetToDuty();
//
//
//    /**
//     * 获取输电班组
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getShuDianTeam")
//    Observable<AutoSingleResponse<UnitModel>> getShuDianTeam(@Query("unitCode") String unitCode, @Query("companyCode") String companyCode);
//
//    /**
//     * 隐患巡视信息列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/queryPageForHiddenTrouble")
//    Observable<AutoSingleResponse<HiddenCheckListBean>> queryPageForHiddenTrouble(@Query("currentPage") int currentPage, @Query("hiddenTroubleCode") String hiddenTroubleCode,
//                                                                                  @Query("fromDate") String fromDate, @Query("toDate") String toDate);
//
//    /**
//     * 缺陷详情（运维版）
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getDetailDefect")
//    Observable<AutoSingleResponse<DefectManageDetailBean>> getDetailDefect(@Query("defectCode") String defectCode, @Query("companyCode") String companyCode);
//
//    /**
//     * 缺陷详情（运维版）
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getDetailDefect")
//    Observable<AutoSingleResponse<FlawManageB>> getDetailDefect1(@Query("defectCode") String defectCode, @Query("companyCode") String companyCode);
//
//    /**
//     * 隐患管理详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/getHiddenDetail")
//    Observable<AutoSingleResponse<HiddenDetailBean>> getHiddenDetail(@Query("hiddenTroubleCode") String hiddenTroubleCode, @Query("fromDate") String fromDate, @Query("toDate") String toDate);
//
//    /**
//     * 值守隐患详情
//     * 我的值守专用：dutyUserCode
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getDutyHiddenDetail")
//    Observable<AutoSingleResponse<WatchHiddenDetailbean>> getDutyHiddenDetail(@Query("hiddenTroubleCode") String hiddenTroubleCode, @Query("companyCode") String companyCode,
//                                                                              @Query("fromDate") String fromDate, @Query("toDate") String toDate, @Query("dutyUserCode") String dutyUserCode);
//
//    /**
//     * 获取值守隐患未到位日期列表
//     */
//    @Headers("Connection: close")
//    @GET(" pmsServices/hiddenTrouble/duty/getBadDutyDateList")
//    Observable<AutoSingleResponse<HiddenBadDutyBean>> getBadDutyDateList(@Query("inspectCode") String inspectCode,
//                                                                         @Query("fromDate") String fromDate, @Query("toDate") String toDate);
//
//    /**
//     * 值守隐患地图详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getDutyLineById")
//    Observable<AutoSingleResponse<HiddenLinePointBean>> getGuardDutyLineById(@Query("companyCode") String companyCode, @Query("xlinteRid") String xlinteRid,
//                                                                             @Query("hiddenTroubleCode") String hiddenTroubleCode);
//
//
//    /**
//     * 隐患地图详情
//     * olis/eap/pmsServices/hiddenTrouble/hiddenTrouble/getLineById
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/getLineById")
//    Observable<AutoSingleResponse<HiddenLinePointBean>> getHiddenLineById(@Query("companyCode") String companyCode, @Query("xlinteRid") String xlinteRid,
//                                                                          @Query("hiddenTroubleCode") String hiddenTroubleCode);
//
//    /**
//     * 值守隐患地图详情
//     * public static final String CIRCUIT_AREA = "/eap/pmsServices/transmission/tower/getLineById?ticket=%s&xlinteRid=%s&hiddenTroubleCode=%s&companyCode=%s";
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getLineById")
//    Observable<AutoSingleResponse<HiddenDetailBean>> getLineById(@Query("companyCode") String companyCode, @Query("xlinteRid") String xlinteRid,
//                                                                 @Query("hiddenTroubleCode") String hiddenTroubleCode);
//
//    /**
//     * 隐患督察
//     * pmsServices/superintendRisk/getPageSuperintendRiskList?riskCode=H20190220083501161050&currentPage=1
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/superintendRisk/getPageSuperintendRiskList")
//    Observable<AutoSingleResponse<SuperviseBean>> getPageSuperintendRiskList(@Query("companyCode") String companyCode, @Query("fromDate") String fromDate,
//                                                                             @Query("toDate") String toDate, @Query("superintendType") String superintendType,
//                                                                             @Query("riskCode") String riskCode, @Query("currentPage") int currentPage, @Query("perPage") int perPage);
//
//    /**
//     * 隐患督察类型
//     * pmsServices/superintendRisk/superintendTypeList?companyCode=D00000001&inspector=U000000001
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/superintendRisk/superintendTypeList")
//    Observable<AutoSingleResponse<HiddenTypeBean>> superintendTypeList(@Query("companyCode") String companyCode, @Query("inspector") String inspector);
//
//
//    /**
//     * 值守隐患值守记录列表
//     * pmsServices/hiddenTrouble/duty/getHistoryDutyList?inspectCode=H20170829084027672996
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getHistoryDutyList")
//    Observable<AutoSingleResponse<WatchHiddenRecordBean>> getHistoryDutyList(@Query("companyCode") String companyCode, @Query("inspectCode") String inspectCode);
//
//    /**
//     * 隐患管控记录列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/control/getPageControlList")
//    Observable<AutoSingleResponse<HiddenControlBean>> getPageControlList(@Query("hiddenTroubleCode") String hiddenTroubleCode, @Query("fromDate") String fromDate,
//                                                                         @Query("toDate") String toDate, @Query("currentPage") int currentPage);
//
//    /**
//     * 隐患管控记录详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/control/getControlDetail")
//    Observable<AutoSingleResponse<HiddenControlDetailBean>> getControlDetail(@Query("hiddenTroubleCode") String hiddenTroubleCode, @Query("id") String id);
//
//    /**
//     * 获取用户模块
//     */
//    @Headers("Connection: close")
//    @GET("olisServices/sm/queryAppModuleList")
//    Observable<AutoSingleResponse<LoginDynamicBean>> queryAppModuleList(@Query("lappCode") String companyCode);
//
//    /**
//     * 我的界面配置
//     */
//    @Headers("Connection: close")
//    @GET("olisServices/sm/queryAppModuleList")
//    Observable<AutoSingleResponse<MineListBean>> queryMineModleList(@Query("lappCode") String companyCode);
//
//    /**
//     * 值守任务详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/task/getDutyTaskDetail")
//    Observable<AutoSingleResponse<HiddenTaskDetailBean>> getDutyTaskDetail(@Query("taskCode") String taskCode);
//
//    /**
//     * 隐患巡视/值守任务详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/process/getProcessTaskDetailList")
//    Observable<AutoSingleResponse<HiddenTaskDetailBean>> getProcessTaskDetailList(@Query("hiddenTroubleCode") String hiddenTroubleCode);
//
//    /**
//     * 新增或更新巡视任务
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/inspect/task/addOrUpdateInspectTask")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addOrUpdateInspectTask(@FieldMap HashMap<String, Object> map);
//
//
//    /**
//     * 隐患文件删除接口(告知书,交底记录等)
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/hiddenTrouble/deleteHiddenTroublePicBook")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> deleteHiddenTroublePicBook(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 隐患隐患管控照片
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/control/deleteControlOperationPic")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> deleteControlOperationPic(@FieldMap HashMap<String, Object> map);
//
//
//    /**
//     * 领取值守任务
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/duty/task/updateAppDutyTask")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateAppDutyTask(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 提交管控措施勾选情况
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/control/addControlOperation")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addControlOperation(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 隐患修改
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/hiddenTrouble/editHiddenTrouble")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateHiddenTroubleByCode(@FieldMap HashMap<String, Object> map);
//
//
//    /**
//     * 值守隐患记录查询
//     * dutyCode 值守人人员编号 >>DUTY_USER_CODE
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getDutyDetailByInspectCode")
//    Observable<AutoSingleResponse<HiddenTaskUpListBean>> getDutyTaskDetailList(@Query("inspectCode") String inspectCode, @Query("dutyCode") String dutyCode,
//                                                                               @Query("fromDate") String fromDate, @Query("toDate") String toDate);
//
//
//    /**
//     * 停用
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/task/getPageDutyTaskList")
//    Observable<AutoSingleResponse<HiddenTaskBean>> getPageDutyTaskList(@Query("dutyGroupCode") String dutyGroupCode, @Query("dutyUserCode") String dutyUserCode,
//                                                                       @Query("currentPage") int currentPage, @Query("taskSearchName") String taskSearchName);
//
//    /**
//     * 值守隐患任务分页 TASK_STATUS 1 :待领取 (停用)
//     * <p>
//     * 我的值守任务
//     * *  dutyGroupCode:任务列表 deptCode
//     * *  dutyUserCode：值守任务 userCode taskSearchName(模糊查询班组名称和值守人名称)
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/task/getAppPageDutyTaskList")
//    Observable<AutoSingleResponse<HiddenTaskPageBean>> getAppPageDutyTaskList(@Query("dutyGroupCode") String dutyGroupCode, @Query("currentPage") int currentPage,
//                                                                              @Query("dutyUserCode") String dutyUserCode, @Query("taskSearchName") String taskSearchName);
//
//
//    /**
//     * 值守上报（值守隐患新增）
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/duty/addDuty")
//    @Multipart
//    Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addDuty(@Part List<MultipartBody.Part> requestBodyMap);
//
//
//    /**
//     * 值守隐患任务分页 TASK_STATUS 1 :待领取
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/getOneDuty")
//    Observable<AutoSingleResponse<HiddenOneDutyBean>> getOneDuty(@Query("hiddenTroubleCode") String inspectCode,
//                                                                 @Query("lineName") String lineName, @Query("towerNo") String towerNo);
//
//
//    /**
//     * 线路巡视列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getVoltageLevel")
//    Observable<AutoSingleResponse<LineInspectModel>> lineInspectionList(@Query("companyCode") String companyCode, @Query("unitCode") String unitCode, @Query("shudianTeam") String shudianTeam, @Query("daiweiTeam") String daiweiTeam);
//
//    /**
//     * 线路列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLines")
//    Observable<AutoSingleResponse<LineModel>> getLines(@Query("voltageLevel") String voltageLevel, @Query("companyCode") String companyCode, @Query("unitCode") String unitCode, @Query("shudianTeam") String shudianTeam, @Query("daiweiTeam") String daiweiTeam, @Query("xlinteRid") String xlinteRid);
//
//    /**
//     * 线路巡视列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getVoltageLevelPatrol")
//    Observable<AutoSingleResponse<LineInspectModel>> getVoltageLevelPatrol(@Query("companyCode") String companyCode, @Query("unitCode") String unitCode, @Query("shudianTeam") String shudianTeam, @Query("daiweiTeam") String daiweiTeam);
//
//    /**
//     * 线路巡视子列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getZhixian")
//    Observable<AutoSingleResponse<LineInspectChildModel>> lineInspectionChildList(@Query("xlinteRid") String xlinteRid, @Query("companyCode") String companyCode, @Query("unitCode") String unitCode);
//
//    /**
//     * 杆塔列表
//     *
//     * @param xlinteRid
//     * @param searchName
//     * @param companyCode
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getTowers")
//    Observable<AutoSingleResponse<TowerModel>> towerList(@Query("xlinteRid") String xlinteRid, @Query("searchName") String searchName, @Query("companyCode") String companyCode);
//
//    /**
//     * 随手拍列表
//     *
//     * @param companyCode
//     * @param fromDate
//     * @param toDate
//     * @param currentPage
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getInfoPages")
//    Observable<AutoSingleResponse<ClickPhotoModel>> infoPages(@Query("inteRid") String inteRid, @Query("companyCode") String companyCode, @Query("fromDate") String fromDate, @Query("toDate") String toDate, @Query("currentPage") int currentPage);
//
//    /**
//     * 新增随手拍
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/transmission/tower/addPtiInformation")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<Object>> addPtiInformation(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 新增隐患
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/hiddenTrouble/insertHiddenTrouble")
//    @Multipart
//    Observable<AutoSingleResponse<Object>> insertHiddenTrouble(@Part List<MultipartBody.Part> requestBodyMap);
//
//
//    /**
//     * 设备搜索电压
//     * companyCode 不用传，后台已写token.getOrganization
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getDianYa")
//    Observable<AutoSingleResponse<VoltageLevelModel>> getVoltageList(@Query("companyCode") String companyCode);
//
//    /**
//     * 隐患线路区域
//     * voltageLevel 电线
//     * xlinteRid 杆号
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getGh")
//    Observable<AutoSingleResponse<EquipmentSearchBModel>> getGh(@Query("voltageLevel") String voltageLevel, @Query("xlinteRid") String xlinteRid,
//                                                                @Query("unitCode") String unitCode, @Query("taskCode") String taskCode);
//
//    /**
//     * 隐患类别
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/getTroubleList")
//    Observable<AutoSingleResponse<RiskTypeModel>> getTroubleList();
//
//    /**
//     * 缺陷台账提交
//     * pmsServices/defect/addDefect
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/defect/addDefect")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<AddTower1Model>> addTower(@FieldMap HashMap<String, Object> map);
//
//
//    /**
//     * 督查登记
//     */
//    @Headers("Connection: close")
//    @POST("ptiServices/superintendRisk/add")
//    @Multipart
//    Observable<AutoSingleResponse<Object>> addDC(@Part List<MultipartBody.Part> requestBodyMap);
//
//    /**
//     * 查询隐患管控措施操作情况
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/control/getControlOperationList")
//    Observable<AutoSingleResponse<ControlListBean>> getControlOperationList(@Query("hiddenTroubleCode") String hiddenTroubleCode);
//
//    /**
//     * 督查登记详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/superintendRisk/getSuperintendRiskDetail")
//    Observable<AutoSingleResponse<DcDetailModel>> getDcDetail(@Query("superintendCode") String superintendCode);
//
//    /**
//     * 缺陷等级得到设备类型
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getDeviceType")
//    Observable<AutoSingleResponse<DeviceTypeModel>> getDeviceType();
//
//    /**
//     * 缺陷等级得到设备部件
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getDeviceParts")
//    Observable<AutoSingleResponse<PartsModel>> getDeviceParts(@Query("deviceTypeCode") String deviceTypeCode);
//
//    /**
//     * 缺陷等级得到部件种类
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getDevicePartsType")
//    Observable<AutoSingleResponse<PartsTypeModel>> getDevicePartsType(@Query("partsCode") String partsCode);
//
//    /**
//     * 缺陷等级得到部位
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getDeviceWidget")
//    Observable<AutoSingleResponse<WidgetModel>> getDeviceWidget(@Query("partsTypeCode") String partsTypeCode);
//
//    /**
//     * 缺陷等级得到缺陷描述
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getDefectType1")
//    Observable<AutoSingleResponse<DefectTypeModel>> getDefectType1(@Query("widgetCode") String widgetCode);
//
//    /**
//     * 缺陷描述 - 钓鱼牌
//     * startTowerId=xx&endTowerId=xx&lineId=xx
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/deviceMgr/getFishCardNumByState")
//    Observable<AutoSingleResponse<FishingSignModel>> queryFishingSign(@Query("lineId") String lineId, @Query("startTowerId") String startTowerId,
//                                                                      @Query("endTowerId") String endTowerId, @Query("state") String state);
//
//    /**
//     * 缺陷等级得到分类依据
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getDefectType2")
//    Observable<AutoSingleResponse<DeviceType2Model>> getDefectType2(@Query("defectContent") String defectContent);
//
//    /**
//     * 缺陷等级
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getGrade")
//    Observable<AutoSingleResponse<DefectGradeModel>> getGrade(@Query("companyCode") String companyCode);
//
//
//    /**
//     * 缺陷台账
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/defect/editDefect")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<Object>> updateDefect(@FieldMap HashMap<String, Object> map);
//
//    /**
//     * 获取代维班组
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getDaiweiTeam")
//    Observable<AutoSingleResponse<UnitModel>> getDwTeam(@Query("shudianTeam") String unitCode, @Query("companyCode") String companyCode);
//
//    /**
//     * 获取输电班组
//     *
//     * @return
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getShuDianTeam")
//    Observable<AutoSingleResponse<UnitModel>> getSdTeam(@Query("unitCode") String unitCode, @Query("companyCode") String companyCode);
//
//    /**
//     * 查询单个流程节点最新一条 详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/process/getProcessRecordDetailList")
//    Observable<AutoSingleResponse<HiddenAuditDetailBean>> getProcessRecordDetailList(@Query("processCode") String processCode, @Query("nodeOrder") String nodeOrder);
//
//    /**
//     * 查询单个值守隐患流程节点最新一条 详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/process/getProcessRecordDetailList")
//    Observable<AutoSingleResponse<HiddenAuditDetailBean>> getDutyProcessRecordDetailList(@Query("processCode") String processCode, @Query("nodeOrder") String nodeOrder);
//
//
//    /**
//     * 隐患流程节点进度情况
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/process/getProcessNodeHasHandle")
//    Observable<AutoSingleResponse<HiddenFlowStateBean>> getProcessNodeHasHandle(@Query("hiddenTroubleCode") String hiddenTroubleCode);
//
//    /**
//     * 值守隐患流程节点进度情况
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/duty/process/getProcessNodeHasHandle")
//    Observable<AutoSingleResponse<HiddenFlowStateBean>> getDutyProcessNodeHasHandle(@Query("hiddenTroubleCode") String hiddenTroubleCode);
//
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getZhixian")
//    Observable<AutoSingleResponse<LineInspectChildModel>> getBranchList(@Query("xlinteRid") String xlinteRid, @Query("companyCode") String companyCode,
//                                                                        @Query("unitCode") String unitCode, @Query("shudianTeam") String shudianTeam, @Query("daiweiTeam") String daiweiTeam);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getdropdownLinesBySearchName")
//    Observable<AutoSingleResponse<DropLineModel>> getdropdownLinesBySearchName(@Query("searchName") String searchName, @Query("companyCode") String companyCode);
//
//    /**
//     * 设备详情
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getTowersDetail")
//    Observable<AutoSingleResponse<EquipmentSearchB>> getTowersDetail(@Query("inteRid") String inteRid, @Query("xlinteRid") String xlinteRid, @Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getCoordsAuth")
//    Observable<AutoSingleResponse<CoordsAuthModel>> getCoordsAuth(@Query("companyCode") String companyCode, @Query("inspectMan") String inspectMan);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getTowerPicList")
//    Observable<AutoSingleResponse<PicModel>> getTowerPicList(@Query("inteRid") String inteRid, @Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getMainlineAndOther")
//    Observable<AutoSingleResponse<MainlineAndOtherModel>> getMainlineAndOther(@Query("xlinteRid") String xlinteRid, @Query("companyCode") String companyCode, @Query("unitCode") String unitCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineSameTower")
//    Observable<AutoSingleResponse<LineSameTowerModel>> getLineSameTower(@Query("xlinteRid") String xlinteRid);
//
//    @Headers("Connection: close")
//    @GET("olisServices/inspectRecord/getInpectRecordPicByInspectCode")
//    Observable<AutoSingleResponse<PicCodeModel>> getInpectRecordPicByInspectCode(@Query("inspectCode") String inspectCode, @Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("olisServices/inspectRecord/getInpectRecordByInterIdNj")
//    Observable<AutoSingleResponse<PollingListBModel>> getInpectRecordByInterIdNj(@Query("inteRid") String inteRid, @Query("inspectType") String inspectType, @Query("fromDate") String fromDate,
//                                                                                 @Query("toDate") String toDate, @Query("companyCode") String companyCode, @Query("xlinteRid") String xlinteRid);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getDefectByInterid")
//    Observable<AutoSingleResponse<FlawManageBModel>>
//    getDefectByInterid(@Query("inteRid") String inteRid, @Query("state") String state, @Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/getHiddenTroubleList")
//    Observable<AutoSingleResponse<RiskManageBModel>> getHiddenTroubleList(@Query("xlinteRid") String xlinteRid, @Query("inteRid") String inteRid, @Query("companyCode") String companyCode,
//                                                                          @Query("hiddenTroubleLevel") String hiddenTroubleLevel, @Query("isWatch") String isWatch, @Query("fromDate") String startTime, @Query("toDate") String endTime, @Query("orderBy") String orderBy);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getInfraPics")
//    Observable<AutoSingleResponse<InfraRedBeanModel>> getInfraPics(@Query("xlinteRid") String xlinteRid, @Query("inteRid") String inteRid, @Query("fromDate") String fromDate, @Query("toDate") String toDate, @Query("typeCode") String typeCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getInfraPicsType")
//    Observable<AutoSingleResponse<TypeModel>> getInfraPicsType();
//
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getRemainDefect")
//    Observable<AutoSingleResponse<RemainDefectNumModel>> getRemainDefect(@Query("xlinteRid") String xlinteRid, @Query("inteRid") String inteRid);
//
//    @Headers("Connection: close")
//    @POST("pmsServices/transmission/tower/deleteDevicePic")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<Object>> deleteDevicePic(@FieldMap HashMap<String, Object> map);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getchannelVisualization")
//    Observable<AutoSingleResponse<MyBeanModel>> getchannelVisualization(@Query("startDate") String startDate, @Query("lineId") String lineId, @Query("gh") String gh,
//                                                                        @Query("companyCode") String companyCode, @Query("ptype") String ptype, @Query("inteRid") String inteRid);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getTowerUavRecords")
//    Observable<AutoSingleResponse<TowerUavRecordsModel>> getTowerUavRecords(@Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getTowerPics")
//    Observable<AutoSingleResponse<TowerPicsModel>> getTowerPics(@Query("companyCode") String companyCode, @Query("inspectCode") String inspectCode, @Query("xlinteRid") String xlinteRid, @Query("inteRid") String inteRid);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/getHiddenDetail")
//    Observable<AutoSingleResponse<RiskDetailsTourBeanModel>> getHiddenDetail(@Query("hiddenTroubleCode") String hiddenTroubleCode, @Query("fromDate") String fromDate, @Query("toDate") String toDate, @Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/superintendRisk/getPageSuperintendRiskList")
//    Observable<AutoSingleResponse<DCRecordAllModel>> getDCList(@Query("companyCode") String companyCode, @Query("fromDate") String fromDate, @Query("toDate") String toDate,
//                                                               @Query("superintendType") String superintendType, @Query("riskCode") String riskCode);
//
//
//    /**
//     * 隐患消除 List<MultipartBody.Part> requestBodyMap
//     */
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/hiddenTrouble/updateHiddenTrouble")
//    Observable<AutoSingleResponse<SuperintendTypeModel>> updateHiddenTrouble(List<MultipartBody.Part> requestBodyMap);
//
//    /**
//     * 杆塔列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getTowers")
//    Observable<AutoSingleResponse<EquipmentInfoModel>> towerList(@Query("xlinteRid") String xlinteRid, @Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getTrans")
//    Observable<AutoSingleResponse<EquipmentInfoModel>> getTrans(@Query("xlinteRid") String xlinteRid, @Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getDefectAndTrouble")
//    Observable<AutoSingleResponse<EquipmentInfoModel>> getDefectAndTrouble(@Query("xlinteRid") String xlinteRid, @Query("companyCode") String companyCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/bigscreen/queryDeviceListForSD")
//    Observable<EquipmentInfoModel> queryDeviceListForSD(@Query("xlinteRid") String xlinteRid);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/defect/getAreaTowerDefectHiddentrouble")
//    Observable<AutoSingleResponse<EquipmentInfoModel>> getAreaTowerDefectHiddentrouble(@Query("companyCode") String companyCode, @Query("xlinteRid") String xlinteRid, @Query("longitude") String longitude, @Query("latitude") String latitude, @Query("mile") String mile);
//
//    @Headers("Connection: close")
//    @GET("olisServices/inspectRecord/getInspectDis")
//    Observable<AutoSingleResponse<InspectDisModel>> getInspectDis(@Query("companyCode") String companyCode);
//
//    /**
//     * 巡视照片
//     */
//    @Headers("Connection: close")
//    @POST("olisServices/inspectRecord/insertInspectRecord")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<Object>> insertInspectRecord(@FieldMap HashMap<String, Object> map);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getInsDevicePicType")
//    Observable<AutoSingleResponse<InsDevicePicTypeModel>> getInsDevicePicType();
//
//    @Headers("Connection: close")
//    @POST("pmsServices/transmission/tower/addNewDevicePic")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<Object>> addNewDevicePic(@FieldMap HashMap<String, Object> map);
//
//    @Headers("Connection: close")
//    @POST("olisServices/inspectRecord/uploadInspectReShotPic")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<Object>> uploadInspectReShotPic(@FieldMap HashMap<String, Object> map);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getTowers")
//    Observable<AutoSingleResponse<EquipmentSearchBModel>> towerList(@Query("xlinteRid") String xlinteRid, @Query("companyCode") String companyCode, @Query("searchName") String searchName,
//                                                                    @Query("shudianTeam") String shudianTeam, @Query("daiweiTeam") String daiweiTeam);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineStatic")
//    Observable<AutoSingleResponse<LineStaticModel>> getLineStatic(@Query("companyCode") String companyCode, @Query("unitCode") String unitCode, @Query("xlinteRid") String xlinteRid);
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineStatic")
//    Observable<AutoSingleResponse<LineBusinessDetailBean>> getLineBusinessDetail(@Query("xlinteRid") String xlinteRid);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineDir")
//    Observable<AutoSingleResponse<DirectoryBeanModel>> getLineDir(@Query("xlinteRid") String xlinteRid);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineDoc")
//    Observable<AutoSingleResponse<DocModel>> getLineDoc(@Query("xlinteRid") String xlinteRid, @Query("dirCode") String dirCode);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/hiddenTrouble/hiddenTrouble/getHiddenTroubleInspectDetail")
//    Observable<AutoSingleResponse<InspectDetailModel>> getHiddenTroubleInspectDetail(@Query("inspectCode") String inspectCode);
//
//    @Headers("Connection: close")
//    @POST("pmsServices/hiddenTrouble/hiddenTrouble/addHiddenTrouble")
//    @FormUrlEncoded
//    Observable<AutoSingleResponse<Object>> addHiddenTrouble(@FieldMap HashMap<String, Object> map);
//
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLinesByVol")
//    Observable<AutoSingleResponse<PowerLineBean>> getLinesByVol(@Query("voltageLevel") String voltageLevel, @Query("companyCode") String companyCode,
//                                                                @Query("searchName") String searchName);
//
//    @Headers("Connection: close")
//    @GET("system/lineVolList")
//    Observable<AutoSingleResponse<PowerLineBean>> lineVolList();
//
//
//    @Headers("Connection: close")
//    @GET("detection/detectionTaskListAll")
//    Observable<AutoSingleResponse<TaskListModel>> detectionTaskListAll(@Query("taskType") String taskType);
//
//    @Headers("Connection: close")
//    @GET("olisServices/inspectRecord/getInspectRecordDetail")
//    Observable<AutoSingleResponse<NotInPlaceExplainModel>> getInspectRecordDetail(@Query("inspectCode") String inspectCode);
//
//    @Headers("Connection: close")
//    @GET("detection/temperatureRecordMsg")
//    Observable<AutoSingleResponse<InfradDetailModel>> temperatureRecordMsg(@Query("taskCode") String taskCode, @Query("lineId") String lineId, @Query("towerId") String towerId);
//
//    @Headers("Connection: close")
//    @GET("detection/temperaturePhaseMsg")
//    Observable<AutoSingleResponse<InfradDetailModel>> temperaturePhaseMsg(@Query("taskCode") String taskCode, @Query("lineId") String lineId, @Query("towerId") String towerId, @Query("phase") String phase);
//
//    @Headers("Connection: close")
//    @DELETE("detection/deleteDetectionPicture")
//    Observable<AutoSingleResponse<Object>> deleteDetectionPicture(@Query("picCode") String picCode);
//
//    @Headers("Connection: close")
//    @GET("system/deptListByOrg")
//    Observable<AutoSingleResponse<DeptModel>> deptListByOrg();
//
//    @Headers("Connection: close")
//    @GET("detection/temperaturePhaseList")
//    Observable<AutoSingleResponse<InfraraedListBean>> temperaturePhaseList(@Query("lineVol") String lineVol, @Query("lineName") String lineName, @Query("isInspected") String isInspected,
//                                                                           @Query("towerNo") String towerNo, @Query("page") int page, @Query("rows") int rows, @Query("lineId") String lineId,
//                                                                           @Query("isNormal") Integer isNormal, @Query("startDate") String startDate, @Query("endDate") String endDate, @Query("taskCode") String taskCode,
//                                                                           @Query("defectGrade") Integer defectGrade);
//
//
//    /*老旧钢管列表*/
//    @Headers("Connection: close")
//    @GET("detection/steelPipeRecordList")
//    Observable<AutoSingleResponse<SteelPipeBean>> getSteelPipePageList(@QueryMap HashMap<String, Object> parmeMap);
//
//    /*老旧钢管提交*/
//  /*   @Headers("Connection: close")
//    @POST("detection/addSteelPipeRecord")
//   Observable<AutoSingleResponse<SteelPipeBean>> getSteelPipeCommitListApi(@Query("lineVol") String lineVol, @Query("lineId") String lineId, @Query("towerId") String towerId,
//                                                                            @Query("towerNo") String towerNo, @Query("taskCode") String taskCode,
//                                                                            @Query("nonDesDesc") String nonDesDesc, @Query("rustDesc") String rustDesc,
//                                                                            @Query("zineDesc") String zineDesc
//            , @Query("internalCorrState") String internalCorrState, @Query("towerTiltDesc") String towerTiltDesc, @Query("maxDeflection") String maxDeflection
//            , @Query("skewDesc") String skewDesc, @Query("flangeDesc") String flangeDesc, @Query("overallRating") String overallRating, @Query("suggestionDesc") String suggestionDesc);*/
//    /*老旧钢管提交*/
//    @FormUrlEncoded
//    @Headers("Connection: close")
//    @POST("detection/addSteelPipeRecord")
//    Observable<AutoSingleResponse<DeteionCommitBean>> getSteelPipeCommitListApi(@FieldMap HashMap<String, Object> mapParema);
//
//    /*老旧钢管详情*/
//    @Headers("Connection: close")
//    @GET("detection/steelPipeRecordMsg")
//    Observable<AutoSingleResponse<SteelPipeDetailsBean>> getSteelPipeDetailsApi(@Query("recodeCode") String lineVol);
//
//
//    /*X光探伤列表*/
//    @Headers("Connection: close")
//    @GET("detection/xrayRecordList")
//    Observable<AutoSingleResponse<XLightBean>> getXLightPageListApi(@QueryMap HashMap<String, Object> parmeMap);
//
//    /*X光探伤提交*/
//    @FormUrlEncoded
//    @Headers("Connection: close")
//    @POST("detection/addXrayRecord")
//    Observable<AutoSingleResponse<DeteionCommitBean>> getXLightCommitListApi(@FieldMap HashMap<String, Object> mapParema);
//
//    /*光探伤详情*/
//    @Headers("Connection: close")
//    @GET("detection/xrayRecordMsg")
//    Observable<AutoSingleResponse<XLightDetailBean>> getXLightDetailsApi(@Query("recodeCode") String recodeCode);
//
//    /*绝缘子零值列表*/
//    @Headers("Connection: close")
//    @GET("detection/insulatorRecordList")
//    Observable<AutoSingleResponse<InsulatorZeroBean>> getInsulatorPageList(@QueryMap HashMap<String, Object> parmeMap);
//
//    /*绝缘子零值提交*/
//    @FormUrlEncoded
//    @Headers("Connection: close")
//    @POST("detection/addInsulatorRecord")
//    Observable<AutoSingleResponse<DeteionCommitBean>> getInsulatorCommitListApi(@FieldMap HashMap<String, Object> mapParema);
//
//    /*绝缘子零值详情*/
//    @Headers("Connection: close")
//    @GET("detection/insulatorRecordMsg")
//    Observable<AutoSingleResponse<InsulatorZeroDetailsBean>> getInsulatorDetailsApi(@Query("recodeCode") String recodeCode);
//
//    /**
//     * 电缆设备详情 - 头部数目统计
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineDeviceCount")
//    Observable<AutoSingleResponse<List<DeviceCountModel>>> getLineDeviceCount(@Query("sectionCode") String sectionCode, @Query("xlinteRid") String xlinteRid, @Query("deviceName") String deviceName);
//
//    /**
//     * 电缆设备详情分页列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineDevicePageList")
//    Observable<AutoSingleResponse<LineDeviceListModel>> getLineDeviceList(@Query("sectionCode") String sectionCode, @Query("xlinteRid") String xlinteRid, @Query("typeCode") String typeCode,
//                                                                          @Query("deviceName") String deviceName, @Query("page") int page, @Query("rows") int rows);
//
//    /**
//     * 电缆设备详情-台账
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineDeviceMsg")
//    Observable<AutoSingleResponse<LineDeviceMsgModel>> getLineDeviceMsg(@Query("rowId") String rowId);
//
//    /**
//     * 电缆通道分页列表
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineWellPageList")
//    Observable<AutoSingleResponse<LineDeviceListModel>> getLineWellPageList(@Query("sectionCode") String sectionCode, @Query("xlinteRid") String xlinteRid, @Query("page") int page, @Query("rows") int rows, @Query("keywords") String keywords);
//
//    /**
//     * 电缆设备详情-台账
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineWellMsg")
//    Observable<AutoSingleResponse<LineDeviceMsgModel>> getLineWellMsg(@Query("rowId") String rowId);
//
//    /**
//     * 设备线路分布图
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineDeviceDistribute")
//    Observable<AutoSingleResponse<DeviceLnieMapBean>> getDeviceLineMap(@QueryMap() HashMap<String, Object> xlinteRid);
//
//    /**
//     * 线路分布图
//     */
//    @Headers("Connection: close")
//    @GET("pmsServices/transmission/tower/getLineDistribute")
//    Observable<AutoSingleResponse<WellOverhBean>> getWellOverhLineMap(@QueryMap() HashMap<String, Object> xlinteRid);
}
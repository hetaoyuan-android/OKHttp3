package com.mengpeng.okhttpdemo.network;//package com.mengpeng.okhttpdemo.network;
//
//import android.content.Context;
//
//import com.glens.jksd.PowerApplication;
//import com.glens.jksd.base.AutoSingleResponse;
//import com.glens.jksd.bean.AddTower1Model;
//import com.glens.jksd.bean.ClickPhotoModel;
//import com.glens.jksd.bean.CoordsAuthModel;
//import com.glens.jksd.bean.DCRecordAllModel;
//import com.glens.jksd.bean.DcDetailModel;
//import com.glens.jksd.bean.DefectGradeModel;
//import com.glens.jksd.bean.DefectTypeModel;
//import com.glens.jksd.bean.DeptModel;
//import com.glens.jksd.bean.DetectionCountBean;
//import com.glens.jksd.bean.DeviceCountModel;
//import com.glens.jksd.bean.DeviceLnieMapBean;
//import com.glens.jksd.bean.DeviceType2Model;
//import com.glens.jksd.bean.DeviceTypeModel;
//import com.glens.jksd.bean.DirectoryBeanModel;
//import com.glens.jksd.bean.DocModel;
//import com.glens.jksd.bean.DropLineModel;
//import com.glens.jksd.bean.EquipmentInfoModel;
//import com.glens.jksd.bean.EquipmentSearchB;
//import com.glens.jksd.bean.EquipmentSearchBModel;
//import com.glens.jksd.bean.FishingSignModel;
//import com.glens.jksd.bean.FlawManageB;
//import com.glens.jksd.bean.FlawManageBModel;
//import com.glens.jksd.bean.InfraRedBeanModel;
//import com.glens.jksd.bean.InfradDetailModel;
//import com.glens.jksd.bean.InsDevicePicTypeModel;
//import com.glens.jksd.bean.InspectDetailModel;
//import com.glens.jksd.bean.InspectDisModel;
//import com.glens.jksd.bean.LineBusinessDetailBean;
//import com.glens.jksd.bean.LineByTowerAllModel;
//import com.glens.jksd.bean.LineDeviceListModel;
//import com.glens.jksd.bean.LineDeviceMsgModel;
//import com.glens.jksd.bean.LineInspectChildModel;
//import com.glens.jksd.bean.LineInspectModel;
//import com.glens.jksd.bean.LineModel;
//import com.glens.jksd.bean.LineSameTowerModel;
//import com.glens.jksd.bean.LineStaticModel;
//import com.glens.jksd.bean.LoginBean;
//import com.glens.jksd.bean.MainlineAndOtherModel;
//import com.glens.jksd.bean.MyBeanModel;
//import com.glens.jksd.bean.NotInPlaceExplainModel;
//import com.glens.jksd.bean.PartsModel;
//import com.glens.jksd.bean.PartsTypeModel;
//import com.glens.jksd.bean.PicCodeModel;
//import com.glens.jksd.bean.PicModel;
//import com.glens.jksd.bean.PollingListBModel;
//import com.glens.jksd.bean.RemainDefectNumModel;
//import com.glens.jksd.bean.RepairAddTowerCheckBean;
//import com.glens.jksd.bean.RepairBillBean;
//import com.glens.jksd.bean.RepairListBean;
//import com.glens.jksd.bean.RepairTowerDetailBean;
//import com.glens.jksd.bean.RepairTowerListBean;
//import com.glens.jksd.bean.ResistanceBean;
//import com.glens.jksd.bean.RiskDetailsTourBeanModel;
//import com.glens.jksd.bean.RiskManageBModel;
//import com.glens.jksd.bean.RiskTypeModel;
//import com.glens.jksd.bean.SuperintendTypeModel;
//import com.glens.jksd.bean.TaskListModel;
//import com.glens.jksd.bean.TowerModel;
//import com.glens.jksd.bean.TowerPicsModel;
//import com.glens.jksd.bean.TowerUavRecordsModel;
//import com.glens.jksd.bean.TypeModel;
//import com.glens.jksd.bean.UnitModel;
//import com.glens.jksd.bean.UpRepairPhotoBean;
//import com.glens.jksd.bean.VoltageLevelModel;
//import com.glens.jksd.bean.WellOverhBean;
//import com.glens.jksd.bean.WidgetModel;
//import com.glens.jksd.bean.achievement.MineListBean;
//import com.glens.jksd.bean.achievement.MyAchievementHeatMapBean;
//import com.glens.jksd.bean.achievement.TodatWorkMapBean;
//import com.glens.jksd.bean.achievement.TodayWorkBean;
//import com.glens.jksd.bean.achievement.TodayWorkDetailBean;
//import com.glens.jksd.bean.deteect.AddGrounResistanceBean;
//import com.glens.jksd.bean.deteect.DeteionCommitBean;
//import com.glens.jksd.bean.deteect.GroundResistanceDetailBean;
//import com.glens.jksd.bean.deteect.GroundResistanceListBean;
//import com.glens.jksd.bean.deteect.InfraraedListBean;
//import com.glens.jksd.bean.deteect.InfraredDetailBean;
//import com.glens.jksd.bean.deteect.InsulatorZeroBean;
//import com.glens.jksd.bean.deteect.InsulatorZeroDetailsBean;
//import com.glens.jksd.bean.deteect.PayMeasureDetailBean;
//import com.glens.jksd.bean.deteect.PayMeasureListBean;
//import com.glens.jksd.bean.deteect.SteelPipeBean;
//import com.glens.jksd.bean.deteect.SteelPipeDetailsBean;
//import com.glens.jksd.bean.deteect.XLightBean;
//import com.glens.jksd.bean.deteect.XLightDetailBean;
//import com.glens.jksd.bean.face.FaceAcuqisitionBean;
//import com.glens.jksd.bean.power_bean.ControlListBean;
//import com.glens.jksd.bean.power_bean.DefectManageDetailBean;
//import com.glens.jksd.bean.power_bean.DutyOnLineBean;
//import com.glens.jksd.bean.power_bean.DutyTaskBean;
//import com.glens.jksd.bean.power_bean.HiddenAuditDetailBean;
//import com.glens.jksd.bean.power_bean.HiddenBadDutyBean;
//import com.glens.jksd.bean.power_bean.HiddenCheckListBean;
//import com.glens.jksd.bean.power_bean.HiddenControlBean;
//import com.glens.jksd.bean.power_bean.HiddenControlDetailBean;
//import com.glens.jksd.bean.power_bean.HiddenDefectBean;
//import com.glens.jksd.bean.power_bean.HiddenDetailBean;
//import com.glens.jksd.bean.power_bean.HiddenFlowStateBean;
//import com.glens.jksd.bean.power_bean.HiddenLinePointBean;
//import com.glens.jksd.bean.power_bean.HiddenOneDutyBean;
//import com.glens.jksd.bean.power_bean.HiddenPersonBean;
//import com.glens.jksd.bean.power_bean.HiddenTaskBean;
//import com.glens.jksd.bean.power_bean.HiddenTaskDetailBean;
//import com.glens.jksd.bean.power_bean.HiddenTaskPageBean;
//import com.glens.jksd.bean.power_bean.HiddenTaskUpListBean;
//import com.glens.jksd.bean.power_bean.HiddenTroubleListBean;
//import com.glens.jksd.bean.power_bean.HiddenTypeBean;
//import com.glens.jksd.bean.power_bean.HidenAnswerBean;
//import com.glens.jksd.bean.power_bean.LoginDynamicBean;
//import com.glens.jksd.bean.power_bean.PagerDefectBean;
//import com.glens.jksd.bean.power_bean.PowerDefectLevelBean;
//import com.glens.jksd.bean.power_bean.PowerLineBean;
//import com.glens.jksd.bean.power_bean.PowerUnitsBean;
//import com.glens.jksd.bean.power_bean.SuperviseBean;
//import com.glens.jksd.bean.power_bean.WatchHiddenDetailbean;
//import com.glens.jksd.bean.power_bean.WatchHiddenRecordBean;
//import com.glens.jksd.bean.project_bean.AddProjectBean;
//import com.glens.jksd.bean.project_bean.ProjectListBean;
//import com.glens.jksd.bean.project_bean.ProjectListDetailBean;
//import com.glens.jksd.bean.repair_bean.DefectDetailBean;
//import com.glens.jksd.bean.repair_bean.EquipmentBean;
import android.content.Context;

import com.mengpeng.okhttpdemo.bean.UserInfoBean;
import com.mengpeng.okhttpdemo.network.RetrofitApiService;
import com.mengpeng.okhttpdemo.network.RetrofitUtil;
import com.mengpeng.okhttpdemo.network.UserInfo;

import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * 该类用来管理RetrofitApiService中对应的各种API接口，
 * 当做Retrofit和presenter中的桥梁，Activity就不用直接和retrofit打交道了
 */
public class DataManager {
    private RetrofitApiService mRetrofitService;
    private volatile static DataManager instance;

    private DataManager(Context context) {
        this.mRetrofitService = RetrofitUtil.getInstance(context).getRetrofitApiService();
    }

    //由于该对象会被频繁调用，采用单例模式，下面是一种线程安全模式的单例写法
    public static DataManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager(context);
                }
            }
        }
        return instance;
    }

//    public static void setInstance(Context context) {
//        instance = new DataManager(context);
//    }


    //将retrofit的业务方法映射到DataManager中，以后统一用该类来调用业务方法
    public Observable<UserInfo> getUserInfo(int uid) {
        return mRetrofitService.getUserInfo(uid);
    }

    public Observable<UserInfoBean> getUserInfo() {
        return mRetrofitService.getUserInfo();
    }
//
//    /**
//     * 人脸识别登录
//     */
//    public Observable<AutoSingleResponse<LoginBean>> faceLogin(String userCode, String userName, String imei) {
//        return mRetrofitService.faceLogin(userCode, userName, imei);
//    }
//
//    /**
//     * 人脸图像上传
//     */
//    public Observable<AutoSingleResponse> uploadFaceImg(String userCode, String lib) {
//        return mRetrofitService.uploadFaceImg(userCode, lib);
//    }
//
//    /**
//     * 人像采集删除 deleteFaceImg
//     */
//    public Observable<AutoSingleResponse> deleteFaceImg(String userCode) {
//        return mRetrofitService.deleteFaceImg(userCode);
//    }
//
//    /**
//     * 人脸采集faceAcquisition
//     */
//    public Observable<AutoSingleResponse<FaceAcuqisitionBean>> faceAcquisition(String cj, String lib) {
//        return mRetrofitService.faceAcquisition(cj, lib);
//    }
//
//    /**
//     * 检修列表
//     *
//     * @param taskName 选填
//     * @param taskTime 选填
//     * @param taskType 选填 0:全部 1：电阻 2：测温 3：测量
//     * @param page     页数 必填
//     * @param rows     条数 必填
//     */
//    public Observable<AutoSingleResponse<ResistanceBean>> detectionList(String taskName, String taskTime, String endTime, int taskType, int page, int rows) {
//        return mRetrofitService.detectionList(taskName, taskTime, endTime, taskType, page, rows);
//    }
//
//    /**
//     * 检测列表底部数量
//     *
//     * @param taskName 选填
//     * @param taskTime 选填
//     * @param taskType 选填
//     */
//    public Observable<AutoSingleResponse<DetectionCountBean>> detectionCount(String taskName, String taskTime, int taskType) {
//        return mRetrofitService.detectionCountList(taskName, taskTime, taskType);
//    }
//
//    /**
//     * 接地电阻列表页
//     *
//     * @param lineVol
//     * @param lineName
//     * @param isInspected
//     * @param towerNo
//     * @param page        必填
//     * @param rows        必填
//     * @param taskCode    必填
//     */
//    public Observable<AutoSingleResponse<GroundResistanceListBean>> getGroundResistanceList(String lineVol, String lineName, String isInspected, String towerNo, int page, int rows, String taskCode, String lineId, String startDate, String endDate) {
//        return mRetrofitService.getGroundResistanceList(lineVol, lineName, isInspected, towerNo, page, rows, taskCode, lineId, startDate, endDate);
//    }
//
//    /**
//     * 老旧钢管列表页
//     */
//    public Observable<AutoSingleResponse<SteelPipeBean>> getSteelPipeMangerList(HashMap<String, Object> parmeMap) {
//        return mRetrofitService.getSteelPipePageList(parmeMap);
//    }
//
//    /**
//     * 老旧钢管新增详情
//     */
//    public Observable<AutoSingleResponse<DeteionCommitBean>> getSteelPipeAddManageList(HashMap<String, Object> mapParema) {
//        return mRetrofitService.getSteelPipeCommitListApi(mapParema);
//    }
//
//    /**
//     * 老旧钢管详情
//     */
//    public Observable<AutoSingleResponse<SteelPipeDetailsBean>> getSteelPipeDetailsManageList(String recodeCode) {
//        return mRetrofitService.getSteelPipeDetailsApi(recodeCode);
//    }
//
//    /**
//     * X光探伤列表页面
//     */
//    public Observable<AutoSingleResponse<XLightBean>> getXLightMangerList(HashMap<String, Object> parmeMap) {
//        return mRetrofitService.getXLightPageListApi(parmeMap);
//    }
//
//    /**
//     * X光探伤新增详情
//     */
//    public Observable<AutoSingleResponse<DeteionCommitBean>> getXlightCommitManageList(HashMap<String, Object> mapParema) {
//        return mRetrofitService.getXLightCommitListApi(mapParema);
//    }
//
//    /**
//     * X光探伤详情
//     */
//    public Observable<AutoSingleResponse<XLightDetailBean>> getXlightDetailsManageList(String recodeCode) {
//        return mRetrofitService.getXLightDetailsApi(recodeCode);
//    }
//
//    /**
//     * 绝缘子零值列表页
//     */
//    public Observable<AutoSingleResponse<InsulatorZeroBean>> getInsulatorPageList(HashMap<String, Object> parmeMap) {
//        return mRetrofitService.getInsulatorPageList(parmeMap);
//    }
//
//    /**
//     * 绝缘子零值新增详情
//     */
//    public Observable<AutoSingleResponse<DeteionCommitBean>> getInsulatorCommitManageList(HashMap<String, Object> mapParema) {
//        return mRetrofitService.getInsulatorCommitListApi(mapParema);
//    }
//
//    /**
//     * 绝缘子零值详情
//     */
//    public Observable<AutoSingleResponse<InsulatorZeroDetailsBean>> getInsulatorDetailsManageList(String recodeCode) {
//        return mRetrofitService.getInsulatorDetailsApi(recodeCode);
//    }
//
//    /**
//     * 退出登录
//     */
//
//    public Observable<Logout> logout() {
//        return mRetrofitService.logout();
//    }
//
//    /**
//     * 签到
//     *
//     * @param map
//     * @return
//     */
//    public Observable<SignBean> checkIn(HashMap<String, Object> map) {
//        return mRetrofitService.checkIn(map);
//    }
//
//    /**
//     * 签退
//     */
//    public Observable<SignBean> checkOut(HashMap<String, Object> map) {
//        return mRetrofitService.checkout(map);
//    }
//
//    /**
//     * 轨迹
//     */
//    public Observable<SignBean> uploadGps(HashMap<String, Object> map) {
//        return mRetrofitService.uploadGps(map);
//    }
//
//    /**
//     * 值守轨迹
//     */
//    public Observable<SignBean> alarmDutyUser(HashMap<String, Object> map) {
//        return mRetrofitService.alarmDutyUser(map);
//    }
//
//    /**
//     * 检查新版本
//     */
//    public Observable<AutoSingleResponse<SelectVersionBean>> inspectVersion() {
//        return mRetrofitService.inspectVersion();
//    }
//
//    /**
//     * 扫一扫详情getLinesByGt
//     */
//    public Observable<AutoSingleResponse<LineByTowerAllModel>> getLinesByGt(String inteRid) {
//        return mRetrofitService.getLinesByGt(inteRid);
//    }
//
//    /**
//     * 新功能介绍 newFunction
//     */
//    public Observable<AutoSingleResponse<NewFunctionBean>> newFunction() {
//        return mRetrofitService.newFunction();
//    }
//
//    /**
//     * 服务协议
//     */
//    public Observable<AutoSingleResponse<NewFunctionBean>> serviceAgreement() {
//        return mRetrofitService.serviceAgreement();
//    }
//
//    /**
//     * 隐私政策 privacyPolicy
//     */
//    public Observable<AutoSingleResponse<NewFunctionBean>> privacyPolicy() {
//        return mRetrofitService.privacyPolicy();
//    }
//
//    /**
//     * 今日工作 list
//     */
//    public Observable<AutoSingleResponse<TodayWorkBean>> todayWorkList(String queryDate, String userCode) {
//        return mRetrofitService.todayWorkList(queryDate, userCode);
//    }
//
//    /**
//     * 今日工作 map
//     */
//    public Observable<AutoSingleResponse<TodatWorkMapBean>> todayWorkMap(String queryDate, String userCode) {
//        return mRetrofitService.todayWorkMap(queryDate, userCode);
//    }
//
//    /**
//     * 杆塔巡视 patrolDetail
//     */
//    public Observable<AutoSingleResponse<TodayWorkDetailBean>> patrolDetail(String queryDate, String xlinteRid) {
//        return mRetrofitService.patrolDetail(queryDate, xlinteRid);
//    }
//
//    /**
//     * 我的成就list
//     */
//    public Observable<AutoSingleResponse<TodayWorkBean>> myAchievement(String startDate, String endDate) {
//        return mRetrofitService.myAchievement(startDate, endDate);
//    }
//
//    /**
//     * 我的成就热力图 myAchievementHeatMap
//     */
//    public Observable<AutoSingleResponse<MyAchievementHeatMapBean>> myAchievementHeatMap(String startDate, String endDate) {
//        return mRetrofitService.myAchievementHeatMap(startDate, endDate);
//    }
//
//    /**
//     * 接地电阻详情列表页
//     */
//    public Observable<AutoSingleResponse<GroundResistanceDetailBean>> getGroundResistanceDetailList(String recodeCode) {
//        return mRetrofitService.getGroundResistanceDetailList(recodeCode);
//    }
//
//    /**
//     * 新增接地电阻
//     */
//    public Observable<AutoSingleResponse<AddGrounResistanceBean>> addGroundResistance(HashMap<String, Object> map) {
//        return mRetrofitService.addGroundResistance(map);
//    }
//
//    /**
//     * 新增接地电阻
//     */
//    public Observable<AutoSingleResponse<AddGrounResistanceBean>> addSoundRecord(HashMap<String, Object> map) {
//        return mRetrofitService.addSoundRecord(map);
//    }
//
//    /**
//     * 新增检修资料
//     */
//    public Observable<AutoSingleResponse<AddGrounResistanceBean>> addInformationRecord(HashMap<String, Object> map) {
//        return mRetrofitService.addInformationRecord(map);
//    }
//
//    /**
//     * 新增接地电阻带上传图片
//     */
//    public Observable<AutoSingleResponse<AddGrounResistanceBean>> addGroundResistanceAndImage(HashMap<String, Object> map, RequestBody file) {
//        return mRetrofitService.addGroundResistanceAndImage(map, file);
//    }
//
//
//    /**
//     * 红外测温列表
//     *
//     * @param taskCode 必填
//     * @param page     必填
//     * @param rows     必填
//     */
//    public Observable<AutoSingleResponse<InfraraedListBean>> getInfraredList(String lineVol, String lineName, String isInspected, String towerNo, int page, int rows, String taskCode) {
//        return mRetrofitService.getInfraredList(lineVol, lineName, isInspected, towerNo, page, rows, taskCode);
//    }
//
//    /**
//     * 红外测温列表
//     *
//     * @param taskCode 必填
//     * @param page     必填
//     * @param rows     必填
//     */
//    public Observable<AutoSingleResponse<InfraraedListBean>> temperaturePhaseList(String lineVol, String lineName, String isInspected, String towerNo, int page, int rows, String taskCode, Integer isNormal, String startDate, String endDate, String lineId, Integer defectGrade) {
//        return mRetrofitService.temperaturePhaseList(lineVol, lineName, isInspected, towerNo, page, rows, taskCode, isNormal, startDate, endDate, lineId, defectGrade);
//    }
//
//    /**
//     * 红外测温详情页
//     */
//    public Observable<AutoSingleResponse<InfraredDetailBean>> getInfraredDetailList(String recodeCode) {
//        return mRetrofitService.getInfraredDetailList(recodeCode);
//    }
//
//    /**
//     * 新增红外测温
//     */
//    public Observable<AutoSingleResponse<AddGrounResistanceBean>> addInfrared(HashMap<String, Object> map) {
//        return mRetrofitService.addInfrared(map);
//    }
//
//
//    /**
//     * 交跨测量主页
//     */
//    public Observable<AutoSingleResponse<PayMeasureListBean>> getPayMeasureList(String lineVol, String lineName, String isInspected, Integer crossType, String exeUnitId, String startTowerNo, String endTowerNo, String taskCode, int page, int rows, String lineId) {
//        return mRetrofitService.getPayMeasureList(lineVol, lineName, isInspected, crossType, exeUnitId, startTowerNo, endTowerNo, taskCode, page, rows, lineId);
//    }
//
//    /**
//     * 交跨测量详情页
//     */
//    public Observable<AutoSingleResponse<PayMeasureDetailBean>> getPayMeasureDetailList(String recodeCode) {
//        return mRetrofitService.getPayMeasureDetailList(recodeCode);
//    }
//
//    /**
//     * 新增交跨测量
//     */
//    public Observable<AutoSingleResponse<AddGrounResistanceBean>> addPayMeasure(HashMap<String, Object> map) {
//        return mRetrofitService.addPayMeasure(map);
//    }
//
//    /**
//     * 我的动态配置queryMineModleList
//     */
//    public Observable<AutoSingleResponse<MineListBean>> queryMineModleList(String lappCode) {
//        return mRetrofitService.queryMineModleList(lappCode);
//    }
//
//
//    /**
//     * 检测上传照片
//     *
//     * @param file    必填
//     * @param picType 必填
//     * @param remarks 必填
//     */
//    public Observable<ResponseBody> uploadImageOffLone(String file, String recodeCode, String taskCode, String picType, String remarks) {
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        return mRetrofitService.uploadImageOffLone(requestFile, recodeCode, taskCode, picType, remarks);
//    }
//
//    /**
//     * 检修列表
//     * String taskName,String startDate,String endDate,
//     * int overhaulType, @Query("createDeptId") String createDeptId, @Query("page") int page,
//     * int rows, String taskContent, int isPowerCut,String powerOutage)
//     */
//    public Observable<AutoSingleResponse<RepairListBean>> checkList(String taskName, String startDate, String endDate, int overhaulType, String createDeptId, int page, int rows) {
//        return mRetrofitService.checkList(taskName, startDate, endDate, overhaulType, createDeptId, page, rows);
//    }
//
//    public Observable<AutoSingleResponse<DeptModel>> deptListByOrg() {
//        return mRetrofitService.deptListByOrg();
//    }
//
//    public Observable<AutoSingleResponse<ProjectListBean>> projectManageList(String projectName, String startDate, String endDate, int projectType, int page, int rows) {
//        return mRetrofitService.projectManageList(projectName, startDate, endDate, projectType, page, rows);
//    }
//
//
//    public Observable<AutoSingleResponse<RepairBillBean>> repairBill(String taskCode) {
//        return mRetrofitService.repairBill(taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairBillBean>> siteLogList(String projectCode) {
//        return mRetrofitService.siteLogList(projectCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTowerListBean>> repairTower(String startDate, String endDate, String taskCode) {
//        return mRetrofitService.repairTower(startDate, endDate, taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTowerListBean>> repairTaskList(String startDate, String endDate, String taskCode) {
//        return mRetrofitService.repairTaskList(startDate, endDate, taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTowerListBean>> insulatorClearList(String startDate, String endDate, String taskCode) {
//        return mRetrofitService.insulatorClearList(startDate, endDate, taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTowerListBean>> traceCheckList(String startDate, String endDate, String taskCode) {
//        return mRetrofitService.traceCheckList(startDate, endDate, taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTowerListBean>> rtvSprayList(String startDate, String endDate, String taskCode) {
//        return mRetrofitService.rtvSprayList(startDate, endDate, taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTowerListBean>> hydrophobicTestList(String startDate, String endDate, String taskCode) {
//        return mRetrofitService.hydrophobicTestList(startDate, endDate, taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTowerListBean>> siteSurveyList(String taskCode) {
//        return mRetrofitService.siteSurveyList(taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTowerListBean>> soundList(String taskCode) {
//        return mRetrofitService.soundList(taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairInformationBean>> informationList(String taskCode) {
//        return mRetrofitService.informationList(taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairGroundBean>> groundList(String taskCode) {
//        return mRetrofitService.groundList(taskCode);
//    }
//
//    public Observable<AutoSingleResponse<EquipmentBean>> equipmentList(String taskCode, int selectType) {
//        return mRetrofitService.equipmentList(taskCode, selectType);
//    }
//
//
//    public Observable<AutoSingleResponse<RepairTowerDetailBean>> repairTowerDetail(String checkRecordCode) {
//        return mRetrofitService.repairTowerDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<DefectDetailBean>> repairTaskDetail(String checkRecordCode) {
//        return mRetrofitService.repairTaskDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<InsulatorDetailBean>> insulatorDetail(String checkRecordCode) {
//        return mRetrofitService.insulatorDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<ProjectListDetailBean>> projectManageDetail(String projectCode) {
//        return mRetrofitService.projectManageDetail(projectCode);
//    }
//
//    public Observable<AutoSingleResponse<InformationDetailBean>> informationDetail(String checkRecordCode) {
//        return mRetrofitService.informationDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<GroundDetailBean>> groundrDetail(String checkRecordCode) {
//        return mRetrofitService.groundrDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<LineCheckBean>> traceCheckDetail(String checkRecordCode) {
//        return mRetrofitService.traceCheckDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<RtvSprayDetailBean>> sprayDetail(String checkRecordCode) {
//        return mRetrofitService.sprayDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<WaterTestDetailBean>> waterTestDetail(String checkRecordCode) {
//        return mRetrofitService.waterTestDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<RepairTaskDetailBean>> siteSurveyDetail(String checkRecordCode) {
//        return mRetrofitService.siteSurveyDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<RecordDetailBean>> repairSoundDetail(String checkRecordCode) {
//        return mRetrofitService.repairSoundDetail(checkRecordCode);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upTowerPhoto(RequestBody file, String taskCode, int picType, String remarks) {
//        return mRetrofitService.upTowerPhoto(file, taskCode, picType, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upInformationPhoto(RequestBody file, String taskCode, int picType, String remarks) {
//        return mRetrofitService.upInformationPhoto(file, taskCode, picType, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upSoundAudio(RequestBody file, String taskCode, String remarks) {
//        return mRetrofitService.upSoundAudio(file, taskCode, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upInformationAudio(RequestBody file, String taskCode, String remarks) {
//        return mRetrofitService.upInformationAudio(file, taskCode, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upInsulatorPhoto(RequestBody file, String taskCode, int picType, String remarks) {
//        return mRetrofitService.upInsulatorPhoto(file, taskCode, picType, remarks);
//    }
//
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upSprayPhoto(RequestBody file, String taskCode, int picType, String remarks) {
//        return mRetrofitService.upSprayPhoto(file, taskCode, picType, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upGroundPhoto(RequestBody file, String taskCode, String picType, String remarks) {
//        return mRetrofitService.upGroundPhoto(file, taskCode, picType, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upWaterTestPhoto(RequestBody file, String taskCode, String remarks) {
//        return mRetrofitService.upWaterTestPhoto(file, taskCode, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upSiteSurveyPhoto(RequestBody file, String taskCode, String remarks) {
//        return mRetrofitService.upSiteSurveyPhoto(file, taskCode, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upLineCheckPhoto(RequestBody file, String taskCode, String remarks) {
//        return mRetrofitService.upLineCheckPhoto(file, taskCode, remarks);
//    }
//
//    public Observable<AutoSingleResponse<UpRepairPhotoBean>> upWorkRecordPhoto(RequestBody file, String taskCode, String remarks) {
//        return mRetrofitService.upWorkRecordPhoto(file, taskCode, remarks);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteTowerPhoto(String picCode) {
//        return mRetrofitService.deleteTowerPhoto(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteRtvSprayPicture(String picCode) {
//        return mRetrofitService.deleteRtvSprayPicture(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteSiteSurveyPicture(String picCode) {
//        return mRetrofitService.deleteSiteSurveyPicture(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteHydrophobicTestPicture(String picCode) {
//        return mRetrofitService.deleteHydrophobicTestPicture(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteInsulatorClearPicture(String picCode) {
//        return mRetrofitService.deleteInsulatorClearPicture(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteTraceCheckPicture(String picCode) {
//        return mRetrofitService.deleteTraceCheckPicture(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteLineCheckPhoto(String picCode) {
//        return mRetrofitService.deleteLineCheckPhoto(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteWaterTestPhoto(String picCode) {
//        return mRetrofitService.deleteWaterTestPhoto(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteSoundPicture(String picCode) {
//        return mRetrofitService.deleteSoundPicture(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteInformationPicture(String picCode) {
//        return mRetrofitService.deleteInformationPicture(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteSound(String audioCode) {
//        return mRetrofitService.deleteSound(audioCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteInformationSound(String audioCode) {
//        return mRetrofitService.deleteInformationSound(audioCode);
//    }
//
//
//    public Observable<AutoSingleResponse<Object>> deleteSprayPhoto(String picCode) {
//        return mRetrofitService.deleteSprayPhoto(picCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteSitePhoto(String picCode) {
//        return mRetrofitService.deleteSitePhoto(picCode);
//    }
//
//
//    public Observable<AutoSingleResponse<Object>> deleteGroundPhoto(String picCode) {
//        return mRetrofitService.deleteGroundPhoto(picCode);
//    }
//
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addTowerCheck(HashMap<String, Object> map) {
//        return mRetrofitService.addTowerCheck(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addLineCheck(HashMap<String, Object> map) {
//        return mRetrofitService.addLineCheck(map);
//    }
//
//    public Observable<AutoSingleResponse<AddProjectBean>> addProjectManage(HashMap<String, Object> map) {
//        return mRetrofitService.addProjectManage(map);
//    }
//
//    public Observable<AutoSingleResponse<AddProjectBean>> addSiteLog(HashMap<String, Object> map) {
//        return mRetrofitService.addSiteLog(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addWaterTest(HashMap<String, Object> map) {
//        return mRetrofitService.addWaterTest(map);
//    }
//
//    public Observable<AutoSingleResponse<TowerBean>> lineCheckList(String taskCode, int selectType, String lineId) {
//        return mRetrofitService.lineCheckList(taskCode, selectType, lineId);
//    }
//
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addInsulatorClear(HashMap<String, Object> map) {
//        return mRetrofitService.addInsulatorClear(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addSiteSurvey(HashMap<String, Object> map) {
//        return mRetrofitService.addSiteSurvey(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateGroundCheck(HashMap<String, Object> map) {
//        return mRetrofitService.updateGroundCheck(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addGroundMout(HashMap<String, Object> map) {
//        return mRetrofitService.addGroundMout(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addSpray(HashMap<String, Object> map) {
//        return mRetrofitService.addSpray(map);
//    }
//
//    public Observable<ResponseBody> test(HashMap<String, String> map) {
//        return mRetrofitService.test();
//    }
//
//    public Observable<AutoSingleResponse<LineInspectModel>> lineInspectionList(String companyCode, String unitCode, String sdTeamCode, String dwTeamCode) {
//        return mRetrofitService.lineInspectionList(companyCode, unitCode, sdTeamCode, dwTeamCode);
//    }
//
//    public Observable<AutoSingleResponse<List<DeviceCountModel>>> getLineDeviceCount(String sectionCode, String xlinteRid, String deviceName) {
//        return mRetrofitService.getLineDeviceCount(sectionCode, xlinteRid, deviceName);
//    }
//
//    public Observable<AutoSingleResponse<LineDeviceListModel>> getLineDeviceList(String sectionCode, String xlinteRid, String typeCode, String deviceName, int page, int rows) {
//        return mRetrofitService.getLineDeviceList(sectionCode, xlinteRid, typeCode, deviceName, page, rows);
//    }
//
//    public Observable<AutoSingleResponse<LineDeviceListModel>> getLineWellPageList(String sectionCode, String xlinteRid, int page, int rows, String keywords) {
//        return mRetrofitService.getLineWellPageList(sectionCode, xlinteRid, page, rows, keywords);
//    }
//
//    public Observable<AutoSingleResponse<LineDeviceMsgModel>> getLineDeviceMsg(String rowId) {
//        return mRetrofitService.getLineDeviceMsg(rowId);
//    }
//
//    public Observable<AutoSingleResponse<LineDeviceMsgModel>> getLineWellMsg(String rowId) {
//        return mRetrofitService.getLineWellMsg(rowId);
//    }
//
//    public Observable<AutoSingleResponse<DeviceLnieMapBean>> getDeviceLineMap(HashMap<String, Object> rowId) {
//        return mRetrofitService.getDeviceLineMap(rowId);
//    }public Observable<AutoSingleResponse<WellOverhBean>> getWellOverhLineMap(HashMap<String, Object> rowId) {
//        return mRetrofitService.getWellOverhLineMap(rowId);
//    }
//
//    public Observable<AutoSingleResponse<LineModel>> getLines(String voltageLevel, String companyCode, String unitCode, String sdTeamCode, String dwTeamCode, String xlinteRid) {
//        return mRetrofitService.getLines(voltageLevel, companyCode, unitCode, sdTeamCode, dwTeamCode, xlinteRid);
//    }
//
//    public Observable<AutoSingleResponse<LineInspectModel>> getVoltageLevelPatrol(String companyCode, String unitCode, String sdTeamCode, String dwTeamCode) {
//        return mRetrofitService.getVoltageLevelPatrol(companyCode, unitCode, sdTeamCode, dwTeamCode);
//    }
//
//    public Observable<AutoSingleResponse<LineInspectChildModel>> lineInspectionChildList(String xlinteRid, String companyCode, String unitCode) {
//        return mRetrofitService.lineInspectionChildList(xlinteRid, companyCode, unitCode);
//    }
//
//    public Observable<AutoSingleResponse<TowerModel>> towerList(String xlinteRid, String searchName, String companyCode) {
//        return mRetrofitService.towerList(xlinteRid, searchName, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<ClickPhotoModel>> infoPagesList(String inteRid, String companyCode, String fromDate, String toDate, int currentPage) {
//        return mRetrofitService.infoPages(inteRid, companyCode, fromDate, toDate, currentPage);
//    }
//
//    public Observable<AutoSingleResponse<Object>> addPtiInformation(HashMap map) {
//        return mRetrofitService.addPtiInformation(map);
//    }
//
//    public Observable<AutoSingleResponse<Object>> insertHiddenTrouble(List<MultipartBody.Part> requestBodyMap) {
//        return mRetrofitService.insertHiddenTrouble(requestBodyMap);
//    }
//
//    public Observable<AutoSingleResponse<VoltageLevelModel>> getVoltageList(String companyCode) {
//        return mRetrofitService.getVoltageList(companyCode);
//    }
//
//
//    public Observable<AutoSingleResponse<EquipmentSearchBModel>> getGH(String voltageLevel, String xlinteRid, String unitCode) {
//        String taskCode = PowerApplication.taskCode;
//        if (taskCode == null) taskCode = "";
//        return mRetrofitService.getGh(voltageLevel, xlinteRid, unitCode, taskCode);
//    }
//
//    public Observable<AutoSingleResponse<RiskTypeModel>> getTroubleList() {
//        return mRetrofitService.getTroubleList();
//    }
//
//    public Observable<AutoSingleResponse<AddTower1Model>> addTower(HashMap map) {
//        return mRetrofitService.addTower(map);
//    }
//
//
//    public Observable<AutoSingleResponse<Object>> addDC(List<MultipartBody.Part> requestBodyMap) {
//        return mRetrofitService.addDC(requestBodyMap);
//    }
//
//    public Observable<AutoSingleResponse<DcDetailModel>> getDcDetail(String superintendCode) {
//        return mRetrofitService.getDcDetail(superintendCode);
//    }
//
//    public Observable<AutoSingleResponse<DeviceTypeModel>> getDeviceType() {
//        return mRetrofitService.getDeviceType();
//    }
//
//    public Observable<AutoSingleResponse<PartsModel>> getDeviceParts(String deviceTypeCode) {
//        return mRetrofitService.getDeviceParts(deviceTypeCode);
//    }
//
//    public Observable<AutoSingleResponse<PartsTypeModel>> getDevicePartsType(String deviceTypeCode) {
//        return mRetrofitService.getDevicePartsType(deviceTypeCode);
//    }
//
//    public Observable<AutoSingleResponse<WidgetModel>> getDeviceWidget(String partsTypeCode) {
//        return mRetrofitService.getDeviceWidget(partsTypeCode);
//    }
//
//    public Observable<AutoSingleResponse<DefectTypeModel>> getDefectType1(String widgetCode) {
//        return mRetrofitService.getDefectType1(widgetCode);
//    }
//
//    public Observable<AutoSingleResponse<FishingSignModel>> queryFishingSign(String lineId, String startTowerId, String endTowerId) {
//        return mRetrofitService.queryFishingSign(lineId, startTowerId, endTowerId, "4");
//    }
//
//    public Observable<AutoSingleResponse<DeviceType2Model>> getDefectType2(String defectContent) {
//        return mRetrofitService.getDefectType2(defectContent);
//    }
//
//    public Observable<AutoSingleResponse<DefectGradeModel>> getGrade(String companyCode) {
//        return mRetrofitService.getGrade(companyCode);
//    }
//
//    public Observable<AutoSingleResponse<ControlListBean>> getControlOperationList(String hiddenTroubleCode) {
//        return mRetrofitService.getControlOperationList(hiddenTroubleCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenFlowStateBean>> getProcessNodeHasHandle(String hiddenTroubleCode) {
//        return mRetrofitService.getProcessNodeHasHandle(hiddenTroubleCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenFlowStateBean>> getDutyProcessNodeHasHandle(String hiddenTroubleCode) {
//        return mRetrofitService.getDutyProcessNodeHasHandle(hiddenTroubleCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> updateDefect(HashMap map) {
//        return mRetrofitService.updateDefect(map);
//    }
//
//    public Observable<AutoSingleResponse<UnitModel>> getDwTeam(String unitCode, String companyCode) {
//        return mRetrofitService.getDwTeam(unitCode, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<UnitModel>> getSdTeam(String unitCode, String companyCode) {
//        return mRetrofitService.getSdTeam(unitCode, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenAuditDetailBean>> getProcessRecordDetailList(String processCode, String nodeOrder) {
//        return mRetrofitService.getProcessRecordDetailList(processCode, nodeOrder);
//    }
//
//    public Observable<AutoSingleResponse<HiddenAuditDetailBean>> getDutyProcessRecordDetailList(String processCode, String nodeOrder) {
//        return mRetrofitService.getDutyProcessRecordDetailList(processCode, nodeOrder);
//    }
//
//    public Observable<AutoSingleResponse<LineInspectChildModel>> getBranchList(String xlinteRid, String companyCode, String unitCode, String shudianTeam, String daiweiTeam) {
//        return mRetrofitService.getBranchList(xlinteRid, companyCode, unitCode, shudianTeam, daiweiTeam);
//    }
//
//    public Observable<AutoSingleResponse<DropLineModel>> getdropdownLinesBySearchName(String searchName, String companyCode) {
//        return mRetrofitService.getdropdownLinesBySearchName(searchName, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<EquipmentSearchB>> getTowersDetail(String inteRid, String xlinteRid, String companyCode) {
//        return mRetrofitService.getTowersDetail(inteRid, xlinteRid, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<CoordsAuthModel>> getCoordsAuth(String companyCode, String inspectMan) {
//        return mRetrofitService.getCoordsAuth(companyCode, inspectMan);
//    }
//
//    public Observable<AutoSingleResponse<PicModel>> getTowerPicList(String inteRid, String companyCode) {
//        return mRetrofitService.getTowerPicList(inteRid, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<MainlineAndOtherModel>> getMainlineAndOther(String xlinteRid, String companyCode, String unitCode) {
//        return mRetrofitService.getMainlineAndOther(xlinteRid, companyCode, unitCode);
//    }
//
//    public Observable<AutoSingleResponse<LineSameTowerModel>> getLineSameTower(String xlinteRid) {
//        return mRetrofitService.getLineSameTower(xlinteRid);
//    }
//
//    public Observable<AutoSingleResponse<PicCodeModel>> getInpectRecordPicByInspectCode(String inspectCode, String companyCode) {
//        return mRetrofitService.getInpectRecordPicByInspectCode(inspectCode, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<PollingListBModel>> getInpectRecordByInterIdNj(String inteRid, String inspectType, String fromDate, String toDate, String companyCode, String xlinteRid) {
//        return mRetrofitService.getInpectRecordByInterIdNj(inteRid, inspectType, fromDate, toDate, companyCode, xlinteRid);
//    }
//
//    public Observable<AutoSingleResponse<FlawManageBModel>> getDefectByInterid(String inteRid, String state, String companyCode) {
//        return mRetrofitService.getDefectByInterid(inteRid, state, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<RiskManageBModel>> getHiddenTroubleList(String xlinteRid, String inteRid, String companyCode, String hiddenTroubleLevel, String isWatch, String startTime, String endTime, String orderBy) {
//        return mRetrofitService.getHiddenTroubleList(xlinteRid, inteRid, companyCode, hiddenTroubleLevel, isWatch, startTime, endTime, orderBy);
//    }
//
//    public Observable<AutoSingleResponse<InfraRedBeanModel>> getInfraPics(String xlinteRid, String inteRid, String fromDate, String toDate, String typeCode) {
//        return mRetrofitService.getInfraPics(xlinteRid, inteRid, fromDate, toDate, typeCode);
//    }
//
//    public Observable<AutoSingleResponse<TypeModel>> getInfraPicsType() {
//        return mRetrofitService.getInfraPicsType();
//    }
//
//    public Observable<AutoSingleResponse<RemainDefectNumModel>> getRemainDefect(String xlinteRid, String inteRid) {
//        return mRetrofitService.getRemainDefect(xlinteRid, inteRid);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteDevicePic(HashMap map) {
//        return mRetrofitService.deleteDevicePic(map);
//    }
//
//    public Observable<AutoSingleResponse<MyBeanModel>> getchannelVisualization(String startDate, String lineId, String gh, String companyCode, String ptype, String inteRid) {
//        return mRetrofitService.getchannelVisualization(startDate, lineId, gh, companyCode, ptype, inteRid);
//    }
//
//    public Observable<AutoSingleResponse<TowerUavRecordsModel>> getTowerUavRecords(String companyCode) {
//        return mRetrofitService.getTowerUavRecords(companyCode);
//    }
//
//    public Observable<AutoSingleResponse<TowerPicsModel>> getTowerPics(String companyCode, String inspectCode, String xlinteRid, String inteRid) {
//        return mRetrofitService.getTowerPics(companyCode, inspectCode, xlinteRid, inteRid);
//    }
//
//    public Observable<AutoSingleResponse<RiskDetailsTourBeanModel>> getHiddenDetail(String hiddenTroubleCode, String fromDate, String toDate, String companyCode) {
//        return mRetrofitService.getHiddenDetail(hiddenTroubleCode, fromDate, toDate, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<DCRecordAllModel>> getDCList(String companyCode, String fromDate, String toDate, String superintendType, String riskCode) {
//        return mRetrofitService.getDCList(companyCode, fromDate, toDate, superintendType, riskCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenTypeBean>> superintendTypeList(String companyCode, String inspector) {
//        return mRetrofitService.superintendTypeList(companyCode, inspector);
//    }
//
//    public Observable<AutoSingleResponse<WatchHiddenRecordBean>> getHistoryDutyList(String companyCode, String inspectCode) {
//        return mRetrofitService.getHistoryDutyList(companyCode, inspectCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenControlBean>> getPageControlList(String hiddenTroubleCode, String fromDate,
//                                                                                String toDate, int lappCode) {
//        return mRetrofitService.getPageControlList(hiddenTroubleCode, fromDate, toDate, lappCode);
//    }
//
//    public Observable<AutoSingleResponse<LoginDynamicBean>> queryAppModuleList(String lappCode) {
//        return mRetrofitService.queryAppModuleList(lappCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenControlDetailBean>> getControlDetail(String hiddenTroubleCode, String id) {
//        return mRetrofitService.getControlDetail(hiddenTroubleCode, id);
//    }
//
//    public Observable<AutoSingleResponse<HiddenTaskDetailBean>> getDutyTaskDetail(String taskCode) {
//        return mRetrofitService.getDutyTaskDetail(taskCode);
//    }
//
//
//    public Observable<AutoSingleResponse<HiddenTaskDetailBean>> getProcessTaskDetailList(String taskCode) {
//        return mRetrofitService.getProcessTaskDetailList(taskCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenTaskUpListBean>> getDutyTaskDetailList(String inspectCode, String dutyCode,
//                                                                                      String fromDate, String toDate) {
//        return mRetrofitService.getDutyTaskDetailList(inspectCode, "", fromDate, toDate);
//    }
//
//    public Observable<AutoSingleResponse<HiddenTaskBean>> getPageDutyTaskList(String dutyGroupCode, String dutyUserCode,
//                                                                              int currentPage, String taskSearchName) {
//        return mRetrofitService.getPageDutyTaskList(dutyGroupCode, dutyUserCode, currentPage, taskSearchName);
//    }
//
//    public Observable<AutoSingleResponse<HiddenTaskPageBean>> getAppPageDutyTaskList(String dutyGroupCode, int currentPage, String dutyUserCode,
//                                                                                     String taskSearchName) {
//        return mRetrofitService.getAppPageDutyTaskList(dutyGroupCode, currentPage, dutyUserCode, taskSearchName);
//    }
//
//    public Observable<AutoSingleResponse<HiddenOneDutyBean>> getOneDuty(String inspectCode, String lineName, String towerNo) {
//        return mRetrofitService.getOneDuty(inspectCode, lineName, towerNo);
//    }
//
//
//    public Observable<AutoSingleResponse<SuperintendTypeModel>> updateHiddenTrouble(List<MultipartBody.Part> requestBodyMap) {
//        return mRetrofitService.updateHiddenTrouble(requestBodyMap);
//    }
//
//    public Observable<AutoSingleResponse<EquipmentInfoModel>> towerList(String xlinteRid, String companyCode) {
//        return mRetrofitService.towerList(xlinteRid, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<EquipmentInfoModel>> getTrans(String xlinteRid, String companyCode) {
//        return mRetrofitService.getTrans(xlinteRid, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<EquipmentInfoModel>> getDefectAndTrouble(String xlinteRid, String companyCode) {
//        return mRetrofitService.getDefectAndTrouble(xlinteRid, companyCode);
//    }
//
//    public Observable<EquipmentInfoModel> queryDeviceListForSD(String xlinteRid) {
//        return mRetrofitService.queryDeviceListForSD(xlinteRid);
//    }
//
//    public Observable<AutoSingleResponse<EquipmentInfoModel>> getAreaTowerDefectHiddentrouble(String companyCode, String xlinteRid, String longitude, String latitude, String mile) {
//        return mRetrofitService.getAreaTowerDefectHiddentrouble(companyCode, xlinteRid, longitude, latitude, mile);
//    }
//
//    public Observable<AutoSingleResponse<InspectDisModel>> getInspectDis(String companyCode) {
//        return mRetrofitService.getInspectDis(companyCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> insertInspectRecord(HashMap map) {
//        return mRetrofitService.insertInspectRecord(map);
//    }
//
//    public Observable<AutoSingleResponse<InsDevicePicTypeModel>> getInsDevicePicType() {
//        return mRetrofitService.getInsDevicePicType();
//    }
//
//    public Observable<AutoSingleResponse<Object>> addNewDevicePic(HashMap map) {
//        return mRetrofitService.addNewDevicePic(map);
//    }
//
//    public Observable<AutoSingleResponse<Object>> uploadInspectReShotPic(HashMap map) {
//        return mRetrofitService.uploadInspectReShotPic(map);
//    }
//
//    public Observable<AutoSingleResponse<EquipmentSearchBModel>> towerList(String xlinteRid, String companyCode, String searchName, String shudianTeam, String daiweiTeam) {
//        return mRetrofitService.towerList(xlinteRid, companyCode, searchName, shudianTeam, daiweiTeam);
//    }
//
//    public Observable<AutoSingleResponse<LineStaticModel>> getLineStatic(String companyCode, String unitCode, String xlinteRid) {
//        return mRetrofitService.getLineStatic(companyCode, unitCode, xlinteRid);
//    }
//    public Observable<AutoSingleResponse<LineBusinessDetailBean>> getLineBusinessDetail(String xlinteRid) {
//        return mRetrofitService.getLineBusinessDetail(xlinteRid);
//    }
//
//    public Observable<AutoSingleResponse<DirectoryBeanModel>> getLineDir(String xlinteRid) {
//        return mRetrofitService.getLineDir(xlinteRid);
//    }
//
//    public Observable<AutoSingleResponse<DocModel>> getLineDoc(String xlinteRid, String dirCode) {
//        return mRetrofitService.getLineDoc(xlinteRid, dirCode);
//    }
//
//    public Observable<AutoSingleResponse<InspectDetailModel>> getHiddenTroubleInspectDetail(String inspectCode) {
//        return mRetrofitService.getHiddenTroubleInspectDetail(inspectCode);
//    }
//
//    public Observable<AutoSingleResponse<Object>> addHiddenTrouble(HashMap map) {
//        return mRetrofitService.addHiddenTrouble(map);
//    }
//
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> checkDefect(HashMap<String, Object> map) {
//        return mRetrofitService.checkDefect(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateProcess(HashMap<String, Object> map) {
//        return mRetrofitService.updateProcess(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> dutyUpdateProcess(HashMap<String, Object> map) {
//        return mRetrofitService.dutyUpdateProcess(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> insertDutyHiddenTrouble(HashMap<String, Object> map) {
//        return mRetrofitService.insertDutyHiddenTrouble(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> editDutyHiddenTrouble(HashMap<String, Object> map) {
//        return mRetrofitService.editDutyHiddenTrouble(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateDutyHiddenTroubleForDuty(HashMap<String, Object> map) {
//        return mRetrofitService.updateDutyHiddenTroubleForDuty(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateDutyHiddenTroubleForSign(HashMap<String, Object> map) {
//        return mRetrofitService.updateDutyHiddenTroubleForSign(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateAppDutyTask(HashMap<String, Object> map) {
//        return mRetrofitService.updateAppDutyTask(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addControlOperation(HashMap<String, Object> map) {
//        return mRetrofitService.addControlOperation(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addOrUpdateInspectTask(HashMap<String, Object> map) {
//        return mRetrofitService.addOrUpdateInspectTask(map);
//    }
//
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> deleteHiddenTroublePicBook(HashMap<String, Object> map) {
//        return mRetrofitService.deleteHiddenTroublePicBook(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> deleteControlOperationPic(HashMap<String, Object> map) {
//        return mRetrofitService.deleteControlOperationPic(map);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> updateHiddenTroubleByCode(HashMap<String, Object> map) {
//        return mRetrofitService.updateHiddenTroubleByCode(map);
//    }
//
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> workOutDefect(List<MultipartBody.Part> requestBodyMap) {
//        return mRetrofitService.workOutDefect(requestBodyMap);
//    }
//
//    public Observable<AutoSingleResponse<RepairAddTowerCheckBean>> addDuty(List<MultipartBody.Part> requestBodyMap) {
//        return mRetrofitService.addDuty(requestBodyMap);
//    }
//
//    public Observable<AutoSingleResponse<PowerDefectLevelBean>> getDefectLevel(String companyCode) {
//        return mRetrofitService.getDefectLevel(companyCode);
//    }
//
//
//    public Observable<AutoSingleResponse<PagerDefectBean>> getPageDefectList(String searchName, int currentPage, String state, String defectClass,
//                                                                             String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                                                             String toDate, String orderBy, String selectUnits, String companyCode,
//                                                                             String unitCode, String prefix, String gradeType, String shudianTeam, String daiweiTeam) {
//        return mRetrofitService.getPageDefectList(searchName, currentPage, state, defectClass, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, companyCode, unitCode, prefix, gradeType, shudianTeam, daiweiTeam);
//    }
//
//    public Observable<AutoSingleResponse<PagerDefectBean>> getMapDefectList(String searchName, String currentPage, String state, String defectClass,
//                                                                            String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                                                            String toDate, String orderBy, String selectUnits, String companyCode,
//                                                                            String unitCode, String prefix) {
//        return mRetrofitService.getMapDefectList(searchName, currentPage, state, defectClass, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, companyCode, unitCode, prefix);
//    }
//
//    public Observable<AutoSingleResponse<HiddenTroubleListBean>> getPageHiddenTroubleList(String searchName, int currentPage, String state, String defectClass,
//                                                                                          String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                                                                          String toDate, String orderBy, String selectUnits, String prefix, String companyCode,
//                                                                                          String unitCode, String shudianTeam, String daiweiTeam) {
//        return mRetrofitService.getPageHiddenTroubleList(searchName, currentPage, state, defectClass, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, prefix, companyCode, unitCode, shudianTeam, daiweiTeam);
//    }
//
//
//    public Observable<AutoSingleResponse<HiddenDefectBean>> getMapHiddenTroubleList(String searchName, int currentPage, String state, String defectClass,
//                                                                                    String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                                                                    String toDate, String orderBy, String selectUnits, String prefix) {
//        return mRetrofitService.getMapHiddenTroubleList(searchName, currentPage, state, defectClass, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, prefix);
//    }
//
//    public Observable<AutoSingleResponse<HiddenTroubleListBean>> getDutyPageHiddenTroubleList(String searchName, int currentPage, String state, String haveProblem,
//                                                                                              String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                                                                              String toDate, String orderBy, String selectUnits, String prefix, String firstday,
//                                                                                              String lastday, String companyCode, String unitCode, String shudianTeam, String daiweiTeam,
//                                                                                              int prePage) {
//        return mRetrofitService.getDutyPageHiddenTroubleList(searchName, currentPage, state, haveProblem, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, prefix, firstday, lastday, companyCode, unitCode, shudianTeam, daiweiTeam, prePage);
//    }
//
//
//    public Observable<AutoSingleResponse<PowerUnitsBean>> getUnits(String companyCode) {
//        return mRetrofitService.getUnits(companyCode);
//    }
//
//
//    public Observable<AutoSingleResponse<DutyTaskBean>> getAppDutyHiddenTroubleList(String dutyUserCode, int currentPage) {
//        return mRetrofitService.getAppDutyHiddenTroubleList(dutyUserCode, 1, 1, currentPage);
//    }
//
//    public Observable<AutoSingleResponse<HiddenPersonBean>> queryDeptMemberList(int companyCode, String searchName) {
//        return mRetrofitService.queryDeptMemberList(companyCode, searchName);
//    }
//
//    public Observable<AutoSingleResponse<HiddenTroubleListBean>> selectHiddenTroubleForDuty(String hiddenTroubleLevel, int currentPage, String searchName, String fromDate,
//                                                                                            String toDate, String voltageLevel, String xlinteRid, String selectUnits) {
//        return mRetrofitService.selectHiddenTroubleForDuty(hiddenTroubleLevel, currentPage, searchName, fromDate, toDate, voltageLevel, xlinteRid, selectUnits);
//    }
//
//    public Observable<AutoSingleResponse<HiddenPersonBean>> queryHiddenTroubleDutyUser(String hiddenTroubleCode) {
//        return mRetrofitService.queryHiddenTroubleDutyUser(hiddenTroubleCode);
//    }
//
//    public Observable<AutoSingleResponse<DutyOnLineBean>> getHiddenTroubleConfig() {
//        return mRetrofitService.getHiddenTroubleConfig();
//    }
//
//    public Observable<AutoSingleResponse<HidenAnswerBean>> getOneAnswerSheetToDuty() {
//        return mRetrofitService.getOneAnswerSheetToDuty();
//    }
//
//    public Observable<AutoSingleResponse<PowerLineBean>> getLinesByVol(String voltageLevel, String companyCode, String prefix) {
//        return mRetrofitService.getLinesByVol(voltageLevel, companyCode, prefix);
//    }
//
//    public Observable<AutoSingleResponse<PowerLineBean>> lineVolList() {
//        return mRetrofitService.lineVolList();
//    }
//
//    public Observable<AutoSingleResponse<TaskListModel>> detectionTaskListAll(String taskType) {
//        return mRetrofitService.detectionTaskListAll(taskType);
//    }
//
//    public Observable<AutoSingleResponse<UnitModel>> getShuDianTeam(String unitCode, String companyCode) {
//        return mRetrofitService.getShuDianTeam(unitCode, companyCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenCheckListBean>> queryPageForHiddenTrouble(int currentPage, String hiddenTroubleCode, String fromDate, String toDate) {
//        return mRetrofitService.queryPageForHiddenTrouble(currentPage, hiddenTroubleCode, fromDate, toDate);
//    }
//
//    public Observable<AutoSingleResponse<DefectManageDetailBean>> getDetailDefect(String defectCode, String companyCode) {
//        return mRetrofitService.getDetailDefect(defectCode, companyCode);
//    }
//
//
//    public Observable<AutoSingleResponse<FlawManageB>> getDetailDefect1(String defectCode, String companyCode) {
//        return mRetrofitService.getDetailDefect1(defectCode, companyCode);
//    }
//
//
//    public Observable<AutoSingleResponse<HiddenDetailBean>> getHiddenDetail(String hiddenTroubleCode, String fromDate, String toDate) {
//        return mRetrofitService.getHiddenDetail(hiddenTroubleCode, fromDate, toDate);
//    }
//
//    public Observable<AutoSingleResponse<WatchHiddenDetailbean>> getDutyHiddenDetail(String hiddenTroubleCode, String companyCode,
//                                                                                     String fromDate, String toDate, String dutyUserCode) {
//        return mRetrofitService.getDutyHiddenDetail(hiddenTroubleCode, companyCode, fromDate, toDate, dutyUserCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenBadDutyBean>> getBadDutyDateList(String inspectCode, String fromDate, String toDate) {
//        return mRetrofitService.getBadDutyDateList(inspectCode, fromDate, toDate);
//    }
//
//    public Observable<AutoSingleResponse<HiddenDetailBean>> getLineById(String companyCode, String xlinteRid, String hiddenTroubleCode) {
//        return mRetrofitService.getLineById(companyCode, xlinteRid, hiddenTroubleCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenLinePointBean>> getHiddenLineById(String companyCode, String xlinteRid, String hiddenTroubleCode) {
//        return mRetrofitService.getHiddenLineById(companyCode, xlinteRid, hiddenTroubleCode);
//    }
//
//    public Observable<AutoSingleResponse<HiddenLinePointBean>> getGuardDutyLineById(String companyCode, String xlinteRid, String hiddenTroubleCode) {
//        return mRetrofitService.getGuardDutyLineById(companyCode, xlinteRid, hiddenTroubleCode);
//    }
//
//    public Observable<AutoSingleResponse<SuperviseBean>> getPageSuperintendRiskList(String companyCode, String fromDate, String toDate,
//                                                                                    String superintendType, String riskCode, int currentPage) {
//        return mRetrofitService.getPageSuperintendRiskList(companyCode, fromDate, toDate, superintendType, riskCode, currentPage, 3000);
//    }
//
//    public Observable<AutoSingleResponse<NotInPlaceExplainModel>> getInspectRecordDetail(String inspectCode) {
//        return mRetrofitService.getInspectRecordDetail(inspectCode);
//    }
//
//    public Observable<AutoSingleResponse<InfradDetailModel>> temperatureRecordMsg(String taskCode, String lineId, String towerId) {
//        return mRetrofitService.temperatureRecordMsg(taskCode, lineId, towerId);
//    }
//
//    public Observable<AutoSingleResponse<InfradDetailModel>> temperaturePhaseMsg(String taskCode, String lineId, String towerId, String phase) {
//        return mRetrofitService.temperaturePhaseMsg(taskCode, lineId, towerId, phase);
//    }
//
//    public Observable<AutoSingleResponse<Object>> deleteDetectionPicture(String inteRid) {
//        return mRetrofitService.deleteDetectionPicture(inteRid);
//    }
//
}

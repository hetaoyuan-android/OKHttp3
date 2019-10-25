package com.mengpeng.okhttpdemo.network;


import com.mengpeng.okhttpdemo.ContextUtils;
import com.mengpeng.okhttpdemo.MyApplication;
import com.mengpeng.okhttpdemo.R;
import com.mengpeng.okhttpdemo.bean.UserInfoBean;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wkc on 2019/5/23.
 */
public class InterManage {

    static final public int NET_ERROR = 2000; // 网络错误

    private static class SingletonHolder {
        private static final InterManage mSingleton = new InterManage();

    }

    public static InterManage getInstance() {
        return InterManage.SingletonHolder.mSingleton;
    }

    /* test */
    public void getUserInfo(BasePresenter presenter, Subscriber<UserInfoBean> subscriber) {
        if (!ContextUtils.is_Network_Available(MyApplication.getInstance())) {
            if (subscriber != null) {
                UserInfoBean s = new UserInfoBean(NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
                subscriber.onNext(s);
            }
            return;
        }
        DataManager.getInstance(MyApplication.getInstance()).getUserInfo().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
        presenter.mCompositeSubscription.add(subscriber);
    }


//    // 接地电阻分页列表
//    public void getGroundResistanceList(BasePresenter presenter, String lineVol, String lineName, String isInspected, String towerNo, int page, int rows, String taskCode, String lineId, String startDate, String endDate, Subscriber<AutoSingleResponse<GroundResistanceListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<GroundResistanceListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getGroundResistanceList(lineVol, lineName, isInspected, towerNo, page, rows, taskCode, lineId, startDate, endDate).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 接地电阻详情页
//    public void getGroundResistanceDetailList(BasePresenter presenter, String recodeCode, Subscriber<AutoSingleResponse<GroundResistanceDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<GroundResistanceDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getGroundResistanceDetailList(recodeCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 新增接地电阻
//    public void addGroundResistance(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<AddGrounResistanceBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<AddGrounResistanceBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addGroundResistance(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 老旧钢管列表
//    public void getSteelPipeInterList(HashMap<String, Object> parmeMap, Subscriber<AutoSingleResponse<SteelPipeBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<SteelPipeBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getSteelPipeMangerList(parmeMap).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    }
//
//    // 老旧钢管新增编辑
//    public void getSteelPipeAddInterList(HashMap<String, Object> mapParema, Subscriber<AutoSingleResponse<DeteionCommitBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<DeteionCommitBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getSteelPipeAddManageList(mapParema).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    }// 老旧钢管详情
//
//    public void getSteelPipeDetailsInter(String recodeCode, Subscriber<AutoSingleResponse<SteelPipeDetailsBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<SteelPipeDetailsBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getSteelPipeDetailsManageList(recodeCode).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    }
//
//    // X光探伤列表
//    public void getXLightInterList(HashMap<String, Object> parmeMap, Subscriber<AutoSingleResponse<XLightBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<XLightBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getXLightMangerList(parmeMap).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    } // X光探伤新增详情
//
//    public void getXLightCommitInterList(HashMap<String, Object> parmeMap, Subscriber<AutoSingleResponse<DeteionCommitBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<DeteionCommitBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getXlightCommitManageList(parmeMap).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    }
//
//    // X光探伤详情
//    public void getXLightDetailsInter(String recodeCode, Subscriber<AutoSingleResponse<XLightDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<XLightDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getXlightDetailsManageList(recodeCode).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    }
//
//    // 绝缘子零值列表
//    public void getInsulatorInterList(HashMap<String, Object> parmeMap, Subscriber<AutoSingleResponse<InsulatorZeroBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<InsulatorZeroBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getInsulatorPageList(parmeMap).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    }
//
//    //  绝缘子零值新增详情
//    public void getInsulatorCommitInterList(HashMap<String, Object> parmeMap, Subscriber<AutoSingleResponse<DeteionCommitBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<DeteionCommitBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getInsulatorCommitManageList(parmeMap).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    }
//
//    // 绝缘子零值详情
//    public void getInsulatorDetailsInter(String recodeCode, Subscriber<AutoSingleResponse<InsulatorZeroDetailsBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<InsulatorZeroDetailsBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getInsulatorDetailsManageList(recodeCode).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//    }
//
//    // 签到
//    public void checkIn(BasePresenter presenter, HashMap<String, Object> map, Subscriber<SignBean> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                SignBean s = new SignBean(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).checkIn(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 签退
//    public void checkOut(BasePresenter presenter, HashMap<String, Object> map, Subscriber<SignBean> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                SignBean s = new SignBean(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).checkOut(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 轨迹 uploadGps
//    public void uploadGps(BasePresenter presenter, HashMap<String, Object> map, Subscriber<SignBean> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                SignBean s = new SignBean(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).uploadGps(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 值守轨迹 alarmDutyUser
//    public void alarmDutyUser(BasePresenter presenter, HashMap<String, Object> map, Subscriber<SignBean> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                SignBean s = new SignBean(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).alarmDutyUser(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 退出登录
//    public void logout(BasePresenter presenter, Subscriber<Logout> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                Logout s = new Logout(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).logout().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 检查新版本
//    public void inspectVersion(BasePresenter presenter, Subscriber<AutoSingleResponse<SelectVersionBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<SelectVersionBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).inspectVersion().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    //扫一扫详情 getLinesByGt
//    public void getLinesByGt(BasePresenter presenter, String inteRid, Subscriber<AutoSingleResponse<LineByTowerAllModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<LineByTowerAllModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getLinesByGt(inteRid).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    //新功能介绍
//    public void newFunction(BasePresenter presenter, Subscriber<AutoSingleResponse<NewFunctionBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<NewFunctionBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).newFunction().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 服务协议
//    public void serviceAgreement(BasePresenter presenter, Subscriber<AutoSingleResponse<NewFunctionBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<NewFunctionBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).serviceAgreement().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 隐私政策
//    public void privacyPolicy(BasePresenter presenter, Subscriber<AutoSingleResponse<NewFunctionBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<NewFunctionBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).privacyPolicy().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 今日工作 list
//    public void todayWorkList(BasePresenter presenter, String queryDate, String userCode, Subscriber<AutoSingleResponse<TodayWorkBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<TodayWorkBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).todayWorkList(queryDate, userCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 今日工作 map
//    public void todayWorkMap(BasePresenter presenter, String queryDate, String userCode, Subscriber<AutoSingleResponse<TodatWorkMapBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<TodatWorkMapBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).todayWorkMap(queryDate, userCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 杆塔巡视 patrolDetail
//    public void patrolDetail(BasePresenter presenter, String queryDate, String xlinteRid, Subscriber<AutoSingleResponse<TodayWorkDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<TodayWorkDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).patrolDetail(queryDate, xlinteRid).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 我的成就 list
//    public void myAchievement(BasePresenter presenter, String startDate, String endDate, Subscriber<AutoSingleResponse<TodayWorkBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<TodayWorkBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).myAchievement(startDate, endDate).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    //我的成就热力图
//    public void myAchievementHeatMap(BasePresenter presenter, String startDate, String endDate, Subscriber<AutoSingleResponse<MyAchievementHeatMapBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<MyAchievementHeatMapBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).myAchievementHeatMap(startDate, endDate).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 新增开收工录音
//    public void addSoundRecord(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<AddGrounResistanceBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<AddGrounResistanceBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addSoundRecord(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 新增检修资料
//    public void addInformationRecord(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<AddGrounResistanceBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<AddGrounResistanceBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addInformationRecord(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    // 新增接地电阻带图片
//    public void addGroundResistanceAndImage(BasePresenter presenter, String path, HashMap<String, Object> map, Subscriber<AutoSingleResponse<AddGrounResistanceBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<AddGrounResistanceBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addGroundResistanceAndImage(map, requestFile).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    // 红外测温分页列表
//    public void getInfraredList(BasePresenter presenter, String lineVol, String lineName, String isInspected, String towerNo, int page, int rows, String taskCode, Subscriber<AutoSingleResponse<InfraraedListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<InfraraedListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getInfraredList(lineVol, lineName, isInspected, towerNo, page, rows, taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 红外测温分页列表
//    public void temperaturePhaseList(BasePresenter presenter, String lineVol, String lineName, String isInspected, String towerNo, int page, int rows, String taskCode, Integer isNormal, String startDate, String endDate, String lineId, Integer defectGrade, Subscriber<AutoSingleResponse<InfraraedListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<InfraraedListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).temperaturePhaseList(lineVol, lineName, isInspected, towerNo, page, rows, taskCode, isNormal, startDate, endDate, lineId, defectGrade).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 红外测温详情页
//    public void getInfraredDetailList(BasePresenter presenter, String recodeCode, Subscriber<AutoSingleResponse<InfraredDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<InfraredDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getInfraredDetailList(recodeCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 新增红外测温
//    public void addInfrared(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<AddGrounResistanceBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<AddGrounResistanceBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addInfrared(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 交跨测量的分页列表
//    public void getPayMeasureList(BasePresenter presenter, String lineVol, String lineName, String isInspected, Integer crossType, String exeUnitId, String startTowerNo, String endTowerNo, String taskCode, int page, int rows, String lineId, Subscriber<AutoSingleResponse<PayMeasureListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<PayMeasureListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getPayMeasureList(lineVol, lineName, isInspected, crossType, exeUnitId, startTowerNo, endTowerNo, taskCode, page, rows, lineId).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 交跨测量详情页
//    public void getPayMeasureDetailList(BasePresenter presenter, String recodeCode, Subscriber<AutoSingleResponse<PayMeasureDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<PayMeasureDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getPayMeasureDetailList(recodeCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 新增交跨测量
//    public void addPayMeasure(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<AddGrounResistanceBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<AddGrounResistanceBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addPayMeasure(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getWellOverhLineMap(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<WellOverhBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<WellOverhBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getWellOverhLineMap(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//        if (presenter != null)
//            presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDeviceLineMap(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<DeviceLnieMapBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<DeviceLnieMapBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDeviceLineMap(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//
//        if (presenter != null)
//            presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    // 人脸识别登录
//    public void faceLogin(BasePresenter presenter, String userCode, String userName, String imei, Subscriber<AutoSingleResponse<LoginBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<LoginBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).faceLogin(userCode, userName, imei).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    //人脸采集列表 faceAcquisition
//    public void faceAcquisition(BasePresenter presenter, String cj, String lib, Subscriber<AutoSingleResponse<FaceAcuqisitionBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<FaceAcuqisitionBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).faceAcquisition(cj, lib).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    //人脸头像上传uploadFaceImg
//    public void uploadFaceImg(BasePresenter presenter, String userCode, String lib, Subscriber<AutoSingleResponse> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UploadFaceImgBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).uploadFaceImg(userCode, lib).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    //人像采集删除 deleteFaceImg
//    public void deleteFaceImg(BasePresenter presenter, String userCode, Subscriber<AutoSingleResponse> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UploadFaceImgBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteFaceImg(userCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void projectManageList(BasePresenter presenter, String projectName, String startDate, String endDate, int projectType, int page, int rows, Subscriber<AutoSingleResponse<ProjectListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<ProjectListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).projectManageList(projectName, startDate, endDate, projectType, page, rows).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void siteLogList(BasePresenter presenter, String projectCode, Subscriber<AutoSingleResponse<RepairBillBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairBillBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).siteLogList(projectCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDetectionList(String taskName, String taskTime, int taskType, int page, int rows, Subscriber<AutoSingleResponse<ResistanceBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<ResistanceBean> s = new AutoSingleResponse<ResistanceBean>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).detectionList(taskName, taskTime, "", taskType, page, rows).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
////        super.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getRepairTower(BasePresenter presenter, String startDate, String endDate, String taskCode, Subscriber<AutoSingleResponse<RepairTowerListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).repairTower(startDate, endDate, taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getRepairTaskList(BasePresenter presenter, String startDate, String endDate, String taskCode, Subscriber<AutoSingleResponse<RepairTowerListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).repairTaskList(startDate, endDate, taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void insulatorClearList(BasePresenter presenter, String startDate, String endDate, String taskCode, Subscriber<AutoSingleResponse<RepairTowerListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).insulatorClearList(startDate, endDate, taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void traceCheckList(BasePresenter presenter, String startDate, String endDate, String taskCode, Subscriber<AutoSingleResponse<RepairTowerListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).traceCheckList(startDate, endDate, taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void rtvSprayList(BasePresenter presenter, String startDate, String endDate, String taskCode, Subscriber<AutoSingleResponse<RepairTowerListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).rtvSprayList(startDate, endDate, taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void hydrophobicTestList(BasePresenter presenter, String startDate, String endDate, String taskCode, Subscriber<AutoSingleResponse<RepairTowerListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).hydrophobicTestList(startDate, endDate, taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void siteSurveyList(BasePresenter presenter, String taskCode, Subscriber<AutoSingleResponse<RepairTowerListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).siteSurveyList(taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void soundList(BasePresenter presenter, String taskCode, Subscriber<AutoSingleResponse<RepairTowerListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).soundList(taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void informationList(BasePresenter presenter, String taskCode, Subscriber<AutoSingleResponse<RepairInformationBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairInformationBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).informationList(taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void groundList(BasePresenter presenter, String taskCode, Subscriber<AutoSingleResponse<RepairGroundBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairGroundBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).groundList(taskCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void equipmentList(BasePresenter presenter, String taskCode, int selectType, Subscriber<AutoSingleResponse<EquipmentBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<EquipmentBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).equipmentList(taskCode, selectType).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void infraredList(Context context, String lineVol, String lineName, int isInspected, String towerNo, String taskCode, int page, int rows, Subscriber<ResponseBody> subscriber) {
////        if (!CommonUtils.is_Network_Available(PowerApplication.getPowerApplication())) {
//////            if (subscriber != null) {
//////                AutoSingleResponse<ResistanceBean> s = new AutoSingleResponse<ResistanceBean>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource()(R.string.net_error));
//////                subscriber.onNext(s);
//////            }
//////            return;
////        }
////        super.mCompositeSubscription.add(DataManager.getInstance(context).infraredList(lineVol, lineName, isInspected, towerNo, taskCode, page, rows).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber));
//    }
//
//    public void repairTowerDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<RepairTowerDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTowerDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).repairTowerDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void repairTaskDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<DefectDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<DefectDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).repairTaskDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void insulatorDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<InsulatorDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<InsulatorDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).insulatorDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void projectManageDetail(BasePresenter presenter, String projectCode, Subscriber<AutoSingleResponse<ProjectListDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<ProjectListDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).projectManageDetail(projectCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void informationDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<InformationDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<InformationDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).informationDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void groundrDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<GroundDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<GroundDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).groundrDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void traceCheckDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<LineCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<LineCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).traceCheckDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void sprayDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<RtvSprayDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RtvSprayDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).sprayDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void waterTestDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<WaterTestDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<WaterTestDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).waterTestDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void siteSurveyDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<RepairTaskDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairTaskDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).siteSurveyDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void repairSoundDetail(BasePresenter presenter, String checkRecordCode, Subscriber<AutoSingleResponse<RecordDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RecordDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).repairSoundDetail(checkRecordCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void upTowerPhoto(BasePresenter presenter, String path, String taskCode, int picType, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upTowerPhoto(requestFile, taskCode, picType, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upInformationPhoto(BasePresenter presenter, String path, String taskCode, int picType, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upInformationPhoto(requestFile, taskCode, picType, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upSoundAudio(BasePresenter presenter, String path, String taskCode, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("音频大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upSoundAudio(requestFile, taskCode, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upInformationAudio(BasePresenter presenter, String path, String taskCode, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("音频大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upInformationAudio(requestFile, taskCode, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upGroundPhoto(BasePresenter presenter, String path, String taskCode, String picType, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upGroundPhoto(requestFile, taskCode, picType, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upWaterTestPhoto(BasePresenter presenter, String path, String taskCode, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upWaterTestPhoto(requestFile, taskCode, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upLineCheckPhoto(BasePresenter presenter, String path, String taskCode, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upLineCheckPhoto(requestFile, taskCode, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upWorkRecordPhoto(BasePresenter presenter, String path, String taskCode, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upWorkRecordPhoto(requestFile, taskCode, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upInsulatorPhoto(BasePresenter presenter, String path, String taskCode, int picType, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upInsulatorPhoto(requestFile, taskCode, picType, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upSprayPhoto(BasePresenter presenter, String path, String taskCode, int picType, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upSprayPhoto(requestFile, taskCode, picType, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void upSiteSurveyPhoto(BasePresenter presenter, String path, String taskCode, String remarks, Subscriber<AutoSingleResponse<UpRepairPhotoBean>> subscriber) {
//        File file = new File(path);
//        try {
//            Log.e("图片大小", path + ImageSizeUtil.getFileSize(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UpRepairPhotoBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).upSiteSurveyPhoto(requestFile, taskCode, remarks).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void deleteTowerPhoto(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteTowerPhoto(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteRtvSprayPicture(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteRtvSprayPicture(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteSiteSurveyPicture(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteSiteSurveyPicture(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteHydrophobicTestPicture(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteHydrophobicTestPicture(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteInsulatorClearPicture(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteInsulatorClearPicture(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteTraceCheckPicture(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteTraceCheckPicture(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteLineCheckPhoto(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteLineCheckPhoto(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteWaterTestPhoto(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteWaterTestPhoto(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteSoundPicture(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteSoundPicture(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteInformationPicture(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteInformationPicture(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteSound(BasePresenter presenter, String audioCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteSound(audioCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteInformationSound(BasePresenter presenter, String audioCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteInformationSound(audioCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteSprayPhoto(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteSprayPhoto(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteSitePhoto(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteSitePhoto(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteGroundPhoto(BasePresenter presenter, String picCode, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteGroundPhoto(picCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void getControlOperationList(BasePresenter presenter, String hiddenTroubleCode, Subscriber<AutoSingleResponse<ControlListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<ControlListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getControlOperationList(hiddenTroubleCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addTowerCheck(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addTowerCheck(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addLineCheck(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addLineCheck(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addProjectManage(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<AddProjectBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<AddProjectBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addProjectManage(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addSiteLog(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<AddProjectBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<AddProjectBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addSiteLog(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addWaterTest(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addWaterTest(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void lineCheckList(BasePresenter presenter, String taskCode, int selectType, String lineId, Subscriber<AutoSingleResponse<TowerBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<TowerBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).lineCheckList(taskCode, selectType, lineId).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addInsulatorClear(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addInsulatorClear(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addSiteSurvey(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addSiteSurvey(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void updateGroundCheck(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).updateGroundCheck(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addGroundMout(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addGroundMout(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addSpray(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addSpray(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void checkDefect(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).checkDefect(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void updateProcess(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).updateProcess(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void dutyUpdateProcess(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).dutyUpdateProcess(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void insertDutyHiddenTrouble(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).insertDutyHiddenTrouble(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void editDutyHiddenTrouble(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).editDutyHiddenTrouble(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void updateDutyHiddenTroubleForDuty(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).updateDutyHiddenTroubleForDuty(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void updateDutyHiddenTroubleForSign(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).updateDutyHiddenTroubleForSign(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void updateAppDutyTask(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).updateAppDutyTask(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addControlOperation(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addControlOperation(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addOrUpdateInspectTask(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addOrUpdateInspectTask(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void deleteHiddenTroublePicBook(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteHiddenTroublePicBook(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void deleteControlOperationPic(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).deleteControlOperationPic(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void updateHiddenTroubleByCode(BasePresenter presenter, HashMap<String, Object> map, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).updateHiddenTroubleByCode(map).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void insertHiddenTrouble(BasePresenter presenter, List<MultipartBody.Part> requestBodyMap, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).insertHiddenTrouble(requestBodyMap).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addDC(BasePresenter presenter, List<MultipartBody.Part> requestBodyMap, Subscriber<AutoSingleResponse<Object>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<Object> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addDC(requestBodyMap).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void workOutDefect(BasePresenter presenter, List<MultipartBody.Part> requestBodyMap, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).workOutDefect(requestBodyMap).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void addDuty(BasePresenter presenter, List<MultipartBody.Part> requestBodyMap, Subscriber<AutoSingleResponse<RepairAddTowerCheckBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RepairAddTowerCheckBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).addDuty(requestBodyMap).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDefectLevel(BasePresenter presenter, String companyCode, Subscriber<AutoSingleResponse<PowerDefectLevelBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<PowerDefectLevelBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDefectLevel(companyCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getUnits(BasePresenter presenter, String companyCode, Subscriber<AutoSingleResponse<PowerUnitsBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<PowerUnitsBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getUnits(companyCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getAppDutyHiddenTroubleList(BasePresenter presenter, String companyCode, int currentPage, Subscriber<AutoSingleResponse<DutyTaskBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<DutyTaskBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getAppDutyHiddenTroubleList(companyCode, currentPage).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void queryDeptMemberList(BasePresenter presenter, int companyCode, String searchName, Subscriber<AutoSingleResponse<HiddenPersonBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenPersonBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).queryDeptMemberList(companyCode, searchName).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void selectHiddenTroubleForDuty(BasePresenter presenter, String hiddenTroubleLevel, int currentPage, String searchName, String fromDate,
//                                           String toDate, String voltageLevel, String xlinteRid, String selectUnits, Subscriber<AutoSingleResponse<HiddenTroubleListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTroubleListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).selectHiddenTroubleForDuty(hiddenTroubleLevel, currentPage, searchName, fromDate, toDate, voltageLevel, xlinteRid, selectUnits).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getHiddenTroubleConfig(BasePresenter presenter, Subscriber<AutoSingleResponse<DutyOnLineBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<DutyOnLineBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getHiddenTroubleConfig().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getOneAnswerSheetToDuty(BasePresenter presenter, Subscriber<AutoSingleResponse<HidenAnswerBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HidenAnswerBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getOneAnswerSheetToDuty().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void queryHiddenTroubleDutyUser(BasePresenter presenter, String hiddenTroubleCode, Subscriber<AutoSingleResponse<HiddenPersonBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenPersonBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).queryHiddenTroubleDutyUser(hiddenTroubleCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getLinesByVol(BasePresenter presenter, String voltageLevel, String prefix, String companyCode, Subscriber<AutoSingleResponse<PowerLineBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<PowerLineBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getLinesByVol(voltageLevel, companyCode, prefix).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    //线路数据列表
//    public void lineVolList(BasePresenter presenter, Subscriber<AutoSingleResponse<PowerLineBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<PowerLineBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).lineVolList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        if (presenter != null) {
//            presenter.mCompositeSubscription.add(subscriber);
//        }
//    }
//
//    public void detectionTaskListAll(BasePresenter presenter, String taskType, Subscriber<AutoSingleResponse<TaskListModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<TaskListModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).detectionTaskListAll(taskType).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        if (presenter != null) {
//            presenter.mCompositeSubscription.add(subscriber);
//        }
//    }
//
//    public void getShuDianTeam(BasePresenter presenter, String unitCode, String companyCode, Subscriber<AutoSingleResponse<UnitModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UnitModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getShuDianTeam(unitCode, companyCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void queryPageForHiddenTrouble(BasePresenter presenter, int currentPage, String hiddenTroubleCode, String fromDate, String toDate, Subscriber<AutoSingleResponse<HiddenCheckListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenCheckListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).queryPageForHiddenTrouble(currentPage, hiddenTroubleCode, fromDate, toDate).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDetailDefect(BasePresenter presenter, String defectCode, String companyCode, Subscriber<AutoSingleResponse<DefectManageDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<DefectManageDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDetailDefect(defectCode, companyCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDetailDefect1(BasePresenter presenter, String defectCode, String companyCode, Subscriber<AutoSingleResponse<FlawManageB>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<FlawManageB> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDetailDefect1(defectCode, companyCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getHiddenDetail(BasePresenter presenter, String hiddenTroubleCode, String fromDate, String toDate, Subscriber<AutoSingleResponse<HiddenDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getHiddenDetail(hiddenTroubleCode, fromDate, toDate).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDutyHiddenDetail(BasePresenter presenter, String hiddenTroubleCode, String companyCode, String fromDate, String toDate, String dutyUserCode, Subscriber<AutoSingleResponse<WatchHiddenDetailbean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<WatchHiddenDetailbean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDutyHiddenDetail(hiddenTroubleCode, companyCode, fromDate, toDate, dutyUserCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getBadDutyDateList(BasePresenter presenter, String inspectCode, String fromDate, String toDate, Subscriber<AutoSingleResponse<HiddenBadDutyBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenBadDutyBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getBadDutyDateList(inspectCode, fromDate, toDate).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void updateHiddenTrouble(BasePresenter presenter, List<MultipartBody.Part> requestBodyMap, Subscriber<AutoSingleResponse<SuperintendTypeModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<SuperintendTypeModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).updateHiddenTrouble(requestBodyMap).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getLineById(BasePresenter presenter, String companyCode, String xlinteRid, String hiddenTroubleCode, Subscriber<AutoSingleResponse<HiddenDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getLineById(companyCode, xlinteRid, hiddenTroubleCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getHiddenLineById(BasePresenter presenter, String companyCode, String xlinteRid, String hiddenTroubleCode, Subscriber<AutoSingleResponse<HiddenLinePointBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenLinePointBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getHiddenLineById(companyCode, xlinteRid, hiddenTroubleCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getGuardDutyLineById(BasePresenter presenter, String companyCode, String xlinteRid, String hiddenTroubleCode, Subscriber<AutoSingleResponse<HiddenLinePointBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenLinePointBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getGuardDutyLineById(companyCode, xlinteRid, hiddenTroubleCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getPageSuperintendRiskList(BasePresenter presenter, String companyCode, String fromDate, String toDate,
//                                           String superintendType, String riskCode, int currentPage, Subscriber<AutoSingleResponse<SuperviseBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<SuperviseBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getPageSuperintendRiskList(companyCode, fromDate, toDate, superintendType, riskCode, currentPage).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void superintendTypeList(BasePresenter presenter, String companyCode, String inspector, Subscriber<AutoSingleResponse<HiddenTypeBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTypeBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).superintendTypeList(companyCode, inspector).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getHistoryDutyList(BasePresenter presenter, String companyCode, String inspectCode, Subscriber<AutoSingleResponse<WatchHiddenRecordBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<WatchHiddenRecordBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getHistoryDutyList(companyCode, inspectCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getHistoryDutyList(companyCode, inspectCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void queryAppModuleList(BasePresenter presenter, String lappCode, Subscriber<AutoSingleResponse<LoginDynamicBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<LoginDynamicBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).queryAppModuleList(lappCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getControlDetail(BasePresenter presenter, String hiddenTroubleCode, String id, Subscriber<AutoSingleResponse<HiddenControlDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenControlDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getControlDetail(hiddenTroubleCode, id).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getPageControlList(BasePresenter presenter, String hiddenTroubleCode, String fromDate,
//                                   String toDate, int lappCode, Subscriber<AutoSingleResponse<HiddenControlBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenControlBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getPageControlList(hiddenTroubleCode, fromDate, toDate, lappCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    /**
//     * 我的界面动态配置
//     *
//     * @param presenter
//     * @param lappCode
//     * @param subscriber
//     */
//    public void queryMineModleList(BasePresenter presenter, String lappCode, Subscriber<AutoSingleResponse<MineListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<MineListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).queryMineModleList(lappCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDutyTaskDetail(BasePresenter presenter, String lappCode, Subscriber<AutoSingleResponse<HiddenTaskDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTaskDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDutyTaskDetail(lappCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getProcessTaskDetailList(BasePresenter presenter, String lappCode, Subscriber<AutoSingleResponse<HiddenTaskDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTaskDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getProcessTaskDetailList(lappCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDutyTaskDetailList(BasePresenter presenter, String inspectCode, String dutyCode,
//                                      String fromDate, String toDate, Subscriber<AutoSingleResponse<HiddenTaskUpListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTaskUpListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDutyTaskDetailList(inspectCode, dutyCode, fromDate, toDate).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void getPageDutyTaskList(BasePresenter presenter, String dutyGroupCode, String dutyUserCode,
//                                    int currentPage, String taskSearchName, Subscriber<AutoSingleResponse<HiddenTaskBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTaskBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getPageDutyTaskList(dutyGroupCode, dutyUserCode, currentPage, taskSearchName).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getAppPageDutyTaskList(BasePresenter presenter, String dutyGroupCode, int currentPage, String dutyUserCode, String taskSearchName, Subscriber<AutoSingleResponse<HiddenTaskPageBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTaskPageBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getAppPageDutyTaskList(dutyGroupCode, currentPage, dutyUserCode, taskSearchName).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getOneDuty(BasePresenter presenter, String inspectCode, String lineName, String towerNo, Subscriber<AutoSingleResponse<HiddenOneDutyBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenOneDutyBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getOneDuty(inspectCode, lineName, towerNo).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void getVoltageList(BasePresenter presenter, String companyCode, Subscriber<AutoSingleResponse<VoltageLevelModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<VoltageLevelModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getVoltageList(companyCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getProcessNodeHasHandle(BasePresenter presenter, String hiddenTroubleCode, Subscriber<AutoSingleResponse<HiddenFlowStateBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenFlowStateBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getProcessNodeHasHandle(hiddenTroubleCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDutyProcessNodeHasHandle(BasePresenter presenter, String hiddenTroubleCode, Subscriber<AutoSingleResponse<HiddenFlowStateBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenFlowStateBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDutyProcessNodeHasHandle(hiddenTroubleCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void getGH(BasePresenter presenter, String voltageLevel, String xlinteRid, String unitCode, Subscriber<AutoSingleResponse<EquipmentSearchBModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<EquipmentSearchBModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getGH(voltageLevel, xlinteRid, unitCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//
//    public void getDwTeam(BasePresenter presenter, String unitCode, String companyCode, Subscriber<AutoSingleResponse<UnitModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UnitModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDwTeam(unitCode, companyCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getSdTeam(BasePresenter presenter, String unitCode, String companyCode, Subscriber<AutoSingleResponse<UnitModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<UnitModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getSdTeam(unitCode, companyCode).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getProcessRecordDetailList(BasePresenter presenter, String processCode, String nodeOrder, Subscriber<AutoSingleResponse<HiddenAuditDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenAuditDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getProcessRecordDetailList(processCode, nodeOrder).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDutyProcessRecordDetailList(BasePresenter presenter, String processCode, String nodeOrder, Subscriber<AutoSingleResponse<HiddenAuditDetailBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenAuditDetailBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDutyProcessRecordDetailList(processCode, nodeOrder).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getPageDefectList(BasePresenter presenter, String searchName, int currentPage, String state, String defectClass,
//                                  String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                  String toDate, String orderBy, String selectUnits, String companyCode,
//                                  String unitCode, String prefix, String gradeType, String shudianTeam, String daiweiTeam,
//                                  Subscriber<AutoSingleResponse<PagerDefectBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<PagerDefectBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getPageDefectList(searchName, currentPage, state, defectClass, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, companyCode, unitCode, prefix, gradeType, shudianTeam, daiweiTeam).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getMapDefectList(BasePresenter presenter, String searchName, String currentPage, String state, String defectClass,
//                                 String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                 String toDate, String orderBy, String selectUnits, String companyCode,
//                                 String unitCode, String prefix, Subscriber<AutoSingleResponse<PagerDefectBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<PagerDefectBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getMapDefectList(searchName, currentPage, state, defectClass, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, companyCode, unitCode, prefix).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getPageHiddenTroubleList(BasePresenter presenter, String searchName, int currentPage, String state, String defectClass,
//                                         String state1, String voltageLevel, String xlinteRid, String fromDate, String toDate, String orderBy,
//                                         String selectUnits, String prefix, String companyCode, String unitCode, String shudianTeam, String daiweiTeam,
//                                         Subscriber<AutoSingleResponse<HiddenTroubleListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTroubleListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getPageHiddenTroubleList(searchName, currentPage, state, defectClass, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, prefix, companyCode, unitCode, shudianTeam, daiweiTeam).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getMapHiddenTroubleList(BasePresenter presenter, String searchName, int currentPage, String state, String defectClass,
//                                        String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                        String toDate, String orderBy, String selectUnits, String prefix, Subscriber<AutoSingleResponse<HiddenDefectBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenDefectBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getMapHiddenTroubleList(searchName, currentPage, state, defectClass, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, prefix).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getDutyPageHiddenTroubleList(BasePresenter presenter, String searchName, int currentPage, String state, String haveProblem,
//                                             String state1, String voltageLevel, String xlinteRid, String fromDate,
//                                             String toDate, String orderBy, String selectUnits, String prefix, String firstday,
//                                             String lastday, String companyCode, String unitCode, String shudianTeam, String daiweiTeam, int prePage, Subscriber<AutoSingleResponse<HiddenTroubleListBean>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<HiddenTroubleListBean> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getDutyPageHiddenTroubleList(searchName, currentPage, state, haveProblem, state1, voltageLevel, xlinteRid, fromDate, toDate,
//                orderBy, selectUnits, prefix, firstday, lastday, companyCode, unitCode, shudianTeam, daiweiTeam, prePage).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }
//
//    public void getTroubleList(BasePresenter presenter, Subscriber<AutoSingleResponse<RiskTypeModel>> subscriber) {
//        if (!CommonUtils.is_Network_Available(PowerApplication.mApplication)) {
//            if (subscriber != null) {
//                AutoSingleResponse<RiskTypeModel> s = new AutoSingleResponse<>(RepairConstantUtils.NET_ERROR, ContextUtils.getStringResource(R.string.net_error));
//                subscriber.onNext(s);
//            }
//            return;
//        }
//        DataManager.getInstance(PowerApplication.getPowerApplication()).getTroubleList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
//        presenter.mCompositeSubscription.add(subscriber);
//    }

}

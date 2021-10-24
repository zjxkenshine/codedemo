
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *  海康门禁
 * @author root
 */
public class Test2 {

    static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
    static int lUserID = -1;//用户句柄
    static int m_lSetCardCfgHandle = -1; //下发卡长连接句柄
    static int m_lSetFaceCfgHandle = -1; //下发人脸长连接句柄

    static int dwState = -1; //下发卡数据状态
    static int dwFaceState = -1; //下发人脸数据状态


    static int lHandle = -1; //下发人脸数据状态
    static int lAlarmHandle = -1; //下发人脸数据状态

    static int iCharEncodeType = 0;//设备字符集


    public void login() {
        //注册
        HCNetSDK.NET_DVR_USER_LOGIN_INFO mStrLoginInfo = new HCNetSDK.NET_DVR_USER_LOGIN_INFO();//设备登录信息

        String m_sDeviceIP = "192.168.100.105";//设备ip地址
        mStrLoginInfo.sDeviceAddress = new byte[HCNetSDK.NET_DVR_DEV_ADDRESS_MAX_LEN];
        System.arraycopy(m_sDeviceIP.getBytes(), 0, mStrLoginInfo.sDeviceAddress, 0, m_sDeviceIP.length());

        String m_sUsername = "admin";//设备用户名
        mStrLoginInfo.sUserName = new byte[HCNetSDK.NET_DVR_LOGIN_USERNAME_MAX_LEN];
        System.arraycopy(m_sUsername.getBytes(), 0, mStrLoginInfo.sUserName, 0, m_sUsername.length());

        String m_sPassword = "ybwl1234";//设备密码
        mStrLoginInfo.sPassword = new byte[HCNetSDK.NET_DVR_LOGIN_PASSWD_MAX_LEN];
        System.arraycopy(m_sPassword.getBytes(), 0, mStrLoginInfo.sPassword, 0, m_sPassword.length());

        mStrLoginInfo.wPort = 8000;
        mStrLoginInfo.bUseAsynLogin = false; //是否异步登录：0- 否，1- 是
        mStrLoginInfo.write();

        HCNetSDK.NET_DVR_DEVICEINFO_V40 mStrDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();//设备信息
        lUserID = hCNetSDK.NET_DVR_Login_V40(mStrLoginInfo, mStrDeviceInfo);
        if (lUserID == -1) {
            System.out.println("登录失败，错误码为" + hCNetSDK.NET_DVR_GetLastError());
        } else {
            System.out.println("登录成功！");
            iCharEncodeType = mStrDeviceInfo.byCharEncodeType;
        }
    }

    public void getOneCard(String strCardNo) {
        HCNetSDK.NET_DVR_CARD_COND struCardCond = new HCNetSDK.NET_DVR_CARD_COND();
        struCardCond.read();
        struCardCond.dwSize = struCardCond.size();
        struCardCond.dwCardNum = 1; //查询一个卡参数
        struCardCond.write();
        Pointer ptrStruCond = struCardCond.getPointer();

        m_lSetCardCfgHandle = hCNetSDK.NET_DVR_StartRemoteConfig(lUserID, HCNetSDK.NET_DVR_GET_CARD, ptrStruCond, struCardCond.size(), null, null);
        if (m_lSetCardCfgHandle == -1) {
            System.out.println("建立查询卡参数长连接失败，错误码为" + hCNetSDK.NET_DVR_GetLastError());
            return;
        } else {
            System.out.println("建立查询卡参数长连接成功！");
        }

        //查找指定卡号的参数，需要下发查找的卡号条件
        HCNetSDK.NET_DVR_CARD_SEND_DATA struCardNo = new HCNetSDK.NET_DVR_CARD_SEND_DATA();
        struCardNo.read();
        struCardNo.dwSize = struCardNo.size();

        for (int i = 0; i < HCNetSDK.ACS_CARD_NO_LEN; i++) {
            struCardNo.byCardNo[i] = 0;
        }
        for (int i = 0; i < strCardNo.length(); i++) {
            struCardNo.byCardNo[i] = strCardNo.getBytes()[i];
        }
        struCardNo.write();
        //用户记录
        HCNetSDK.NET_DVR_CARD_RECORD struCardRecord = new HCNetSDK.NET_DVR_CARD_RECORD();
        struCardRecord.read();

        HCNetSDK.NET_DVR_AUTH_INFO authInfo = new HCNetSDK.NET_DVR_AUTH_INFO();

        IntByReference pInt = new IntByReference(0);

        while (true) {
            dwState = hCNetSDK.NET_DVR_SendWithRecvRemoteConfig(m_lSetCardCfgHandle, struCardNo.getPointer(), struCardNo.size(),
                    struCardRecord.getPointer(), struCardRecord.size(), pInt);
            struCardRecord.read();
            if (dwState == -1) {
                System.out.println("NET_DVR_SendWithRecvRemoteConfig查询卡参数调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_NEEDWAIT) {
                System.out.println("配置等待");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_FAILED) {
                System.out.println("获取卡参数失败, 卡号: " + strCardNo);
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_EXCEPTION) {
                System.out.println("获取卡参数异常, 卡号: " + strCardNo);
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_SUCCESS) {
                try {
                    String strName = "";
                    if ((iCharEncodeType == 0) || (iCharEncodeType == 1) || (iCharEncodeType == 2)) {
                        strName = new String(struCardRecord.byName, "GBK").trim();
                    }

                    if (iCharEncodeType == 6) {
                        strName = new String(struCardRecord.byName, StandardCharsets.UTF_8).trim();
                    }

                    System.out.println("获取卡参数成功, 卡号: " + new String(struCardRecord.byCardNo).trim()
                            + ", 卡类型：" + struCardRecord.byCardType
                            + ", 姓名：" + strName);
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_FINISH) {
                System.out.println("获取卡参数完成");
                break;
            }
        }

        if (!hCNetSDK.NET_DVR_StopRemoteConfig(m_lSetCardCfgHandle)) {
            System.out.println("NET_DVR_StopRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
        } else {
            System.out.println("NET_DVR_StopRemoteConfig接口成功");
        }
    }

    public void setCartTemplate(int iPlanTemplateNumber) {
        int iErr = 0;

        //设置卡权限计划模板参数
        HCNetSDK.NET_DVR_PLAN_TEMPLATE_COND struPlanCond = new HCNetSDK.NET_DVR_PLAN_TEMPLATE_COND();
        struPlanCond.dwSize = struPlanCond.size();
        struPlanCond.dwPlanTemplateNumber = iPlanTemplateNumber;//计划模板编号，从1开始，最大值从门禁能力集获取
        struPlanCond.wLocalControllerID = 0;//就地控制器序号[1,64]，0表示门禁主机
        struPlanCond.write();

        HCNetSDK.NET_DVR_PLAN_TEMPLATE struPlanTemCfg = new HCNetSDK.NET_DVR_PLAN_TEMPLATE();
        struPlanTemCfg.dwSize = struPlanTemCfg.size();
        struPlanTemCfg.byEnable = 1; //是否使能：0- 否，1- 是
        struPlanTemCfg.dwWeekPlanNo = 1;//周计划编号，0表示无效
        struPlanTemCfg.dwHolidayGroupNo[0] = 0;//假日组编号，按值表示，采用紧凑型排列，中间遇到0则后续无效

        byte[] byTemplateName;
        try {
            byTemplateName = "计划模板名称测试".getBytes("GBK");
            //计划模板名称
            for (int i = 0; i < HCNetSDK.NAME_LEN; i++) {
                struPlanTemCfg.byTemplateName[i] = 0;
            }
            System.arraycopy(byTemplateName, 0, struPlanTemCfg.byTemplateName, 0, byTemplateName.length);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        struPlanTemCfg.write();

        IntByReference pInt = new IntByReference(0);
        Pointer lpStatusList = pInt.getPointer();

        if (!hCNetSDK.NET_DVR_SetDeviceConfig(lUserID, HCNetSDK.NET_DVR_SET_CARD_RIGHT_PLAN_TEMPLATE_V50, 1, struPlanCond.getPointer(), struPlanCond.size(), lpStatusList, struPlanTemCfg.getPointer(), struPlanTemCfg.size())) {
            iErr = hCNetSDK.NET_DVR_GetLastError();
            System.out.println("NET_DVR_SET_CARD_RIGHT_PLAN_TEMPLATE_V50失败，错误号：" + iErr);
            return;
        }
        System.out.println("NET_DVR_SET_CARD_RIGHT_PLAN_TEMPLATE_V50成功！");

        //获取卡权限周计划参数
        HCNetSDK.NET_DVR_WEEK_PLAN_COND struWeekPlanCond = new HCNetSDK.NET_DVR_WEEK_PLAN_COND();
        struWeekPlanCond.dwSize = struWeekPlanCond.size();
        struWeekPlanCond.dwWeekPlanNumber = 1;
        struWeekPlanCond.wLocalControllerID = 0;

        HCNetSDK.NET_DVR_WEEK_PLAN_CFG struWeekPlanCfg = new HCNetSDK.NET_DVR_WEEK_PLAN_CFG();

        struWeekPlanCond.write();
        struWeekPlanCfg.write();

        Pointer lpCond = struWeekPlanCond.getPointer();
        Pointer lpInbuferCfg = struWeekPlanCfg.getPointer();

        if (!hCNetSDK.NET_DVR_GetDeviceConfig(lUserID, HCNetSDK.NET_DVR_GET_CARD_RIGHT_WEEK_PLAN_V50, 1, lpCond, struWeekPlanCond.size(), lpStatusList, lpInbuferCfg, struWeekPlanCfg.size())) {
            iErr = hCNetSDK.NET_DVR_GetLastError();
            System.out.println("NET_DVR_GET_CARD_RIGHT_WEEK_PLAN_V50失败，错误号：" + iErr);
            return;
        }
        struWeekPlanCfg.read();

        struWeekPlanCfg.byEnable = 1; //是否使能：0- 否，1- 是

        //避免时间段交叉，先初始化
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[j].byEnable = 0;
                struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[j].struTimeSegment.struBeginTime.byHour = 0;
                struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[j].struTimeSegment.struBeginTime.byMinute = 0;
                struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[j].struTimeSegment.struBeginTime.bySecond = 0;
                struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[j].struTimeSegment.struEndTime.byHour = 0;
                struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[j].struTimeSegment.struEndTime.byMinute = 0;
                struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[j].struTimeSegment.struEndTime.bySecond = 0;
            }
        }

        //一周7天，全天24小时
        for (int i = 0; i < 7; i++) {
            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].byEnable = 1;
            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struBeginTime.byHour = 0;
            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struBeginTime.byMinute = 0;
            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struBeginTime.bySecond = 0;
            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struEndTime.byHour = 24;
            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struEndTime.byMinute = 0;
            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struEndTime.bySecond = 0;
        }

        //一周7天，每天设置2个时间段
	    /*for(int i=0;i<7;i++)
	    {
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].byEnable = 1;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struBeginTime.byHour = 0;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struBeginTime.byMinute = 0;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struBeginTime.bySecond = 0;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struEndTime.byHour = 11;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struEndTime.byMinute = 59;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[0].struTimeSegment.struEndTime.bySecond = 59;

	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[1].byEnable = 1;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[1].struTimeSegment.struBeginTime.byHour = 13;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[1].struTimeSegment.struBeginTime.byMinute = 30;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[1].struTimeSegment.struBeginTime.bySecond = 0;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[1].struTimeSegment.struEndTime.byHour = 19;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[1].struTimeSegment.struEndTime.byMinute = 59;
	            struWeekPlanCfg.struPlanCfg[i].struPlanCfgDay[1].struTimeSegment.struEndTime.bySecond = 59;
	    }*/
        struWeekPlanCfg.write();

        //设置卡权限周计划参数
        if (!hCNetSDK.NET_DVR_SetDeviceConfig(lUserID, HCNetSDK.NET_DVR_SET_CARD_RIGHT_WEEK_PLAN_V50, 1, lpCond, struWeekPlanCond.size(), lpStatusList, lpInbuferCfg, struWeekPlanCfg.size())) {
            iErr = hCNetSDK.NET_DVR_GetLastError();
            System.out.println("NET_DVR_SET_CARD_RIGHT_WEEK_PLAN_V50失败，错误号：" + iErr);
            return;
        }
        System.out.println("NET_DVR_SET_CARD_RIGHT_WEEK_PLAN_V50成功！");
    }

    public void getAllCard() {
        HCNetSDK.NET_DVR_CARD_COND struCardCond = new HCNetSDK.NET_DVR_CARD_COND();
        struCardCond.read();
        struCardCond.dwSize = struCardCond.size();
        struCardCond.dwCardNum = 0xffffffff; //查询所有
        struCardCond.write();
        Pointer ptrStruCond = struCardCond.getPointer();
        //添加成员到门禁
        m_lSetCardCfgHandle = hCNetSDK.NET_DVR_StartRemoteConfig(lUserID, HCNetSDK.NET_DVR_GET_CARD, ptrStruCond, struCardCond.size(), null, null);
        if (m_lSetCardCfgHandle == -1) {
            System.out.println("建立下发卡长连接失败，错误码为" + hCNetSDK.NET_DVR_GetLastError());
            return;
        } else {
            System.out.println("建立下发卡长连接成功！");
        }

        HCNetSDK.NET_DVR_CARD_RECORD struCardRecord = new HCNetSDK.NET_DVR_CARD_RECORD();
        struCardRecord.read();
        struCardRecord.dwSize = struCardRecord.size();
        struCardRecord.write();

        IntByReference pInt = new IntByReference(0);

        while (true) {
            dwState = hCNetSDK.NET_DVR_GetNextRemoteConfig(m_lSetCardCfgHandle, struCardRecord.getPointer(), struCardRecord.size());
            struCardRecord.read();
            if (dwState == -1) {
                System.out.println("NET_DVR_SendWithRecvRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_NEEDWAIT) {
                System.out.println("配置等待");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_FAILED) {
                System.out.println("获取卡参数失败");
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_EXCEPTION) {
                System.out.println("获取卡参数异常");
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_SUCCESS) {
                try {

                    String strName = "";
                    if ((iCharEncodeType == 0) || (iCharEncodeType == 1) || (iCharEncodeType == 2)) {
                        strName = new String(struCardRecord.byName, "GBK").trim();
                    }

                    if (iCharEncodeType == 6) {
                        strName = new String(struCardRecord.byName, StandardCharsets.UTF_8).trim();
                    }

                    System.out.println("获取卡参数成功, 卡号: " + new String(struCardRecord.byCardNo).trim()
                            + ", 卡类型：" + struCardRecord.byCardType
                            + ", 姓名：" + strName);
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_FINISH) {
                System.out.println("获取卡参数完成");
                break;
            }
        }

        if (!hCNetSDK.NET_DVR_StopRemoteConfig(m_lSetCardCfgHandle)) {
            System.out.println("NET_DVR_StopRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
        } else {
            System.out.println("NET_DVR_StopRemoteConfig接口成功");
        }

    }

    public void setOneCard(String strCardNo, short wPlanTemplateNumber) throws UnsupportedEncodingException, InterruptedException {
        HCNetSDK.NET_DVR_CARD_COND struCardCond = new HCNetSDK.NET_DVR_CARD_COND();
        struCardCond.read();
        struCardCond.dwSize = struCardCond.size();
        struCardCond.dwCardNum = 1;  //下发一张
        struCardCond.write();
        Pointer ptrStruCond = struCardCond.getPointer();

        m_lSetCardCfgHandle = hCNetSDK.NET_DVR_StartRemoteConfig(lUserID, HCNetSDK.NET_DVR_SET_CARD, ptrStruCond, struCardCond.size(), null, null);
        if (m_lSetCardCfgHandle == -1) {
            System.out.println("建立下发卡长连接失败，错误码为" + hCNetSDK.NET_DVR_GetLastError());
            return;
        } else {
            System.out.println("建立下发卡长连接成功！");
        }

        HCNetSDK.NET_DVR_CARD_RECORD struCardRecord = new HCNetSDK.NET_DVR_CARD_RECORD();
        struCardRecord.read();
        struCardRecord.dwSize = struCardRecord.size();

        for (int i = 0; i < HCNetSDK.ACS_CARD_NO_LEN; i++) {
            struCardRecord.byCardNo[i] = 0;
        }
        for (int i = 0; i < strCardNo.length(); i++) {
            struCardRecord.byCardNo[i] = strCardNo.getBytes()[i];
        }

        struCardRecord.byCardType = 1; //普通卡
        struCardRecord.byLeaderCard = 0; //是否为首卡，0-否，1-是
        struCardRecord.byUserType = 0;
        struCardRecord.byDoorRight[0] = 1; //门1有权限
        struCardRecord.wCardRightPlan[0] = wPlanTemplateNumber;//关联门计划模板，使用了前面配置的计划模板

        struCardRecord.struValid.byEnable = 1;    //卡有效期使能，下面是卡有效期从2000-1-1 11:11:11到2030-1-1 11:11:11
        struCardRecord.struValid.struBeginTime.wYear = 2000;
        struCardRecord.struValid.struBeginTime.byMonth = 1;
        struCardRecord.struValid.struBeginTime.byDay = 1;
        struCardRecord.struValid.struBeginTime.byHour = 11;
        struCardRecord.struValid.struBeginTime.byMinute = 11;
        struCardRecord.struValid.struBeginTime.bySecond = 11;
        struCardRecord.struValid.struEndTime.wYear = 2030;
        struCardRecord.struValid.struEndTime.byMonth = 1;
        struCardRecord.struValid.struEndTime.byDay = 1;
        struCardRecord.struValid.struEndTime.byHour = 11;
        struCardRecord.struValid.struEndTime.byMinute = 11;
        struCardRecord.struValid.struEndTime.bySecond = 11;

        struCardRecord.dwEmployeeNo = 66611; //工号

        if ((iCharEncodeType == 0) || (iCharEncodeType == 1) || (iCharEncodeType == 2)) {
            byte[] strCardName = "赵六".getBytes("GBK");  //姓名
            for (int i = 0; i < HCNetSDK.NAME_LEN; i++) {
                struCardRecord.byName[i] = 0;
            }
            System.arraycopy(strCardName, 0, struCardRecord.byName, 0, strCardName.length);
        }

        if (iCharEncodeType == 6) {
            byte[] strCardName = "赵六".getBytes(StandardCharsets.UTF_8);  //姓名
            for (int i = 0; i < HCNetSDK.NAME_LEN; i++) {
                struCardRecord.byName[i] = 0;
            }
            System.arraycopy(strCardName, 0, struCardRecord.byName, 0, strCardName.length);
        }

        struCardRecord.write();

        HCNetSDK.NET_DVR_CARD_STATUS struCardStatus = new HCNetSDK.NET_DVR_CARD_STATUS();
        struCardStatus.read();
        struCardStatus.dwSize = struCardStatus.size();
        struCardStatus.write();

        IntByReference pInt = new IntByReference(0);

        while (true) {
            dwState = hCNetSDK.NET_DVR_SendWithRecvRemoteConfig(m_lSetCardCfgHandle, struCardRecord.getPointer(), struCardRecord.size(), struCardStatus.getPointer(), struCardStatus.size(), pInt);
            struCardStatus.read();
            if (dwState == -1) {
                System.out.println("NET_DVR_SendWithRecvRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_NEEDWAIT) {
                System.out.println("配置等待");
                Thread.sleep(10);
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_FAILED) {
                System.out.println("下发卡失败, 卡号: " + new String(struCardStatus.byCardNo).trim() + ", 错误码：" + struCardStatus.dwErrorCode);
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_EXCEPTION) {
                System.out.println("下发卡异常, 卡号: " + new String(struCardStatus.byCardNo).trim() + ", 错误码：" + struCardStatus.dwErrorCode);
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_SUCCESS) {
                if (struCardStatus.dwErrorCode != 0) {
                    System.out.println("下发卡成功,但是错误码" + struCardStatus.dwErrorCode + ", 卡号：" + new String(struCardStatus.byCardNo).trim());
                } else {
                    System.out.println("下发卡成功, 卡号: " + new String(struCardStatus.byCardNo).trim() + ", 状态：" + struCardStatus.byStatus);
                }
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_FINISH) {
                System.out.println("下发卡完成");
                break;
            }

        }

        if (!hCNetSDK.NET_DVR_StopRemoteConfig(m_lSetCardCfgHandle)) {
            System.out.println("NET_DVR_StopRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
        } else {
            System.out.println("NET_DVR_StopRemoteConfig接口成功");
        }

    }

    public void setOneFace(String strCardNo) throws InterruptedException {
        HCNetSDK.NET_DVR_FACE_COND struFaceCond = new HCNetSDK.NET_DVR_FACE_COND();
        struFaceCond.read();
        struFaceCond.dwSize = struFaceCond.size();
        struFaceCond.byCardNo = "9654321".getBytes();
        struFaceCond.dwFaceNum = 1;  //下发一张
        struFaceCond.dwEnableReaderNo = 1;//人脸读卡器编号
        struFaceCond.write();
        Pointer ptrStruFaceCond = struFaceCond.getPointer();

        m_lSetFaceCfgHandle = hCNetSDK.NET_DVR_StartRemoteConfig(lUserID, HCNetSDK.NET_DVR_SET_FACE, ptrStruFaceCond, struFaceCond.size(), null, null);
        if (m_lSetFaceCfgHandle == -1) {
            System.out.println("建立下发人脸长连接失败，错误码为" + hCNetSDK.NET_DVR_GetLastError());
            return;
        } else {
            System.out.println("建立下发人脸长连接成功！");
        }

        HCNetSDK.NET_DVR_FACE_RECORD struFaceRecord = new HCNetSDK.NET_DVR_FACE_RECORD();
        struFaceRecord.read();
        struFaceRecord.dwSize = struFaceRecord.size();

        for (int i = 0; i < HCNetSDK.ACS_CARD_NO_LEN; i++) {
            struFaceRecord.byCardNo[i] = 0;
        }
        for (int i = 0; i < strCardNo.length(); i++) {
            struFaceRecord.byCardNo[i] = strCardNo.getBytes()[i];
        }

        /*****************************************
         * 从本地文件里面读取JPEG图片二进制数据
         *****************************************/
        FileInputStream picfile = null;
        int picdataLength = 0;
        try {
            picfile = new FileInputStream(new File(System.getProperty("user.dir") + "\\lib\\face.jpg"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            picdataLength = picfile.available();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if (picdataLength < 0) {
            System.out.println("input file dataSize < 0");
            return;
        }

        HCNetSDK.BYTE_ARRAY ptrpicByte = new HCNetSDK.BYTE_ARRAY(picdataLength);
        try {
            picfile.read(ptrpicByte.byValue);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        ptrpicByte.write();
        struFaceRecord.dwFaceLen = picdataLength;
        struFaceRecord.pFaceBuffer = ptrpicByte.getPointer();

        struFaceRecord.write();


        HCNetSDK.NET_DVR_FACE_STATUS struFaceStatus = new HCNetSDK.NET_DVR_FACE_STATUS();
        struFaceStatus.read();
        struFaceStatus.dwSize = struFaceStatus.size();
        struFaceStatus.write();

        IntByReference pInt = new IntByReference(0);

        while (true) {
            dwFaceState = hCNetSDK.NET_DVR_SendWithRecvRemoteConfig(m_lSetFaceCfgHandle, struFaceRecord.getPointer(), struFaceRecord.size(), struFaceStatus.getPointer(), struFaceStatus.size(), pInt);
            struFaceStatus.read();
            if (dwFaceState == -1) {
                System.out.println("NET_DVR_SendWithRecvRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
                break;
            } else if (dwFaceState == HCNetSDK.NET_SDK_CONFIG_STATUS_NEEDWAIT) {
                System.out.println("配置等待");
                Thread.sleep(10);
            } else if (dwFaceState == HCNetSDK.NET_SDK_CONFIG_STATUS_FAILED) {
                System.out.println("下发人脸失败, 卡号: " + new String(struFaceStatus.byCardNo).trim() + ", 错误码：" + hCNetSDK.NET_DVR_GetLastError());
                break;
            } else if (dwFaceState == HCNetSDK.NET_SDK_CONFIG_STATUS_EXCEPTION) {
                System.out.println("下发卡异常, 卡号: " + new String(struFaceStatus.byCardNo).trim() + ", 错误码：" + hCNetSDK.NET_DVR_GetLastError());
                break;
            } else if (dwFaceState == HCNetSDK.NET_SDK_CONFIG_STATUS_SUCCESS) {
                if (struFaceStatus.byRecvStatus != 1) {
                    System.out.println("下发卡失败，人脸读卡器状态" + struFaceStatus.byRecvStatus + ", 卡号：" + new String(struFaceStatus.byCardNo).trim());
                    break;
                } else {
                    System.out.println("下发卡成功, 卡号: " + new String(struFaceStatus.byCardNo).trim() + ", 状态：" + struFaceStatus.byRecvStatus);
                }
            } else if (dwFaceState == HCNetSDK.NET_SDK_CONFIG_STATUS_FINISH) {
                System.out.println("下发人脸完成");
                break;
            }

        }

        if (!hCNetSDK.NET_DVR_StopRemoteConfig(m_lSetFaceCfgHandle)) {
            System.out.println("NET_DVR_StopRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
        } else {
            System.out.println("NET_DVR_StopRemoteConfig接口成功");
        }

    }

    public void delOneFace(String strCardNo) {
        HCNetSDK.NET_DVR_FACE_PARAM_CTRL struFaceDelCond = new HCNetSDK.NET_DVR_FACE_PARAM_CTRL();
        struFaceDelCond.dwSize = struFaceDelCond.size();
        struFaceDelCond.byMode = 0; //删除方式：0- 按卡号方式删除，1- 按读卡器删除

        struFaceDelCond.struProcessMode.setType(HCNetSDK.NET_DVR_FACE_PARAM_BYCARD.class);

        //需要删除人脸关联的卡号
        for (int i = 0; i < HCNetSDK.ACS_CARD_NO_LEN; i++) {
            struFaceDelCond.struProcessMode.struByCard.byCardNo[i] = 0;
        }
        System.arraycopy(strCardNo.getBytes(), 0, struFaceDelCond.struProcessMode.struByCard.byCardNo, 0, strCardNo.length());

        struFaceDelCond.struProcessMode.struByCard.byEnableCardReader[0] = 1; //读卡器
        struFaceDelCond.struProcessMode.struByCard.byFaceID[0] = 1; //人脸ID
        struFaceDelCond.write();

        Pointer ptrFaceDelCond = struFaceDelCond.getPointer();

        boolean bRet = hCNetSDK.NET_DVR_RemoteControl(lUserID, HCNetSDK.NET_DVR_DEL_FACE_PARAM_CFG, ptrFaceDelCond, struFaceDelCond.size());
        if (!bRet) {
            System.out.println("删除人脸失败，错误码为" + hCNetSDK.NET_DVR_GetLastError());
        } else {
            System.out.println("删除人脸成功！");
        }
    }

    public void DelOneCard(String strCardNo) throws InterruptedException {
        HCNetSDK.NET_DVR_CARD_COND struCardCond = new HCNetSDK.NET_DVR_CARD_COND();
        struCardCond.read();
        struCardCond.dwSize = struCardCond.size();
        struCardCond.dwCardNum = 1;  //下发一张
        struCardCond.write();
        Pointer ptrStruCond = struCardCond.getPointer();

        m_lSetCardCfgHandle = hCNetSDK.NET_DVR_StartRemoteConfig(lUserID, HCNetSDK.NET_DVR_DEL_CARD, ptrStruCond, struCardCond.size(), null, null);
        if (m_lSetCardCfgHandle == -1) {
            System.out.println("建立删除卡长连接失败，错误码为" + hCNetSDK.NET_DVR_GetLastError());
            return;
        } else {
            System.out.println("建立删除卡长连接成功！");
        }

        HCNetSDK.NET_DVR_CARD_SEND_DATA struCardData = new HCNetSDK.NET_DVR_CARD_SEND_DATA();
        struCardData.read();
        struCardData.dwSize = struCardData.size();

        for (int i = 0; i < HCNetSDK.ACS_CARD_NO_LEN; i++) {
            struCardData.byCardNo[i] = 0;
        }
        for (int i = 0; i < strCardNo.length(); i++) {
            struCardData.byCardNo[i] = strCardNo.getBytes()[i];
        }
        struCardData.write();

        HCNetSDK.NET_DVR_CARD_STATUS struCardStatus = new HCNetSDK.NET_DVR_CARD_STATUS();
        struCardStatus.read();
        struCardStatus.dwSize = struCardStatus.size();
        struCardStatus.write();

        IntByReference pInt = new IntByReference(0);

        while (true) {
            dwState = hCNetSDK.NET_DVR_SendWithRecvRemoteConfig(m_lSetCardCfgHandle, struCardData.getPointer(), struCardData.size(), struCardStatus.getPointer(), struCardStatus.size(), pInt);
            struCardStatus.read();
            if (dwState == -1) {
                System.out.println("NET_DVR_SendWithRecvRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_NEEDWAIT) {
                System.out.println("配置等待");
                Thread.sleep(10);
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_FAILED) {
                System.out.println("删除卡失败, 卡号: " + new String(struCardStatus.byCardNo).trim() + ", 错误码：" + struCardStatus.dwErrorCode);
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_EXCEPTION) {
                System.out.println("删除卡异常, 卡号: " + new String(struCardStatus.byCardNo).trim() + ", 错误码：" + struCardStatus.dwErrorCode);
                break;
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_SUCCESS) {
                if (struCardStatus.dwErrorCode != 0) {
                    System.out.println("删除卡成功,但是错误码" + struCardStatus.dwErrorCode + ", 卡号：" + new String(struCardStatus.byCardNo).trim());
                } else {
                    System.out.println("删除卡成功, 卡号: " + new String(struCardStatus.byCardNo).trim() + ", 状态：" + struCardStatus.byStatus);
                }
            } else if (dwState == HCNetSDK.NET_SDK_CONFIG_STATUS_FINISH) {
                System.out.println("删除卡完成");
                break;
            }

        }

        if (!hCNetSDK.NET_DVR_StopRemoteConfig(m_lSetCardCfgHandle)) {
            System.out.println("NET_DVR_StopRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
        } else {
            System.out.println("NET_DVR_StopRemoteConfig接口成功");
        }
    }

    /**
     * 调用设备事件
     */
    public void getDeviceCase() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse("20200609000000");   //开始时间
            endTime = sdf.parse("20200622220000");      //结束时间
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Map<String, String>> eventList = new ArrayList<>();

        Map<String, String> eventMap = new HashMap<>();// 储存事件信息的map
        // 调用获取设备事件长连接
        HCNetSDK.NET_DVR_ACS_EVENT_COND struAcsEventCond = new HCNetSDK.NET_DVR_ACS_EVENT_COND();
        struAcsEventCond.read();
        struAcsEventCond.dwSize = struAcsEventCond.size();
        struAcsEventCond.dwMajor = 5;// 5代表event事件
        struAcsEventCond.dwMinor = 0x4b;// 代表刷脸成功
        struAcsEventCond.struStartTime = getHkTime(startTime);// ****必须要
        struAcsEventCond.struEndTime = getHkTime(endTime);// ***必须要
        struAcsEventCond.write();

        Pointer ptrStruEventCond = struAcsEventCond.getPointer();
        lHandle = hCNetSDK.NET_DVR_StartRemoteConfig(lUserID, HCNetSDK.NET_DVR_GET_ACS_EVENT, ptrStruEventCond, struAcsEventCond.size(), null, null);
        if (lHandle == -1) {
            System.out.println("建立获取设备事件长连接失败，错误码为" + hCNetSDK.NET_DVR_GetLastError());
            return;
        } else {
            System.out.println("建立获取设备事件连接成功！" + lHandle);
        }
        // 获取设备详细事件开始
        HCNetSDK.NET_DVR_ACS_EVENT_CFG struEventCFG = new HCNetSDK.NET_DVR_ACS_EVENT_CFG();
        struEventCFG.read();
        struEventCFG.dwSize = struEventCFG.size();
        struEventCFG.write();
        while (true) {
            dwState = hCNetSDK.NET_DVR_GetNextRemoteConfig(lHandle, struEventCFG.getPointer(), struEventCFG.size());
            struEventCFG.read();
            if (dwState == -1) {
                System.out.println("NET_DVR_GetNextRemoteConfig接口调用失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
            } else if (dwState == HCNetSDK.NET_SDK_GET_NEXT_STATUS_NEED_WAIT) {
                // 配置等待
                System.out.println("==========配置等待==============");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (dwState == HCNetSDK.NET_SDK_GET_NEXT_STATUS_FAILED) {
                // 获取事件失败
                System.out.println("===============获取设备事件失败=======================");
                break;

            } else if (dwState == HCNetSDK.NET_SDK_GET_NEXT_STATUS_EXCEPTION) {
                // 获取事件异常
                System.out.println("===============获取设备事件异常=======================");
                break;
            } else if (dwState == HCNetSDK.NET_SDK_GET_NEXT_STATUS_SUCCESS) {
                // 获取设备事件成功
                eventMap = new HashMap<>(16);
                eventMap.put("employeeNo", new String(struEventCFG.struAcsEventInfo.byEmployeeNo, StandardCharsets.UTF_8).trim());
                System.out.println("employeeNo:" + new String(struEventCFG.struAcsEventInfo.byEmployeeNo, StandardCharsets.UTF_8).trim());

                eventMap.put("cardNo", new String(struEventCFG.struAcsEventInfo.byCardNo, StandardCharsets.UTF_8).trim());
                System.out.println("cardNo:" + new String(struEventCFG.struAcsEventInfo.byCardNo, StandardCharsets.UTF_8).trim());

                eventMap.put("struTime", struEventCFG.struTime.toString());
                HCNetSDK.NET_DVR_TIME struTime = struEventCFG.struTime;
                System.out.println("struTime:" + struTime.dwYear + struTime.dwMonth + struTime.dwDay + struTime.dwHour + struTime.dwMinute + struTime.dwSecond);
                System.out.println("-------------------------------------------------");
                eventList.add(eventMap);
            } else if (dwState == HCNetSDK.NET_SDK_GET_NEXT_STATUS_FINISH) {
                // 获取设备事件信息完成
                System.out.println("=============获取设备事件完成================");
                break;
            }
        }
    }


    //时间格式转换
    public static HCNetSDK.NET_DVR_TIME getHkTime(Date time) {
        HCNetSDK.NET_DVR_TIME structTime = new HCNetSDK.NET_DVR_TIME();
        String str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(time);
        String[] times = str.split("-");
        structTime.dwYear = Integer.parseInt(times[0]);
        structTime.dwMonth = Integer.parseInt(times[1]);
        structTime.dwDay = Integer.parseInt(times[2]);
        structTime.dwHour = Integer.parseInt(times[3]);
        structTime.dwMinute = Integer.parseInt(times[4]);
        structTime.dwSecond = Integer.parseInt(times[5]);
        return structTime;
    }


    public static void main(String[] args) throws InterruptedException {
        Test2 test = new Test2();
        hCNetSDK.NET_DVR_Init();

        test.login();                //登陆
        Thread.sleep(500);

        //查询所有卡参数
        test.getAllCard();

        //查询刷脸记录
        test.getDeviceCase();

//        test.SetCartTemplate(1); //计划模板配置
//        Thread.sleep(500);
//
//        test.getAllLog();
//
//        String strCardNo = "1234569";
//        test.SetOneCard(strCardNo, (short) 1);    //下发1张卡号，关联计划模板1
//
//        Thread.sleep(500);
//        test.GetOneCard(strCardNo); //查询指定卡参数
//
//        Thread.sleep(500);
//        test.SetOneFace(strCardNo);    //下发1张人脸
//
//        Thread.sleep(5000);
//
//        test.DelOneFace(strCardNo);  //删除人脸
//        Thread.sleep(1000);
//        test.DelOneCard(strCardNo);  //删除卡号
    }
}

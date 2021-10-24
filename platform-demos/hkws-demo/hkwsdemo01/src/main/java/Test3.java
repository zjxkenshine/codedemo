
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 海康 NVR
 * @author root
 */
public class Test3 {


    private static HCNetSDK hcNetSDK = HCNetSDK.INSTANCE;
    private int userId = -1;//用户句柄
    private int loadHandle = -1;//下载句柄

    static int lHandle = -1; //查找录像数据状态
    static int dwState = -1; //获取文件数据状态


    public void findVideoFiles (Date startTime, Date endTime, int channel){
        boolean initFlag = hcNetSDK.NET_DVR_Init();
        if (!initFlag) { //返回值为布尔值 fasle初始化失败

            System.out.println("海康sdk初始化失败!");
        }
        HCNetSDK.NET_DVR_DEVICEINFO_V30 deviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V30();
        String ip = "192.168.100.105";
        short port = 8000;
        String name = "admin";
        String password = "ybwl1234";
        userId = hcNetSDK.NET_DVR_Login_V30(ip, port, name, password, deviceInfo);
        if (userId == -1) {
            System.out.println("海康sdk登录失败!");
        }

        HCNetSDK.NET_DVR_FILECOND dvrFilecond = new HCNetSDK.NET_DVR_FILECOND();
        dvrFilecond.read();
        dvrFilecond.lChannel = channel;
        dvrFilecond.dwFileType = 0xff;
        dvrFilecond.dwIsLocked = 0xff;
        dvrFilecond.struStartTime = getHkTime(startTime);
        dvrFilecond.struStopTime = getHkTime(endTime);
        dvrFilecond.write();

        //查找录像文件
        lHandle = hcNetSDK.NET_DVR_FindFile_V30(userId, dvrFilecond);

        HCNetSDK.NET_DVR_FINDDATA_V30 dvrFinddataV30 = new HCNetSDK.NET_DVR_FINDDATA_V30();
        dvrFinddataV30.read();
        dvrFinddataV30.dwFileSize = dvrFinddataV30.size();
        dvrFinddataV30.write();

        while (true) {
            //获取文件信息
            dwState = hcNetSDK.NET_DVR_FindNextFile_V30(lHandle, dvrFinddataV30);
            dvrFinddataV30.read();
            if (dwState == -1) {
                System.out.println("NET_DVR_GetNextRemoteConfig接口调用失败，错误码：" + hcNetSDK.NET_DVR_GetLastError());
            } else if (dwState == HCNetSDK.NET_DVR_ISFINDING) {
                // 配置等待
                System.out.println("==========正在查找文件，请等待==============");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (dwState == HCNetSDK.NET_DVR_FILE_EXCEPTION) {
                // 获取事件异常
                System.out.println("===============查找文件时异常=======================");
                break;
            } else if (dwState == HCNetSDK.NET_DVR_FILE_SUCCESS) {

                String fileName = new String(dvrFinddataV30.sFileName, StandardCharsets.UTF_8).trim();
                System.out.println("文件名：" + fileName);

                HCNetSDK.NET_DVR_TIME struStartTime = dvrFinddataV30.struStartTime;
                String strStartTime = judgeSingleDigit(struStartTime.dwYear) +
                        judgeSingleDigit(struStartTime.dwMonth) +
                        judgeSingleDigit(struStartTime.dwDay) +
                        judgeSingleDigit(struStartTime.dwHour) +
                        judgeSingleDigit(struStartTime.dwMinute) +
                        judgeSingleDigit(struStartTime.dwSecond);
                System.out.println("文件开始时间：" +  strStartTime);

                HCNetSDK.NET_DVR_TIME struStopTime = dvrFinddataV30.struStopTime;
                String strStopTime = judgeSingleDigit(struStopTime.dwYear) +
                        judgeSingleDigit(struStopTime.dwMonth) +
                        judgeSingleDigit(struStopTime.dwDay) +
                        judgeSingleDigit(struStopTime.dwHour) +
                        judgeSingleDigit(struStopTime.dwMinute) +
                        judgeSingleDigit(struStopTime.dwSecond);
                System.out.println("文件开始时间：" + strStopTime);

            } else if (dwState == HCNetSDK.NET_DVR_NOMOREFILE) {
                // 获取设备事件信息完成
                System.out.println("=============没有更多的文件，查找结束================");
                break;
            }
        }
    }

    /**
     * 获取海康录像机格式的时间
     * @param time
     * @return
     */
    private HCNetSDK.NET_DVR_TIME getHkTime(Date time) {
        HCNetSDK.NET_DVR_TIME structTime = new HCNetSDK.NET_DVR_TIME();
        String str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(time);
        String[] times = str.split("-");
        structTime.dwYear = Integer.parseInt(times[0]);
        structTime.dwMonth = Integer.parseInt(times[1]);
        structTime.dwDay = Integer.parseInt(times[2]);
        structTime.dwHour = Integer.parseInt(times[3]);
        structTime.dwMinute =Integer.parseInt(times[4]);
        structTime.dwSecond = Integer.parseInt(times[5]);
        return structTime;
    }


    private static String judgeSingleDigit(int digit) {

        int length = (digit + "").length();

        if (digit < 10 && length == 1) {
            return "0" + digit;
        }
        return String.valueOf(digit);
    }



    public static void main(String[] args) throws UnsupportedEncodingException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date startTime =null;
        Date endTime = null;
        try {
            startTime = sdf.parse("20200623000000");   //开始时间
            endTime =   sdf.parse("20200623100000");      //结束时间
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Test3 test = new Test3();

        //回放通道33开始
        int channel = 33;
        test.findVideoFiles(startTime, endTime , channel);

    }
}

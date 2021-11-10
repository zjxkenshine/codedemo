package com.kenshine.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.kenshine.easyexcel.domain.User;
import com.kenshine.easyexcel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 16:36
 * @description：用户数据监听
 * @modified By：
 * @version: $
 */
@Slf4j
public class UserDataListener extends AnalysisEventListener<User> {

    private UserService userService;

    public UserDataListener(UserService userService) {
        this.userService = userService;
    }

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<User> list = new ArrayList<User>();

    @Override
    public void invoke(User data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        if (!CollectionUtils.isEmpty(list)) {
            userService.saveBatch(list);
        }
        log.info("存储数据库成功！");
    }

}

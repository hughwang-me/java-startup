package com.uwjx.springmvc.service;

import com.uwjx.springmvc.model.UserBasicInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserBasicInfoService {

    public UserBasicInfo get() throws InterruptedException {
        log.warn("开始处理获取用户基本信息");
        Thread.sleep(3000L);
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setId(1001L);
        userBasicInfo.setName("王欢");
        userBasicInfo.setScore(12.22);
        log.warn("获取用户基本信息完毕");
        return userBasicInfo;
    }
}

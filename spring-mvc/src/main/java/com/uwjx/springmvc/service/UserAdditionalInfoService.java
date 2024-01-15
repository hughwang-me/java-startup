package com.uwjx.springmvc.service;

import com.uwjx.springmvc.model.UserAdditionalInfo;
import com.uwjx.springmvc.model.UserBasicInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAdditionalInfoService {

    public UserAdditionalInfo get() throws InterruptedException {
        log.warn("开始处理获取用户附加信息");
        Thread.sleep(7000L);
        UserAdditionalInfo userAdditionalInfo = new UserAdditionalInfo();
        userAdditionalInfo.setAddress("江苏省昆山市玉山镇");
        userAdditionalInfo.setSchool("南星渎小学");
        userAdditionalInfo.setMoney(12.22);
        log.warn("获取用户附加信息完毕");
        return userAdditionalInfo;
    }
}

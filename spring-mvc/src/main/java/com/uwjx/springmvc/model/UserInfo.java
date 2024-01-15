package com.uwjx.springmvc.model;

import lombok.Data;

@Data
public class UserInfo {

    private UserBasicInfo basicInfo;
    private UserAdditionalInfo additionalInfo;
}

package com.uwjx.springmvc.editor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class DatePropertyEditor extends PropertyEditorSupport {

    private String DEFAULT_FORMAT = "yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        log.warn("DatePropertyEditor -> 执行转换");
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT);
        try {
            Date date = format.parse(text);
            setValue(date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

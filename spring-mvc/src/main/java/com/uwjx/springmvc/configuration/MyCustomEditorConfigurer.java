package com.uwjx.springmvc.configuration;

import com.uwjx.springmvc.editor.DatePropertyEditor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditor;
import java.util.Date;
import java.util.Map;

@Configuration
@Slf4j
public class MyCustomEditorConfigurer implements PropertyEditorRegistrar {

    @Autowired
    DatePropertyEditor datePropertyEditor;


    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        log.warn("注册自定义 DatePropertyEditor");
        registry.registerCustomEditor(String.class , datePropertyEditor);
    }
}

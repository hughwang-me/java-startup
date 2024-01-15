package com.uwjx.springmvc.converter;

import com.uwjx.springmvc.vo.BRequestVO;
import com.uwjx.springmvc.vo.ProductRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import static java.lang.Double.parseDouble;

@Slf4j
public class StringToBRequestConverter implements Converter<String  , BRequestVO> {

    @Override
    public BRequestVO convert(String source) {
        log.warn("StringToBRequestConverter convert()");
        if(!StringUtils.isEmpty(source)){
            BRequestVO bRequestVO = new BRequestVO();
            String[] arr = source.split(",");
            bRequestVO.setId(Long.parseLong(arr[0]));
            bRequestVO.setName(arr[1]);
            return bRequestVO;
        }

        log.warn("StringToBRequestConverter对象为空");
        return null;
    }
}

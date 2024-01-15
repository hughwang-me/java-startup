package com.uwjx.springmvc.converter;

import com.uwjx.springmvc.vo.BRequestVO;
import com.uwjx.springmvc.vo.ProductRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.ObjectUtils;

@Slf4j
public class MyConverter implements Converter<ProductRequestVO , BRequestVO> {

    @Override
    public BRequestVO convert(ProductRequestVO source) {
        log.warn("MyConverter convert()");
        if(!ObjectUtils.isEmpty(source)){
            BRequestVO bRequestVO = new BRequestVO();
            bRequestVO.setId(source.getId() + 1000);
            bRequestVO.setName(source.getName() + "王欢");
            return bRequestVO;
        }
        log.warn("MyConverter 对象为空");
        return null;
    }
}

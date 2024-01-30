package com.uwjx.springmvc.mapstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public class RunMapStruct {
    public static void main(String[] args) {
        Car car = new Car( "Morris", 5, CarType.BIG );

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );

        //then
        Assert.notNull(carDto , "为空");
//        assertThat( carDto.getMake() ).isEqualTo( "Morris" );
//        assertThat( carDto.getSeatCount() ).isEqualTo( 5 );
//        assertThat( carDto.getType() ).isEqualTo( "SEDAN" );
    }
}

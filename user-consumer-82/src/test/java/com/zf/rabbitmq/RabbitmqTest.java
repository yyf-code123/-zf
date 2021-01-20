/*
package com.zf.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitmqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void providerHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    @Test
    public void providerWork(){
        for(int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("work","workMessage"+i);
        }
    }

    @Test
    public void providerFanout(){
        for(int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("logs","","fanoutMessage"+i);
        }
    }

    @Test
    public void providerDirect(){     //路由全匹配
        rabbitTemplate.convertAndSend("logs_routing","info","directMessageInfo");
        rabbitTemplate.convertAndSend("logs_routing","error","directMessageError");

    }

    @Test
    public void providerTopics(){     //路由部分匹配
        rabbitTemplate.convertAndSend("logs_topics","user.info","topicsMessageInfo");
        rabbitTemplate.convertAndSend("logs_topics","abc.user.abc.error","topicsMessageError");

    }
}
*/

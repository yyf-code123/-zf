package com.zf.service.impl;

import com.rabbitmq.client.Channel;
import com.zf.entity.CommonResult;
import com.zf.entity.User;
import com.zf.dao.UserDao;
import com.zf.service.UserService;
import com.zf.util.SendNoteUtil;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Resource
    SendNoteUtil sendNoteUtil;

    @Resource
    RabbitTemplate rabbitTemplate;

    @Override
    public User findByUserPhone(String userPhone) {
        return userDao.findByUserPhone(userPhone);
    }

    @Resource
    RedisTemplate<String,Object> redisTemplate;


    @Override
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }


    @Override
    public Integer delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
            exchange = @Exchange(value = "logs_routing",type = "direct"),
            key = "register")
    })
    public void sendMessage(String phoneNum, Channel channel) throws IOException, TimeoutException {
        String template = "SMS_205612723";
        String phoneNumRegisterCode = sendNoteUtil.sendNoteMessgae(phoneNum, template);


        redisTemplate.opsForValue().set(phoneNum,phoneNumRegisterCode,60, TimeUnit.SECONDS);
        channel.close();
        System.out.println(phoneNumRegisterCode);
    }

    @Override
    public CommonResult<String> sendExchange(String phoneNum) {
        rabbitTemplate.convertAndSend("logs_routing","register",phoneNum);
        return new CommonResult<String>(200,"发送短信验证码成功！");
    }

    @Override
    public Object verifyCode(String phone, String code){

        return redisTemplate.opsForValue().get(phone);
    }

    @Override
    public String getUserNameById(Integer userId) {
        return userDao.getUserNameById(userId);
    }

    @Override
    public String getUserImageById(Integer userId) {
        return userDao.getUserImageById(userId);
    }
}

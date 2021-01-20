package com.zf.service;

import com.rabbitmq.client.Channel;
import com.zf.entity.CommonResult;
import com.zf.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface UserService {

    public User findOne(Integer id);

    public User save(User user);

    public Integer delete(Integer id);

    public void sendMessage(String phoneNum, Channel channel) throws IOException, TimeoutException;

    public CommonResult<String> sendExchange(String phoneNum);

    public User findByUserPhone(String userPhone);

    public Object verifyCode(String phone, String node);

    public String getUserNameById(Integer userId);

    public String getUserImageById(Integer userId);
}
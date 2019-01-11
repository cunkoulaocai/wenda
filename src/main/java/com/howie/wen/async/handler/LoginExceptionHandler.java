package com.howie.wen.async.handler;

import com.howie.wen.async.EventHandler;
import com.howie.wen.async.EventModel;
import com.howie.wen.async.EventType;
import com.howie.wen.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class LoginExceptionHandler implements EventHandler {

    @Autowired(required=false)
    @Qualifier("mailSender")
    MailSender mailSender;

    @Override
    public void doHandle(EventModel model) {
        // xxxx判断发现这个用户登陆异常
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", model.getExt("username"));
        mailSender.sendWithHTMLTemplate(model.getExt("email"), "登录提醒", "templates/mails/login_exception.html", map);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}
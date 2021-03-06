package com.howie.wen.async;

import java.util.List;

/**
 * @Author HowieLee
 * @Description //TODO 定义一个统一的接口
 * @Date 20:47 1/14/2019
 * @Param 
 * @return 
 **/
public interface EventHandler {

    void doHandle(EventModel model);
    //用来注册自己，宣布自己关注什么event
    List<EventType> getSupportEventTypes();
}

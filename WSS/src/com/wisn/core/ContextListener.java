package com.wisn.core;

import com.wisn.core.factory.HandleThreadFactory;
import com.wisn.core.factory.MessageQueueFactory;
import com.wisn.core.factory.SessionFactory;
import com.wisn.servlet.ConstAPI;
import com.wisn.utils.LogUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @author Wisn
 * 2016年9月30日   上午9:23:26
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sc) {
        initServerConfig(sc);
        initService();
        initTimer();
    }

    private void initServerConfig(ServletContextEvent sc) {
        String file = sc.getServletContext().getRealPath("/WEB-INF/config_user/log4jbackup.properties");
        if (file != null) {
//            PropertyConfigurator.configure(file);
        }
        LogUtils.initConfig();
        Config.intConfig(sc.getServletContext());
    }

    private void initTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (MessageQueueFactory.getInstance().MessageCount > Config.initEveryThreadMessage) {
                    HandleThreadFactory.getInstance().init().addThread();
                } else {
                    if (HandleThreadFactory.getInstance().currentThreadCount > Config.initHalfHandleThread) {
                        HandleThreadFactory.getInstance().removeThread();
                    }
                }
            }

        }, new Date(), 20000);
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        LogUtils.d("Stop  Message  Server!");
        //TODO  存储所有消息列队中的消息
        HandleThreadFactory.getInstance().init().removeAllThread();
    }

    public void initService() {
        try {
            HandleThreadFactory.getInstance().init().startService();
            LogUtils.d("HandleThread started!");
            SessionFactory.getInstance().init();
            LogUtils.d("SessionThread started!");
            MessageQueueFactory.getInstance().init();
            LogUtils.d("MessageThread started!");
            MessageEntrance server = new MessageEntrance(ConstAPI.WS_PORT);
            server.start();
            LogUtils.d("MessageEntrance started!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

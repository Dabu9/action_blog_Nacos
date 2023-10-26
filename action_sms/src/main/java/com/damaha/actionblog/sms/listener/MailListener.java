package com.damaha.actionblog.sms.listener;

import com.damaha.actionblog.sms.util.SendMailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 邮件监听器【用于发送邮件】
 *
 * @author 陌溪
 * @date 2020年10月6日10:09:30
 */
@Slf4j
@Component
public class MailListener {

    @Autowired
    private SendMailUtils sendMailUtils;

    /**
     * 如果队列action.email中存在数据，那么将调用下面的方法进行处理
     * @param map
     */
    @RabbitListener(queues = "action.email")
    public void sendMail(Map<String, String> map) {
        if (map != null) {
            sendMailUtils.sendEmail(
                    map.get("subject"),
                    map.get("receiver"),
                    map.get("text")
            );
        }
    }
}

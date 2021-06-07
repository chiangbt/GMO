package cn.geoportal.gmo.server.controller.mail;

import cn.geoportal.gmo.server.config.RabbitMqConfig;
import cn.geoportal.gmo.server.entity.MailLog;
import cn.geoportal.gmo.server.entity.common.PageResult;
import cn.geoportal.gmo.server.entity.common.RespBean;
import cn.geoportal.gmo.server.entity.mail.MailMessage;
import cn.geoportal.gmo.server.service.MailLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.controller.mail
 * @ClassName: ChatController
 * @Author: chiangbt@geoportal.cn
 * @Description: 在线聊天
 * @Date: 2021/6/6 12:14
 */
@Api(tags = "11.Websocket发送信息")
@ApiSupport(order = 313)
@RestController
@RequestMapping("/api/send")
public class ChatController {

    private static Logger log = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MailLogService mailLogService;

    /**
     * 发送消息
     *
     * @param msg 消息内容
     * @return
     */
    @ApiOperation(value = "发送消息")
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public boolean send(String msg) {
        try {
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.BINDING_KEY_1, msg);
        } catch (AmqpException e) {
            log.error("发送消息1异常：{}", e);
            return false;
        }
        return true;
    }

    @ApiOperation(value = "发送邮件")
    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public boolean send2(@RequestBody MailMessage mailMessage) {
        try {
            MailMessage emailSend = new MailMessage(mailMessage.getTo(), mailMessage.getContent(), LocalDateTime.now().toString());

            // 保存到日志表
            MailLog mailLog = new MailLog();
            mailLog.setMailto(mailMessage.getTo());
            mailLog.setContent(mailMessage.getContent());
            mailLogService.save(mailLog);

            // 向RabbitMQ发送消息序列，以用于邮件发送
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.BINDING_KEY_2, emailSend);
        } catch (AmqpException e) {
            log.error("发送消息2异常：{}", e);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @ApiOperation(value = "客户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页号", required = true, example = "1"),
            @ApiImplicitParam(name="pageSize", value = "批次数量", required = true, example = "15"),
            @ApiImplicitParam(name = "query",value = "名称", required = false, example = "")
    })
    @RequestMapping(value = "/maillist", method = RequestMethod.GET)
    public RespBean getMailLog(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                               @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize,
                               @RequestParam(value="query", defaultValue = "") String query){
        // 翻页参数包装器
        QueryWrapper<MailLog> wrapper = new QueryWrapper<>();
        wrapper.like("mailto", query).or().like("content", query);
        wrapper.orderByDesc("id");
        // 翻页对象
        Page<MailLog> ipage = new Page<>(pageNo, pageSize);
        try{
            IPage<MailLog> users = mailLogService.selectPage(ipage, wrapper);
            PageResult<?> pageResult = new PageResult<MailLog>(
                    users.getCurrent(),
                    users.getSize(),
                    users.getTotal(),
                    users.getRecords());

            return RespBean.success("获取成功", pageResult);
        }catch (Exception e){
            return RespBean.error("无数据");
        }
    }
}

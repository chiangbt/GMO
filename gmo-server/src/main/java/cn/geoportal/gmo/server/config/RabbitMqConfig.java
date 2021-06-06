package cn.geoportal.gmo.server.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.config
 * @ClassName: RabbitMqConfig
 * @Author: chiangbt@geoportal.cn
 * @Description: RabbitMQ配置
 * @Date: 2021/6/6 12:24
 */
@Configuration
public class RabbitMqConfig {
    /**
     * 交换机名称
     */
    public static final String EXCHANGE_NAME = "gmo.topic";

    /**
     * 绑定键1
     */
    public static final String BINDING_KEY_1 = "topic.key1";

    /**
     * 绑定键2
     */
    public static final String BINDING_KEY_2 = "topic.key2";

    /**
     * 队列1名称
     */
    public static final String QUEUE_NAME_1 = "test1.queue";

    /**
     * 队列2名称
     */
    public static final String QUEUE_NAME_2 = "mail.queue";

    /**
     * 配置Direct交换机
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    /**
     * 配置队列1
     *
     * @return
     */
    @Bean
    public Queue test1Queue() {
        return new Queue(QUEUE_NAME_1);
    }

    /**
     * 配置队列2
     *
     * @return
     */
    @Bean
    public Queue test2Queue() {
        return new Queue(QUEUE_NAME_2);
    }

    /**
     * 将队列1与交换机通过绑定键1绑定
     *
     * @return
     */
    @Bean
    public Binding bindingQueue1() {
        return BindingBuilder.bind(test1Queue()).to(topicExchange()).with(BINDING_KEY_1);
    }

    /**
     * 将队列2与交换机通过绑定键前缀绑定
     *
     * @return
     */
    @Bean
    public Binding bindingQueue2() {
        return BindingBuilder.bind(test2Queue()).to(topicExchange()).with(BINDING_KEY_2);
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}

package com.toxic.job.template;

//import com.alibaba.dubbo.common.utils.StringUtils;
//import com.reapal.core.cache.service.JedisLockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 白云鹏 on 2017/3/28.
 */
@Component
public abstract class QuartzTemplate {
//    @Autowired
//    private JedisLockService jedisLockService;
    public static final Logger logger = LoggerFactory.getLogger(QuartzTemplate.class);
    public static final int defLockDuration = 60000;

    public void executeQuartz(CallBack callBack) {
        String lockKey = callBack.getLockKey();
        String describe = callBack.getDescribe();
        int duration = callBack.getLockDuration();
//        if (StringUtils.isNotEmpty(lockKey)) {
//            boolean lock = true;
//            try {
//                lock = jedisLockService.lock(lockKey, 0, duration);
//            } catch (Exception e) {
//                logger.info("[RBException] - [{}] - [{}] - {}", lockKey, describe, "reids 分布式锁加锁，出现异常", e);
//            }
//            if (lock) {
                try {
                    long current = System.currentTimeMillis();
                    logger.info("[RBRequestParameter] - [{}] - {} - {}", lockKey, describe, "任务开始执行");
                    callBack.execute();
                    logger.info("[RBResponseParameter] - [{}] - [{}] - duration:[{}] - {}", lockKey, describe, System.currentTimeMillis() - current, "任务执行结束");
                } catch (Exception e) {
                    logger.info("[RBException] - [{}] - [{}] - {}", lockKey, describe, "任务执行失败，出现异常", e);
                } finally {
                    try {
//                        jedisLockService.unlock(lockKey);
                    } catch (Exception e) {
                        logger.info("[RBException] - [{}] - [{}] - {}", lockKey, describe, "reids 分布式锁解锁，出现异常", e);
                    }
                }
            }
//            else {
//                logger.info(" [{}] - {} - {}", lockKey, describe, "任务正在执行中");
//            }
//        }
//    }


}

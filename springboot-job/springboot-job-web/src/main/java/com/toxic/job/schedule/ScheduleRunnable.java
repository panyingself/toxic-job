package com.toxic.job.schedule;

import com.toxic.job.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * 执行定时任务
 *
 */
public class ScheduleRunnable implements Runnable {

	private Logger logger = LoggerFactory.getLogger(ScheduleRunnable.class.getName());

	private Object target;
	private Method method;
	private String params;

	public ScheduleRunnable(String beanName, String methodName, String params) throws NoSuchMethodException, SecurityException {
		this.target = SpringContextUtils.getBean(beanName);
		this.params = params;

//		if(StringUtils.isEmpty(params)){
//			this.method = target.getClass().getDeclaredMethod(methodName, String.class);
//		}else{
			this.method = target.getClass().getDeclaredMethod(methodName);
//		}
	}
	public void run() {
		try {
			ReflectionUtils.makeAccessible(method);
//			if(StringUtils.isEmpty(params)){
//				method.invoke(target, params);
//			}else{
				method.invoke(target);
//			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}

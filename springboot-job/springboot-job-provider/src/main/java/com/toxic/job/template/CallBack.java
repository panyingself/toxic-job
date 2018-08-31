package com.toxic.job.template;

/**
 * Created by 白云鹏 on 2017/3/28.
 */
public interface CallBack {
    public void execute();

    /**
     * 获取分布式锁的key
     *
     * @return
     */
    public String getLockKey();

    /**
     * 获取分布式锁的时长
     *
     * @return
     */
    public int getLockDuration();


    /**
     * 获取描述信息
     * @return
     */
    public String getDescribe();
}

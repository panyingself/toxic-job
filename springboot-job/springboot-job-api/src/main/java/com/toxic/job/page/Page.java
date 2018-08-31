package com.toxic.job.page;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public class Page<T> implements Serializable {

    public Page() {

    }

    public Page(Integer current, Integer size) {
        setCurrent(current);
        setSize(size);
    }

    private static final long serialVersionUID = 6796929191028325317L;
    private int current = 1;

    private int size = 10;

    private int pages;

    private long total;

    private List<T> records;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        PageInfo<T> pageInfo = new PageInfo<T>(records);
        setTotal(pageInfo.getTotal());
        setSize(pageInfo.getPageSize());
        setCurrent(pageInfo.getPageNum());
        setPages(pageInfo.getPages());
        this.records = pageInfo.getList();
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}

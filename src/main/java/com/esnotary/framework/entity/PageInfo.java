package com.esnotary.framework.entity;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 分页实体类
 */
public class PageInfo<T> implements Serializable {

    private int pageNo;     // 页码从1开始
    private int pageSize;   // 每页多少条数据
    private long totalCount; // 总条数
    private int totalPages; // 总页数

    private List<T> result = new ArrayList();//列表数据

    public PageInfo(int pageNo, int pageSize, int totalCount, int totalPages, List<T> result) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.result = result;
    }

    public PageInfo(List<T> list){
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNo = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.totalPages = page.getPages();
            this.totalCount = page.getTotal();
            this.result = page.getResult();
        }else if (list instanceof Collection){
            this.pageNo = 1;
            this.pageSize = list.size();
            this.totalPages = this.pageSize > 0 ? 1 : 0;
            this.totalCount = list.size();
            this.result = list;
        }
    }

    public PageInfo() {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}

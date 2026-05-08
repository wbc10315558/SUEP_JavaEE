package com.demo.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private long current;

    /**
     * 每页显示条数
     */
    private long size;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 数据列表
     */
    private List<T> records;

    /**
     * 是否有下一页
     */
    private boolean hasNext;

    /**
     * 是否有上一页
     */
    private boolean hasPrevious;

    public PageResult() {
    }

    public PageResult(long current, long size, long total, long pages, List<T> records) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.pages = pages;
        this.records = records;
        this.hasNext = current < pages;
        this.hasPrevious = current > 1;
    }

    /**
     * 从 MyBatis-Plus 的 IPage 转换
     */
    public static <T> PageResult<T> of(IPage<T> page) {
        return new PageResult<>(
                page.getCurrent(),
                page.getSize(),
                page.getTotal(),
                page.getPages(),
                page.getRecords()
        );
    }

    /**
     * 构建空分页结果
     */
    public static <T> PageResult<T> empty() {
        return new PageResult<>(1, 10, 0, 0, List.of());
    }
}
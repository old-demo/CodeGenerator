package com.heqing.util;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 分页帮助类
 *
 * @author $!{authorName}
 * @email  $!{authorEmail}
 * @date   $!{createTime}
 */
public class PageInfoUtil<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * pageNum 当前页
     */
    @JSONField(name="page_num")
    private int pageNum;

    /**
     * pageSize 每页的数量
     */
    @JSONField(name="page_size")
    private int pageSize;

    /**
     * total 总记录数
     */
    @JSONField(name="total")
    private long total;

    /**
     * pages 总页数
     */
    @JSONField(name="pages")
    private int pages;

    /**
     * list 结果集
     */
    @JSONField(name="list")
    private List<T> list;

    /**
     * isFirstPage 是否为第一页
     */
    @JSONField(name="is_first_page")
    private boolean isFirstPage = false;

    /**
     * isLastPage 是否为最后一页
     */
    @JSONField(name="is_last_page")
    private boolean isLastPage = false;

    /**
     * 包装Page对象
     *
     * @param list 数据
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param total 总数
     */
    public PageInfoUtil(List list, int pageNum, int pageSize, long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
        this.pages = ((int)total/pageSize) + (total%pageSize==0 ? 0 : 1);

        judgePageBoudary();
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

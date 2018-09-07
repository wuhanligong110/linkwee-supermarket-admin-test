package com.linkwee.web.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分页请求
 * @author Administrator
 */
public class PageRequest implements Request {

    private static final long serialVersionUID = 3822254586637939558L;

    @NotNull
    @Min(1)
    private int pageNo = 1;

    @NotNull
    @Min(1)
    private int pageSize = 10;

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
}

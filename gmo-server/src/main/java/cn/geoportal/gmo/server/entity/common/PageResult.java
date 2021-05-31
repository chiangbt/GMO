package cn.geoportal.gmo.server.entity.common;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
/**
 * @ProjectName: gmo
 * @Package: cn.geoportal.gmo.server.entity.common
 * @ClassName: PageResult
 * @Author: chiangbt@geoportal.cn
 * @Description: 翻页返回对象
 * @Date: 2021/5/31 10:04
 */
public class PageResult<T> {

    @ApiModelProperty(value = "当前页码")
    @JSONField(ordinal = 0)
    private long pageNo = 1;// 页码，默认是第一页

    @ApiModelProperty(value = "每页记录数")
    @JSONField(ordinal = 1)
    private long pageSize = 3;// 每页显示的记录数，默认是15

    @ApiModelProperty(value = "总记录数")
    @JSONField(ordinal = 2)
    private long total;// 总记录数

    @ApiModelProperty(value = "总页数")
    @JSONField(ordinal = 3)
    private long totalPage;// 总页数

    @ApiModelProperty(value = "记录数组")
    @JSONField(ordinal = 4)
    private List<T> records;

    private long offset = 0;// 偏移量，当前页起始记录数
    private long limit = 15;

    private boolean count = true;

    public PageResult(long pageNo, long pageSize, long total, List<T> records) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        this.setRecords(records);
        int totalPage = (int) (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
        this.setTotalPage(totalPage);
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public void setOffset(int offset) {
        this.offset = (this.pageNo - 1) * pageSize;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalRecord=" + total + ", totalPage="
                + totalPage + ", records=" + records + "]";
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
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
        int totalPage = (int) (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
        this.setTotalPage(totalPage);
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}

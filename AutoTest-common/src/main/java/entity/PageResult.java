package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname PageResult
 * @Date 2019/8/27 21:58
 * @Created by StevenZsh
 * @Description 分页结果类
 */
public class PageResult implements Serializable {

    private long total; // 总记录数
    private List rows;  // 当前页记录

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRow() {
        return rows;
    }

    public void setRow(List row) {
        this.rows = row;
    }
}

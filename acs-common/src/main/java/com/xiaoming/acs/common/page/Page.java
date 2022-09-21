package com.xiaoming.acs.common.page;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanming03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> implements Serializable {

    /**
     * 页码
     */
    private int pageNo;

    /**
     * 数据总条数
     */
    private long total;

    /**
     * 分页数据列表
     */
    private List<T> dataList;

}

package com.lstfight.portal.auth;

/**
 * 数据源接口 说明数据源应该提供的方法实现
 * @author lst
 */
public interface DataSource {
    /**
     *
     * @return
     */
    int findByNameAndPassWord();
}

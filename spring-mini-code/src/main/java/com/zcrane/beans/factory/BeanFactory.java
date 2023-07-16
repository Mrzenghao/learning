package com.zcrane.beans.factory;

/**
 * bean容器
 *
 * @author zcrane
 * @date 2023年07月16日 20:35
 */
public interface BeanFactory {

    /**
     * 获取bean
     *
     * @param name
     * @return
     * @throws BeanException bean不存在时报异常
     */
    Object getBean(String name) throws BeanException;
}

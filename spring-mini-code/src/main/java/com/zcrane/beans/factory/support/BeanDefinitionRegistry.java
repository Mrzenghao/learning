package com.zcrane.beans.factory.support;

import com.zcrane.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 *
 * @author zcrane
 * @date 2023年07月16日 21:41
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 beanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

package com.zcrane.beans.factory.support;

import com.zcrane.beans.factory.BeanException;
import com.zcrane.beans.factory.config.BeanDefinition;

/**
 * Bean的实例化策略
 *
 * @author zcrane
 * @date 2023年07月16日 22:33
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeanException;

}

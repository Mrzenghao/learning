package com.zcrane.beans.factory.support;

import com.zcrane.beans.factory.BeanException;
import com.zcrane.beans.factory.config.BeanDefinition;

/**
 * @author zcrane
 * @date 2023年07月16日 21:53
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        return doCreateBean(name, beanDefinition);
    }

    private Object doCreateBean(String name, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            bean = beanClass.newInstance();
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed", e);
        }
        addSingleton(name, beanDefinition);
        return bean;
    }

}

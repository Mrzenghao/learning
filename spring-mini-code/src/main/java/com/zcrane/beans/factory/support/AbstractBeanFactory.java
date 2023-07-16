package com.zcrane.beans.factory.support;

import com.zcrane.beans.factory.BeanException;
import com.zcrane.beans.factory.BeanFactory;
import com.zcrane.beans.factory.config.BeanDefinition;

/**
 * @author zcrane
 * @date 2023年07月16日 21:36
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String name);

}

package com.zcrane.beans.factory.support;

import com.zcrane.beans.factory.BeanException;
import com.zcrane.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author zcrane
 * @date 2023年07月16日 22:35
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeanException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeanException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}

package com.zcrane.beans.factory.config;

/**
 * 单例注册表
 *
 * @author zcrane
 * @date 2023年07月16日 21:38
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}

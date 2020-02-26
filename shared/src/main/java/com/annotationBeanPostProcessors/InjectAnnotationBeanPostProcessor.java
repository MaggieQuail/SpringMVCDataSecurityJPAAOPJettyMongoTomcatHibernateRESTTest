package com.annotationBeanPostProcessors;

import com.interfaces.InjectAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.Instant;

public class InjectAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        long startTime = Instant.now().toEpochMilli();
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectAnnotation annot = field.getAnnotation(InjectAnnotation.class);
            if (annot != null) {
                System.out.println("BPP Before = ");
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, startTime);
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectAnnotation annot = field.getAnnotation(InjectAnnotation.class);
            if (annot != null) {
                System.out.println("BPP After = ");
            }
        }
        return bean;
    }
}

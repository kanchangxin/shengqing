package cn.qtone.util.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)   //用于构造方法
@Retention(RetentionPolicy.RUNTIME) //在运行时加载到Annotation到JVM中
public @interface ExportMethodAnnotation {
	String name() default "";
}

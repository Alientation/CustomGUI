package me.alientation.customgui.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ METHOD})
public @interface ButtonAnnotation {
	int height();
	int width();
	int x();
	int y();
}

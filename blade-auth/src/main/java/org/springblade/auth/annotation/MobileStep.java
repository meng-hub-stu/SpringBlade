package org.springblade.auth.annotation;

import org.springblade.auth.enums.MobileLoginStepEnum;

import java.lang.annotation.*;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MobileStep {
	MobileLoginStepEnum value();
}

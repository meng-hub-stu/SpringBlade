package org.springblade.auth.annotation;

import org.springblade.auth.enums.LoginTypeEnum;

import java.lang.annotation.*;

/**
 * @author Mengdl
 * @date 2021/09/17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {

	LoginTypeEnum value();

}

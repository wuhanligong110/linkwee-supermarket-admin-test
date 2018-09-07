package com.linkwee.annotaions;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @author Zhao Junjian
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface MyBatisRepository {
}

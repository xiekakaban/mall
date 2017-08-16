package com.statestr.mall.util.test;

import com.statestr.mall.util.SecurityUtil;
import org.junit.Test;

/**
 * Created by e604845 on 8/12/2017.
 */
public class SecurityUtilOOCTest {

    @Test
    public void testEccryptMD5(){
        System.out.println(SecurityUtil.eccryptMD5("testuser"));
    }
}

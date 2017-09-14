package org.stenio.demo.impl;

import org.springframework.stereotype.Service;
import org.stenio.demo.api.TestService;

/**
 * Created by stenio on 2017/9/7.
 */

@Service("testService")
public class TestServiceImpl implements TestService{
    @Override
    public String test() {

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}

package com.udemy.backendninja.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestService{

    private static final Log LOG = LogFactory.getLog(TestService.class);


    public static void getLog(){
        LOG.info("Say hello from service" + TestService.class.getName());
    }
}

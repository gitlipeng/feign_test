package com.movitech.product.project.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller基类
 *
 * @author hawods
 * @version 2018-06-29
 */
public abstract class BaseController extends com.movitech.generics.framework.controller.BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}

package com.perfree.interceptor;

import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.perfree.model.LinkModel;
import com.perfree.service.LinkService;

import java.util.List;

/**
 * @Author Perfree
 * @Date 2019/3/26 18:22
 */
public class LinkAddonInterceptor implements Interceptor {

    @Inject
    private LinkService linkService;

    @Override
    public void intercept(Invocation invocation) {
        List<LinkModel> allLink = linkService.getAllLink();
        invocation.getController().setAttr("links",allLink);
        invocation.invoke();
    }
}

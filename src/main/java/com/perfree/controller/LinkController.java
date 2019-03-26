package com.perfree.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.perfree.service.LinkService;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jpress.core.menu.annotation.AdminMenu;
import io.jpress.web.base.AdminControllerBase;

/**
 * @Author Perfree
 * @Date 2019/3/26 11:51
 */
@RequestMapping(value = "/perfreeLink",viewPath = "/")
public class LinkController extends AdminControllerBase {

    @Inject
    private LinkService linkService;

    @ActionKey("/admin/perfreeLink")
    @AdminMenu(groupId = "perfreeLink", text = "友链管理",order = 1)
    public void index() {
        render("perfreeLink/index.html");
    }

    @ActionKey("/admin/perfreeLink/add")
    @AdminMenu(groupId = "perfreeLink", text = "新建",order = 2)
    public void add() {
        render("perfreeLink/add.html");
    }
}

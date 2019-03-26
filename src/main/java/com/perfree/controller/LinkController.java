package com.perfree.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.perfree.model.LinkModel;
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
    @AdminMenu(groupId = "perfreeLink", text = "友链管理")
    public void index() {
        LinkModel linkModel = new LinkModel();
        linkModel.set("name","测试").set("link","测试").set("desc","测试").set("imgUrl","测试");
        linkService.addLink(linkModel);
        render("perfreeLink/index.html");
    }
}

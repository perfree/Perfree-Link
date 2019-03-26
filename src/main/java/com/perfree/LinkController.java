package com.perfree;

import com.jfinal.core.ActionKey;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jpress.core.menu.annotation.AdminMenu;
import io.jpress.web.base.AdminControllerBase;

/**
 * @Author Perfree
 * @Date 2019/3/26 11:51
 */
@RequestMapping(value = "/perfreeLink",viewPath = "/")
public class LinkController extends AdminControllerBase {

    @ActionKey("/admin/perfreeLink")
    @AdminMenu(groupId = "perfreeLink", text = "友链管理")
    public void index() {
        render("perfreeLink/index.html");
    }
}

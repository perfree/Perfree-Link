package com.perfree.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.perfree.model.LinkModel;
import com.perfree.service.LinkService;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jpress.core.menu.annotation.AdminMenu;
import io.jpress.model.User;
import io.jpress.web.base.AdminControllerBase;

import java.util.Set;

/**
 * @Author Perfree
 * @Date 2019/3/26 11:51
 */
@RequestMapping(value = "/admin/perfreeLink",viewPath = "/")
public class LinkController extends AdminControllerBase {

    @Inject
    private LinkService linkService;

    /**
     * 友链管理页面
     */
    @AdminMenu(groupId = "perfreeLink", text = "友链管理",order = 1)
    public void index() {
        Page<LinkModel> page = linkService.paginate(getPagePara(), 10,
                getPara("name"),
                getPara("link"));
        setAttr("page", page);
        render("perfreeLink/index.html");
    }

    /**
     * 新建友链页面
     */
    @AdminMenu(groupId = "perfreeLink", text = "新建",order = 2)
    public void add() {
        render("perfreeLink/add.html");
    }

    /**
     * 删除友链
     */
    public void doLinkDel(){
        linkService.deleteById(getIdPara());
        renderOkJson();
    }

    /**
     * 批量删除友链
     */
    public void doLinkDelByIds(){
        Set<String> idsSet = getParaSet("ids");
        render(linkService.deleteByIds(idsSet.toArray()) ? OK : FAIL);
    }

    /**
     * 友链详情
     */
    public void detail(){
        Long id = getParaToLong();
        LinkModel link = linkService.findById(id);
        setAttr("link", link);
        render("perfreeLink/detail.html");
    }

    /**
     * 增加友链
     * @param linkModel
     */
    public void doAdd(LinkModel linkModel){
        if (linkModel.getStr("name") == null) {
            renderJson(Ret.fail().set("message", "网站名字不能为空").set("errorCode", 3));
            return;
        }
        if (linkModel.getStr("link") == null) {
            renderJson(Ret.fail().set("message", "网站地址不能为空").set("errorCode", 4));
            return;
        }
        if (linkModel.getStr("desc") == null) {
            renderJson(Ret.fail().set("message", "网站描述不能为空").set("errorCode", 5));
            return;
        }
        if (linkModel.getStr("imgUrl") == null) {
            renderJson(Ret.fail().set("message", "网站logo图片地址不能为空").set("errorCode", 6));
            return;
        }
        if(linkService.add(linkModel)){
            renderOkJson();
            return;
        }
        renderJson(Ret.fail().set("message", "保存失败").set("errorCode", 7));
    }

    /**
     * 更新/编辑友链
     * @param linkModel
     */
    public void doEdit(LinkModel linkModel){
        if (linkModel.getStr("name") == null) {
            renderJson(Ret.fail().set("message", "网站名字不能为空").set("errorCode", 3));
            return;
        }
        if (linkModel.getStr("link") == null) {
            renderJson(Ret.fail().set("message", "网站地址不能为空").set("errorCode", 4));
            return;
        }
        if (linkModel.getStr("desc") == null) {
            renderJson(Ret.fail().set("message", "网站描述不能为空").set("errorCode", 5));
            return;
        }
        if (linkModel.getStr("imgUrl") == null) {
            renderJson(Ret.fail().set("message", "网站logo图片地址不能为空").set("errorCode", 6));
            return;
        }
        if(linkService.edit(linkModel)){
            renderOkJson();
            return;
        }
        renderJson(Ret.fail().set("message", "更新失败").set("errorCode", 7));
    }
}

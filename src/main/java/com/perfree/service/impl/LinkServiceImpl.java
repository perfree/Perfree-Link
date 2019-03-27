package com.perfree.service.impl;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.perfree.model.LinkModel;
import com.perfree.service.LinkService;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.service.JbootServiceBase;
import io.jpress.commons.utils.SqlUtils;

import java.util.List;

/**
 * @Author Perfree
 * @Date 2019/3/26 18:26
 */
@Bean
public class LinkServiceImpl extends JbootServiceBase<LinkModel> implements LinkService {

    @Override
    public List<LinkModel> getAllLink() {
        return new LinkModel().findAll();
    }

    @Override
    public Page<LinkModel> paginate(int page, int pagesize, String name, String link) {
        Columns columns = Columns.create();
        columns.likeAppendPercent("name",name);
        columns.likeAppendPercent("link",link);
        return  DAO.paginateByColumns(page, pagesize, columns, "id desc");
    }

    @Override
    public boolean deleteById(Object id) {
        return new LinkModel().deleteById(id);
    }

    @Override
    public boolean deleteByIds(Object... ids) {
        return Db.update("delete from `perfree-link` where id in " + SqlUtils.buildInSqlPara(ids)) > 0;
    }

    @Override
    public LinkModel findById(Long id) {
        return new LinkModel().findById(id);
    }

    @Override
    public boolean add(LinkModel linkModel){
        return linkModel.save();
    }

    @Override
    public boolean edit(LinkModel linkModel) {
        return linkModel.update();
    }
}

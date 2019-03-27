package com.perfree.service;

import com.jfinal.plugin.activerecord.Page;
import com.perfree.model.LinkModel;

import java.util.List;

/**
 * @Author Perfree
 * @Date 2019/3/26 18:23
 */
public interface LinkService {

    /**
     * 获取所有友链
     * @return List<LinkModel>
     */
    List<LinkModel> getAllLink();

    /**
     * 分页友链
     * @param page
     * @param pagesize
     * @param name
     * @param link
     * @return Page<LinkModel>
     */
    Page<LinkModel> paginate(int page, int pagesize, String name, String link);

    /**
     * 根据id删除友链
     * @param id
     * @return boolean
     */
    boolean deleteById(Object id);

    /**
     * 批量删除友链
     * @param ids
     * @return boolean
     */
    boolean deleteByIds(Object... ids);

    /**
     * 根据id获取友链
     * @param id
     * @return LinkModel
     */
    LinkModel findById(Long id);

    /**
     * 增加友链
     * @param linkModel
     * @return boolean
     */
    boolean add(LinkModel linkModel);

    /**
     * 更新友链
     * @param linkModel
     * @return boolean
     */
    boolean edit(LinkModel linkModel);
}

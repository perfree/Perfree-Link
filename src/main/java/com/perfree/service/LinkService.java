package com.perfree.service;

import com.perfree.model.LinkModel;

import java.util.List;

/**
 * @Author Perfree
 * @Date 2019/3/26 18:23
 */
public interface LinkService {

    /**
     * 添加友链
     * @Author Perfree
     **/
    void addLink(LinkModel linkModel);

    /**
     * 获取所有友链
     * @Author Perfree
     **/
    List<LinkModel> getAllLink();
}

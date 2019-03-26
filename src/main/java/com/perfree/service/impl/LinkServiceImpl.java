package com.perfree.service.impl;

import com.perfree.model.LinkModel;
import com.perfree.service.LinkService;
import io.jboot.aop.annotation.Bean;

import java.util.List;

/**
 * @Author Perfree
 * @Date 2019/3/26 18:26
 */
@Bean
public class LinkServiceImpl implements LinkService {

    @Override
    public void addLink(LinkModel linkModel) {
        linkModel.save();
    }

    @Override
    public List<LinkModel> getAllLink() {
        return new LinkModel().findAll();
    }
}

package com.perfree.directive;

import com.jfinal.aop.Inject;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import com.perfree.model.LinkModel;
import com.perfree.service.LinkService;
import io.jboot.web.directive.annotation.JFinalDirective;
import io.jboot.web.directive.base.JbootDirectiveBase;

import java.util.List;

@JFinalDirective("perfreeLinks")
public class LinksDirective extends JbootDirectiveBase {

    @Inject
    private LinkService linkService;

    @Override
    public void onRender(Env env, Scope scope, Writer writer) {
        List<LinkModel> allLink = linkService.getAllLink();
        scope.setLocal("links", allLink);
        renderBody(env, scope, writer);
    }

    @Override
    public boolean hasEnd() {
        return true;
    }
}

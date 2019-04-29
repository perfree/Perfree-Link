package com.perfree.addon;

import com.jfinal.plugin.activerecord.Db;
import io.jpress.core.addon.Addon;
import io.jpress.core.addon.AddonInfo;
import io.jpress.core.menu.MenuGroup;
import io.jpress.core.menu.MenuManager;

/**
 * @Author Perfree
 * @Date 2019/3/26 11:52
 */
public class LinkAddon implements Addon {
    @Override
    public void onInstall(AddonInfo addonInfo) {
        //创建数据表perfree-link
        Db.update("CREATE TABLE `perfree-link`  (" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT," +
                "  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL," +
                "  `link` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL," +
                "  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL," +
                "  `imgUrl` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL," +
                "  PRIMARY KEY (`id`)" +
                ")");
    }

    @Override
    public void onUninstall(AddonInfo addonInfo) {
        //删除数据表perfree-link
        Db.update("DROP TABLE IF EXISTS `perfree-link`");
    }

    @Override
    public void onStart(AddonInfo addonInfo) {
        //添加菜单组
        MenuGroup menuGroup = new MenuGroup();
        menuGroup.setId("perfreeLink");
        menuGroup.setText("友情链接");
        menuGroup.setIcon("<i class='fa fa-fw fa-globe'></i>");
        menuGroup.setOrder(20);
        MenuManager.me().getModuleMenus().add(menuGroup);
    }

    @Override
    public void onStop(AddonInfo addonInfo) {
        //删除菜单组
        MenuManager.me().deleteMenuGroup("perfreeLink");
    }
}

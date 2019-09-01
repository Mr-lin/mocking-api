package com.mockst.mocking.model.menu;

import lombok.Data;

import java.util.List;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/28 20:43
 * @Description:
 */
@Data
public class TreeMenu {
    private String id;
    private String parentId;
    private String label;
    private List<TreeMenu> children;
}

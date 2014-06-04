package com.windrift.common.bean;

/**
 * Created by IntelliJ IDEA.
 * User: xuweigui
 * Date: 1/13/12
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Option {
    private Integer id;
    private Integer parentId;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package io.gitee.xjt2016;

import lombok.Data;

@Data
public class HiParam {

    private String name;

    private String alias;

    public HiParam(String name) {
        this.name = name;
    }

    public HiParam(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }
}

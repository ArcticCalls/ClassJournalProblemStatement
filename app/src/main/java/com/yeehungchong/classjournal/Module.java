package com.yeehungchong.classjournal;

import java.io.Serializable;

public class Module implements Serializable {
    private String module;


    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Module(String module) {
        this.module = module;
    }
}

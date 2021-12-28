package com.kenshine.aether.demo02;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 11:05
 * @description：存储库相关参数
 * @modified By：
 * @version: $
 */
@Data
public class Params {
    /**
     * jar包在maven仓库中的groupId
     */
    private String groupId;
    /**
     * jar包在maven仓库中的artifactId
     */
    private String artifactId;
    /**
     * jar包在maven仓库中的version
     */
    private String version;
    /**
     * 远程maven仓库的URL地址，默认使用bw30的远程maven-public库
     * http://ae.mvn.bw30.com/repository/maven-public/
     */
    private String repository="https://repo1.maven.org/maven2/";
    /**
     * 下载的jar包存放的目标地址，默认为./target/repo
     */
    private String target="temp";
    /**
     * 登录远程maven仓库的用户名，若远程仓库不需要权限，设为null，默认为null
     */
    private String username=null;
    /**
     * 登录远程maven仓库的密码，若远程仓库不需要权限，设为null，默认为null
     */
    private String password=null;

    public Params() {
        super();
    }



    public Params(String groupId, String artifactId) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
    }



    public Params(String groupId, String artifactId, String username,
                  String password) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.username = username;
        this.password = password;
    }



    public Params(String groupId, String artifactId, String version,
                  String repository, /*String target,*/ String username, String password) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.repository = repository;
        /*this.target = target;*/
        this.username = username;
        this.password = password;
    }



    public Params(String groupId, String artifactId, String version,
                  String username, String password) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.username = username;
        this.password = password;
    }


}

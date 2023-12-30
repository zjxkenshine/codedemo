-- Dataway 中的API
CREATE TABLE interface_info (
                                api_id          varchar(64)  NOT NULL COMMENT 'ID',
                                api_method      varchar(12)  NOT NULL COMMENT 'HttpMethod：GET、PUT、POST',
                                api_path        varchar(512) NOT NULL COMMENT '拦截路径',
                                api_status      varchar(4)   NOT NULL COMMENT '状态：-1-删除, 0-草稿，1-发布，2-有变更，3-禁用',
                                api_comment     varchar(255) NOT NULL COMMENT '注释',
                                api_type        varchar(24)  NOT NULL COMMENT '脚本类型：SQL、DataQL',
                                api_script      mediumtext   NOT NULL COMMENT '查询脚本：xxxxxxx',
                                api_schema      mediumtext   NOT NULL COMMENT '接口的请求/响应数据结构',
                                api_sample      mediumtext   NOT NULL COMMENT '请求/响应/请求头样本数据',
                                api_option      mediumtext   NOT NULL COMMENT '扩展配置信息',
                                api_create_time varchar(32)  NOT NULL COMMENT '创建时间',
                                api_gmt_time    varchar(32)  NOT NULL COMMENT '修改时间',
                                PRIMARY KEY (api_id),
                                UNIQUE KEY uk_interface_info (api_path)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Dataway 中的API';

-- Dataway API 发布历史
CREATE TABLE interface_release (
                                   pub_id           varchar(64)  NOT NULL COMMENT 'Publish ID',
                                   pub_api_id       varchar(64)  NOT NULL COMMENT '所属API ID',
                                   pub_method       varchar(12)  NOT NULL COMMENT 'HttpMethod：GET、PUT、POST',
                                   pub_path         varchar(512) NOT NULL COMMENT '拦截路径',
                                   pub_status       varchar(4)   NOT NULL COMMENT '状态：-1-删除, 0-草稿，1-发布，2-有变更，3-禁用',
                                   pub_comment      varchar(255) NOT NULL COMMENT '注释',
                                   pub_type         varchar(24)  NOT NULL COMMENT '脚本类型：SQL、DataQL',
                                   pub_script       mediumtext   NOT NULL COMMENT '查询脚本：xxxxxxx',
                                   pub_script_ori   mediumtext   NOT NULL COMMENT '原始查询脚本，仅当类型为SQL时不同',
                                   pub_schema       mediumtext   NOT NULL COMMENT '接口的请求/响应数据结构',
                                   pub_sample       mediumtext   NOT NULL COMMENT '请求/响应/请求头样本数据',
                                   pub_option       mediumtext   NOT NULL COMMENT '扩展配置信息',
                                   pub_release_time varchar(32)  NOT NULL COMMENT '发布时间（下线不更新）',
                                   PRIMARY KEY (pub_id),
                                   KEY idx_interface_release_api  (pub_api_id),
                                   KEY idx_interface_release_path (pub_path)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Dataway API 发布历史。';

-- 人员表，测试用
CREATE TABLE `person` (
                          `p_id` int DEFAULT NULL,
                          `p_name` varchar(100) DEFAULT NULL,
                          `p_phone` varchar(11) DEFAULT NULL,
                          `p_score` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='人员表';

-- 插入测试数据
INSERT INTO person (p_id,p_name,p_phone,p_score) VALUES
(1,'李阳','123456','7890'),
(2,'张骞','123456','7890'),
(3,'马康敬','123456','7890'),
(4,'尚世宇','123456','7890'),
(5,'赵题','123456','7890'),
(6,'王澳','123456','7890'),
(7,'张三','13611112222','100'),
(7,'张三','13611112222','100'),
(7,'张三','13611112222','100');
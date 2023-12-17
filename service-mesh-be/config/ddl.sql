DROP TABLE IF EXISTS svc_mesh_flow;
CREATE TABLE svc_mesh_flow(
                              id BigSERIAL NOT NULL,
                              uuid VARCHAR(40) NOT NULL,
                              code VARCHAR(30) NOT NULL,
                              name VARCHAR(50),
                              description VARCHAR(200),
                              tenant_id VARCHAR(40),
                              version VARCHAR(32),
                              create_by VARCHAR(40),
                              create_by_name VARCHAR(50),
                              create_time TIMESTAMP,
                              update_by VARCHAR(32),
                              update_by_name VARCHAR(50),
                              update_time TIMESTAMP,
                              PRIMARY KEY (id)
);

COMMENT ON TABLE svc_mesh_flow IS '流程表';
COMMENT ON COLUMN svc_mesh_flow.id IS '主鍵ID';
COMMENT ON COLUMN svc_mesh_flow.uuid IS '唯一標識';
COMMENT ON COLUMN svc_mesh_flow.code IS '編碼';
COMMENT ON COLUMN svc_mesh_flow.name IS '名稱';
COMMENT ON COLUMN svc_mesh_flow.description IS '描述';
COMMENT ON COLUMN svc_mesh_flow.tenant_id IS '租户号';
COMMENT ON COLUMN svc_mesh_flow.version IS '乐观锁';
COMMENT ON COLUMN svc_mesh_flow.create_by IS '創建人';
COMMENT ON COLUMN svc_mesh_flow.create_by_name IS '創建人姓名';
COMMENT ON COLUMN svc_mesh_flow.create_time IS '创建时间';
COMMENT ON COLUMN svc_mesh_flow.update_by IS '更新人';
COMMENT ON COLUMN svc_mesh_flow.update_by_name IS '更新人姓名';
COMMENT ON COLUMN svc_mesh_flow.update_time IS '更新时间';

DROP TABLE IF EXISTS svc_mesh_flow_invoke_log;
CREATE TABLE svc_mesh_flow_invoke_log(
                                         id BigSERIAL NOT NULL,
                                         flow_id bigint NOT NULL,
                                         source_ip VARCHAR(255),
                                         target_ip VARCHAR(255),
                                         request TEXT,
                                         response TEXT,
                                         log TEXT,
                                         status CHAR(1),
                                         tenant_id VARCHAR(40),
                                         version VARCHAR(32),
                                         create_by VARCHAR(40),
                                         create_by_name VARCHAR(50),
                                         create_time TIMESTAMP,
                                         update_by VARCHAR(32),
                                         update_by_name VARCHAR(50),
                                         update_time TIMESTAMP,
                                         PRIMARY KEY (id)
);

COMMENT ON TABLE svc_mesh_flow_invoke_log IS '服務調用記錄';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.id IS '主鍵ID';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.flow_id IS '服務流程ID';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.source_ip IS '調用方IP';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.target_ip IS '服務方IP';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.request IS '請求參數';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.response IS '響應';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.log IS '調用日誌';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.status IS '狀態 Y為成功， N為失敗';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.tenant_id IS '租户号';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.version IS '乐观锁';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.create_by IS '創建人';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.create_by_name IS '創建人姓名';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.create_time IS '创建时间';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.update_by IS '更新人';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.update_by_name IS '更新人姓名';
COMMENT ON COLUMN svc_mesh_flow_invoke_log.update_time IS '更新时间';

DROP TABLE IF EXISTS svc_mesh_flow_config;
CREATE TABLE svc_mesh_flow_config(
                                     id BigSERIAL NOT NULL,
                                     flow_id bigint NOT NULL,
                                     config TEXT,
                                     tenant_id VARCHAR(40),
                                     version VARCHAR(32),
                                     create_by VARCHAR(40),
                                     create_by_name VARCHAR(50),
                                     create_time TIMESTAMP,
                                     update_by VARCHAR(32),
                                     update_by_name VARCHAR(50),
                                     update_time TIMESTAMP,
                                     PRIMARY KEY (id)
);

COMMENT ON TABLE svc_mesh_flow_config IS '流程配置表';
COMMENT ON COLUMN svc_mesh_flow_config.id IS '主鍵';
COMMENT ON COLUMN svc_mesh_flow_config.flow_id IS '流程ID';
COMMENT ON COLUMN svc_mesh_flow_config.config IS '流程配置';
COMMENT ON COLUMN svc_mesh_flow_config.tenant_id IS '租户号';
COMMENT ON COLUMN svc_mesh_flow_config.version IS '乐观锁';
COMMENT ON COLUMN svc_mesh_flow_config.create_by IS '創建人';
COMMENT ON COLUMN svc_mesh_flow_config.create_by_name IS '創建人姓名';
COMMENT ON COLUMN svc_mesh_flow_config.create_time IS '创建时间';
COMMENT ON COLUMN svc_mesh_flow_config.update_by IS '更新人';
COMMENT ON COLUMN svc_mesh_flow_config.update_by_name IS '更新人姓名';
COMMENT ON COLUMN svc_mesh_flow_config.update_time IS '更新时间';

DROP TABLE IF EXISTS svc_mesh_flow_node;
CREATE TABLE svc_mesh_flow_node(
                                   id BigSERIAL NOT NULL,
                                   flow_id bigint NOT NULL,
                                   node_id VARCHAR(100) NOT NULL,
                                   code VARCHAR(40) NOT NULL,
                                   node_type VARCHAR(10) NOT NULL,
                                   config VARCHAR(900),
                                   tenant_id VARCHAR(40),
                                   version VARCHAR(32),
                                   create_by VARCHAR(40),
                                   create_by_name VARCHAR(50),
                                   create_time TIMESTAMP,
                                   update_by VARCHAR(32),
                                   update_by_name VARCHAR(50),
                                   update_time TIMESTAMP,
                                   PRIMARY KEY (id)
);

COMMENT ON TABLE svc_mesh_flow_node IS '流程節點配置表';
COMMENT ON COLUMN svc_mesh_flow_node.id IS '主鍵';
COMMENT ON COLUMN svc_mesh_flow_node.flow_id IS '流程ID';
COMMENT ON COLUMN svc_mesh_flow_node.node_id IS '節點ID';
COMMENT ON COLUMN svc_mesh_flow_node.code IS '節點編碼';
COMMENT ON COLUMN svc_mesh_flow_node.node_type IS '節點類型，包括數據節點，轉換節點，判斷節點等';
COMMENT ON COLUMN svc_mesh_flow_node.config IS '節點配置json';
COMMENT ON COLUMN svc_mesh_flow_node.tenant_id IS '租户号';
COMMENT ON COLUMN svc_mesh_flow_node.version IS '乐观锁';
COMMENT ON COLUMN svc_mesh_flow_node.create_by IS '創建人';
COMMENT ON COLUMN svc_mesh_flow_node.create_by_name IS '創建人姓名';
COMMENT ON COLUMN svc_mesh_flow_node.create_time IS '创建时间';
COMMENT ON COLUMN svc_mesh_flow_node.update_by IS '更新人';
COMMENT ON COLUMN svc_mesh_flow_node.update_by_name IS '更新人姓名';
COMMENT ON COLUMN svc_mesh_flow_node.update_time IS '更新时间';

DROP TABLE IF EXISTS svc_mesh_datasource;
CREATE TABLE svc_mesh_datasource(
                                    id BigSERIAL NOT NULL,
                                    code VARCHAR(30) NOT NULL,
                                    name VARCHAR(255),
                                    type VARCHAR(10) NOT NULL,
                                    config TEXT,
                                    tenant_id VARCHAR(40),
                                    version VARCHAR(32),
                                    create_by VARCHAR(40),
                                    create_by_name VARCHAR(50),
                                    create_time TIMESTAMP,
                                    update_by VARCHAR(32),
                                    update_by_name VARCHAR(50),
                                    update_time TIMESTAMP,
                                    PRIMARY KEY (id)
);

COMMENT ON TABLE svc_mesh_datasource IS '數據源配置';
COMMENT ON COLUMN svc_mesh_datasource.id IS '主鍵ID';
COMMENT ON COLUMN svc_mesh_datasource.code IS '編碼';
COMMENT ON COLUMN svc_mesh_datasource.name IS '名稱';
COMMENT ON COLUMN svc_mesh_datasource.type IS '數據源類型';
COMMENT ON COLUMN svc_mesh_datasource.config IS '配置';
COMMENT ON COLUMN svc_mesh_datasource.tenant_id IS '租户号';
COMMENT ON COLUMN svc_mesh_datasource.version IS '乐观锁';
COMMENT ON COLUMN svc_mesh_datasource.create_by IS '創建人';
COMMENT ON COLUMN svc_mesh_datasource.create_by_name IS '創建人姓名';
COMMENT ON COLUMN svc_mesh_datasource.create_time IS '创建时间';
COMMENT ON COLUMN svc_mesh_datasource.update_by IS '更新人';
COMMENT ON COLUMN svc_mesh_datasource.update_by_name IS '更新人姓名';
COMMENT ON COLUMN svc_mesh_datasource.update_time IS '更新时间';

DROP TABLE IF EXISTS svc_mesh_service;
CREATE TABLE svc_mesh_service(
                                 id BigSERIAL NOT NULL,
                                 datasource_id bigint NOT NULL,
                                 code VARCHAR(30) NOT NULL,
                                 name VARCHAR(100),
                                 input_template TEXT,
                                 config TEXT,
                                 output_template TEXT,
                                 tenant_id VARCHAR(40),
                                 version VARCHAR(32),
                                 create_by VARCHAR(40),
                                 create_by_name VARCHAR(50),
                                 create_time TIMESTAMP,
                                 update_by VARCHAR(32),
                                 update_by_name VARCHAR(50),
                                 update_time TIMESTAMP,
                                 PRIMARY KEY (id)
);

COMMENT ON TABLE svc_mesh_service IS '服務配置';
COMMENT ON COLUMN svc_mesh_service.id IS '主鍵ID';
COMMENT ON COLUMN svc_mesh_service.datasource_id IS '數據源配置';
COMMENT ON COLUMN svc_mesh_service.code IS '編碼';
COMMENT ON COLUMN svc_mesh_service.name IS '名稱';
COMMENT ON COLUMN svc_mesh_service.input_template IS '請求模板';
COMMENT ON COLUMN svc_mesh_service.config IS '配置';
COMMENT ON COLUMN svc_mesh_service.output_template IS '輸出模板';
COMMENT ON COLUMN svc_mesh_service.tenant_id IS '租户号';
COMMENT ON COLUMN svc_mesh_service.version IS '乐观锁';
COMMENT ON COLUMN svc_mesh_service.create_by IS '創建人';
COMMENT ON COLUMN svc_mesh_service.create_by_name IS '創建人姓名';
COMMENT ON COLUMN svc_mesh_service.create_time IS '创建时间';
COMMENT ON COLUMN svc_mesh_service.update_by IS '更新人';
COMMENT ON COLUMN svc_mesh_service.update_by_name IS '更新人姓名';
COMMENT ON COLUMN svc_mesh_service.update_time IS '更新时间';


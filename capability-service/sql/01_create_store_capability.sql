-- STORE_CAPABILITY: capability-service bounded context
-- Aynı Oracle instance / store_app şeması (Backend B).

ALTER SESSION SET CONTAINER = FREEPDB1;

CREATE TABLE store_app.store_capability (
    store_id         NUMBER(19)    NOT NULL,
    capability_type  VARCHAR2(40)  NOT NULL,
    CONSTRAINT pk_store_capability PRIMARY KEY (store_id, capability_type),
    CONSTRAINT ck_capability_type CHECK (capability_type IN (
        'NEW_LINE', 'DEVICE_DELIVERY', 'DEVICE_REPAIR', 'NUMBER_PORT', 'BILL_PAYMENT'
    ))
);

CREATE INDEX store_app.idx_capability_type ON store_app.store_capability (capability_type);

COMMENT ON TABLE store_app.store_capability IS 'Bayi işlem yetkinlikleri — capability-service';

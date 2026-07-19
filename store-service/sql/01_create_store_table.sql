-- STORE: bayi master data (store-service bounded context)
-- gvenzl/oracle-free init script'leri SYS olarak CDB$ROOT'ta başlar.
-- Bu yüzden önce PDB'ye geçip APP_USER (store_app) şemasında tablo oluşturuyoruz.

ALTER SESSION SET CONTAINER = FREEPDB1;

CREATE TABLE store_app.store (
    id              NUMBER(19)       NOT NULL,
    name            VARCHAR2(150)    NOT NULL,
    address         VARCHAR2(255)    NOT NULL,
    city            VARCHAR2(80)     NOT NULL,
    district        VARCHAR2(80)     NOT NULL,
    latitude        NUMBER(10, 7)    NOT NULL,
    longitude       NUMBER(10, 7)    NOT NULL,
    type            VARCHAR2(20)     NOT NULL,
    phone           VARCHAR2(30),
    working_hours   VARCHAR2(120),
    status          VARCHAR2(20)     DEFAULT 'ACTIVE' NOT NULL,
    opens_weekend   NUMBER(1)        DEFAULT 1 NOT NULL,
    CONSTRAINT pk_store PRIMARY KEY (id),
    CONSTRAINT ck_store_type CHECK (type IN ('TIM', 'FRANCHISE')),
    CONSTRAINT ck_store_status CHECK (status IN ('ACTIVE', 'INACTIVE')),
    CONSTRAINT ck_store_weekend CHECK (opens_weekend IN (0, 1))
);

CREATE INDEX store_app.idx_store_city_district ON store_app.store (city, district);
CREATE INDEX store_app.idx_store_type ON store_app.store (type);
CREATE INDEX store_app.idx_store_status ON store_app.store (status);

COMMENT ON TABLE store_app.store IS 'Bayi master data — single source of truth (store-service)';
COMMENT ON COLUMN store_app.store.type IS 'TIM veya FRANCHISE';
COMMENT ON COLUMN store_app.store.status IS 'ACTIVE veya INACTIVE (Gün 7 filtre)';
COMMENT ON COLUMN store_app.store.opens_weekend IS '1 = hafta sonu açık (workingHours=weekend)';
COMMENT ON COLUMN store_app.store.latitude IS 'Harita pin enlemi';
COMMENT ON COLUMN store_app.store.longitude IS 'Harita pin boylamı';

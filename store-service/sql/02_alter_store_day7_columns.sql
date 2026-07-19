-- Mevcut volume'da STORE tablosu varsa Gün 7 kolonlarını ekler.
-- Taze kurulumda 01_create_store_table.sql zaten bu kolonları içerir; hata alırsanız yok sayın.

ALTER SESSION SET CONTAINER = FREEPDB1;

BEGIN
    EXECUTE IMMEDIATE 'ALTER TABLE store_app.store ADD status VARCHAR2(20) DEFAULT ''ACTIVE'' NOT NULL';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -1430 THEN RAISE; END IF; -- column already exists
END;
/

BEGIN
    EXECUTE IMMEDIATE 'ALTER TABLE store_app.store ADD opens_weekend NUMBER(1) DEFAULT 1 NOT NULL';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -1430 THEN RAISE; END IF;
END;
/

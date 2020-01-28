-- ----------------------------
-- Table structure for MerchantAddress
-- ----------------------------
DROP TABLE IF EXISTS "public"."merchant_address";
CREATE TABLE "public"."merchant_address" (
  "merchant_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "contact_gender" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "address_city" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "address_country" varchar(2) COLLATE "pg_catalog"."default" NOT NULL,
  "flg_had_first_sale" int NOT NULL
)
;

-- ----------------------------
-- Primary Key structure for table merchant_address
-- ----------------------------
ALTER TABLE "public"."merchant_address" ADD CONSTRAINT "PK__Merchant__04416434543349D434E" PRIMARY KEY ("merchant_id") WITH (fillfactor=95);



-- ----------------------------
-- Table structure for MerchantContract
-- ----------------------------
DROP TABLE IF EXISTS "public"."merchant_contract";
CREATE TABLE "public"."merchant_contract" (
  "merchant_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "contract_start_date" date NOT NULL,
  "contract_end_date" date NOT NULL,
  "contract_year" int NOT NULL,
  "flg_test_shop" int NOT NULL
)
;


-- ----------------------------
-- Primary Key structure for table MerchantContract
-- ----------------------------
ALTER TABLE "public"."merchant_contract" ADD CONSTRAINT "PK__Merchant__04443545165430AFECA44" PRIMARY KEY ("merchant_id") WITH (fillfactor=95);

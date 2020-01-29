-- ----------------------------
-- Table structure for merchant_address
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
-- Table structure for merchant_contract
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
-- Primary Key structure for table merchant_contract
-- ----------------------------
ALTER TABLE "public"."merchant_contract" ADD CONSTRAINT "PK__Merchant__04443545165430AFECA44" PRIMARY KEY ("merchant_id") WITH (fillfactor=95);



-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS "public"."orders";
CREATE TABLE "public"."orders" (
  "id" int4 NOT NULL,
  "order_no" varchar(255) COLLATE "pg_catalog"."default",
  "merchant_id" varchar(255) COLLATE "pg_catalog"."default",
  "order_volume" numeric(20,2) NOT NULL,
  "voucher_reduction" int4 NOT NULL,
  "order_status" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "order_created" timestamp(6),
  "order_shipped" timestamp(6),
  "order_paid" timestamp(6)
)
;

-- ----------------------------
-- Primary Key structure for table orders
-- ----------------------------
ALTER TABLE "public"."orders" ADD CONSTRAINT "PK__orders__04165430AFECA44" PRIMARY KEY ("id") WITH (fillfactor=95);


-- ----------------------------
-- Table structure for traffic
-- ----------------------------
DROP TABLE IF EXISTS "public"."traffic";
CREATE TABLE "public"."traffic" (
  "merchant_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "visit_date" date NOT NULL,
  "visits" int4,
  "pageviews" int4
)
;

-- ----------------------------
-- Primary Key structure for table traffic
-- ----------------------------
ALTER TABLE "public"."traffic" ADD CONSTRAINT "PK__traffic__04545165430AFECA44" PRIMARY KEY ("merchant_id", visit_date) WITH (fillfactor=95);
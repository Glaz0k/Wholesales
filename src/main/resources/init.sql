CREATE TABLE "goods" (
  "id" bigint PRIMARY KEY,
  "name" varchar,
  "priority" real
);

CREATE TABLE "sales" (
  "id" bigint PRIMARY KEY,
  "good_id" bigint,
  "good_count" bigint,
  "create_date" timestamp
);

CREATE TABLE "warehouses" (
  "id" bigint PRIMARY KEY
);

CREATE TABLE "entries" (
  "id" bigint PRIMARY KEY,
  "warehouse_id" bigint,
  "good_id" bigint,
  "good_count" bigint
);

ALTER TABLE "sales" ADD FOREIGN KEY ("good_id") REFERENCES "goods" ("id");

ALTER TABLE "entries" ADD FOREIGN KEY ("warehouse_id") REFERENCES "warehouses" ("id");

ALTER TABLE "entries" ADD FOREIGN KEY ("good_id") REFERENCES "goods" ("id");

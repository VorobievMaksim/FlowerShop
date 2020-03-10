CREATE TABLE IF NOT EXISTS "tb_users"(
"id" INT NOT NULL AUTO_INCREMENT,
"username" VARCHAR(255) NOT NULL UNIQUE,
"password" VARCHAR(255) NOT NULL,
"fullName" VARCHAR(255) NOT NULL,
"address" VARCHAR(255) NOT NULL,
"number" VARCHAR(255) NOT NULL,
"balance" DECIMAL(8,2) DEFAULT 0,
"discount" INT DEFAULT 0,
"role" VARCHAR(255) DEFAULT 'USER',
PRIMARY KEY("id"));

CREATE TABLE IF NOT EXISTS "tb_flowers" (
  "id" INT NOT NULL AUTO_INCREMENT,
  "name" VARCHAR(255) NOT NULL,
  "price" DECIMAL(6,2) NOT NULL,
  "description" TEXT,
  "quantity" INT,
  PRIMARY KEY("id"));

CREATE TABLE IF NOT EXISTS "tb_orders" (
  "id" INT AUTO_INCREMENT NOT NULL,
  "user_id" INT NOT NULL,
  "status" VARCHAR(255) NOT NULL,
  "created_date" TIMESTAMP NOT NULL,
  "closet_date" TIMESTAMP,
  PRIMARY KEY("id"),

  CONSTRAINT "f_user_id"
    FOREIGN KEY ("user_id")
    REFERENCES "tb_users" ("id")
    ON DELETE CASCADE
    ON UPDATE CASCADE );

CREATE TABLE IF NOT EXISTS "tb_order_flower" (
  "id" INT AUTO_INCREMENT NOT NULL,
  "order_id" INT NOT NULL,
  "flower_id" INT NOT NULL,
  "quantity" INT NOT NULL,
  PRIMARY KEY("id"),

  CONSTRAINT "f_order_id"
    FOREIGN KEY ("order_id")
    REFERENCES "tb_orders" ("id")
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT "f_flower_id"
    FOREIGN KEY ("flower_id")
    REFERENCES "tb_flowers" ("id")
    ON DELETE SET NULL
    ON UPDATE CASCADE);
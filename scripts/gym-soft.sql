CREATE TABLE "users" (
  "user_id" SERIAL PRIMARY KEY,
  "username" varchar NOT NULL,
  "password" varchar NOT NULL,
  "role" varchar NOT NULL,
  "enabled" bool DEFAULT TRUE,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "employees" (
  "employee_id" SERIAL PRIMARY KEY,
  "first_name" varchar NOT NULL,
  "last_name" varchar NOT NULL,
  "employee_type" varchar NOT NULL,
  "address" varchar NOT NULL,
  "email" varchar NOT NULL,
  "phone" varchar NOT NULL,
  "user_id" integer,
  "enabled" bool DEFAULT TRUE,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "clients" (
  "client_id" SERIAL PRIMARY KEY,
  "first_name" varchar NOT NULL,
  "last_name" varchar NOT NULL,
  "address" varchar NOT NULL,
  "email" varchar NOT NULL,
  "phone" varchar NOT NULL,
  "enabled" bool DEFAULT TRUE,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "memberships" (
  "membership_id" SERIAL PRIMARY KEY,
  "type" varchar NOT NULL,
  "description" varchar NOT NULL,
  "cost" float DEFAULT 0,
  "enabled" bool DEFAULT TRUE,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "clients_memberships" (
  "client_membership_id" SERIAL PRIMARY KEY,
  "client_id" integer,
  "membership_id" integer NOT NULL,
  "start_date" timestamp NOT NULL,
  "end_date" timestamp,
  "remaining_days" integer DEFAULT 0,
  "quantity" integer DEFAULT 0,
  "cost" float DEFAULT 0,
  "price" float DEFAULT 0,
  "enabled" bool DEFAULT TRUE,
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "entry_records" (
  "entry_record_id" SERIAL PRIMARY KEY,
  "client_membership_id" integer NOT NULL,
  "entry_date" timestamp
);

ALTER TABLE "employees" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");

ALTER TABLE "clients_memberships" ADD FOREIGN KEY ("client_id") REFERENCES "clients" ("client_id");

ALTER TABLE "clients_memberships" ADD FOREIGN KEY ("membership_id") REFERENCES "memberships" ("membership_id");

ALTER TABLE "entry_records" ADD FOREIGN KEY ("client_membership_id") REFERENCES "clients_memberships" ("client_membership_id");
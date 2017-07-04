-- Adminer 4.3.1 SQLite 3 dump

DROP TABLE IF EXISTS "card";
CREATE TABLE "card" (
  "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  "id_list" integer NOT NULL,
  "word_1" text NOT NULL,
  "word_2" text NOT NULL, "priority" integer NOT NULL DEFAULT '1',
  FOREIGN KEY ("id_list") REFERENCES "list" ("id") ON DELETE CASCADE
);


DROP TABLE IF EXISTS "list";
CREATE TABLE "list" (
  "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" text NOT NULL
);


--
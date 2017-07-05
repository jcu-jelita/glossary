-- Adminer 4.3.1 SQLite 3 dump

DROP TABLE IF EXISTS "card";
CREATE TABLE "card" (
  "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  "id_card_list" integer NOT NULL,
  "word_1" text NOT NULL,
  "word_2" text NOT NULL,
  "priority" integer NOT NULL DEFAULT '1',
  FOREIGN KEY ("id_card_list") REFERENCES "card_list" ("id"),
  FOREIGN KEY ("id_card_list") REFERENCES "list" ("id") ON DELETE CASCADE ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS "card_list";
CREATE TABLE "card_list" (
  "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" text NOT NULL
);


--
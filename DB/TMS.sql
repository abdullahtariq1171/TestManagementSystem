CREATE TABLE "users" ("id" VARCHAR(10) PRIMARY KEY  NOT NULL  UNIQUE , "name" VARCHAR(25) NOT NULL , "password" VARCHAR(25) NOT NULL   , "age" INTEGER, "is_male" BOOL DEFAULT true, "type" INTEGER NOT NULL  DEFAULT 0, "discipline" VARCHAR(25) DEFAULT CS)


CREATE  TABLE  IF NOT EXISTS "main"."course" (
"id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , "name" VARCHAR(25) NOT NULL  UNIQUE , "code" VARCHAR(10) NOT NULL  UNIQUE 
)
--correct
CREATE  TABLE  IF NOT EXISTS "main"."courses" (
 "name" VARCHAR(25) NOT NULL   UNIQUE , "code" VARCHAR(10) NOT NULL  UNIQUE ,
PRIMARY KEY (name,code)
)


CREATE TABLE course_user_relation("user_id" INTEGER  not null REFERENCES user(id),
 "course_id" INTEGER not null REFERENCES course(id), 
primary key (user_id, course_id)
 );

 --correct
 CREATE TABLE course_user_relations("user_id" INTEGER  not null REFERENCES users(id),
 "course_code" INTEGER not null REFERENCES courses(code), 
primary key (user_id, course_code)
 );
 
 INSERT INTO course_user_relation VALUES ( 1, 1);
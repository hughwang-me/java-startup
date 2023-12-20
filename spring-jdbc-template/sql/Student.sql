-- auto Generated on 2023-12-20
-- DROP TABLE IF EXISTS student;
CREATE TABLE student(
	id bigserial PRIMARY KEY NOT NULL,
	name varchar (50),
	age integer,
	height double precision,
	weight double precision
);


COMMENT ON COLUMN student.id IS 'id';
COMMENT ON COLUMN student.name IS '姓名';
COMMENT ON COLUMN student.age IS '年龄';
COMMENT ON COLUMN student.height IS '身高';
COMMENT ON COLUMN student.weight IS '体重';

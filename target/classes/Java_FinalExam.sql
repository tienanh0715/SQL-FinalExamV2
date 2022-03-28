-- CREATE DATABASE AND TABLE
DROP DATABASE IF EXISTS java_finalexam;
CREATE DATABASE java_finalexam;
USE java_finalexam;

CREATE TABLE `User`(
	id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	full_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE KEY NOT NULL,
    `password` VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    exp_in_year	TINYINT UNSIGNED,
    pro_skill	VARCHAR(50),
    project_id TINYINT UNSIGNED,
    `role` ENUM('Manager', 'Employee')
);

-- INSERT RECORDS
INSERT INTO `User` (id, full_name, email, `password`, exp_in_year, pro_skill, project_id, `role`)
VALUES 	(1, N'Vu Tien Anh', 'tienanh231@gmail.com', '1234ABCD', 2, null, 1, 'Manager'),
		(2, N'Pham Thi Hoa', 'hoapham@gmail.com', 'Hoapham123', null, 'DEV', 1, 'Employee'),
		(3, N'Nguyen Quoc Chien', 'chiennguyen@gmail.com', 'Quocchien', null, 'DEV', 1, 'Employee'),
		(4, N'Nguyen Quang Tuan', 'tuannguyen@gmail.com', 'NguyenTuan', null, 'JAVA', 1, 'Employee'),
		(5, N'Tran Van Huy', 'huytran@gmail.com', 'huyTran123', 3, null, 2, 'Manager'),
		(6, N'Hoang Thi Duyen', 'duyenhoang@gmail.com', 'Hoangduyen', null, 'JAVA', 2, 'Employee'),
		(7, N'Tran Quoc Bao', 'tranbao@gmail.com', 'Tranbaoxyz', null, 'PYTHON', 2, 'Employee');
CREATE DATABASE motel;
USE motel;

-- bang nguoi dung
CREATE TABLE users
(
	id INT(11) AUTO_INCREMENT,
    password VARCHAR(20) NOT NULL,
    name NVARCHAR(50) NOT NULL,
    birthday DATE,
    identification VARCHAR(20),
    phone VARCHAR(20) NOT NULL,
    hometown NVARCHAR(50),
    gender BIT,
    email VARCHAR(50),
    type_of_account INT DEFAULT 1 NOT NULL, 
    CONSTRAINT pk_users PRIMARY KEY (id)
);

-- bang loai nha
CREATE TABLE category
(
	id INT(11) AUTO_INCREMENT,
    name NVARCHAR(100) NOT NULL,
    description NVARCHAR(500),
    CONSTRAINT pk_category PRIMARY KEY (id)
);

-- bang nha
CREATE TABLE location
(
	id INT(11) AUTO_INCREMENT,
    county NVARCHAR(50),
    district NVARCHAR(50),
    street NVARCHAR(50),
	apartment_number NVARCHAR(50),
    CONSTRAINT pk_location PRIMARY KEY (id)
);

CREATE TABLE motel
(
	id INT(11) AUTO_INCREMENT,
    category_id INT,
    user_id INT,
    location_id INT,
    area INT NOT NULL,
    price FLOAT NOT NULL,
    description NVARCHAR(100) NOT NULL,
    electric_price FLOAT,
    internet_price FLOAT,
    water_price FLOAT,
    status INT,
    CONSTRAINT pk_motel PRIMARY KEY (id),
    CONSTRAINT fk_motel_category FOREIGN KEY (category_id) REFERENCES category(id),
    CONSTRAINT fk_motel_users FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_motel_location FOREIGN KEY (location_id) REFERENCES location(id)    
);


-- bang hinh anh nha
CREATE TABLE picture
(
	motel_id INT,
    url VARCHAR(50) NOT NULL,
    CONSTRAINT fk_picture_motel FOREIGN KEY (motel_id) REFERENCES motel(id)
);

INSERT INTO users(name,password,birthday,identification,phone,hometown,gender,email,type_of_account)
VALUES(N'Nguyễn Đăng Khoa','123','1997-11-10','168573209','0123456789',N'Bắc Ninh',1,'khoand@gmail.com',1);

INSERT INTO users(name,password,birthday,identification,phone,hometown,gender,email,type_of_account)
VALUES(N'Trần Trung Hiếu','123','1997-06-26','168570382','0974511405',N'Hà Nam',1,'hieutt@gmail.com',1);

-- -----------------------------------

INSERT INTO category VALUES (3,N'Nhà cấp I',N'Kết cấu chịu lực bằng bê tông cốt thép hoặc xây gạch có niên hạn sử dụng quy định trên 80 năm;
Bao che nhà và tường ngăn cách các phòng bằng bê tông cốt thép hoặc xây gạch;
Mái bằng bê tông cốt thép hoặc lợp ngói, có hệ thống cách nhiệt tốt;
Vật liệu hoàn thiện (trát, lát, ốp) trong và ngoài nhà tốt;
Tiện nghi sinh hoạt (bếp, xí, tắm, điện nước) đầy đủ, tiện lợi, không hạn chế số tầng;'),

(4,N'Nhà cấp II',N'Kết cấu chịu lực bằng bê tông cốt thép hoặc xây gạch có niên hạn sử dụng quy định trên 70 năm;
Bao che nhà và tường ngăn cách các phòng bằng bê tông cốt thép hoặc xây gạch;
Mái bằng bê tông cốt thép hoặc mái ngói bằng Fibroociment;
Vật liệu hoàn thiện trong ngoài nhà tương đối tốt;
Tiện nghi sinh hoạt đầy đủ. Số tầng không hạn chế.'),

(5,N'Nhà cấp III',N'Kết cấu chịu lực kết hợp giữa bê tông cốt thép và xây gạch hoặc xây gạch. Niên hạn sử dụng trên 40 năm;
Bao che nhà và tường ngăn bằng gạch;
Mái ngói hoặc Fibroociment;
Vật liệu hoàn thiện bằng vật liệu phổ thông.
Tiện nghi sinh hoạt bình thường, trang bị xí, tắm bằng vật liệu bình thường. Nhà cao tối đa là 2 tầng'),

(6,N'Nhà cấp IV',N'Kết cấu chịu lực bằng gạch, gỗ. Niên hạn sử dụng tối đa 30 năm;
Tường bao che và tường ngăn bằng gạch (tường 22 hoặc 11 cm);
Mái ngói hoặc Fibroociment;
Vật liệu hoàn thiện chất lượng thấp;');

-- -------------------------------------

INSERT INTO location VALUES 
(1,N'Quận Nam Từ Liêm',N'Mỹ Đình',N'Lê Đức Thọ','69');

INSERT INTO location VALUES 
(2,N'Quận Thanh Xuân',N'Tố Hữu',N'Lê Trọng Tấn','26');

INSERT INTO location VALUES 
(3,N'Quận Bắc Từ Liêm',N'Phúc Diễn',N'Văn Tiến Dũng','13');

-- data motel
INSERT INTO motel(category_id,user_id,location_id,area,price,description,electric_price,internet_price,water_price,status)
VALUES(3,1,3,15,1000000,N'Nhà trọ chỉ từ 800k',4000,80000,150000,1);

INSERT INTO motel(category_id,user_id,location_id,area,price,description,electric_price,internet_price,water_price,status)
VALUES(4,1,1,30,2000000,N'Nhà trọ tại ngõ 35 Lê Đức Thọ',5000,120000,100000,1);

INSERT INTO motel(category_id,user_id,location_id,area,price,description,electric_price,internet_price,water_price,status)
VALUES(3,1,2,20,1200000,N'Cho thuê nhà nguyên căn',4000,80000,150000,1);

INSERT INTO motel(category_id,user_id,location_id,area,price,description,electric_price,internet_price,water_price,status)
VALUES(4,1,3,20,1600000,N'Chung cư mini ở Thanh Xuân',5000,200000,100000,1);

-- -------------------------- 

INSERT INTO picture
VALUES('1','anh1');

INSERT INTO picture(motel_id,url)
VALUES('2','anh2');

INSERT INTO picture(motel_id,url)
VALUES('3','anh3');

INSERT INTO picture(motel_id,url)
VALUES('4','anh4');
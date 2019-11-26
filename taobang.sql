/** Bỏ qua 2 dòng dưới nếu đã có database **/ 
create database BTL_CNPM;
use BTL_CNPM;

create table NguoiDung(
	username varchar(30) not null,
	ten nvarchar(30) not null,
	pwd varchar(30) not null,
	diaChi nvarchar(50) not null,
	soDienThoai varchar(15) not null,
	primary key (username)
)
create table DauSach(
	maDauSach int not null identity(0,1),
	tenSach nvarchar(50) not null,
	namXuatBan smallint,
	urlAnh varchar(50),
	theLoai nvarchar(30),
	primary key (maDauSach)
)


create table QuyenSach(
	maQuyenSach int not null identity(0,1),
	maDauSach int not null foreign key references DauSach(maDauSach),
	nguoiBan varchar(30) not null foreign key references NguoiDung(username),
	ngayDang datetime not null,
	tinhTrang nvarchar(50),
	conHang bit not null, 
	primary key (MaQuyenSach)
)

create table Anh(
	tenAnh varchar(15) not null,
	maQuyenSach int not null foreign key references QuyenSach(maQuyenSach),
	primary key (tenAnh)
)

create table ReviewSach(
	maDauSach int  not null foreign key references DauSach(maDauSach),
	nguoiReview varchar(30)  not null foreign key references NguoiDung(username),
	soSao smallint not null,
	review nvarchar(500),
	ngayReview datetime not null,
	primary key (maDauSach, nguoiReview)
)

create table DaMua(
	nguoiDung varchar(30) not null foreign key references NguoiDung(username),
	maQuyenSach int not null foreign key references QuyenSach(maQuyenSach),
	ngayMua datetime not null,
	primary key (nguoiDung, maQuyenSach)
)

/** Dòng dưới là để sửa lại tên cột, nếu scripts và stored procedures bị lỗi, hãy xoá nó đi**/
sp_rename 'DauSach.namSuatBan', 'namXuatBan', 'COLUMN';

/** record initiation starts here **/

insert into NguoiDung values
('theadmin777', N'Nguyễn Ðức Tiến', '123456', N'Hà Nội', '0312856789'),
('elomel', N'Ðặng Ðình Ðăng', '111111', N'Hà Giang', '0312845796'),
('geke789', N'Bùi Thị Dung', 'password', N'Hải Phòng', '0387894125'),
('number4', N'Bill Murray', '123123', N'New York', '0888999777'),
('sotour', N'Bùi Mạnh Huấn', '000000', N'Thái Nguyên', '0756110000'),
('dubaothoitiet', N'Nguyễn Hồng Ðăng', 'xxxxxx', N'Hà Giang', '0123444888'),
('randomusername', N'Bùi Ðức Khoa', 'abcdef', N'Cần Thơ', '0123586789'),
('flex333', N'Bùi Thị My', '654321', N'Ðà Nẵng', '0124555781'),
('h3ll0n', N'Xuân Bắc', 'asdf1234', N'Hà Nội', '0142789412'),
('langtudung', N'Nguyễn Ðức Dũng', '222222', N'Ninh Bình', '0122411766');

insert into DauSach(tenSach, namXuatBan, urlAnh, theLoai) values
(N'Dế Mèn phiêu lưu ký', 1941, '/image/demen.jpg', N'Truyện thiếu nhi'),
(N'Harry Porter', 1997, '/image/potter.jpg', N'Truyện kỳ ảo'),
(N'Nhà giả kim', 1988, '/image/nhagiakim.jpg', N'Tiểu thuyết'),
(N'Đắc nhân tâm', 1936, '/image/dacnhantam.jpg', N'Sách tự lực'),
(N'Rừng Na Uy', 1987, '/image/rungnauy.jpg', N'Tiểu thuyết'),
(N'Mật mã Da Vinci', 2000, '/image/matmadavinci.jpg', N'Trinh thám'),
(N'Sherlock Holmes', 1892, '/image/sherlock.jpg', N'Trinh thám'),
(N'Toán cao cấp', 1990, '/image/toancaocap.jpg', N'Sách giáo khoa'),
(N'Head First Java', 2003, '/image/hfjava.jpg', N'Sách giáo khoa'),
(N'Mắt biếc', 2004, '/image/matbiec.jpg', N'Tiểu thuyết');

/** SQL server datetime format YYYY-MM-DD HH:MI:SS **/
/** Các giá trị của trường tình trạng: Mới, Như mới, Tốt, Khá, Cũ **/
insert into QuyenSach(maDauSach, nguoiBan, ngayDang, tinhTrang, conHang) values
(0, 'dubaothoitiet', 2019-10-20 15:20:00, N'Khá', 0),
(3, 'h3ll0n', 2019-10-29 08:20:10, N'Cũ', 1),
(0, 'geke789', 2019-11-01 10:05:12, N'Tốt', 1),
(1, 'geke789', 2019-11-02 12:05:00, N'Mới', 1),
(2, 'sotour', 2019-11-13 06:20:10, N'Như mới', 1),
(7, 'theadmin777', 2019-11-13 07:00:00, N'Cũ', 0),
(9, 'flex333', 2019-11-15 20:22:01, N'Mới', 1),
(5, 'langtudung', 2019-11-15 22:00:01, N'Khá', 1),
(2, 'h3ll0n', 2019-11-16 01:20:20, N'Mới', 0),
(6, 'randomusername', 2019-11-17 10:10:21, N'Tốt', 1);

/** insert ReviewSach values **/

insert DaMua values
('elomel', 0, 2019-10-25 13:00:02),
('number4', 5, 2019-11-13 08:00:00),
('theadmin777', 8, 2019-11-18 22:02:00);






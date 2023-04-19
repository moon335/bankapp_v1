
INSERT INTO user_tb(username, password, fullname, created_at) values('길동', '1234',
'고', now());
INSERT INTO user_tb(username, password, fullname, created_at) values('둘리', '1234',
'애기공룡', now());
INSERT INTO user_tb(username, password, fullname, created_at) values('콜', '1234',
'마이', now());
INSERT INTO user_tb(username, password, fullname, created_at) values('홍아', '1234',
'항아', now());

INSERT INTO account_tb(number, password, balance, user_id, created_at)
values('1111', '1234', 1200, 1, now());
INSERT INTO account_tb(number, password, balance, user_id, created_at)
values('2222', '1234', 2200, 2, now());
INSERT INTO account_tb(number, password, balance, user_id, created_at)
values('333', '1234', 0, 3, now());

INSERT INTO history_tb(amount, w_balance, d_balance, 
					   w_account_id, d_account_id, created_at)
VALUES (100, 800, 1200, 1, 2, now());
INSERT INTO history_tb(amount, w_balance, d_balance, 
					   w_account_id, d_account_id, created_at)
VALUES (100, 700, null, 1, null, now());
INSERT INTO history_tb(amount, w_balance, d_balance, 
					   w_account_id, d_account_id, created_at)
VALUES (500, null, 1200, null, 1, now());
INSERT INTO history_tb(amount, w_balance, d_balance, 
					   w_account_id, d_account_id, created_at)
VALUES (1000, null, 2200, null, 2, now());

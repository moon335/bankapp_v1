
CREATE TABLE user_tb(
	id int AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) not null UNIQUE,
    password VARCHAR(30) not null,
    fullname VARCHAR(50) not null,
    created_at TIMESTAMP not null DEFAULT now()
);

CREATE TABLE account_tb(
	id int AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(30) not null UNIQUE,
    password VARCHAR(20) not null,
    balance BIGINT not null COMMENT '계좌 잔액',
    user_id int,
    created_at TIMESTAMP not null DEFAULT now()
);

CREATE TABLE history_tb(
	id int AUTO_INCREMENT PRIMARY KEY COMMENT '거래 내역 ID',
    amount BIGINT not null COMMENT '거래 금액',
    w_account_id int COMMENT '출금 계좌 id',
    d_account_id int COMMENT '입금 계좌 id',
    w_balance BIGINT COMMENT '출금 요청된 계좌의 잔액',
    d_balance BIGINT COMMENT '입금 요청된 계좌의 잔액',
    created_at TIMESTAMP not null DEFAULT now()
);



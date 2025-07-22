-- DROP TABLE BANKING.USERS;

-- DROP TABLE "Banking"."flyway_schema_history";

CREATE SCHEMA IF NOT EXISTS banking;

CREATE TABLE banking.users (
                               id BIGINT PRIMARY KEY,
                               firstname VARCHAR(255) NOT NULL,
                               lastname VARCHAR(255) NOT NULL,
                               gender VARCHAR(50) NOT NULL,
                               email VARCHAR(255) UNIQUE NOT NULL,
                               username VARCHAR(255) UNIQUE NOT NULL,
                               password VARCHAR(255) NOT NULL,
                               created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE banking.transactions (
                                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                      user_id BIGINT NOT NULL,
                                      amount DECIMAL(10, 2) NOT NULL,
                                      transaction_type VARCHAR(50) NOT NULL, -- e.g., "Deposit", "Withdrawal"
                                      transaction_date DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                      description VARCHAR(255),
                                      FOREIGN KEY (user_id) REFERENCES banking.users(id)
                                          ON DELETE CASCADE ON UPDATE CASCADE
);


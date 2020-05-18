
create table CAR (
                     id BIGINT IDENTITY primary key,
                     brand VARCHAR2(150),
                     model VARCHAR2(200),
                     power DOUBLE,
                     year_of_issue SMALLINT
);

create table AIRPLANE (
                          id BIGINT IDENTITY primary key,
                          brand VARCHAR2(150),
                          model VARCHAR2(200),
                          manufacturer VARCHAR2(500),
                          year_of_issue SMALLINT,
                          fuel_capacity INT,
                          seats INT
);
create table ASSESSED_VALUE_CAR (
                                id BIGINT IDENTITY primary key,
                                assessed_date date,
                                assessed_value DECIMAL(20),
                                car_id BIGINT,
                                FOREIGN KEY (car_id) REFERENCES CAR(id)
);

create table ASSESSED_VALUE_AIRPLANE (
                                id BIGINT IDENTITY primary key,
                                assessed_date date,
                                assessed_value DECIMAL(20),
                                airplane_id BIGINT,
                                FOREIGN KEY (airplane_id)  REFERENCES AIRPLANE(id)
);

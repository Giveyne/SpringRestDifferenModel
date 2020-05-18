

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
  fuelCapacity INT,
  seats INT
);
create table ASSESSED_VALUE (
id BIGINT IDENTITY primary key,
assessedDate date,
assessed_value DECIMAL(20),
airplane_id BIGINT,
car_id BIGINT,
CONSTRAINT
    FOREIGN KEY (airplane_id)  REFERENCES AIRPLANE(id),
FOREIGN KEY (car_id) REFERENCES CAR(id)
);




DROP TABLE IF EXISTS lakoach;
 
CREATE TABLE lakoach (
  id INT   PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL
);
 
DROP TABLE IF EXISTS tnuot;
 
CREATE TABLE tnuot (
  id INT  ,
  transaction_date VARCHAR(250) NOT NULL,
  esek VARCHAR(250) NOT NULL,
  amount INT NOT NULL,
  ccno VARCHAR(16) NOT NULL
);


INSERT INTO lakoach (id, name, address)
VALUES
  (123, 'Moshe', 'Tel Aviv'),
  (231, 'Yitsak', 'Rannana'),
  (321, 'David', 'Jerusalem'),
  (333, 'Ester', 'Herzeliya'),
  (654, 'Avi', 'Eilat'),
  (879, 'Yaakov', 'Metula');
  
  
INSERT INTO tnuot (id, transaction_date, esek, amount,ccno)
VALUES
  (123, now(), 'Supersal',100, 123444),
  (321, now(), 'Supersal',200, 3213333),
  (123, now(), 'Supersal',100, 123444),
  (123, now(), 'Osher Ad',100, 123555),
  (123, now(), 'Supersal',200, 123555),
  (321, DATEADD('DAY',-180, CURRENT_DATE), 'Supersal',500, 3213333),
  (321, DATEADD('DAY',-1, CURRENT_DATE), 'Osher Ad',200, 3213333);
  
  


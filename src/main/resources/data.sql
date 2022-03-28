INSERT INTO drone(droneid, positionx, positiony) VALUES ('LMDR-1', 5,10);
INSERT INTO drone(droneid, positionx, positiony) VALUES ('LMDR-2', 2,7);
INSERT INTO drone(droneid, positionx, positiony) VALUES ('LMDR-3', 6,20);
INSERT INTO drone(droneid, positionx, positiony) VALUES ('LMDR-4', 4,43);
INSERT INTO drone(droneid, positionx, positiony) VALUES ('LMDR-5', 9,9);

INSERT INTO store(id, storeid,  positionx, positiony) VALUES (101,'LMFR-VA', 3,3);
INSERT INTO store(id, storeid,  positionx, positiony) VALUES (102,'LMFR-RO', 23,45);
INSERT INTO store(id, storeid,  positionx, positiony) VALUES (103, 'LMFR-LE', 10,14);

INSERT INTO product(id, productid, productname, quantity) VALUES (1001, 'LMFRPRD-1', 'Shovel', 10);
INSERT INTO product(id, productid, productname, quantity) VALUES (1002, 'LMFRPRD-1', 'Shovel', 1);

INSERT INTO product(id, productid, productname, quantity) VALUES (1003, 'LMFRPRD-2', 'Pickaxe', 3);
INSERT INTO product(id, productid, productname, quantity) VALUES (1004, 'LMFRPRD-2', 'Pickaxe', 2);

INSERT INTO product(id, productid, productname, quantity) VALUES (1005,'LMFRPRD-3', 'Rake', 1);
INSERT INTO product(id, productid, productname, quantity) VALUES (1006, 'LMFRPRD-3', 'Rake', 2);


INSERT INTO store_products(store_id, products_id) VALUES (101, 1001);
INSERT INTO store_products(store_id, products_id) VALUES (101, 1006);

INSERT INTO store_products(store_id, products_id) VALUES (102, 1002);
INSERT INTO store_products(store_id, products_id) VALUES (102, 1003);

INSERT INTO store_products(store_id, products_id) VALUES (103, 1004);
INSERT INTO store_products(store_id, products_id) VALUES (103, 1005);

INSERT INTO customer(id, customerid, positionx, positiony) VALUES (301, 'CUS-1', 5, 8);
INSERT INTO customer(id, customerid, positionx, positiony) VALUES (302, 'CUS-2', 20, 20);
INSERT INTO customer(id, customerid, positionx, positiony) VALUES (303, 'CUS-3', 12, 3);

INSERT INTO orders(id, orderid, customer_id) VALUES (201, 'LMFORDER-1', 301);
INSERT INTO orders(id, orderid, customer_id) VALUES (202, 'LMFORDER-2', 302);
INSERT INTO orders(id, orderid, customer_id) VALUES (203, 'LMFORDER-3', 303);

INSERT INTO orderedproduct(order_id, productid, quantity) VALUES (201, 'LMFRPRD-1', 5);
INSERT INTO orderedproduct(order_id, productid, quantity) VALUES (201, 'LMFRPRD-2', 1);
INSERT INTO orderedproduct(order_id, productid, quantity) VALUES (201, 'LMFRPRD-3', 1);

INSERT INTO orderedproduct(order_id, productid, quantity) VALUES (202,'LMFRPRD-2', 1);
INSERT INTO orderedproduct(order_id, productid, quantity) VALUES (202,'LMFRPRD-3', 1);

INSERT INTO orderedproduct(order_id, productid, quantity) VALUES (203, 'LMFRPRD-3', 1);
INSERT INTO orderedproduct(order_id, productid, quantity) VALUES (203, 'LMFRPRD-1', 5);


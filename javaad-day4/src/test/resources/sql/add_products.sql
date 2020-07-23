INSERT INTO product (id, name, price, brand)
VALUES (-1, 'Ionut', 1.00, 'Coca-Cola');
INSERT INTO product (id, name, price, brand)
VALUES (-2, 'Ana', 1.00, 'Coca-Cola');
INSERT INTO product (id, name, price, brand)
VALUES (-3, 'Bogdan', 2.00, 'Coca-Cola');

INSERT INTO store_product (id, stock, store_id, product_id, active)
 VALUES (-1, 1, 1, -1, true),
        (-2, 4, 2, -1, true);

USE mydb;

INSERT INTO products (name, price, web_id) VALUES
('Sauce Labs Backpack', '29.99', 'item_4'),
('Sauce Labs Bolt T-Shirt','15.99', 'item_1'),
('Sauce Labs Onesie','7.99', 'item_2'),
('Sauce Labs Bike Light','9.99', 'item_0'),
('Sauce Labs Fleece Jacket','49.99', 'item_5'),
('Test.allTheThings() T-Shirt (Red)','15.99', 'item_3');

INSERT INTO users (first_name, last_name, login, password, zip_code) VALUES
('John', 'Smith', 'standard_user', 'secret_sauce', "11-222"),
('Kate', 'Brown', 'standard_user', 'secret_sauce', "33-444");

INSERT INTO orders (user_id) VALUES (1), (2);

INSERT INTO orders_has_products (orders_id, products_id) VALUES (1, 1), (1, 2), (2, 3), (2, 4), (2, 6);
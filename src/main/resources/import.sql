-- Create User
INSERT INTO tb_user (name, email, password) VALUES ('Alex', 'alex@gmail.com', '$2a$10$Bhcw4tAiXmtMtrHOCNYzEeRoNCI4rgbgQ/OrP3RYb43Y71CZ7K0Hy');
INSERT INTO tb_user (name, email, password) VALUES ('Maria', 'maria@gmail.com', '$2a$10$Bhcw4tAiXmtMtrHOCNYzEeRoNCI4rgbgQ/OrP3RYb43Y71CZ7K0Hy');
-- Create Roles
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
-- Associate Users with Roles
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
-- Create Products
INSERT INTO tb_product (name) VALUES ('TV');
INSERT INTO tb_product (name) VALUES ('Computer');

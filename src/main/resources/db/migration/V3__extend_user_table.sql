ALTER TABLE "user" ADD COLUMN password VARCHAR(200);
ALTER TABLE "user" ADD COLUMN authority VARCHAR(100);

INSERT INTO "user" (email, password, authority)
VALUES ('user@mail.com', '{noop}user_password', 'USER'),
       ('admin@mail.com', '{bcrypt}$2a$10$7c.F/reuaqXXzYeLq5GpQudP5cDsFtes7Vh.OZalExwDK4BzIWXq2', 'admin,user');

-- Create roles
INSERT INTO public."userrole"(user_role_id, name, description) VALUES (10, 'ADMIN', 'Administrator user role, all privileges');
INSERT INTO public."userrole"(user_role_id, name, description) VALUES (11, 'READ', 'Read user role, only read privileges');
INSERT INTO public."userrole"(user_role_id, name, description) VALUES (12, 'WRITE', 'Write user role, read and write privileges');

-- Create users
INSERT INTO public."user"(email, person_name, password, user_role_id) VALUES ('test@centriz.cr', 'Admin user', 'centriz', 10);

-- Create brands
INSERT INTO public."brand"(name) VALUES ('Budget');
INSERT INTO public."brand"(name) VALUES ('Apex');
INSERT INTO public."brand"(name) VALUES ('Cero Stress');
INSERT INTO public."brand"(name) VALUES ('Renting');

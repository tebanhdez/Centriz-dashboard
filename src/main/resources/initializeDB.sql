-- Create roles
INSERT INTO public."userrole"(user_role_id, description, name) VALUES (10, 'Admin role', 'ADMIN');

-- Create users
INSERT INTO public."user"(email, person_name, password, user_role_id) VALUES ('test@centriz.cr', 'Admin user', 'centriz', 10);

-- Create brands
INSERT INTO public."brand"(id, name) VALUES (1, 'Budget');

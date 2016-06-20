-- Create roles
INSERT INTO public.userrole(description, name) VALUES ('Admin role', "ADMIN");

-- Create users
INSERT INTO public."user"(email, person_name, password, user_role_id) VALUES ('test@centriz.cr', 'Admin user', 'centriz', 1);
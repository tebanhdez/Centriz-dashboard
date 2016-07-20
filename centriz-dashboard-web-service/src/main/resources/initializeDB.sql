-- Organization name
INSERT INTO public.source(id, name, parent) VALUES (1, 'Centriz', null);

-- Business units
INSERT INTO public.source(id, name, parent) VALUES (2, 'Financiera', 1), (3, 'Clientes', 1), (4, 'Procesos', 1), (5, 'Crecimiento y aprendizaje', 1);

-- Primary KPI
INSERT INTO public.source(id, name, parent) VALUES (6, 'Ebidta', 2), (7, 'Salud financiera', 2), (8, 'Rendimiento de vehiculos vendidos', 2);
INSERT INTO public.source(id, name, parent) VALUES (9, 'Satisfaccion de clientes', 3), (10, 'Cumplir con plan de clientes', 3), (11, 'Satisfaccion de venta de usados', 3);
INSERT INTO public.source(id, name, parent) VALUES (12, 'Inventario de vehiculos por segmento', 4), (13, 'RPU operativo', 4), (14, 'Recuperacion de servicios', 4), (15, 'Cumplir con alistado de venta', 4);
INSERT INTO public.source(id, name, parent) VALUES (16, 'RSC', 5), (17, 'KAIZEN', 5), (18, 'Promover una cultura enfocada en valores', 5), (19, 'Promover el desarrollo del colaborador', 5), (20, 'Mantener el personal', 5);

-- Metrics
-- Financiera
INSERT INTO public.source(id, name, parent) VALUES (21, 'Ebitda BRAC', 6), (22, 'Ebitda RENT', 6), (23, 'Ebitda APEX', 6), (24, 'GPU', 6);
INSERT INTO public.source(id, name, parent) VALUES (25, 'Costo financiero', 7), (26, 'Patrimonio neto tangible', 7), (27, 'Periodo medio de cobro (dias)', 7), (28, 'Morosidad de c/c', 7), (29, 'Razon de deuda =< 1,75', 7), (30, 'Razon de cobertura del servicio de la deuda => 1,40', 7);
INSERT INTO public.source(id, name, parent) VALUES (31, 'Precio CeroStres', 8), (32, 'Precio de dealer', 8), (33, 'Precio revendedor', 8), (34, 'Acumulado de presupuesto de venta de 0 es 3', 8);

-- Clientes
INSERT INTO public.source(id, name, parent) VALUES (35, 'OSE', 9), (36, 'Satisfaccion general de budget', 9), (37, 'Llamadas exitosas al call center', 9), (38, 'Reclamos responsabilidad nuestra', 9), (39, 'Satisfaccion de clientes de renting', 9);
INSERT INTO public.source(id, name, parent) VALUES (40, 'Cumplimiento de precio mayorista', 10), (41, 'No show web in', 10), (42, 'Clientes activos corporativos', 10), (43, 'Visitas vrs reservaciones de la web', 10), (44, 'Tiempo de duracion de pago (dias)', 10), (45, 'Cumplir con el presupuesto de Mercadeo', 10);
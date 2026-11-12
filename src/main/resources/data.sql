-- ===================================================================
--  DATOS INICIALES · la base de datos esta en memoria: se cargan en
--  cada arranque. Los id salen 1, 2, 3... en el orden de los INSERT.
-- ===================================================================

INSERT INTO autores (nombre, nacionalidad) VALUES
  ('Miguel Delibes',       'Española'),        -- id 1
  ('Ursula K. Le Guin',    'Estadounidense'),  -- id 2
  ('Svetlana Aleksievich', 'Bielorrusa'),      -- id 3
  ('Italo Calvino',        'Italiana');        -- id 4

-- ===================================================================
--  LIBROS · DESCOMENTA este bloque cuando termines la TAREA 1.
--  Si los 8 INSERT entran sin error al arrancar, tu entidad esta bien.
-- ===================================================================
-- INSERT INTO libros (titulo, isbn, precio, stock, anio_publicacion,
--                     autor_id, is_deleted, created_at, updated_at) VALUES
--   ('Los santos inocentes',              '978-84-233-2518-4', 12.50, 7, 1981, 1, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--   ('El camino',                         '978-84-233-1234-5', 10.95, 3, 1950, 1, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--   ('Cinco horas con Mario',             '978-84-233-0011-2', 14.90, 0, 1966, 1, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--   ('La mano izquierda de la oscuridad', '978-84-450-7623-1', 18.00, 5, 1969, 2, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--   ('Los desposeídos',                   '978-84-450-7624-8', 19.90, 0, 1974, 2, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--   ('Voces de Chernóbil',                '978-84-9998-402-7', 21.00, 2, 1997, 3, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--   ('Las ciudades invisibles',           '978-84-663-2691-0', 14.25, 9, 1972, 4, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--   ('El barón rampante',                 '978-84-663-1802-1', 11.50, 4, 1957, 4, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

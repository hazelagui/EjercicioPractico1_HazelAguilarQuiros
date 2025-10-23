-- Script: biblioteca_schema.sql
-- Crea la BD, tablas y datos de ejemplo para la aplicación de la biblioteca (MySQL)

-- 1) Crear la base de datos
DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

USE biblioteca;

-- 2) Tabla categorias
DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) DEFAULT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY ux_categoria_nombre (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 3) Tabla libros
DROP TABLE IF EXISTS libro;
CREATE TABLE libro (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(200) NOT NULL,
    isbn VARCHAR(20) DEFAULT NULL,
    descripcion TEXT DEFAULT NULL,
    categoria_id BIGINT UNSIGNED NOT NULL,
    fecha_publicacion DATE DEFAULT NULL,
    disponible BOOLEAN NOT NULL DEFAULT TRUE,
    precio DECIMAL(10,2) DEFAULT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_libro_categoria (categoria_id),
    CONSTRAINT fk_libro_categoria FOREIGN KEY (categoria_id)
        REFERENCES categoria (id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 4) Tabla quejas (sugerencias/quejas)
DROP TABLE IF EXISTS queja;
CREATE TABLE queja (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre_cliente VARCHAR(150) DEFAULT NULL,
    email VARCHAR(200) DEFAULT NULL,
    telefono VARCHAR(30) DEFAULT NULL,
    tipo ENUM('QUEJA','SUGERENCIA','CONSULTA') NOT NULL DEFAULT 'CONSULTA',
    asunto VARCHAR(200) DEFAULT NULL,
    mensaje TEXT NOT NULL,
    tratado BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_queja_tipo (tipo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 5) Datos de ejemplo: categorías
INSERT INTO categoria (nombre, descripcion) VALUES
('Ficción', 'Novelas y relatos de ficción.'),
('Ciencia', 'Libros de divulgación y textos científicos.'),
('Historia', 'Libros sobre historia mundial y regional.'),
('Tecnología', 'Libros sobre informática, programación y tecnología.'),
('Literatura Clásica', 'Obras clásicas de la literatura universal.');

-- 6) Datos de ejemplo: libros
INSERT INTO libro (titulo, autor, isbn, descripcion, categoria_id, fecha_publicacion, precio, disponible)
VALUES
('Cien años de soledad', 'Gabriel García Márquez', '978-0307474728', 
 'Novela clásica de realismo mágico que narra la historia de la familia Buendía.', 
 1, '1967-06-05', 19.90, TRUE),

('Breves respuestas a las grandes preguntas', 'Stephen Hawking', '978-0241346714', 
 'Divulgación científica sobre preguntas actuales del universo y la física.', 
 2, '2018-10-16', 14.50, TRUE),

('1984', 'George Orwell', '978-0451524935', 
 'Novela distópica sobre un régimen totalitario y la vigilancia extrema.', 
 1, '1949-06-08', 15.99, TRUE),

('Sapiens: De animales a dioses', 'Yuval Noah Harari', '978-0062316097', 
 'Una breve historia de la humanidad desde la prehistoria hasta el presente.', 
 3, '2011-01-01', 22.50, TRUE),

('Clean Code', 'Robert C. Martin', '978-0132350884', 
 'Manual de buenas prácticas de programación y código limpio.', 
 4, '2008-08-01', 42.00, TRUE),

('Don Quijote de la Mancha', 'Miguel de Cervantes', '978-8420412146', 
 'La obra cumbre de la literatura española sobre las aventuras de un hidalgo.', 
 5, '1605-01-16', 18.00, TRUE),

('El origen de las especies', 'Charles Darwin', '978-8420649795', 
 'Obra fundamental sobre la teoría de la evolución por selección natural.', 
 2, '1859-11-24', 25.00, FALSE),

('Crónica de una muerte anunciada', 'Gabriel García Márquez', '978-0307387134', 
 'Novela corta sobre un asesinato anunciado en un pueblo colombiano.', 
 1, '1981-01-01', 12.50, TRUE);

-- 7) Datos de ejemplo: quejas/sugerencias
INSERT INTO queja (nombre_cliente, email, telefono, tipo, asunto, mensaje, tratado) 
VALUES
('María Pérez', 'maria.perez@email.com', '506-8888-7777', 'SUGERENCIA', 
 'Ampliar horario', 
 'Sería ideal que la biblioteca abra más horas los fines de semana para poder visitarla con más frecuencia.',
 FALSE),

('Carlos Ramírez', 'carlos.ramirez@email.com', '506-7777-8888', 'QUEJA', 
 'Libro deteriorado', 
 'El libro "1984" que presté estaba en mal estado, con páginas sueltas. Deberían revisar el catálogo.',
 TRUE),

('Ana González', 'ana.gonzalez@email.com', '506-6666-9999', 'CONSULTA', 
 '¿Tienen servicio de reservas?', 
 'Me gustaría saber si es posible reservar libros por teléfono o internet antes de ir a la biblioteca.',
 FALSE);

-- 8) Comprobar datos insertados (opcional)
SELECT COUNT(*) as total_categorias FROM categoria;
SELECT COUNT(*) as total_libros FROM libro;
SELECT COUNT(*) as total_quejas FROM queja;

-- 9) Consultas útiles para verificación
-- SELECT * FROM categoria;
-- SELECT l.titulo, l.autor, c.nombre as categoria FROM libro l JOIN categoria c ON l.categoria_id = c.id;
-- SELECT * FROM queja WHERE tratado = FALSE;

-- Fin del script
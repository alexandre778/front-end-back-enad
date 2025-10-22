-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS AGMSoftwareDB
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE AGMSoftwareDB;

-- =========================================================
-- TABELA DE USUÁRIOS (Anunciantes)
-- =========================================================
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================================================
-- TABELA DE ANÚNCIOS DE CARROS
-- =========================================================
CREATE TABLE anuncios_carros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    data_publicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- =========================================================
-- TABELA DE ANÚNCIOS DE IMÓVEIS
-- =========================================================
CREATE TABLE anuncios_imoveis (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    data_publicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- =========================================================
-- TABELA DE ANÚNCIOS DE NEGÓCIOS
-- =========================================================
CREATE TABLE anuncios_negocios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    investimento DECIMAL(10,2) NOT NULL,
    data_publicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- =========================================================
-- TABELA DE VAGAS DE EMPREGOS
-- =========================================================
CREATE TABLE anuncios_empregos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    empresa_nome VARCHAR(100) NOT NULL,
    titulo_vaga VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    data_publicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================================================
-- INSERÇÃO DE DADOS EXEMPLO
-- =========================================================
INSERT INTO usuarios (nome, email, senha)
VALUES
('Alexandre Martins', 'alexandre@agm.com', '123456'),
('João Silva', 'joao@teste.com', '123456');

INSERT INTO anuncios_carros (usuario_id, titulo, descricao, preco)
VALUES
(1, 'Fiat Uno 2015', 'Carro em ótimo estado, 1.0, completo.', 25000.00),
(2, 'Honda Civic 2020', 'Automático, único dono, 30 mil km.', 115000.00);

INSERT INTO anuncios_imoveis (usuario_id, titulo, descricao, preco)
VALUES
(1, 'Apartamento no Centro', '2 quartos, 1 suíte, garagem.', 350000.00),
(2, 'Casa com piscina', 'Casa ampla com área gourmet.', 680000.00);

INSERT INTO anuncios_negocios (usuario_id, titulo, descricao, investimento)
VALUES
(1, 'Pizzaria em Funcionamento', 'Negócio lucrativo com clientela fiel.', 120000.00);

INSERT INTO anuncios_empregos (empresa_nome, titulo_vaga, descricao, salario)
VALUES
('AGM Software', 'Desenvolvedor Java', 'Desenvolver sistemas web em Spring Boot.', 6000.00);

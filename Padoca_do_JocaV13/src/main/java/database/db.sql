create database Padaria;

use Padaria;

CREATE TABLE Endereco (
    cep VARCHAR(9) NOT NULL,
    rua VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(30),
    uf VARCHAR(2)
);

ALTER TABLE Endereco ADD CONSTRAINT PK_Endereco
        PRIMARY KEY (cep);

CREATE TABLE Cliente (
    cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(50),
    email VARCHAR(50),
    celular VARCHAR(20),
    cep VARCHAR(9),
    rua VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(30),
    uf VARCHAR(2)
);

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente
        PRIMARY KEY (cpf);

CREATE TABLE Funcionario (
    cpf INT NOT NULL,
    nome VARCHAR(50),
    data_Admissao VARCHAR(10),
    cargo VARCHAR(30),
    data_Nascimento VARCHAR(10)
);

ALTER TABLE Funcionario ADD CONSTRAINT PK_Funcionario
        PRIMARY KEY (cpf);

CREATE TABLE Fornecedor (
    cnpj VARCHAR(30) NOT NULL,
    nome VARCHAR(50),
    telefone VARCHAR(15)
);

ALTER TABLE Fornecedor ADD CONSTRAINT PK_Fornecedor
        PRIMARY KEY (cnpj);

CREATE TABLE Produto (
    id_Produto INT NOT NULL,
    preco DECIMAL(10,2),
    descricao VARCHAR(30),
    cnpj VARCHAR(30)
);

ALTER TABLE Produto ADD CONSTRAINT PK_Produto
        PRIMARY KEY (id_Produto);

ALTER TABLE Produto ADD CONSTRAINT FK_Produto_Fornecedor
        FOREIGN KEY (cnpj)
        REFERENCES Fornecedor (cnpj);

INSERT INTO Produto (id_Produto,preco,descricao)
        VALUES (1,1.19,'Pão Francês');

INSERT INTO Produto (id_Produto,preco,descricao)
        VALUES (2,2.99,'Brigadeiro');

INSERT INTO Produto (id_Produto,preco,descricao)
        VALUES (3,8.99,'Bolo');

INSERT INTO Produto (id_Produto,preco,descricao)
        VALUES (4,7.99,'Torta');

INSERT INTO Produto (id_Produto,preco,descricao)
        VALUES (5,4.99,'Pudim');

INSERT INTO Produto (id_Produto,preco,descricao)
        VALUES (6,1.49,'Pão Italiano');

INSERT INTO Produto (id_Produto,preco,descricao)
        VALUES (7,2.39,'Baguete');

INSERT INTO Produto (id_Produto,preco,descricao)
        VALUES (8,1.79,'Pão de Queijo');

CREATE TABLE Pedido (
    id_Pedido INT NOT NULL,
    qtd_Pedido INT,
    valor_Total DECIMAL(10,2),
    nome_Cliente VARCHAR(50),
    nome_Produto VARCHAR(30),
    cpf VARCHAR(14),
    id_Produto INT
);

ALTER TABLE Pedido ADD CONSTRAINT PK_Pedido
        PRIMARY KEY (id_Pedido);

ALTER TABLE Pedido ADD CONSTRAINT FK_Pedido_Cliente
        FOREIGN KEY (cpf)
        REFERENCES Cliente (cpf);

ALTER TABLE Pedido ADD CONSTRAINT FK_Pedido_Produto
        FOREIGN KEY (id_Produto)
        REFERENCES Produto (id_Produto);
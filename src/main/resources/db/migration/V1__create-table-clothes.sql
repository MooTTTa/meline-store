CREATE TABLE clothes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    image TEXT,
    price INT
);
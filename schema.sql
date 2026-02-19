CREATE TABLE suppliers (
  id BIGSERIAL PRIMARY KEY,
  nom VARCHAR(255) NOT NULL,
  telephone VARCHAR(100),
  email VARCHAR(255),
  adresse TEXT,
  version BIGINT
);

CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL,
  version BIGINT
);

CREATE TABLE clients (
  id BIGSERIAL PRIMARY KEY,
  nom VARCHAR(255) NOT NULL,
  telephone VARCHAR(50),
  adresse TEXT,
  plafond_credit NUMERIC(12,2) NOT NULL,
  montant_credit_actuel NUMERIC(12,2) NOT NULL DEFAULT 0,
  statut VARCHAR(20) NOT NULL,
  version BIGINT
);

CREATE TABLE products (
  id BIGSERIAL PRIMARY KEY,
  reference VARCHAR(100) NOT NULL UNIQUE,
  nom VARCHAR(255) NOT NULL,
  categorie VARCHAR(100),
  marque VARCHAR(100),
  prix_achat NUMERIC(12,2) NOT NULL,
  prix_vente NUMERIC(12,2) NOT NULL,
  quantite_stock INT NOT NULL,
  seuil_alerte INT NOT NULL,
  emplacement VARCHAR(100),
  fournisseur_id BIGINT REFERENCES suppliers(id),
  version BIGINT
);

CREATE TABLE cash_registers (
  id BIGSERIAL PRIMARY KEY,
  date DATE NOT NULL,
  montant_initial NUMERIC(12,2) NOT NULL,
  total_entrees NUMERIC(12,2) NOT NULL DEFAULT 0,
  total_sorties NUMERIC(12,2) NOT NULL DEFAULT 0,
  solde_theorique NUMERIC(12,2) NOT NULL,
  solde_reel NUMERIC(12,2),
  statut VARCHAR(20) NOT NULL,
  version BIGINT
);
CREATE UNIQUE INDEX uk_cash_register_open_per_day ON cash_registers(date) WHERE statut='OUVERTE';

CREATE TABLE cash_movements (
  id BIGSERIAL PRIMARY KEY,
  caisse_id BIGINT NOT NULL REFERENCES cash_registers(id),
  type VARCHAR(20) NOT NULL,
  montant NUMERIC(12,2) NOT NULL,
  description VARCHAR(255),
  date TIMESTAMP NOT NULL
);

CREATE TABLE sales (
  id BIGSERIAL PRIMARY KEY,
  numero_facture VARCHAR(100) UNIQUE NOT NULL,
  date TIMESTAMP NOT NULL,
  total NUMERIC(12,2) NOT NULL,
  mode_paiement VARCHAR(20) NOT NULL,
  client_id BIGINT REFERENCES clients(id),
  version BIGINT
);

CREATE TABLE sale_lines (
  id BIGSERIAL PRIMARY KEY,
  sale_id BIGINT NOT NULL REFERENCES sales(id) ON DELETE CASCADE,
  produit_id BIGINT NOT NULL REFERENCES products(id),
  quantite INT NOT NULL,
  prix_unitaire NUMERIC(12,2) NOT NULL
);

CREATE TABLE credit_transactions (
  id BIGSERIAL PRIMARY KEY,
  client_id BIGINT NOT NULL REFERENCES clients(id),
  montant NUMERIC(12,2) NOT NULL,
  type VARCHAR(30) NOT NULL,
  date TIMESTAMP NOT NULL,
  version BIGINT
);

CREATE INDEX idx_product_reference ON products(reference);
CREATE INDEX idx_sales_date ON sales(date);
CREATE INDEX idx_sales_client_id ON sales(client_id);
CREATE INDEX idx_credit_client_id ON credit_transactions(client_id);

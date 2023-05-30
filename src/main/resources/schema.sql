-- Create the database
CREATE DATABASE annual_declaration;

-- Connect to the newly created database
-- \c annual_declaration;

-- Create the schema
CREATE SCHEMA pensioner;

-- Create the SocialSecurityPensioner table under the pensioner schema
CREATE TABLE pensioner.social_security_pensioner (
                                                     pensioner_id SERIAL PRIMARY KEY,
                                                     national_number VARCHAR(10) NOT NULL,
                                                     pension_number VARCHAR(10) NOT NULL,
                                                     name VARCHAR(100) NOT NULL,
                                                     date_of_birth DATE NOT NULL,
                                                     address VARCHAR(200) NOT NULL
);

-- Create the FamilyMember table under the pensioner schema
CREATE TABLE pensioner.family_member (
                                         family_member_id SERIAL PRIMARY KEY,
                                         pensioner_id INT NOT NULL,
                                         name VARCHAR(100) NOT NULL,
                                         date_of_birth DATE NOT NULL,
                                         gender VARCHAR(10) NOT NULL,
                                         FOREIGN KEY (pensioner_id) REFERENCES pensioner.social_security_pensioner(pensioner_id)
);

-- Create the Beneficiary table under the pensioner schema
CREATE TABLE pensioner.beneficiary (
                                       family_member_id INT PRIMARY KEY,
                                       entitlement_type VARCHAR(100) NOT NULL,
                                       entitlement_details TEXT,
                                       FOREIGN KEY (family_member_id) REFERENCES pensioner.family_member(family_member_id)
);

-- Create the AnnualDeclaration table under the pensioner schema
CREATE TABLE pensioner.annual_declaration (
                                              declaration_id SERIAL PRIMARY KEY,
                                              pensioner_id INT NOT NULL,
                                              submission_date DATE NOT NULL,
                                              status VARCHAR(20) NOT NULL,
                                              FOREIGN KEY (pensioner_id) REFERENCES pensioner.social_security_pensioner(pensioner_id)
);

-- Create the Document table under the pensioner schema
CREATE TABLE pensioner.document (
                                    document_id SERIAL PRIMARY KEY,
                                    declaration_id INT NOT NULL,
                                    file_name VARCHAR(200) NOT NULL,
                                    file_path VARCHAR(200) NOT NULL,
                                    FOREIGN KEY (declaration_id) REFERENCES pensioner.annual_declaration(declaration_id)
);

-- Create the Administrator table under the pensioner schema
CREATE TABLE pensioner.administrator (
                                         administrator_id SERIAL PRIMARY KEY,
                                         username VARCHAR(100) NOT NULL,
                                         password VARCHAR(100) NOT NULL
);

-- Create any additional tables for the pensioner schema as needed

-- Grant privileges to the user on the pensioner schema
GRANT ALL PRIVILEGES ON SCHEMA pensioner TO ad_user;

-- Grant privileges to the user on the tables within the pensioner schema
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA pensioner TO ad_user;

-- Grant privileges to the user on sequences within the pensioner schema
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA pensioner TO ad_user;

-- Grant privileges to the user on functions within the pensioner schema
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA pensioner TO ad_user;

-- Create the schema
CREATE SCHEMA pensioners;

-- Create the SocialSecurityPensioner table under the pensioner schema
CREATE TABLE pensioners.pensioner(
                                     pensioner_id SERIAL PRIMARY KEY,
                                     national_number VARCHAR(12) NOT NULL,
                                     pension_number VARCHAR(10) NOT NULL,
                                     name VARCHAR(100) NOT NULL,
                                     date_of_birth DATE NOT NULL,
                                     address VARCHAR(200) NOT NULL,
                                    CONSTRAINT unique_national_number UNIQUE (national_number)

);

-- Create the FamilyMember table under the pensioner schema
CREATE TABLE pensioners.family_member(
                                         family_member_id SERIAL PRIMARY KEY,
                                         pensioner_id INT NOT NULL,
                                         national_number VARCHAR(12) NOT NULL,
                                         name VARCHAR(100) NOT NULL,
                                         date_of_birth DATE NOT NULL,
                                         gender VARCHAR(10) NOT NULL,
                                         FOREIGN KEY (pensioner_id) REFERENCES pensioners.pensioner(pensioner_id),
                                         CONSTRAINT unique_family_member_national_number UNIQUE (national_number)

);

-- Create the Beneficiary table under the pensioner schema
CREATE TABLE pensioners.beneficiary(
                                       family_member_id INT PRIMARY KEY,
                                       entitlement_type VARCHAR(100) NOT NULL,
                                       entitlement_details TEXT,
                                       FOREIGN KEY (family_member_id) REFERENCES pensioners.family_member(family_member_id)
);

-- Create the AnnualDeclaration table under the pensioner schema
CREATE TABLE pensioners.annual_declaration(
                                              declaration_id SERIAL PRIMARY KEY,
                                              pensioner_id INT NOT NULL,
                                              submission_date DATE NOT NULL,
                                              status VARCHAR(20) NOT NULL,
                                              FOREIGN KEY (pensioner_id) REFERENCES pensioners.pensioner(pensioner_id)
);

-- Create the Document table under the pensioner schema
CREATE TABLE pensioners.document(
                                    document_id SERIAL PRIMARY KEY,
                                    declaration_id INT NOT NULL,
                                    file_name VARCHAR(200) NOT NULL,
                                    file_path VARCHAR(200) NOT NULL,
                                    FOREIGN KEY (declaration_id) REFERENCES pensioners.annual_declaration(declaration_id)
);

-- Create the Administrator table under the pensioner schema
CREATE TABLE pensioners.administrator(
                                         administrator_id SERIAL PRIMARY KEY,
                                         username VARCHAR(100) NOT NULL,
                                         password VARCHAR(100) NOT NULL
);

-- Grant privileges to the user on the pensioner schema
GRANT ALL PRIVILEGES ON SCHEMA pensioners TO ad_user;

-- Grant privileges to the user on the tables within the pensioner schema
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA pensioners TO ad_user;

-- Grant privileges to the user on sequences within the pensioner schema
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA pensioners TO ad_user;

-- Grant privileges to the user on functions within the pensioner schema
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA pensioners TO ad_user;

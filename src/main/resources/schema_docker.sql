-- Create the schema
CREATE SCHEMA pensioner;

-- Create the SocialSecurityPensioner table under the pensioner schema
CREATE TABLE pensioner.pensioner (
                                                     national_number VARCHAR(12) PRIMARY KEY,
                                                     pension_number VARCHAR(10) NOT NULL,
                                                     name VARCHAR(100) NOT NULL,
                                                     date_of_birth DATE NOT NULL,
                                                     address VARCHAR(200) NOT NULL
);

-- Create the FamilyMember table under the pensioner schema
CREATE TABLE pensioner.family_member (
                                         national_number VARCHAR(12) PRIMARY KEY,
                                         name VARCHAR(100) NOT NULL,
                                         date_of_birth DATE NOT NULL,
                                         gender VARCHAR(10) NOT NULL,
                                         FOREIGN KEY (national_number) REFERENCES pensioner.pensioner(national_number)
);

-- Create the Beneficiary table under the pensioner schema
CREATE TABLE pensioner.beneficiary (
                                       family_member_national_number VARCHAR(12) PRIMARY KEY,
                                       entitlement_type VARCHAR(100) NOT NULL,
                                       entitlement_details TEXT,
                                       FOREIGN KEY (family_member_national_number) REFERENCES pensioner.family_member(national_number)
);

-- Create the AnnualDeclaration table under the pensioner schema
CREATE TABLE pensioner.annual_declaration (
                                              declaration_id SERIAL PRIMARY KEY,
                                              pensioner_national_number VARCHAR(12) NOT NULL,
                                              submission_date DATE NOT NULL,
                                              status VARCHAR(20) NOT NULL,
                                              FOREIGN KEY (pensioner_national_number) REFERENCES pensioner.pensioner(national_number)
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

-- Grant privileges to the user on the pensioner schema
GRANT ALL PRIVILEGES ON SCHEMA pensioner TO ad_user;

-- Grant privileges to the user on the tables within the pensioner schema
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA pensioner TO ad_user;

-- Grant privileges to the user on sequences within the pensioner schema
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA pensioner TO ad_user;

-- Grant privileges to the user on functions within the pensioner schema
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA pensioner TO ad_user;

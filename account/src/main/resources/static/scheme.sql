CREATE TABLE PATIENTS (
    patient_id INT PRIMARY KEY IDENTITY(1,1),
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20) DEFAULT 'none',
    date_of_birth DATE,
    gender CHAR(1) NOT NULL,
    phone_number VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    blood_type VARCHAR(5) NOT NULL,
    allergies TEXT DEFAULT 'none',
    medical_history TEXT DEFAULT 'none',
    current_medication TEXT DEFAULT 'none',
    family_diseases CHAR(1) DEFAULT 'N',
    vaccination_status CHAR(1) DEFAULT 'N',
    organ_donor_status CHAR(1) DEFAULT 'N',
    emergency_contact_name VARCHAR(20) NOT NULL,
    emergency_contact_number VARCHAR(11) NOT NULL,
    emergency_contact_relation VARCHAR(10) NOT NULL,
    insurance_provider VARCHAR(30) DEFAULT 'none',
    insurance_policy_number VARCHAR(30),
    primary_care_physician VARCHAR(20) DEFAULT 'none',
    registration_date DATE NOT NULL,
    last_visit_date DATE NOT NULL,
    patient_type VARCHAR(20) NOT NULL,
    consent_for_data_usage CHAR(1) DEFAULT 'N' NOT NULL,
    CHECK (gender IN ('M','F')),
    CHECK (family_diseases IN ('N','Y')),
    CHECK (vaccination_status IN ('N','Y')),
    CHECK (organ_donor_status IN ('N','Y')),
    CHECK (consent_for_data_usage IN ('N','Y')),
    CHECK (
        LEN(phone_number) = 11 AND phone_number NOT LIKE '%[^0-9]%'
    ),
    CHECK (
        LEN(emergency_contact_number) = 11 AND emergency_contact_number NOT LIKE '%[^0-9]%'
    ),
    CHECK (
        email LIKE '%@%.%' AND
        LEN(email) - LEN(REPLACE(email, '@', '')) = 1
    ),
    CHECK (
        (insurance_provider = 'none' AND insurance_policy_number IS NULL) OR
        (insurance_provider <> 'none' AND insurance_policy_number IS NOT NULL)
    )
);



CREATE TABLE STAFFS (
    staff_id INT PRIMARY KEY IDENTITY(1,1),
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20) DEFAULT 'none',
    date_of_birth DATE,
    gender CHAR(1) NOT NULL,
    phone_number VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    identification_number VARCHAR(18) NOT NULL UNIQUE,
    staff_role VARCHAR(20) NOT NULL,
    hire_date DATE,
    CHECK (gender IN ('M', 'F')),
    CHECK (LEN(phone_number) = 11 AND phone_number NOT LIKE '%[^0-9]%'),
    CHECK (
        email LIKE '%@%.%' AND
        LEN(email) - LEN(REPLACE(email, '@', '')) = 1
    ),
    CHECK (LEN(identification_number) >= 11 AND identification_number NOT LIKE '%[^0-9]%'),
    CHECK (staff_role IN ('Doctor', 'Nurse', 'Accountant', 'Labour', 'Administrative')),
    CHECK (
        (staff_role = 'Doctor' AND identification_number LIKE 'DO%') OR
        (staff_role = 'Nurse' AND identification_number LIKE 'NU%') OR
        (staff_role = 'Accountant' AND identification_number LIKE 'AC%') OR
        (staff_role = 'Labour' AND identification_number LIKE 'LA%') OR
        (staff_role = 'Administrative' AND identification_number LIKE 'AD%')
    )
);



CREATE TABLE DOCTORS (
    doctor_id INT PRIMARY KEY IDENTITY(1,1),
    staff_id INT NOT NULL,
    staff_role VARCHAR(20) NOT NULL DEFAULT 'Doctor',
    medical_license VARCHAR(30) NOT NULL UNIQUE,
    specialization VARCHAR(30) NOT NULL,
    badge_color VARCHAR(10) DEFAULT 'White',
    salary FLOAT NOT NULL,
    CHECK (staff_role = 'Doctor'),
    CHECK (medical_license LIKE 'DO%' AND LEN(medical_license) >= 3),
    CHECK (badge_color IN ('White', 'Purple', 'Blue')),
    CHECK (
        (badge_color = 'White' AND salary BETWEEN 10000.0 AND 30000.0) OR
        (badge_color = 'Blue' AND salary BETWEEN 33000.0 AND 50000.0) OR
        (badge_color = 'Purple' AND salary BETWEEN 55000.0 AND 10000000.0)
    ),
);



CREATE TABLE NURSES(
	nurse_id INT PRIMARY KEY IDENTITY(1,1),
	staff_id INT NOT NULL,
	staff_role VARCHAR(20) NOT NULL DEFAULT 'Nurse',
	medical_license VARCHAR(30) NOT NULL UNIQUE,
	badge_color VARCHAR(10) DEFAULT 'White',
    salary FLOAT NOT NULL,
	 CHECK (staff_role = 'Nurse'),
    CHECK (medical_license LIKE 'NU%' AND LEN(medical_license) >= 3),
    CHECK (badge_color IN ('White', 'Purple', 'Blue')),
    CHECK (
        (badge_color = 'White' AND salary BETWEEN 3000.0 AND 8000.0) OR
        (badge_color = 'Blue' AND salary BETWEEN 9000.0 AND 15000.0) OR
        (badge_color = 'Purple' AND salary BETWEEN 20000.0 AND 70000.0)
    )
)

CREATE TABLE LABOURS(
	labour_id INT PRIMARY KEY IDENTITY(1,1),
	staff_id INT NOT NULL,
	staff_role VARCHAR(20) NOT NULL DEFAULT 'Labour',
	salary FLOAT NOT NULL,
	CHECK(salary BETWEEN 500.0 AND 2000.0),
	CHECK(staff_role = 'Labour')
)

CREATE TABLE ACCOUNTANTS(
	accountant_id INT PRIMARY KEY IDENTITY(1,1),
	staff_id INT NOT NULL,
	staff_role VARCHAR(20) NOT NULL DEFAULT 'Accountant',
	position VARCHAR(10) NOT NULL,
	salary FLOAT NOT NULL,
	CHECK(position IN('J.Accountant','S.Accountant')),
	CHECK((position = 'J.Accountant' AND salary BETWEEN 3000.0 AND 8000.0) OR (position = 'S.Accountant' AND salary BETWEEN 12000.0 AND 20000.0))
)

CREATE TABLE ADMINISTRATIVES(
	administrative_id INT PRIMARY KEY IDENTITY(1,1),
	staff_id INT NOT NULL,
	staff_role VARCHAR(20) NOT NULL DEFAULT 'Administrative',
	position VARCHAR(10) NOT NULL,
	salary FLOAT NOT NULL,
	CHECK(position IN('J.Admin','S.Admin')),
	CHECK((position = 'J.Admin' AND salary BETWEEN 300000.0 AND 800000.0) OR (position = 'S.Admin' AND salary BETWEEN 1200000.0 AND 20000000.0))
)


--DROP TABLE DOCTORS
--DROP TABLE NURSES
--DROP TABLE LABOURS
--DROP TABLE ACCOUNTANTS
--DROP TABLE ADMINISTRATIVES

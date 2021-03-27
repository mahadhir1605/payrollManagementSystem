CREATE TABLE `employee_ctc` (
  `emp_id` bigint NOT NULL AUTO_INCREMENT,
  `basic_salary` double DEFAULT NULL,
  `special_allowance` double DEFAULT NULL,
  `HRA` double DEFAULT NULL,
  `LTA` double DEFAULT NULL,
  `food_coupon` double DEFAULT NULL,
  `PF` double DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `employee` (
  `emp_id` bigint NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `date_of_joining` date DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `bank_acc_no` bigint DEFAULT NULL,
  `phone_num` bigint DEFAULT NULL,
  `email_id` varchar(200) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `usertype` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee_ctc` (`emp_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee_attendance` (
  `RECORD_ID` bigint NOT NULL AUTO_INCREMENT,
  `emp_id` bigint NOT NULL,
  `month_` varchar(200) DEFAULT NULL,
  `year_` int DEFAULT NULL,
  `LOP_days` int DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee_available_leaves` (
  `RECORD_ID` bigint NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` bigint NOT NULL,
  `EARNED_LEAVES` int DEFAULT NULL,
  `SICK_LEAVES` int DEFAULT NULL,
  `EMERGENCY_LEAVES` int DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`),
  UNIQUE KEY `EMPLOYEE_ID` (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `investment_proofs` (
  `RECORD_ID` bigint NOT NULL AUTO_INCREMENT,
  `employee_id` bigint DEFAULT NULL,
  `financial_year` varchar(200) DEFAULT NULL,
  `hra_amount` double DEFAULT NULL,
  `hra_file_bytes` longblob,
  `childern_tution_fee_amount` double DEFAULT NULL,
  `childern_tution_fee_file_bytes` longblob,
  `education_loan_interest_amount` double DEFAULT NULL,
  `education_loan_interest_file_bytes` longblob,
  `medical_insurance_amount` double DEFAULT NULL,
  `medical_insurance_file_bytes` longblob,
  `mutual_funds_amount` double DEFAULT NULL,
  `mutual_funds_file_bytes` longblob,
  `status_` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `leavedata` (
  `RECORD_ID` bigint NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` bigint NOT NULL,
  `LEAVE_TYPE` varchar(200) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `TOTAL_DAYS` int DEFAULT NULL,
  `REASON` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `otptracker` (
  `employeeId` int NOT NULL,
  `otp` int DEFAULT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `payslip` (
  `RECORD_ID` bigint NOT NULL AUTO_INCREMENT,
  `emp_id` bigint DEFAULT NULL,
  `emp_name` varchar(200) DEFAULT NULL,
  `department` varchar(200) DEFAULT NULL,
  `designation` varchar(200) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `date_of_joining` date DEFAULT NULL,
  `gender` varchar(200) DEFAULT NULL,
  `bank_acc_num` bigint DEFAULT NULL,
  `phone_num` bigint DEFAULT NULL,
  `email_id` varchar(200) DEFAULT NULL,
  `basic_salary` double DEFAULT NULL,
  `special_allowance` double DEFAULT NULL,
  `HRA` double DEFAULT NULL,
  `LTA` double DEFAULT NULL,
  `food_coupon` double DEFAULT NULL,
  `provident_fund` double DEFAULT NULL,
  `professional_tax` double DEFAULT NULL,
  `LOP_deductions` double DEFAULT NULL,
  `total_earnings` double DEFAULT NULL,
  `total_deductions` double DEFAULT NULL,
  `net_pay` double DEFAULT NULL,
  `month_` varchar(200) DEFAULT NULL,
  `year_` int DEFAULT NULL,
  `days_in_month` int DEFAULT NULL,
  `LOP_days` int DEFAULT NULL,
  `net_days_worked` int DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


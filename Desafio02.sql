CREATE TABLE `employee` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` int(11) NOT NULL,
 `email` int(11) NOT NULL,
 PRIMARY KEY (`id`)
) ;

CREATE TABLE `salary` (
 `id` int(11) NOT NULL,
 `value` decimal(10,0) NOT NULL,
 `payment_date` date NOT NULL,
 `employee_id` int(11) NOT NULL,
 KEY `employee_id` (`employee_id`),
 CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee`
(`id`)
);


    SELECT e.id AS Id, employee.name AS Nome, AVG(salary.value) AS media_salarial 
    FROM employee e
    INNER JOIN salary s ON e.id = s.employee_id
    WHERE s.payment_date > CURRENT_DATE - INTERVAL 3 MONTH
    GROUP BY e.id
    ORDER BY media_salarial DESC
    LIMIT 3;
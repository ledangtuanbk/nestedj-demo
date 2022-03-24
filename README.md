# Create application-local.properties
```
cp src/main/resources/application-template.properties -> src/main/resources/application-local.properties
``` 



# Update username/password database before run
```
spring.datasource.url=jdbc:mariadb://localhost:3306/test?useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=haproxy
spring.datasource.password=
```

# create table if not existed
```sql
CREATE TABLE `nested_nodes` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`node_name` varchar(50) NOT NULL,
`tree_left` int(11) NOT NULL,
`tree_right` int(11) NOT NULL,
`tree_level` int(11) NOT NULL,
`parent_id` int(11) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
```
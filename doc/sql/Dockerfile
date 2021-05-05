FROM mysql:5.7.26
ADD my.cnf /etc/mysql/conf.d/my.cnf
COPY blade/blade-saber-mysql.sql /docker-entrypoint-initdb.d/blade-saber-mysql.sql
# COPY blade/blade-sword-mysql.sql /docker-entrypoint-initdb.d/blade-sword-mysql.sql
# COPY seata/seata_order.sql /docker-entrypoint-initdb.d/seata_order.sql
# COPY seata/seata_storage.sql /docker-entrypoint-initdb.d/seata_storage.sql
# COPY seata/seata.sql /docker-entrypoint-initdb.d/seata.sql
EXPOSE 3306

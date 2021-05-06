FROM mysql:5.7.26
ADD my.cnf /etc/mysql/conf.d/my.cnf
COPY ../../../doc/sql/blade/blade-saber-mysql.sql /docker-entrypoint-initdb.d/blade-saber-mysql.sql
# COPY ../../../doc/sql/blade/blade-sword-mysql.sql /docker-entrypoint-initdb.d/blade-sword-mysql.sql
# COPY ../../../doc/sql/seata/seata_order.sql /docker-entrypoint-initdb.d/seata_order.sql
# COPY ../../../doc/sql/seata/seata_storage.sql /docker-entrypoint-initdb.d/seata_storage.sql
# COPY ../../../doc/sql/seata/seata.sql /docker-entrypoint-initdb.d/seata.sql
EXPOSE 3306

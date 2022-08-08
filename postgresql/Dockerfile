FROM postgres:14.4-alpine
MAINTAINER ITAcademy

ADD /VotingService/ddl/*.sql /docker-entrypoint-initdb.d/
ADD /VotingService/dml/*.sql /docker-entrypoint-initdb.d/

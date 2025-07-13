FROM postgres:latest

# Настройка окружения
ENV POSTGRES_USER=martin
ENV POSTGRES_PASSWORD=martin2004
ENV POSTGRES_DB=test_bd

EXPOSE 5432

COPY init.sql /docker-entrypoint-initdb.d/

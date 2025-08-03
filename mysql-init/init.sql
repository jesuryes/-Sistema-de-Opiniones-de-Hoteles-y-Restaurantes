CREATE DATABASE IF NOT EXISTS authdb;
CREATE DATABASE IF NOT EXISTS placedb;
CREATE DATABASE IF NOT EXISTS reviewdb;

docker-compose down -v
docker-compose up --build

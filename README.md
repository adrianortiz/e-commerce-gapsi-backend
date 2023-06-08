# Gapsi - Back-end - Spring Boot
Back-end basado en Spring Boot

**Características:**
* GET API Inicio
* CRUD API Proveedor
* Cargar datos de Archivo JSON con CommandLineRunner
* Generar archivo JSON y guardar los Proveedores

### Requerimientos
* Maven
* Java 11
* Spring Boot 2.7.12

### ¿Cómo instalar?

* Descargar el proyecto dentro de un directorio especifico
* Entrar al directorio del proyecto desde Consola/Terminal

    - Descargar dependencias y empaquetar: `mvn clean install`
    
* O Ejecutar desde el IDE
  - Importar como proyeto Maven y ejecutar la clase `EcommerceApplication.java`
    
* Url base de la API `http://localhost:8081/rest/proveedor`

## API
* Descargar Postman e importar los archivos descriptivos de la API:

    - Postman: Environment [`localhost.postman_environment.json`](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/postman/localhost.postman_environment.json)
    - Postman: API [`API_Proveedor.postman_collection.json`](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/postman/API_Proveedor.postman_collection.json)

![API](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/images/img-01-backend.png)
![API](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/images/img-02-backend.png)
![API](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/images/img-03-backend.png)
![API](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/images/img-04-backend.png)
![API](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/images/img-05-backend.png)
![API](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/images/img-06-backend.png)
![API](https://github.com/adrianortiz/e-commerce-gapsi-backend/blob/main/src/main/resources/images/img-07-backend.png)


## Spring Framework

### License

The Spring framework is open-sourced software licensed under the [MIT license](http://opensource.org/licenses/MIT)
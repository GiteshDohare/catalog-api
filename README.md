# catalog-api

Note: Some data are being populated on app startup using InitialDataPopulator class

Swagger Documentation: http://localhost:8080/v3/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config


Endpoints as per requirement (see swagger doc above for all endpoints):

1) To create a category:  POST http://localhost:8080/categories
2) To create category attributes: POST http://localhost:8080/categories/{category_id}/attributes
3) To create a product by linking it to category and its attributes: POSt http://localhost:8080/categories/{category_id}/products
4) Get product by id: GET http://localhost:8080//products/{product_id}
5) get category attributes by category id: GET http://localhost:8080/categories/{category_id}


Carrito de compras desarrollado en spring


para la obtencion del token se uso Jwt y se traen los usarios desde la entity Userlogin, por defecto son:
usuario: admin, contraseña: admin
usuario: user, contraseña: user
estos datos son cargados desde una script sql que se ejecuta al iniciar el proyecto.

para las demas entyties se hace uso de los servicios solocitados en la prueba para cada una.

la tabla de productos se llena desde un archivo plano, haciendo uso del siguiente endpoint:
"localhost:8082/products/upFiles/textoPlano.txt"

este endpoint puede usar cualquier texto plano que se encuentre en la carpeta static del proyecto, lo
unico que varia es el nombre del archivo que se envia por la url del endpoint.

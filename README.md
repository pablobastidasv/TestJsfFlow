# README #

Este proyecto tiene como objetivo guardar diversas pruebas de ejemplos de traspaso de parametros entre vistas 
utilizando los diferentes scopes de JSF.

Este proyecto esta hecho y probado sobre wildfly8. Al ser JEE estandar no deberia presentar problemas con diferentes 
servidores de aplicaciones que soporte JEE 7

## Recomendacion DB ##

La primera vez que se ejecute la aplicacion descomentar la linea 8 del archivo persistence.xml, una vez ejecutada por primera vez
la pueden volver a comentar, de no hacerlo, se perdera la informacion en cada despliegue.

## Servidor de aplicaciones ##

El app yo lo ejecute sobre un wildfly 8, en mi caso le adicione el siguiente parametro al inicio del sistema.

    -XX:PermSize=128m -XX:MaxPermSize=128m
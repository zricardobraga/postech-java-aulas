# em um um container com a imagem do ubuntu
FROM ubuntu:latest
# vai atualizar o OS
RUN apt update
# e depois instalar o servidor web
RUN apt install nginx -y

VOLUME [ "/var/www/html" ]

WORKDIR "/var/www/html"

# ADD index.html index.html

COPY index.html index.html

# CMD [ "/usr/sbin/nginx", "-g", "daemon off;" ]
ENTRYPOINT [ "/usr/sbin/nginx", "-g", "daemon off;" ]

# expose ajuda a documentar o dockfile, mostrando como interagir com o mundo externo
EXPOSE 80
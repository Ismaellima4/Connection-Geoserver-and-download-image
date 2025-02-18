# Como executar o projeto

Este projeto utiliza o Docker Compose para gerenciar os contêineres.

## Pré-requisitos

Certifique-se de ter o Docker e o Docker Compose instalados em sua máquina.

## Executando o projeto

1. Clone este repositório.
2. Navegue até o diretório do projeto no terminal.
3. Execute o seguinte comando:

```bash
docker-compose up -d
```

## Configurando o Geoserver

1. acesse localhost:8080/geoserver
2. crie um workspace
3. crie um store usado os shapefiles de workspaces/nome_workspace/shapefiles
4. crie uma nova layer usando o store criado anterior e published

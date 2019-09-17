# mocking-api
> mocking-api是API接口管理系统的接口工程

# 项目依赖
> wkhtmltopdf

# 项目部署
初始化先创建一个数据库 mocking，修改项目中数据库账号密码，导入db/mockgin.sql初始化脚本

## 普通部署
```bash
jave -jar mocking-0.0.1-SNAPSHOT.jar
```

## docker部署
新建目录，将fonts目录 docker-compose.yml，Dockerfile及编译后的mocking-0.0.1-SNAPSHOT.jar拷贝过去
在目录下运行命令
```bash
docker-compose up -d
```
访问localhost:8080查看接口启动情况
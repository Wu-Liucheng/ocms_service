1.运行镜像，设置root账号初始密码（123456），映射本地宿主机端口3306到Docker端口3306。测试过程没有挂载本地数据盘：

```shell
docker run -it --rm --name mysql -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 -d mysql 
```

2.在容器内登陆Mysql:

```shell
mysql -uroot -p123456
```

3.更改权限

```shell
ALTER user 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
```

4.刷新

```shell
FLUSH PRIVILEGES;
```


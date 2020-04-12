```shell
sudo docker run -p 6379:6379 --name redis -v /Users/a1/docker/redis.conf:/etc/redis/redis.conf -v /Users/a1/docker/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes
```

其中/Users/a1是本用户的文件夹


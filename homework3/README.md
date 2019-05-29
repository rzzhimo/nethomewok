### 完成homework3
> 把task3中的wordladder拆成两个微服务放到容器中
#### 用法
> 使用命令下拉图像  
$ docker pull rzzhimo/wordladderapp  
$ docker pull rzzhimo/loginapp

> 创建docker容器  
$ docker network create net  
$ docker run --network net --name host -p 8086:8086 rzzhimo/wordladderapp  
$ docker run --network net --name checkhost -p 8088:8088 rzzhimo/loginapp

> 测试方法  
1、首次输入 http://localhost:8086/wordladder/ladder?start=data&end=code 显示"未登录请先登录"  
2、输入 http://localhost:8086/wordladder/login?username=uuu&password=111 登录成功返回“true”   
3、再次输入 http://localhost:8086/wordladder/ladder?start=data&end=code 返回wordladder结果


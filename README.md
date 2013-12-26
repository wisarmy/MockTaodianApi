编译运行
----------

        call mvn assembly:assembly
        call java -jar target\MockTaodianApi-0.0.1.jar -short_data data\short_url.txt
        
使用说明
----------
1. -short_data 自己准备好 Api需要传入的数据 文件第一行需要配置api返回字段与数据行相对应：FORMAT_RULE:short_key;user_id;shop_id;create_source;long_url

2. -Dhttp.port 修改端口 默认8090
3. 接口访问地址 <http://localhost:8090/api/route>
       

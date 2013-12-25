编译运行
----------

        call mvn assembly:assembly
        call java -jar target\MockTaodianApi-0.0.1.jar -short_data short_url.txt
        
使用说明
----------
1. -short_data 自己准备好 Api需要传入的数据 需要在项目跟路径下创建一个data目录来存放数据文件(暂支持该路径)
2. -Dhttp.post 修改端口 默认8090
3. 接口访问地址 <http://localhost:8090/api/router>
       

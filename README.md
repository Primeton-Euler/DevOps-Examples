# DevOps-Examples
  
  
## Usage  
  
使用租户`abc`登陆`PORTAL-FE`门户，新建一个产品`test`，在这个产品下新建一个组件（`springboot类型`），组件编码为 `c-springboot`，查看产品的`Git库地址`，克隆仓库到本地，参考下面命令：  
  
`mkdir -p ~/DevOps/git`  
`cd ~/DevOps/git`  
`git clone http://euler-gitlab.theplatform.top/tenant-abc/tenant-abc-test.git `  
  
## Download DevOps Example Project

[https://github.com/Primeton-Euler/DevOps-Examples.git](https://github.com/Primeton-Euler/DevOps-Examples.git)  
  
`cd ~/DevOps/git`  
`git clone https://github.com/Primeton-Euler/DevOps-Examples.git`  
`rm -rf DevOps-Examples/.git`  
`cp -r DevOps-Examples/* tenant-abc-test/`  
  
`# commit source code`  
`cd ~/DevOps/git/tenant-abc-test`  
`git add .`  
`git commit -m "Update: commit source code"`  
`git push`  
  
也可以从github仓库`https://github.com/Primeton-Euler/DevOps-Examples.git`首页下载源码包：  
  
  
<img src="README/source.png" />  
  
  
`# or use curl/wget linux command tool`  
`curl https://codeload.github.com/Primeton-Euler/DevOps-Examples/zip/master -O /tmp/DevOps-Examples.zip`  
`unzip /tmp/DevOps-Examples.zip -d ~/git/`  
`# ...`  
  
  
## Configuration injection items  
  
打包某个组件之前请先配置该组件，配置项如下所示：（部分配置项有默认值，具体参考项目源码）  
  
### (1) c-springboot  
  
`db.url (*)`  
`db.user (*)`  
`db.password (*)`  
`home.title`  
  
### (2) c-frontapp  
  
`title`  
`body`  
`key1`  
`key2`  
`key3`  
`key4`  
  
### (3) c-war  
  
`title`  
`body`  
`key1`  
`key2`  
`key3`  
`key4`  
  
### (4) c-runnablejar  
  
`title`  
`body`  
`key1`  
`key2`  
`key3`  
`key4`  
  
  
## Multi-Component
  
在 test产品下再新建1-3个组件，可选择 `c-war（war类型）、c-frontapp（frontapp类型）、c-runnablejar（springboot类型）`， `https://github.com/Primeton-Euler/DevOps-Examples.git` 示例代码库已经包含该这2个组件的示例代码；可以直接在页面上编译打包这两个组件。如果你新建的组件的编码不是默认值  `c-springboot、c-war、c-frontapp、c-runnablejar` ，请修改目录结构和根pom.xml文件：  
  
`# Source Code Directory`  
`|- pom.xml -> module改为各个组件编码`  
`|- c-springboot -> ${A组件编码}`  
`|- c-war -> ${B组件编码}`  
`|- c-frontapp -> ${C组件编码}`  
`|- c-runnablejar -> ${D组件编码}`  
`|- .git`  
`|- ...`  
  
如果不遵循默认的组件目录规范，新建组件时，请在新建向导的表单中指定`构建入口`和`产物路径`。你还可以根据自己的项目需要继续添加其它组件。  
  
  
## Other  
  
为方便测试（节约时间）`c-springboot`示例应用数据源启动自初始化，无需手动拷贝脚本执行。  
`c-runnablejar`示例不是真正的`springboot`项目，只要是满足以下几点的`FatJar`，都可以选择`springboot`类型组件：  
  
`(1) /META-INF/MANIFEST.MF 定义了JAR启动类Main-Class;`  
`(2) 包含其运行所需依赖的所有类,可以使用 maven-assembly-plugin(jar-with-dependencies) 插件来编译FatJar,springboot有自己的打包插件;`  
`(3) 服务对外提供服务端口一定是8080,允许有多个端口,但只有8080对外能访问;`  
`(4) Jar要支持JRE1.8环境下运行;`  
  
## Custom    
  
[https://github.com/Primeton-Euler/Multi-Wars](https://github.com/Primeton-Euler/Multi-Wars)
  
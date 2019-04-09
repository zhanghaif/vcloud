# vcloud-app

### 使用框架

    nodejs10.15.3
    npm6.4.1
    vue2.9.6
    vue-cli2.9.6
    axios0.18.0
    element-ui2.6.1

### 环境说明

### 开发环境

    nodejs10.15.3
    npm6.4.1
    vue2.9.6
    vue-cli2.9.6
    
### 运行环境

    nodejs10.15.3
    vue-cli2.9.6
    
### 打包
    
    npm run build
    
### 运行
    
    npm run dev
    
### 项目下载部署本地
  
    1、安装node环境，如果本地有node环境，请确认版本是否是10.0以上的版本，如果不是请更新node版本
      1）node下载地址 https://nodejs.org/en/download/ 
      2）node版本更新 在官网下载覆盖以前的版本
      3）安装淘宝镜像 npm install -g cnpm --registry=https://registry.npm.taobao.org
    2、安装vue-cli
      cnpm install -g vue-cli@2.9.6
    3、初始化vue，下载vue脚手架,下载项目部署本地
      1）在本地新建文件夹，在文件夹下打开命令行窗口或者git bash
      2）vue init webpack demo(项目名),project name、project description、author这三个直接回车，vue build选择第一个（runtime + compiler）,vue-router选择yes，其他都选择no，mended（use arrow keys）选择第三个 No, I will handle that myself
      3）下载项目
          （1）先不要下载项目依赖，在github上下载项目
          （2）下载项目两种方式，git下载和直接在github项目地址上下载
          （3）github项目地址 https://github.com/zhanghaif/vcloud ，点击右侧的clone or download，选择Download ZIP
          （4）git下载，在本地创建一个文件夹， 重复（3）复制input框中的url（以https开头的）右键打开git bash，把复制的url粘贴到git bash
      4）部署本地
          （1）把下载的项目中的vcloud-app中的src文件夹和package.json文件复制到demo（项目名）文件夹下，替换对应的文件夹和文件
          （2）在命令行中 按顺序执行cd demo（项目名）cnpm install
          （3）下载完依赖后，执行npm run dev 运行项目
      




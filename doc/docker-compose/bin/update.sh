#!/usr/bin/env bash

echo '=====开始更新蘑菇博客镜像====='

echo '=====开始关闭运行的容器====='
sh kernShutdown.sh

echo '=====开始更新action-gateway====='
docker pull registry.cn-shenzhen.aliyuncs.com/actionblog/action_gateway

echo '=====开始更新action-admin====='
docker pull registry.cn-shenzhen.aliyuncs.com/actionblog/action_admin

echo '=====开始更新action-web====='
docker pull registry.cn-shenzhen.aliyuncs.com/actionblog/action_web

echo '=====开始更新action-sms====='
docker pull registry.cn-shenzhen.aliyuncs.com/actionblog/action_sms

echo '=====开始更新action-picture====='
docker pull registry.cn-shenzhen.aliyuncs.com/actionblog/action_picture

echo '=====开始更新vue_action_admin====='
docker pull registry.cn-shenzhen.aliyuncs.com/actionblog/vue_action_admin

echo '=====开始更新vue_action_web====='
docker pull registry.cn-shenzhen.aliyuncs.com/actionblog/vue_action_web

echo '=====删除docker标签为none的镜像====='
docker images | grep none | awk '{print $3}' | xargs docker rmi

echo '=====开始运行的一键部署脚本====='
sh kernStartup.sh

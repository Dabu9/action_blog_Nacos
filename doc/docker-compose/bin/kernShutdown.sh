#!/usr/bin/env bash

echo '=====开始结束运行蘑菇博客服务====='

echo '=====结束运行portainer可视化工具====='
docker-compose -f ../yaml/portainer.yml down

echo '=====结束运行mysql====='
docker-compose -f ../yaml/mysql.yml down

echo '=====结束运行nacos====='
docker-compose -f ../yaml/nacos.yml down

echo '=====结束运行rabbitmq====='
docker-compose -f ../yaml/rabbitmq.yml down

echo '=====结束运行redis====='
docker-compose -f ../yaml/redis.yml down

echo '=====结束运行action_data====='
docker-compose -f ../yaml/action_data.yml down

echo '=====结束运行minio====='
docker-compose -f ../yaml/minio.yml down


echo '=========================='
echo '=====结束后台服务运行====='
echo '=========================='

echo '=====结束运行action_gateway====='
docker-compose -f ../yaml/action_gateway.yml down

echo '=====结束运行action_admin====='
docker-compose -f ../yaml/action_admin.yml down

echo '=====结束运行action_picture====='
docker-compose -f ../yaml/action_picture.yml down

echo '=====结束运行action_sms====='
docker-compose -f ../yaml/action_sms.yml down

echo '=====结束运行action_web====='
docker-compose -f ../yaml/action_web.yml down


echo '=========================='
echo '=====结束前台服务运行====='
echo '=========================='

echo '=====结束运行vue_action_admin====='
docker-compose -f ../yaml/vue_action_admin.yml down


echo '=====结束运行vue_action_web====='
docker-compose -f ../yaml/vue_action_web.yml down

echo '=============================='
echo '=====所有服务已经结束运行====='
echo '=============================='
#!/usr/bin/env bash

echo '=====开始关闭蘑菇博客环境====='

echo '=====开始关闭mysql====='
docker-compose -f ../yaml/mysql.yml down

echo '=====开始关闭redis====='
docker-compose -f ../yaml/redis.yml down

echo '=====开始关闭action_data====='
docker-compose -f ../yaml/action_data.yml down

echo '=====开始关闭minio====='
docker-compose -f ../yaml/minio.yml down

echo '======================'
echo '=====开始关闭后台====='
echo '======================'

echo '=====开始关闭action_go====='
docker-compose -f ../yaml/action_blog_go.yml down

echo '=====开始关闭前台====='
echo '======================'

echo '=====开始关闭vue_action_admin====='
docker-compose -f ../yaml/vue_action_admin.yml down


echo '=====开始关闭vue_action_web====='
docker-compose -f ../yaml/vue_action_web.yml down

echo '================================================================='
echo '=====【蘑菇博客Go版关闭成功】====='
echo '================================================================='

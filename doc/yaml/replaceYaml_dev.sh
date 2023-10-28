#!/bin/bash
echo "#######################"
echo "##### begin copy ######"
echo "#######################"

echo "###### copy action_admin ########"
cp ./conf/dev/action_admin/application.yml ../../action_admin/src/main/resources/
cp ./conf/dev/action_admin/bootstrap.yml ../../action_admin/src/main/resources/

echo "###### copy action_gateway ########"
cp ./conf/dev/action_gateway/application.yml ../../action_gateway/src/main/resources/
cp ./conf/dev/action_gateway/bootstrap.yml ../../action_gateway/src/main/resources/

echo "###### copy action_monitor ########"
cp ./conf/dev/action_monitor/application.yml ../../action_monitor/src/main/resources/
cp ./conf/dev/action_monitor/bootstrap.yml ../../action_monitor/src/main/resources/

echo "###### copy action_picture ########"
cp ./conf/dev/action_picture/application.yml ../../action_picture/src/main/resources/
cp ./conf/dev/action_picture/bootstrap.yml ../../action_picture/src/main/resources/

echo "###### copy action_search ########"
cp ./conf/dev/action_search/application.yml ../../action_search/src/main/resources/
cp ./conf/dev/action_search/bootstrap.yml ../../action_search/src/main/resources/

echo "###### copy action_sms ########"
cp ./conf/dev/action_sms/application.yml ../../action_sms/src/main/resources/
cp ./conf/dev/action_sms/bootstrap.yml ../../action_sms/src/main/resources/

echo "###### copy action_spider ########"
cp ./conf/dev/action_spider/application.yml ../../action_spider/src/main/resources/
cp ./conf/dev/action_spider/bootstrap.yml ../../action_spider/src/main/resources/

echo "###### copy action_web ########"
cp ./conf/dev/action_web/application.yml ../../action_web/src/main/resources/
cp ./conf/dev/action_web/bootstrap.yml ../../action_web/src/main/resources/
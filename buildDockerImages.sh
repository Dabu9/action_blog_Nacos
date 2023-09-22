echo '=====开始mvn clean====='
mvn clean

echo '=====开始mvn install&&package====='
mvn install -DskipTests=true && mvn package -DskipTests=true

echo '=====开始构建镜像====='
echo '=====开始构建action_admin====='
cd action_admin
mvn docker:build
cd ..

echo '=====开始构建action_gateway====='
cd action_gateway
mvn docker:build
cd ..

echo '=====开始构建action_monitor==CLC==='
cd action_monitor
mvn docker:build
cd ..

echo '=====开始构建action_picture====='
cd action_picture
mvn docker:build
cd ..

echo '=====开始构建action_search====='
cd action_search
mvn docker:build
cd ..

echo '=====开始构建action_sms====='
cd action_sms
mvn docker:build
cd ..

echo '=====开始构建action_spider====='
cd action_spider
mvn docker:build
cd ..

echo '=====开始构建action_web====='
cd action_web
mvn docker:build
cd ..

echo '=====镜像构建结束====='

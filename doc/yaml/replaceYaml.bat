echo #######################
echo ##### begin copy ######
echo #######################

echo ###### copy action_admin ########
copy .\conf\prod\action_admin\application.yml ..\..\action_admin\src\main\resources\
copy .\conf\prod\action_admin\bootstrap.yml ..\..\action_admin\src\main\resources\


echo ###### copy action_gateway ########
copy .\conf\prod\action_gateway\application.yml ..\..\action_gateway\src\main\resources\
copy .\conf\prod\action_gateway\bootstrap.yml ..\..\action_gateway\src\main\resources\


echo ###### copy action_monitor ########
copy .\conf\prod\action_monitor\application.yml ..\..\action_monitor\src\main\resources\
copy .\conf\prod\action_monitor\bootstrap.yml ..\..\action_monitor\src\main\resources\


echo ###### copy action_picture ########
copy .\conf\prod\action_picture\application.yml ..\..\action_picture\src\main\resources\
copy .\conf\prod\action_picture\bootstrap.yml ..\..\action_picture\src\main\resources\


echo ###### copy action_search ########
copy .\conf\prod\action_search\application.yml ..\..\action_search\src\main\resources\
copy .\conf\prod\action_search\bootstrap.yml ..\..\action_search\src\main\resources\


echo ###### copy action_sms ########
copy .\conf\prod\action_sms\application.yml ..\..\action_sms\src\main\resources\
copy .\conf\prod\action_sms\bootstrap.yml ..\..\action_sms\src\main\resources\


echo ###### copy action_spider ########
copy .\conf\prod\action_spider\application.yml ..\..\action_spider\src\main\resources\
copy .\conf\prod\action_spider\bootstrap.yml ..\..\action_spider\src\main\resources\


echo ###### copy action_web ########
copy .\conf\prod\action_web\application.yml ..\..\action_web\src\main\resources\
copy .\conf\prod\action_web\bootstrap.yml ..\..\action_web\src\main\resources\

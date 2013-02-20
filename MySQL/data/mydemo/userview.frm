TYPE=VIEW
query=select `u`.`id` AS `id`,`u`.`loginName` AS `loginName`,`u`.`name` AS `name`,`u`.`password` AS `password`,`u`.`companyId` AS `companyId`,`u`.`departmentId` AS `departmentId`,`u`.`isManager` AS `isManager`,`u`.`hireDate` AS `hireDate`,`c`.`companyLevel` AS `companyLevel`,`c`.`name` AS `companyName` from (`mydemo`.`demouser` `u` join `mydemo`.`company` `c`) where (`u`.`companyId` = `c`.`id`)
md5=ac7e6a1e321d64d0c55b88982eb0313d
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2011-12-20 05:16:58
create-version=1
source=select `u`.`id` AS `id`,`u`.`loginName` AS `loginName`,`u`.`name` AS `name`,`u`.`password` AS `password`,`u`.`companyId` AS `companyId`,`u`.`departmentId` AS `departmentId`,`u`.`isManager` AS `isManager`,`u`.`hireDate` AS `hireDate`,`c`.`companyLevel` AS `companyLevel`,`c`.`name` AS `companyName` from (`demouser` `u` join `company` `c`) where (`u`.`companyId` = `c`.`id`)
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `u`.`id` AS `id`,`u`.`loginName` AS `loginName`,`u`.`name` AS `name`,`u`.`password` AS `password`,`u`.`companyId` AS `companyId`,`u`.`departmentId` AS `departmentId`,`u`.`isManager` AS `isManager`,`u`.`hireDate` AS `hireDate`,`c`.`companyLevel` AS `companyLevel`,`c`.`name` AS `companyName` from (`mydemo`.`demouser` `u` join `mydemo`.`company` `c`) where (`u`.`companyId` = `c`.`id`)

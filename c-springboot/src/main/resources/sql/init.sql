--DROP TABLE `demo_json_template`;
--DROP TABLE `demo_sales_item`;
--DROP TABLE `demo_product`;

CREATE TABLE `demo_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by_id` bigint(20) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_by_id` bigint(20) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `display_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;


CREATE TABLE `demo_sales_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by_id` bigint(20) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_by_id` bigint(20) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  `number` int(11) NOT NULL,
  `type` varchar(64) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

alter table `demo_sales_item` add constraint FK_ID foreign key(`product_id`) REFERENCES `demo_product`(`id`);

CREATE TABLE `demo_json_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by_id` bigint(20) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_by_id` bigint(20) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `template_key` varchar(64) DEFAULT NULL,
  `template_value` longtext,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- Product
INSERT INTO `demo_product` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `description`, `display_name`) VALUES (1, 1, '2016-01-01', 1, 1, '2016-01-02', 'product1', 'Product1', 'Product1');
INSERT INTO `demo_product` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `description`, `display_name`) VALUES (2, 1, '2016-02-01', 1, 1, '2016-02-02', 'product2', 'Product2', 'Product2');
INSERT INTO `demo_product` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `description`, `display_name`) VALUES (3, 1, '2016-03-01', 1, 1, '2016-03-02', 'product3', 'Product3', 'Product3');
																						   
-- sales_item
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (1, 1, '2016-01-23', 1, 1, '2016-02-23', 'item1', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (2, 1, '2016-02-23', 1, 1, '2016-01-23', 'item2', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (3, 1, '2016-03-23', 1, 1, '2016-02-23', 'item3', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (4, 1, '2016-04-23', 1, 1, '2016-03-23', 'item4', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (5, 1, '2016-05-23', 1, 1, '2016-04-23', 'item5', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (6, 1, '2016-01-23', 1, 1, '2016-05-23', 'item6', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (7, 1, '2016-01-23', 1, 1, '2016-01-23', 'item7', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (8, 1, '2016-02-23', 1, 1, '2016-01-23', 'item8', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (9, 1, '2016-02-23', 1, 1, '2016-02-23', 'item9', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (10, 1, '2016-03-23', 1, 1, '2016-05-23', 'item10', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (11, 1, '2016-03-23', 1, 1, '2016-03-23', 'item11', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (12, 1, '2016-04-23', 1, 1, '2016-03-23', 'item12', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (13, 1, '2016-04-23', 1, 1, '2016-04-23', 'item13', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (14, 1, '2016-05-23', 1, 1, '2016-04-23', 'item14', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (15, 1, '2016-02-23', 1, 1, '2016-05-23', 'item15', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (16, 1, '2016-05-23', 1, 1, '2016-02-23', 'item16', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (17, 1, '2016-01-23', 1, 1, '2016-05-23', 'item17', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (18, 1, '2016-01-23', 1, 1, '2016-01-23', 'item18', 100, 'subscribe', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (19, 1, '2016-01-23', 1, 1, '2016-01-23', 'item19', 100, 'subscribe', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (20, 1, '2016-01-23', 1, 1, '2016-01-23', 'item20', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (21, 1, '2016-01-23', 1, 1, '2016-01-23', 'item21', 100, 'subscribe', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (22, 1, '2016-02-23', 1, 1, '2016-01-23', 'item22', 100, 'subscribe', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (23, 1, '2016-03-23', 1, 1, '2016-02-23', 'item23', 100, 'subscribe', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (24, 1, '2016-04-23', 1, 1, '2016-03-23', 'item24', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (25, 1, '2016-04-23', 1, 1, '2016-04-23', 'item25', 100, 'subscribe', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (26, 1, '2016-04-23', 1, 1, '2016-04-23', 'item26', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (27, 1, '2016-04-23', 1, 1, '2016-04-23', 'item27', 100, 'subscribe', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (28, 1, '2016-04-23', 1, 1, '2016-04-23', 'item28', 100, 'subscribe', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (29, 1, '2016-03-23', 1, 1, '2016-04-23', 'item29', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (30, 1, '2016-02-23', 1, 1, '2016-03-23', 'item30', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (31, 1, '2016-03-23', 1, 1, '2016-02-23', 'item31', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (32, 1, '2016-03-23', 1, 1, '2016-03-23', 'item32', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (33, 1, '2016-02-23', 1, 1, '2016-03-23', 'item33', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (34, 1, '2016-02-23', 1, 1, '2016-02-23', 'item34', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (35, 1, '2016-02-23', 1, 1, '2016-02-23', 'item35', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (36, 1, '2016-02-23', 1, 1, '2016-02-23', 'item36', 100, 'business', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (37, 1, '2016-02-23', 1, 1, '2016-02-23', 'item37', 100, 'purpose', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (38, 1, '2016-02-23', 1, 1, '2016-02-23', 'item38', 100, 'complete', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (39, 1, '2016-02-23', 1, 1, '2016-02-23', 'item39', 100, 'complete', 1);
INSERT INTO `demo_sales_item` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `code`, `number`, `type`, `product_id`) VALUES (40, 1, '2016-02-23', 1, 1, '2016-02-23', 'item40', 100, 'complete', 1);

-- json_template
INSERT INTO `demo_json_template` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `template_key`, `template_value`) VALUES (1, 1, '2016-04-22', 1, 1, '2016-04-22', 'tendency', '{
    title: {
        text: '',
        subtext: '',
        x: \'center\',
        y: \'center\',
        itemGap: 20,
        textStyle : {
            color : \'rgba(30,144,255,0.8)\',
            fontFamily : \'微软雅黑\',
            fontSize : 30,
            fontWeight : \'bolder\'
        }
    },
    tooltip : {
        show: true,
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : \'vertical\',
        x : document.getElementById(\'main\').offsetWidth / 2,
        y : 45,
        itemGap:12,
        data:[]
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    series : [
        {
        	id:\'purpose\',
            name:\'购买意向\',
            type:\'pie\',
            clockWise:false,
            radius : [125, 150],
            itemStyle : dataStyle,
            data:[
                {
                    value:0,
                    name:''
                },
                {
                    value:0,
                    name:\'invisible\',
                    itemStyle : placeHolderStyle
                }
            ]
        },
        {
        	id:\'business\',
            name:\'商务洽谈\',
            type:\'pie\',
            clockWise:false,
            radius : [100, 125],
            itemStyle : dataStyle,
            data:[
                {
                    value:0, 
                    name:''
                },
                {
                    value:0,
                    name:\'invisible\',
                    itemStyle : placeHolderStyle
                }
            ]
        },
        {
        	id:\'subscribe\',
            name:\'合同确认\',
            type:\'pie\',
            clockWise:false,
            radius : [75, 100],
            itemStyle : dataStyle,
            data:[
                {
                    value:0, 
                    name:''
                },
                {
                    value:0,
                    name:\'invisible\',
                    itemStyle : placeHolderStyle
                }
            ]
        },
        {
        	id:\'complete\',
            name:\'合同完成\',
            type:\'pie\',
            clockWise:false,
            radius : [50, 75],
            itemStyle : dataStyle,
            data:[
                {
                    value:0, 
                    name:''
                },
                {
                    value:0,
                    name:\'invisible\',
                    itemStyle : placeHolderStyle
                }
            ]
        }
    ]
}');

INSERT INTO `demo_json_template` (`id`, `create_by_id`, `create_date`, `status`, `update_by_id`, `update_date`, `template_key`, `template_value`) VALUES (2, 1, '2016-04-22', 1, 1, '2016-04-22', 'month', '{
    tooltip : {
        trigger: \'axis\'
    },
    legend: {
        data:[\'购买意向\',\'商务洽谈\',\'合同确认\',\'合同完成\']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: false},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: [\'line\', \'bar\', \'stack\', \'tiled\']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : \'category\',
            boundaryGap : false,
            data : [\'一月\',\'二月\',\'三月\',\'四月\',\'五月\',\'六月\']
        }
    ],
    yAxis : [
        {
            type : \'value\'
        }
    ],
    series : [
        {
        	id:\'purpose\',
            name:\'购买意向\',
            type:\'line\',
            stack: \'总量\',
            itemStyle: {normal: {areaStyle: {type: \'default\'}}},
            data:[]
        },
        {
        	id:\'business\',
            name:\'商务洽谈\',
            type:\'line\',
            stack: \'总量\',
            itemStyle: {normal: {areaStyle: {type: \'default\'}}},
            data:[]
        },
        {
        	id:\'subscribe\',
            name:\'合同确认\',
            type:\'line\',
            stack: \'总量\',
            itemStyle: {normal: {areaStyle: {type: \'default\'}}},
            data:[]
        },
        {
        	id:\'complete\',
            name:\'合同完成\',
            type:\'line\',
            stack: \'总量\',
            itemStyle: {normal: {areaStyle: {type: \'default\'}}},
            data:[]
        }
    ]
}');
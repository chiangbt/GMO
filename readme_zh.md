# GMO相关技术点

## 1、微服务项目的创建

1、从Intellij中新建一个SpringBoot项目。将其余文件都删除，仅留下pom文件。

2、新建module项目，类型选择maven-archetype-quickstart。

3、将模块项目的<parent/>设置为根目录的pom

## 2、初始化数据

1、执行sql文件，初始化数据库；

2、使用Mybatis plus进行ORM操作。注意修改application.yml中的`type-aliases-package`

```javascript
var code=ke.response.data.code;
if(code==200){
    //判断,如果服务端响应code是8200才执行操作
    //获取token
    var token=ke.response.data.data.token;
    //1、如何参数是Header，则设置当前逻辑分组下的全局Header
    ke.global.setHeader("Authorization", "Bearer " + token);

}
```

## 3、地理函数

计算距离，单位是m的方法

```javascript
-- 921.37629155
select ST_Distance(ST_GeographyFromText('SRID=4326;POINT(114.017299 22.537126)'), 
					ST_GeographyFromText('SRID=4326;POINT(114.025919 22.534866)')
					);
-- 921.37629155
SELECT ST_Distance(ST_GeomFromText('POINT(114.017299 22.537126)',4326):: geography,
			ST_GeomFromText('POINT(114.025919 22.534866)', 4326):: geography
		);

-- 920.28519
SELECT ST_DistanceSphere(ST_GeomFromText('POINT(114.017299 22.537126)',4326),
			ST_GeomFromText('POINT(114.025919 22.534866)', 4326)
		);
		
-- unit=m   26986  马萨诸塞州 投影平面坐标系 单位m  result=972.989337453172
SELECT ST_Distance(
			ST_Transform(ST_GeomFromText('POINT(114.017299 22.537126)',4326 ),26986),
			ST_Transform(ST_GeomFromText('POINT(114.025919 22.534866)', 4326 ),26986)
		);
```

计算距离，单位是度

```javascript
# unit=degrees   result=0.00891134108875483
SELECT ST_Distance(ST_GeomFromText('POINT(114.017299 22.537126)',4326),
			ST_GeomFromText('POINT(114.025919 22.534866)', 4326)
		);
```
关于单位是m的, 前三种的计算结果是正确的。最后一种坐标转换的计算方法。

使用函数ST_DWithin 可以计算两个点之间的距离是否在5公里内。

```javascript
-- 查找给定经纬度5km以内的点
SELECT
	uuid,
	longitude,
	latitude,
	ST_DistanceSphere (
		geom_point,
	ST_GeomFromText ( 'POINT(121.248642 31.380415)', 4326 )) distance 
FROM
	s_poi_gaode 
WHERE
	ST_DWithin ( geom_point :: geography, ST_GeomFromText ( 'POINT(121.248642 31.380415)', 4326 ) :: geography, 5000 ) IS TRUE 
	order by distance desc
	LIMIT 30;
```
最近的10个点

```
SELECT * FROM s_poi_gaode_gps ORDER BY geom_point <-> ST_GeomFromText ( 'POINT(121.248642 31.380415)', 4326 )  LIMIT 10;
```
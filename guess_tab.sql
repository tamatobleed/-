/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.29 : Database - guess
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`guess` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `guess`;

/*Table structure for table `guess_tab` */

DROP TABLE IF EXISTS `guess_tab`;

CREATE TABLE `guess_tab` (
  `id` int NOT NULL COMMENT '主键',
  `question` varchar(128) NOT NULL COMMENT '问题',
  `answer` varchar(128) NOT NULL COMMENT '答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `guess_tab` */

insert  into `guess_tab`(`id`,`question`,`answer`) values (1,'不是狐，不是狗，前面架铡刀，后面拖扫帚','狼'),(2,'尾巴一根钉，秋水两粒豆，有翅没有毛，有脚不会走','蜻蜓'),(3,'身体花绿，走路弯曲弄笑的谜语，洞里进出，启齿恶毒','蛇'),(4,'天空捍卫小飞军，井然排列人字形，冬天朝南春回北，规规矩矩纪律明','大雁'),(5,'白日草里住，晚上空中游，金光闪闪动，见尾不见头','萤火虫'),(6,'纵横沙漠中，展翅飞不起，快走犹如飞，是鸟中第一','鸵鸟'),(7,'远看像只猫，近看像只鸟，夜晚啄老鼠，白日睡大觉','猫头鹰'),(8,'小时穿黑衣，大时换白袍，造一间小屋，在里面睡觉','蚕'),(9,'角黍头，梅花脚，屁股挂把批示刀，坐着反比立着高','狗'),(10,'有位小姑娘，身穿黄衣裳。谁要欺负她，她就戳一枪','黄蜂'),(11,'上肢下肢都是手，有时爬来有时走，走时很象一个人，爬时又象一条狗','猴子'),(12,'瞳孔遇光能大小，唱起歌来妙妙妙，夜半巡逻不需灯，四处畅行难不倒','猫'),(13,'坐也是行，立也是行，行也是行，卧也是行','鱼'),(14,'不管翻地或打洞，生成爱动处处钻，松松土来施竹子谜语点肥，人人称我为地龙','蚯蚓'),(15,'年纪并不大，胡子一大把，不论遇见谁，总爱喊妈妈','山羊'),(16,'小小一条龙，髯毛硬似粽，活着没有血，死了浑身红','虾'),(17,'嘴象小铲子，脚象小扇子，走路摆布摆，不是摆架子','鸭子'),(18,'尖嘴尖耳尖下巴，细腿细角细小腰，素性奸刁多猜疑，尾后拖着一丛毛','狐狸'),(19,'小小飞贼，兵器是针，抽别人血，养自我身','蚊子'),(20,'任劳又任怨，田里活猛干，生产万顿粮，只把草当饭','牛');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

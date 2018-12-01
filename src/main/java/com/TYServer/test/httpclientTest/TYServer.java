package com.TYServer.test.httpclientTest;

import com.TYServer.util.httpclientUtils.HttpClientDriverChange;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

public class TYServer {
    private final static Logger logger = LoggerFactory.getLogger(TYServer.class);
    @Test
    public void error(){
        String url = "http://localhost:8080/errorTrace.do";
        String body = "{\"number\" :\"1\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void getListAllDubbo(){
        String url = "http://10.128.1.12:8080/rest_interface/getEmployeeUsedubbo.do";
        String body = "{\"id\" :\"1\",\"name\" : \"\",\"sex\" : \"\",\"age\":\"\",\"address\" : \"\",\"birthday\" : \"\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        long start = System.currentTimeMillis();
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info((start - end) + "");
        logger.info("=====" + list);
    }

    @Test
    public void getListAll(){
        String url = "http://192.168.47.128:8080/agent3.0/selectEmployeeUseRedis/12";
        String body = "{\"id\" :\"1\" ,\"name\" : \"\",\"sex\" : \"\",\"age\":\"\",\"address\" : \"\",\"birthday\" : \"\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void selectRestInterface(){
        String url = "http://10.128.1.12:8080/rest_interface/selectResultByUrlBody.do";
        String body = "{\"url\":\"http://10.128.1.13:8080/TYServer/selectEmployee_CPU.do?pageIndex=1\",\"path\":\"/data/selectBody.txt\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void insertRestInterface(){
        String url = "http://10.128.1.12:8080/rest_interface/insertTYServer.do";
        String body = "{\"url\":\"http://10.128.1.13:8080/TYServer/insertEmployee.do?birthday=2017-08-02\",\"path\":\"E:\\\\insertBody.txt\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void deleteRestInterface(){
        String url = "http://localhost:8081/deleteTYServer.do";
        String body = "{\"url\":\"http://localhost:8080/deleteEmployeeById.do\",\"body\":\"{\\\"id\\\":\\\"2\\\"}\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void updateRestInterface(){
        String url = "http://localhost:8081/updateTYServer.do";
        String body = "{\"url\":\"http://localhost:8080/updateEmployeeById.do\",\"path\":\"E:\\\\updateBody.txt\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void acTest(){
        String url = "http://localhost:8080/init?license=095U9877&version=8";
        String body = "{\"environment\":{\"container\":{\"logical_processors\":4,\"hostname\":\"jialianqing\",\"total_ram_mib\":16264},\"system\":{\"sun.desktop\":\"windows\",\"awt.toolkit\":\"sun.awt.windows.WToolkit\",\"file.encoding.pkg\":\"sun.io\",\"java.specification.version\":\"1.8\",\"sun.cpu.isalist\":\"amd64\",\"sun.jnu.encoding\":\"GBK\",\"com.sun.management.jmxremote.authenticate\":\"false\",\"java.class.path\":\"D:\\\\apache-tomcat-7.0.72\\\\bin\\\\bootstrap.jar;D:\\\\apache-tomcat-7.0.72\\\\bin\\\\tomcat-juli.jar;D:/tingyun_agent/tingyunagent3/tingyun-agent-java.jar\",\"java.vm.vendor\":\"Oracle Corporation\",\"sun.arch.data.model\":\"64\",\"user.variant\":\"\",\"java.vendor.url\":\"http://java.oracle.com/\",\"user.timezone\":\"Asia/Shanghai\",\"os.name\":\"Windows 7\",\"java.vm.specification.version\":\"1.8\",\"tingyun.accracy\":\"true\",\"user.country\":\"CN\",\"sun.java.launcher\":\"SUN_STANDARD\",\"sun.boot.library.path\":\"C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\bin\",\"com.sun.management.jmxremote.ssl\":\"false\",\"sun.java.command\":\"org.apache.catalina.startup.Bootstrap start\",\"com.sun.management.jmxremote\":\"\",\"sun.cpu.endian\":\"little\",\"user.home\":\"C:\\\\Users\\\\Administrator.EIT-20160927ELP\",\"user.language\":\"zh\",\"java.specification.vendor\":\"Oracle Corporation\",\"java.home\":\"C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\",\"file.separator\":\"\\\\\",\"line.separator\":\"\\r\\n\",\"java.vm.specification.vendor\":\"Oracle Corporation\",\"java.specification.name\":\"Java Platform API Specification\",\"java.awt.graphicsenv\":\"sun.awt.Win32GraphicsEnvironment\",\"sun.boot.class.path\":\"C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\lib\\\\resources.jar;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\lib\\\\rt.jar;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\lib\\\\sunrsasign.jar;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\lib\\\\jsse.jar;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\lib\\\\jce.jar;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\lib\\\\charsets.jar;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\lib\\\\jfr.jar;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\classes\",\"jdk.tls.ephemeralDHKeySize\":\"2048\",\"user.script\":\"\",\"java.util.logging.config.file\":\"C:\\\\Users\\\\Administrator.EIT-20160927ELP\\\\.IntelliJIdea2017.2\\\\system\\\\tomcat\\\\Unnamed_DB_08_3\\\\conf\\\\logging.properties\",\"sun.management.compiler\":\"HotSpot 64-Bit Tiered Compilers\",\"java.runtime.version\":\"1.8.0_66-b17\",\"user.name\":\"jialianqing\",\"path.separator\":\";\",\"os.version\":\"6.1\",\"java.endorsed.dirs\":\"D:\\\\apache-tomcat-7.0.72\\\\endorsed\",\"java.runtime.name\":\"Java(TM) SE Runtime Environment\",\"file.encoding\":\"UTF-8\",\"tingyun.classout\":\"true\",\"java.vm.name\":\"Java HotSpot(TM) 64-Bit Server VM\",\"java.vendor.url.bug\":\"http://bugreport.sun.com/bugreport/\",\"java.io.tmpdir\":\"D:\\\\apache-tomcat-7.0.72\\\\temp\",\"catalina.home\":\"D:\\\\apache-tomcat-7.0.72\",\"com.sun.management.jmxremote.port\":\"21099\",\"tingyun.debug\":\"true\",\"java.version\":\"1.8.0_66\",\"user.dir\":\"D:\\\\apache-tomcat-7.0.72\\\\bin\",\"os.arch\":\"amd64\",\"java.vm.specification.name\":\"Java Virtual Machine Specification\",\"java.awt.printerjob\":\"sun.awt.windows.WPrinterJob\",\"sun.os.patch.level\":\"Service Pack 1\",\"catalina.base\":\"C:\\\\Users\\\\Administrator.EIT-20160927ELP\\\\.IntelliJIdea2017.2\\\\system\\\\tomcat\\\\Unnamed_DB_08_3\",\"tingyun.log.stdout\":\"true\",\"java.util.logging.manager\":\"org.apache.juli.ClassLoaderLogManager\",\"java.library.path\":\"C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\bin;C:\\\\Windows\\\\Sun\\\\Java\\\\bin;C:\\\\Windows\\\\system32;C:\\\\Windows;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\bin;C:\\\\ProgramData\\\\Oracle\\\\Java\\\\javapath;C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\bin;C:\\\\Windows\\\\system32;C:\\\\Windows;C:\\\\Windows\\\\System32\\\\Wbem;C:\\\\Windows\\\\System32\\\\WindowsPowerShell\\\\v1.0\\\\;D:\\\\开发工具等\\\\mysql\\\\mysql-5.6.32-winx64\\\\bin;%RED;S_HOME%;D:\\\\maven\\\\apache-maven-3.3.9\\\\bin;C:\\\\Program Files\\\\erl8.1\\\\bin;C:\\\\Program Files\\\\RabbitMQ Server\\\\rabbitmq_server-3.6.6\\\\sbin;C:\\\\Program Files\\\\TortoiseSVN\\\\bin;D:\\\\Program Files (x86)\\\\scala\\\\bin;D:\\\\DB\\\\db-derby-10.7.1.1-bin\\\\bin;E:\\\\RocketMQ\\\\rocketmq-3.5.8\\\\bin;D:\\\\tools\\\\sbt\\\\bin;;.\",\"java.vm.info\":\"mixed mode\",\"java.vendor\":\"Oracle Corporation\",\"java.vm.version\":\"25.66-b17\",\"java.rmi.server.hostname\":\"127.0.0.1\",\"java.ext.dirs\":\"C:\\\\Program Files\\\\Java\\\\jdk1.8.0_66\\\\jre\\\\lib\\\\ext;C:\\\\Windows\\\\Sun\\\\Java\\\\lib\\\\ext\",\"sun.io.unicode.encoding\":\"UnicodeLittle\",\"java.class.version\":\"52.0\"},\"meta\":{\"Built-At\":\"2018-05-16 18:05:06\",\"pid\":5632,\"UUID\":\"java:test_jia:28080\"},\"env\":{\"Heap initial (MB)\":\"256.0\",\"OS\":\"Windows 7\",\"Dispatcher Version\":\"7.0.72\",\"Heap Max (MB)\":\"3616.0\",\"Log path\":\"D:\\\\tingyun_agent\\\\tingyunagent3\\\\logs\\\\tingyun_agent.log\",\"JVM arguments\":\"-Dfile.encoding=UTF-8\\n-javaagent:D:/tingyun_agent/tingyunagent3/tingyun-agent-java.jar\\n-Dtingyun.debug=true\\n-Dtingyun.accracy=true\\n-Dtingyun.classout=true\\n-Dtingyun.log.stdout=true\\n-Dcom.sun.management.jmxremote=\\n-Dcom.sun.management.jmxremote.port=21099\\n-Dcom.sun.management.jmxremote.ssl=false\\n-Dcom.sun.management.jmxremote.authenticate=false\\n-Djava.rmi.server.hostname=127.0.0.1\\n-Djdk.tls.ephemeralDHKeySize=2048\\n-Djava.util.logging.config.file=C:\\\\Users\\\\Administrator.EIT-20160927ELP\\\\.IntelliJIdea2017.2\\\\system\\\\tomcat\\\\Unnamed_DB_08_3\\\\conf\\\\logging.properties\\n-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager\\n-Djava.endorsed.dirs=D:\\\\apache-tomcat-7.0.72\\\\endorsed\\n-Dcatalina.base=C:\\\\Users\\\\Administrator.EIT-20160927ELP\\\\.IntelliJIdea2017.2\\\\system\\\\tomcat\\\\Unnamed_DB_08_3\\n-Dcatalina.home=D:\\\\apache-tomcat-7.0.72\\n-Djava.io.tmpdir=D:\\\\apache-tomcat-7.0.72\\\\temp\\n\",\"Server port\":28080,\"OS version\":\"6.1\",\"Arch\":\"amd64\",\"Logical Processors\":\"4\",\"Java VM\":\"Java HotSpot(TM) 64-Bit Server VM\",\"Dispatcher\":\"Apache Tomcat\",\"Java VM version\":\"25.66-b17\",\"Java vendor\":\"Oracle Corporation\",\"Instance Name\":\"fengzhiyin-mbp-instance\",\"Java version\":\"1.8.0_66\",\"Framework\":\"java\"},\"config\":{\"hotspot.enabled\":true,\"trim_stats\":false,\"deadlock_detector.enabled\":true,\"ssl\":false,\"class_transformer.tingyun-spring-aop-plugin.enabled\":true,\"inspect.spring_annotations.enabled\":true,\"async_timeout\":10,\"host\":\"192.168.1.46\",\"audit_mode\":true,\"circuitbreaker.heap_threshold\":98,\"hotspot.action.intervel\":120000,\"class_transformer.ConcurrentCallable.enabled\":false,\"???#\":\"?\\u0090ˉ?\\u0094¨?o\\u0094?\\u0094¨?\\u008E￠é\\u0092\\u0088\",\"segment_timeout\":30,\"action_tracer.top_n\":1000,\"circuitbreaker.gc_cpu_threshold\":1,\"agent_log_level\":\"debug\",\"agent_log_file_size\":102400,\"instance.name\":\"fengzhiyin-mbp-instance\",\"action_timeout\":60,\"license_key\":\"999-999-999\",\"app_name\":\"test_jia\",\"class_transformer.quartz_job.enabled\":false,\"agent_log_file_count\":10,\"port\":41010,\"class_transformer.quartz_system.enabled\":false,\"transaction_tracer.enabled\":true,\"user_trace.enabled\":true}},\"port\":28080,\"instanceName\":\"fengzhiyin-mbp-instance\",\"appName\":\"test_jia\",\"host\":\"jialianqing\",\"agentVersion\":\"3.0.0\",\"language\":\"java\",\"firstRun\":true}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/octet-stream");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            long start = System.currentTimeMillis();
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
            long end = System.currentTimeMillis();
            logger.info("接口相应时间为：" + (end - start) + "");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }

}

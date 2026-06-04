package com.vcpf.jee202405110415.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.vcpf.jee202405110415.entity.BaseEntity;

import java.util.*;

/**
 * MP的代码生成器
 *      核心配置：配置数据源，配置包，配置参数，配置使用策略等
 *      生成模板文件
 *      生成库对应的mapper接口和mapper接口配置类
 *
 * 生成器的使用方法
 *      1. 直接运行main方法
 *      2. 按提示，输入库里已经存在的表名，如user
 *      3. 回车后，生成相应的代码，如
 *			源码文件
 *          controller
 *          entity
 *          mapper
 *          service
 *			配置文件
 *          mapper/...*.xml
 *      4. 将代码置于项目中---如果路径配置正确，会直接生成到项目中
 *      5. 然后就可以使用，进行测试
 *      6. 在IDEA下，建议使用相应的插件进行可视化操作
 *
 * @author fhzheng
 * @blog https://fhzheng.blog.csdn.net
 * @since 2025/3/15
 */
public class MysqlGenerator {

    // 每次运行前，仔细检查这里的数据库坐标
    public static final String DATABASE_URL = "jdbc:mysql://192.168.126.128:3306/db_mybatisplus?characterEncoding=utf8&useSSL" +
            "=false&serverTimezone=Asia/Shanghai";
    public static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "123456";
    // 仔细检查对应的项目名和包名
    public static final String OUT_PUT_PATH = "/jee-2024051104-15/src/main/java";
    public static final String TEMPLATES_MAPPER_XML_PATH = "/templates/mapper.xml.ftl";
    public static final String XML_PATH = "/jee-2024051104-15/src/main/resources/mapper/";
    public static final String XML_POSTFIX = "Mapper";
    // 这一部分的数据相对固定
    public static final String AUTHOR = "vcpf";
    public static final String PARENT_PACKAGE = "com.vcpf.jee202405110415";
    public static final String[] SUPER_ENTITY_COLUMNS = {"id", "create_time", "update_time", "creator", "modifier"};

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + OUT_PUT_PATH);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setBaseResultMap(true);
        gc.setActiveRecord(true);
        gc.setBaseColumnList(true);
        gc.setSwagger2(true);
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DATABASE_URL);
        dsc.setDriverName(DATABASE_DRIVER);
        dsc.setUsername(DATABASE_USERNAME);
        dsc.setPassword(DATABASE_PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 不设置模块名的话 Controller 请求路径会多一个 “/”
        pc.setModuleName(null);
        pc.setParent(PARENT_PACKAGE);
        mpg.setPackageInfo(pc);

        // 自定义配置 可以设置自定义参数，然后在模板中使用
        InjectionConfig cfg = new InjectionConfig() {
            // 后续章节会用到
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("parent", PARENT_PACKAGE);
                setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(TEMPLATES_MAPPER_XML_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + XML_PATH + tableInfo.getEntityName() + XML_POSTFIX + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        strategy.setEntityLombokModel(true);
        strategy.setChainModel(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));

        strategy.setControllerMappingHyphenStyle(true);
        strategy.setRestControllerStyle(true);

        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
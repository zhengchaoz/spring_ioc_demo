package cn.jt.template;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 用默认的模板生成引擎Velocity生成
 * Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码
 *
 * @user 郑超
 * @date 2021/4/29
 */
public class CodeGeneratorUtils {

    // 当前项目的带盘符的绝对路径
    private static final String projectPath = System.getProperty("user.dir");
    // 模块名
    private static String moduleName = null;

    public static String setModuleName(String tip) {
        moduleName = scanner("模块名");
        return moduleName;
    }

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
     * 全局配置
     *
     * @return GlobalConfig
     */
    public static GlobalConfig gc() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/springboot_demo_02_plus/src/main/java");
        gc.setAuthor("郑超");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        return gc;
    }

    /**
     * 数据源配置
     *
     * @return DataSourceConfig
     */
    public static DataSourceConfig dsc() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mariadb://localhost:3309/jt?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true");
        // dsc.setSchemaName("public");
        dsc.setDriverName("org.mariadb.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        return dsc;
    }

    /**
     * 包配置
     *
     * @return PackageConfig
     */
    public static PackageConfig pc() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(setModuleName("模块名"));
        pc.setParent("cn.jt");
        return pc;
    }

    /**
     * 自定义配置
     * @param templatePath 模板引擎
     * @return InjectionConfig
     */
    public static InjectionConfig cfg(String templatePath) {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
//        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/springboot_demo_02_plus/src/main/resources/mappers/" + moduleName.replace(".", "/")
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 配置模板
     * @return TemplateConfig
     */
    public static TemplateConfig tc() {
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        return templateConfig;
    }

    /**
     * 策略配置
     * @return StrategyConfig
     */
    public static StrategyConfig sc() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(moduleName + "_");
        return strategy;
    }

    /**
     *  代码生成
     *
     * @param templatePath 如果模板引擎是 freemarker "/templates/mapper.xml.ftl";
         *                 如果模板引擎是 velocity    "/templates/mapper.xml.vm";
     * @param templateEngine 设置freemarker引擎 new FreemarkerTemplateEngine()
     *                       设置beetl引擎      new BeetlTemplateEngine()
     */
    public static void codeGenerator(String templatePath, AbstractTemplateEngine templateEngine) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        mpg.setGlobalConfig(gc());
        // 数据源配置
        mpg.setDataSource(dsc());
        // 包配置
        mpg.setPackageInfo(pc());
        // 自定义配置
        mpg.setCfg(cfg(templatePath));
        // 配置模板
        mpg.setTemplate(tc());
        // 策略配置
        mpg.setStrategy(sc());
        mpg.setTemplateEngine(templateEngine);
        mpg.execute();
    }
}

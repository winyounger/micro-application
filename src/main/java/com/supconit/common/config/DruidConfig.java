package com.supconit.common.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: chenxuankai
 * @Date: 2019年07月18日 17:28:51
 * @Description:
 * @Version: 1.0.0
 */
@Configuration
public class DruidConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @NotNull
    @Value("${spring.datasource.dynamic.datasource.master.driver-class-name}")
    private String driverClass;

    @NotNull
    @Value("${spring.datasource.dynamic.datasource.master.url}")
    private String url;

    @NotNull
    @Value("${spring.datasource.dynamic.datasource.master.username}")
    private String username;

    @NotNull
    @Value("${spring.datasource.dynamic.datasource.master.password}")
    private String password;

    @Value("${spring.datasource.dynamic.datasource.master.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.dynamic.datasource.master.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.dynamic.datasource.master.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.dynamic.datasource.master.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.dynamic.datasource.master.slowSqlMillis}")
    private long slowSqlMillis;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url + "&allowMultiQueries=true");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);

        List<Filter> filters = new ArrayList<>();
        StatFilter filter = new StatFilter();
        //慢sql，默认3s
        filter.setSlowSqlMillis(slowSqlMillis);
        //增加sql统计的merge功能,默认是false
        filter.setMergeSql(true);
        //慢SQL日志记录
        filter.setLogSlowSql(true);
        filters.add(filter);
        dataSource.setProxyFilters(filters);

        return dataSource;
    }

//    /**
//     * 配置事务
//     * @param dataSource
//     * @return
//     */
//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    /**
//     * 配置分页插件
//     * @return
//     */
//    @Bean
//    public PageInterceptor pageHelper(){
//        PageInterceptor pageHelper = new PageInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum", "true");
//        properties.setProperty("rowBoundsWithCount", "true");
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }

    //    配置servlet
    @Bean
    public ServletRegistrationBean myservlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<String,String>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");// 如果不写就是默认允许所有
        initParams.put("deny","127.0.0.1");
        //是否能够重置数据.
        bean.addInitParameter("resetEnable","false");
        bean.setInitParameters(initParams);
        return bean;
    }

//    /**
//     * 配置sqlSessionFactory
//     * @param dataSource
//     * @return
//     * @throws Exception
//     */
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, PageInterceptor pageHelper){
//        SqlSessionFactoryBean sqlSessionFactory =  new SqlSessionFactoryBean();
//        try {
//            sqlSessionFactory.setDataSource(dataSource);
//            sqlSessionFactory.setTypeAliasesPackage(env.getProperty("mybatis.aliasesPackage"));
//            sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
//            sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(env.getProperty("mybatis.config-location")));
//            //设置分页插件
//            sqlSessionFactory.setPlugins(new Interceptor[]{pageHelper,new CatMybatisInterceptor(AesUtil.decrypt(url,aesPassword))});
//            sqlSessionFactory.setVfs(SpringBootVFS.class);
//        } catch (IOException e) {
//            logger.error("sqlSessionFactory,e={}",e);
//        }
//        return sqlSessionFactory;
//
//    }

    //    配置filter
    @Bean
    public FilterRegistrationBean myfilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.addUrlPatterns("/*");
        return bean;
    }

}

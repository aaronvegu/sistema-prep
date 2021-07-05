package com.aaronvegu.prep.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.aaronvegu.prep.dao.CandidaturaDAO;
import com.aaronvegu.prep.dao.CandidaturaDAOImpl;
import com.aaronvegu.prep.dao.CasillaDAO;
import com.aaronvegu.prep.dao.CasillaDAOImpl;
import com.aaronvegu.prep.dao.ResultadoDAO;
import com.aaronvegu.prep.dao.ResultadoDAOImpl;
import com.aaronvegu.prep.dao.UsuarioDAO;
import com.aaronvegu.prep.dao.UsuarioDAOImpl;
import com.aaronvegu.prep.dao.VotoDAO;
import com.aaronvegu.prep.dao.VotoDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.aaronvegu.prep")
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sistema_prep_d");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	@Bean
	public ViewResolver PDFResolver() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setOrder(1);
		resolver.setBasename("pdf-view");
		
		return resolver;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setOrder(2);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean
	public CasillaDAO getCasillaDAO() {
		return new CasillaDAOImpl(getDataSource());
	}
	
	@Bean
	public CandidaturaDAO getCandidaturaDAO() {
		return new CandidaturaDAOImpl(getDataSource());
	}
	
	@Bean
	public VotoDAO getVotoDAO() {
		return new VotoDAOImpl(getDataSource());
	}
	
	@Bean
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl(getDataSource());
	}
	
	@Bean
	public ResultadoDAO getResultadoDAO() {
		return new ResultadoDAOImpl(getDataSource());
	}
}

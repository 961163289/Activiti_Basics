package com.gec.demotest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class DemoTest1 {

	public static void main(String[] args) {

		// 流程引擎配置对象

		// 得到流程引擎配置对象
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();

		// 配置数据库的四个基本属性
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activiti_demo");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("root");

		/*
		 * 如果不存在表，就创建表，如果存在，就直接使用！ 
		 * public static final String DB_SCHEMA_UPDATE_FALSE = "false";
		 * 
		 * 如果不存在表，就直接抛出异常
		 * public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";
		 * 
		 * 每次都要先删除表，再去创建 
		 * public static final String DB_SCHEMA_UPDATE_TRUE = "true";
		 */

		// 设置建表策略
		processEngineConfiguration.setDatabaseSchemaUpdate("true");

		// 流程引擎对象
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();

		System.out.println(processEngine);

	}

}

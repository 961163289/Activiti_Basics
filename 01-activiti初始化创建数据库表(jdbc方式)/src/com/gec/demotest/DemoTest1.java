package com.gec.demotest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class DemoTest1 {

	public static void main(String[] args) {

		// �����������ö���

		// �õ������������ö���
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();

		// �������ݿ���ĸ���������
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activiti_demo");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("root");

		/*
		 * ��������ڱ��ʹ�����������ڣ���ֱ��ʹ�ã� 
		 * public static final String DB_SCHEMA_UPDATE_FALSE = "false";
		 * 
		 * ��������ڱ���ֱ���׳��쳣
		 * public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";
		 * 
		 * ÿ�ζ�Ҫ��ɾ������ȥ���� 
		 * public static final String DB_SCHEMA_UPDATE_TRUE = "true";
		 */

		// ���ý������
		processEngineConfiguration.setDatabaseSchemaUpdate("true");

		// �����������
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();

		System.out.println(processEngine);

	}

}

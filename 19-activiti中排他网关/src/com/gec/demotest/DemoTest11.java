package com.gec.demotest;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.Validate;
import org.h2.util.New;
import org.junit.Test;

public class DemoTest11 {
	
	// �����������
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	//1.���̲���
	@Test
	public void fun1() {
		
		//С��(���ַ���)
		//���صõ��������
//		InputStream in = new FileInputStream(file);
		
		//ͨ�����䷽ʽ��һ���ļ�תΪinputstream
//		InputStream in = this.getClass().getClassLoader().getResourceAsStream("digram/helloworldProcess.zip");
//		ZipInputStream zipInputStream = new ZipInputStream(in);
		
		
		Deployment deployment = processEngine.getRepositoryService()
		.createDeployment()
		.name("��������˱��ʽ��ʽ����")
		.addClasspathResource("digram/MyProcessTest1.bpmn")
		.addClasspathResource("digram/MyProcessTest1.png")
		.deploy();
		
		System.out.println("����id:"+deployment.getId());
		System.out.println("����name:"+deployment.getName());
		
	}
	
	
	//2.��������(�ӿ�ʼ���򵽵�һ������������)
	@Test
	public void fun2(){
		String processDefinitionKey = "myProcessTest1";
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", "С��");
		
		ProcessInstance processInstance = processEngine.getRuntimeService()
//		.startProcessInstanceByKey(processDefinitionKey);
		.startProcessInstanceByKey(processDefinitionKey,map);		
		System.out.println("�������̳ɹ�...");
	}
	
	
	
	//3.������� complete(String taskId)2303
	@Test
	public void fun4(){
		String taskId = "2303";
//		Map<String, Object> map = new HashMap<String,Object>();
//		map.put("message", "ͬ��");
		this.processEngine.getTaskService()
		.complete(taskId);
//		.complete(taskId, map);
		System.out.println("�����Ѿ����...");
	}
	
	
	//5.��ȡ�����̱�����ֵ
	@Test
	public void getValiableTest() {
		String taskId="2002";
		Object value = this.processEngine
		.getTaskService()
		.getVariable(taskId, "���");
		System.out.println("��ȡ�������̱�����ֵ:"+value);
		
		Object value1 = this.processEngine
		.getTaskService()
		.getVariable(taskId, "����");
		System.out.println("��ȡ�������̱�����ֵ:"+value1);
	}
	
	
}

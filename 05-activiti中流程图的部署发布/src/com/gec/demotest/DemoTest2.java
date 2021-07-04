package com.gec.demotest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

public class DemoTest2 {
	
	
	
	//1.���̲���
	@Test
	public void fun1() {
		// �����������
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
		//С��(���ַ���)
		//���صõ��������
		Deployment deployment = processEngine.getRepositoryService()
		//�����������		
		.createDeployment()
		//��������
		.name("��һ�����̲������")
		//����·���¼��������ļ�
		.addClasspathResource("digram/HelloWorld.bpmn")
		.addClasspathResource("digram/HelloWorld.png")
		//���ò��𷽷�
		.deploy();
		
		System.out.println("����id:"+deployment.getId());     //1
		System.out.println("����name:"+deployment.getName()); //��һ�����̲������
		
		
	}
}
